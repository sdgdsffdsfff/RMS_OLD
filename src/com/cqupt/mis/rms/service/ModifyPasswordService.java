/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.service;

/**
*<p>Title:管理用户修改密码的服务层接口</p>
*<p>Description: 处理用户修改密码的业务逻辑</p>
*@author LvHai
*@version 1.0
*/
public interface ModifyPasswordService {

	/**
	*修改用户密码
	*@param userId 用户Id
	*@param oldPassword 旧的密码
	*@param newPassword 新的密码
	*@return 添加成功返回true 失败返回false
	*/
	public boolean updateUserPassword(String userId, String oldPassword, String newPassword);
	
	
}
