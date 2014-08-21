package com.cqupt.mis.rms.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;

import com.cqupt.mis.rms.manager.CollegeInfoDao;
import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.UserInfoDao;
import com.cqupt.mis.rms.manager.UserRoleInfoDao;
import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.UserLogin;
import com.cqupt.mis.rms.service.UserManagerService;
import com.cqupt.mis.rms.service.model.UserAndRole;
import com.cqupt.mis.rms.utils.DoString;

/**
 * <p>
 * Title:管理用户信息的服务曾接口实现类
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author LM
 * @version 1.0
 * */
public class UserManagerServiceImpl implements UserManagerService {
	// 注入管理用户信息的底层接口
	private UserInfoDao userInfoDao;
	// 注入用户角色信息的底层接口
	private RoleInfoDao roleInfoDao;
	//注入管理学院信息的接口
	private CollegeInfoDao collegeInfoDao;
	//注入用户角色信息接口
	private UserRoleInfoDao userRoleInfoDao;

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public void setRoleInfoDao(RoleInfoDao roleInfoDao) {
		this.roleInfoDao = roleInfoDao;
	}

	public void setCollegeInfoDao(CollegeInfoDao collegeInfoDao) {
		this.collegeInfoDao = collegeInfoDao;
	}
	
	public void setUserRoleInfoDao(UserRoleInfoDao userRoleInfoDao) {
		this.userRoleInfoDao = userRoleInfoDao;
	}

