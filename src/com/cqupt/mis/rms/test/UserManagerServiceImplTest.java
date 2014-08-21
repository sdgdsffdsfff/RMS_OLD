package com.cqupt.mis.rms.test;

import java.io.File;

import org.junit.Test;

import com.cqupt.mis.rms.manager.CollegeInfoDao;
import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.UserLogin;
import com.cqupt.mis.rms.service.UserManagerService;
import com.cqupt.mis.rms.utils.AbstractTest;

public class UserManagerServiceImplTest extends AbstractTest {
	private UserManagerService userManagerService;
	private CollegeInfoDao collegeInfoDao; 
	
	@Override
	public void init() {
		userManagerService = (UserManagerService)this.configYourManager("userManagerService");
		collegeInfoDao = (CollegeInfoDao)this.configYourManager("collegeInfoDao");
	}

	@Test
	public void testAddUserLoginAndCquptUser() {
		init();
		UserLogin uLogin = new UserLogin();
		CQUPTUser cUser = new CQUPTUser();
		uLogin.setUserId("wy");
		uLogin.setUserPwd("123");
		cUser.setUserLogin(uLogin);
		CQUPTCollege cquptCollege = collegeInfoDao.findCQUPTCollegeByCollegeId("01");
		cUser.setCquptCollege(cquptCollege);
		cUser.setDepartment("管理信息系统研究所");
		cUser.setUserName("王永");
		cUser.setGender("男");
		userManagerService.addUserLoginAndCquptUser(uLogin, cUser);
	}

	@Test
	public void testCheckUNameAndUPass() {
		init();
		//已经在web端进行了测试
	}

	@Test
	public void testCheckRoleLevelByUserIdAndRoleLevelId() {
		init();
		//已经在web端进行了测试
	}

	@Test
	public void testReadUserBasicInfoExceltoDB() {
		init();
		File file = new File("F://1.xls");
		userManagerService.readUserBasicInfoExceltoDB(file);
	}

}
