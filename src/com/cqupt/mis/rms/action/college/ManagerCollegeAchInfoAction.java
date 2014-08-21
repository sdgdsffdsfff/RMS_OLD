package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.model.CourseContribute;
import com.cqupt.mis.rms.model.MajorContribute;
import com.cqupt.mis.rms.model.StudentAwards;
import com.cqupt.mis.rms.model.TeachAchievements;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
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
public class ManagerCollegeAchInfoAction extends ActionSupport{

	//注入服务层接口
	private CollegeManagerService collegeManagerService;
	
	//教学成果类
	//得到符合条件的教学成果信息类课程建设的相关信息
	private List<CourseContribute> courseContributelists;
	//得到符合条件的教学成果信息类专业建设的相关信息
    private List<MajorContribute> majorContributelists;
    //得到符合条件的教学成果信息类学生获奖的相关信息
    private List<StudentAwards> studentAwardslists;
    //得到符合条件的教学成果信息类教材立项的相关信息
    private List<TeachingMaterialSet> teachingMaterialSetlists;
    //得到符合条件的教学成果信息类教学成果的相关信息
    private List<TeachAchievements> teachAchievementslists;
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

	public List<CourseContribute> getCourseContributelists() {
		return courseContributelists;
	}

	public void setCourseContributelists(
			List<CourseContribute> courseContributelists) {
		this.courseContributelists = courseContributelists;
	}

	public List<MajorContribute> getMajorContributelists() {
		return majorContributelists;
	}

	public void setMajorContributelists(List<MajorContribute> majorContributelists) {
		this.majorContributelists = majorContributelists;
	}

	public List<StudentAwards> getStudentAwardslists() {
		return studentAwardslists;
	}

	public void setStudentAwardslists(List<StudentAwards> studentAwardslists) {
		this.studentAwardslists = studentAwardslists;
	}

	public List<TeachingMaterialSet> getTeachingMaterialSetlists() {
		return teachingMaterialSetlists;
	}

	public void setTeachingMaterialSetlists(
			List<TeachingMaterialSet> teachingMaterialSetlists) {
		this.teachingMaterialSetlists = teachingMaterialSetlists;
	}

	public List<TeachAchievements> getTeachAchievementslists() {
		return teachAchievementslists;
	}

	public void setTeachAchievementslists(
			List<TeachAchievements> teachAchievementslists) {
		this.teachAchievementslists = teachAchievementslists;
	}

	//得到符合条件的教学成果信息类课程建设的相关信息
    @SuppressWarnings("unchecked")
	public String courseContribute(){
		
    	courseContributelists = (List<CourseContribute>) collegeManagerService.getInfo("CourseContribute");
    	type="show";
    	return "CourseContribute";
	}
    
    //得到符合条件的教学成果信息类专业建设的相关信息
    @SuppressWarnings("unchecked")
	public String majorContribute(){
		
    	majorContributelists = (List<MajorContribute>) collegeManagerService.getInfo("MajorContribute");
    	type="show";
    	return "MajorContribute";
	}
    
    //得到符合条件的教学成果信息类学生获奖的相关信息
    @SuppressWarnings("unchecked")
	public String studentAwards(){
		
    	studentAwardslists = (List<StudentAwards>) collegeManagerService.getInfo("StudentAwards");
    	type="show";
    	return "StudentAwards";
	}
   
    //得到符合条件的教学成果信息类教材立项的相关信息
    @SuppressWarnings("unchecked")
	public String teachingMaterialSet(){
		
    	teachingMaterialSetlists = (List<TeachingMaterialSet>) collegeManagerService.getInfo("TeachingMaterialSet");
    	type="show";
    	return "TeachingMaterialSet";
	}

    //得到符合条件的教学成果信息类教学成果的相关信息
    @SuppressWarnings("unchecked")
	public String teachAchievements(){
		
    	teachAchievementslists = (List<TeachAchievements>) collegeManagerService.getInfo("TeachAchievements");
    	type="show";
    	return "TeachAchievements";
	}
 
  
}
