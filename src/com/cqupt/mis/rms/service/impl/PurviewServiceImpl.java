package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.CollegeInfoDao;
import com.cqupt.mis.rms.manager.PurviewDao;
import com.cqupt.mis.rms.manager.RoleCollegeInfoDao;
import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.RoleLevelDao;
import com.cqupt.mis.rms.manager.RolePurviewDao;
import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.Purviewinfo;
import com.cqupt.mis.rms.model.RoleLevel;
import com.cqupt.mis.rms.model.Rolepurview;
import com.cqupt.mis.rms.service.PurviewService;
import com.cqupt.mis.rms.service.model.MenuInfo;

public class PurviewServiceImpl implements PurviewService {
	private PurviewDao purviewDao;
	private RoleInfoDao roleInfoDao;
	private RoleLevelDao roleLevelDao;
	private RolePurviewDao rolePurviewDao;
	private CollegeInfoDao collegeInfoDao;
	private RoleCollegeInfoDao roleCollegeInfoDao;

	public void setPurviewDao(PurviewDao purviewDao) {
		this.purviewDao = purviewDao;
	}

	public void setRoleInfoDao(RoleInfoDao roleInfoDao) {
		this.roleInfoDao = roleInfoDao;
	}

	public void setRoleLevelDao(RoleLevelDao roleLevelDao) {
		this.roleLevelDao = roleLevelDao;
	}

	public void setRolePurviewDao(RolePurviewDao rolePurviewDao) {
		this.rolePurviewDao = rolePurviewDao;
	}

	public void setCollegeInfoDao(CollegeInfoDao collegeInfoDao) {
		this.collegeInfoDao = collegeInfoDao;
	}

	public void setRoleCollegeInfoDao(RoleCollegeInfoDao roleCollegeInfoDao) {
		this.roleCollegeInfoDao = roleCollegeInfoDao;
	}

	@Override
	public List<Purviewinfo> findPurviewListByUserIdAndRoleIdForCommonds(
			String userId, int roleId) {
		try {
			List<Purviewinfo> list = purviewDao
					.findPurviewListByUserIdAndRoleIdForCommonds(userId, roleId);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Purviewinfo> findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(
			String userId, int roleId, int parentId) {
		try {
			List<Purviewinfo> list = purviewDao
					.findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(
							userId, roleId, parentId);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Rolepurview findRolepurviewByRoleIdAndPurviewId(int roleId,int purviewId) {
		return rolePurviewDao.findRolepurviewByRoleIdAndPurviewId(roleId, purviewId);
	}
	
	@Override
	public List<MenuInfo> findMenuListByUserIdAndRoleId(String userId,
			int roleId) {
		// 获取满足用户Id和角色Id的所有的一级菜单
		List<Purviewinfo> firstList = findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(
				userId, roleId, 0);
		// 存放封装过后的菜单
		List<MenuInfo> menuList = new ArrayList<MenuInfo>();
		if(firstList != null){
			for (Purviewinfo first : firstList) {
				MenuInfo menu = new MenuInfo();
				menu.setFirst(first);
				// 获取该一级菜单下面的是该用户在该角色下面的二级菜单
				List<Purviewinfo> second = findPurviewListByUserIdAndRoleIdAndParentIdForCommonds(
						userId, roleId, first.getPurviewId());
				menu.setSecond(second);
				menuList.add(menu);
			}
		}
		return menuList;
	}

	@Override
	public boolean addRolePurviewByRoleIdAndpurviewIdArray(int roleId,
			int[] purviewIdArray) {
		try {
			rolePurviewDao.addRolePurviewByRoleIdAndpurviewIdArray(roleId,
					purviewIdArray);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CQUPTRole> findRoleInfoList(int offset, int pageSize) {
		try {
			List<CQUPTRole> list = roleInfoDao.findRoleInfoList(offset,
					pageSize);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addRoleInfo(CQUPTRole roleInfo) {
		try {
			roleInfoDao.addRoleInfo(roleInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateRoleInfo(CQUPTRole roleInfo) {
		try {
			roleInfoDao.updateRoleInfo(roleInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delRoleInfoByRoleId(int roleId) {
		try {
			roleInfoDao.delRoleInfoByRoleId(roleId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delRoleInfoByRoleLevelId(int roleLevelId) {
		try {
			roleInfoDao.delRoleInfoByRoleLevelId(roleLevelId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteRoleInfoByRoleIdArray(int[] roleIds) {
		try {
			roleInfoDao.deleteRoleInfoByRoleIdArray(roleIds);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CQUPTRole findRoleInfoByroleId(int roleId) {
		try {
			CQUPTRole role = roleInfoDao.findRoleInfoByroleId(roleId);
			if (role != null) {
				return role;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CQUPTRole> findCQUPTRoleListByRoleLevelId(int roleLevelId) {
		try {
			List<CQUPTRole> list = roleInfoDao
					.findCQUPTRoleListByRoleLevelId(roleLevelId);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addRoleLevelByEntity(RoleLevel roleLevel) {
		try {
			roleLevelDao.addRoleLevelByEntity(roleLevel);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delRoleLevelByLevelId(int levelId) {
		try {
			roleLevelDao.delRoleLevelByLevelId(levelId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateRoleLevelByEntity(RoleLevel roleLevel) {
		try {
			roleLevelDao.updateRoleLevelByEntity(roleLevel);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public RoleLevel findRoleLevelByRoleLevelId(int roleLevelId) {
		try {
			RoleLevel roleLevel = roleLevelDao
					.findRoleLevelByRoleLevelId(roleLevelId);
			if (roleLevel != null) {
				return roleLevel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RoleLevel> findAllRoleLevel() {
		try {
			List<RoleLevel> list = roleLevelDao.findAllRoleLevel();
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CQUPTCollege> findCQUPTCollegeListByRoleId(int roleId) {
		try {
			List<CQUPTCollege> list = collegeInfoDao
					.findCQUPTCollegeListByRoleId(roleId);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addRoleCollegeByRoleIdAndCollegeIds(int roleId,
			String[] collegeIds) {
		try {
			roleCollegeInfoDao.addRoleCollegeByRoleIdAndCollegeIds(roleId,
					collegeIds);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
