package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.model.CourseContribute;
import com.cqupt.mis.rms.model.CourseContributeMember;
import com.cqupt.mis.rms.model.MajorContribute;
import com.cqupt.mis.rms.model.MajorContributeMember;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.StudentAwards;
import com.cqupt.mis.rms.model.StudentInstructor;
import com.cqupt.mis.rms.model.TeachAchievements;
import com.cqupt.mis.rms.model.TeachersAwards;
import com.cqupt.mis.rms.model.TeachingMaterialEditor;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ManagerCollegeAchStatusAction extends ActionSupport{

	
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
	private List<CourseContribute> courseContributelists;
	//得到满足要求的教学成果信息类专业建设的相关信息
    private List<MajorContribute> majorContributelists;
    //得到满足要求的教学成果信息类学生获奖的相关信息
    private List<StudentAwards> studentAwardslists;
    //得到满足要求的教学成果信息类教材立项的相关信息
    private List<TeachingMaterialSet> teachingMaterialSetlists;
    //得到满足要求的教学成果信息类教学成果的相关信息
    private List<TeachAchievements> teachAchievementslists;
 
    //得到满足要求的教学成果信息类课程建设参与人的相关信息
    private List<CourseContributeMember> courseContributeMemberlists;
  	//得到满足要求的教学成果信息类专业建设参与人的相关信息
    private List<MajorContributeMember> majorContributeMemberlists;
    //得到满足要求的教学成果信息类学生获奖指导老师的相关信息
    private List<StudentInstructor> studentInstructorlists;
    //得到满足要求的教学成果信息类教学成果参与人的相关信息
    private List<TeachersAwards> teachersAwardslists;
    
    /*
     * 新添加内容：教材主编信息
     * LvHai 2012-10-31
     * */
    private List<TeachingMaterialEditor> teachingMaterialEditorlists;
  
    //得到与之对应的旁证材料
    private List<Proofs> proofslists;
    
    public List<Proofs> getProofslists() {
		return proofslists;
	}

	public void setProofslists(List<Proofs> proofslists) {
		this.proofslists = proofslists;
	}

    
    public List<CourseContributeMember> getCourseContributeMemberlists() {
		return courseContributeMemberlists;
	}

	public void setCourseContributeMemberlists(
			List<CourseContributeMember> courseContributeMemberlists) {
		this.courseContributeMemberlists = courseContributeMemberlists;
	}

	public List<MajorContributeMember> getMajorContributeMemberlists() {
		return majorContributeMemberlists;
	}

	public void setMajorContributeMemberlists(
			List<MajorContributeMember> majorContributeMemberlists) {
		this.majorContributeMemberlists = majorContributeMemberlists;
	}

	public List<StudentInstructor> getStudentInstructorlists() {
		return studentInstructorlists;
	}

	public void setStudentInstructorlists(
			List<StudentInstructor> studentInstructorlists) {
		this.studentInstructorlists = studentInstructorlists;
	}

	public List<TeachersAwards> getTeachersAwardslists() {
		return teachersAwardslists;
	}

	public void setTeachersAwardslists(List<TeachersAwards> teachersAwardslists) {
		this.teachersAwardslists = teachersAwardslists;
	}

    public CollegeManagerService getCollegeManagerService() {
		return collegeManagerService;
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

	
	
	@SuppressWarnings("unchecked")
	public String courseContribute(){
		//得到满足要求的教学成果信息类课程建设的相关信息
    	courseContributelists = (List<CourseContribute>) 
    			collegeManagerService.getInfoByFactor(id, "CourseContribute","courseId");
    	
    	//得到满足要求的教学成果信息类课程建设参与人的相关信息
    	courseContributeMemberlists = (List<CourseContributeMember>) 
    			collegeManagerService.getInfoByFactor(id, "CourseContributeMember", "courseContribute.courseId");
    	
    	//得到满足要求的教学成果信息类课程建设的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "CourseContribute";
	}
    
	
	
    @SuppressWarnings("unchecked")
	public String majorContribute(){
    	//得到满足要求的教学成果信息类专业建设的相关信息
    	majorContributelists = (List<MajorContribute>) 
    			collegeManagerService.getInfoByFactor(id, "MajorContribute","majorId");
    	
    	//得到满足要求的教学成果信息类专业建设参与人的相关信息
    	majorContributeMemberlists = (List<MajorContributeMember>) 
    			collegeManagerService.getInfoByFactor(id, "MajorContributeMember", "majorContribute.majorId");
    	
    	//得到满足要求的教学成果信息类专业建设的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "MajorContribute";
	}
    
   
    
    @SuppressWarnings("unchecked")
	public String studentAwards(){
		
    	//得到满足要求的教学成果信息类学生获奖的相关信息
    	studentAwardslists = (List<StudentAwards>) 
    			collegeManagerService.getInfoByFactor(id, "StudentAwards","awardsId");
    	
    	//得到满足要求的教学成果信息类学生获奖指导老师的相关信息
    	studentInstructorlists = (List<StudentInstructor>) 
    			collegeManagerService.getInfoByFactor(id, "StudentInstructor", "studentAwards.awardsId");
    	
    	//得到满足要求的教学成果信息类学生获奖的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "StudentAwards";
	}
    
   
    @SuppressWarnings("unchecked")
	public String teachingMaterialSet(){
    	 //得到满足要求的教学成果信息类教材立项的相关信息
    	teachingMaterialSetlists = (List<TeachingMaterialSet>) 
    			collegeManagerService.getInfoByFactor(id, "TeachingMaterialSet","teachingMaterialId");
    	
    	//得到满足条件的教学成果类信息教材立项的主编/作者信息
    	teachingMaterialEditorlists = (List<TeachingMaterialEditor>)
    			collegeManagerService.getInfoByFactor(id, "TeachingMaterialEditor", "teachingMaterialSet.teachingMaterialId");
    	
    	 //得到满足要求的教学成果信息类教材立项的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "TeachingMaterialSet";
	}
   
   
   
    @SuppressWarnings("unchecked")
	public String teachAchievements(){
    	 //得到满足要求的教学成果信息类教学成果的相关信息
    	teachAchievementslists = (List<TeachAchievements>) 
    			collegeManagerService.getInfoByFactor(id, "TeachAchievements","achievementsId");
    	
    	 //得到满足要求的教学成果信息类教学成果参与人的相关信息
    	teachersAwardslists = (List<TeachersAwards>) 
    			collegeManagerService.getInfoByFactor(id, "TeachersAwards", "teachAchievements.achievementsId");
    	
    	//得到满足要求的教学成果信息类教学成果的相关信息的旁证材料
    	proofslists = (List<Proofs>)
    			collegeManagerService.getInfoByFactor(id, "Proofs", "infoApprovedId");
		return "TeachAchievements";
	}

	public List<TeachingMaterialEditor> getTeachingMaterialEditorlists() {
		return teachingMaterialEditorlists;
	}

	public void setTeachingMaterialEditorlists(
			List<TeachingMaterialEditor> teachingMaterialEditorlists) {
		this.teachingMaterialEditorlists = teachingMaterialEditorlists;
	}
 
  
}
