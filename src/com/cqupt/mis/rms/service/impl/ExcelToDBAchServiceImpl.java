package com.cqupt.mis.rms.service.impl;
/**
*<p>Title:实现管理用户信息Service</p>
*<p>Description:从excel导入教学成果类信息到数据库</p>
*@author HuangHaiyan
*@version 1.0
**/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.CourseContribute;
import com.cqupt.mis.rms.model.CourseContributeMember;
import com.cqupt.mis.rms.model.MajorContribute;
import com.cqupt.mis.rms.model.MajorContributeMember;
import com.cqupt.mis.rms.model.Sheet;
import com.cqupt.mis.rms.model.StudentAwards;
import com.cqupt.mis.rms.model.StudentInstructor;
import com.cqupt.mis.rms.model.TeachAchievements;
import com.cqupt.mis.rms.model.TeachersAwards;
import com.cqupt.mis.rms.model.TeachingMaterialEditor;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
import com.cqupt.mis.rms.service.ExcelToDBService;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.DoString;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;

public class ExcelToDBAchServiceImpl implements ExcelToDBService{
	
	private SubmitInfoAndProofsService submitInfoAndProofsService;
	
	public SubmitInfoAndProofsService getSubmitInfoAndProofsService() {
		return submitInfoAndProofsService;
	}
	public void setSubmitInfoAndProofsService(
			SubmitInfoAndProofsService submitInfoAndProofsService) {
		this.submitInfoAndProofsService = submitInfoAndProofsService;
	}
	
