package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.manager.DynamicDataRecordDao;
import com.cqupt.mis.rms.model.MajorContribute;
import com.cqupt.mis.rms.model.MajorContributeMember;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.StudentRecordInstructor;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理审核者查找详细信息的Action
 * @author Bern
 *
 */
public class ManagerCollegeAchRecordStatusAction extends ActionSupport {
	//注入服务层接口
	private DynamicDataRecordDao dynamicDataRecordDao;
	private CollegeManagerService collegeManagerService;
	
	private String recordId;
	
	private final static String RECORD = "record";
	private final static String PROOFS = "proofs";
	
	/**
	 * 查找学生获奖的所有详细信息
	 */
	@SuppressWarnings("unchecked")
	public String studentAwardsRecord() {
    	Object record = dynamicDataRecordDao.findRecordByClassNameAndId("StudentAwardsRecord",recordId);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<StudentRecordInstructor> memberList = (List<StudentRecordInstructor>)collegeManagerService.getInfoByFactor(recordId, "StudentRecordInstructor", "studentAwardsRecord.id");
    	ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put(PROOFS, proofs);
		ActionContext.getContext().put("memberList", memberList);
    	return SUCCESS;
	}

	public DynamicDataRecordDao getDynamicDataRecordDao() {
		return dynamicDataRecordDao;
	}

	public void setDynamicDataRecordDao(DynamicDataRecordDao dynamicDataRecordDao) {
		this.dynamicDataRecordDao = dynamicDataRecordDao;
	}

	public CollegeManagerService getCollegeManagerService() {
		return collegeManagerService;
	}

	public void setCollegeManagerService(CollegeManagerService collegeManagerService) {
		this.collegeManagerService = collegeManagerService;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	
}
