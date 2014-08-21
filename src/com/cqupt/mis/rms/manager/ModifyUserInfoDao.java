/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.manager;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.Positions;
import com.cqupt.mis.rms.model.Titles;

/**
*<p>Title:管理用户修改个人信息的底层接口</p>
*<p>Description: 处理用户修改个人信息时对数据库的操作</p>
*<p>Company:重邮信管工作室 </p>
*@author LvHai
*@version 1.0
*/
public interface ModifyUserInfoDao {
	
	/**
	 * 根据用户ID查找用户的信息
	 * @param userId  用户登录Id
	 * @return CQUPTUser 用户信息
	 * */
	public CQUPTUser findUserInfoByUserId(String userId);
	
	/**
	 * 保存修改后的用户信息
	 * @param cquptUser 用户信息
	 * @return void
	 * */
	public void updateUserInfo(CQUPTUser cquptUser);
	
	/**
	 * 增加一条职称或职位信息
	 * @param object
	 */
	public void addTitlesOrPositions(Object object);
	
	/**
	 * 根据用户ID查找用户的职称信息
	 * @param userId
	 * @return List<Titles> 用户职称信息
	 */
	public List<Titles> findTitlesByUserId(String userId);
	
	/**
	 * 根据用户ID查找用户的职务信息
	 * @param userId
	 * @return List<Positions> 用户职务信息
	 */
	public List<Positions> findPositionsByUserId(String userId);
}
