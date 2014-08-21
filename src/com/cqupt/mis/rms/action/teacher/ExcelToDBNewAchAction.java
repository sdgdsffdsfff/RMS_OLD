package com.cqupt.mis.rms.action.teacher;

import java.io.File;

import javax.servlet.ServletContext;



import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.service.ExcelToDBService;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:管理用户信息Action</p>
*<p>Description:从excel导入教学成果信息类教材立项信息</p>
*@author HuangHaiyan
*@version 1.0
**/
@SuppressWarnings("serial")
public class ExcelToDBNewAchAction extends ActionSupport implements ServletContextAware {

	private ExcelToDBService excelToDBService;
    private String warning;
    private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	
	//上传文件
	private File upload;// 实际上传文件
	private String uploadFileName; // 上传文件名
	private ServletContext servletContext;
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	
	public void setExcelToDBService(ExcelToDBService excelToDBService) {
		this.excelToDBService = excelToDBService;
	}
	public ExcelToDBService getExcelToDBService() {
		return excelToDBService;
	}

	
	public String execute() throws Exception {
		
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		
		String targetDirectory = servletContext.getRealPath("Excel");//获得路径
		
		
		
		if(upload != null){
			try {
				String targetFileName = GenerateUtils.generateFileName(uploadFileName);   
		        File target = new File(targetDirectory, targetFileName); 
		        
		        FileUtils.copyFile(upload, target);
		        String userInfoExcelPath = targetDirectory + "\\" + targetFileName;
		        File excelfile = new File(userInfoExcelPath);
		        String info = excelToDBService.readInfoExceltoDB(excelfile,userId,targetDirectory);
		        if("ALLSUC".equals(info)){
		        	warning = "数据全部导入成功！";
		        }else if("ERR".equals(info)){
		        	warning = "数据导入中出现问题,请看是否上传的是正确的excel,否则请联系管理员！";
		        }else{
		        	warning = "部分未导入的数据生成的excel,请及时下载！";
		        	url = info;
		        }
		        if(target.exists()){
		        	target.delete();
		        }
		        return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		}
		warning = "请上传材料";
		return ERROR;
	}
}
