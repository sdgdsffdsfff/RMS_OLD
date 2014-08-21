package com.cqupt.mis.rms.action.system.role;

import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.service.PurviewService;
import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * <p>
 * Title:更新角色信息的Action
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
public class UpdateRoleInfoAction extends ActionSupport {
	// 注入权限服务层接口
	private PurviewService purviewService;
	// 注入普通属性
	private int roleId;
	private String roleName;
	private String description;

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String execute() throws Exception {
		CQUPTRole role = purviewService.findRoleInfoByroleId(roleId);
		role.setDescription(description);
		role.setRoleName(roleName);
		//更新角色
		boolean result  = purviewService.updateRoleInfo(role);
		Confirm confirm = new Confirm();
		if (result) {
			confirm.setIsSuccess("right");
			confirm.setMessage("角色更新成功");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色列表");
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("角色更新失败");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色信息列表");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}

}
