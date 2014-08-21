package com.cqupt.mis.rms.action.teacher;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class DownExcelModelAction  extends ActionSupport{
	 private String modelName;
	 private String downLoadUrl;
	 private String fileShowName;
	 public String getFileShowName() {
		return fileShowName;
	}

	public void setFileShowName(String fileShowName) {
		this.fileShowName = fileShowName;
	}

	public String getModelName() {
		return modelName;
	 }

	 public void setModelName(String modelName) {
		this.modelName = modelName;
	 }

	 public InputStream getInputStream() throws Exception{
		    return ServletActionContext.getServletContext().getResourceAsStream(downLoadUrl);
	 }
	 public String execute() throws Exception {
		 if("Tec".equals(modelName)){
			 downLoadUrl = "/upload/理工科研成果统计表模板.xls"; 
			 fileShowName = "LiGong.xls";
		 }else if("Ach".equals(modelName)){
			 downLoadUrl = "/upload/教学类成果统计表模板.xls"; 
			 fileShowName = "JiaoXue.xls";
		 }else if("NewAch".equals(modelName)){
			 downLoadUrl = "/upload/教学奖励统计表模板.xls"; 
			 fileShowName = "JiaoXueNew.xls";
			 return SUCCESS;
		 }else if("Hum".equals(modelName)){
			 downLoadUrl = "/upload/人文社科科研成果统计表模板.xls"; 
			 fileShowName = "SheKe.xls";
		 }else if("Document".equals(modelName)){
			 downLoadUrl = "/upload/重邮邮电大学经济管理学院科研管理系统使用说明文档.doc"; 
			 fileShowName = "ShiYongWenDang.doc";
			 return "DOC";
		 }
		 
		 return SUCCESS;
	 }
}
