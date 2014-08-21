package com.cqupt.mis.rms.manager.impl;

import java.util.List;

import com.cqupt.mis.rms.manager.BaseHibernateDaoSupport;
import com.cqupt.mis.rms.manager.UserInfoDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.UserLogin;
import com.cqupt.mis.rms.utils.EncryptUtils;

/**
 * <p>Title:管理用户信息的接口实现</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
/**
 * <p>
 * Title:管理用户信息的接口实现
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
public class UserInfoDaoImpl extends BaseHibernateDaoSupport implements
		UserInfoDao {

	@Override
	public void addUserLoginByEntity(UserLogin user) {
		user.setUserPwd(EncryptUtils.setUPassEncrypt(user.getUserPwd()));
		this.getHibernateTemplate().persist(user);
	}

	@Override
	public void addCQUPTUserByEntity(CQUPTUser user) {
		this.getHibernateTemplate().persist(user);
	}

	@Override
	public UserLogin checkUNameAndUPass(String userId, String password) {
		String hql = "from UserLogin user where user.userId = ? and user.userPwd = ?";
		password = EncryptUtils.setUPassEncrypt(password);
		return (UserLogin) getSession().createQuery(hql)
				.setParameter(0, userId).setParameter(1, password)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CQUPTUser> findCQUPTUserListByUserIdAndRoleId(String userId,
			int roleId) {
		String hql = "select user from CQUPTUser user,UserLogin ulogin,UserRoleInfo ur,RoleCollege rc "
				+ "where ulogin.userId = ur.userLogin.userId and ur.roleinfo.roleId=rc.roleInfo.roleId and rc.collegeInfo.collegeId = user.cquptCollege.collegeId "
				+ "and ulogin.userId = ? and ur.roleinfo.roleId = ?";
		return getSession().createQuery(hql).setParameter(0, userId)
				.setParameter(1, roleId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CQUPTUser> findCQUPTUserByRoleId(int roleId) {
		String hql = "select user from CQUPTUser user ,UserRoleInfo ur where ur.roleinfo.roleId = ? and ur.userLogin.userId = user.userId ";
		return getSession().createQuery(hql).setParameter(0, roleId).list();
	}

	@Override
	public UserLogin findUserLoginByUserId(String userId) {
		return this.getHibernateTemplate().get(UserLogin.class, userId);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CQUPTUser> findUser() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from CQUPTUser");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkUserId(String userId) {
		// TODO Auto-generated method stub
		List<CQUPTUser> list= this.getSession().createQuery("from CQUPTUser user where user.userId =?").setParameter(0, userId).list();
		if(list.size()==0){//不重复
			return true;
		}else
			return false;
	}
	
}
