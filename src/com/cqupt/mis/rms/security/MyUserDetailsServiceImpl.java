/**
 * 
 */
package com.cqupt.mis.rms.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.UserInfoDao;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.UserLogin;
import com.cqupt.mis.rms.utils.EncryptUtils;


/**
 * 实现SpringSecurity的UserDetailsService接口,获取用户Detail信息(用户名，密码，状态信息，用户权限)
 * 
 * @author Bern
 *
 */
public class MyUserDetailsServiceImpl implements UserDetailsService{
	private UserInfoDao userInfoDao;
	private RoleInfoDao roleInfoDao;
	
	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		
		//根据用户名查找用户的权限信息
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		List<CQUPTRole> list1 = roleInfoDao.findRoleInfoListByuserId(userId);
		for (CQUPTRole cquptRole : list1) {
			GrantedAuthorityImpl authority = new GrantedAuthorityImpl(String.valueOf(cquptRole.getRoleId()));
			auths.add(authority);
		}
		
		/*
		 * 根据用户名得到用户密码等信息,必须返回已解密的密码
		 */
		UserLogin userLogin = userInfoDao.findUserLoginByUserId(userId);
		String password = EncryptUtils.getDesString(userLogin.getUserPwd());	
		
		return new User(userLogin.getUserId(), password, true, true, true, true, auths);
	}

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public RoleInfoDao getRoleInfoDao() {
		return roleInfoDao;
	}

	public void setRoleInfoDao(RoleInfoDao roleInfoDao) {
		this.roleInfoDao = roleInfoDao;
	}
}
