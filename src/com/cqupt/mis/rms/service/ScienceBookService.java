package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceBook;
import com.cqupt.mis.rms.model.ScienceBookAuthor;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface ScienceBookService {
	//根据著作ID查找指定著作Info信息
	public ModelInfo<ScienceBook, ScienceBookAuthor> findScienceBookInfoByBookId(String bookId);
	//根据作者ID查找该作者所有的著作信息
	public List<ModelInfo<ScienceBook, ScienceBookAuthor>> findScienceBookInfoByAuthorId(String authorId);
	//根据用户集合查找与该用户群体相关的著作信息。
	public List<ModelInfo<ScienceBook, ScienceBookAuthor>> findAllScienceBookInfo(List<CQUPTUser> CQUPTUsers);
	
	//从指定ScienceBookInfo集合中筛检出符合条件的ScienceBookInfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<ScienceBook, ScienceBookAuthor>> searchScienceBookInfoByStringFactor(List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfos,String factorName,String factorValue);
	//筛选字段为数值类型
	public List<ModelInfo<ScienceBook, ScienceBookAuthor>> searchScienceBookInfoByNumFactor(List<ModelInfo<ScienceBook, ScienceBookAuthor>> scienceBookInfos,String factorName,float minNum,float maxNum);
}
