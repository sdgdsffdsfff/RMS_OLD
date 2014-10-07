package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.TeachingMaterialRecord;
import com.cqupt.mis.rms.model.TeachingRecordEditor;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找教材立项信息的Service接口
 * @author Bern
 *
 */
public interface TeachingMaterialRecordInfoService {
	/**
	 * 根据记录ID查找指定教材立项信息
	 * @param awardsId
	 * @return
	 */
	public ModelInfo<TeachingMaterialRecord, TeachingRecordEditor> findTeachingMaterialRecordInfoByAwardsId(String recordId);
	
	/**
	 * 根据用户集合查找与该用户群体相关的教材立项信息。
	 * @param CQUPTUsers
	 * @return
	 */
	public List<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>> findAllTeachingMaterialRecordInfo(List<CQUPTUser> CQUPTUsers);
		
	/**
	 * 从指定TeachingMaterialRecordInfo集合中筛检出符合条件的TeachingMaterialRecordInfo集合，筛选字段为字符串类型
	 * @param studentAwardsInfosRecord 要进行筛选的集合
	 * @param factorName	筛选的字符串名
	 * @param factorValue	筛选的值
	 * @return	符合要求的的筛选结果
	 */
	public List<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>> searchTeachingMaterialRecordInfoByStringFactor(List<ModelInfo<TeachingMaterialRecord, TeachingRecordEditor>> teachingMaterialRecordInfos,String factorName,String factorValue);

}
