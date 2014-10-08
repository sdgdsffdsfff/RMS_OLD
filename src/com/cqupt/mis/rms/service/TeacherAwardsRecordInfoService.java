package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachersAwardsRecord;
import com.cqupt.mis.rms.model.TeachersRecordAchievements;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找教学成果获奖信息的Service接口
 * @author Liu
 *
 */
public interface TeacherAwardsRecordInfoService {
	/**
	 * 根据教师获奖ID查找指定教学成果奖信息
	 * @param awardsId
	 * @return
	 */
	public ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements> findTeacherAwardsRecordInfoByAwardsId(String awardsId);
	
	/**
	 * 根据用户集合查找与该用户群体相关的教学成果奖信息。
	 * @param CQUPTUsers
	 * @return
	 */
	public List<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>> findAllTeacherAwardsRecordInfo(List<CQUPTUser> CQUPTUsers);
		
	/**
	 * 从指定TeacherAwardsInfo集合中筛检出符合条件的TeacherAwardsRecordInfo集合，筛选字段为字符串类型
	 * @param teacherAwardsInfosRecord 要进行筛选的集合
	 * @param factorName	筛选的字符串名
	 * @param factorValue	筛选的值
	 * @return	符合要求的的筛选结果
	 */
	public List<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>> searchTeacherAwardsRecordInfoByStringFactor(List<ModelInfo<TeachersAwardsRecord, TeachersRecordAchievements>> teacherAwardsRecordInfos,String factorName,String factorValue);
		
}
