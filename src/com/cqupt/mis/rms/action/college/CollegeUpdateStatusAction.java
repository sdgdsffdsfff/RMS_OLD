package com.cqupt.mis.rms.action.college;

import com.cqupt.mis.rms.service.CollegeManagerService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.DynamicDataFieldUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * Title:审批操作的action
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author HHY
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class CollegeUpdateStatusAction extends ActionSupport {

	// 注入服务层接口
	private CollegeManagerService collegeManagerService;
	// 得到id 需要的信息的id的值
	private String id;
	// 得到modelName 需要的model的名称(注意大小写)
	private String modelName;
	// 得到idName model中做对应的id的名称
	private String idName;
	// 得到status 需要的设置的信息状态
	private String status;

	private String returnReason;

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public CollegeManagerService getCollegeManagerService() {
		return collegeManagerService;
	}

	public String getId() {
		return id;
	}

	public String getIdName() {
		return idName;
	}

	public String getStatus() {
		return status;
	}

	public void setCollegeManagerService(
			CollegeManagerService collegeManagerService) {
		this.collegeManagerService = collegeManagerService;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	// 材料是否被审核通过
	public String execute() throws Exception {
		// 调用函数 实现审批操作 如果操作成功返回true 否则返回false
		String approvedUserId = (String) ActionContext.getContext()
				.getSession().get("userId");
		boolean result = false;
		if (returnReason == null) {
			// 审批通过
			if ("1".equals(status))
				status = "2";
			if ("5".equals(status))
				status = "6";
			Float verify_amounts = 0.0f;

			result = collegeManagerService.updateInfoByIdNew(id, modelName,
					status, idName, approvedUserId, verify_amounts);
		} else {
			// 拒绝审批
			if ("1".equals(status))
				status = "3";
			if ("5".equals(status))
				status = "7";
			if ("2".equals(status))
				status = "3";
			if ("6".equals(status))
				status = "7";

			result = collegeManagerService.updateRejectInfoById(id, modelName,
					status, idName, approvedUserId, returnReason);

		}
		Confirm confirm = new Confirm();
		if (result) {
			confirm.setIsSuccess("right");
			if ("ScienceOrganization".equals(modelName)) {
				confirm.setMessage("科研机构信息审批成功");
				confirm.setUrl("collegeTecInfo/scienceOrganization.action");
				confirm.setRetName("科研机构信息审批页面");
			} else if ("ScienceTechProject".equals(modelName)) {
				confirm.setMessage("科技项目信息审批成功");
				confirm.setUrl("collegeTecInfo/scienceTechProject.action");
				confirm.setRetName("科技项目信息审批页面");
			} else if ("ScienceBook".equals(modelName)) {
				confirm.setMessage("理科著作信息审批成功");
				confirm.setUrl("collegeTecInfo/scienceBook.action");
				confirm.setRetName("理科著作信息审批页面");
			} else if ("SciencePaper".equals(modelName)) {
				confirm.setMessage("理科论文信息审批成功");
				confirm.setUrl("collegeTecInfo/sciencePaper.action");
				confirm.setRetName("理科论文信息审批页面");
			} else if ("ScienceGovernmentAward".equals(modelName)) {
				confirm.setMessage("政府科技奖励信息审批成功");
				confirm.setUrl("collegeTecInfo/scienceGovernmentAward.action");
				confirm.setRetName("政府科技奖励信息审批页面");
			} else if ("ScienceIpRights".equals(modelName)) {
				confirm.setMessage("知识产权信息审批成功");
				confirm.setUrl("collegeTecInfo/scienceIpRights.action");
				confirm.setRetName("知识产权信息审批页面");
			} else if ("ScienceTechTransfer".equals(modelName)) {
				confirm.setMessage("技术转让信息审批成功");
				confirm.setUrl("collegeTecInfo/scienceTechTransfer.action");
				confirm.setRetName("技术转让信息审批页面");
			} else if ("ScienceTechExchange".equals(modelName)) {
				confirm.setMessage("科技交流信息审批成功");
				confirm.setUrl("collegeTecInfo/scienceTechExchange.action");
				confirm.setRetName("科技交流信息审批页面");
			} else if ("HumanitiesPaper".equals(modelName)) {
				confirm.setMessage("人文社科论文信息审批成功");
				confirm.setUrl("collegeHumInfo/humanitiesPaper.action");
				confirm.setRetName("人文社科论文信息审批页面");
			} else if ("HumanitiesBook".equals(modelName)) {
				confirm.setMessage("人文社科著作信息审批成功");
				confirm.setUrl("collegeHumInfo/humanitiesBook.action");
				confirm.setRetName("人文社科著作信息审批页面");
			} else if ("HumanitiesProject".equals(modelName)) {
				confirm.setMessage("科研项目信息审批成功");
				confirm.setUrl("collegeHumInfo/humanitiesProject.action");
				confirm.setRetName("科研项目信息审批页面");
			} else if ("HumanitiesExchangePaper".equals(modelName)) {
				confirm.setMessage("会议论文交流信息审批成功");
				confirm.setUrl("collegeHumInfo/humanitiesExchangePaper.action");
				confirm.setRetName("会议论文交流信息审批页面");
			} else if ("HumanitiesResearchReward".equals(modelName)) {
				confirm.setMessage("人文社科科研获奖信息审批成功");
				confirm.setUrl("collegeHumInfo/humanitiesResearchReward.action");
				confirm.setRetName("人文社科科研获奖信息审批页面");
			} else if ("HumanitiesAcademicMeeting".equals(modelName)) {
				confirm.setMessage("人文社科学术会议信息审批成功");
				confirm.setUrl("collegeHumInfo/humanitiesAcademicMeeting.action");
				confirm.setRetName("人文社科学术会议信息审批页面");
			} else if ("MajorContribute".equals(modelName)) {
				confirm.setMessage("专业建设信息审批成功");
				confirm.setUrl("collegeAchInfo/majorContribute.action");
				confirm.setRetName("专业建设信息审批页面");
			} else if ("CourseContribute".equals(modelName)) {
				confirm.setMessage("课程建设信息审批成功");
				confirm.setUrl("collegeAchInfo/courseContribute.action");
				confirm.setRetName("课程建设信息审批页面");
			} else if ("TeachAchievements".equals(modelName)) {
				confirm.setMessage("教学成果奖信息审批成功");
				confirm.setUrl("collegeAchInfo/teachAchievements.action");
				confirm.setRetName("教学成果奖信息审批页面");
			} else if ("TeachingMaterialSet".equals(modelName)) {
				confirm.setMessage("教材立项信息审批成功");
				confirm.setUrl("collegeAchInfo/teachingMaterialSet.action");
				confirm.setRetName("教材立项信息审批页面");
			} else if ("StudentAwards".equals(modelName)) {
				confirm.setMessage("学生获奖信息审批成功");
				confirm.setUrl("collegeAchInfo/studentAwards.action");
				confirm.setRetName("学生获奖信息审批页面");
			} else if ("MajorContributeNew".equals(modelName)) {
				confirm.setMessage("教改项目信息审批成功");
				confirm.setUrl("collegeAchNewInfo/majorContributeNew.action");
				confirm.setRetName("教改项目信息审批页面");
			} else if ("CourseContributeNew".equals(modelName)) {
				confirm.setMessage("本科教学工程信息审批成功");
				confirm.setUrl("collegeAchNewInfo/courseContributeNew.action");
				confirm.setRetName("本科教学工程信息审批页面");
			} else if ("TeachAchievementsNew".equals(modelName)) {
				confirm.setMessage("发表教改论文信息审批成功");
				confirm.setUrl("collegeAchNewInfo/teachAchievementsNew.action");
				confirm.setRetName("发表教改论文信息审批页面");
			} else if ("TeachingMaterialSetNew".equals(modelName)) {
				confirm.setMessage("教材出版信息审批成功");
				confirm.setUrl("collegeAchNewInfo/teachingMaterialSetNew.action");
				confirm.setRetName("教材出版信息审批页面");
			} else if ("StudentAwardsNew".equals(modelName)) {
				confirm.setMessage("指导学生参赛获奖信息审批成功");
				confirm.setUrl("collegeAchNewInfo/studentAwardsNew.action");
				confirm.setRetName("指导学生参赛获奖信息审批页面");
			} else if ("TeachAchievementsCQ".equals(modelName)) {
				confirm.setMessage("重庆市大学生创新创业训练计划项目信息审批成功");
				confirm.setUrl("collegeAchNewInfo/teachAchievementsCQ.action");
				confirm.setRetName("重庆市大学生创新创业训练计划项目信息审批页面");
			} else if ("StudentAwardsRecord".equals(modelName)) { // TODO
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(5)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/teacherAwardsRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(5)+"审批页面");
			} else if ("TeachersAwardsRecord".equals(modelName)) { // TODO
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(3)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/teacherAwardsRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(3)+"审批页面");
			}else if("MajorContributeRecord".equals(modelName)) {		
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(1)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/majorContributeRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(1)+"审批页面");
			}else if("TeachingMaterialRecord".equals(modelName)) {		
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(4)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/teachingMaterialRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(4)+"审批页面");
			}else if("ExcellentTrainerRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(2)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/excellentTrainerRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(2)+"审批页面");
			}else if("QualityProjectRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(6)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/qualityProjectRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(6)+"审批页面");
			}else if("LearningEvaluationRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(7)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/learningEvaluationRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(7)+"审批页面");
			}else if("EducationalReformRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(8)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/educationalReformRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(8)+"审批页面");
			}else if("OtherTeachingAwardsRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(9)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/otherTeachingAwardsRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(9)+"审批页面");
			}
		} else {
			confirm.setIsSuccess("error");
			if ("ScienceOrganization".equals(modelName)) {
				confirm.setMessage("科研机构信息审批失败");
				confirm.setUrl("collegeTecInfo/scienceOrganization.action");
				confirm.setRetName("科研机构信息审批页面");
			} else if ("ScienceTechProject".equals(modelName)) {
				confirm.setMessage("科技项目信息审批失败");
				confirm.setUrl("collegeTecInfo/scienceTechProject.action");
				confirm.setRetName("科技项目信息审批页面");
			} else if ("ScienceBook".equals(modelName)) {
				confirm.setMessage("理科著作信息审批失败");
				confirm.setUrl("collegeTecInfo/scienceBook.action");
				confirm.setRetName("理科著作信息审批页面");
			} else if ("SciencePaper".equals(modelName)) {
				confirm.setMessage("理科论文信息审批失败");
				confirm.setUrl("collegeTecInfo/sciencePaper.action");
				confirm.setRetName("理科论文信息审批页面");
			} else if ("ScienceGovernmentAward".equals(modelName)) {
				confirm.setMessage("政府科技奖励信息审批失败");
				confirm.setUrl("collegeTecInfo/scienceGovernmentAward.action");
				confirm.setRetName("政府科技奖励信息审批页面");
			} else if ("ScienceIpRights".equals(modelName)) {
				confirm.setMessage("知识产权信息审批失败");
				confirm.setUrl("collegeTecInfo/scienceIpRights.action");
				confirm.setRetName("知识产权信息审批页面");
			} else if ("ScienceTechTransfer".equals(modelName)) {
				confirm.setMessage("技术转让信息审批失败");
				confirm.setUrl("collegeTecInfo/scienceTechTransfer.action");
				confirm.setRetName("技术转让信息审批页面");
			} else if ("ScienceTechExchange".equals(modelName)) {
				confirm.setMessage("科技交流信息审批失败");
				confirm.setUrl("collegeTecInfo/scienceTechExchange.action");
				confirm.setRetName("科技交流信息审批页面");
			} else if ("HumanitiesPaper".equals(modelName)) {
				confirm.setMessage("人文社科论文信息审批失败");
				confirm.setUrl("collegeHumInfo/humanitiesPaper.action");
				confirm.setRetName("人文社科论文信息审批页面");
			} else if ("HumanitiesBook".equals(modelName)) {
				confirm.setMessage("人文社科著作信息审批失败");
				confirm.setUrl("collegeHumInfo/humanitiesBook.action");
				confirm.setRetName("人文社科著作信息审批页面");
			} else if ("HumanitiesProject".equals(modelName)) {
				confirm.setMessage("科研项目信息审批失败");
				confirm.setUrl("collegeHumInfo/humanitiesProject.action");
				confirm.setRetName("科研项目信息审批页面");
			} else if ("HumanitiesExchangePaper".equals(modelName)) {
				confirm.setMessage("会议论文交流信息审批失败");
				confirm.setUrl("collegeHumInfo/humanitiesExchangePaper.action");
				confirm.setRetName("会议论文交流信息审批页面");
			} else if ("HumanitiesResearchReward".equals(modelName)) {
				confirm.setMessage("人文社科科研获奖信息审批失败");
				confirm.setUrl("collegeHumInfo/humanitiesResearchReward.action");
				confirm.setRetName("人文社科科研获奖信息审批页面");
			} else if ("HumanitiesAcademicMeeting".equals(modelName)) {
				confirm.setMessage("人文社科学术会议信息审批失败");
				confirm.setUrl("collegeHumInfo/humanitiesAcademicMeeting.action");
				confirm.setRetName("人文社科学术会议信息审批页面");
			} else if ("MajorContribute".equals(modelName)) {
				confirm.setMessage("专业建设信息审批失败");
				confirm.setUrl("collegeAchInfo/majorContribute.action");
				confirm.setRetName("专业建设信息审批页面");
			} else if ("CourseContribute".equals(modelName)) {
				confirm.setMessage("课程建设信息审批失败");
				confirm.setUrl("collegeAchInfo/courseContribute.action");
				confirm.setRetName("课程建设信息审批页面");
			} else if ("TeachAchievements".equals(modelName)) {
				confirm.setMessage("教学成果奖信息审批失败");
				confirm.setUrl("collegeAchInfo/teachAchievements.action");
				confirm.setRetName("教学成果奖信息审批页面");
			} else if ("TeachingMaterialSet".equals(modelName)) {
				confirm.setMessage("教材立项信息审批失败");
				confirm.setUrl("collegeAchInfo/teachingMaterialSet.action");
				confirm.setRetName("教材立项信息审批页面");
			} else if ("StudentAwards".equals(modelName)) {
				confirm.setMessage("学生获奖信息审批失败");
				confirm.setUrl("collegeAchInfo/studentAwards.action");
				confirm.setRetName("学生获奖信息审批页面");
			} else if ("MajorContributeNew".equals(modelName)) {
				confirm.setMessage("教改项目信息审批失败");
				confirm.setUrl("collegeAchNewInfo/majorContributeNew.action");
				confirm.setRetName("教改项目信息审批页面");
			} else if ("CourseContributeNew".equals(modelName)) {
				confirm.setMessage("本科教学工程息审批失败");
				confirm.setUrl("collegeAchNewInfo/courseContributeNew.action");
				confirm.setRetName("本科教学工程信息审批页面");
			} else if ("TeachAchievementsNew".equals(modelName)) {
				confirm.setMessage("发表教改论文信息审批失败");
				confirm.setUrl("collegeAchNewInfo/teachAchievementsNew.action");
				confirm.setRetName("发表教改论文信息审批页面");
			} else if ("TeachingMaterialSetNew".equals(modelName)) {
				confirm.setMessage("教材出版信息审批失败");
				confirm.setUrl("collegeAchNewInfo/teachingMaterialSetNew.action");
				confirm.setRetName("教材出版信息审批页面");
			} else if ("StudentAwardsNew".equals(modelName)) {
				confirm.setMessage("指导学生参赛获奖信息审批失败");
				confirm.setUrl("collegeAchNewInfo/studentAwardsNew.action");
				confirm.setRetName("指导学生参赛获奖信息审批页面");
			} else if ("TeachAchievementsCQ".equals(modelName)) {
				confirm.setMessage("重庆市大学生创新创业训练计划项目信息审批失败");
				confirm.setUrl("collegeAchNewInfo/teachAchievementsCQ.action");
				confirm.setRetName("重庆市大学生创新创业训练计划项目信息审批页面");
			} else if ("StudentAwardsRecord".equals(modelName)) { // TODO
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(5)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/teacherAwardsRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(5)+"审批页面");
			} else if ("TeachersAwardsRecord".equals(modelName)) { // TODO
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(3)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/teacherAwardsRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(3)+"审批页面");
			}else if("MajorContributeRecord".equals(modelName)) {		
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(1)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/majorContributeRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(1)+"审批页面");
			}else if("TeachingMaterialRecord".equals(modelName)) {		
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(4)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/teachingMaterialRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(4)+"审批页面");
			}else if("ExcellentTrainerRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(2)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/excellentTrainerRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(2)+"审批页面");
			}else if("QualityProjectRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(6)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/qualityProjectRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(6)+"审批页面");
			}else if("LearningEvaluationRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(7)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/learningEvaluationRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(7)+"审批页面");
			}else if("EducationalReformRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(8)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/educationalReformRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(8)+"审批页面");
			}else if("OtherTeachingAwardsRecord".equals(modelName)){
				confirm.setMessage(DynamicDataFieldUtils.getInfoNameByClassNum(9)+"审批成功");
				confirm.setUrl("collegeAchInfoRecord/otherTeachingAwardsRecord.action");
				confirm.setRetName(DynamicDataFieldUtils.getInfoNameByClassNum(9)+"审批页面");
			}
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}
}
