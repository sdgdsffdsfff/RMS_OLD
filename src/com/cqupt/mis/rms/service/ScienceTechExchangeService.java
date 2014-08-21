package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceTechAttendPerson;
import com.cqupt.mis.rms.model.ScienceTechExchange;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface ScienceTechExchangeService {
	//根据科技交流ID查找指定科技交流信息
	public ModelInfo<ScienceTechExchange, ScienceTechAttendPerson> findScienceTechExchangeByTechExchangeId(String techExchangeId);
	//根据用户集合查找与该用户群体相关的科技交流信息。
	public List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> findAllScienceTechExchange(List<CQUPTUser> CQUPTUsers);
	
	
	//从指定ScienceTechExchangeInfo集合中筛检出符合条件的ScienceTechExchangeInfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> searchScienceTechExchangeByStringFactor(List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> scienceTechExchanges,String factorName,String factorValue);
	//筛选字段为数值类型
	public List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> searchScienceTechExchangeByNumFactor(List<ModelInfo<ScienceTechExchange, ScienceTechAttendPerson>> scienceTechExchanges,String factorName,float minNum,float maxNum);
	
}
