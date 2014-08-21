package com.cqupt.mis.rms.action.teacher;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewAddUserAction extends ActionSupport {
	
	private CollegeManagerService collegeManagerService;
	private List<CQUPTCollege> cquptCollege;
	
	public List<CQUPTCollege> getCquptCollege() {
		return cquptCollege;
	}

	public void setCquptCollege(List<CQUPTCollege> cquptCollege) {
		this.cquptCollege = cquptCollege;
	}

	public void setCollegeManagerService(CollegeManagerService collegeManagerService) {
		this.collegeManagerService = collegeManagerService;
	}
	
	public String execute(){
		try {
			cquptCollege=collegeManagerService.getAllCollege();
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
	}
}
