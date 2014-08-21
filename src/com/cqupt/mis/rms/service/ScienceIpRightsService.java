package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceInventors;
import com.cqupt.mis.rms.model.ScienceIpRights;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface ScienceIpRightsService {
	//根据奖励ID查找指定奖励信息
	public ModelInfo<ScienceIpRights, ScienceInventors> findScienceIpRightsInfoByRightsId(String rightsId);
	//根据用户集合查找与该用户群体相关的奖励信息。
	public List<ModelInfo<ScienceIpRights, ScienceInventors>> findAllScienceIpRightsInfo(List<CQUPTUser> CQUPTUsers);
	
	//从指定ScienceGovernmentAward集合中筛检出符合条件的ScienceGovernmentAward集合
	//筛选字段为字符串类型
	public List<ModelInfo<ScienceIpRights, ScienceInventors>> searchScienceIpRightsInfoByStringFactor(List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfos,String factorName,String factorValue);
	//筛选字段为数值类型
	public List<ModelInfo<ScienceIpRights, ScienceInventors>> searchScienceIpRightsInfoByNumFactor(List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfos,String factorName,float minNum,float maxNum);
	//筛选字段为时间类型
	public List<ModelInfo<ScienceIpRights, ScienceInventors>> searchScienceIpRightsInfoByDateFactor(List<ModelInfo<ScienceIpRights, ScienceInventors>> scienceIpRightsInfos,String factorName,Date begin,Date end);
}
