package com.cqupt.mis.rms.action.teacher;

import java.util.List;

import com.cqupt.mis.rms.manager.DynamicDataRecordDao;
import com.cqupt.mis.rms.manager.ResearchInfoDao;
import com.cqupt.mis.rms.model.MajorRecordMember;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.StudentRecordInstructor;
import com.cqupt.mis.rms.model.TeachersRecordAchievements;
import com.cqupt.mis.rms.model.TeachingRecordEditor;
import com.cqupt.mis.rms.utils.DynamicDataFieldUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理用户查看详细科研信息(动态字段)的Action
 * @author Bern
 *
 */
public class ViewResearchDetailRecordInfoAction extends ActionSupport {
	//注入接口
	private DynamicDataRecordDao dynamicDataRecordDao; 
	private ResearchInfoDao researchInfoDao;
	
	private int classNum;
	private String recordId;
	private String flag;
	
	private final static String RECORD = "record";
	
	/**
	 * 查找单个详细的学生获奖信息 
	 */
	@SuppressWarnings("unchecked")
	public String viewStudentAwardsRecordDetail() {
		Object record = dynamicDataRecordDao.findRecordByClassNameAndId("StudentAwardsRecord", recordId);
		List<Proofs> proofs = researchInfoDao.findProofByApprovedId(recordId);
		List<StudentRecordInstructor> memberList = (List<StudentRecordInstructor>)researchInfoDao.
				findMemberByIdAndModelNameAndFactor(recordId, "StudentRecordInstructor", "studentAwardsRecord.id");
		if(record == null) {
			return "error";
		}
		ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put("proofs", proofs);
		ActionContext.getContext().put("memberList", memberList);
		if("modify".equals(flag)){
			return "modify";
		}else{
			return SUCCESS;
		}
	}
	

	/**
	 * 查找单个详细的教学成果奖信息 
	 */
	@SuppressWarnings("unchecked")
	public String viewTeacherAwardsRecordDetail() {
		Object record = dynamicDataRecordDao.findRecordByClassNameAndId("TeachersAwardsRecord", recordId);
		List<Proofs> proofs = researchInfoDao.findProofByApprovedId(recordId);
	
		List<TeachersRecordAchievements> memberList = (List<TeachersRecordAchievements>)researchInfoDao.
				findMemberByIdAndModelNameAndFactor(recordId, "TeachersRecordAchievements", "teachersAwardsRecord.id");
		if(record == null) {
			return "error";
		}
		ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put("proofs", proofs);
		ActionContext.getContext().put("memberList", memberList);
		if("modify".equals(flag)){
			return "modify";
		}else{
			return SUCCESS;
		}
	}
	
	/**
	 * 查找单个详细的专业建设信息 
	 */
	@SuppressWarnings("unchecked")
	public String viewMajorContributeRecordDetail() {
		Object record = dynamicDataRecordDao.findRecordByClassNameAndId("MajorContributeRecord", recordId);
		List<Proofs> proofs = researchInfoDao.findProofByApprovedId(recordId);
		List<MajorRecordMember> memberList = (List<MajorRecordMember>)researchInfoDao.
				findMemberByIdAndModelNameAndFactor(recordId, "MajorRecordMember", "majorContributeRecord.id");
		if(record == null) {
			return "error";
		}
		ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put("proofs", proofs);
		ActionContext.getContext().put("memberList", memberList);
		if("modify".equals(flag)){
			return "modify";
		}else{
			return SUCCESS;
		}
	}
	
	/**
	 * 查找单个详细的教材立项信息 
	 */
	@SuppressWarnings("unchecked")
	public String viewTeachingMaterialRecordDetail() {
		Object record = dynamicDataRecordDao.findRecordByClassNameAndId("TeachingMaterialRecord", recordId);
		List<Proofs> proofs = researchInfoDao.findProofByApprovedId(recordId);
		List<TeachingRecordEditor> memberList = (List<TeachingRecordEditor>)researchInfoDao.
				findMemberByIdAndModelNameAndFactor(recordId, "TeachingRecordEditor", "teachingMaterialRecord.id");
		if(record == null) {
			return "error";
		}
		ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put("proofs", proofs);
		ActionContext.getContext().put("memberList", memberList);
		if("modify".equals(flag)){
			return "modify";
		}else{
			return SUCCESS;
		}
	}
	
	public DynamicDataRecordDao getDynamicDataRecordDao() {
		return dynamicDataRecordDao;
	}
	public void setDynamicDataRecordDao(DynamicDataRecordDao dynamicDataRecordDao) {
		this.dynamicDataRecordDao = dynamicDataRecordDao;
	}
	public ResearchInfoDao getResearchInfoDao() {
		return researchInfoDao;
	}
	public void setResearchInfoDao(ResearchInfoDao researchInfoDao) {
		this.researchInfoDao = researchInfoDao;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
