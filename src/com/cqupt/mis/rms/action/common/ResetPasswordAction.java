package com.cqupt.mis.rms.action.common;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.service.ModifyPasswordService;
import com.cqupt.mis.rms.service.ModifyUserInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.EncryptUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ResetPasswordAction extends ActionSupport{
	private ModifyPasswordService modifyPasswordService;
	private ModifyUserInfoService modifyUserInfoService;

	
	public ModifyPasswordService getModifyPasswordService() {
		return modifyPasswordService;
	}
	public void setModifyPasswordService(ModifyPasswordService modifyPasswordService) {
		this.modifyPasswordService = modifyPasswordService;
	}
	public ModifyUserInfoService getModifyUserInfoService() {
		return modifyUserInfoService;
	}
	public void setModifyUserInfoService(ModifyUserInfoService modifyUserInfoService) {
		this.modifyUserInfoService = modifyUserInfoService;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public String execute() throws Exception {
		CQUPTUser cquptUser = modifyUserInfoService.findUserInfoByUserId(userId);
		String password = cquptUser.getUserLogin().getUserPwd();
		password = EncryptUtils.getDesString(password);
		Confirm confirm = new Confirm();
		boolean result = modifyPasswordService.updateUserPassword(userId, password, "123");
		if(result){
			confirm.setIsSuccess("right");
			confirm.setMessage("重置密码成功");
			confirm.setUrl("viewUserAndRole.action");
			confirm.setRetName("角色列表");
		}else{
			confirm.setIsSuccess("error");
			confirm.setMessage("重置密码失败");
			confirm.setUrl("viewUserAndRole.action");
			confirm.setRetName("角色列表");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}

}
