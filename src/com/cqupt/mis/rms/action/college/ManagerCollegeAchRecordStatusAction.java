package com.cqupt.mis.rms.action.college;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cqupt.mis.rms.manager.DynamicDataRecordDao;
import com.cqupt.mis.rms.model.EducationalRecordAward;
import com.cqupt.mis.rms.model.EducationalReformData;
import com.cqupt.mis.rms.model.EducationalReformRecord;
import com.cqupt.mis.rms.model.ExcellentRecordAward;
import com.cqupt.mis.rms.model.ExcellentTrainerData;
import com.cqupt.mis.rms.model.ExcellentTrainerRecord;
import com.cqupt.mis.rms.model.LearningEvaluationData;
import com.cqupt.mis.rms.model.LearningEvaluationRecord;
import com.cqupt.mis.rms.model.LearningRecordAward;
import com.cqupt.mis.rms.model.MajorContributeData;
import com.cqupt.mis.rms.model.MajorContributeRecord;
import com.cqupt.mis.rms.model.MajorRecordMember;
import com.cqupt.mis.rms.model.OtherTeachingAwardsData;
import com.cqupt.mis.rms.model.OtherTeachingAwardsRecord;
import com.cqupt.mis.rms.model.OtherTeachingRecordAward;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.QualityProjectData;
import com.cqupt.mis.rms.model.QualityProjectRecord;
import com.cqupt.mis.rms.model.QualityRecordAward;
import com.cqupt.mis.rms.model.StudentAwardsData;
import com.cqupt.mis.rms.model.StudentAwardsRecord;
import com.cqupt.mis.rms.model.StudentRecordInstructor;
import com.cqupt.mis.rms.model.TeachersAwardsData;
import com.cqupt.mis.rms.model.TeachersAwardsRecord;
import com.cqupt.mis.rms.model.TeachersRecordAchievements;
import com.cqupt.mis.rms.model.TeachingMaterialData;
import com.cqupt.mis.rms.model.TeachingMaterialRecord;
import com.cqupt.mis.rms.model.TeachingRecordEditor;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.cqupt.mis.rms.utils.EducationalReformDataComparator;
import com.cqupt.mis.rms.utils.ExcellentTrainerDataComparator;
import com.cqupt.mis.rms.utils.LearningEvaluationDataComparator;
import com.cqupt.mis.rms.utils.MajorContributeDataComparator;
import com.cqupt.mis.rms.utils.OtherTeachingAwardsDataComparator;
import com.cqupt.mis.rms.utils.QualityProjectDataComparator;
import com.cqupt.mis.rms.utils.StudentAwardsDataComparator;
import com.cqupt.mis.rms.utils.TeachAchievementsDataComparator;
import com.cqupt.mis.rms.utils.TeachingMaterialDataComparator;
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
    	StudentAwardsRecord record = (StudentAwardsRecord) dynamicDataRecordDao.findRecordByClassNameAndId("StudentAwardsRecord",recordId);
    	Set<StudentAwardsData> sortedFields = new TreeSet<StudentAwardsData>(new StudentAwardsDataComparator());
    	sortedFields.addAll(record.getFields());
    	record.setFields(sortedFields);
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
		
		TeachersAwardsRecord record = (TeachersAwardsRecord) dynamicDataRecordDao.findRecordByClassNameAndId("TeachersAwardsRecord",recordId);
    	Set<TeachersAwardsData> sortedFields = new TreeSet<TeachersAwardsData>(new TeachAchievementsDataComparator());
    	sortedFields.addAll(record.getFields());
    	record.setFields(sortedFields);
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
		MajorContributeRecord record =(MajorContributeRecord)dynamicDataRecordDao.findRecordByClassNameAndId("MajorContributeRecord",recordId);
    	Set<MajorContributeData> sortedFields = new TreeSet<MajorContributeData>(new MajorContributeDataComparator());
    	sortedFields.addAll(record.getFields());
    	record.setFields(sortedFields);
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
		TeachingMaterialRecord record =(TeachingMaterialRecord)dynamicDataRecordDao.findRecordByClassNameAndId("TeachingMaterialRecord",recordId);
    	Set<TeachingMaterialData> sortedFields = new TreeSet<TeachingMaterialData>(new TeachingMaterialDataComparator());
    	sortedFields.addAll(record.getFields());
    	record.setFields(sortedFields);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<TeachingRecordEditor> memberList = (List<TeachingRecordEditor>)collegeManagerService.getInfoByFactor(recordId, "TeachingRecordEditor", "teachingMaterialRecord.id");
    	ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put(PROOFS, proofs);
		ActionContext.getContext().put("memberList", memberList);
    	return SUCCESS;
	}
	

	/**
	 * 查找优秀培训师的所有详细信息
	 */
	@SuppressWarnings("unchecked")
	public String excellentTrainerRecord() {
		ExcellentTrainerRecord record =(ExcellentTrainerRecord)dynamicDataRecordDao.findRecordByClassNameAndId("ExcellentTrainerRecord",recordId);
		Set<ExcellentTrainerData> sortedFields = new TreeSet<ExcellentTrainerData>(new ExcellentTrainerDataComparator());
    	sortedFields.addAll(record.getFields());
    	record.setFields(sortedFields);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<ExcellentRecordAward> memberList = (List<ExcellentRecordAward >)collegeManagerService.getInfoByFactor(recordId, "ExcellentRecordAward ", "excellentTrainerRecord.id");
    	ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put(PROOFS, proofs);
		ActionContext.getContext().put("memberList", memberList);
    	return SUCCESS;
	}
	/**
	 * 查找质量工程的所有详细信息
	 */
	@SuppressWarnings("unchecked")
	public String qualityProjectRecord() {
	
		QualityProjectRecord record =(QualityProjectRecord)dynamicDataRecordDao.findRecordByClassNameAndId("QualityProjectRecord",recordId);
		Set<QualityProjectData> sortedFields = new TreeSet<QualityProjectData>(new QualityProjectDataComparator());
    	sortedFields.addAll(record.getFields());
    	record.setFields(sortedFields);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<QualityRecordAward> memberList = (List<QualityRecordAward >)collegeManagerService.getInfoByFactor(recordId, "QualityRecordAward ", "qualityProjectRecord.id");
    	ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put(PROOFS, proofs);
		ActionContext.getContext().put("memberList", memberList);
    	return SUCCESS;
	}
	/**
	 * 查找学评教的所有详细信息
	 */

	@SuppressWarnings("unchecked")
	public String learningEvaluationRecord() {
		LearningEvaluationRecord record = (LearningEvaluationRecord)dynamicDataRecordDao.findRecordByClassNameAndId("LearningEvaluationRecord",recordId);
    	Set<LearningEvaluationData> sortedFields = new TreeSet<LearningEvaluationData>(new LearningEvaluationDataComparator());
    	sortedFields.addAll(record.getFields());
    	record.setFields(sortedFields);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<LearningRecordAward> memberList = (List<LearningRecordAward >)collegeManagerService.getInfoByFactor(recordId, "LearningRecordAward ", "learningEvaluationRecord.id");
    	ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put(PROOFS, proofs);
		ActionContext.getContext().put("memberList", memberList);
    	return SUCCESS;
	}
	/**
	 * 查找教改项目的所有详细信息
	 */
	@SuppressWarnings("unchecked")
	public String educationalReformRecord() {
		EducationalReformRecord record =(EducationalReformRecord) dynamicDataRecordDao.findRecordByClassNameAndId("EducationalReformRecord",recordId);
    	Set<EducationalReformData> sortedFields = new TreeSet<EducationalReformData>(new EducationalReformDataComparator());
    	sortedFields.addAll(record.getFields());
    	record.setFields(sortedFields);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<EducationalRecordAward> memberList = (List<EducationalRecordAward>)collegeManagerService.getInfoByFactor(recordId, "EducationalRecordAward ", "educationalReformRecord.id");
    	ActionContext.getContext().put(RECORD, record);
		ActionContext.getContext().put(PROOFS, proofs);
		ActionContext.getContext().put("memberList", memberList);
    	return SUCCESS;
	}
	
	/**
	 * 查找其他教学奖励的所有详细信息
	 */
	@SuppressWarnings("unchecked")
	public String otherTeachingAwardsRecord() {
		OtherTeachingAwardsRecord record =(OtherTeachingAwardsRecord) dynamicDataRecordDao.findRecordByClassNameAndId("OtherTeachingAwardsRecord",recordId);
    	Set<OtherTeachingAwardsData> sortedFields = new TreeSet<OtherTeachingAwardsData>(new OtherTeachingAwardsDataComparator());
    	sortedFields.addAll(record.getFields());
    	record.setFields(sortedFields);
    	List<Proofs> proofs = (List<Proofs>) collegeManagerService.getInfoByFactor(recordId, "Proofs", "infoApprovedId");
    	List<OtherTeachingRecordAward> memberList = (List<OtherTeachingRecordAward>)collegeManagerService.getInfoByFactor(recordId, "OtherTeachingRecordAward ", "otherTeachingAwardsRecord.id");
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
