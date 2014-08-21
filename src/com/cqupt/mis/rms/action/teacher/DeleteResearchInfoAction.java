/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.teacher;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.TypeConvert;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理用户删除个人科研信息的Action</p>
*<p>Description:接收用户提交的动作并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings({ "serial", "deprecation" })
public class DeleteResearchInfoAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private ResearchInfoService researchInfoService;
	private String infoIds;
	private ServletContext servletContext;
	private InputStream inputStream;
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setResearchInfoService(ResearchInfoService researchInfoService) {
		this.researchInfoService = researchInfoService;
	}
	
	public void setInfoIds(String infoIds) {
		this.infoIds = infoIds;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public String obtainFileBasePath(){
		String fileBasePath = servletContext.getRealPath("") + "\\";
		return fileBasePath;
	}
	
	//删除旁证材料
	public String deleteProof(){
		String[] proofIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteProof(proofIds, this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除理科论文信息
	public String deleteSciencePaper(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "SciencePaper",
				"paperId", "SciencePaperAuthor", "sciencePaper", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除理科活动机构信息
	public String deleteScienceOrganization(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "ScienceOrganization", 
				"organizationId", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除理科科技项目信息
	public String deleteScienceTechProject(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "ScienceTechProject", "projectId", 
				"ScienceDetailTechProject", "scienceTechProject", "ScienceTechProjectMember", 
				"project", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除理科著作信息
	public String deleteScienceBook(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "ScienceBook", "bookId", 
				"ScienceBookAuthor", "scienceBook", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除理科政府科技奖励信息
	public String deleteScienceGovernmentAward(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "ScienceGovernmentAward", "awardId", 
				"ScienceGovAwardPerson", "scienceGovernmentAward", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除理科知识产权信息
	public String deleteScienceIpRights(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "ScienceIpRights", "rightsId", 
				"ScienceInventors", "scienceIpRights", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除理科技术转让信息
	public String deleteScienceTechTransfer(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "ScienceTechTransfer", 
				"transferId", "ScienceTransferLeader", "scienceTechTransfer", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除理科科技交流信息
	public String deleteScienceTechExchange(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "ScienceTechExchange", "techExchangeId", 
				"ScienceTechAttendPerson", "scienceTechExchange", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除人文社科论文信息
	public String deleteHumanitiesPaper(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "HumanitiesPaper", "paperId", 
				"HumanitiesPaperAuthor", "humanitiesPaper", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除人文社科著作信息
	public String deleteHumanitiesBook(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "HumanitiesBook", "bookId", 
				"HumanitiesBookAuthor", "humanitiesBook", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除人文社科项目信息
	public String deleteHumanitiesProject(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "HumanitiesProject", "projectId", 
				"HumanitiesProjectDetail", "humanitiesProject", "HumanitiesProjectMember", 
				"humanitiesProject", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除人文社科交流论文信息
	public String deleteHumanitiesExchangePaper(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "HumanitiesExchangePaper", 
				"exchangePaperId", "HumanitiesExchangePaperAuthor", "humanitiesExchangePaper", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除人文社科科研获奖信息
	public String deleteHumanitiesResearchReward(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "HumanitiesResearchReward", 
				"researchRewardId", "HumanitiesResearchRewardPerson", "humanitiesResearchReward", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除人文社科学术会议信息
	public String deleteHumanitiesAcademicMeeting(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "HumanitiesAcademicMeeting", 
				"academicMeetingId", "HumanitiesAcademicMeetingPerson", "humanitiesAcademicMeeting", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除专业建设信息
	public String deleteMajorContribute(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "MajorContribute", 
				"majorId", "MajorContributeMember", "majorContribute", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除课程建设信息
	public String deleteCourseContribute(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "CourseContribute", 
				"courseId", "CourseContributeMember", "courseContribute", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除教学成果奖信息
	public String deleteTeachAchievements(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "TeachAchievements", 
				"achievementsId", "TeachersAwards", "teachAchievements", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除教材立项信息
	public String deleteTeachingMaterialSet(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "TeachingMaterialSet", 
				"teachingMaterialId", "TeachingMaterialEditor", "teachingMaterialSet", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除学生获奖信息
	public String deleteStudentAwards(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "StudentAwards", "awardsId", 
				"StudentInstructor", "studentAwards", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}

	/***************************************************************************************/
	
	
	//删除教改项目信息
	public String deleteMajorContributeNew(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "MajorContributeNew", 
				"majorId", "MajorContributeMemberNew", "majorContributeNew", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除本科教学工程信息
	public String deleteCourseContributeNew(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "CourseContributeNew", 
				"courseId", "CourseContributeMemberNew", "courseContributeNew", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除发表教改论文信息
	public String deleteTeachAchievementsNew(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "TeachAchievementsNew", 
				"achievementsId", "TeachersAwardsNew", "teachAchievementsNew", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除教材出版息
	public String deleteTeachingMaterialSetNew(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "TeachingMaterialSetNew", 
				"teachingMaterialId", "TeachingMaterialEditorNew", "teachingMaterialSetNew", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除指导学生参赛获奖信息
	public String deleteStudentAwardsNew(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "StudentAwardsNew", "awardsId", 
				"StudentInstructorNew", "studentAwardsNew", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
	
	//删除重庆市大学生创新创业训练计划项目信息
	public String deleteTeachAchievementsCQ(){
		String[] researchIds = TypeConvert.StringToStringArrayByComma(infoIds);
		boolean result = researchInfoService.deleteResearchInfo(researchIds, "TeachAchievementsCQ", 
				"achievementsId", "TeachAchievementsDeclarant", "teachAchievementsCQ", this.obtainFileBasePath());
		inputStream = new StringBufferInputStream(""+result);
		return SUCCESS;
	}
}
