package com.cqupt.mis.rms.action.system.role;

import com.cqupt.mis.rms.service.PurviewService;
import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * Title:删除角色信息的Action
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author LM
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class DeleteRoleAction extends ActionSupport {
	// 注入权限服务层接口
	private PurviewService purviewService;
	// 注入普通属性
	private int roleId;

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String execute() throws Exception {
		boolean result = purviewService.delRoleInfoByRoleId(roleId);
		Confirm confirm = new Confirm();
		if (result) {
			confirm.setIsSuccess("right");
			confirm.setMessage("角色删除成功");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色信息列表");
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("角色删除失败");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色信息列表");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}
}
