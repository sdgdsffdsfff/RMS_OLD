package com.cqupt.mis.rms.action.system.purview;

import com.cqupt.mis.rms.security.MyFilterInvocationSecurityMetadataSource;
import com.cqupt.mis.rms.service.PurviewService;
import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理分配权限的Action
 * @author LM
 * 
 */
@SuppressWarnings("serial")
public class AssignPurviewAction extends ActionSupport {
	// 注入接口属性
	private PurviewService purviewService;
	// 注入普通属性
	private int[] purviewId;
	private int roleId;

	public PurviewService getPurviewService() {
		return purviewService;
	}

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setPurviewId(int[] purviewId) {
		this.purviewId = purviewId;
	}

	@Override
	public String execute() throws Exception {
		Confirm confirm = new Confirm();
		boolean result = purviewService.addRolePurviewByRoleIdAndpurviewIdArray(roleId, purviewId);
		//重新加载resourceMap里的权限资源对应列表
		MyFilterInvocationSecurityMetadataSource source = new MyFilterInvocationSecurityMetadataSource();
		if (result) {
			confirm.setIsSuccess("right");
			confirm.setMessage("权限分配成功");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色列表");
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("权限分配失败");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色列表");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}

}
