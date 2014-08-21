package com.cqupt.mis.rms.action.system.role;

import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.RoleLevel;
import com.cqupt.mis.rms.service.PurviewService;
import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * Title:添加角色信息的Action
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
public class AddRoleAction extends ActionSupport {
	// 注入普通属性
	private String roleName;
	private String description;
	private int roleLevelId;
	// 注入权限服务层接口
	private PurviewService purviewService;

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRoleLevelId(int roleLevelId) {
		this.roleLevelId = roleLevelId;
	}

	@Override
	public String execute() throws Exception {
		CQUPTRole role = new CQUPTRole();
		role.setDescription(description);
		RoleLevel roleLevel =purviewService.findRoleLevelByRoleLevelId(roleLevelId);
		role.setRoleLevel(roleLevel);
		role.setRoleName(roleName);
		//添加角色
		boolean result  = purviewService.addRoleInfo(role);
		Confirm confirm = new Confirm();
		if (result) {
			confirm.setIsSuccess("right");
			confirm.setMessage("角色添加成功");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色信息列表");
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("角色添加失败");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色信息列表");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}
}
