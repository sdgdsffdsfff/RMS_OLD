package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.manager.DynamicDataRecordDao;
import com.cqupt.mis.rms.model.MajorRecordMember;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.StudentRecordInstructor;
import com.cqupt.mis.rms.model.TeachersRecordAchievements;
import com.cqupt.mis.rms.model.TeachingRecordEditor;
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

	/**
	 * 查找教学成果奖的所有详细信息
	 */
	@SuppressWarnings("unchecked")
	public String teacherAwardsRecord() {
    	Object record = dynamicDataRecordDao.findRecordByClassNameAndId("TeachersAwardsRecord",recordId);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<TeachersRecordAchievements> memberList = (List<TeachersRecordAchievements >)collegeManagerService.getInfoByFactor(recordId, "TeachersRecordAchievements ", "teachersAwardsRecord.id");
    	ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put(PROOFS, proofs);
		ActionContext.getContext().put("memberList", memberList);
    	return SUCCESS;
	}

	
	/**
	 * 查找专业建设的所有详细信息
	 */
	@SuppressWarnings("unchecked")
	public String majorContributeRecord() {
    	Object record = dynamicDataRecordDao.findRecordByClassNameAndId("MajorContributeRecord",recordId);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<MajorRecordMember> memberList = (List<MajorRecordMember>)collegeManagerService.getInfoByFactor(recordId, "MajorRecordMember", "majorContributeRecord.id");
    	ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put(PROOFS, proofs);
		ActionContext.getContext().put("memberList", memberList);
    	return SUCCESS;
	}
	
	/**
	 * 查找教材立项的所有详细信息
	 */
	@SuppressWarnings("unchecked")
	public String teachingMaterialRecord() {
    	Object record = dynamicDataRecordDao.findRecordByClassNameAndId("TeachingMaterialRecord",recordId);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<TeachingRecordEditor> memberList = (List<TeachingRecordEditor>)collegeManagerService.getInfoByFactor(recordId, "TeachingRecordEditor", "teachingMaterialRecord.id");
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
