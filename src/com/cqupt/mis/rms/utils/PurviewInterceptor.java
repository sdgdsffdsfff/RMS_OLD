package com.cqupt.mis.rms.utils;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * <p>
 * Title:权限拦截器
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
public class PurviewInterceptor extends AbstractInterceptor {
	// 获取Log日志对象
	private static Log log = LogFactory.getLog(PurviewInterceptor.class);
	@SuppressWarnings("rawtypes")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// 获取ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();	
		Map session = ctx.getSession();
		String userId = (String) session.get("userId");
		// 判断用户是否登录
		if (userId != null) {
			return invocation.invoke();
		} else {
			ctx.put("tip", "你还没有登录！");
			log.debug("请先登录");
			return Action.LOGIN;
		}
	}

}
