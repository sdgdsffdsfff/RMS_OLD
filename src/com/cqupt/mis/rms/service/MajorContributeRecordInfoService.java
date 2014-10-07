package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.MajorContributeRecord;
import com.cqupt.mis.rms.model.MajorRecordMember;
import com.cqupt.mis.rms.service.model.ModelInfo;

/**
 * 查找专业建设信息的Service接口
 * @author Bern
 *
 */
public interface MajorContributeRecordInfoService {
	/**
	 * 根据记录ID查找指定专业建设信息
	 * @param awardsId
	 * @return
	 */
	public ModelInfo<MajorContributeRecord, MajorRecordMember> findMajorContributeRecordInfoByRecordId(String recordId);
	
	/**
	 * 根据用户集合查找与该用户群体相关的专业建设信息。
	 * @param CQUPTUsers
	 * @return
	 */
	public List<ModelInfo<MajorContributeRecord, MajorRecordMember>> findAllMajorContributeRecordInfo(List<CQUPTUser> CQUPTUsers);
		
	/**
	 * 从指定MajorContributeRecordInfo集合中筛检出符合条件的MajorContributeRecordInfo集合，筛选字段为字符串类型
	 * @param studentAwardsInfosRecord 要进行筛选的集合
	 * @param factorName	筛选的字符串名
	 * @param factorValue	筛选的值
	 * @return	符合要求的的筛选结果
	 */
	public List<ModelInfo<MajorContributeRecord, MajorRecordMember>> searchMajorContributeRecordInfoByStringFactor(List<ModelInfo<MajorContributeRecord, MajorRecordMember>> majorContributeRecordInfos,String factorName,String factorValue);

}
