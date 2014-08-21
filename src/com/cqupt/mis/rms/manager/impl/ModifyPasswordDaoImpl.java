/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.manager.impl;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.ModifyPasswordDao;
import com.cqupt.mis.rms.model.UserLogin;

/**
*<p>Title:管理用户修改密码底层接口的实现类</p>
*<p>Description:处理用户修改密码时对数据库的操作</p>
*<p>Company:重邮信管工作室 </p>
*@author LvHai
*@version 1.0
*/
public class ModifyPasswordDaoImpl extends BaseHibernateDaoSupport implements ModifyPasswordDao {

	@Override
	public UserLogin findUserAndPassword(String userId, String passWord) {
		String hql = "from UserLogin user where user.userId = ? and user.userPwd = ?";
		return (UserLogin) getSession().createQuery(hql)
				.setParameter(0, userId).setParameter(1, passWord).uniqueResult();
	}

	@Override
	public void updateUserLoginInfo(UserLogin userLogin) {
		this.getHibernateTemplate().update(userLogin);
	}

}
