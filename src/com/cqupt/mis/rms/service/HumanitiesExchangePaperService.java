package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesExchangePaperAuthor;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface HumanitiesExchangePaperService {
	//根据人文社科交流论文ID查找指定交流论文信息
	public ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor> findHumanitiesExchangePaperInfoByExchangePaperId(String exchangePaperId);
	//根据用户集合查找与该用户群体相关的交流论文信息。
	public List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> findAllHumanitiesExchangePaperInfo(List<CQUPTUser> CQUPTUsers);
	
	//从指定HumanitiesExchangePaperInfo集合中筛检出符合条件的HumanitiesExchangePaperInfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> searchHumanitiesExchangePaperInfoByStringFactor(List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> humanitiesExchangePaperInfos,String factorName,String factorValue);
	//筛选字段为时间类型
	public List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> searchHumanitiesExchangePaperInfoByDateFactor(List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> humanitiesExchangePaperInfos,String factorName,Date begin,Date end);
		
}
