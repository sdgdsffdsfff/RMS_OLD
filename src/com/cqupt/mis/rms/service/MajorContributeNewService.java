package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.MajorContributeNew;
import com.cqupt.mis.rms.model.MajorContributeMemberNew;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface MajorContributeNewService {
	//根据专业建设ID查找指定专业建设信息
	public ModelInfo<MajorContributeNew, MajorContributeMemberNew> findMajorContributeInfoByMajorId(String majorId);
	//根据用户集合查找与该用户群体相关的专业建设信息。
	public List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> findAllMajorContributeInfo(List<CQUPTUser> CQUPTUsers);
	
	//从指定MajorContributeInfo集合中筛检出符合条件的MajorContributeInfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> searchMajorContributeInfoByStringFactor(List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfos,String factorName,String factorValue);
	//筛选字段为数值类型
	public List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> searchMajorContributeInfoByNumFactor(List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfos,String factorName,float minNum,float maxNum);
	//筛选字段为时间类型
	public List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> searchMajorContributeInfoByDateFactor(List<ModelInfo<MajorContributeNew, MajorContributeMemberNew>> majorContributeInfos,String factorName,Date begin,Date end);

}
