package com.cqupt.mis.rms.service;

import java.util.List;

import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTUser;

public interface SearchCQUPTUserService {
	//根据用户ID查找指定用户
	public CQUPTUser findUserByUserId(String userId);
	
	//根据角色ID查找该用户所管辖的范围
	public List<CQUPTUser> findManageUserByRoleId(int roleId);
	
	//根据学院ID和用户集合查找该用户集合中该学院的用户集合
	public List<CQUPTUser> searchCollegeUserByCollegeId(List<CQUPTUser> cquptUsers,String collegeId);
	
	//根据角色ID查找该角色所管辖的学院集合
	public List<CQUPTCollege> findManageCQUPTCollegeByRoleId(int roleId);
}
