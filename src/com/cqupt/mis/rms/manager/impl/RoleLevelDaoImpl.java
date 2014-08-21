package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.RoleLevelDao;
import com.cqupt.mis.rms.model.RoleLevel;

public class RoleLevelDaoImpl extends BaseHibernateDaoSupport implements
		RoleLevelDao {
	private RoleInfoDao roleInfoDao;

	public void setRoleInfoDao(RoleInfoDao roleInfoDao) {
		this.roleInfoDao = roleInfoDao;
	}

	@Override
	public void addRoleLevelByEntity(RoleLevel roleLevel) {
		this.getHibernateTemplate().persist(roleLevel);
	}

	@Override
	public void delRoleLevelByLevelId(int levelId) {
		RoleLevel roleLevel = findRoleLevelByRoleLevelId(levelId);
		if(roleLevel!=null){
			if(!roleLevel.getRoles().isEmpty()){
				roleInfoDao.delRoleInfoByRoleLevelId(levelId);
			}
			this.getHibernateTemplate().delete(roleLevel);
		}
	}

	@Override
	public void updateRoleLevelByEntity(RoleLevel roleLevel) {
		RoleLevel rLevel = findRoleLevelByRoleLevelId(roleLevel.getId());
		if(rLevel!=null){
			rLevel.setRoleLevelDescription(roleLevel.getRoleLevelDescription());
			rLevel.setRoleLevelName(roleLevel.getRoleLevelName());
			this.getHibernateTemplate().update(rLevel);
		}

	}

	@Override
	public RoleLevel findRoleLevelByRoleLevelId(int roleLevelId) {
		return this.getHibernateTemplate().get(RoleLevel.class, roleLevelId);
	}

	@Override
	public List<RoleLevel> findAllRoleLevel() {
		return this.getHibernateTemplate().loadAll(RoleLevel.class);
	}

}
