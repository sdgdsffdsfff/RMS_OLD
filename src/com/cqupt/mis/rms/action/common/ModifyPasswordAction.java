/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.common;

import com.cqupt.mis.rms.service.ModifyPasswordService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理用户修改密码的Action</p>
*<p>Description:接收用户提交修改密码的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyPasswordAction extends ActionSupport {
	//注入服务层接口
	private ModifyPasswordService modifyPasswordService;
	
	private String oldPassword;
	private String newPassword;
	public void setModifyPasswordService(ModifyPasswordService modifyPasswordService) {
		this.modifyPasswordService = modifyPasswordService;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String execute() throws Exception {
		//取得存放在session中的userId
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		boolean result = modifyPasswordService.updateUserPassword(userId, oldPassword, newPassword);
		
		if(result){
			return SUCCESS;
		}else{
			this.addActionError("你输入的原始密码错误,请重新输入!");
			return INPUT;
		}
		
	}
	
}