	/**
	 * 从EXCEL表格里面导入教学成果类信息进入数据库
	 * @param excelfile EXCEL文件
	 * @return  String SUCCESS 表示全部导入成功 ;ERR 表示导入失败;excelName 表示导入了一部分正确的数据
	 */
	@SuppressWarnings("unused")
	@Override
	public String readInfoExceltoDB(File excelfile,String userId,String url) {
		
		 WritableWorkbook writableworkbook  = null;
		 WritableSheet writableSheet;
		 String excelName = "";
		 File file = null;
		try {
			String tecId = GenerateUtils.getID();
			url = url+"\\";
			excelName = "Tec"+tecId+".xls";
			 file=new File(url+excelName);
			if(!file.exists()){
				file.createNewFile();
			}
			writableworkbook = Workbook.createWorkbook(file);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CQUPTUser user = new CQUPTUser();
		user.setUserId(userId);
		// 读入数据库
		 ArrayList<Sheet> courseContributeSheet = new ArrayList<Sheet>();
		 ArrayList<CourseContribute> courseContributelists = new ArrayList<CourseContribute>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> CourseContributeMemberslist = new ArrayList<ArrayList>();
		 
		 ArrayList<Sheet> majorContributeSheet = new ArrayList<Sheet>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> majorContributeMemberslist = new ArrayList<ArrayList>();
		 List<MajorContribute> majorContributelists = new ArrayList<MajorContribute>();
		 
		 @SuppressWarnings("rawtypes")
	   	 ArrayList<ArrayList> TeachersAwardsslist = new ArrayList<ArrayList>();
		 ArrayList<Sheet> teachAchievementsSheet = new ArrayList<Sheet>();
		 ArrayList<TeachAchievements> teachAchievementslist = new ArrayList<TeachAchievements>();
		 
		 ArrayList<TeachingMaterialSet> teachingMaterialSetlists = new ArrayList<TeachingMaterialSet>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> teachingMaterialEditorlists = new ArrayList<ArrayList>();
		 ArrayList<Sheet> teachingMaterialSetSheet = new ArrayList<Sheet>(); 
		 
		 ArrayList<StudentAwards> studentAwardslists = new ArrayList<StudentAwards>();
		 ArrayList<Sheet> StudentAwardsSheet = new ArrayList<Sheet>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> StudentInstructorslists = new ArrayList<ArrayList>();
		 
		 boolean b1 = true;
		 
		if (excelfile != null || !"".equals(excelfile)) {
			try {
				
				jxl.Workbook wb = Workbook.getWorkbook(excelfile);// 获取工作薄
				
				for(int i=0;i<wb.getNumberOfSheets();i++){
					
					 jxl.Sheet st = wb.getSheet(i);// 得到工作薄
					 
					 String name =st.getName();
					 
					
					 
					 if("教学成果类专业建设".equals(name)){
						 
					 
					 
					 for (int j = 1; j < st.getRows()&&st.getCell(3,j).getContents()!=null&&st.getCell(3,j).getContents()!="";j++) { 
						 
						 Sheet sheet = new Sheet();	 
							
						 ArrayList<String> memberName = new ArrayList<String>();
						  
							 String classContribute = "";
							 String typeContribute = "";
							 String timeContribute = "";
							 String majorName = "";
							 String allMember = "";
							 String checkTime = "";
							 String endTime = "";
							 Float rewardCollege = 0.0f;
							 String rewardCollegeWrong;
							 String remarks = "";
							 int status = 0;
							 
						if(st.getCell(0, j).getContents()!=""){
						
							classContribute = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(classContribute);
					 	}else {
							
							sheet.setSheet0(classContribute);
						
						}
						
						if(st.getCell(1, j).getContents()!=""){
						
							typeContribute = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(typeContribute);
						}else {
							
							sheet.setSheet1(typeContribute);
						
						}
						
						if(st.getCell(2, j).getContents()!=""){
							
							timeContribute = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
						    sheet.setSheet2(timeContribute);
						}else {
							
							sheet.setSheet2(timeContribute);
						
						}
						
						if(st.getCell(3, j).getContents()!=""){
							
							majorName = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(majorName);
						}else {
							majorName = "请输入立项专业的名称";
							sheet.setSheet3(majorName);
						    b1 = false;
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有输入负责人名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet4(allMember);
					
						}else {
							allMember = allMember + "(请输入负责人姓名)";
							sheet.setSheet4(allMember);
						
						}
						
						if(st.getCell(5, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(5,j).getContents()))!=null)
							{
								checkTime = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							    sheet.setSheet5(checkTime);
					
						    }else {
						    	checkTime = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
						    	checkTime = checkTime+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012或2012.12或2012）"+"";
								sheet.setSheet5(checkTime);
						        b1 = false;
						  }
						}
						

						if(st.getCell(6, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(6,j).getContents()))!=null)
							{
								endTime = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							    sheet.setSheet6(endTime);
					
						    }else {
						    	endTime = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
						    	endTime = endTime+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet6(endTime);
						        b1 = false;
						  }
						}
						
						
						if(st.getCell(7, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
							sheet.setSheet7(remarks);
						}else {
							
							sheet.setSheet7(remarks);
						}
						
						if(st.getCell(8, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(8, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(8, j).getContents())){

								rewardCollege = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(8,j).getContents()));
								sheet.setSheet8(rewardCollege+"");
							}else {

								rewardCollegeWrong = rewardCollege+"（请输入相应的数值）"+"";
								sheet.setSheet8(rewardCollegeWrong);
								b1 = false;
							}
						}
						if(b1){
							
							String majorId = GenerateUtils.getID();
							MajorContribute majorContribute =new MajorContribute();
							if(TypeConvert.StringtoDate(checkTime)!=null)
							majorContribute.setCheckTime(TypeConvert.StringtoDate(checkTime));
							majorContribute.setClassContribute(classContribute);
							majorContribute.setRewardCollege(rewardCollege);
							majorContribute.setMajorId(majorId);
							majorContribute.setMajorName(majorName);
							if(TypeConvert.StringtoDate(endTime)!=null)
							majorContribute.setEndTime(TypeConvert.StringtoDate(endTime));
							majorContribute.setRemarks(remarks);
							majorContribute.setStatus(status);
							majorContribute.setSubmitUser(user);
							majorContribute.setTimeContribute(timeContribute);
							majorContribute.setTypeContribute(typeContribute);
							
							majorContributelists.add(majorContribute);
							
							 ArrayList<MajorContributeMember> majorContributeMembers = new ArrayList<MajorContributeMember>();

							 
								for(int m = 0; m < memberName.size(); m++){
									MajorContributeMember majorContributeMember = new MajorContributeMember();
									majorContributeMember.setMajorContribute(majorContribute);
									majorContributeMember.setMemberName(memberName.get(m));
									
									majorContributeMembers.add(majorContributeMember);
								}
								majorContributeMemberslist.add(majorContributeMembers);
							
						}else{
							b1 = true;
							majorContributeSheet.add(sheet);
						}
					  
					 }	
					 
					 
					 if(majorContributeSheet.size()!=0){
						 
						writableSheet = writableworkbook.createSheet("教学成果类专业建设",0);
						
						 Label label = new Label(0,0,"立项级别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"立项类别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"立项时间");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"专业名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"负责人");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"年度检查时间");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"结题时间"	);
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"备注");	
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"学院奖励");	
						  writableSheet.addCell(label);
						  
