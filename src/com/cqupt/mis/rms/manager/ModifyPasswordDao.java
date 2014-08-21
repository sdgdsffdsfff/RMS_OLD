/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.manager;

import com.cqupt.mis.rms.model.UserLogin;

/**
*<p>Title:管理用户修改密码的底层接口</p>
*<p>Description: 处理用户修改密码时对数据库的操作</p>
*<p>Company:重邮信管工作室 </p>
*@author LvHai
*@version 1.0
*/
public interface ModifyPasswordDao {

	/**
	 * 判断用户名和密码是否正确
	 * @param userId  用户登录Id
	 * @param passWord  用户登录Id
	 * @return UserLogin 获得的用户信息
	 * */
	public UserLogin findUserAndPassword(String userId, String passWord);
	
	/**
	 * 修改用户密码
	 * @param UserLogin  用户登录信息
	 * @return void
	 * */
	public void updateUserLoginInfo(UserLogin userLogin);
	
}
