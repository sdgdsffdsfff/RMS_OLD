/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.college.modify;


import com.cqupt.mis.rms.manager.ResearchInfoDao;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/***************2013-8-12   黄海燕添加*************************/

/**
*<p>Title:(学院管理员权限)新添加的处理教师用户提交教学成果奖信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author HHY
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyTeachAchievementsNewCollegeAction extends ActionSupport {
	//注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	
	private String achievementsId;
	
	private String verifyAmounts;
	
	private String returnReason;
	
	
	public String execute() throws Exception {
		TeachAchievementsCQ teachAchievementsNew = (TeachAchievementsCQ)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(achievementsId, "TeachAchievementsCQ", "achievementsId");
		teachAchievementsNew.setAchievementsId(achievementsId);
		teachAchievementsNew.setReturnReason(returnReason);
		if(!verifyAmounts.isEmpty()){
			teachAchievementsNew.setVerifyAmounts(Float.parseFloat(verifyAmounts));
		}
		
		
		
		
		
			try{
			boolean result1 = researchInfoService.modifyResearchInfo(teachAchievementsNew);
			Confirm confirm = new Confirm();
			if(result1){
				confirm.setIsSuccess("right");
				confirm.setMessage("教学成果奖信息修改成功");
				confirm.setUrl("viewTeachAchievementsNew.action");
				confirm.setRetName("个人教学成果奖信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("教学成果奖信息修改失败");
				confirm.setUrl("viewTeachAchievementsNew.action");
				confirm.setRetName("个人教学成果奖信息页面");
			}
			ActionContext.getContext().put("confirm", confirm);
			return SUCCESS;
			}catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		
	}

	public void setResearchInfoService(ResearchInfoService researchInfoService) {
		this.researchInfoService = researchInfoService;
	}

	public void setResearchInfoDao(ResearchInfoDao researchInfoDao) {
		this.researchInfoDao = researchInfoDao;
	}

	public void setAchievementsId(String achievementsId) {
		this.achievementsId = achievementsId;
	}

	public void setVerifyAmounts(String verifyAmounts) {
		this.verifyAmounts = verifyAmounts;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
}
