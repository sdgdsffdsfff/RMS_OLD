package com.cqupt.mis.rms.action.system.user;



import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.utils.FileChecker;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:管理用户信息Action</p>
*<p>Description:删除存在服务器上的有错误信息的excel</p>
*@author HuangHaiyan
*@version 1.0
**/
@SuppressWarnings("serial")
public class DeleteErrorExcelAction extends ActionSupport implements ServletContextAware{

	private FileChecker fileChecker = new FileChecker();
	private ServletContext servletContext;
	private String alert;	
	

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	public String execute() throws Exception {
    	
    	String fileUrl = servletContext.getRealPath("Excel");
    	boolean b = false;
    	b = fileChecker.deleteFileinFolder(fileUrl);
    	if(b){
    		alert = "删除成功!";
    		
    	}else{
    		alert = "删除失败,请稍后再试！";
    	}
    	return SUCCESS;
	}
}
