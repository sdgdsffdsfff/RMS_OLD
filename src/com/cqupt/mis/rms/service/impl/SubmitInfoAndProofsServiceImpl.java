/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SubmitInfoAndProofsDao;
import com.cqupt.mis.rms.manager.SubmitInfoMemberDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.CourseContributeMember;
import com.cqupt.mis.rms.model.CourseContributeMemberNew;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeetingPerson;
import com.cqupt.mis.rms.model.HumanitiesBookAuthor;
import com.cqupt.mis.rms.model.HumanitiesExchangePaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesPaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesProjectMember;
import com.cqupt.mis.rms.model.HumanitiesResearchRewardPerson;
import com.cqupt.mis.rms.model.MajorContributeMember;
import com.cqupt.mis.rms.model.MajorContributeMemberNew;
import com.cqupt.mis.rms.model.MajorRecordMember;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.ScienceBookAuthor;
import com.cqupt.mis.rms.model.ScienceGovAwardPerson;
import com.cqupt.mis.rms.model.ScienceInventors;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.model.ScienceTechAttendPerson;
import com.cqupt.mis.rms.model.ScienceTechProjectMember;
import com.cqupt.mis.rms.model.ScienceTransferLeader;
import com.cqupt.mis.rms.model.StudentInstructor;
import com.cqupt.mis.rms.model.StudentInstructorNew;
import com.cqupt.mis.rms.model.StudentRecordInstructor;
import com.cqupt.mis.rms.model.TeachAchievementsDeclarant;
import com.cqupt.mis.rms.model.TeachersAwards;
import com.cqupt.mis.rms.model.TeachersAwardsNew;
import com.cqupt.mis.rms.model.TeachersRecordAchievements;
import com.cqupt.mis.rms.model.TeachingMaterialEditor;
import com.cqupt.mis.rms.model.TeachingMaterialEditorNew;
import com.cqupt.mis.rms.model.TeachingRecordEditor;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.GenerateUtils;

/**
*<p>Title:管理各类科研信息总包含基本信息及旁证材料（包括参与成员）的实现类</p>
*<p>Description:处理用户对科研信息的业务逻辑</p>
*@author LvHai
*@version 1.0
*/
public class SubmitInfoAndProofsServiceImpl implements SubmitInfoAndProofsService {
	//注入管理各类科研信息的底层接口
	private SubmitInfoAndProofsDao submitInfoAndProofsDao;
	private SubmitInfoMemberDao submitInfoMemberDao;
	
	public void setSubmitInfoMemberDao(SubmitInfoMemberDao submitInfoMemberDao) {
		this.submitInfoMemberDao = submitInfoMemberDao;
	}
	public void setSubmitInfoAndProofsDao(
			SubmitInfoAndProofsDao submitInfoAndProofsDao) {
		this.submitInfoAndProofsDao = submitInfoAndProofsDao;
	}

	@Override
	public boolean submitInfo(Object object) {
		// TODO Auto-generated method stub
		if(object != null){
			return submitInfoAndProofsDao.addInfo(object);
		}else{
			return false;
		}
	}

