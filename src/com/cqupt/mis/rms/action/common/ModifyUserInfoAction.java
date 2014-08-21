/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.common;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.service.ModifyUserInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:管理用户修改个人信息Action</p>
*<p>Description:更新用户个人信息</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyUserInfoAction extends ActionSupport {
	//注入服务层接口
	private ModifyUserInfoService modifyUserInfoService;
	
	private CQUPTUser cquptUser;

	public void setModifyUserInfoService(ModifyUserInfoService modifyUserInfoService) {
		this.modifyUserInfoService = modifyUserInfoService;
	}

	public void setCquptUser(CQUPTUser cquptUser) {
		this.cquptUser = cquptUser;
	}
	
	public String execute() throws Exception {
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		CQUPTUser user = modifyUserInfoService.findUserInfoByUserId(userId);
		user.setBirthday(cquptUser.getBirthday());
		user.setDepartment(cquptUser.getDepartment());
		user.setFirstDegree(cquptUser.getFirstDegree());
		user.setFirstGraduateSchool(cquptUser.getFirstGraduateSchool());
		user.setFirstProfessionalName(cquptUser.getFirstProfessionalName());
		user.setGender(cquptUser.getGender());
		user.setLastAcademic(cquptUser.getLastAcademic());
		user.setLastDegree(cquptUser.getLastDegree());
		user.setLastGraduateSchool(cquptUser.getLastGraduateSchool());
		user.setLastProfessionalName(cquptUser.getLastProfessionalName());
		user.setNationality(cquptUser.getNationality());
		user.setOrigin(cquptUser.getOrigin());
		user.setPoliticalStatus(cquptUser.getPoliticalStatus());
		user.setTimeBeginCqupt(cquptUser.getTimeBeginCqupt());
		user.setTimeBeginWork(cquptUser.getTimeBeginWork());
		user.setTimeJoinParty(cquptUser.getTimeJoinParty());
		user.setUserName(cquptUser.getUserName());
		boolean result = modifyUserInfoService.modifyUserInfo(user);
		Confirm confirm = new Confirm();
		if(result){
			confirm.setIsSuccess("right");
			confirm.setMessage("个人信息修改成功");
			confirm.setUrl("manageUserInfo.action");
			confirm.setRetName("个人信息管理页面");
		}else{
			confirm.setIsSuccess("error");
			confirm.setMessage("个人信息修改失败");
			confirm.setUrl("manageUserInfo.action");
			confirm.setRetName("个人信息管理页面");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}

	public CQUPTUser getCquptUser() {
		return cquptUser;
	}
	
	
}
