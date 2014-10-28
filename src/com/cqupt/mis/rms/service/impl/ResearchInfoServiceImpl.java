package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.ResearchInfoDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.CourseContributeMember;
import com.cqupt.mis.rms.model.CourseContributeMemberNew;
import com.cqupt.mis.rms.model.EducationalRecordAward;
import com.cqupt.mis.rms.model.ExcellentRecordAward;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeetingPerson;
import com.cqupt.mis.rms.model.HumanitiesBookAuthor;
import com.cqupt.mis.rms.model.HumanitiesExchangePaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesPaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.HumanitiesProjectMember;
import com.cqupt.mis.rms.model.HumanitiesResearchRewardPerson;
import com.cqupt.mis.rms.model.LearningRecordAward;
import com.cqupt.mis.rms.model.MajorContributeMember;
import com.cqupt.mis.rms.model.MajorContributeMemberNew;
import com.cqupt.mis.rms.model.MajorRecordMember;
import com.cqupt.mis.rms.model.OtherTeachingRecordAward;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.QualityRecordAward;
import com.cqupt.mis.rms.model.ScienceBookAuthor;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;
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
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.GenerateUtils;

/**
 * <p>Title:管理用户个人科研信息的服务层实现类</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LvHai
 * @version 1.0
 * */
public class ResearchInfoServiceImpl implements ResearchInfoService {
	//注入管理层接口
	private ResearchInfoDao researchInfoDao;
	
	public void setResearchInfoDao(ResearchInfoDao researchInfoDao) {
		this.researchInfoDao = researchInfoDao;
	}
	
	@Override
	public Object viewResearchInfo(String submitUserId, String modelName) {
		return researchInfoDao.findResearchInfoByUserIdAndModelName(submitUserId, modelName);
	}

