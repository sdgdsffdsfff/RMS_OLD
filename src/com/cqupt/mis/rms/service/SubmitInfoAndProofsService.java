/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.Proofs;

/**
*<p>Title:管理各类科研信息总包含基本信息及旁证材料（包括参与成员）的服务层接口</p>
*<p>Description: 处理用户对科研信息的业务逻辑</p>
*@author LvHai
*@version 1.0
*/
public interface SubmitInfoAndProofsService {
	/**
	*将一条科研信息传给Dao层
	*@param Object
	*@return 添加成功返回true，失败返回 false
	*/
	public boolean submitInfo(Object object);
	/**
	*添加一组旁证材料信息
	*@param List<Proofs> 旁证材料信息组
	*@return 添加成功返回true 失败返回false
	*/
	public boolean submitProofs(List<Proofs> proofs);
	/**
	 * 添加科研信息成员信息
	 * @param flag 标志成员信息的参数
	 * @param memberListObject 成员信息列表
	 * @return boolean 修改成功则返回true，否则返回false
	 */
	public boolean submitResearchMemberInfo(int flag, 
			Object memberListObject);
	
}
