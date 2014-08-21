/**
 * 
 */
package com.cqupt.mis.rms.action;

import java.util.List;

import com.cqupt.mis.rms.service.PurviewService;
import com.cqupt.mis.rms.service.model.MenuInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * Title:显示主菜单的Action
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
public class MenuAction extends ActionSupport {
	// 注入权限管理服务层接口
	private PurviewService purviewService;

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}

	@Override
	public String execute() throws Exception {
		//获取userId和roleId
		String userId = (String) ActionContext.getContext().getSession().get("userId");
		int roleId = (Integer) ActionContext.getContext().getSession().get("roleId");
		//返回用户在该角色下面的封装过后的一级和该一级菜单对应的二级菜单
		List<MenuInfo> list = purviewService.findMenuListByUserIdAndRoleId(userId, roleId);
		ActionContext.getContext().put("list", list);
		return super.execute();
	}

}
