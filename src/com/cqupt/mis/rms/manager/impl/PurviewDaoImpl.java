package com.cqupt.mis.rms.manager.impl;

import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.PurviewDao;
import com.cqupt.mis.rms.manager.RolePurviewDao;
import com.cqupt.mis.rms.model.Purviewinfo;
import com.cqupt.mis.rms.model.Rolepurview;

/**
 * <p>
 * Title:管理用户模块信息的接口实现
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author HHY
 * @version 1.0
 * */
public class PurviewDaoImpl extends BaseHibernateDaoSupport implements
		PurviewDao {
	private RolePurviewDao rolePurviewDao;

	public void setRolePurviewDao(RolePurviewDao rolePurviewDao) {
		this.rolePurviewDao = rolePurviewDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purviewinfo> findPurviewListByUserIdAndRoleIdForCommonds(String userId,int roleId) {
		String hql = "select p from UserRoleInfo ur , Rolepurview rp ,Purviewinfo p where ur.userLogin.userId = ? "
				+ "and ur.roleinfo.roleId = rp.roleinfo.roleId "
				+ "and rp.purviewinfo.purviewId = p.purviewId "
				+ "and ur.roleinfo.roleId = ?";
		return getSession().createQuery(hql).setParameter(0, userId).setParameter(1, roleId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purviewinfo> findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(String userId, int roleId,int parentId) {

		String hql = "select p from UserRoleInfo ur , Rolepurview rp ,Purviewinfo p where ur.userLogin.userId = ? "
				+ "and ur.roleinfo.roleId = rp.roleinfo.roleId "
				+ "and rp.purviewinfo.purviewId = p.purviewId and p.parentPurviewinfo.purviewId = ? "
				+ "and ur.roleinfo.roleId = ?";
		return getSession().createQuery(hql).setParameter(0, userId).setParameter(1, parentId).setParameter(2, roleId).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Purviewinfo> findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(int parentId) {
		String hql = "select p from Purviewinfo p where p.parentPurviewinfo.purviewId = ?";
		return  getSession().createQuery(hql).setParameter(0, parentId).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Purviewinfo> findPurviewListByparentId(int parentId) {
		String hql = "from Purviewinfo p where p.parentPurviewinfo.purviewId = ?";
		return getSession().createQuery(hql).setParameter(0, parentId).list();
	}

	@Override
	public void addPurviewInfo(Purviewinfo purview) {
		getHibernateTemplate().save(purview);
	}

	@Override
	public void updatePurview(Purviewinfo purview) {
		Purviewinfo purviewinfo = findPurviewByPurviewId(purview.getPurviewId());
		if (purviewinfo != null) {
			purviewinfo.setParentPurviewinfo(purview.getParentPurviewinfo());
			purviewinfo.setPurviewName(purview.getPurviewName());
			purviewinfo.setPurviewRemark(purview.getPurviewRemark());
			purviewinfo.setPurviewUrl(purview.getPurviewUrl());
			this.getHibernateTemplate().update(purviewinfo);
		}
	}
	@Override
	public void deletePurview(int purviewId) {
		Purviewinfo purviewinfo = findPurviewByPurviewId(purviewId);
		if(purviewinfo!=null){
			Set<Rolepurview> list = purviewinfo.getRolepurviews();
			if(!list.isEmpty()){
				rolePurviewDao.deleteRolePurviewByPurviewId(purviewId);
			}
			this.getHibernateTemplate().delete(purviewinfo);
		}
	}
	@Override
	public void deletePurviewArray(int[] purviewIds) {
		if(purviewIds != null){
			for(int purviewId : purviewIds){
				deletePurview(purviewId);
			}
		}
	}

	@Override
	public Purviewinfo findPurviewByPurviewId(int purviewId) {
		return this.getHibernateTemplate().get(Purviewinfo.class, purviewId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purviewinfo> findPurviewListByUserIdAndRoleIdUsePage(String userId,int roleId, int offset, int pageSize) {
		String hql = "select pur from Purviewinfo pur,UserRoleInfo ur,Rolepurview rp where ur.userLogin.userId = ? "
				+ "and ur.roleinfo.roleId = rp.roleinfo.roleId and rp.purviewinfo.purviewId = pur.purviewId and ur.roleinfo.roleId = ?";
		Object[] values = {userId,roleId};
		return this.findByPage(hql, values, offset, pageSize);
	}

	@Override
	public int findPurviewListNumber() {
		return this.getTotalNumber();
	}


}
