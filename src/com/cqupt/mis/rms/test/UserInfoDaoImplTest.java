package com.cqupt.mis.rms.test;

import java.util.List;

import com.cqupt.mis.rms.manager.UserInfoDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.UserLogin;
import com.cqupt.mis.rms.utils.AbstractTest;

public class UserInfoDaoImplTest extends AbstractTest {
	private UserInfoDao userInfoDao;
	@Override
	public void init() {
		userInfoDao = (UserInfoDao)this.configYourManager("userInfoDao");
	}

	public void testLogin() {
		init();
		try {
			UserLogin user = userInfoDao.checkUNameAndUPass("limin", "234");
			if(user!=null){
				System.out.println("登录成功");
			}else{
				System.out.println("登录失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindCQUPTUserListByUserIdAndRoleId() {
		init();
		try {
			List<CQUPTUser> list = userInfoDao.findCQUPTUserListByUserIdAndRoleId("limin", 4);
			if(!list.isEmpty()){
				for(CQUPTUser user : list){
					System.out.println("用户名为："+user.getUserName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindCQUPTUserByRoleId() {
		init();
		try {
			List<CQUPTUser> list = userInfoDao.findCQUPTUserByRoleId(5);
			if(!list.isEmpty()){
				for(CQUPTUser user : list){
					System.out.println("用户名为："+user.getUserName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindUserLoginByUserId() {
		init();
		try {
			UserLogin user = userInfoDao.findUserLoginByUserId("limin");
			if(user!=null){
				System.out.println("用户密码："+user.getUserPwd());
			}else{
				System.out.println("没有该用户");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
