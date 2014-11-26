package com.cqupt.mis.rms.action.teacher;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.service.ResearchRecordInfoService;
import com.cqupt.mis.rms.utils.TypeConvert;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理删除教学类科研信息（动态）的Action
 * @author Bern
 *
 */
public class DeleteResearchRecordInfoAction extends ActionSupport implements ServletContextAware {
	private ResearchRecordInfoService researchRecordInfoService;
	private ServletContext servletContext;
	private String recordIdString;		//传回来的是用逗号分隔的一个字符串
	
	public String obtainFileBasePath(){
		String fileBasePath = servletContext.getRealPath("") + "\\";
		return fileBasePath;
	}
	
	/**
	 * 删除学生获奖信息 
	 */
	public String deleteStudentAwardsRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		researchRecordInfoService.deleteResearchInfo(recordIds, "StudentAwardsRecord", 
				"StudentRecordInstructor", "StudentAwardsData", "awards",
				"studentAwardsRecord", this.obtainFileBasePath());
		return SUCCESS;
	}
	
	/**
	 * 删除教学成果奖信息 
	 */
	public String deleteTeacherAwardsRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		researchRecordInfoService.deleteResearchInfo(recordIds, "TeacherAwardsRecord", 
				"TeachersRecordAchievements", "TeacherAwardsData", "record",
				"teacherAwardsRecord", this.obtainFileBasePath());
		return SUCCESS;
	}

	/**
	 * 删除专业建设信息 
	 */
	public String deleteMajorContributeRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		researchRecordInfoService.deleteResearchInfo(recordIds, "MajorContributeRecord", 
				"MajorRecordMember", "MajorContributeData", "record",
				"majorContributeRecord", this.obtainFileBasePath());
		return SUCCESS;
	}
	
	/**
	 * 删除教材立项信息 
	 */
	public String deleteTeachingMaterialRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		researchRecordInfoService.deleteResearchInfo(recordIds, "TeachingMaterialRecord", 
				"TeachingRecordEditor", "TeachingMaterialData", "record",
				"teachingMaterialRecord", this.obtainFileBasePath());
		return SUCCESS;
	}
	
	/**
	 * 删除优秀培训师信息 
	 */
	public String deleteExcellentTrainerRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		researchRecordInfoService.deleteResearchInfo(recordIds, "ExcellentTrainerRecord", 
				"ExcellentRecordAward", "ExcellentTrainerData", "record",
				"excellentTrainerRecord", this.obtainFileBasePath());
		return SUCCESS;
	}
	
	/**
	 * 删除质量工程信息 
	 */
	public String deleteQualityProjectRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		researchRecordInfoService.deleteResearchInfo(recordIds, "QualityProjectRecord", 
				"QualityRecordAward", "QualityProjectData", "record",
				"qualityProjectRecord", this.obtainFileBasePath());
		return SUCCESS;
	}
	
	/**
	 * 删除学评教信息 
	 */
	public String deleteLearningEvaluationRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		researchRecordInfoService.deleteResearchInfo(recordIds, "LearningEvaluationRecord", 
				"LearningRecordAward", "LearningEvaluationData", "record",
				"learningEvaluationRecord", this.obtainFileBasePath());
		return SUCCESS;
	}
	
	
	/**
	 * 删除教改结题信息 
	 */
	public String deleteEducationalReformRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		researchRecordInfoService.deleteResearchInfo(recordIds, "EducationalReformRecord", 
				"EducationalRecordAward", "EducationalReformData", "record",
				"educationalReformRecord", this.obtainFileBasePath());
		return SUCCESS;
	}
	
	/**
	 * 删除其他教学奖励信息 
	 */
	public String deleteOtherTeachingAwardsRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		researchRecordInfoService.deleteResearchInfo(recordIds, "OtherTeachingAwardsRecord", 
				"OtherTeachingRecordAward", "OtherTeachingAwardsData", "record",
				"otherTeachingAwardsRecord", this.obtainFileBasePath());
		return SUCCESS;
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public ResearchRecordInfoService getResearchRecordInfoService() {
		return researchRecordInfoService;
	}

	public void setResearchRecordInfoService(
			ResearchRecordInfoService researchRecordInfoService) {
		this.researchRecordInfoService = researchRecordInfoService;
	}

	public String getRecordIdString() {
		return recordIdString;
	}

	public void setRecordIdString(String recordIdString) {
		this.recordIdString = recordIdString;
	}
	
	
}
