package com.cqupt.mis.rms.action.teacher;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import com.cqupt.mis.rms.service.UserManagerService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial", "deprecation" })
public class CheckUserIdAction extends ActionSupport{
	
	private UserManagerService userManagerService;
	private String userId;
	private InputStream inputStream;
	
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String execute(){
		try {
			
			if(userManagerService.checkUserId(userId)){
				inputStream = new StringBufferInputStream(""+SUCCESS);
				return SUCCESS;
			}else{
				inputStream = new StringBufferInputStream("repeat");
				return "repeat";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
	}
}
