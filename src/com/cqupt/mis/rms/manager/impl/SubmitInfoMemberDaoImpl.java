/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.manager.impl;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.SubmitInfoMemberDao;
import com.cqupt.mis.rms.model.CQUPTUser;

/**
*<p>Title:管理参与各类科研信息成员的实现类</p>
*<p>Description:处理用户管理各类科研信息的参与成员时对数据库的操作</p>
*@author LvHai
*@version 1.0
*/
public class SubmitInfoMemberDaoImpl extends BaseHibernateDaoSupport implements SubmitInfoMemberDao {

	@Override
	public boolean addInfoMember(Object object) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			this.getHibernateTemplate().persist(object);
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public CQUPTUser findCQUPTUserByUserName(String userNmae) {
		// TODO Auto-generated method stub
		String hql = "from CQUPTUser cquptuser where cquptuser.userName = :username ";
		return (CQUPTUser) this.getSession().createQuery(hql).setParameter("username", userNmae).uniqueResult();
	}

}
