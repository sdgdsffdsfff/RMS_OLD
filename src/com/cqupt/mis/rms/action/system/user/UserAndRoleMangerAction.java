/**
 * 
 */
package com.cqupt.mis.rms.action.system.user;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.service.PurviewService;
import com.cqupt.mis.rms.service.UserManagerService;
import com.cqupt.mis.rms.service.model.UserAndRole;
import com.cqupt.mis.rms.utils.Confirm;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理用户和角色的Action
 * 
 * @author lim
 * 
 */
@SuppressWarnings("serial")
public class UserAndRoleMangerAction extends ActionSupport {
	// 注入用户管理的接口
	private UserManagerService userManagerService;
	// 注入权限服务层接口
	private PurviewService purviewService;
	// 注入普通属性
	private String userId;
	private int[] roleId;

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoleId(int[] roleId) {
		this.roleId = roleId;
	}

	// 获取用户信息和角色信息
	public String findUserRoleInfo() throws Exception {
		String loginUserId = (String) ActionContext.getContext().getSession()
				.get("userId");
		int loginRoleId = (Integer) ActionContext.getContext().getSession()
				.get("roleId");
		List<UserAndRole> list = userManagerService
				.findCQUPTUserListByUserIdAndRoleId(loginUserId, loginRoleId);
		ActionContext.getContext().put("userAndRolelist", list);
		return SUCCESS;
	}

	// 获取角色信息列表
	public String findRoleInfo() throws Exception {
		// 这里查询前50个角色，因为本系统中角色不回超过50个，所以相当于查询所有的角色
		List<CQUPTRole> list = purviewService.findRoleInfoList(0, 50);
		ActionContext.getContext().put("roleList", list);
		ActionContext.getContext().put("userId", userId);
		return SUCCESS;
	}

	// 分配角色
	public String assignRoleToUser() throws Exception {
		Confirm confirm = new Confirm();
		boolean result = userManagerService.addUserRoleInfo(userId, roleId);
		if (result) {
			confirm.setIsSuccess("right");
			confirm.setMessage("角色分配成功");
			confirm.setUrl("viewUserAndRole.action");
			confirm.setRetName("用户角色信息列表");
		} else {
			confirm.setIsSuccess("error");
			confirm.setMessage("角色分配失败");
			confirm.setUrl("viewUserAndRole.action");
			confirm.setRetName("用户角色信息列表");
		}
		ActionContext.getContext().put("confirm", confirm);
		return SUCCESS;
	}
}
