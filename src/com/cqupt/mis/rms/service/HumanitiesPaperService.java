package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesPaper;
import com.cqupt.mis.rms.model.HumanitiesPaperAuthor;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface HumanitiesPaperService {
	//根据人文社科论文ID查找指定论文信息
	public ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor> findHumanitiesPaperInfoByPaperId(String paperId);
	//根据用户集合查找与该用户群体相关的论文信息。
	public List<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>> findAllHumanitiesPaperInfo(List<CQUPTUser> CQUPTUsers);
	
	//从指定HumanitiesPaperInfo集合中筛检出符合条件的HumanitiesPaperinfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>> searchHumanitiesPaperInfoByStringFactor(List<ModelInfo<HumanitiesPaper, HumanitiesPaperAuthor>> humanitiesPaperInfos,String factorName,String factorValue);
	
}
