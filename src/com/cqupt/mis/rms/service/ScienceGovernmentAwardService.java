package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceGovAwardPerson;
import com.cqupt.mis.rms.model.ScienceGovernmentAward;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface ScienceGovernmentAwardService {
	//根据奖励ID查找指定奖励信息
	public ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson> findScienceGovernmentAwardByAwardId(String awardId);
	//根据用户集合查找与该用户群体相关的奖励信息。
	public List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> findAllScienceGovernmentAward(List<CQUPTUser> CQUPTUsers);
	
	//从指定ScienceGovernmentAward集合中筛检出符合条件的ScienceGovernmentAward集合
	//筛选字段为字符串类型
	public List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> searchScienceGovernmentAwardByStringFactor(List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> scienceGovernmentAwards,String factorName,String factorValue);
	//筛选字段为数值类型
	public List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> searchScienceGovernmentAwardByNumFactor(List<ModelInfo<ScienceGovernmentAward, ScienceGovAwardPerson>> scienceGovernmentAwards,String factorName,float minNum,float maxNum);

}
