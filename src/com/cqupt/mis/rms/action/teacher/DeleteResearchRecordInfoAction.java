package com.cqupt.mis.rms.action.teacher;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
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
	public void deleteStudentAwardsRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		boolean result = researchRecordInfoService.deleteResearchInfo(recordIds, "StudentAwardsRecord", 
				"StudentRecordInstructor", "StudentAwardsData", "awards",
				"studentAwardsRecord", this.obtainFileBasePath());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(result) {				
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除教学成果奖信息 
	 */
	public void deleteTeacherAwardsRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		boolean result = researchRecordInfoService.deleteResearchInfo(recordIds, "TeachersAwardsRecord", 
				"TeachersRecordAchievements", "TeachersAwardsData", "awards",
				"teachersAwardsRecord", this.obtainFileBasePath());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(result) {				
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除专业建设信息 
	 */
	public void deleteMajorContributeRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		boolean result = researchRecordInfoService.deleteResearchInfo(recordIds, "MajorContributeRecord", 
				"MajorRecordMember", "MajorContributeData", "record",
				"majorContributeRecord", this.obtainFileBasePath());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(result) {				
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除教材立项信息 
	 */
	public void deleteTeachingMaterialRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		boolean result = researchRecordInfoService.deleteResearchInfo(recordIds, "TeachingMaterialRecord", 
				"TeachingRecordEditor", "TeachingMaterialData", "record",
				"teachingMaterialRecord", this.obtainFileBasePath());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(result) {				
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	}
	
	/**
	 * 删除优秀培训师信息 
	 */
	public void deleteExcellentTrainerRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		boolean result = researchRecordInfoService.deleteResearchInfo(recordIds, "ExcellentTrainerRecord", 
				"ExcellentRecordAward", "ExcellentTrainerData", "record",
				"excellentTrainerRecord", this.obtainFileBasePath());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(result) {				
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除质量工程信息 
	 */
	public void deleteQualityProjectRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		boolean result = researchRecordInfoService.deleteResearchInfo(recordIds, "QualityProjectRecord", 
				"QualityRecordAward", "QualityProjectData", "record",
				"qualityProjectRecord", this.obtainFileBasePath());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(result) {				
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	}
	
	/**
	 * 删除学评教信息 
	 */
	public void deleteLearningEvaluationRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		boolean result = researchRecordInfoService.deleteResearchInfo(recordIds, "LearningEvaluationRecord", 
				"LearningRecordAward", "LearningEvaluationData", "record",
				"learningEvaluationRecord", this.obtainFileBasePath());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(result) {				
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 删除教改结题信息 
	 */
	public void deleteEducationalReformRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		boolean result = researchRecordInfoService.deleteResearchInfo(recordIds, "EducationalReformRecord", 
				"EducationalRecordAward", "EducationalReformData", "record",
				"educationalReformRecord", this.obtainFileBasePath());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(result) {				
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * 删除其他教学奖励信息 
	 */
	public void deleteOtherTeachingAwardsRecord() {
		String[] recordIds = TypeConvert.StringToStringArrayByComma(recordIdString);
		boolean result = researchRecordInfoService.deleteResearchInfo(recordIds, "OtherTeachingAwardsRecord", 
				"OtherTeachingRecordAward", "OtherTeachingAwardsData", "record",
				"otherTeachingAwardsRecord", this.obtainFileBasePath());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(result) {				
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
