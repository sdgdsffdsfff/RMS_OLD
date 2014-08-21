/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.service;


import com.cqupt.mis.rms.model.CQUPTUser;

/**
*<p>Title:管理用户修改个人信息的服务层接口</p>
*<p>Description: 处理用户修改个人信息时对数据库的操作</p>
*<p>Company:重邮信管工作室 </p>
*@author LvHai
*@version 1.0
*/
public interface ModifyUserInfoService {
	
	/**
	 * 保存修改后的用户信息
	 * @param cquptUser 用户信息
	 * @return void
	 * */
	public boolean modifyUserInfo(CQUPTUser cquptUser);
	
	/**
	 * 根据用户ID查找用户信息
	 * @param userId 用户信息
	 * @return CQUPTUser 用户信息
	 * */
	public CQUPTUser findUserInfoByUserId(String userId);
	
	/**
	 * 更新个人职称或职位信息
	 * @param object
	 * @return 更新成功返回true，失败返回false
	 */
	public boolean updateTitlesOrPositions(Object object);
}
