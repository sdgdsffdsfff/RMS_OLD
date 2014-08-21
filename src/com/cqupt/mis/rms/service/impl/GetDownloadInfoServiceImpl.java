package com.cqupt.mis.rms.service.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.GetInfoToExcelDao;
import com.cqupt.mis.rms.service.GetDownloadInfoService;


/**
 * <p>Title:实现需要导入Excel的数据信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
public class GetDownloadInfoServiceImpl implements GetDownloadInfoService{

	
	private GetInfoToExcelDao getInfoToExcelDao;
	
	public GetInfoToExcelDao getGetInfoToExcelDao() {
		return getInfoToExcelDao;
	}
    public void setGetInfoToExcelDao(GetInfoToExcelDao getInfoToExcelDao) {
		this.getInfoToExcelDao = getInfoToExcelDao;
	}

     /**
	 * 通过相应的条件得到相应的信息
	 * @param className 相应的model的名称
	 * @return Object 返回相应的结果集
	 * */

	@Override
	public Object getExcelDownloadInfo(String className) {
		
		List<Object> lists = (List<Object>) getInfoToExcelDao.getInfo(className);
		System.out.println(lists);
		return lists;
	}
	
	 /**
	 * 通过相应的条件得到相应的信息
	 * @param className 相应的model的名称
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回相应的结果集
	 * */
	@Override
	public Object getExcelDownloadInfoByFactors(String className,
			String factorName, String factorValues) {
		List<Object> lists = (List<Object>) getInfoToExcelDao.getInfoByFactors(className,factorName,factorValues);
	

		return lists;
	}
	
	@Override
	public Object getExcelDownloadInfoByFactor(String className,
			String factorName, String factorValue) {
		// TODO Auto-generated method stub
		List<Object> lists = (List<Object>) getInfoToExcelDao.getInfoByFactors(className,factorName,factorValue);

		return lists;
	}

}
