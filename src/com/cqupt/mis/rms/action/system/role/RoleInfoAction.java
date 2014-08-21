package com.cqupt.mis.rms.action.system.role;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.service.PurviewService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * Title:处理角色信息的Action
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
public class RoleInfoAction extends ActionSupport {
	// 注入登录方式(级别)的接口
	private PurviewService purviewService;

	public void setPurviewService(PurviewService purviewService) {
		this.purviewService = purviewService;
	}
	@Override
	public String execute() throws Exception {
		//这里查询前50个角色，因为本系统中角色不回超过50个，所以相当于查询所有的角色
		List<CQUPTRole> list = purviewService.findRoleInfoList(0, 50);
		ActionContext.getContext().put("roleList", list);
		return SUCCESS;
	}
}
