package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.QualityProjectRecord;
import com.cqupt.mis.rms.model.QualityRecordAward;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找质量工程信息的Service接口
 * @author Bern
 *
 */
public interface QualityProjectRecordInfoService {
	/**
	 * 根据质量工程ID查找指定质量工程信息
	 * @param awardsId
	 * @return
	 */
	public ModelInfo<QualityProjectRecord, QualityRecordAward> findQualityProjectRecordInfoByAwardsId(String recordId);
	
	/**
	 * 根据用户集合查找与该用户群体相关的质量工程信息。
	 * @param CQUPTUsers
	 * @return
	 */
	public List<ModelInfo<QualityProjectRecord, QualityRecordAward>> findAllQualityProjectRecordInfo(List<CQUPTUser> CQUPTUsers);
		
	/**
	 * 从指定QualityProjectInfo集合中筛检出符合条件的QualityProjectRecordInfo集合，筛选字段为字符串类型
	 * @param qualityProjectInfosRecord 要进行筛选的集合
	 * @param factorName	筛选的字符串名
	 * @param factorValue	筛选的值
	 * @return	符合要求的的筛选结果
	 */
	public List<ModelInfo<QualityProjectRecord, QualityRecordAward>> searchQualityProjectRecordInfoByStringFactor(List<ModelInfo<QualityProjectRecord, QualityRecordAward>> qualityProjectInfosRecord,String factorName,String factorValue);

}
