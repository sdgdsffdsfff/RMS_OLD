/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.ModifyUserInfoDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.Positions;
import com.cqupt.mis.rms.model.Titles;

/**
*<p>Title:管理用户修改个人信息底层接口的实现类</p>
*<p>Description:处理用户修改个人信息时对数据库的操作</p>
*<p>Company:重邮信管工作室 </p>
*@author LvHai
*@version 1.0
*/
public class ModifyUserInfoDaoImpl extends BaseHibernateDaoSupport implements ModifyUserInfoDao {

	@Override
	public CQUPTUser findUserInfoByUserId(String userId) {
		String hql = "from CQUPTUser cquptUser where cquptUser.userId = ? ";
		return (CQUPTUser)getSession().createQuery(hql).setParameter(0, userId).uniqueResult();
	}

	@Override
	public void updateUserInfo(CQUPTUser cquptUser) {
		this.getHibernateTemplate().update(cquptUser);
	}

	@Override
	public void addTitlesOrPositions(Object object) {
		this.getHibernateTemplate().persist(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Titles> findTitlesByUserId(String userId) {
		String hql ="from Titles titles where titles.user.userId = ?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Positions> findPositionsByUserId(String userId) {
		String hql = "from Positions positions where positions.user.userId = ?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}

}
