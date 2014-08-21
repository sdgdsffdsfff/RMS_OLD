package com.cqupt.mis.rms.service;

/**
 * <p>Title:得到需要导入Excel的数据信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
public interface GetDownloadInfoService {

	/**
	 * 通过相应的条件得到相应教学成果信息类课程建设的信息
	 * @param className 相应的model的名称
	 * @param factorName 需要的信息的字段名
	 * @param factorValue 需要的信息的字段名所对应的值
	 * @return Object 返回相应的结果集
	 * */
	public Object getExcelDownloadInfo(String className);	
	public Object getExcelDownloadInfoByFactors(String className,String factorName,String factorValues);	
	public Object getExcelDownloadInfoByFactor(String className,String factorName,String factorValue);	
}
