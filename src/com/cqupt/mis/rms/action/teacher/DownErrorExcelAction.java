package com.cqupt.mis.rms.action.teacher;

import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.service.ResearchInfoService;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:管理用户信息Action</p>
*<p>Description:下载集合了上传未成功的信息的excel</p>
*@author HuangHaiyan
*@version 1.0
**/
@SuppressWarnings("serial")
public class DownErrorExcelAction extends ActionSupport implements ServletContextAware {

	private String url;
	private String fileShowName;
	private ServletContext servletContext;
	private String type;
	private ResearchInfoService researchInfoService;
	

	

	public ResearchInfoService getResearchInfoService() {
		return researchInfoService;
	}

	public void setResearchInfoService(ResearchInfoService researchInfoService) {
		this.researchInfoService = researchInfoService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileShowName() {
		return fileShowName;
	}

	public void setFileShowName(String fileShowName) {
		this.fileShowName = fileShowName;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	public String getUrl() {
		return url;
	}

    public void setUrl(String url) {
		this.url = url;
	}
	
    public InputStream getInputStream() throws Exception{
		
	    return ServletActionContext.getServletContext().getResourceAsStream("Excel\\"+url);
	}
	    
    
    public String execute() throws Exception {
    	if("Tec".equals(type)){
    		fileShowName = "LiGongErrorInfo";
    	}else if("Ach".equals(type)){
    		fileShowName = "JiaoXueErrorInfo";
    	}else if("Hum".equals(type)){
    		fileShowName = "SheKeErrorInfo";
    	}else if("NewAch".equals(type)){
    		fileShowName = "JiangLiErrorInfo";
    	}
		return SUCCESS;
	}
}
