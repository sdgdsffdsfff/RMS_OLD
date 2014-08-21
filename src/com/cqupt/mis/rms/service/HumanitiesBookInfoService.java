package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesBookAuthor;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface HumanitiesBookInfoService {
	//根据人文社科著作ID查找指定著作信息
	public ModelInfo<HumanitiesBook, HumanitiesBookAuthor> findHumanitiesBookInfoByBookId(String bookId);
	//根据用户集合查找与该用户群体相关的著作信息。
	public List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> findAllHumanitiesBookInfo(List<CQUPTUser> CQUPTUsers);
	
	//从指定HumanitiesBookInfo集合中筛检出符合条件的HumanitiesBookinfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> searchHumanitiesBookInfoByStringFactor(List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfos,String factorName,String factorValue);
	//筛选字段为数值类型
	public List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> searchHumanitiesBookInfoByNumFactor(List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfos,String factorName,float minNum,float maxNum);
	//筛选字段为时间类型
	public List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> searchHumanitiesBookInfoByDateFactor(List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfos,String factorName,Date begin,Date end);
	
}