	@Override
	public boolean submitProofs(List<Proofs> proofs) {
		// TODO Auto-generated method stub
		try {
			if(!proofs.isEmpty()){
				for (int i = 0; i < proofs.size(); i++) {
					Proofs proof = proofs.get(i);
					submitInfoAndProofsDao.addProof(proof);
				}
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean submitResearchMemberInfo(int flag, Object memberListObject) {
		try {
			//添加新的成员信息
			switch(flag){
			case 1:
				List<SciencePaperAuthor> sciencePaperAuthors = (List<SciencePaperAuthor>)memberListObject;
				this.submitSciencePaperAuthors(sciencePaperAuthors);
				break;
			case 2:
				List<ScienceTechProjectMember> scienceTechProjectMembers = (List<ScienceTechProjectMember>)memberListObject;
				this.submitScienceTechProjectMembers(scienceTechProjectMembers);
				break;
			case 3:
				List<ScienceBookAuthor> scienceBookAuthors = (List<ScienceBookAuthor>)memberListObject;
				this.submitScienceBookAuthors(scienceBookAuthors);
				break;
			case 4:
				List<ScienceGovAwardPerson> scienceGovAwardPersons = (List<ScienceGovAwardPerson>)memberListObject;
				this.submitScienceGovAwardPersons(scienceGovAwardPersons);
				break;
			case 5:
				List<ScienceInventors> scienceInventors = (List<ScienceInventors>)memberListObject;
				this.submitScienceInventors(scienceInventors);
				break;
			case 6:
				List<ScienceTechAttendPerson> scienceTechAttendPersons = (List<ScienceTechAttendPerson>)memberListObject;
				this.submitScienceTechAttendPersons(scienceTechAttendPersons);
				break;
			case 7:
				List<HumanitiesPaperAuthor> humanitiesPaperAuthors = (List<HumanitiesPaperAuthor>)memberListObject;
				this.submitHumanitiesPaperAuthors(humanitiesPaperAuthors);
				break;
			case 8:
				List<HumanitiesBookAuthor> humanitiesBookAuthors = (List<HumanitiesBookAuthor>)memberListObject;
				this.submitHumanitiesBookAuthors(humanitiesBookAuthors);
				break;
			case 9:
				List<HumanitiesProjectMember> humanitiesProjectMembers = (List<HumanitiesProjectMember>)memberListObject;
				this.submitHumanitiesProjectMembers(humanitiesProjectMembers);
				break;
			case 10:
				List<HumanitiesExchangePaperAuthor> humanitiesExchangePaperAuthors = (List<HumanitiesExchangePaperAuthor>)memberListObject;
				this.submitHumanitiesExchangePaperAuthors(humanitiesExchangePaperAuthors);
				break;
			case 11:
				List<HumanitiesResearchRewardPerson> humanitiesResearchRewardPersons = (List<HumanitiesResearchRewardPerson>)memberListObject;
				this.submitHumanitiesResearchRewardPersons(humanitiesResearchRewardPersons);
				break;
			case 12:
				List<HumanitiesAcademicMeetingPerson> humanitiesAcademicMeetingPersons = (List<HumanitiesAcademicMeetingPerson>)memberListObject;
				this.submitHumanitiesAcademicMeetingPersons(humanitiesAcademicMeetingPersons);
				break;
			case 13:
				List<MajorContributeMember> majorContributeMembers = (List<MajorContributeMember>)memberListObject;
				this.submitMajorContributeMembers(majorContributeMembers);
				break;
			case 14:
				List<CourseContributeMember> courseContributeMembers = (List<CourseContributeMember>)memberListObject;
				this.submitCourseContributeMembers(courseContributeMembers);
				break;
			case 15:
				List<TeachersAwards> teachersAwards = (List<TeachersAwards>)memberListObject;
				this.submitTeachersAwards(teachersAwards);
				break;
			case 16:
				List<StudentInstructor> studentInstructors = (List<StudentInstructor>)memberListObject;
				this.submitStudentInstructors(studentInstructors);
				break;
			case 17:
				//教材立项成员信息
				List<TeachingMaterialEditor> teachingMaterialEditors = (List<TeachingMaterialEditor>)memberListObject;
				this.submitTeachingMaterialEditor(teachingMaterialEditors);
				break;
			case 18:
				//技术转让负责人信息
				List<ScienceTransferLeader> scienceTransferLeaders = (List<ScienceTransferLeader>)memberListObject;
				this.submitScienceTransferLeader(scienceTransferLeaders);
				break;
				
			/*****************2013-8-10 15:24  黄海燕添加*************************************************************/
			case 19:
				List<TeachAchievementsDeclarant> teachAchievementsDeclarants = (List<TeachAchievementsDeclarant>)memberListObject;
				this.submitTeachAchievementsDeclarant(teachAchievementsDeclarants);
				break;
				
			case 20:
				List<MajorContributeMemberNew> majorContributeMembersNew = (List<MajorContributeMemberNew>)memberListObject;
				this.submitMajorContributeMembersNew(majorContributeMembersNew);
				break;
			case 21:
				List<CourseContributeMemberNew> courseContributeMembersNew = (List<CourseContributeMemberNew>)memberListObject;
				this.submitCourseContributeMembersNew(courseContributeMembersNew);
				break;
			case 22:
				List<TeachersAwardsNew> teachersAwardsNew = (List<TeachersAwardsNew>)memberListObject;
				this.submitTeachersAwardsNew(teachersAwardsNew);
				break;
			case 23:
				List<StudentInstructorNew> studentInstructorsNew = (List<StudentInstructorNew>)memberListObject;
				this.submitStudentInstructorsNew(studentInstructorsNew);
				break;
			case 24:
				//教材立项成员信息
				List<TeachingMaterialEditorNew> teachingMaterialEditorsNew = (List<TeachingMaterialEditorNew>)memberListObject;
				this.submitTeachingMaterialEditorNew(teachingMaterialEditorsNew);
				break;
			
			/*****************2014.10.6  Bern添加*************************************************************/
			case 25:
				//学生获奖指导教师信息
				List<StudentRecordInstructor> StudentRecordInstructors = (List<StudentRecordInstructor>)memberListObject;
				this.submitStudentRecordInstructors(StudentRecordInstructors);
				break;
			/*****************2014.10.07   liu添加*************************************************************/	
			case 26:
				//教学成果奖获奖老师信息
				List<TeachersRecordAchievements> teachersRecordAchievementsList =(List<TeachersRecordAchievements>)memberListObject ;
				this.submitTeachersRecordAchievements(teachersRecordAchievementsList);
				break;
			case 28:
				//专业建设负责人信息
				List<MajorRecordMember> majorRecordMembers = (List<MajorRecordMember>)memberListObject;
				this.submitMajorRecordMembers(majorRecordMembers);
				break;
			case 29:
				//教材立项作者信息
				List<TeachingRecordEditor> teachingRecordEditors = (List<TeachingRecordEditor>)memberListObject;
				this.submitTeachingRecordEditors(teachingRecordEditors);
				break;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void submitSciencePaperAuthors(
			List<SciencePaperAuthor> sciencePaperAuthors) {
		if(!sciencePaperAuthors.isEmpty()){
			for (int i = 0; i < sciencePaperAuthors.size(); i++) {
				SciencePaperAuthor sciencePaperAuthor = sciencePaperAuthors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(sciencePaperAuthor.getMemberName());
				sciencePaperAuthor.setOrders(i + 1);
				if(cquptUser != null){
					sciencePaperAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					sciencePaperAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(sciencePaperAuthor);
			}
		}
	}
	
	public void submitScienceTechProjectMembers(
			List<ScienceTechProjectMember> scienceTechProjectMembers) {
		if(!scienceTechProjectMembers.isEmpty()){
			for (int i = 0; i < scienceTechProjectMembers.size(); i++) {
				ScienceTechProjectMember scienceTechProjectMember = scienceTechProjectMembers.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(scienceTechProjectMember.getMemberName());
				scienceTechProjectMember.setOrders(i + 1);
				if(cquptUser != null){
					scienceTechProjectMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceTechProjectMember.setMemberId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(scienceTechProjectMember);
			}
		}
	}
	
	public void submitCourseContributeMembers(
			List<CourseContributeMember> courseContributeMembers) {
		if(!courseContributeMembers.isEmpty()){
			for (int i = 0; i < courseContributeMembers.size(); i++) {
				CourseContributeMember courseContributeMember = courseContributeMembers.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(courseContributeMember.getMemberName());
				courseContributeMember.setOrders(i + 1);
				if(cquptUser != null){
					courseContributeMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					courseContributeMember.setMemberId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(courseContributeMember);
			}
		}
	}
	
	public void submitHumanitiesAcademicMeetingPersons(
			List<HumanitiesAcademicMeetingPerson> humanitiesAcademicMeetingPersons) {
		if(!humanitiesAcademicMeetingPersons.isEmpty()){
			for (int i = 0; i < humanitiesAcademicMeetingPersons.size(); i++) {
				HumanitiesAcademicMeetingPerson humanitiesAcademicMeetingPerson = humanitiesAcademicMeetingPersons.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(humanitiesAcademicMeetingPerson.getMeetingPersonName());
				humanitiesAcademicMeetingPerson.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesAcademicMeetingPerson.setMeetingPersonId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesAcademicMeetingPerson.setMeetingPersonId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(humanitiesAcademicMeetingPerson);
			}
		}
	}
	
	public void submitHumanitiesBookAuthors(
			List<HumanitiesBookAuthor> humanitiesBookAuthors) {
		if(!humanitiesBookAuthors.isEmpty()){
			for (int i = 0; i < humanitiesBookAuthors.size(); i++) {
				HumanitiesBookAuthor humanitiesBookAuthor = humanitiesBookAuthors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(humanitiesBookAuthor.getAuthorName());
				humanitiesBookAuthor.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesBookAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesBookAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(humanitiesBookAuthor);
			}
		}
	}
	
	public void submitHumanitiesExchangePaperAuthors(
			List<HumanitiesExchangePaperAuthor> humanitiesExchangePaperAuthors) {
		if(!humanitiesExchangePaperAuthors.isEmpty()){
			for (int i = 0; i < humanitiesExchangePaperAuthors.size(); i++) {
				HumanitiesExchangePaperAuthor humanitiesExchangePaperAuthor = humanitiesExchangePaperAuthors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(humanitiesExchangePaperAuthor.getAuthorName());
				humanitiesExchangePaperAuthor.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesExchangePaperAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesExchangePaperAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(humanitiesExchangePaperAuthor);
			}
		}
	}
	
	public void submitHumanitiesPaperAuthors(
			List<HumanitiesPaperAuthor> humanitiesPaperAuthors) {
		if(!humanitiesPaperAuthors.isEmpty()){
			for (int i = 0; i < humanitiesPaperAuthors.size(); i++) {
				HumanitiesPaperAuthor humanitiesPaperAuthor = humanitiesPaperAuthors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(humanitiesPaperAuthor.getAuthorName());
				humanitiesPaperAuthor.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesPaperAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesPaperAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(humanitiesPaperAuthor);
			}
		}
	}
	
	public void submitHumanitiesProjectMembers(
			List<HumanitiesProjectMember> humanitiesProjectMembers) {
		if(!humanitiesProjectMembers.isEmpty()){
			for (int i = 0; i < humanitiesProjectMembers.size(); i++) {
				HumanitiesProjectMember humanitiesProjectMember = humanitiesProjectMembers.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(humanitiesProjectMember.getMemberName());
				humanitiesProjectMember.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesProjectMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesProjectMember.setMemberId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(humanitiesProjectMember);
			}
		}
	}
	
	public void submitHumanitiesResearchRewardPersons(
			List<HumanitiesResearchRewardPerson> humanitiesResearchRewardPersons) {
		if(!humanitiesResearchRewardPersons.isEmpty()){
			for (int i = 0; i < humanitiesResearchRewardPersons.size(); i++) {
				HumanitiesResearchRewardPerson humanitiesResearchRewardPerson = humanitiesResearchRewardPersons.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(humanitiesResearchRewardPerson.getRewardPersonName());
				humanitiesResearchRewardPerson.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesResearchRewardPerson.setRewardPersonId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesResearchRewardPerson.setRewardPersonId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(humanitiesResearchRewardPerson);
			}
		}
	}
	
	public void submitMajorContributeMembers(
			List<MajorContributeMember> majorContributeMembers) {
		if(!majorContributeMembers.isEmpty()){
			for (int i = 0; i < majorContributeMembers.size(); i++) {
				MajorContributeMember majorContributeMember = majorContributeMembers.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(majorContributeMember.getMemberName());
				majorContributeMember.setOrders(i + 1);
				if(cquptUser != null){
					majorContributeMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					majorContributeMember.setMemberId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(majorContributeMember);
			}
		}
	}
	
	public void submitScienceBookAuthors(
			List<ScienceBookAuthor> scienceBookAuthors) {
		if(!scienceBookAuthors.isEmpty()){
			for (int i = 0; i < scienceBookAuthors.size(); i++) {
				ScienceBookAuthor scienceBookAuthor = scienceBookAuthors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(scienceBookAuthor.getMemberName());
				scienceBookAuthor.setOrders(i + 1);
				if(cquptUser != null){
					scienceBookAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceBookAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(scienceBookAuthor);
			}
		}
	}
	
	public void submitScienceGovAwardPersons(
			List<ScienceGovAwardPerson> scienceGovAwardPersons) {
		if(!scienceGovAwardPersons.isEmpty()){
			for (int i = 0; i < scienceGovAwardPersons.size(); i++) {
				ScienceGovAwardPerson scienceGovAwardPerson = scienceGovAwardPersons.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(scienceGovAwardPerson.getMemberName());
				scienceGovAwardPerson.setOrders(i + 1);
				if(cquptUser != null){
					scienceGovAwardPerson.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceGovAwardPerson.setAuthorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(scienceGovAwardPerson);
			}
		}
	}
	
	public void submitScienceInventors(
			List<ScienceInventors> scienceInventors) {
		if(!scienceInventors.isEmpty()){
			for (int i = 0; i < scienceInventors.size(); i++) {
				ScienceInventors scienceInventor = scienceInventors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(scienceInventor.getMemberName());
				scienceInventor.setOrders(i + 1);
				if(cquptUser != null){
					scienceInventor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceInventor.setAuthorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(scienceInventor);
			}
		}
	}
	
	public void submitScienceTechAttendPersons(
			List<ScienceTechAttendPerson> scienceTechAttendPersons) {
		if(!scienceTechAttendPersons.isEmpty()){
			for (int i = 0; i < scienceTechAttendPersons.size(); i++) {
				ScienceTechAttendPerson scienceTechAttendPerson = scienceTechAttendPersons.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(scienceTechAttendPerson.getMemberName());
				scienceTechAttendPerson.setOrders(i + 1);
				if(cquptUser != null){
					scienceTechAttendPerson.setAttendId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceTechAttendPerson.setAttendId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(scienceTechAttendPerson);
			}
		}
	}
	
	public void submitStudentInstructors(
			List<StudentInstructor> studentInstructors) {
		if(!studentInstructors.isEmpty()){
			for (int i = 0; i < studentInstructors.size(); i++) {
				StudentInstructor studentInstructor = studentInstructors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(studentInstructor.getMemberName());
				if(cquptUser != null){
					studentInstructor.setInstructorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					studentInstructor.setInstructorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(studentInstructor);
			}
		}
	}
	
	public void submitTeachersAwards(List<TeachersAwards> teachersAwards) {
		if(!teachersAwards.isEmpty()){
			for (int i = 0; i < teachersAwards.size(); i++) {
				TeachersAwards teachersAward = teachersAwards.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(teachersAward.getMemberName());
				teachersAward.setOrders(i + 1);
				if(cquptUser != null){
					teachersAward.setAwardId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachersAward.setAwardId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(teachersAward);
			}
		}
	}
	
	public void submitTeachingMaterialEditor(List<TeachingMaterialEditor> teachingMaterialEditors) {
		if(!teachingMaterialEditors.isEmpty()){
			for (int i = 0; i < teachingMaterialEditors.size(); i++) {
				TeachingMaterialEditor teachingMaterialEditor = teachingMaterialEditors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(teachingMaterialEditor.getEditorName());
				teachingMaterialEditor.setOrders(i + 1);
				if(cquptUser != null){
					teachingMaterialEditor.setEditorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachingMaterialEditor.setEditorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(teachingMaterialEditor);
			}
		}
	}
	
	public void submitScienceTransferLeader(List<ScienceTransferLeader> scienceTransferLeaders) {
		if(!scienceTransferLeaders.isEmpty()){
			for (int i = 0; i < scienceTransferLeaders.size(); i++) {
				ScienceTransferLeader scienceTransferLeader = scienceTransferLeaders.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(scienceTransferLeader.getLeaderName());
				scienceTransferLeader.setOrders(i + 1);
				if(cquptUser != null){
					scienceTransferLeader.setLeaderId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceTransferLeader.setLeaderId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(scienceTransferLeader);
			}
		}
	}
	/*******************2013-8-10 15:28  黄海燕添加********************/
	public void submitTeachAchievementsDeclarant(List<TeachAchievementsDeclarant> teachAchievementsDeclarants) {
		if(!teachAchievementsDeclarants.isEmpty()){
			for (int i = 0; i < teachAchievementsDeclarants.size(); i++) {
				TeachAchievementsDeclarant teachAchievementsDeclarant = teachAchievementsDeclarants.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(teachAchievementsDeclarant.getDeclarantName());
				teachAchievementsDeclarant.setOrders(i + 1);
				if(cquptUser != null){
					teachAchievementsDeclarant.setDeclarantId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachAchievementsDeclarant.setDeclarantId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(teachAchievementsDeclarant);
			}
		}
	}	
		
	public void submitStudentInstructorsNew(
			List<StudentInstructorNew> studentInstructors) {
		if(!studentInstructors.isEmpty()){
			for (int i = 0; i < studentInstructors.size(); i++) {
				StudentInstructorNew studentInstructor = studentInstructors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(studentInstructor.getMemberName());
				if(cquptUser != null){
					studentInstructor.setInstructorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					studentInstructor.setInstructorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(studentInstructor);
			}
		}
	}
	
	public void submitTeachersAwardsNew(List<TeachersAwardsNew> teachersAwards) {
		if(!teachersAwards.isEmpty()){
			for (int i = 0; i < teachersAwards.size(); i++) {
				TeachersAwardsNew teachersAward = teachersAwards.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(teachersAward.getMemberName());
				teachersAward.setOrders(i + 1);
				if(cquptUser != null){
					teachersAward.setAwardId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachersAward.setAwardId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(teachersAward);
			}
		}
	}
	
	public void submitTeachingMaterialEditorNew(List<TeachingMaterialEditorNew> teachingMaterialEditors) {
		if(!teachingMaterialEditors.isEmpty()){
			for (int i = 0; i < teachingMaterialEditors.size(); i++) {
				TeachingMaterialEditorNew teachingMaterialEditor = teachingMaterialEditors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(teachingMaterialEditor.getEditorName());
				teachingMaterialEditor.setOrders(i + 1);
				if(cquptUser != null){
					teachingMaterialEditor.setEditorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachingMaterialEditor.setEditorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(teachingMaterialEditor);
			}
		}
	}
	public void submitCourseContributeMembersNew(
			List<CourseContributeMemberNew> courseContributeMembers) {
		if(!courseContributeMembers.isEmpty()){
			for (int i = 0; i < courseContributeMembers.size(); i++) {
				CourseContributeMemberNew courseContributeMember = courseContributeMembers.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(courseContributeMember.getMemberName());
				courseContributeMember.setOrders(i + 1);
				if(cquptUser != null){
					courseContributeMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					courseContributeMember.setMemberId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(courseContributeMember);
			}
		}
	}
	
	public void submitMajorContributeMembersNew(
			List<MajorContributeMemberNew> majorContributeMembers) {
		if(!majorContributeMembers.isEmpty()){
			for (int i = 0; i < majorContributeMembers.size(); i++) {
				MajorContributeMemberNew majorContributeMember = majorContributeMembers.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(majorContributeMember.getMemberName());
				majorContributeMember.setOrders(i + 1);
				if(cquptUser != null){
					majorContributeMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					majorContributeMember.setMemberId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(majorContributeMember);
			}
		}
	}
	
	/*********************	Bern添加 2014.10.3 **************************/
	public void submitStudentRecordInstructors(
			List<StudentRecordInstructor> studentRecordInstructors) {
		if(!studentRecordInstructors.isEmpty()){
			for (int i = 0; i < studentRecordInstructors.size(); i++) {
				StudentRecordInstructor studentRecordInstructor = studentRecordInstructors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(studentRecordInstructor.getMemberName());
				if(cquptUser != null){
					studentRecordInstructor.setInstructorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					studentRecordInstructor.setInstructorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(studentRecordInstructor);
			}
		}
	}
	/*********************	liu添加 2014.10.07 **************************/
	public void submitTeachersRecordAchievements(List<TeachersRecordAchievements> teachersRecordAchievementsList) {
		if(!teachersRecordAchievementsList.isEmpty()){
			for (int i = 0; i < teachersRecordAchievementsList.size(); i++) {
				TeachersRecordAchievements teachersRecordAchievements = teachersRecordAchievementsList.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(teachersRecordAchievements.getMemberName());
				teachersRecordAchievements.setOrders(i + 1);
				if(cquptUser != null){
					teachersRecordAchievements.setAwardId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachersRecordAchievements.setAwardId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(teachersRecordAchievements);
			}
		}
	}
	
	public void submitMajorRecordMembers(List<MajorRecordMember> majorRecordMembers) {
		if(!majorRecordMembers.isEmpty()){
			for (int i = 0; i < majorRecordMembers.size(); i++) {
				MajorRecordMember majorRecordMember = majorRecordMembers.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(majorRecordMember.getMemberName());
				if(cquptUser != null){
					majorRecordMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					majorRecordMember.setMemberId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(majorRecordMember);
			}
		}
	}
	
	public void submitTeachingRecordEditors(List<TeachingRecordEditor> teachingRecordEditors) {
		if(!teachingRecordEditors.isEmpty()){
			for (int i = 0; i < teachingRecordEditors.size(); i++) {
				TeachingRecordEditor teachingRecordEditor = teachingRecordEditors.get(i);
				CQUPTUser cquptUser = submitInfoMemberDao.findCQUPTUserByUserName(teachingRecordEditor.getEditorName());
				if(cquptUser != null){
					teachingRecordEditor.setEditorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachingRecordEditor.setEditorId(GenerateUtils.generateUserID());
				}
				submitInfoMemberDao.addInfoMember(teachingRecordEditor);
			}
		}
	}
	
	
}
