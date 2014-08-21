/**
 * 
 */
package com.cqupt.mis.rms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.manager.RoleLevelDao;
import com.cqupt.mis.rms.model.RoleLevel;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * Title:处理用户选择登录登录方式的Action
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
public class ForwardLoginAction extends ActionSupport {
	// 注入登录方式(级别)的接口
	private RoleLevelDao roleLevelDao;

	public void setRoleLevelDao(RoleLevelDao roleLevelDao) {
		this.roleLevelDao = roleLevelDao;
	}
	

	public RoleLevelDao getRoleLevelDao() {
		return roleLevelDao;
	}


	public String getRoleLevel() throws Exception {
		// 保存登录方式（级别）的链表
		List<RoleLevel> roleLevelList = roleLevelDao.findAllRoleLevel();
		JsonConfig jsonConfig = new JsonConfig(); // 建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false); // 设置默认忽略
		jsonConfig.setExcludes(new String[] { "roles"});
		// 转换成JSON数据
		JSONArray jsonArray = JSONArray.fromObject(roleLevelList, jsonConfig);
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		outString("{" + jsonArray + "}");
		return null;
	}

	public void outString(String str) {
		try {
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
