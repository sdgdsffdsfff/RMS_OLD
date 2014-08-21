/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.common;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.service.UserManagerService;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:管理用户信息Action</p>
*<p>Description:从excel导入用户信息</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ImportUserInfoAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private UserManagerService userManagerService;
	
	//上传文件
	//上传文件
	private File upload;// 实际上传文件
	private String uploadFileName; // 上传文件名
	private ServletContext servletContext;
	
	
	public String execute() throws Exception {
		String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
		if(upload != null){
			try {
				String targetFileName = GenerateUtils.generateFileName(uploadFileName);   
		        File target = new File(targetDirectory, targetFileName); 
		       // System.out.println(targetDirectory + "\\" + targetFileName);
		        FileUtils.copyFile(upload, target);
		        String userInfoExcelPath = targetDirectory + "\\" + targetFileName;
		        File excelfile = new File(userInfoExcelPath);
		        userManagerService.readUserBasicInfoExceltoDB(excelfile);
		        
		        if(excelfile.exists()){
		        	excelfile.delete();
		        }
		        if(target.exists()){
		        	target.delete();
		        }
		        
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		}
		return SUCCESS;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
