package com.cqupt.mis.rms.service;

import java.io.File;
/**
*<p>Title:管理用户信息Service</p>
*<p>Description:从excel导入信息到数据库</p>
*@author HuangHaiyan
*@version 1.0
**/


public interface ExcelToDBService {
	/**
	 * 从EXCEL表格里面导入教师基本信息进入数据库
	 * @param excelfile EXCEL文件
	 * @return  导入成功返回true  失败返回false
	 */
	public String readInfoExceltoDB(File excelfile,String userId,String url);
	
}