						 for(int m=0;m<majorContributeSheet.size();m++){
							
							 Sheet sheets = majorContributeSheet.get(m);
							 
							  label = new Label(0,m+1,sheets.getSheet0());	
							  writableSheet.addCell(label);
							  label = new Label(1,m+1,sheets.getSheet1());	
							  writableSheet.addCell(label);
							  label = new Label(2,m+1,sheets.getSheet2());	
							  writableSheet.addCell(label);
							  label = new Label(3,m+1,sheets.getSheet3());	
							  writableSheet.addCell(label);
							  label = new Label(4,m+1,sheets.getSheet4());	
							  writableSheet.addCell(label);
							  label = new Label(5,m+1,sheets.getSheet5());	
							  writableSheet.addCell(label);
							  label = new Label(6,m+1,sheets.getSheet6());	
							  writableSheet.addCell(label);
							  label = new Label(7,m+1,sheets.getSheet7());	
							  writableSheet.addCell(label);
							  label = new Label(8,m+1,sheets.getSheet8());	
							  writableSheet.addCell(label);
							 
						}
				
						 
				}	
				
			    }else if("教学成果类课程建设".equals(name)){
			    	 
					 for (int j = 1; j < st.getRows()&&st.getCell(3,j).getContents()!=null&&st.getCell(3,j).getContents()!="";j++) { 
						 Sheet sheet = new Sheet();	 
							
						 ArrayList<String> memberName = new ArrayList<String>();
						  String allMember = "";
						  String classContribute = "";
						  String typeContribute = "";
						  String timeContribute = "";
						  String courseName = "";
						   
						  String checkTime = "";
						  String endTime = "";
						  Float collegeAward = 0.0f;
						  String collegeAwardWrong;
						  String remarks = "";
						  int status = 0;
						 
						
						if(st.getCell(0, j).getContents()!=""){
						
							classContribute = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(classContribute);
					 	}else {
							
							sheet.setSheet0(classContribute);
						
						}
						
						if(st.getCell(1, j).getContents()!=""){
						
							typeContribute = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(typeContribute);
						}else {
							
							sheet.setSheet1(typeContribute);
						
						}
						
						if(st.getCell(2, j).getContents()!=""){
							
							timeContribute = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
						    sheet.setSheet2(timeContribute);
						}else {
							
							sheet.setSheet2(timeContribute);
						
						}
						
						if(st.getCell(3, j).getContents()!=""){
							
							courseName = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(courseName);
						}else {
							courseName = "请输入立项课程的名称";
							sheet.setSheet3(courseName);
						    b1 = false;
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有输入负责人名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet4(allMember);
					
						}else {
							allMember = allMember + "(请输入负责人姓名)";
							sheet.setSheet4(allMember);
						
						}
						
						if(st.getCell(5, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(5,j).getContents()))!=null)
							{
								checkTime = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							    sheet.setSheet5(checkTime);
					
						    }else {
						    	checkTime = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
						    	checkTime = checkTime+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet5(checkTime);
						        b1 = false;
						  }
						}
						

						if(st.getCell(6, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(6,j).getContents()))!=null)
							{
								endTime = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							    sheet.setSheet6(endTime);
					
						    }else {
						    	endTime = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
						    	endTime = endTime+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet6(endTime);
						        b1 = false;
						  }
						}
						
						
						if(st.getCell(7, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(7, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(7, j).getContents())){

								collegeAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(7,j).getContents()));
								sheet.setSheet7(collegeAward+"");
							}else {

								collegeAwardWrong = collegeAward+"（请输入相应的数值）"+"";
								sheet.setSheet7(collegeAwardWrong);
								b1 = false;
							}
						}
						if(b1){
							
							String courseId = GenerateUtils.getID();
							CourseContribute courseContribute =new CourseContribute();
							if(TypeConvert.StringtoDate(checkTime)!=null)
							courseContribute.setCheckTime(TypeConvert.StringtoDate(checkTime));
							courseContribute.setClassContribute(classContribute);
							courseContribute.setCollegeAward(collegeAward);
							courseContribute.setCourseId(courseId);
							courseContribute.setCourseName(courseName);
							if(TypeConvert.StringtoDate(endTime)!=null)
							courseContribute.setEndTime(TypeConvert.StringtoDate(endTime));
							courseContribute.setRemarks(remarks);
							courseContribute.setStatus(status);
							courseContribute.setSubmitUser(user);
							courseContribute.setTimeContribute(timeContribute);
							courseContribute.setTypeContribute(typeContribute);
							
							courseContributelists.add(courseContribute);
							
							 ArrayList<CourseContributeMember> CourseContributeMembers = new ArrayList<CourseContributeMember>();

							 
								for(int m = 0; m < memberName.size(); m++){
									CourseContributeMember courseContributeMember = new CourseContributeMember();
									courseContributeMember.setCourseContribute(courseContribute);
									courseContributeMember.setMemberName(memberName.get(m));
									
									CourseContributeMembers.add(courseContributeMember);
								}
								CourseContributeMemberslist.add(CourseContributeMembers);
							
						}else{
							b1 = true;
							courseContributeSheet.add(sheet);
						}
					  
					 }	
					 
					 
					 if(courseContributeSheet.size()!=0){
						 
						writableSheet = writableworkbook.createSheet("教学成果类课程建设",1);
						
						 Label label = new Label(0,0,"立项级别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"立项类别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"立项时间");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"课程名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"负责人");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"年度检查时间");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"结题时间"	);
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"学院奖励");	
						  writableSheet.addCell(label);
						  
						 for(int m=0;m<courseContributeSheet.size();m++){
							
							 Sheet sheets = courseContributeSheet.get(m);
							 
							  label = new Label(0,m+1,sheets.getSheet0());	
							  writableSheet.addCell(label);
							  label = new Label(1,m+1,sheets.getSheet1());	
							  writableSheet.addCell(label);
							  label = new Label(2,m+1,sheets.getSheet2());	
							  writableSheet.addCell(label);
							  label = new Label(3,m+1,sheets.getSheet3());	
							  writableSheet.addCell(label);
							  label = new Label(4,m+1,sheets.getSheet4());	
							  writableSheet.addCell(label);
							  label = new Label(5,m+1,sheets.getSheet5());	
							  writableSheet.addCell(label);
							  label = new Label(6,m+1,sheets.getSheet6());	
							  writableSheet.addCell(label);
							  label = new Label(7,m+1,sheets.getSheet7());	
							  writableSheet.addCell(label);
							
							 
						}
				
						 
				}	
				
					
				}else if("教学成果类教学成果奖".equals(name)){
					
					 b1 = true;
			    	
					 
					for (int j = 1; j < st.getRows()&&st.getCell(1,j).getContents()!=null&&st.getCell(1,j).getContents()!=""; j++) { 
						 Sheet sheet = new Sheet();	
						 ArrayList<String> memberName = new ArrayList<String>();
						 String allMember = "";
						 
						  String classAchievements = "";
						  String projectName = "";
						  String levelAchievements = "";
						  String timeAchievements = "";
						  Float collegeAward = 0.0f;
						  String collegeAwardWrong;
						  int status = 0;
						
						
						
						if(st.getCell(0, j).getContents()!=""){
							
							classAchievements = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(classAchievements);
					 	
						}else {
							
						    sheet.setSheet0(classAchievements);
						
						}
						
						if(st.getCell(1, j).getContents()!=""){
							
							projectName = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(projectName);
						
						}else {
							projectName="请输入获得项目成果奖的项目名称";
							sheet.setSheet1(projectName);
							b1 =false;
						}
						
						if(st.getCell(2, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有输如获奖人名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet2(allMember);
					
						}else {
							allMember = allMember + "(请输入获奖人姓名)";
							sheet.setSheet2(allMember);
						
						}
						
						
						
						if(st.getCell(3, j).getContents()!=""){
							
							levelAchievements = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(levelAchievements);
						
						}else {
							
							sheet.setSheet3(levelAchievements);
						
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							timeAchievements = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(timeAchievements);
						
						}else {
							
							timeAchievements = "请输入第一作者名字";
							sheet.setSheet4(timeAchievements);
						
						}

				
						if(st.getCell(5, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(5, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(5, j).getContents())){

								collegeAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(5,j).getContents()));
								sheet.setSheet5(collegeAward+"");
							
							}else {
								
								collegeAwardWrong = collegeAward+"（请输入相应的数值）"+"";
								sheet.setSheet5(collegeAwardWrong+"");
								b1 = false;
						    }
						}	
						
						
						if(b1){
							
							String achievementsId = GenerateUtils.getID();
							TeachAchievements teachAchievements =new TeachAchievements();
							teachAchievements.setAchievementsId(achievementsId);
							teachAchievements.setClassAchievements(classAchievements);
							teachAchievements.setCollegeAward(collegeAward);
							teachAchievements.setLevelAchievements(levelAchievements);
							teachAchievements.setProjectName(projectName);
							teachAchievements.setStatus(status);
							teachAchievements.setSubmitUser(user);
							teachAchievements.setTimeAchievements(timeAchievements);
							
							teachAchievementslist.add(teachAchievements);
							
							
							 ArrayList<TeachersAwards> TeachersAwardss = new ArrayList<TeachersAwards>();

								for(int m = 0; m < memberName.size(); m++){
									TeachersAwards teachersAwards = new TeachersAwards();
									teachersAwards.setTeachAchievements(teachAchievements);
									teachersAwards.setMemberName(memberName.get(m));
									
									TeachersAwardss.add(teachersAwards);
								}
								 
				
								
								TeachersAwardsslist.add(TeachersAwardss);
						    
						}else{
							b1 = true;
							teachAchievementsSheet.add(sheet);
						}	
					}
					
					 
					 if(teachAchievementsSheet.size()!=0){
						 
					   	 writableSheet = writableworkbook.createSheet("教学成果类教学成果奖",2);
					      Label label = new Label(0,0,"级别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"项目名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"获奖人（*）");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"等级");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"时间");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"学院奖励");
						  writableSheet.addCell(label);
						  
						 
						
						 for(int m=0;m<teachAchievementsSheet.size();m++){
							
							 Sheet sheets = teachAchievementsSheet.get(m);
							 
							  label = new Label(0,m+1,sheets.getSheet0());	
							  writableSheet.addCell(label);
							  label = new Label(1,m+1,sheets.getSheet1());	
							  writableSheet.addCell(label);
							  label = new Label(2,m+1,sheets.getSheet2());	
							  writableSheet.addCell(label);
							  label = new Label(3,m+1,sheets.getSheet3());	
							  writableSheet.addCell(label);
							  label = new Label(4,m+1,sheets.getSheet4());	
							  writableSheet.addCell(label);
							  label = new Label(5,m+1,sheets.getSheet5());	
							  writableSheet.addCell(label);
							 
							
						}
				
				  }
					
				}else if("教学成果类教材立项".equals(name)){
					
					
					 
					for (int j = 1; j < st.getRows()&&st.getCell(3,j).getContents()!=null&&st.getCell(3,j).getContents()!=""; j++) { 
						 b1 = true;
				    	 Sheet sheet = new Sheet();	
				    	 ArrayList<String> memberName = new ArrayList<String>();
						 String allMember = "";
						 
							 String setClass = "";
							 String setTime = "";
							 String numberProject = "";
							 String teachingMaterialName = "";
							 String editorName = "";
							 String resultsPostedStatus = "";
							
							 int status = 0;
						
						
						if(st.getCell(0, j).getContents()!=""){
							
							setClass = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(setClass);
					 	
						}else {
							
						    sheet.setSheet0(setClass);
						
						}
						
						if(st.getCell(1, j).getContents()!=""){
							
							setTime = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(setTime);
						
						}else {
							sheet.setSheet1(setTime);
						}
						
						if(st.getCell(2, j).getContents()!=""){
							
							numberProject = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(numberProject);
						
						}else {
							sheet.setSheet2(numberProject);
						}
						
						if(st.getCell(3, j).getContents()!=""){
							
							teachingMaterialName = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(teachingMaterialName);
						
						}else {
							teachingMaterialName = "请输入立项的教材名称";
							sheet.setSheet3(teachingMaterialName);
							b1 = false;
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有输主编名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet4(allMember);
					
						}else {
							allMember = allMember + "(请输入获奖人姓名)";
							sheet.setSheet4(allMember);
						
						}
						
						
						
						if(st.getCell(5, j).getContents()!=""){
							
							resultsPostedStatus = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(resultsPostedStatus);
						
						}else {
							
							sheet.setSheet5(resultsPostedStatus);
						
						}
						
						
						
						if(b1){
							
							String teachingMaterialId = GenerateUtils.getID();
							TeachingMaterialSet teachingMaterialSet =new TeachingMaterialSet();
							teachingMaterialSet.setNumberProject(numberProject);
							teachingMaterialSet.setResultsPostedStatus(resultsPostedStatus);
							teachingMaterialSet.setSetClass(setClass);
							teachingMaterialSet.setSetTime(setTime);
							teachingMaterialSet.setStatus(status);
							teachingMaterialSet.setSubmitUser(user);
							teachingMaterialSet.setTeachingMaterialId(teachingMaterialId);
							teachingMaterialSet.setTeachingMaterialName(teachingMaterialName);
							
							teachingMaterialSetlists.add(teachingMaterialSet);
							
							
							
							 ArrayList<TeachingMaterialEditor> teachingMaterialEditors = new ArrayList<TeachingMaterialEditor>();

								for(int m = 0; m < memberName.size(); m++){
									TeachingMaterialEditor teachingMaterialEditor = new TeachingMaterialEditor();
									teachingMaterialEditor.setTeachingMaterialSet(teachingMaterialSet);
									teachingMaterialEditor.setEditorName(memberName.get(m));
									teachingMaterialEditors.add(teachingMaterialEditor);
								}
								 
				
								teachingMaterialEditorlists.add(teachingMaterialEditors);
						    
						}else{
							b1 = true;
							teachingMaterialSetSheet.add(sheet);
						}	
					}
					
					 
					 if(teachingMaterialSetSheet.size()!=0){
						 
					   	 writableSheet = writableworkbook.createSheet("教学成果类教材立项",3);
					      Label label = new Label(0,0,"级别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"时间");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"项目编号");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"教材名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"主编姓名");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"是否结贴");
						  writableSheet.addCell(label);
						  
						 
						
						 for(int m=0;m<teachingMaterialSetSheet.size();m++){
							
							 Sheet sheets = teachingMaterialSetSheet.get(m);
							 
							  label = new Label(0,m+1,sheets.getSheet0());	
							  writableSheet.addCell(label);
							  label = new Label(1,m+1,sheets.getSheet1());	
							  writableSheet.addCell(label);
							  label = new Label(2,m+1,sheets.getSheet2());	
							  writableSheet.addCell(label);
							  label = new Label(3,m+1,sheets.getSheet3());	
							  writableSheet.addCell(label);
							  label = new Label(4,m+1,sheets.getSheet4());	
							  writableSheet.addCell(label);
							  label = new Label(5,m+1,sheets.getSheet5());	
							  writableSheet.addCell(label);
							 
							
						}
				
				  }
					
				}else if("教学成果类学生获奖".equals(name)){
					
					 
					 
					for (int j = 1; j < st.getRows()&&st.getCell(2,j).getContents()!=null&&st.getCell(2,j).getContents()!=""; j++) { 
						b1 = true;
				    	 Sheet sheet = new Sheet();	
				    	 ArrayList<String> memberName = new ArrayList<String>();
						 String allMember = "";
						 
							 String rewardTime = "";
							 String rewardStudents = "";
							 String rewardName = "";
							 String rewardLevel = "";
							 String collegeAward = "";
							 int status = 0;
						
						
						if(st.getCell(1, j).getContents()!=""){
							
							rewardTime = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(rewardTime);
					 	
						}else {
							
						    sheet.setSheet1(rewardTime);
						
						}
						
						
						if(st.getCell(2, j).getContents()!=""){
							
							rewardName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(rewardName);
						
						}else {
							rewardName = "请输入获奖名称";
							sheet.setSheet2(rewardName);
							b1 = false;
						}
						
						if(st.getCell(3, j).getContents()!=""){
							
							rewardStudents = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(rewardStudents);
						
						}else {
							sheet.setSheet3(rewardStudents);
						}
						
						
						
						if(st.getCell(4, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有输主编名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet4(allMember);
					
						}else {
							allMember = allMember + "(请输入获奖人姓名)";
							sheet.setSheet4(allMember);
						
						}
						
						
						
						if(st.getCell(5, j).getContents()!=""){
							
							rewardLevel = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(rewardLevel);
						
						}else {
							
							sheet.setSheet5(rewardLevel);
						
						}
						
						if(st.getCell(6, j).getContents()!=""){
							
							collegeAward = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							sheet.setSheet6(collegeAward);
						
						}else {
							
							sheet.setSheet6(collegeAward);
						
						}
						
						if(b1){
							
							String awardsId = GenerateUtils.getID();
							StudentAwards studentAwards =new StudentAwards();
							studentAwards.setAwardsId(awardsId);
							studentAwards.setCollegeAward(collegeAward);
							studentAwards.setRewardLevel(rewardLevel);
							studentAwards.setRewardName(rewardName);
							studentAwards.setRewardStudents(rewardStudents);
							studentAwards.setRewardTime(rewardTime);
							studentAwards.setStatus(status);
							studentAwards.setSubmitUser(user);
							studentAwardslists.add(studentAwards);
							
							
							
							 ArrayList<StudentInstructor> studentInstructors = new ArrayList<StudentInstructor>();

								for(int m = 0; m < memberName.size(); m++){
									StudentInstructor studentInstructor = new StudentInstructor();
									studentInstructor.setStudentAwards(studentAwards);
									studentInstructor.setMemberName(memberName.get(m));
									
									studentInstructors.add(studentInstructor);
								}
								 
				
								StudentInstructorslists.add(studentInstructors);
						    
						}else{
							b1 = true;
							StudentAwardsSheet.add(sheet);
						}	
					}
					
					 
					 if(StudentAwardsSheet.size()!=0){
						 
					   	 writableSheet = writableworkbook.createSheet("教学成果类学生获奖",4);
					      Label label = new Label(0,0,"序号");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"时间");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"获奖名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"获奖个人或集体");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"指导教师");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"获奖级别");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"学院奖励");
						  writableSheet.addCell(label);
						 
						
						 for(int m=0;m<StudentAwardsSheet.size();m++){
							
							 Sheet sheets = StudentAwardsSheet.get(m);
							 
							  label = new Label(0,m+1,m+1+"");	
							  writableSheet.addCell(label);
							  label = new Label(1,m+1,sheets.getSheet1());	
							  writableSheet.addCell(label);
							  label = new Label(2,m+1,sheets.getSheet2());	
							  writableSheet.addCell(label);
							  label = new Label(3,m+1,sheets.getSheet3());	
							  writableSheet.addCell(label);
							  label = new Label(4,m+1,sheets.getSheet4());	
							  writableSheet.addCell(label);
							  label = new Label(5,m+1,sheets.getSheet5());	
							  writableSheet.addCell(label);
							  label = new Label(6,m+1,sheets.getSheet6());	
							  writableSheet.addCell(label);
							 
							
						}
				
				  }
					
				}else{
					
					return "ERR";
				}
			}
				
				if(courseContributelists!=null){
					
					
					for(int i=0;i<courseContributelists.size();i++){
						
						CourseContribute courseContribute = courseContributelists.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<CourseContributeMember> courseContributeMembers = CourseContributeMemberslist.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(courseContribute);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(14, courseContributeMembers);
					    if(!(result2 || result1)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(majorContributelists!=null){
					
					
					for(int i=0;i<majorContributelists.size();i++){
						
						MajorContribute majorContribute = majorContributelists.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<MajorContributeMember> majorContributeMembers = majorContributeMemberslist.get(i);
						
						boolean result1 = submitInfoAndProofsService.submitInfo(majorContribute);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(13, majorContributeMembers);
					    if(!(result2 || result1)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(TeachersAwardsslist!=null){
					
					
					for(int i=0;i<TeachersAwardsslist.size();i++){
						
						TeachAchievements teachAchievements = teachAchievementslist.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<TeachersAwards> teachersAwards = TeachersAwardsslist.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(teachAchievements);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(15, teachersAwards);
					    	
							if(!(result1&&result2)){
						    	
						    	return "ERR";
						    }
					    }
				}
					
				

				if(teachingMaterialSetlists!=null){
					
					
					for(int i=0;i<teachingMaterialSetlists.size();i++){
						@SuppressWarnings("unchecked")
						ArrayList<TeachingMaterialEditor> teachingMaterialEditors = teachingMaterialEditorlists.get(i);
						TeachingMaterialSet teachingMaterialSet = teachingMaterialSetlists.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(teachingMaterialSet);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(17, teachingMaterialEditors);

					    if(!(result1&&result2)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(studentAwardslists!=null){
					
					
					for(int i=0;i<studentAwardslists.size();i++){
						@SuppressWarnings("unchecked")
						ArrayList<StudentInstructor> studentInstructors = StudentInstructorslists.get(i);
						StudentAwards studentAwards = studentAwardslists.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(studentAwards);
						boolean result3 = submitInfoAndProofsService.submitResearchMemberInfo(16, studentInstructors);
					    if(!(result1&&result3)){
					    	
					    	return "ERR";
					    }
					}
					
				}	
				
				//插入数据库的操作
				wb.close();// 关闭工作薄
				
				if(writableworkbook.getNumberOfSheets()==0&&studentAwardslists==null
						&&teachingMaterialSetlists==null
						&&TeachersAwardsslist==null&&majorContributelists==null
						&&courseContributelists==null){
					return "ERR";
				}
				
				if(writableworkbook.getNumberOfSheets()==0){
					if(file.exists()){
						
						writableworkbook.close();
						file.delete();
					
					}
					
					return "ALLSUC";
				}else if(writableworkbook!=null){
					try {
						writableworkbook.write();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						writableworkbook.close();
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String wrongExcelId = GenerateUtils.getID();
					
					return excelName;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return "ERR";
			}
		}
		return "ALLSUC";
	}

}
