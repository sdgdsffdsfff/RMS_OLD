package com.cqupt.mis.rms.action.system.role;

import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.service.PurviewService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * <p>
 * Title:跳转到更新角色信息的Action
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
public class ForwardUpdateRoleInfoAction extends ActionSupport {
	//注入角色Id属性
	private int roleId;
	// 注入权限服务层接口
	private PurviewService purviewService;

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String execute() throws Exception {
		CQUPTRole role = purviewService.findRoleInfoByroleId(roleId);
		if(role!=null){
			ActionContext.getContext().put("role", role);
			return SUCCESS;
		}else{
			return LOGIN;
		}
		
	}

}
