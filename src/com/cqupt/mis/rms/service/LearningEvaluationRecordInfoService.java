package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.LearningEvaluationRecord;
import com.cqupt.mis.rms.model.LearningRecordAward;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找学评教信息的Service接口
 * @author Bern
 *
 */
public interface LearningEvaluationRecordInfoService {
	/**
	 * 根据学评教ID查找指定学生获奖信息
	 * @param awardsId
	 * @return
	 */
	public ModelInfo<LearningEvaluationRecord, LearningRecordAward> findLearningEvaluationRecordInfoByAwardsId(String recordId);
	
	/**
	 * 根据用户集合查找与该用户群体相关的学评教信信息。
	 * @param CQUPTUsers
	 * @return
	 */
	public List<ModelInfo<LearningEvaluationRecord, LearningRecordAward>> findAllLearningEvaluationRecordInfo(List<CQUPTUser> CQUPTUsers);
		
	/**
	 * 从指定LearningEvaluationInfo集合中筛检出符合条件的LearningEvaluationRecordInfo集合，筛选字段为字符串类型
	 * @param learningEvaluationInfosRecord 要进行筛选的集合
	 * @param factorName	筛选的字符串名
	 * @param factorValue	筛选的值
	 * @return	符合要求的的筛选结果
	 */
	public List<ModelInfo<LearningEvaluationRecord, LearningRecordAward>> searchLearningEvaluationRecordInfoByStringFactor(List<ModelInfo<LearningEvaluationRecord, LearningRecordAward>> learningEvaluationInfosRecord,String factorName,String factorValue);

}
