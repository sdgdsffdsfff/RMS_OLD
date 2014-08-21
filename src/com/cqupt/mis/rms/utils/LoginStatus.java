package com.cqupt.mis.rms.utils;
/**
 * <p>
 * Title:用户登录状态信息
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
public class LoginStatus {
	//用户的角色和选中的登录角色不一致
	public static final int  USER_ROLE_ERROR = 1;
	//用户名或者密码错误
	public static final int UNAME_OR_UPwd_ERROR = 2;
	//登录成功
	public static final int LOGIN_SUCCESS = 3;
}
