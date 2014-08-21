package com.cqupt.mis.rms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.RoleCollege;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;

public class SearchCQUPTUserServiceImpl implements SearchCQUPTUserService {
	private SearchDao searchDao;
	
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	@Override
	public CQUPTUser findUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return this.searchDao.SearchUniqueObjectsByFactor("CQUPTUser", "userId", userId);
	}

	@Override
	public List<CQUPTUser> findManageUserByRoleId(int roleId) {
		// TODO Auto-generated method stub
		List<RoleCollege> roleColleges = this.searchDao.SearchObjectsByFactor("RoleCollege", "roleInfo.roleId", roleId);
		List<CQUPTUser> cquptUsers = new ArrayList<CQUPTUser>();
		for(int i=0;i<roleColleges.size();i++){
			List<CQUPTUser> cquptUser = this.searchDao.SearchObjectsByFactor("CQUPTUser", "cquptCollege.collegeId", roleColleges.get(i).getCollegeInfo().getCollegeId());
			for(int j=0;j<cquptUser.size();j++){
				cquptUsers.add(cquptUser.get(j));
			}
		}
		return cquptUsers;
	}

	@Override
	public List<CQUPTUser> searchCollegeUserByCollegeId(List<CQUPTUser> cquptUsers,String collegeId) {
		// TODO Auto-generated method stub
		List<CQUPTUser> cquptUser = new ArrayList<CQUPTUser>();
		for(int i=0;i<cquptUsers.size();i++){
			if(cquptUsers.get(i).getCquptCollege().getCollegeId().equals(collegeId)){
				cquptUser.add(cquptUsers.get(i));
			}
		}
		return cquptUser;
	}

	@Override
	public List<CQUPTCollege> findManageCQUPTCollegeByRoleId(int roleId) {
		// TODO Auto-generated method stub
		List<CQUPTCollege> cquptColleges = new ArrayList<CQUPTCollege>();
		List<RoleCollege> roleColleges = this.searchDao.SearchObjectsByFactor("RoleCollege", "roleInfo.roleId", roleId);
		for(int i=0;i<roleColleges.size();i++){
			cquptColleges.add((CQUPTCollege)this.searchDao.SearchUniqueObjectsByFactor("CQUPTCollege", "collegeId", roleColleges.get(i).getCollegeInfo().getCollegeId()));
		}
		return cquptColleges;
	}

}
