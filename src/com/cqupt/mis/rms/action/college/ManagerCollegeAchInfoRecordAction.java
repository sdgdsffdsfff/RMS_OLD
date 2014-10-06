package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.model.StudentAwardsRecord;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title:实现得到符合条件教学成果类信息的action</p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company:重邮信管工作室 </p>
 * @author Bern
 * @version 2.0
 * */
public class ManagerCollegeAchInfoRecordAction extends ActionSupport {
	//注入服务层接口
	private CollegeManagerService collegeManagerService;
	
	private final static String RECORDS = "records";
	
	//得到符合条件的教学成果信息类学生获奖的相关信息
    @SuppressWarnings("unchecked")
	public String studentAwardsRecord(){
		List<StudentAwardsRecord> studentAwardsRecordsLists;
    	studentAwardsRecordsLists = (List<StudentAwardsRecord>) collegeManagerService.getInfo("StudentAwardsRecord");
    	ActionContext.getContext().put(RECORDS, studentAwardsRecordsLists);
    	return SUCCESS;
	}

	public CollegeManagerService getCollegeManagerService() {
		return collegeManagerService;
	}

	public void setCollegeManagerService(CollegeManagerService collegeManagerService) {
		this.collegeManagerService = collegeManagerService;
	}
    
}
