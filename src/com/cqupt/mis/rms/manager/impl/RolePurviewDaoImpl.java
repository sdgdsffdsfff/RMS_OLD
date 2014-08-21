package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cqupt.mis.rms.manager.PurviewDao;
import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.RolePurviewDao;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.Purviewinfo;
import com.cqupt.mis.rms.model.Rolepurview;

/**
 * <p>
 * Title:管理角色模块信息的接口实现
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author LM
 * @version 1.0
 * */
@SuppressWarnings("unchecked")
public class RolePurviewDaoImpl extends HibernateDaoSupport implements RolePurviewDao {
	private RoleInfoDao roleInfoDao;
	private PurviewDao purviewDao;

	public void setRoleInfoDao(RoleInfoDao roleInfoDao) {
		this.roleInfoDao = roleInfoDao;
	}

	public void setPurviewDao(PurviewDao purviewDao) {
		this.purviewDao = purviewDao;
	}

	@Override
	public void addRolePurviewByEntity(Rolepurview rolepurview){
		this.getHibernateTemplate().persist(rolepurview);
	}

	@Override
	public void addRolePurviewByRoleIdAndpurviewIdArray(int roleId,int[] purviewIdArr) {
		//在赋予新模块的时候，先删除所有已经有的模块
		deleteRolePurviewByRoleId(roleId);
		CQUPTRole roleInfo = roleInfoDao.findRoleInfoByroleId(roleId);
		if(purviewIdArr!=null){
			for(int purviewId : purviewIdArr){
				Purviewinfo purviewinfo = purviewDao.findPurviewByPurviewId(purviewId);
				Rolepurview rolepurview = new Rolepurview();
				rolepurview.setPurviewinfo(purviewinfo);
				rolepurview.setRoleinfo(roleInfo);
				addRolePurviewByEntity(rolepurview);
			}
		}
	}

	@Override
	public List<Rolepurview> findRolePurviewListByroleId(int roleId) {
		String hql = "from Rolepurview rp where rp.roleinfo.roleId = ? ";
		return getSession().createQuery(hql).setParameter(0, roleId).list();
	}

	@Override
	public void deleteRolePurviewByRoleId(int roleId) {
		String hql ="delete from Rolepurview where roleinfo.roleId = ? ";
		getSession().createQuery(hql).setParameter(0, roleId).executeUpdate();
	}
	
	@Override
	public List<Rolepurview> findRolePurviewListByPurviewId(int purviewId) {
		String hql = "from Rolepurview rp where rp.purviewinfo.purviewId = ?";
		return  getSession().createQuery(hql).setParameter(0, purviewId).list();
	}

	@Override
	public void deleteRolePurviewByPurviewId(int purviewId) {
		String hql ="delete from Rolepurview where purviewinfo.purviewId = ?";
		getSession().createQuery(hql).setParameter(0, purviewId).executeUpdate();
	}

	@Override
	public Rolepurview findRolepurviewByRoleIdAndPurviewId(int roleId,int purviewId) {
		String hql = "from Rolepurview where purviewinfo.purviewId = ? and roleinfo.roleId = ?";
		return (Rolepurview)getSession().createQuery(hql).setParameter(0, purviewId).setParameter(1, roleId).uniqueResult();
	}
}
