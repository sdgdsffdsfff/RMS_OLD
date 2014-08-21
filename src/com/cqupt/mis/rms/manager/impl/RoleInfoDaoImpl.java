package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.RoleCollegeInfoDao;
import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.RolePurviewDao;
import com.cqupt.mis.rms.manager.UserRoleInfoDao;
import com.cqupt.mis.rms.model.CQUPTRole;

/**
 * <p>
 * Title:角色信息管理的接口实现
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

public class RoleInfoDaoImpl extends BaseHibernateDaoSupport implements
		RoleInfoDao {

	private RolePurviewDao rolePurviewDao;
	private RoleCollegeInfoDao roleCollegeInfoDao;
	private UserRoleInfoDao userRoleInfoDao;

	public void setRolePurviewDao(RolePurviewDao rolePurviewDao) {
		this.rolePurviewDao = rolePurviewDao;
	}

	public void setRoleCollegeInfoDao(RoleCollegeInfoDao roleCollegeInfoDao) {
		this.roleCollegeInfoDao = roleCollegeInfoDao;
	}

	public void setUserRoleInfoDao(UserRoleInfoDao userRoleInfoDao) {
		this.userRoleInfoDao = userRoleInfoDao;
	}

	@Override
	public CQUPTRole checkRoleLevelByUserIdAndRoleLevelId(String userId,
			int roleLevelId) {
		String hql = "select r from CQUPTRole r,UserRoleInfo ur where ur.userLogin.userId = ? and ur.roleinfo.roleId = r.roleId and r.roleLevel.id = ?";
		return (CQUPTRole) getSession().createQuery(hql)
				.setParameter(0, userId).setParameter(1, roleLevelId)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CQUPTRole> findRoleInfoList(int offset, int pageSize) {
		String hql = "from CQUPTRole";
		return findByPage(hql, offset, pageSize);
	}

	@Override
	public int findRoleInfoListNumber() {
		return this.getTotalNumber();
	}

	@Override
	public void addRoleInfo(CQUPTRole roleInfo) {
		this.getHibernateTemplate().persist(roleInfo);
	}

	@Override
	public void updateRoleInfo(CQUPTRole roleInfo) {
		CQUPTRole rInfo = findRoleInfoByroleId(roleInfo.getRoleId());
		if (rInfo != null) {
			rInfo.setDescription(roleInfo.getDescription());
			rInfo.setRoleLevel(roleInfo.getRoleLevel());
			rInfo.setRoleName(roleInfo.getRoleName());
			this.getHibernateTemplate().update(rInfo);
		}
	}

	@Override
	public void delRoleInfoByRoleId(int roleId) {
		CQUPTRole rInfo = findRoleInfoByroleId(roleId);
		if (rInfo != null) {
			if (!(rInfo.getRolepurviews().isEmpty())) {
				rolePurviewDao.deleteRolePurviewByRoleId(roleId);
			}
			if (!rInfo.getRoleColleges().isEmpty()) {
				roleCollegeInfoDao.delRoleCollegeByRoleId(roleId);
			}
			//如果删除角色，则该角色下面的所有用户也将被删除——是删除用户角色配置表里面的信息，不是删除用户表里面的用户信息
			userRoleInfoDao.deleteUserRoleInfoByRoleId(roleId);
			this.getHibernateTemplate().delete(rInfo);
		}
	}

	@Override
	public void delRoleInfoByRoleLevelId(int roleLevelId) {
		List<CQUPTRole> list = findCQUPTRoleListByRoleLevelId(roleLevelId);
		if (!list.isEmpty()) {
			for (CQUPTRole role : list) {
				delRoleInfoByRoleId(role.getRoleId());
			}
		}
	}

	@Override
	public void deleteRoleInfoByRoleIdArray(int[] roleIds) {
		if (roleIds != null) {
			for (int roleId : roleIds) {
				delRoleInfoByRoleId(roleId);
			}
		}
	}

	@Override
	public CQUPTRole findRoleInfoByroleId(int roleId) {
		return this.getHibernateTemplate().get(CQUPTRole.class, roleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CQUPTRole> findCQUPTRoleListByRoleLevelId(int roleLevelId) {
		String hql = "from CQUPTRole where roleLevel.id = ?";
		return getSession().createQuery(hql).setParameter(0, roleLevelId)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CQUPTRole> findRoleInfoListByuserId(String userId) {
		String hql = "select role from UserLogin user ,UserRoleInfo ur,CQUPTRole role "
				+ "where user.userId = ? and user.userId = ur.userLogin.userId and ur.roleinfo.roleId = role.roleId ";
		return this.getSession().createQuery(hql).setParameter(0, userId)
				.list();
	}

}