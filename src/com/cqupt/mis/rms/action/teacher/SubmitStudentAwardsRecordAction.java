package com.cqupt.mis.rms.action.teacher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.cqupt.mis.rms.manager.DynamicDataRecordDao;
import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.StudentAwardsData;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.cqupt.mis.rms.model.StudentAwardsRecord;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 处理学生获奖信息的Action
 */
public class SubmitStudentAwardsRecordAction extends ActionSupport {
	private SubmitInfoAndProofsService submitInfoAndProofsService;
	private DynamicDataRecordDao dynamicDataRecordDao;
	private SearchDao searchDao;
	
	private String awardsName;
	
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		StudentAwardsRecord studentAwardsRecord = new StudentAwardsRecord();
		String id = GenerateUtils.getID();	//生成ID
		//取得存放在session中的userId
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		CQUPTUser user = new CQUPTUser();
		user.setUserId(userId);
		studentAwardsRecord.setId(id);
		studentAwardsRecord.setSubmitUser(user);
		studentAwardsRecord.setName(awardsName);
		List<StudentAwardsField> fieldsFromDataBase = searchDao.SearchObjectsByFactor("com.cqupt.mis.rms.model.StudentAwardsField", "isDelete", 0);
		Set<StudentAwardsData> fields = new HashSet<StudentAwardsData>();
		//将前台已填写的字段封装成StudentAwardsData对象
		for(StudentAwardsField f : fieldsFromDataBase) {
			String value = (String) request.getParameter(f.getName());
			if(value==null || "".equals(value)) {
				continue;
			} else {
				StudentAwardsData tempData = new StudentAwardsData();
				tempData.setAwards(studentAwardsRecord);
				tempData.setField(f);
				tempData.setValue(value);
				fields.add(tempData);
			}
		}
		studentAwardsRecord.setFields(fields);
		boolean result1 = dynamicDataRecordDao.addRecord(studentAwardsRecord);
		Confirm confirm = new Confirm();
		if(result1){
			confirm.setIsSuccess("right");
			confirm.setMessage("学生获奖信息添加成功");
			confirm.setUrl("viewStudentAwards.action");
			confirm.setRetName("个人学生获奖信息页面");
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("学生获奖信息添加失败");
			confirm.setUrl("viewStudentAwards.action");
			confirm.setRetName("个人学生获奖信息页面");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}

	
	public SubmitInfoAndProofsService getSubmitInfoAndProofsService() {
		return submitInfoAndProofsService;
	}


	public void setSubmitInfoAndProofsService(
			SubmitInfoAndProofsService submitInfoAndProofsService) {
		this.submitInfoAndProofsService = submitInfoAndProofsService;
	}


	public SearchDao getSearchDao() {
		return searchDao;
	}


	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	public String getAwardsName() {
		return awardsName;
	}


	public void setAwardsName(String awardsName) {
		this.awardsName = awardsName;
	}


	public DynamicDataRecordDao getDynamicDataRecordDao() {
		return dynamicDataRecordDao;
	}


	public void setDynamicDataRecordDao(DynamicDataRecordDao dynamicDataRecordDao) {
		this.dynamicDataRecordDao = dynamicDataRecordDao;
	}

	
}
