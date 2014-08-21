/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.manager;

import com.cqupt.mis.rms.model.CQUPTUser;

/**
*<p>Title:管理参与各类科研信息成员的接口</p>
*<p>Description: 处理用户管理各类科研信息的参与成员时对数据库的操作</p>
*@author LvHai
*@version 1.0
*/
public interface SubmitInfoMemberDao {
	
	/**
	*增加一条参与科研成员的基本信息
	*@param Object
	*@return 添加成功返回true 失败返回false
	*/
	public boolean addInfoMember(Object object);
	
	/**
	*根据姓名返回该成员的信息
	*@param String 成员姓名
	*@return 存在该用户信息返回List<CQUPTUser> 不存在则返回空
	*/
	public CQUPTUser findCQUPTUserByUserName(String userNmae);
}
