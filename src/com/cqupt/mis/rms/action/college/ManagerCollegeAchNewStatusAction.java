package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.model.CourseContributeNew;
import com.cqupt.mis.rms.model.CourseContributeMemberNew;
import com.cqupt.mis.rms.model.MajorContributeNew;
import com.cqupt.mis.rms.model.MajorContributeMemberNew;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.StudentAwardsNew;
import com.cqupt.mis.rms.model.StudentInstructorNew;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.model.TeachAchievementsDeclarant;
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachersAwardsNew;
import com.cqupt.mis.rms.model.TeachingMaterialEditorNew;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ManagerCollegeAchNewStatusAction extends ActionSupport{

	
	private CollegeManagerService collegeManagerService;
	private String id;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//教学成果类
	//得到满足要求的教学成果信息类课程建设的相关信息
	private List<CourseContributeNew> courseContributeNewlists;
	//得到满足要求的教学成果信息类专业建设的相关信息
    private List<MajorContributeNew> majorContributeNewlists;
    //得到满足要求的教学成果信息类学生获奖的相关信息
    private List<StudentAwardsNew> studentAwardsNewlists;
    //得到满足要求的教学成果信息类教材立项的相关信息
    private List<TeachingMaterialSetNew> teachingMaterialSetNewlists;
    //得到满足要求的教学成果信息类教学成果的相关信息
    private List<TeachAchievementsNew> teachAchievementsNewlists;
    
    /**************2013-8-10 19:37  黄海燕添加********************************/
    //得到满足要求的教学成果信息类教学成果的相关信息
    private List<TeachAchievementsCQ> teachAchievementsCQlists;
 
  

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

	public List<TeachAchievementsCQ> getTeachAchievementsCQlists() {
		return teachAchievementsCQlists;
	}

	public void setTeachAchievementsCQlists(
			List<TeachAchievementsCQ> teachAchievementsCQlists) {
		this.teachAchievementsCQlists = teachAchievementsCQlists;
	}

	//得到满足要求的教学成果信息类课程建设参与人的相关信息
    private List<CourseContributeMemberNew> courseContributeMemberNewlists;
  	//得到满足要求的教学成果信息类专业建设参与人的相关信息
    private List<MajorContributeMemberNew> majorContributeMemberNewlists;
    //得到满足要求的教学成果信息类学生获奖指导老师的相关信息
    private List<StudentInstructorNew> studentInstructorNewlists;
    //得到满足要求的教学成果信息类教学成果参与人的相关信息
    private List<TeachersAwardsNew> teachersAwardsNewlists;
    
    /*
     * 新添加内容：教材主编信息
     * LvHai 2012-10-31
     * */
    private List<TeachingMaterialEditorNew> teachingMaterialEditorNewlists;
  
    /**
     * 新添加内容：新的教学成果类申请人信息
     * HuangHaiYan  2013-8-11
     * 
     * */
  
	private List<TeachAchievementsDeclarant> teachAchievementsDeclarantlists;
	//得到与之对应的旁证材料
    private List<Proofs> proofslists;
    
    public List<CourseContributeMemberNew> getCourseContributeMemberNewlists() {
		return courseContributeMemberNewlists;
	}

	public void setCourseContributeMemberNewlists(
			List<CourseContributeMemberNew> courseContributeMemberNewlists) {
		this.courseContributeMemberNewlists = courseContributeMemberNewlists;
	}

	public List<MajorContributeMemberNew> getMajorContributeMemberNewlists() {
		return majorContributeMemberNewlists;
	}

	public void setMajorContributeMemberNewlists(
			List<MajorContributeMemberNew> majorContributeMemberNewlists) {
		this.majorContributeMemberNewlists = majorContributeMemberNewlists;
	}

	public List<StudentInstructorNew> getStudentInstructorNewlists() {
		return studentInstructorNewlists;
	}

	public void setStudentInstructorNewlists(
			List<StudentInstructorNew> studentInstructorNewlists) {
		this.studentInstructorNewlists = studentInstructorNewlists;
	}

	public List<TeachersAwardsNew> getTeachersAwardsNewlists() {
		return teachersAwardsNewlists;
	}

	public void setTeachersAwardsNewlists(
			List<TeachersAwardsNew> teachersAwardsNewlists) {
		this.teachersAwardsNewlists = teachersAwardsNewlists;
	}

	public List<TeachingMaterialEditorNew> getTeachingMaterialEditorNewlists() {
		return teachingMaterialEditorNewlists;
	}

	public void setTeachingMaterialEditorNewlists(
			List<TeachingMaterialEditorNew> teachingMaterialEditorNewlists) {
		this.teachingMaterialEditorNewlists = teachingMaterialEditorNewlists;
	}

	public List<TeachAchievementsDeclarant> getTeachAchievementsDeclarantlists() {
		return teachAchievementsDeclarantlists;
	}

	public void setTeachAchievementsDeclarantlists(
			List<TeachAchievementsDeclarant> teachAchievementsDeclarantlists) {
		this.teachAchievementsDeclarantlists = teachAchievementsDeclarantlists;
	}

	public List<Proofs> getProofslists() {
		return proofslists;
	}

	public void setProofslists(List<Proofs> proofslists) {
		this.proofslists = proofslists;
	}

    
  
    public CollegeManagerService getCollegeManagerService() {
		return collegeManagerService;
	}

	public void setCollegeManagerService(CollegeManagerService collegeManagerService) {
		this.collegeManagerService = collegeManagerService;
	}

	
	
	
	@SuppressWarnings("unchecked")
	public String courseContributeNew(){
		//得到满足要求的教学成果信息类课程建设的相关信息
    	courseContributeNewlists = (List<CourseContributeNew>) 
    			collegeManagerService.getInfoByFactor(id, "CourseContributeNew","courseId");
    	
    	//得到满足要求的教学成果信息类课程建设参与人的相关信息
    	courseContributeMemberNewlists = (List<CourseContributeMemberNew>) 
    			collegeManagerService.getInfoByFactor(id, "CourseContributeMemberNew", "courseContributeNew.courseId");
    	
    	//得到满足要求的教学成果信息类课程建设的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "CourseContributeNew";
	}
    
	
	
    @SuppressWarnings("unchecked")
	public String majorContributeNew(){
    	//得到满足要求的教学成果信息类专业建设的相关信息
    	majorContributeNewlists = (List<MajorContributeNew>) 
    			collegeManagerService.getInfoByFactor(id, "MajorContributeNew","majorId");
    	
    	//得到满足要求的教学成果信息类专业建设参与人的相关信息
    	majorContributeMemberNewlists = (List<MajorContributeMemberNew>) 
    			collegeManagerService.getInfoByFactor(id, "MajorContributeMemberNew", "majorContributeNew.majorId");
    	
    	//得到满足要求的教学成果信息类专业建设的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "MajorContributeNew";
	}
    
   
    
    @SuppressWarnings("unchecked")
	public String studentAwardsNew(){
		
    	System.out.println("!!!!!!!!!!!!!");
    	//得到满足要求的教学成果信息类学生获奖的相关信息
    	studentAwardsNewlists = (List<StudentAwardsNew>) 
    			collegeManagerService.getInfoByFactor(id, "StudentAwardsNew","awardsId");
    	
    	//得到满足要求的教学成果信息类学生获奖指导老师的相关信息
    	studentInstructorNewlists = (List<StudentInstructorNew>) 
    			collegeManagerService.getInfoByFactor(id, "StudentInstructorNew", "studentAwardsNew.awardsId");
    	
    	//得到满足要求的教学成果信息类学生获奖的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		
    	System.out.println("studentAwardsNewlists"+
    			studentAwardsNewlists+"==="+
    			"studentInstructorNewlists"+
    			studentInstructorNewlists+"===="+"proofslists"+proofslists);
    	return "StudentAwardsNew";
	}
    
   
    @SuppressWarnings("unchecked")
	public String teachingMaterialSetNew(){
    	System.out.println("!!!!!!!!!!!!!");
    	 //得到满足要求的教学成果信息类教材立项的相关信息
    	teachingMaterialSetNewlists = (List<TeachingMaterialSetNew>) 
    			collegeManagerService.getInfoByFactor(id, "TeachingMaterialSetNew","teachingMaterialId");
    	
    	//得到满足条件的教学成果类信息教材立项的主编/作者信息
    	teachingMaterialEditorNewlists = (List<TeachingMaterialEditorNew>)
    			collegeManagerService.getInfoByFactor(id, "TeachingMaterialEditorNew", "teachingMaterialSetNew.teachingMaterialId");
    	
    	 //得到满足要求的教学成果信息类教材立项的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "TeachingMaterialSetNew";
	}
   
   
   
    @SuppressWarnings("unchecked")
	public String teachAchievementsNew(){
    	 //得到满足要求的教学成果信息类教学成果的相关信息
    	teachAchievementsNewlists = (List<TeachAchievementsNew>) 
    			collegeManagerService.getInfoByFactor(id, "TeachAchievementsNew","achievementsId");
    	
    	 //得到满足要求的教学成果信息类教学成果参与人的相关信息
    	teachersAwardsNewlists = (List<TeachersAwardsNew>) 
    			collegeManagerService.getInfoByFactor(id, "TeachersAwardsNew", "teachAchievementsNew.achievementsId");
    	
    	//得到满足要求的教学成果信息类教学成果的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "TeachAchievementsNew";
	}
    
    @SuppressWarnings("unchecked")
	public String teachAchievementsCQ(){
    	 //得到满足要求的教学成果信息类教学成果的相关信息
    	teachAchievementsCQlists = (List<TeachAchievementsCQ>) 
    			collegeManagerService.getInfoByFactor(id, "TeachAchievementsCQ","achievementsId");
    	
    	 //得到满足要求的教学成果信息类教学成果参与人的相关信息
    	teachAchievementsDeclarantlists = (List<TeachAchievementsDeclarant>) 
    			collegeManagerService.getInfoByFactor(id, "TeachAchievementsDeclarant", "teachAchievementsCQ.achievementsId");
    	
    	//得到满足要求的教学成果信息类教学成果的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "TeachAchievementsCQ";
	}

    
  
}
