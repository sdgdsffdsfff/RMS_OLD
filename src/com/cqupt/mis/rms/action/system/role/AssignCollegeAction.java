/**
 * 
 */
package com.cqupt.mis.rms.action.system.role;

import com.cqupt.mis.rms.service.PurviewService;
import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理分配学院的Action
 * 
 * @author LM
 * 
 */
@SuppressWarnings("serial")
public class AssignCollegeAction extends ActionSupport {
	// 注入接口属性
	private PurviewService purviewService;
	// 注入普通属性
	private String[] collegeId;
	private int roleId;

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}

	public void setCollegeId(String[] collegeId) {
		this.collegeId = collegeId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String execute() throws Exception {
		Confirm confirm = new Confirm();
		boolean result = purviewService.addRoleCollegeByRoleIdAndCollegeIds(roleId, collegeId);
		if (result) {
			confirm.setIsSuccess("right");
			confirm.setMessage("学院分配成功");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色列表");
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("学院分配失败");
			confirm.setUrl("roleInfo.action");
			confirm.setRetName("角色列表");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}

}
