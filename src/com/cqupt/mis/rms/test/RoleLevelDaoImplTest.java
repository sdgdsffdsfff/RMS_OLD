package com.cqupt.mis.rms.test;

import java.util.List;

import com.cqupt.mis.rms.manager.RoleLevelDao;
import com.cqupt.mis.rms.model.RoleLevel;
import com.cqupt.mis.rms.utils.AbstractTest;

public class RoleLevelDaoImplTest extends AbstractTest {
	private RoleLevelDao roleLevelDao;

	@Override
	public void init() {
		roleLevelDao = (RoleLevelDao)this.configYourManager("roleLevelDao");
	}

	public void testAddRoleLevelByEntity() {
		init();
		try {
			RoleLevel roleLevel = new RoleLevel();
			roleLevel.setRoleLevelDescription("测试级别");
			roleLevel.setRoleLevelName("测试级别2");
			roleLevelDao.addRoleLevelByEntity(roleLevel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDelRoleLevelByLevelId() {
		init();
		try {
			roleLevelDao.delRoleLevelByLevelId(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testUpdateRoleLevelByEntity() {
		init();
		try {
			RoleLevel roleLevel = roleLevelDao.findRoleLevelByRoleLevelId(5);
			roleLevel.setRoleLevelDescription("用户删除的测试");
			roleLevelDao.updateRoleLevelByEntity(roleLevel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindRoleLevelByRoleLevelId() {
		init();
		try {
			RoleLevel roleLevel = roleLevelDao.findRoleLevelByRoleLevelId(4);
			if(roleLevel!=null){
				System.out.println("角色级别名称为："+roleLevel.getRoleLevelName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindAllRoleLevel() {
		init();
		try {
			List<RoleLevel> list = roleLevelDao.findAllRoleLevel();
			if(!list.isEmpty()){
				for(RoleLevel roleLevel : list){
					System.out.println("角色级别名称为："+roleLevel.getRoleLevelName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
