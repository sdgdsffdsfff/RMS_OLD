package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.UserInfoDao;
import com.cqupt.mis.rms.manager.UserRoleInfoDao;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.UserLogin;
import com.cqupt.mis.rms.model.UserRoleInfo;
/**
 * <p>Title:管理用户和角色信息的接口实现</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
public class UserRoleInfoDaoImpl extends HibernateDaoSupport implements UserRoleInfoDao {
	private UserInfoDao userInfoDao;
	private RoleInfoDao roleInfoDao;
	
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	public void setRoleInfoDao(RoleInfoDao roleInfoDao) {
		this.roleInfoDao = roleInfoDao;
	}
	@Override
	public void addUserRoleInfo(String userID, int[] RoleIdArr) {
		//为用户重新赋予角色信息之前，需要先删除已经有的角色信息
		deleteUserRoleInfoByUserId(userID);
		UserLogin userLogin = userInfoDao.findUserLoginByUserId(userID);
		if(RoleIdArr!=null){
			for(int roleId : RoleIdArr){
				UserRoleInfo userRoleInfo = new UserRoleInfo();
				CQUPTRole roleinfo = roleInfoDao.findRoleInfoByroleId(roleId);
				userRoleInfo.setUserLogin(userLogin);
				userRoleInfo.setRoleinfo(roleinfo);
				this.getHibernateTemplate().persist(userRoleInfo);
			}
		}
	}
	@Override
	public void deleteUserRoleInfoByUserId(String userId) {
		String hql = "delete from UserRoleInfo ur  where ur.userLogin.userId = ? ";
		getSession().createQuery(hql).setParameter(0, userId).executeUpdate();
	}
	@Override
	public void deleteUserRoleInfoByRoleId(int roleId) {
		String hql = "delete from UserRoleInfo ur  where ur.roleinfo.roleId = ? ";
		getSession().createQuery(hql).setParameter(0, roleId).executeUpdate();
	}
	@Override
	public List<UserRoleInfo> findAllUserRoleInfo() {
		return this.getHibernateTemplate().loadAll(UserRoleInfo.class);
	}
}
