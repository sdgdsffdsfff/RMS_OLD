package com.cqupt.mis.rms.test;

import java.util.List;

import com.cqupt.mis.rms.manager.PurviewDao;
import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.RolePurviewDao;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.Purviewinfo;
import com.cqupt.mis.rms.model.Rolepurview;
import com.cqupt.mis.rms.utils.AbstractTest;

public class RolePurviewDaoImplTest extends AbstractTest {
	private RolePurviewDao rolePurviewDao;
	private RoleInfoDao roleInfoDao;
	private PurviewDao purviewDao;
	@Override
	public void init() {
		rolePurviewDao = (RolePurviewDao)this.configYourManager("rolePurviewDao");
		roleInfoDao = (RoleInfoDao)this.configYourManager("roleInfoDao");
		purviewDao = (PurviewDao)this.configYourManager("purviewDao");
	}

	public void testAddRolePurviewByEntity() {
		init();
		try {
			Rolepurview rolepurview = new Rolepurview();
			CQUPTRole roleinfo = roleInfoDao.findRoleInfoByroleId(1);
			Purviewinfo purviewinfo = purviewDao.findPurviewByPurviewId(3);
			rolepurview.setPurviewinfo(purviewinfo);
			rolepurview.setRoleinfo(roleinfo);
			rolePurviewDao.addRolePurviewByEntity(rolepurview);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testAddRolePurviewByRoleIdAndpurviewIdArray() {
		init();
		try {
			int[] purviewIdArr = {1,2,3,4,5,6,7,8};
			rolePurviewDao.addRolePurviewByRoleIdAndpurviewIdArray(1,purviewIdArr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindRolePurviewListByroleId() {
		init();
		try {
			List<Rolepurview> list = rolePurviewDao.findRolePurviewListByroleId(1);
			if(!list.isEmpty()){
				for(Rolepurview rp : list){
					System.out.println("模块编号为："+rp.getPurviewinfo().getPurviewId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeleteRolePurviewByRoleId() {
		init();
		try {
			rolePurviewDao.deleteRolePurviewByRoleId(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFindRolePurviewListByPurviewId() {
		init();
		try {
			List<Rolepurview> list = rolePurviewDao.findRolePurviewListByPurviewId(2);
			if(!list.isEmpty()){
				for(Rolepurview rp : list){
					System.out.println("角色编号为："+rp.getRoleinfo().getRoleId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeleteRolePurviewByPurviewId() {
		init();
		try {
			rolePurviewDao.deleteRolePurviewByPurviewId(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFindRolepurviewByRoleIdAndPurviewId(){
		init();
		try {
			Rolepurview rolePurview  = rolePurviewDao.findRolepurviewByRoleIdAndPurviewId(1,2);
			if(rolePurview!=null){
				System.out.println("角色模块:"+rolePurview);
			}else{
				System.out.println("角色模块为空");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
