package com.cqupt.mis.rms.test;

import com.cqupt.mis.rms.manager.CollegeInfoDao;
import com.cqupt.mis.rms.manager.RoleCollegeInfoDao;
import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.RoleCollege;
import com.cqupt.mis.rms.utils.AbstractTest;

public class RoleCollegeInfoDaoImplTest extends AbstractTest {
	private RoleCollegeInfoDao roleCollegeInfoDao;
	private CollegeInfoDao collegeInfoDao;
	private RoleInfoDao roleInfoDao;
	@Override
	public void init() {
		roleCollegeInfoDao = (RoleCollegeInfoDao)this.configYourManager("roleCollegeInfoDao");
		collegeInfoDao = (CollegeInfoDao)this.configYourManager("collegeInfoDao");
		roleInfoDao = (RoleInfoDao)this.configYourManager("roleInfoDao");
	}

	public void testAddRoleCollegeByRoleIdAndCollegeIds() {
		init();
		String[] collegeIds = {"01","02","04","05"};
		try {
			roleCollegeInfoDao.addRoleCollegeByRoleIdAndCollegeIds(2, collegeIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testAddRoleCollegeByRoleCollegeEntity() {
		init();
		try {
			CQUPTRole roleInfo = roleInfoDao.findRoleInfoByroleId(2);
			CQUPTCollege collegeInfo = collegeInfoDao.findCQUPTCollegeByCollegeId("03");
			RoleCollege roleCollege = new RoleCollege();
			roleCollege.setCollegeInfo(collegeInfo);
			roleCollege.setRoleInfo(roleInfo);
			roleCollegeInfoDao.addRoleCollegeByRoleCollegeEntity(roleCollege);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public void testDelRoleCollegeByRoleId() {
		init();
		try {
			roleCollegeInfoDao.delRoleCollegeByRoleId(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
