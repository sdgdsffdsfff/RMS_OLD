package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.StudentAwardsRecord;
import com.cqupt.mis.rms.model.StudentRecordInstructor;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找学生获奖信息的Service接口
 * @author Bern
 *
 */
public interface StudentAwardsRecordInfoService {
	/**
	 * 根据学生获奖ID查找指定学生获奖信息
	 * @param awardsId
	 * @return
	 */
	public ModelInfo<StudentAwardsRecord, StudentRecordInstructor> findStudentAwardsRecordInfoByAwardsId(String awardsId);
	
	/**
	 * 根据用户集合查找与该用户群体相关的学生获奖信息。
	 * @param CQUPTUsers
	 * @return
	 */
	public List<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>> findAllStudentAwardsRecordInfo(List<CQUPTUser> CQUPTUsers);
		
	/**
	 * 从指定StudentAwardsInfo集合中筛检出符合条件的StudentAwardsRecordInfo集合，筛选字段为字符串类型
	 * @param studentAwardsInfosRecord 要进行筛选的集合
	 * @param factorName	筛选的字符串名
	 * @param factorValue	筛选的值
	 * @return	符合要求的的筛选结果
	 */
	public List<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>> searchStudentAwardsRecordInfoByStringFactor(List<ModelInfo<StudentAwardsRecord, StudentRecordInstructor>> studentAwardsRecordInfos,String factorName,String factorValue);
		
}
