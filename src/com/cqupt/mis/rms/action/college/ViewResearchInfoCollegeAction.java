/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.model.CourseContribute;
import com.cqupt.mis.rms.model.CourseContributeNew;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeeting;
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesPaper;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesResearchReward;
import com.cqupt.mis.rms.model.MajorContribute;
import com.cqupt.mis.rms.model.MajorContributeNew;
import com.cqupt.mis.rms.model.ScienceBook;
import com.cqupt.mis.rms.model.ScienceGovernmentAward;
import com.cqupt.mis.rms.model.ScienceIpRights;
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.ScienceTechExchange;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechTransfer;
import com.cqupt.mis.rms.model.StudentAwards;
import com.cqupt.mis.rms.model.StudentAwardsNew;
import com.cqupt.mis.rms.model.TeachAchievements;
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理用户查看个人科研信息的Action</p>
*<p>Description:接收用户提交的动作并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ViewResearchInfoCollegeAction extends ActionSupport {
	//注入服务层接口
	private ResearchInfoService researchInfoService;

	public void setResearchInfoService(ResearchInfoService researchInfoService) {
		this.researchInfoService = researchInfoService;
	}
	
	public String obtainUserId(){
		return (String)ActionContext.getContext().getSession().get("userId");
	}
	
	//查看理科论文基本信息
	@SuppressWarnings("unchecked")
	public String viewSciencePaperCollege(){
		List<SciencePaper> sciencePaperList = (List<SciencePaper>)researchInfoService.viewResearchInfo(this.obtainUserId(), "SciencePaper");
		ActionContext.getContext().put("sciencePaperList", sciencePaperList);
		return SUCCESS;
	}
	
	//查看理科活动机构信息
	@SuppressWarnings("unchecked")
	public String viewScienceOrganizationCollege(){
		List<ScienceOrganization> scienceOrganizationList = (List<ScienceOrganization>)researchInfoService.viewResearchInfo(this.obtainUserId(), "ScienceOrganization");
		ActionContext.getContext().put("scienceOrganizationList", scienceOrganizationList);
		return SUCCESS;
	}
	
	//查看理科科技项目基本信息
	@SuppressWarnings("unchecked")
	public String viewScienceTechProjectCollege(){
		List<ScienceTechProject> scienceTechProjectList = (List<ScienceTechProject>)researchInfoService.viewResearchInfo(this.obtainUserId(), "ScienceTechProject");
		ActionContext.getContext().put("scienceTechProjectList", scienceTechProjectList);
		return SUCCESS;
	}
	
	//查看理科著作基本信息
	@SuppressWarnings("unchecked")
	public String viewScienceBookCollege(){
		List<ScienceBook> scienceBookList = (List<ScienceBook>)researchInfoService.viewResearchInfo(this.obtainUserId(), "ScienceBook");
		ActionContext.getContext().put("scienceBookList", scienceBookList);
		return SUCCESS;
	}
	
	//查看理科政府科技奖励基本信息
	@SuppressWarnings("unchecked")
	public String viewScienceGovernmentAwardCollege(){
		List<ScienceGovernmentAward> scienceGovernmentAwardList = (List<ScienceGovernmentAward>)researchInfoService.viewResearchInfo(this.obtainUserId(), "ScienceGovernmentAward");
		ActionContext.getContext().put("scienceGovernmentAwardList", scienceGovernmentAwardList);
		return SUCCESS;
	}
	
	//查看理科知识产权情况信息
	@SuppressWarnings("unchecked")
	public String viewScienceIpRightsCollege(){
		List<ScienceIpRights> scienceIpRightsList = (List<ScienceIpRights>)researchInfoService.viewResearchInfo(this.obtainUserId(), "ScienceIpRights");
		ActionContext.getContext().put("scienceIpRightsList", scienceIpRightsList);
		return SUCCESS;
	}
	
	//查看理科技术转让信息
	@SuppressWarnings("unchecked")
	public String viewScienceTechTransferCollege(){
		List<ScienceTechTransfer> scienceTechTransferList = (List<ScienceTechTransfer>)researchInfoService.viewResearchInfo(this.obtainUserId(), "ScienceTechTransfer");
		ActionContext.getContext().put("scienceTechTransferList", scienceTechTransferList);
		return SUCCESS;
	}
	
	//查看理科科技交流信息
	@SuppressWarnings("unchecked")
	public String viewScienceTechExchangeCollege(){
		List<ScienceTechExchange> scienceTechExchangeList = (List<ScienceTechExchange>)researchInfoService.viewResearchInfo(this.obtainUserId(), "ScienceTechExchange");
		ActionContext.getContext().put("scienceTechExchangeList", scienceTechExchangeList);
		return SUCCESS;
	}
	
	//查看人文社科论文基本信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesPaperCollege(){
		List<HumanitiesPaper> humanitiesPaperList = (List<HumanitiesPaper>)researchInfoService.viewResearchInfo(this.obtainUserId(), "HumanitiesPaper");
		ActionContext.getContext().put("humanitiesPaperList", humanitiesPaperList);
		return SUCCESS;
	}
	
	//查看人文社科著作基本信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesBookCollege(){
		List<HumanitiesBook> humanitiesBookList = (List<HumanitiesBook>)researchInfoService.viewResearchInfo(this.obtainUserId(), "HumanitiesBook");
		ActionContext.getContext().put("humanitiesBookList", humanitiesBookList);
		return SUCCESS;
	}
	
	//查看人文社科项目基本信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesProjectCollege(){
		List<HumanitiesProject> humanitiesProjectList = (List<HumanitiesProject>)researchInfoService.viewResearchInfo(this.obtainUserId(), "HumanitiesProject");
		ActionContext.getContext().put("humanitiesProjectList", humanitiesProjectList);
		return SUCCESS;
	}
	
	//查看人文社科交流论文基本信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesExchangePaperCollege(){
		List<HumanitiesExchangePaper> humanitiesExchangePaperList = (List<HumanitiesExchangePaper>)researchInfoService.viewResearchInfo(this.obtainUserId(), "HumanitiesExchangePaper");
		ActionContext.getContext().put("humanitiesExchangePaperList", humanitiesExchangePaperList);
		return SUCCESS;
	}
	
	//查看人文社科科研获奖基本信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesResearchRewardCollege(){
		List<HumanitiesResearchReward> humanitiesResearchRewardList = (List<HumanitiesResearchReward>)researchInfoService.viewResearchInfo(this.obtainUserId(), "HumanitiesResearchReward");
		ActionContext.getContext().put("humanitiesResearchRewardList", humanitiesResearchRewardList);
		return SUCCESS;
	}
	
	//查看人文社科学术会议基本信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesAcademicMeetingCollege(){
		List<HumanitiesAcademicMeeting> humanitiesAcademicMeetingList = (List<HumanitiesAcademicMeeting>)researchInfoService.viewResearchInfo(this.obtainUserId(), "HumanitiesAcademicMeeting");
		ActionContext.getContext().put("humanitiesAcademicMeetingList", humanitiesAcademicMeetingList);
		return SUCCESS;
	}
	
	//查看专业建设基本信息
	@SuppressWarnings("unchecked")
	public String viewMajorContributeCollege(){
		List<MajorContribute> majorContributeList = (List<MajorContribute>)researchInfoService.viewResearchInfo(this.obtainUserId(), "MajorContribute");
		ActionContext.getContext().put("majorContributeList", majorContributeList);
		return SUCCESS;
	}
	
	//查看课程建设基本信息
	@SuppressWarnings("unchecked")
	public String viewCourseContributeCollege(){
		List<CourseContribute> courseContributeList = (List<CourseContribute>)researchInfoService.viewResearchInfo(this.obtainUserId(), "CourseContribute");
		ActionContext.getContext().put("courseContributeList", courseContributeList);
		return SUCCESS;
	}
	
	//查看教学成果奖基本信息
	@SuppressWarnings("unchecked")
	public String viewTeachAchievementsCollege(){
		List<TeachAchievements> teachAchievementsList = (List<TeachAchievements>)researchInfoService.viewResearchInfo(this.obtainUserId(), "TeachAchievements");
		ActionContext.getContext().put("teachAchievementsList", teachAchievementsList);
		return SUCCESS;
	}
	
	//查看教材立项表信息
	@SuppressWarnings("unchecked")
	public String viewTeachingMaterialSetCollege(){
		List<TeachingMaterialSet> teachingMaterialSetList = (List<TeachingMaterialSet>)researchInfoService.viewResearchInfo(this.obtainUserId(), "TeachingMaterialSet");
		ActionContext.getContext().put("teachingMaterialSetList", teachingMaterialSetList);
		return SUCCESS;
	}
	
	//查看学生获奖基本信息
	@SuppressWarnings("unchecked")
	public String viewStudentAwardsCollege(){
		List<StudentAwards> studentAwardsList = (List<StudentAwards>)researchInfoService.viewResearchInfo(this.obtainUserId(), "StudentAwards");
		ActionContext.getContext().put("studentAwardsList", studentAwardsList);
		return SUCCESS;
	}
	/*****************2014-5-12  黄海燕添加*************************/
	
	//查看教改项目基本信息
	@SuppressWarnings("unchecked")
	public String viewMajorContributeNewCollege(){
		List<MajorContributeNew> majorContributeNewList = (List<MajorContributeNew>)researchInfoService.viewResearchInfo(this.obtainUserId(), "MajorContributeNew");
		ActionContext.getContext().put("majorContributeNewList", majorContributeNewList);
		return SUCCESS;
	}
	
	//查看本科教学工程基本信息
	@SuppressWarnings("unchecked")
	public String viewCourseContributeNewCollege(){
		List<CourseContributeNew> courseContributeNewList = (List<CourseContributeNew>)researchInfoService.viewResearchInfo(this.obtainUserId(), "CourseContributeNew");
		ActionContext.getContext().put("courseContributeNewList", courseContributeNewList);
		return SUCCESS;
	}
	
	//查看发表教改论文基本信息
	@SuppressWarnings("unchecked")
	public String viewTeachAchievementsNewCollege(){
		List<TeachAchievementsNew> teachAchievementsNewList = (List<TeachAchievementsNew>)researchInfoService.viewResearchInfo(this.obtainUserId(), "TeachAchievementsNew");
		ActionContext.getContext().put("teachAchievementsNewList", teachAchievementsNewList);
		return SUCCESS;
	}
	
	//查看教材出版信息
	@SuppressWarnings("unchecked")
	public String viewTeachingMaterialSetNewCollege(){
		List<TeachingMaterialSetNew> teachingMaterialSetNewList = (List<TeachingMaterialSetNew>)researchInfoService.viewResearchInfo(this.obtainUserId(), "TeachingMaterialSetNew");
		ActionContext.getContext().put("teachingMaterialSetNewList", teachingMaterialSetNewList);
		return SUCCESS;
	}
	
	//查看指导学生参赛获奖基本信息
	@SuppressWarnings("unchecked")
	public String viewStudentAwardsNewCollege(){
		List<StudentAwardsNew> studentAwardsNewList = (List<StudentAwardsNew>)researchInfoService.viewResearchInfo(this.obtainUserId(), "StudentAwardsNew");
		ActionContext.getContext().put("studentAwardsNewList", studentAwardsNewList);
		return SUCCESS;
	}
	
	//查看重庆市大学生创新创业训练计划项目基本信息
	@SuppressWarnings("unchecked")
	public String viewTeachAchievementsCQCollege(){
		List<TeachAchievementsCQ> teachAchievementsCQList = (List<TeachAchievementsCQ>)researchInfoService.viewResearchInfo(this.obtainUserId(), "TeachAchievementsCQ");
		ActionContext.getContext().put("teachAchievementsCQList", teachAchievementsCQList);
		return SUCCESS;
	}
	
	
	
}