	@Override
	public boolean deleteResearchInfo(String[] researchIds,
			String researchModelName, String researchFactor,
			String memberModelName, String memberFactor, String fileBasePath) {
		try {
			for(int i = 0; i < researchIds.length; i++){
				String researchId = researchIds[i];
				int status = researchInfoDao.findStatusByResearchId(researchId, researchModelName, researchFactor);
				//判断科研信息的状态，如果为0（保存状态）或3（审批未通过）则可以删除，否则不能删除。
				if(status == 0 ||status ==3){
					List<Proofs> proofs = researchInfoDao.findProofByApprovedId(researchId);
					researchInfoDao.deleteMemberInfoByResearchId(researchId, memberModelName, memberFactor, researchFactor);
					researchInfoDao.deleteProofByResearchId(researchId);
					researchInfoDao.deleteInfoByResearchId(researchId, researchModelName, researchFactor);
					for(int j = 0; j < proofs.size(); j++){
						Proofs proof = proofs.get(j);
						String fileName = proof.getUploadRealName();
						String filePath = fileBasePath + proof.getProofPath();
						researchInfoDao.deleteFile(fileName, filePath);
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteResearchInfo(String[] researchIds,
			String researchModelName, String researchFactor,
			String detailModelName, String detailFactor,
			String memberModelName, String memberFactor, String fileBasePath) {
		try {
			for(int i = 0; i < researchIds.length; i++){
				String researchId = researchIds[i];
				int status = researchInfoDao.findStatusByResearchId(researchId, researchModelName, researchFactor);
				//判断科研信息的状态，如果为0（保存状态）或3（审批未通过）则可以删除，否则不能删除。
				if(status == 0 ||status ==3){
					List<Proofs> proofs = researchInfoDao.findProofByApprovedId(researchId);
					researchInfoDao.deleteMemberInfoByResearchId(researchId, memberModelName, memberFactor, researchFactor);
					researchInfoDao.deleteDetailInfoByResearchId(researchId, detailModelName, detailFactor, researchFactor);
					researchInfoDao.deleteProofByResearchId(researchId);
					researchInfoDao.deleteInfoByResearchId(researchId, researchModelName, researchFactor);
					for(int j = 0; j < proofs.size(); j++){
						Proofs proof = proofs.get(j);
						String fileName = proof.getUploadRealName();
						String filePath = fileBasePath + proof.getProofPath();
						researchInfoDao.deleteFile(fileName, filePath);
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteResearchInfo(String[] researchIds,
			String researchModelName, String researchFactor, String fileBasePath) {
		try {
			for(int i = 0; i < researchIds.length; i++){
				String researchId = researchIds[i];
				int status = researchInfoDao.findStatusByResearchId(researchId, researchModelName, researchFactor);
				//判断科研信息的状态，如果为0（保存状态）或3（审批未通过）则可以删除，否则不能删除。
				if(status == 0 ||status ==3){
					List<Proofs> proofs = researchInfoDao.findProofByApprovedId(researchId);
					researchInfoDao.deleteProofByResearchId(researchId);
					researchInfoDao.deleteInfoByResearchId(researchId, researchModelName, researchFactor);
					for(int j = 0; j < proofs.size(); j++){
						Proofs proof = proofs.get(j);
						String fileName = proof.getUploadRealName();
						String filePath = fileBasePath + proof.getProofPath();
						researchInfoDao.deleteFile(fileName, filePath);
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProof(String[] proofIds, String fileBasePath) {
		try {
			for(int i = 0; i < proofIds.length; i++){
				String proofId = proofIds[i];
				int id = Integer.parseInt(proofId);;
				Proofs proof = researchInfoDao.findProofById(id);
				String fileName = proof.getUploadRealName();
				String filePath = fileBasePath + proof.getProofPath();
				researchInfoDao.deleteProof(id);
				researchInfoDao.deleteFile(fileName, filePath);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modifyResearchInfo(Object researchObject) {
		//更新科研信息
		try {
			if(researchObject != null){
				researchInfoDao.updateResearchInfo(researchObject);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean modifyProofs(List<Proofs> proofs) {
		try {
			if(!proofs.isEmpty()){
				for (int i = 0; i < proofs.size(); i++) {
					Proofs proof = proofs.get(i);
					researchInfoDao.addProof(proof);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public boolean modifyResearchMemberInfo(String researchId,
			String memberModelName, String memberFactor, String researchFactor, int flag,
			Object memberListObject) {
		try {
			//删除旧的科研成员信息
			researchInfoDao.deleteMemberInfoByResearchId(researchId, memberModelName, memberFactor, researchFactor);
			
			//添加新的科研成员信息
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
				/****************2013-8-12  黄海燕添加***************************/
			case 19:
				List<TeachAchievementsDeclarant> teachAchievementsDeclarantlists = (List<TeachAchievementsDeclarant>)memberListObject;
				this.submitTeachAchievementsDeclarant(teachAchievementsDeclarantlists);
				break;
				
				/****************2014.10.6	Bern 添加***************************/
			case 25:
				List<StudentRecordInstructor> studentRecordInstructorlists = (List<StudentRecordInstructor>)memberListObject;
				this.submitStudentRecordInstructors(studentRecordInstructorlists);
				break;
				/****************2014.10.07	liu 添加***************************/
			case 26:
				List<TeachersRecordAchievements> teachersRecordAchievementslists = (List<TeachersRecordAchievements>)memberListObject;
				this.submitTeacherRecordAchievements(teachersRecordAchievementslists);
				break;	
			case 28:
				List<MajorRecordMember> majorRecordMembers = (List<MajorRecordMember>)memberListObject;
				this.submitMajorRecordMembers(majorRecordMembers);
				break;
				
			case 29:
				List<TeachingRecordEditor> teachingRecordEditors = (List<TeachingRecordEditor>)memberListObject;
				this.submitTeachingRecordEditors(teachingRecordEditors);
				break;
				
			case 27:	//优秀培训师
				List<ExcellentRecordAward> excellentRecordAwards = (List<ExcellentRecordAward>)memberListObject;
				this.submitExcellentRecordAward(excellentRecordAwards);
				break;
				
			case 30:		//质量工程
				List<QualityRecordAward> qualityRecordAwards = (List<QualityRecordAward>)memberListObject;
				this.submitQualityRecordAward(qualityRecordAwards);
				break;
				
			case 31:		//学评教
				List<LearningRecordAward> learningRecordAwards = (List<LearningRecordAward>)memberListObject;
				this.submitLearningRecordAward(learningRecordAwards);
				break;
				
			case 32:		//教改结题
				List<EducationalRecordAward> educationalRecordAwards = (List<EducationalRecordAward>)memberListObject;
				this.submitEducationalRecordAward(educationalRecordAwards);
				break;
				
			case 33:		//其他教学奖励
				List<OtherTeachingRecordAward> otherTeachingRecordAwards = (List<OtherTeachingRecordAward>)memberListObject;
				this.submitOtherTeachingRecordAward(otherTeachingRecordAwards);
				break;
				
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 其他教学获奖信息
	 */
	private void submitOtherTeachingRecordAward(
			List<OtherTeachingRecordAward> otherTeachingRecordAwards) {
		if(!otherTeachingRecordAwards.isEmpty()){
			for (int i = 0; i < otherTeachingRecordAwards.size(); i++) {
				OtherTeachingRecordAward otherTeachingRecordAward = otherTeachingRecordAwards.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(otherTeachingRecordAward.getMemberName());
				if(cquptUser != null){
					otherTeachingRecordAward.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					otherTeachingRecordAward.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(otherTeachingRecordAward);
			}
		}
	}

	/**
	 * 教改结题信息
	 */
	private void submitEducationalRecordAward(
			List<EducationalRecordAward> educationalRecordAwards) {
		if(!educationalRecordAwards.isEmpty()){
			for (int i = 0; i < educationalRecordAwards.size(); i++) {
				EducationalRecordAward educationalRecordAward = educationalRecordAwards.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(educationalRecordAward.getMemberName());
				if(cquptUser != null){
					educationalRecordAward.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					educationalRecordAward.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(educationalRecordAward);
			}
		}
	}

	/**
	 * 学评教信息
	 */
	private void submitLearningRecordAward(
			List<LearningRecordAward> learningRecordAwards) {
		if(!learningRecordAwards.isEmpty()){
			for (int i = 0; i < learningRecordAwards.size(); i++) {
				LearningRecordAward learningRecordAward = learningRecordAwards.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(learningRecordAward.getMemberName());
				if(cquptUser != null){
					learningRecordAward.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					learningRecordAward.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(learningRecordAward);
			}
		}
	}

	/**
	 * 质量工程信息
	 */
	private void submitQualityRecordAward(
			List<QualityRecordAward> qualityRecordAwards) {
		if(!qualityRecordAwards.isEmpty()){
			for (int i = 0; i < qualityRecordAwards.size(); i++) {
				QualityRecordAward qualityRecordAward = qualityRecordAwards.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(qualityRecordAward.getMemberName());
				if(cquptUser != null){
					qualityRecordAward.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					qualityRecordAward.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(qualityRecordAward);
			}
		}
	}

	/**
	 * 优秀培训师信息
	 */
	private void submitExcellentRecordAward(
			List<ExcellentRecordAward> excellentRecordAwards) {
		if(!excellentRecordAwards.isEmpty()){
			for (int i = 0; i < excellentRecordAwards.size(); i++) {
				ExcellentRecordAward excellentRecordAward = excellentRecordAwards.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(excellentRecordAward.getMemberName());
				if(cquptUser != null){
					excellentRecordAward.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					excellentRecordAward.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(excellentRecordAward);
			}
		}
	}

	public void submitTeachAchievementsDeclarant(
			List<TeachAchievementsDeclarant> teachAchievementsDeclarantlists) {
		if(!teachAchievementsDeclarantlists.isEmpty()){
			for (int i = 0; i < teachAchievementsDeclarantlists.size(); i++) {
				TeachAchievementsDeclarant teachAchievementsDeclarant = teachAchievementsDeclarantlists.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(teachAchievementsDeclarant.getDeclarantName());
				teachAchievementsDeclarant.setOrders(i + 1);
				if(cquptUser != null){
					teachAchievementsDeclarant.setDeclarantId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachAchievementsDeclarant.setDeclarantId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(teachAchievementsDeclarant);
			}
		} 
		
	}

	//提交理科论文作者信息
	public void submitSciencePaperAuthors(
			List<SciencePaperAuthor> sciencePaperAuthors) {
		if(!sciencePaperAuthors.isEmpty()){
			for (int i = 0; i < sciencePaperAuthors.size(); i++) {
				SciencePaperAuthor sciencePaperAuthor = sciencePaperAuthors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(sciencePaperAuthor.getMemberName());
				sciencePaperAuthor.setOrders(i + 1);
				if(cquptUser != null){
					sciencePaperAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					sciencePaperAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(sciencePaperAuthor);
			}
		} 
	}
	//提交理科科技项目负责人信息
	public void submitScienceTechProjectMembers(
			List<ScienceTechProjectMember> scienceTechProjectMembers) {
		if(!scienceTechProjectMembers.isEmpty()){
			for (int i = 0; i < scienceTechProjectMembers.size(); i++) {
				ScienceTechProjectMember scienceTechProjectMember = scienceTechProjectMembers.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(scienceTechProjectMember.getMemberName());
				scienceTechProjectMember.setOrders(i + 1);
				if(cquptUser != null){
					scienceTechProjectMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceTechProjectMember.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(scienceTechProjectMember);
			}
		} 
	}
	//提交理科著作作者信息
	public void submitScienceBookAuthors(
			List<ScienceBookAuthor> scienceBookAuthors) {
		if(!scienceBookAuthors.isEmpty()){
			for (int i = 0; i < scienceBookAuthors.size(); i++) {
				ScienceBookAuthor scienceBookAuthor = scienceBookAuthors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(scienceBookAuthor.getMemberName());
				scienceBookAuthor.setOrders(i + 1);
				if(cquptUser != null){
					scienceBookAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceBookAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(scienceBookAuthor);
			}
		} 
	}
	//提交理科政府科技奖完成人信息
	public void submitScienceGovAwardPersons(
			List<ScienceGovAwardPerson> scienceGovAwardPersons) {
		if(!scienceGovAwardPersons.isEmpty()){
			for (int i = 0; i < scienceGovAwardPersons.size(); i++) {
				ScienceGovAwardPerson scienceGovAwardPerson = scienceGovAwardPersons.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(scienceGovAwardPerson.getMemberName());
				scienceGovAwardPerson.setOrders(i + 1);
				if(cquptUser != null){
					scienceGovAwardPerson.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceGovAwardPerson.setAuthorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(scienceGovAwardPerson);
			}
		} 
	}
	//提交理科知识产权发明人信息
	public void submitScienceInventors(
			List<ScienceInventors> scienceInventors) {
		if(!scienceInventors.isEmpty()){
			for (int i = 0; i < scienceInventors.size(); i++) {
				ScienceInventors scienceInventor = scienceInventors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(scienceInventor.getMemberName());
				scienceInventor.setOrders(i + 1);
				if(cquptUser != null){
					scienceInventor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceInventor.setAuthorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(scienceInventor);
			}
		} 
	}
	//提交理科科技交流参与人信息
	public void submitScienceTechAttendPersons(
			List<ScienceTechAttendPerson> scienceTechAttendPersons) {
		if(!scienceTechAttendPersons.isEmpty()){
			for (int i = 0; i < scienceTechAttendPersons.size(); i++) {
				ScienceTechAttendPerson scienceTechAttendPerson = scienceTechAttendPersons.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(scienceTechAttendPerson.getMemberName());
				scienceTechAttendPerson.setOrders(i + 1);
				if(cquptUser != null){
					scienceTechAttendPerson.setAttendId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceTechAttendPerson.setAttendId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(scienceTechAttendPerson);
			}
		} 
	}
	//提交人文社科论文作者信息
	public void submitHumanitiesPaperAuthors(
			List<HumanitiesPaperAuthor> humanitiesPaperAuthors) {
		if(!humanitiesPaperAuthors.isEmpty()){
			for (int i = 0; i < humanitiesPaperAuthors.size(); i++) {
				HumanitiesPaperAuthor humanitiesPaperAuthor = humanitiesPaperAuthors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(humanitiesPaperAuthor.getAuthorName());
				humanitiesPaperAuthor.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesPaperAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesPaperAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(humanitiesPaperAuthor);
			}
		} 
	}
	//提交人文社科著作作者信息
	public void submitHumanitiesBookAuthors(
			List<HumanitiesBookAuthor> humanitiesBookAuthors) {
		if(!humanitiesBookAuthors.isEmpty()){
			for (int i = 0; i < humanitiesBookAuthors.size(); i++) {
				HumanitiesBookAuthor humanitiesBookAuthor = humanitiesBookAuthors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(humanitiesBookAuthor.getAuthorName());
				humanitiesBookAuthor.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesBookAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesBookAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(humanitiesBookAuthor);
			}
		} 
	}
	//提交人文社科项目人员信息
	public void submitHumanitiesProjectMembers(
			List<HumanitiesProjectMember> humanitiesProjectMembers) {
		if(!humanitiesProjectMembers.isEmpty()){
			for (int i = 0; i < humanitiesProjectMembers.size(); i++) {
				HumanitiesProjectMember humanitiesProjectMember = humanitiesProjectMembers.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(humanitiesProjectMember.getMemberName());
				humanitiesProjectMember.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesProjectMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesProjectMember.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(humanitiesProjectMember);
			}
		} 
	}
	//提交人文社科交流论文作者信息
	public void submitHumanitiesExchangePaperAuthors(
			List<HumanitiesExchangePaperAuthor> humanitiesExchangePaperAuthors) {
		if(!humanitiesExchangePaperAuthors.isEmpty()){
			for (int i = 0; i < humanitiesExchangePaperAuthors.size(); i++) {
				HumanitiesExchangePaperAuthor humanitiesExchangePaperAuthor = humanitiesExchangePaperAuthors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(humanitiesExchangePaperAuthor.getAuthorName());
				humanitiesExchangePaperAuthor.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesExchangePaperAuthor.setAuthorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesExchangePaperAuthor.setAuthorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(humanitiesExchangePaperAuthor);
			}
		} 
	}
	//提交人文社科科研获奖人信息
	public void submitHumanitiesResearchRewardPersons(
			List<HumanitiesResearchRewardPerson> humanitiesResearchRewardPersons) {
		if(!humanitiesResearchRewardPersons.isEmpty()){
			for (int i = 0; i < humanitiesResearchRewardPersons.size(); i++) {
				HumanitiesResearchRewardPerson humanitiesResearchRewardPerson = humanitiesResearchRewardPersons.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(humanitiesResearchRewardPerson.getRewardPersonName());
				humanitiesResearchRewardPerson.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesResearchRewardPerson.setRewardPersonId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesResearchRewardPerson.setRewardPersonId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(humanitiesResearchRewardPerson);
			}
		} 
	}
	//提交人文社科学术会议人员信息
	public void submitHumanitiesAcademicMeetingPersons(
			List<HumanitiesAcademicMeetingPerson> humanitiesAcademicMeetingPersons) {
		if(!humanitiesAcademicMeetingPersons.isEmpty()){
			for (int i = 0; i < humanitiesAcademicMeetingPersons.size(); i++) {
				HumanitiesAcademicMeetingPerson humanitiesAcademicMeetingPerson = humanitiesAcademicMeetingPersons.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(humanitiesAcademicMeetingPerson.getMeetingPersonName());
				humanitiesAcademicMeetingPerson.setOrders(i + 1);
				if(cquptUser != null){
					humanitiesAcademicMeetingPerson.setMeetingPersonId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					humanitiesAcademicMeetingPerson.setMeetingPersonId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(humanitiesAcademicMeetingPerson);
			}
		} 
	}
	//提交专业建设负责人信息
	public void submitMajorContributeMembers(
			List<MajorContributeMember> majorContributeMembers) {
		if(!majorContributeMembers.isEmpty()){
			for (int i = 0; i < majorContributeMembers.size(); i++) {
				MajorContributeMember majorContributeMember = majorContributeMembers.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(majorContributeMember.getMemberName());
				majorContributeMember.setOrders(i + 1);
				if(cquptUser != null){
					majorContributeMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					majorContributeMember.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(majorContributeMember);
			}
		} 
	}
	//提交课程建设负责人信息
	public void submitCourseContributeMembers(
			List<CourseContributeMember> courseContributeMembers) {
		if(!courseContributeMembers.isEmpty()){
			for (int i = 0; i < courseContributeMembers.size(); i++) {
				CourseContributeMember courseContributeMember = courseContributeMembers.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(courseContributeMember.getMemberName());
				courseContributeMember.setOrders(i + 1);
				if(cquptUser != null){
					courseContributeMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					courseContributeMember.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(courseContributeMember);
			}
		} 
	}
	//提交教学成果获奖人信息
	public void submitTeachersAwards(
			List<TeachersAwards> teachersAwards) {
		if(!teachersAwards.isEmpty()){
			for (int i = 0; i < teachersAwards.size(); i++) {
				TeachersAwards teachersAward = teachersAwards.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(teachersAward.getMemberName());
				teachersAward.setOrders(i + 1);
				if(cquptUser != null){
					teachersAward.setAwardId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachersAward.setAwardId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(teachersAward);
			}
		} 
	}
	//提交学生获奖指导教师信息
	public void submitStudentInstructors(
			List<StudentInstructor> studentInstructors) {
		if(!studentInstructors.isEmpty()){
			for (int i = 0; i < studentInstructors.size(); i++) {
				StudentInstructor studentInstructor = studentInstructors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(studentInstructor.getMemberName());
				if(cquptUser != null){
					studentInstructor.setInstructorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					studentInstructor.setInstructorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(studentInstructor);
			}
		} 
	}
	
	
	public void submitTeachingMaterialEditor(List<TeachingMaterialEditor> teachingMaterialEditors) {
		if(!teachingMaterialEditors.isEmpty()){
			for (int i = 0; i < teachingMaterialEditors.size(); i++) {
				TeachingMaterialEditor teachingMaterialEditor = teachingMaterialEditors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(teachingMaterialEditor.getEditorName());
				teachingMaterialEditor.setOrders(i + 1);
				if(cquptUser != null){
					teachingMaterialEditor.setEditorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachingMaterialEditor.setEditorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(teachingMaterialEditor);
			}
		}
	}
	
	public void submitScienceTransferLeader(List<ScienceTransferLeader> scienceTransferLeaders) {
		if(!scienceTransferLeaders.isEmpty()){
			for (int i = 0; i < scienceTransferLeaders.size(); i++) {
				ScienceTransferLeader scienceTransferLeader = scienceTransferLeaders.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(scienceTransferLeader.getLeaderName());
				scienceTransferLeader.setOrders(i + 1);
				if(cquptUser != null){
					scienceTransferLeader.setLeaderId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					scienceTransferLeader.setLeaderId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(scienceTransferLeader);
			}
		}
	
	}
	

	@Override
	public boolean addProjectDetailInfo(Object object, String projectId, int status, String modelName, String factorName) {
		try {
			//添加一条项目详细信息
			researchInfoDao.addProjectDetailInfo(object);
			//更新项目的状态
			researchInfoDao.updateProjectDetailStatus(projectId, status, modelName, factorName);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
	
	@Override
	public void modifyScienceProjectDetailInfo(String deatilProjectId,
			ScienceDetailTechProject scienceDetailTechProject, int status) {
		
		researchInfoDao.updateResearchInfo(scienceDetailTechProject);
		//更新项目的状态
		researchInfoDao.updateProjectDetailStatus(scienceDetailTechProject.getScienceTechProject().getProjectId(), status, "ScienceTechProject", "projectId");
	}

	@Override
	public void modifyHumanitiesProjectDetailInfo(int id,
			HumanitiesProjectDetail humanitiesProjectDetail, int status) {
		
		researchInfoDao.updateResearchInfo(humanitiesProjectDetail);
		//更新项目的状态
		researchInfoDao.updateProjectDetailStatus(humanitiesProjectDetail.getHumanitiesProject().getProjectId(), status, "HumanitiesProject", "projectId");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ScienceDetailTechProject showScienceProjectDetailInfoByDate(String projectId) {
		List<ScienceDetailTechProject> scienceDetailTechProjects = new ArrayList<ScienceDetailTechProject>();
		scienceDetailTechProjects = (List<ScienceDetailTechProject>)researchInfoDao.findProjectDetailByDate(projectId, "ScienceDetailTechProject", "scienceTechProject", "scienceTechProject.projectId");
		ScienceDetailTechProject scienceDetailTechProject = scienceDetailTechProjects.get(0);
		return scienceDetailTechProject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HumanitiesProjectDetail showHumanitiesProjectDetailInfoByDate(
			String projectId) {
		List<HumanitiesProjectDetail> humanitiesProjectDetails = new ArrayList<HumanitiesProjectDetail>();
		humanitiesProjectDetails = (List<HumanitiesProjectDetail>)researchInfoDao.findProjectDetailByDate(projectId, "HumanitiesProjectDetail", "humanitiesProject", "humanitiesProject.projectId");
		HumanitiesProjectDetail humanitiesProjectDetail = humanitiesProjectDetails.get(0);
		return humanitiesProjectDetail;
	}
	
	
	/******************************************************************/
	//提交教改项目负责人信息
	public void submitMajorContributeMembersNew(
			List<MajorContributeMemberNew> majorContributeMembers) {
		if(!majorContributeMembers.isEmpty()){
			for (int i = 0; i < majorContributeMembers.size(); i++) {
				MajorContributeMemberNew majorContributeMember = majorContributeMembers.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(majorContributeMember.getMemberName());
				majorContributeMember.setOrders(i + 1);
				if(cquptUser != null){
					majorContributeMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					majorContributeMember.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(majorContributeMember);
			}
		} 
	}
	//提交本科教学工程负责人信息
	public void submitCourseContributeMembersNew(
			List<CourseContributeMemberNew> courseContributeMembers) {
		if(!courseContributeMembers.isEmpty()){
			for (int i = 0; i < courseContributeMembers.size(); i++) {
				CourseContributeMemberNew courseContributeMember = courseContributeMembers.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(courseContributeMember.getMemberName());
				courseContributeMember.setOrders(i + 1);
				if(cquptUser != null){
					courseContributeMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					courseContributeMember.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(courseContributeMember);
			}
		} 
	}
	//提交发表教改论文获奖人信息
	public void submitTeachersAwardsNew(
			List<TeachersAwardsNew> teachersAwards) {
		if(!teachersAwards.isEmpty()){
			for (int i = 0; i < teachersAwards.size(); i++) {
				TeachersAwardsNew teachersAward = teachersAwards.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(teachersAward.getMemberName());
				teachersAward.setOrders(i + 1);
				if(cquptUser != null){
					teachersAward.setAwardId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachersAward.setAwardId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(teachersAward);
			}
		} 
	}
	//提交指导学生参赛获奖 指导教师信息
	public void submitStudentInstructorsNew(
			List<StudentInstructorNew> studentInstructors) {
		if(!studentInstructors.isEmpty()){
			for (int i = 0; i < studentInstructors.size(); i++) {
				StudentInstructorNew studentInstructor = studentInstructors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(studentInstructor.getMemberName());
				if(cquptUser != null){
					studentInstructor.setInstructorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					studentInstructor.setInstructorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(studentInstructor);
			}
		} 
	}
	
	//教材出版
	public void submitTeachingMaterialEditorNew(List<TeachingMaterialEditorNew> teachingMaterialEditors) {
		if(!teachingMaterialEditors.isEmpty()){
			for (int i = 0; i < teachingMaterialEditors.size(); i++) {
				TeachingMaterialEditorNew teachingMaterialEditor = teachingMaterialEditors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(teachingMaterialEditor.getEditorName());
				teachingMaterialEditor.setOrders(i + 1);
				if(cquptUser != null){
					teachingMaterialEditor.setEditorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachingMaterialEditor.setEditorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(teachingMaterialEditor);
			}
		}
	}
	
	
	/*******************************2014.10.6 Bern	添加***********************************/

	public void submitStudentRecordInstructors(
			List<StudentRecordInstructor> studentRecordInstructors) {
		if(!studentRecordInstructors.isEmpty()){
			for (int i = 0; i < studentRecordInstructors.size(); i++) {
				StudentRecordInstructor studentRecordInstructor = studentRecordInstructors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(studentRecordInstructor.getMemberName());
				if(cquptUser != null){
					studentRecordInstructor.setInstructorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					studentRecordInstructor.setInstructorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(studentRecordInstructor);
			}
		}
	}
	/*******************************2014.10.6 Liu	添加***********************************/
	public void submitTeacherRecordAchievements(
			List<TeachersRecordAchievements> teachersRecordAchievementsList) {
		if(!teachersRecordAchievementsList.isEmpty()){
			for (int i = 0; i < teachersRecordAchievementsList.size(); i++) {
				TeachersRecordAchievements  teachersRecordAchievements = teachersRecordAchievementsList.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(teachersRecordAchievements.getMemberName());
				if(cquptUser != null){
					teachersRecordAchievements.setAwardId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachersRecordAchievements.setAwardId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(teachersRecordAchievements);
			}
		}
	}
	
	private void submitTeachingRecordEditors(
			List<TeachingRecordEditor> teachingRecordEditors) {
		if(!teachingRecordEditors.isEmpty()){
			for (int i = 0; i < teachingRecordEditors.size(); i++) {
				TeachingRecordEditor teachingRecordEditor = teachingRecordEditors.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(teachingRecordEditor.getEditorName());
				if(cquptUser != null){
					teachingRecordEditor.setEditorId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					teachingRecordEditor.setEditorId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(teachingRecordEditor);
			}
		}
		
	}

	private void submitMajorRecordMembers(
			List<MajorRecordMember> majorRecordMembers) {
		if(!majorRecordMembers.isEmpty()){
			for (int i = 0; i < majorRecordMembers.size(); i++) {
				MajorRecordMember majorRecordMember = majorRecordMembers.get(i);
				CQUPTUser cquptUser = researchInfoDao.findCQUPTUserByUserName(majorRecordMember.getMemberName());
				if(cquptUser != null){
					majorRecordMember.setMemberId(cquptUser.getUserId());
				}else{
					//此处为自动为用户生成的ID
					majorRecordMember.setMemberId(GenerateUtils.generateUserID());
				}
				researchInfoDao.addMemberInfo(majorRecordMember);
			}
		}
		
	}
	
	
}
