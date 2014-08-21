package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface SciencePaperInfoService {
	//根据论文ID查找指定论文Info信息
	public ModelInfo<SciencePaper, SciencePaperAuthor> findSciencePaperInfoByPaperId(String paperId);
	//根据作者ID查找该作者的所有论文Info信息
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByAuthorId(String authorId);
	//根据论文ID查找论文第一作者
	public SciencePaperAuthor findSciencePaperFirstAuthorByPaperId(String paperId);
	//根据论文ID查找论文其他作者
	public List<SciencePaperAuthor> findSciencePaperOtherAuthorByPaperId(String paperId);
	//根据论文基本信息名称和值查找指定名称指定值的论文Info信息
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByPaperFactor(String paperFactorName, String paperFactorValue);
	//根据用户集合查找与该用户群体相关的论文信息。
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findAllSciencePaperInfo(List<CQUPTUser> CQUPTUsers);
	//根据用户ID查找包涵该用户的论文Info信息
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findHerselfSciencePaperInfo(String userId);
	
	//从指定SciencePaperInfo集合中筛检出符合条件的SciencePaperInfo集合
	//筛检字段为字符串类型、根据主表字段进行筛选
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByPaperStringFactor(List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos,String paperFactorName,String paperFactorValue);
	
	//筛检字段为数值类型、根据主表字段进行筛选
	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByPaperNumberFactor(List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos,String paperFactorName,float minNum,float maxNum);
	
//	//筛选字段为时间类型、根据主表字段进行筛选
//	public List<ModelInfo<SciencePaper, SciencePaperAuthor>> findSciencePaperInfoByPaperDateFactor(List<ModelInfo<SciencePaper, SciencePaperAuthor>> sciencePaperInfos,String paperFactorName,Date begin,Date end);

}
