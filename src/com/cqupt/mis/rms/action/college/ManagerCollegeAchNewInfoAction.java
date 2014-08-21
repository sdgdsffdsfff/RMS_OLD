package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.model.CourseContributeNew;
import com.cqupt.mis.rms.model.MajorContributeNew;
import com.cqupt.mis.rms.model.StudentAwardsNew;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * <p>Title:实现得到符合条件教学成果类信息的action</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class ManagerCollegeAchNewInfoAction extends ActionSupport{

	//注入服务层接口
	private CollegeManagerService collegeManagerService;
	
	//教学成果类
	//得到符合条件的教学成果信息类本科教学工程的相关信息
	private List<CourseContributeNew> courseContributeNewlists;
	//得到符合条件的教学成果信息类教改项目的相关信息
    private List<MajorContributeNew> majorContributeNewlists;
    //得到符合条件的教学成果信息类指导学生参赛获奖的相关信息
    private List<StudentAwardsNew> studentAwardsNewlists;
    //得到符合条件的教学成果信息类教材出版的相关信息
    private List<TeachingMaterialSetNew> teachingMaterialSetNewlists;
    //得到符合条件的教学成果信息类发表教改论文的相关信息
    private List<TeachAchievementsNew> teachAchievementsNewlists;
    
   //得到符合条件的教学成果信息类重庆市大学生创新创业训练计划项目的相关信息
    private List<TeachAchievementsCQ> teachAchievementsCQlist;
	

	public List<TeachAchievementsCQ> getTeachAchievementsCQlist() {
		return teachAchievementsCQlist;
	}

	public void setTeachAchievementsCQlist(
			List<TeachAchievementsCQ> teachAchievementsCQlist) {
		this.teachAchievementsCQlist = teachAchievementsCQlist;
	}
    public List<CourseContributeNew> getCourseContributeNewlists() {
		return courseContributeNewlists;
	}

	public void setCourseContributeNewlists(
			List<CourseContributeNew> courseContributeNewlists) {
		this.courseContributeNewlists = courseContributeNewlists;
	}

	public List<MajorContributeNew> getMajorContributeNewlists() {
		return majorContributeNewlists;
	}

	public void setMajorContributeNewlists(
			List<MajorContributeNew> majorContributeNewlists) {
		this.majorContributeNewlists = majorContributeNewlists;
	}

	public List<StudentAwardsNew> getStudentAwardsNewlists() {
		return studentAwardsNewlists;
	}

	public void setStudentAwardsNewlists(
			List<StudentAwardsNew> studentAwardsNewlists) {
		this.studentAwardsNewlists = studentAwardsNewlists;
	}

	public List<TeachingMaterialSetNew> getTeachingMaterialSetNewlists() {
		return teachingMaterialSetNewlists;
	}

	public void setTeachingMaterialSetNewlists(
			List<TeachingMaterialSetNew> teachingMaterialSetNewlists) {
		this.teachingMaterialSetNewlists = teachingMaterialSetNewlists;
	}

	public List<TeachAchievementsNew> getTeachAchievementsNewlists() {
		return teachAchievementsNewlists;
	}

	public void setTeachAchievementsNewlists(
			List<TeachAchievementsNew> teachAchievementsNewlists) {
		this.teachAchievementsNewlists = teachAchievementsNewlists;
	}

	public CollegeManagerService getCollegeManagerService() {
		return collegeManagerService;
	}

	/**************2013-8-10 19:08  黄海燕添加********************************/
    

	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

  
	public void setCollegeManagerService(CollegeManagerService collegeManagerService) {
		this.collegeManagerService = collegeManagerService;
	}

	

	//得到符合条件的教学成果信息类课程建设的相关信息
    @SuppressWarnings("unchecked")
	public String courseContributeNew(){
		
    	courseContributeNewlists = (List<CourseContributeNew>) collegeManagerService.getInfo("CourseContributeNew");
    	type="show";
    	return "CourseContributeNew";
	}
    
    //得到符合条件的教学成果信息类专业建设的相关信息
    @SuppressWarnings("unchecked")
	public String majorContributeNew(){
		
    	majorContributeNewlists = (List<MajorContributeNew>) collegeManagerService.getInfo("MajorContributeNew");
    	type="show";
    	return "MajorContributeNew";
	}
    
    //得到符合条件的教学成果信息类学生获奖的相关信息
    @SuppressWarnings("unchecked")
	public String studentAwardsNew(){
		
    	studentAwardsNewlists = (List<StudentAwardsNew>) collegeManagerService.getInfo("StudentAwardsNew");
    	type="show";
    	return "StudentAwardsNew";
	}
   
    //得到符合条件的教学成果信息类教材立项的相关信息
    @SuppressWarnings("unchecked")
	public String teachingMaterialSetNew(){
		
    	teachingMaterialSetNewlists = (List<TeachingMaterialSetNew>) collegeManagerService.getInfo("TeachingMaterialSetNew");
    	type="show";
    	return "TeachingMaterialSetNew";
	}

    //得到符合条件的教学成果信息类教学成果的相关信息
    @SuppressWarnings("unchecked")
	public String teachAchievementsNew(){
		
    	teachAchievementsNewlists = (List<TeachAchievementsNew>) collegeManagerService.getInfo("TeachAchievementsNew");
    	type="show";
    	return "TeachAchievementsNew";
	}
    
    
    /**************2013-8-10 19:08  黄海燕添加********************************/
    //得到符合条件的教学成果信息类新的教学成果的相关信息
    @SuppressWarnings("unchecked")
	public String teachAchievementsCQ(){
		
    	teachAchievementsCQlist = (List<TeachAchievementsCQ>) collegeManagerService.getInfo("TeachAchievementsCQ");
    	type="show";
    	return "TeachAchievementsCQ";
	}
 
  
}
