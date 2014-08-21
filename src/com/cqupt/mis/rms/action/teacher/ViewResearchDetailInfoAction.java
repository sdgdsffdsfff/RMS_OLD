/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.teacher;

import java.util.List;

import com.cqupt.mis.rms.manager.ResearchInfoDao;
import com.cqupt.mis.rms.model.CourseContribute;
import com.cqupt.mis.rms.model.CourseContributeMember;
import com.cqupt.mis.rms.model.CourseContributeNew;
import com.cqupt.mis.rms.model.CourseContributeMemberNew;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeeting;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeetingPerson;
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesBookAuthor;
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesExchangePaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesPaper;
import com.cqupt.mis.rms.model.HumanitiesPaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.HumanitiesProjectMember;
import com.cqupt.mis.rms.model.HumanitiesResearchReward;
import com.cqupt.mis.rms.model.HumanitiesResearchRewardPerson;
import com.cqupt.mis.rms.model.MajorContribute;
import com.cqupt.mis.rms.model.MajorContributeMember;
import com.cqupt.mis.rms.model.MajorContributeNew;
import com.cqupt.mis.rms.model.MajorContributeMemberNew;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.ScienceBook;
import com.cqupt.mis.rms.model.ScienceBookAuthor;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;
import com.cqupt.mis.rms.model.ScienceGovAwardPerson;
import com.cqupt.mis.rms.model.ScienceGovernmentAward;
import com.cqupt.mis.rms.model.ScienceInventors;
import com.cqupt.mis.rms.model.ScienceIpRights;
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.model.ScienceTechAttendPerson;
import com.cqupt.mis.rms.model.ScienceTechExchange;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechProjectMember;
import com.cqupt.mis.rms.model.ScienceTechTransfer;
import com.cqupt.mis.rms.model.ScienceTransferLeader;
import com.cqupt.mis.rms.model.StudentAwards;
import com.cqupt.mis.rms.model.StudentAwardsNew;
import com.cqupt.mis.rms.model.StudentInstructor;
import com.cqupt.mis.rms.model.StudentInstructorNew;
import com.cqupt.mis.rms.model.TeachAchievements;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.model.TeachAchievementsDeclarant;
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachersAwards;
import com.cqupt.mis.rms.model.TeachersAwardsNew;
import com.cqupt.mis.rms.model.TeachingMaterialEditor;
import com.cqupt.mis.rms.model.TeachingMaterialEditorNew;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理用户查看详细科研信息的Action</p>
*<p>Description:接收用户提交的动作并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ViewResearchDetailInfoAction extends ActionSupport {
	//注入接口
	private ResearchInfoDao researchInfoDao;
	
	private String infoid;
	private String flag;

	public void setResearchInfoDao(ResearchInfoDao researchInfoDao) {
		this.researchInfoDao = researchInfoDao;
	}

	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}
	
	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	//查看理科论文详细信息
	@SuppressWarnings("unchecked")
	public String viewSciencePaperDetail(){
		try {
			SciencePaper sciencePaper = (SciencePaper)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "SciencePaper", "paperId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<SciencePaperAuthor> memberList = (List<SciencePaperAuthor>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "SciencePaperAuthor", "sciencePaper.paperId");
			ActionContext.getContext().put("sciencePaper", sciencePaper);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	//查看理科活动机构详细信息
	public String viewScienceOrganizationDetail(){
		try {
			ScienceOrganization scienceOrganization = (ScienceOrganization)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "ScienceOrganization", "organizationId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			ActionContext.getContext().put("scienceOrganization", scienceOrganization);
			ActionContext.getContext().put("proofs", proofs);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	//查看理科科技项目详细信息
	@SuppressWarnings("unchecked")
	public String viewScienceTechProjectDetail(){
		try {
			ScienceTechProject scienceTechProject = (ScienceTechProject)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "ScienceTechProject", "projectId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<ScienceDetailTechProject> scienceDetailTechProject = (List<ScienceDetailTechProject>)
					researchInfoDao.findDetailByIdAndModelNameAndFactor(infoid, "ScienceDetailTechProject", "scienceTechProject.projectId");
			List<ScienceTechProjectMember> memberList = (List<ScienceTechProjectMember>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "ScienceTechProjectMember", "project.projectId");
			ActionContext.getContext().put("scienceTechProject", scienceTechProject);
			ActionContext.getContext().put("scienceDetailTechProject", scienceDetailTechProject);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看理科著作详细信息
	@SuppressWarnings("unchecked")
	public String viewScienceBookDetail(){
		try {
			ScienceBook scienceBook = (ScienceBook)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "ScienceBook", "bookId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<ScienceBookAuthor> memberList = (List<ScienceBookAuthor>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "ScienceBookAuthor", "scienceBook.bookId");
			ActionContext.getContext().put("scienceBook", scienceBook);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看理科政府科技奖励详细信息
	@SuppressWarnings("unchecked")
	public String viewScienceGovernmentAwardDetail(){
		try {
			ScienceGovernmentAward scienceGovernmentAward = (ScienceGovernmentAward)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "ScienceGovernmentAward", "awardId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<ScienceGovAwardPerson> memberList = (List<ScienceGovAwardPerson>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "ScienceGovAwardPerson", "scienceGovernmentAward.awardId");
			ActionContext.getContext().put("scienceGovernmentAward", scienceGovernmentAward);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看理科知识产权详细信息
	@SuppressWarnings("unchecked")
	public String viewScienceIpRightsDetail(){
		try {
			ScienceIpRights scienceIpRights = (ScienceIpRights)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "ScienceIpRights", "rightsId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<ScienceInventors> memberList = (List<ScienceInventors>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "ScienceInventors", "scienceIpRights.rightsId");
			ActionContext.getContext().put("scienceIpRights", scienceIpRights);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看理科技术转让详细信息
	@SuppressWarnings("unchecked")
	public String viewScienceTechTransferDetail(){
		try {
			ScienceTechTransfer scienceTechTransfer = (ScienceTechTransfer)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "ScienceTechTransfer", "transferId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<ScienceTransferLeader> memberList = (List<ScienceTransferLeader>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "ScienceTransferLeader", "scienceTechTransfer.transferId");
			ActionContext.getContext().put("scienceTechTransfer", scienceTechTransfer);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	//查看理科科技交流详细信息
	@SuppressWarnings("unchecked")
	public String viewScienceTechExchangeDetail(){
		try {
			ScienceTechExchange scienceTechExchange = (ScienceTechExchange)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "ScienceTechExchange", "techExchangeId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<ScienceTechAttendPerson> memberList = (List<ScienceTechAttendPerson>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "ScienceTechAttendPerson", "scienceTechExchange.techExchangeId");
			ActionContext.getContext().put("scienceTechExchange", scienceTechExchange);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看人文社科论文详细信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesPaperDetail(){
		try {
			HumanitiesPaper humanitiesPaper = (HumanitiesPaper)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "HumanitiesPaper", "paperId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<HumanitiesPaperAuthor> memberList = (List<HumanitiesPaperAuthor>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "HumanitiesPaperAuthor", "humanitiesPaper.paperId");
			ActionContext.getContext().put("humanitiesPaper", humanitiesPaper);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看人文社科著作详细信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesBookDetail(){
		try {
			HumanitiesBook humanitiesBook = (HumanitiesBook)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "HumanitiesBook", "bookId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<HumanitiesBookAuthor> memberList = (List<HumanitiesBookAuthor>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "HumanitiesBookAuthor", "humanitiesBook.bookId");
			ActionContext.getContext().put("humanitiesBook", humanitiesBook);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看人文社科项目详细信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesProjectDetail(){
		try {
			HumanitiesProject humanitiesProject = (HumanitiesProject)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "HumanitiesProject", "projectId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<HumanitiesProjectDetail> humanitiesProjectDetail = (List<HumanitiesProjectDetail>)
					researchInfoDao.findDetailByIdAndModelNameAndFactor(infoid, "HumanitiesProjectDetail", "humanitiesProject.projectId");
			List<HumanitiesProjectMember> memberList = (List<HumanitiesProjectMember>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "HumanitiesProjectMember", "humanitiesProject.projectId");
			ActionContext.getContext().put("humanitiesProject", humanitiesProject);
			ActionContext.getContext().put("humanitiesProjectDetail", humanitiesProjectDetail);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	//查看人文社科交流论文详细信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesExchangePaperDetail(){
		try {
			HumanitiesExchangePaper humanitiesExchangePaper = (HumanitiesExchangePaper)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "HumanitiesExchangePaper", "exchangePaperId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<HumanitiesExchangePaperAuthor> memberList = (List<HumanitiesExchangePaperAuthor>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "HumanitiesExchangePaperAuthor", "humanitiesExchangePaper.exchangePaperId");
			ActionContext.getContext().put("humanitiesExchangePaper", humanitiesExchangePaper);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看人文社科科研获奖详细信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesResearchRewardDetail(){
		try {
			HumanitiesResearchReward humanitiesResearchReward = (HumanitiesResearchReward)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "HumanitiesResearchReward", "researchRewardId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<HumanitiesResearchRewardPerson> memberList = (List<HumanitiesResearchRewardPerson>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "HumanitiesResearchRewardPerson", "humanitiesResearchReward.researchRewardId");
			ActionContext.getContext().put("humanitiesResearchReward", humanitiesResearchReward);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看人文社科学术会议详细信息
	@SuppressWarnings("unchecked")
	public String viewHumanitiesAcademicMeetingDetail(){
		try {
			HumanitiesAcademicMeeting humanitiesAcademicMeeting = (HumanitiesAcademicMeeting)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "HumanitiesAcademicMeeting", "academicMeetingId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<HumanitiesAcademicMeetingPerson> memberList = (List<HumanitiesAcademicMeetingPerson>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "HumanitiesAcademicMeetingPerson", "humanitiesAcademicMeeting.academicMeetingId");
			ActionContext.getContext().put("humanitiesAcademicMeeting", humanitiesAcademicMeeting);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	

	//查看专业建设详细信息
	@SuppressWarnings("unchecked")
	public String viewMajorContributeDetail(){
		try {
			MajorContribute majorContribute = (MajorContribute)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "MajorContribute", "majorId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<MajorContributeMember> memberList = (List<MajorContributeMember>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "MajorContributeMember", "majorContribute.majorId");
			ActionContext.getContext().put("majorContribute", majorContribute);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看课程建设详细信息
	@SuppressWarnings("unchecked")
	public String viewCourseContributeDetail(){
		try {
			CourseContribute courseContribute = (CourseContribute)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "CourseContribute", "courseId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<CourseContributeMember> memberList = (List<CourseContributeMember>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "CourseContributeMember", "courseContribute.courseId");
			ActionContext.getContext().put("courseContribute", courseContribute);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看教学成果奖详细信息
	@SuppressWarnings("unchecked")
	public String viewTeachAchievementsDetail(){
		try {
			TeachAchievements teachAchievements = (TeachAchievements)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "TeachAchievements", "achievementsId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<TeachersAwards> memberList = (List<TeachersAwards>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "TeachersAwards", "teachAchievements.achievementsId");
			ActionContext.getContext().put("teachAchievements", teachAchievements);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看教材立项详细信息
	@SuppressWarnings("unchecked")
	public String viewTeachingMaterialSetDetail(){
		try {
			TeachingMaterialSet teachingMaterialSet = (TeachingMaterialSet)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "TeachingMaterialSet", "teachingMaterialId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<TeachingMaterialEditor> memberList = (List<TeachingMaterialEditor>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "TeachingMaterialEditor", "teachingMaterialSet.teachingMaterialId");
			ActionContext.getContext().put("teachingMaterialSet", teachingMaterialSet);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看学生获奖详细信息
	@SuppressWarnings("unchecked")
	public String viewStudentAwardsDetail(){
		try {
			StudentAwards studentAwards = (StudentAwards)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "StudentAwards", "awardsId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<StudentInstructor> memberList = (List<StudentInstructor>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "StudentInstructor", "studentAwards.awardsId");
			ActionContext.getContext().put("studentAwards", studentAwards);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	//****************************************************//
	//查看教改项目详细信息
	@SuppressWarnings("unchecked")
	public String viewMajorContributeNewDetail(){
		try {
			MajorContributeNew majorContributeNew = (MajorContributeNew)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "MajorContributeNew", "majorId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<MajorContributeMemberNew> memberList = (List<MajorContributeMemberNew>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "MajorContributeMemberNew", "majorContributeNew.majorId");
			ActionContext.getContext().put("majorContributeNew", majorContributeNew);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看本科教学工程详细信息
	@SuppressWarnings("unchecked")
	public String viewCourseContributeNewDetail(){
		try {
			CourseContributeNew CourseContributeNew = (CourseContributeNew)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "CourseContributeNew", "courseId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<CourseContributeMemberNew> memberList = (List<CourseContributeMemberNew>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "CourseContributeMemberNew", "courseContributeNew.courseId");
			ActionContext.getContext().put("CourseContributeNew", CourseContributeNew);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看发表教改论文详细信息
	@SuppressWarnings("unchecked")
	public String viewTeachAchievementsNewDetail(){
		try {
			TeachAchievementsNew teachAchievementsNew = (TeachAchievementsNew)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "TeachAchievementsNew", "achievementsId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<TeachersAwardsNew> memberList = (List<TeachersAwardsNew>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "TeachersAwardsNew", "teachAchievementsNew.achievementsId");
			ActionContext.getContext().put("teachAchievementsNew", teachAchievementsNew);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//查看教材出版信息
	@SuppressWarnings("unchecked")
	public String viewTeachingMaterialSetNewDetail(){
		try {
			TeachingMaterialSetNew TeachingMaterialSetNew = (TeachingMaterialSetNew)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "TeachingMaterialSetNew", "teachingMaterialId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<TeachingMaterialEditorNew> memberList = (List<TeachingMaterialEditorNew>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "TeachingMaterialEditorNew", "teachingMaterialSetNew.teachingMaterialId");
			ActionContext.getContext().put("TeachingMaterialSetNew", TeachingMaterialSetNew);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//指导学生参赛获奖
	@SuppressWarnings("unchecked")
	public String viewStudentAwardsNewDetail(){
		try {
			StudentAwardsNew studentAwardsNew = (StudentAwardsNew)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "StudentAwardsNew", "awardsId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<StudentInstructorNew> memberList = (List<StudentInstructorNew>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "StudentInstructorNew", "studentAwardsNew.awardsId");
			ActionContext.getContext().put("studentAwardsNew", studentAwardsNew);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	//查看重庆市大学生创新创业训练计划项目详细信息
	@SuppressWarnings("unchecked")
	public String viewTeachAchievementsCQDetail(){
		try {
			
			TeachAchievementsCQ teachAchievementsCQ = (TeachAchievementsCQ)researchInfoDao.
					findResearchInfoByIdAndModelNameAndFactor(infoid, "TeachAchievementsCQ", "achievementsId");
			List<Proofs> proofs = researchInfoDao.findProofByApprovedId(infoid);
			List<TeachAchievementsDeclarant> memberList = (List<TeachAchievementsDeclarant>)researchInfoDao.
					findMemberByIdAndModelNameAndFactor(infoid, "TeachAchievementsDeclarant", "teachAchievementsCQ.achievementsId");
			ActionContext.getContext().put("teachAchievementsCQ", teachAchievementsCQ);
			ActionContext.getContext().put("proofs", proofs);
			ActionContext.getContext().put("memberList", memberList);
			if("modify".equals(flag)){
				return "modify";
			}else{
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	

}
