package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.OtherTeachingAwardsRecord;
import com.cqupt.mis.rms.model.OtherTeachingRecordAward;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找其他教学奖励信息的Service接口
 * @author Bern
 *
 */
public interface OtherTeachingAwardsRecordInfoService {
	/**
	 * 根据其他教学奖励ID查找指定其他教学奖励信息
	 * @param awardsId
	 * @return
	 */
	public ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward> findOtherTeachingAwardsRecordInfoByAwardsId(String awardsId);
	
	/**
	 * 根据用户集合查找与该用户群体相关的其他教学奖励信息。
	 * @param CQUPTUsers
	 * @return
	 */
	public List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> findAllOtherTeachingAwardsRecordInfo(List<CQUPTUser> CQUPTUsers);
		
	/**
	 * 从指定OtherTeachingAwardsInfo集合中筛检出符合条件的OtherTeachingAwardsRecordInfo集合，筛选字段为字符串类型
	 * @param otherTeachingAwardsInfosRecord 要进行筛选的集合
	 * @param factorName	筛选的字符串名
	 * @param factorValue	筛选的值
	 * @return	符合要求的的筛选结果
	 */
	public List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> searchOtherTeachingAwardsRecordInfoByStringFactor(List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> otherTeachingAwardsInfosRecord,String factorName,String factorValue);

}
