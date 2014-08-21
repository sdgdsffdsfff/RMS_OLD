package com.cqupt.mis.rms.action.teacher;

import com.cqupt.mis.rms.model.CQUPTCollege;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.UserLogin;
import com.cqupt.mis.rms.service.UserManagerService;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SubmitUserInfoAction extends ActionSupport {
	
	private UserManagerService userManagerService;
	
	private String userId;
	private UserLogin userLogin;
	private String cquptCollegeId;
	private String department;
	private String userName;
	private String gender;
	private String origin;
	private String nationality;
	private String birthday;
	private String politicalStatus;
	private String timeJoinParty;
	private String timeBeginCqupt;
	private String timeBeginWork;
	private String firstDegree;
	private String firstProfessionalName;
	private String firstGraduateSchool;
	private String lastDegree;
	private String lastProfessionalName;
	private String lastGraduateSchool;
	private String lastAcademic;
	
	

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}
	
	public String execute(){
		try {
			String userPwd="123";
			UserLogin uLogin = new UserLogin();
			if(userId==null){
				userId=GenerateUtils.generateUserID();
			}
			uLogin.setUserId(userId);
			uLogin.setUserPwd(userPwd);
			
			CQUPTUser cUser = new CQUPTUser();
			cUser.setUserLogin(uLogin);
			CQUPTCollege cquptCollege = userManagerService.getCQUPTCollege(getCquptCollegeId());//设置关联的学院
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
			
			userManagerService.addUserLoginAndCquptUser(uLogin, cUser);
			return "addsuccess";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public String getCquptCollegeId() {
		return cquptCollegeId;
	}

	public void setCquptCollegeId(String cquptCollegeId) {
		this.cquptCollegeId = cquptCollegeId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getTimeJoinParty() {
		return timeJoinParty;
	}

	public void setTimeJoinParty(String timeJoinParty) {
		this.timeJoinParty = timeJoinParty;
	}

	public String getTimeBeginCqupt() {
		return timeBeginCqupt;
	}

	public void setTimeBeginCqupt(String timeBeginCqupt) {
		this.timeBeginCqupt = timeBeginCqupt;
	}

	public String getTimeBeginWork() {
		return timeBeginWork;
	}

	public void setTimeBeginWork(String timeBeginWork) {
		this.timeBeginWork = timeBeginWork;
	}

	public String getFirstDegree() {
		return firstDegree;
	}

	public void setFirstDegree(String firstDegree) {
		this.firstDegree = firstDegree;
	}

	public String getFirstProfessionalName() {
		return firstProfessionalName;
	}

	public void setFirstProfessionalName(String firstProfessionalName) {
		this.firstProfessionalName = firstProfessionalName;
	}

	public String getFirstGraduateSchool() {
		return firstGraduateSchool;
	}

	public void setFirstGraduateSchool(String firstGraduateSchool) {
		this.firstGraduateSchool = firstGraduateSchool;
	}

	public String getLastDegree() {
		return lastDegree;
	}

	public void setLastDegree(String lastDegree) {
		this.lastDegree = lastDegree;
	}

	public String getLastProfessionalName() {
		return lastProfessionalName;
	}

	public void setLastProfessionalName(String lastProfessionalName) {
		this.lastProfessionalName = lastProfessionalName;
	}

	public String getLastGraduateSchool() {
		return lastGraduateSchool;
	}

	public void setLastGraduateSchool(String lastGraduateSchool) {
		this.lastGraduateSchool = lastGraduateSchool;
	}

	public String getLastAcademic() {
		return lastAcademic;
	}

	public void setLastAcademic(String lastAcademic) {
		this.lastAcademic = lastAcademic;
	}

	public UserManagerService getUserManagerService() {
		return userManagerService;
	}
	
	
}
