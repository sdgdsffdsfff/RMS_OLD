/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.manager;

import com.cqupt.mis.rms.model.Proofs;

/**
*<p>Title:管理各类科研信息的接口</p>
*<p>Description: 处理用户管理各类科研信息时对数据库的操作</p>
*@author LvHai
*@version 1.0
*/
public interface SubmitInfoAndProofsDao {
	
	/**
	*增加一条关于科研的基本信息
	*@param Object
	*@return 添加成功返回true 失败返回false
	*/
	public boolean addInfo(Object object);
	
	/**
	*增加一条关于旁证材料的信息
	*@param Proofs 旁证材料信息
	*@return void
	*/
	public void addProof(Proofs proof);
}
