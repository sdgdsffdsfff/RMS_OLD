package com.cqupt.mis.rms.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.service.UserManagerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * Title:处理用户登录的Action
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
public class LoginAction extends ActionSupport {
	// 注入服务层接口
	private UserManagerService userManagerService;
	private String userName;
	private String userPwd;
	private String check;
	private int loginType;

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}
	
	
	public void setCheck(String check) {
		this.check = check;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		// 首先检查角色是否匹配
		CQUPTRole role = userManagerService.checkRoleLevelByUserIdAndRoleLevelId(userName, loginType);
		if(role!= null){
			String rand = (String)ActionContext.getContext().getSession().get("rand");
			if (rand.equals(check)) {
				// 角色和登录类型匹配，判断用户名和密码是否正确
				boolean result = userManagerService.checkUNameAndUPass(userName,
						userPwd);
				if (result) {
					// 用户名和密码正确,则保存登录名和用户角色信息——因为后面很多地方会使用到这两个参数，所以存放在session里面
					ActionContext.getContext().getSession().put("userId", userName);
					ActionContext.getContext().getSession().put("roleId", role.getRoleId());
					return SUCCESS;
				} else {
					this.addActionError("用户名或密码错误！");
				}
			} else {
				this.addActionError("请输入正确的验证码！");
			}
		}else {
			this.addActionError("身份不匹配,请重新选择！");
		}
		
		// 无论是用户名或者密码错误，还是角色和登录类型不匹配，最终都要进入INPUT定义的视图
		return INPUT;
	}
	public void outString(String str) {
		try {
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print("<script language='javascript'>alert('hello');</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
