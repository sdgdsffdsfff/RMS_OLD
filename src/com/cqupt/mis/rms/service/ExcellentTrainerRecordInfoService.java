package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ExcellentRecordAward;
import com.cqupt.mis.rms.model.ExcellentTrainerRecord;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找优秀培训师信息的Service接口
 * @author Bern
 *
 */
public interface ExcellentTrainerRecordInfoService {
	/**
	 * 根据优秀培训师信息的ID查找指定优秀培训师信息
	 * @param awardsId
	 * @return
	 */
	public ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward> findExcellentTrainerRecordInfoByAwardsId(String recordId);
	
	/**
	 * 根据用户集合查找与该用户群体相关的优秀培训师信息。
	 * @param CQUPTUsers
	 * @return
	 */
	public List<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>> findAllExcellentTrainerRecordInfo(List<CQUPTUser> CQUPTUsers);
		
	/**
	 * 从指定ExcellentTrainerInfo集合中筛检出符合条件的ExcellentTrainerRecordInfo集合，筛选字段为字符串类型
	 * @param excellentTrainerInfosRecord 要进行筛选的集合
	 * @param factorName	筛选的字符串名
	 * @param factorValue	筛选的值
	 * @return	符合要求的的筛选结果
	 */
	public List<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>> searchExcellentTrainerRecordInfoByStringFactor(List<ModelInfo<ExcellentTrainerRecord, ExcellentRecordAward>> excellentTrainerRecordInfos,String factorName,String factorValue);

}
