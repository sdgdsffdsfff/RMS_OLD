package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.service.UserManagerService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewManageTeacherAction extends ActionSupport {
	
	private UserManagerService userManagerService;
	private List<CQUPTUser> collegeteacherList;
	
	
	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

	public List<CQUPTUser> getCollegeteacherList() {
		return collegeteacherList;
	}



	public void setCollegeteacherList(List<CQUPTUser> collegeteacherList) {
		this.collegeteacherList = collegeteacherList;
	}



	public String execute() throws Exception{
		try {
			collegeteacherList=userManagerService.getUser();
			return "manageTea";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
}
