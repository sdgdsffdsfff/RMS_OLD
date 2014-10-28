package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.EducationalRecordAward;
import com.cqupt.mis.rms.model.EducationalReformRecord;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找教改结题信息的Service接口
 * @author Bern
 *
 */
public interface EducationalReformRecordInfoService {
	/**
	 * 根据学生获奖ID查找指定教改结题信息
	 * @param recordId
	 * @return
	 */
	public ModelInfo<EducationalReformRecord, EducationalRecordAward> findEducationalReformRecordInfoByAwardsId(String recordId);
	
	/**
	 * 根据用户集合查找与该用户群体相关的学生获奖信息。
	 * @param CQUPTUsers
	 * @return
	 */
	public List<ModelInfo<EducationalReformRecord, EducationalRecordAward>> findAllEducationalReformRecordInfo(List<CQUPTUser> CQUPTUsers);
		
	/**
	 * 从指定EducationalReformInfo集合中筛检出符合条件的EducationalReformRecordInfo集合，筛选字段为字符串类型
	 * @param educationalReformInfosRecord 要进行筛选的集合
	 * @param factorName	筛选的字符串名
	 * @param factorValue	筛选的值
	 * @return	符合要求的的筛选结果
	 */
	public List<ModelInfo<EducationalReformRecord, EducationalRecordAward>> searchEducationalReformRecordInfoByStringFactor(List<ModelInfo<EducationalReformRecord, EducationalRecordAward>> educationalReformInfosRecord,String factorName,String factorValue);

}
