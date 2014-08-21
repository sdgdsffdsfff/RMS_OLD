package com.cqupt.mis.rms.test;

import java.util.List;

import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.RoleLevelDao;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.RoleLevel;
import com.cqupt.mis.rms.utils.AbstractTest;

public class RoleInfoDaoImplTest extends AbstractTest {
	private RoleInfoDao roleInfoDao;
	private RoleLevelDao roleLevelDao;
	@Override
	public void init() {
		roleInfoDao = (RoleInfoDao)this.configYourManager("roleInfoDao");
		roleLevelDao = (RoleLevelDao)this.configYourManager("roleLevelDao");
	}
	public void testCheckRoleLevelByUserIdAndRoleLevelId() {
		init();
		try {
			CQUPTRole role = roleInfoDao.checkRoleLevelByUserIdAndRoleLevelId("limin", 3);
			if(role!=null){
				System.out.println("角色名称为："+role.getRoleName());
			}else{
				System.out.println("用户没有该级别的角色");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindRoleInfoList() {
		init();
		try {
			List<CQUPTRole> list = roleInfoDao.findRoleInfoList(0, 20);
			if(!list.isEmpty()){
				for(CQUPTRole role : list){
					System.out.println("角色名称："+role.getRoleName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindRoleInfoListNumber() {
		init();
		try {
			roleInfoDao.findRoleInfoList(0, 20);
			System.out.println("角色总数为："+roleInfoDao.findRoleInfoListNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testAddRoleInfo() {
		init();
		try {
			CQUPTRole roleInfo =new CQUPTRole();
			roleInfo.setRoleName("游客");
			RoleLevel roleLevel = roleLevelDao.findRoleLevelByRoleLevelId(1);
			roleInfo.setRoleLevel(roleLevel);
			roleInfo.setDescription("游客也是普通用户");
			roleInfoDao.addRoleInfo(roleInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testUpdateRoleInfo() {
		init();
		try {
			CQUPTRole roleInfo = roleInfoDao.findRoleInfoByroleId(7);
			roleInfo.setRoleName("匿名");
			roleInfoDao.updateRoleInfo(roleInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDelRoleInfoByRoleId() {
		init();
		try {
			roleInfoDao.delRoleInfoByRoleId(7);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void testDelRoleInfoByRoleLevelId() {
		init();
		try {
			roleInfoDao.delRoleInfoByRoleLevelId(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeleteRoleInfoByRoleIdArray() {
		init();
		try {
			int[] roleIds = {7,8};
			roleInfoDao.deleteRoleInfoByRoleIdArray(roleIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindRoleInfoByroleId() {
		init();
		try {
			CQUPTRole role = roleInfoDao.findRoleInfoByroleId(7);
			if(role!=null){
				System.out.println("角色名称为："+role.getRoleName());
			}else{
				System.out.println("没有找到该角色");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFindCQUPTRoleListByRoleLevelId(){
		init();
		try {
			List<CQUPTRole> list = roleInfoDao.findCQUPTRoleListByRoleLevelId(2);
			if(!list.isEmpty()){
				for(CQUPTRole role : list){
					System.out.println("角色信息为："+role.getRoleName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFindRoleInfoListByuserId() {
		init();
		try {
			List<CQUPTRole> list = roleInfoDao.findRoleInfoListByuserId("ty");
			if(!list.isEmpty()){
				for(CQUPTRole role : list){
					System.out.println("角色信息为："+role.getRoleName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