	@Override
	public boolean addUserLoginAndCquptUser(UserLogin uLogin, CQUPTUser cUser) {
		try {
			userInfoDao.addUserLoginByEntity(uLogin);
			userInfoDao.addCQUPTUserByEntity(cUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkUNameAndUPass(String userId, String userpwd) {
		try {
			UserLogin user = userInfoDao.checkUNameAndUPass(userId, userpwd);
			if (user != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CQUPTRole checkRoleLevelByUserIdAndRoleLevelId(String userId,
			int roleLevelId) {
		try {
			CQUPTRole uRole = roleInfoDao.checkRoleLevelByUserIdAndRoleLevelId(
					userId, roleLevelId);
			if (uRole != null) {
				return uRole;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean readUserBasicInfoExceltoDB(File excelfile) {
		// 读入数据库
		if (excelfile != null || !"".equals(excelfile)) {
			try {
				jxl.Workbook wb = Workbook.getWorkbook(excelfile); // 获取工作薄
				jxl.Sheet st = wb.getSheet(0);// 得到工作薄中的第一个工作表
				/*** 下面是导入到教师基本信息表里面的数据 ***/
				String userId = ""; // 用户登录Id
				String collegeId = "";// 学院编号
				String department = "";// 部门名称
				String userName = "";//真实姓名
				String gender = "";// 性别
				String origin = "";// 籍贯
				String nationality = "";// 民族
				String birthday = "";// 生日
				String politicalStatus = "";// 政治面貌
				String timeJoinParty = "";// 参加党派时间
				String timeBeginCqupt = "";// 进入重邮时间
				String timeBeginWork = "";// 参加工作时间
				String firstDegree = "";// 第一学位
				String firstProfessionalName = "";// 第一学位专业名称
				String firstGraduateSchool = "";// 第一学位毕业学校
				String lastDegree = "";// 最后学位
				String lastProfessionalName = "";// 最后学位专业名称
				String lastGraduateSchool = "";// 最后学位毕业学校
				String lastAcademic = "";// 最后学历
				/*** 下面是员工登录信息表的数据 ***/
				String userPwd = "123"; // 初始密码，默认设置为123，这里可以修改
				// 循环遍历sheet中的所有内容
				for (int i = 1; i < st.getRows(); i++) { // 行数从第2行开始，去掉标题行，st.getRows()返回总行数
					userId = DoString.nulltoEmptyString(st.getCell(0, i).getContents());// 第一列
					collegeId = DoString.nulltoEmptyString(st.getCell(1, i).getContents());// 第二列
					department = DoString.nulltoEmptyString(st.getCell(2, i).getContents());// 第三列
					userName =  DoString.nulltoEmptyString(st.getCell(3, i).getContents());// 第四列
					gender = DoString.nulltoEmptyString(st.getCell(4, i).getContents());;// 第五列
					origin = DoString.nulltoEmptyString(st.getCell(5, i).getContents());// 第六列
					nationality = DoString.nulltoEmptyString(st.getCell(6, i).getContents());// 第七列
					birthday = DoString.nulltoEmptyString(st.getCell(7, i).getContents());// 第八列
					politicalStatus = DoString.nulltoEmptyString(st.getCell(8, i).getContents());// 第九列
					timeJoinParty = DoString.nulltoEmptyString(st.getCell(9, i).getContents());// 第十列
					timeBeginCqupt = DoString.nulltoEmptyString(st.getCell(10, i).getContents());// 第十一列
					timeBeginWork = DoString.nulltoEmptyString(st.getCell(11,i).getContents());// 第十二列
					firstDegree = DoString.nulltoEmptyString(st.getCell(12,i).getContents());// 第十三列
					firstProfessionalName = DoString.nulltoEmptyString(st.getCell(13, i).getContents());// 第十四列
					firstGraduateSchool = DoString.nulltoEmptyString(st.getCell(14, i).getContents());// 第十五列
					lastDegree = DoString.nulltoEmptyString(st.getCell(15, i).getContents());// 第十六列
					lastProfessionalName = DoString.nulltoEmptyString(st.getCell(16, i).getContents());// 第十七列
					lastGraduateSchool = DoString.nulltoEmptyString(st.getCell(17, i).getContents());// 第十八列
					lastAcademic = DoString.nulltoEmptyString(st.getCell(18, i).getContents());// 第十九列
					//设置登录信息表内容
					UserLogin uLogin = new UserLogin();
					uLogin.setUserId(userId);
					uLogin.setUserPwd(userPwd);
					//设置基本信息表的内容
					CQUPTUser cUser = new CQUPTUser();
					cUser.setUserLogin(uLogin);
					CQUPTCollege cquptCollege = collegeInfoDao.findCQUPTCollegeByCollegeId(collegeId);//设置关联的学院
					cUser.setCquptCollege(cquptCollege);
					cUser.setDepartment(department);
					cUser.setUserName(userName);
					cUser.setGender(gender);
					cUser.setOrigin(origin);
					cUser.setNationality(nationality);
					cUser.setBirthday(birthday);
					cUser.setPoliticalStatus(politicalStatus);
					cUser.setTimeJoinParty(timeJoinParty);
					cUser.setTimeBeginCqupt(timeBeginCqupt);
					cUser.setTimeBeginWork(timeBeginWork);
					cUser.setFirstDegree(firstDegree);
					cUser.setFirstProfessionalName(firstProfessionalName);
					cUser.setFirstGraduateSchool(firstGraduateSchool);
					cUser.setLastDegree(lastDegree);
					cUser.setLastProfessionalName(lastProfessionalName);
					cUser.setLastGraduateSchool(lastGraduateSchool);
					cUser.setLastAcademic(lastAcademic);
					//导入数据,暂时不考虑性能问题，以后来进行批量插入的性能提升
					addUserLoginAndCquptUser(uLogin,cUser);
				}
				wb.close();// 关闭工作薄
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	@Override
	public List<CQUPTUser> getUser() {
		// TODO Auto-generated method stub
		return userInfoDao.findUser();
	}
	
	@Override
	public CQUPTCollege getCQUPTCollege(String collegeId) {
		// TODO Auto-generated method stub
		return collegeInfoDao.findCQUPTCollegeByCollegeId(collegeId);
	}
	
	@Override
	public boolean checkUserId(String UserId) {
		// TODO Auto-generated method stub
		return userInfoDao.checkUserId(UserId);
	}
	
	@Override
	public List<UserAndRole> findCQUPTUserListByUserIdAndRoleId(String loginUserId,int loginUserRoleId) {
		try {
			List<CQUPTUser> list = userInfoDao.findCQUPTUserListByUserIdAndRoleId(loginUserId, loginUserRoleId);
			//存放用户和他对应的角色信息列表
			List<UserAndRole> userAndRoleList =  new ArrayList<UserAndRole>();
			if(!list.isEmpty()){
				for(CQUPTUser user : list){
					UserAndRole userAndRole = new UserAndRole();
					userAndRole.setUser(user);
					List<CQUPTRole> roleList = roleInfoDao.findRoleInfoListByuserId(user.getUserId());
					userAndRole.setRoleList(roleList);
					userAndRoleList.add(userAndRole);
				}
				return userAndRoleList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUserRoleInfo(String userID, int[] RoleIdArr) {
		try {
			userRoleInfoDao.addUserRoleInfo(userID, RoleIdArr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
