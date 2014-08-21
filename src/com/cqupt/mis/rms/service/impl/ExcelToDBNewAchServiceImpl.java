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

import com.cqupt.mis.rms.manager.SubmitInfoMemberDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.CourseContributeNew;
import com.cqupt.mis.rms.model.CourseContributeMemberNew;
import com.cqupt.mis.rms.model.MajorContributeNew;
import com.cqupt.mis.rms.model.MajorContributeMemberNew;
import com.cqupt.mis.rms.model.Sheet;
import com.cqupt.mis.rms.model.StudentAwardsNew;
import com.cqupt.mis.rms.model.StudentInstructorNew;
import com.cqupt.mis.rms.model.TeachAchievementsDeclarant;
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.model.TeachersAwardsNew;
import com.cqupt.mis.rms.model.TeachingMaterialEditorNew;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.cqupt.mis.rms.service.ExcelToDBService;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.DoString;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;

public class ExcelToDBNewAchServiceImpl implements ExcelToDBService{
	
	private SubmitInfoAndProofsService submitInfoAndProofsService;
	private SubmitInfoMemberDao submitInfoMemberDao;
	public SubmitInfoMemberDao getSubmitInfoMemberDao() {
		return submitInfoMemberDao;
	}
	public void setSubmitInfoMemberDao(SubmitInfoMemberDao submitInfoMemberDao) {
		this.submitInfoMemberDao = submitInfoMemberDao;
	}
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
			excelName = "NewAch"+tecId+".xls";
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
		 ArrayList<CourseContributeNew> courseContributelists = new ArrayList<CourseContributeNew>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> CourseContributeMemberslist = new ArrayList<ArrayList>();
		 
		 ArrayList<Sheet> majorContributeSheet = new ArrayList<Sheet>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> majorContributeMemberslist = new ArrayList<ArrayList>();
		 List<MajorContributeNew> majorContributelists = new ArrayList<MajorContributeNew>();
		 
		 @SuppressWarnings("rawtypes")
	   	 ArrayList<ArrayList> TeachersAwardsslist = new ArrayList<ArrayList>();
		 ArrayList<Sheet> teachAchievementsSheet = new ArrayList<Sheet>();
		 ArrayList<TeachAchievementsNew> teachAchievementslist = new ArrayList<TeachAchievementsNew>();
		 
		 ArrayList<TeachingMaterialSetNew> teachingMaterialSetlists = new ArrayList<TeachingMaterialSetNew>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> teachingMaterialEditorlists = new ArrayList<ArrayList>();
		 ArrayList<Sheet> teachingMaterialSetSheet = new ArrayList<Sheet>(); 
		 
		 ArrayList<StudentAwardsNew> studentAwardslists = new ArrayList<StudentAwardsNew>();
		 ArrayList<Sheet> StudentAwardsSheet = new ArrayList<Sheet>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> StudentInstructorslists = new ArrayList<ArrayList>();
		 /*****************2013-8-18  HuangHaiYan  add*****************************/
		 @SuppressWarnings("rawtypes")
	   	 ArrayList<ArrayList> TeachAchievementsDeclarantlist = new ArrayList<ArrayList>();
		 ArrayList<Sheet> teachAchievementsNewSheet = new ArrayList<Sheet>();
		 ArrayList<TeachAchievementsCQ> teachAchievementsNewlist = new ArrayList<TeachAchievementsCQ>();
		 
		 
		 
		 boolean b1 = true;
		 
		if (excelfile != null || !"".equals(excelfile)) {
			try {
				
				jxl.Workbook wb = Workbook.getWorkbook(excelfile);// 获取工作薄
				
				for(int i=0;i<wb.getNumberOfSheets();i++){
					
					 jxl.Sheet st = wb.getSheet(i);// 得到工作薄
					 
					 String name =st.getName();
					
					 
					 if("教学奖励类教改项目".equals(name)){
						 
					 
					 
					 for (int j = 1; j < st.getRows()&&st.getCell(3,j).getContents()!=null&&st.getCell(3,j).getContents()!="";j++) { 
						 
						 Sheet sheet = new Sheet();	 
							
						 ArrayList<String> memberName = new ArrayList<String>();
						  
							 String classContribute = "";
							 String typeContribute = "";
							 String timeContribute = "";
							 String chargeMan = "";
							 String majorName = "";
							 String allMember = "";
							 String checkTime = "";
							 String endTime = "";
							 Float rewardCollege = 0.0f;
							 String rewardCollegeWrong;
							 String remarks = "";
							 String projectSource = "";//项目来源
							 Float reportedAmounts = 0f;//申报金额
								
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
							
							majorName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(majorName);
						}else {
							majorName = "请输入教改项目名称";
							sheet.setSheet2(majorName);
						    b1 = false;
						}
						
						
						
						if(st.getCell(3, j).getContents()!=""){
							
							chargeMan = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(chargeMan);
						}else {
							chargeMan = "请输入负责人姓名";
							sheet.setSheet3(chargeMan);
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
								allMember = allMember + "(没有输入其他参与人名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet4(allMember);
					
						}else {
							allMember = allMember + "(请输入其他参与人姓名)";
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
								timeContribute = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							    sheet.setSheet6(timeContribute);
					
						    }else {
						    	timeContribute = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
						    	timeContribute = timeContribute+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012或2012.12或2012）"+"";
								sheet.setSheet6(timeContribute);
						        b1 = false;
						  }
						}
				
						if(st.getCell(7, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(7,j).getContents()))!=null)
							{
								endTime = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
							    sheet.setSheet7(endTime);
					
						    }else {
						    	endTime = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
						    	endTime = endTime+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet7(endTime);
						        b1 = false;
						  }
						}
						
						if(st.getCell(8, j).getContents()!=""){
							
							projectSource = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
							sheet.setSheet8(projectSource);
						}else {
							
							sheet.setSheet8(projectSource);
						}
						
						
						if(st.getCell(9, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(9, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(9, j).getContents())){

								reportedAmounts = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(9,j).getContents()));
								sheet.setSheet9(reportedAmounts+"");
							}else {
								String reportedAmountsWrong = "";
								reportedAmountsWrong = reportedAmounts+"（请输入相应的数值）"+"";
								sheet.setSheet9(reportedAmountsWrong);
								b1 = false;
							}
						}

						if(st.getCell(10, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(10,j).getContents());
							sheet.setSheet10(remarks);
						}else {
							
							sheet.setSheet10(remarks);
						}
						
						if(st.getCell(11, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(11, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(11, j).getContents())){

								rewardCollege = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(11,j).getContents()));
								sheet.setSheet11(rewardCollege+"");
							}else {

								rewardCollegeWrong = rewardCollege+"（请输入相应的数值）"+"";
								sheet.setSheet11(rewardCollegeWrong);
								b1 = false;
							}
						}
						if(b1){
							
							String majorId = GenerateUtils.getID();
							MajorContributeNew majorContribute =new MajorContributeNew();
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
							majorContribute.setReportedAmounts(reportedAmounts);
							majorContribute.setProjectSource(projectSource);
							majorContributelists.add(majorContribute);
							
							 ArrayList<MajorContributeMemberNew> majorContributeMembers = new ArrayList<MajorContributeMemberNew>();

							 MajorContributeMemberNew majorContributeMember1 = new MajorContributeMemberNew();
							 majorContributeMember1.setMajorContributeNew(majorContribute);
							 majorContributeMember1.setMemberName(chargeMan);
							 majorContributeMembers.add(majorContributeMember1);
								for(int m = 1; m < memberName.size(); m++){
									MajorContributeMemberNew majorContributeMember = new MajorContributeMemberNew();
									majorContributeMember.setMajorContributeNew(majorContribute);
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
						 
						writableSheet = writableworkbook.createSheet("教学奖励类教改项目",0);
						
						 Label label = new Label(0,0,"项目级别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"项目类别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"项目名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"负责人");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"其他参与人");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"申报时间");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"结项时间"	);
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"项目来源");	
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"申报金额");	
						  writableSheet.addCell(label);
						  
						  label = new Label(9,0,"备注");
						  writableSheet.addCell(label);
						  
						  label = new Label(10,0,"奖励金额");
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
							  label = new Label(9,m+1,sheets.getSheet9());	
							  writableSheet.addCell(label);
							  label = new Label(10,m+1,sheets.getSheet10());	
							  writableSheet.addCell(label);
						}
				
						 
				}	
				
			    }else if("教学奖励类本科教学工程".equals(name)){
			    	 
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
						  String applicantRanking = "";
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
							
							courseName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(courseName);
						}else {
							courseName = "请输入本科教学工程的名称";
							sheet.setSheet2(courseName);
						    b1 = false;
						}
						
						
						if(st.getCell(3, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有输入负责人名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet3(allMember);
					
						}else {
							allMember = allMember + "(请输入负责人姓名)";
							sheet.setSheet3(allMember);
						
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							applicantRanking = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(courseName);
						}else {
							applicantRanking = "请输入申报人排名";
							sheet.setSheet4(applicantRanking);
						    b1 = false;
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
						
						//项目来源
						if(st.getCell(7, j).getContents()!=""){
							
							timeContribute = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
						    sheet.setSheet7(timeContribute);
						}else {
							
							sheet.setSheet7(timeContribute);
						
						}
						

						//备注
						if(st.getCell(8, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
						    sheet.setSheet8(remarks);
						}else {
							
							sheet.setSheet8(remarks);
						
						}
						
						if(st.getCell(9, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(9, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(9, j).getContents())){

								collegeAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(9,j).getContents()));
								sheet.setSheet9(collegeAward+"");
							}else {

								collegeAwardWrong = collegeAward+"（请输入相应的数值）"+"";
								sheet.setSheet9(collegeAwardWrong);
								b1 = false;
							}
						}
						
						
						if(b1){
							
							String courseId = GenerateUtils.getID();
							CourseContributeNew courseContribute =new CourseContributeNew();
							if(TypeConvert.StringtoDate(checkTime)!=null)
							courseContribute.setCheckTime(TypeConvert.StringtoDate(checkTime));
							courseContribute.setClassContribute(classContribute);
							courseContribute.setCollegeAward(collegeAward);
							courseContribute.setCourseId(courseId);
							courseContribute.setCourseName(courseName);
							courseContribute.setApplicantRanking(applicantRanking);
							if(TypeConvert.StringtoDate(endTime)!=null)
							courseContribute.setEndTime(TypeConvert.StringtoDate(endTime));
							courseContribute.setRemarks(remarks);
							courseContribute.setStatus(status);
							courseContribute.setSubmitUser(user);
							courseContribute.setTimeContribute(timeContribute);
							courseContribute.setTypeContribute(typeContribute);
							
							courseContributelists.add(courseContribute);
							
							 ArrayList<CourseContributeMemberNew> CourseContributeMembers = new ArrayList<CourseContributeMemberNew>();

							 
								for(int m = 0; m < memberName.size(); m++){
									CourseContributeMemberNew courseContributeMember = new CourseContributeMemberNew();
									courseContributeMember.setCourseContributeNew(courseContribute);
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
						 
						writableSheet = writableworkbook.createSheet("教学奖励类本科教学工程",1);
						
						 Label label = new Label(0,0,"项目级别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"项目类别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"项目名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"负责人");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"申报人排名");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"立项时间");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"结题时间"	);
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"项目来源");	
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"备注");	
						  writableSheet.addCell(label);
						  
						  label = new Label(9,0,"奖励金额");	
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
							  label = new Label(8,m+1,sheets.getSheet8());	
							  writableSheet.addCell(label);
							  label = new Label(9,m+1,sheets.getSheet9());	
							  writableSheet.addCell(label);
							
							 
						}
				
						 
				}	
				
					
				}else if("教学奖励类发表教改论文".equals(name)){
					
					 b1 = true;
			    	
					 
					for (int j = 1; j < st.getRows()&&st.getCell(1,j).getContents()!=null&&st.getCell(1,j).getContents()!=""; j++) { 
						 Sheet sheet = new Sheet();	
						 ArrayList<String> memberName = new ArrayList<String>();
						 String allMember = "";
						 
						 
						  String remarks = "";//备注
						  Float wordsNumber = 0f;//字数(千字)
						  String firstChargeMan = "";//是否为第一负责人
						  String authorRank = "";//作者排名
						  String publisher = "";//出版单位
						 
						  String classAchievements = "";
						  String projectName = "";
						  String levelAchievements = "";
						  String timeAchievements = "";
						  Float collegeAward = 0.0f;
						  String collegeAwardWrong;
						  int status = 0;
						
						
						//期刊类别
						if(st.getCell(0, j).getContents()!=""){
							
							classAchievements = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(classAchievements);
					 	
						}else {
							
						    sheet.setSheet0(classAchievements);
						
						}
						
						//期刊名称
						if(st.getCell(1, j).getContents()!=""){
							
							levelAchievements = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(levelAchievements);
						
						}else {
							
							sheet.setSheet1(levelAchievements);
						
						}
						
						//论文名称
						if(st.getCell(2, j).getContents()!=""){
							
							projectName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(projectName);
						
						}else {
							projectName="请输入获得项目成果奖的项目名称";
							sheet.setSheet2(projectName);
							b1 =false;
						}
						
						if(st.getCell(3, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有输如作者名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet3(allMember);
					
						}else {
							allMember = allMember + "(请输入作者姓名)";
							sheet.setSheet3(allMember);
						
						}
						
						
						//是否是第一负责人
						if(st.getCell(4, j).getContents()!=""){
							
							firstChargeMan = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(firstChargeMan);
						
						}else {
							
							firstChargeMan = "是否是第一负责人（是/否）";
							sheet.setSheet4(firstChargeMan);
						
						}

						
						//作者排名
						if(st.getCell(5, j).getContents()!=""){
							
							authorRank = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(authorRank);
						
						}else {
							
							authorRank = "作者排名";
							sheet.setSheet5(authorRank);
						
						}
						
						//出版单位
						if(st.getCell(6, j).getContents()!=""){
							
							publisher = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							sheet.setSheet6(publisher);
						
						}else {
							
							publisher = "请输入出版单位";
							sheet.setSheet6(publisher);
						
						}
						
						
						if(st.getCell(7, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(7,j).getContents()))!=null)
							{
								timeAchievements = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
							    sheet.setSheet7(timeAchievements);
					
						    }else {
						    	timeAchievements = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
						    	timeAchievements = timeAchievements+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet7(timeAchievements);
						        b1 = false;
						  }
						}
						

						String wordsNumberWrong = "";
						if(st.getCell(8, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(8, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(8, j).getContents())){

								wordsNumber = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(8,j).getContents()));
								sheet.setSheet8(wordsNumber+"");
							
							}else {
								
								wordsNumberWrong = wordsNumber.toString()+"（请输入相应的数值）"+"";
								sheet.setSheet8(wordsNumberWrong+"");
								b1 = false;
						    }
						}
						
						if(st.getCell(9, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(9,j).getContents());
							sheet.setSheet9(remarks);
						
						}else {
							
							sheet.setSheet9(remarks);
						
						}
						
						if(st.getCell(10, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(10, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(10, j).getContents())){

								collegeAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(10,j).getContents()));
								sheet.setSheet10(collegeAward+"");
							
							}else {
								
								collegeAwardWrong = collegeAward+"（请输入相应的数值）"+"";
								sheet.setSheet10(collegeAwardWrong+"");
								b1 = false;
						    }
						}	
						
						
						if(b1){
							
							String achievementsId = GenerateUtils.getID();
							TeachAchievementsNew teachAchievementsNew =new TeachAchievementsNew();
							teachAchievementsNew.setAchievementsId(achievementsId);
							teachAchievementsNew.setClassAchievements(classAchievements);
							teachAchievementsNew.setCollegeAward(collegeAward);
							teachAchievementsNew.setLevelAchievements(levelAchievements);
							teachAchievementsNew.setProjectName(projectName);
							teachAchievementsNew.setStatus(status);
							teachAchievementsNew.setSubmitUser(user);
							teachAchievementsNew.setAuthorRank(authorRank);
							teachAchievementsNew.setFirstChargeMan(firstChargeMan);
							teachAchievementsNew.setPublisher(publisher);
							teachAchievementsNew.setRemarks(remarks);
							teachAchievementsNew.setWordsNumber(wordsNumber);
							teachAchievementsNew.setTimeAchievements(TypeConvert.StringtoDate(timeAchievements));
							
							teachAchievementslist.add(teachAchievementsNew);
							
							
							 ArrayList<TeachersAwardsNew> TeachersAwardss = new ArrayList<TeachersAwardsNew>();

								for(int m = 0; m < memberName.size(); m++){
									TeachersAwardsNew teachersAwards = new TeachersAwardsNew();
									teachersAwards.setTeachAchievementsNew(teachAchievementsNew);
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
						 
					   	 writableSheet = writableworkbook.createSheet("教学奖励类发表教改论文",2);
					      Label label = new Label(0,0,"期刊类别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"期刊名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"论文名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"作者");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"是否为第一负责人");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"作者排名");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"出版单位");	
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"出版日期");	
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"字数");
						  writableSheet.addCell(label);
						  
						  label = new Label(9,0,"备注");	
						  writableSheet.addCell(label);
						  
						  label = new Label(10,0,"奖励金额");	
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
							  label = new Label(6,m+1,sheets.getSheet6());	
							  writableSheet.addCell(label);
							  label = new Label(7,m+1,sheets.getSheet7());	
							  writableSheet.addCell(label);
							  label = new Label(8,m+1,sheets.getSheet8());	
							  writableSheet.addCell(label);
							  label = new Label(9,m+1,sheets.getSheet9());	
							  writableSheet.addCell(label);
							  label = new Label(10,m+1,sheets.getSheet10());	
							  writableSheet.addCell(label);
							 
							
						}
				
				  }
					
				}else if("教学奖励类教材出版".equals(name)){
					
					
					 
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
							 Float wordsNumbers = 0f;//字数（千字）
							 String remarks = "";//备注
							 Float collegeAward = 0f;//奖励金额
							 int status = 0;
						
						//教材等级
						if(st.getCell(0, j).getContents()!=""){
							
							setClass = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(setClass);
					 	
						}else {
							
						    sheet.setSheet0(setClass);
						
						}
						
						//教材名称
						if(st.getCell(1, j).getContents()!=""){
							
							teachingMaterialName = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(teachingMaterialName);
						
						}else {
							teachingMaterialName = "请输入教材名称";
							sheet.setSheet1(teachingMaterialName);
							b1 = false;
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
								allMember = allMember + "(没有输作者名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet2(allMember);
					
						}else {
							allMember = allMember + "(请输入作者姓名)";
							sheet.setSheet2(allMember);
						
						}
						
						String rank = "";
						//作者排名
						if(st.getCell(3, j).getContents()!=""){
							
							rank = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(rank);
					 	
						}else {
							
						    sheet.setSheet3(rank);
						
						}
						
						//类别
						if(st.getCell(4, j).getContents()!=""){
							
							numberProject = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(numberProject);
					 	
						}else {
							
						    sheet.setSheet4(numberProject);
						
						}
						
						//出版单位
						if(st.getCell(5, j).getContents()!=""){
							
							resultsPostedStatus = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(resultsPostedStatus);
					 	
						}else {
							
						    sheet.setSheet5(resultsPostedStatus);
						
						}
						
						//出版日期
						if(st.getCell(6, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(6,j).getContents()))!=null)
							{
								setTime = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							    sheet.setSheet6(setTime);
					
						    }else {
						    	setTime = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
						    	setTime = setTime+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet6(setTime);
						        b1 = false;
						  }
						}
						
						//字数
						String wordsNumbersWrong = "";
						if(st.getCell(7, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(7, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(7, j).getContents())){

								wordsNumbers = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(7,j).getContents()));
								sheet.setSheet7(collegeAward+"");
							
							}else {
								
								wordsNumbersWrong = collegeAward+"（请输入相应的数值（字数（千字）））"+"";
								sheet.setSheet7(wordsNumbersWrong+"");
								b1 = false;
						    }
						}	
						
						
						//备注
						if(st.getCell(8, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
							sheet.setSheet8(remarks);
						
						}else {
							sheet.setSheet8(remarks);
						}
						
						//奖励金额
						String collegeAwardWrong = "";
						if(st.getCell(9, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(9, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(9, j).getContents())){

								collegeAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(9,j).getContents()));
								sheet.setSheet9(collegeAward+"");
							
							}else {
								
								collegeAwardWrong = collegeAward+"（请输入相应的奖励金额）"+"";
								sheet.setSheet9(collegeAwardWrong+"");
								b1 = false;
						    }
						}
						
						
						
						
						if(b1){
							
							String teachingMaterialId = GenerateUtils.getID();
							TeachingMaterialSetNew teachingMaterialSet =new TeachingMaterialSetNew();
							teachingMaterialSet.setNumberProject(numberProject);
							teachingMaterialSet.setResultsPostedStatus(resultsPostedStatus);
							teachingMaterialSet.setSetClass(setClass);
							teachingMaterialSet.setSetTime(setTime);
							teachingMaterialSet.setStatus(status);
							teachingMaterialSet.setSubmitUser(user);
							teachingMaterialSet.setCollegeAward(collegeAward);
							teachingMaterialSet.setRemarks(remarks);
							teachingMaterialSet.setWordsNumbers(wordsNumbers);
							teachingMaterialSet.setTeachingMaterialId(teachingMaterialId);
							teachingMaterialSet.setTeachingMaterialName(teachingMaterialName);
							
							teachingMaterialSetlists.add(teachingMaterialSet);
							
							
							
							 ArrayList<TeachingMaterialEditorNew> teachingMaterialEditors = new ArrayList<TeachingMaterialEditorNew>();

								for(int m = 0; m < memberName.size(); m++){
									TeachingMaterialEditorNew teachingMaterialEditor = new TeachingMaterialEditorNew();
									teachingMaterialEditor.setTeachingMaterialSetNew(teachingMaterialSet);
									teachingMaterialEditor.setEditorName(memberName.get(m));
									teachingMaterialEditor.setRemarks(rank);
									teachingMaterialEditors.add(teachingMaterialEditor);
								}
								 
				
								teachingMaterialEditorlists.add(teachingMaterialEditors);
						    
						}else{
							b1 = true;
							teachingMaterialSetSheet.add(sheet);
						}	
					}
					
					 
					 if(teachingMaterialSetSheet.size()!=0){
						 
					   	 writableSheet = writableworkbook.createSheet("教学奖励类教材出版",3);
					      Label label = new Label(0,0,"教材等级");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"教材名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"作者");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"作者排名");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"类别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"出版单位");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"出版日期");
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"字数（千字）");
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"备注");
						  writableSheet.addCell(label);
						  
						  label = new Label(9,0,"奖励金额");
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
							  label = new Label(6,m+1,sheets.getSheet6());	
							  writableSheet.addCell(label);
							  label = new Label(7,m+1,sheets.getSheet7());	
							  writableSheet.addCell(label);
							  label = new Label(8,m+1,sheets.getSheet8());	
							  writableSheet.addCell(label);
							  label = new Label(9,m+1,sheets.getSheet9());	
							  writableSheet.addCell(label);
							
						}
				
				  }
					
				}else if("教学奖励类指导学生参赛获奖".equals(name)){
					
					 
					 
					for (int j = 1; j < st.getRows()&&st.getCell(2,j).getContents()!=null&&st.getCell(2,j).getContents()!=""; j++) { 
						b1 = true;
				    	 Sheet sheet = new Sheet();	
				    	 ArrayList<String> memberName = new ArrayList<String>();
						 String allMember = "";
						 
	
						     String rewardName = "";
						     String rewardUnit = "";
						     String rewardLevel = "";
						     String rewardTime = "";
							 String rewardStudents = "";
							 String firstStudents = "";
							 String remarks = "";
							 String collegeAward = "";
							 int status = 0;
						
					    if(st.getCell(1, j).getContents()!=""){
							
							rewardName = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(rewardName);
						
						}else {
							rewardName = "请输入赛事名称";
							sheet.setSheet1(rewardName);
							b1 = false;
						}
						
					    if(st.getCell(2, j).getContents()!=""){
							
					    	rewardUnit = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(rewardUnit);
						
						}else {
							rewardUnit = "请输入颁奖单位";
							sheet.setSheet2(rewardUnit);
							b1 = false;
						}
					    
						
						if(st.getCell(3, j).getContents()!=""){
							
							rewardLevel = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(rewardLevel);
						
						}else {
							
							sheet.setSheet3(rewardLevel);
						
						}
					    
						if(st.getCell(4, j).getContents()!=""){
							
							rewardTime = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(rewardTime);
					 	
						}else {
							
						    sheet.setSheet4(rewardTime);
						
						}
						
						if(st.getCell(5, j).getContents()!=""){
							
							rewardStudents = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(rewardStudents);
						
						}else {
							sheet.setSheet5(rewardStudents);
						}
						
						if(st.getCell(6, j).getContents()!=""){
							
							firstStudents = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							sheet.setSheet6(firstStudents);
					 	
						}else {
							
						    sheet.setSheet6(firstStudents);
						
						}
						
		
						
						if(st.getCell(7, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有输指导教师或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet7(allMember);
					
						}else {
							allMember = allMember + "(请输入指导教师)";
							sheet.setSheet7(allMember);
						
						}
						
						
						if(st.getCell(8, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
							sheet.setSheet8(remarks);
					 	
						}else {
							
						    sheet.setSheet8(remarks);
						
						}
						
						if(st.getCell(9, j).getContents()!=""){
							
							collegeAward = DoString.nulltoEmptyString(st.getCell(9,j).getContents());
							sheet.setSheet9(collegeAward);
						
						}else {
							
							sheet.setSheet9(collegeAward);
						
						} 
						
						
				
						
					
						
						
						
						if(b1){
							
							String awardsId = GenerateUtils.getID();
							StudentAwardsNew studentAwards =new StudentAwardsNew();
							studentAwards.setAwardsId(awardsId);
							studentAwards.setCollegeAward(Float.parseFloat(collegeAward));
							studentAwards.setRewardLevel(rewardLevel);
							studentAwards.setRewardName(rewardName);
							studentAwards.setRewardStudents(rewardStudents);
							studentAwards.setRewardTime(rewardTime);
							studentAwards.setStatus(status);
							studentAwards.setRemarks(remarks);
							studentAwards.setFirstStudents(firstStudents);
							studentAwards.setRewardUnit(rewardUnit);
							studentAwards.setSubmitUser(user);
							studentAwardslists.add(studentAwards);
							
							
							
							 ArrayList<StudentInstructorNew> studentInstructors = new ArrayList<StudentInstructorNew>();

								for(int m = 0; m < memberName.size(); m++){
									StudentInstructorNew studentInstructor = new StudentInstructorNew();
									studentInstructor.setStudentAwardsNew(studentAwards);
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
						 
					   	 writableSheet = writableworkbook.createSheet("教学奖励类指导学生参赛获奖",4);
					      Label label = new Label(0,0,"赛事名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"颁奖单位");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"获奖级别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"获奖时间");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"学生团队成员");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"排名第一的学生姓名");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"指导教师");
						  writableSheet.addCell(label);
						 
						  label = new Label(7,0,"备注");
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"奖励金额");
						  writableSheet.addCell(label);
						
						 for(int m=0;m<StudentAwardsSheet.size();m++){
							
							 Sheet sheets = StudentAwardsSheet.get(m);
							 
							  label = new Label(0,m+1,sheets.getSheet1());	
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
					
				}else if("教学奖励类重庆市大学生创新创业训练计划项目".equals(name)){
					
					for (int j = 1; j < st.getRows()&&st.getCell(2,j).getContents()!=null&&st.getCell(2,j).getContents()!=""; j++) { 
						b1 = true;
				    	 Sheet sheet = new Sheet();	
				    	 ArrayList<String> memberName = new ArrayList<String>();
						 String allMember = "";
						 
							 String classAchievements = "";
							 String gradeAchievements = "";
							 String projectName = "";
							 String projectType = "";
							 String timeAchievements = null;
							 String certificationUnit = "";
							 Float reportedAmounts = 0.0f;
							 Float verifyAmounts = 0.0f;
							 String submitUser = "";
							 String  approvedUser = "";
							 String remarks = "";
							 String chargeMan = "";
						 
							 int status = 0;
						
						
							//项目编号
						if(st.getCell(0, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(0, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(0, j).getContents())){

								reportedAmounts = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(0,j).getContents()));
								sheet.setSheet0(reportedAmounts+"");
							
							}else {
								sheet.setSheet0("（请输入相应的数值）");
								b1 = false;
						    }
						}
						if(st.getCell(1, j).getContents()!=""){
							
							projectName = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(projectName);
						
						}else {
							projectName = "请输入项目名称";
							sheet.setSheet1(projectName);
							b1 = false;
						}
						
						//立项时间
						if(st.getCell(2, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(2,j).getContents()))!=null)
							{
								timeAchievements = TypeConvert.StringtoDate(st.getCell(2,j).getContents()).toString();
							    sheet.setSheet2(timeAchievements.toString());
					
						    }else {
								sheet.setSheet2(st.getCell(2, j).getContents()+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）");
								b1=false;
						  }
					 	
						}
						
						//结题时间
						if(st.getCell(3, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(3,j).getContents()))!=null)
							{
								gradeAchievements = TypeConvert.StringtoDate(st.getCell(3,j).getContents()).toString();
							    sheet.setSheet3(gradeAchievements.toString());
					
						    }else {
								sheet.setSheet3(st.getCell(3, j).getContents()+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）");
								b1=false;
						  }
					 	
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							projectType = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(projectType);
						
						}else {
							projectType = "请输入项目类别";
							sheet.setSheet4(projectType);
							b1 = false;
						}
						
						if(st.getCell(5, j).getContents()!=""){
							
							classAchievements = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(classAchievements);
					 	
						}else {
							classAchievements = "请输入负责人（学生）";
						    sheet.setSheet5(classAchievements);
						    b1 = false;
						}
						
						//团队成员
						if(st.getCell(6, j).getContents()!=""){
							
							certificationUnit = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							sheet.setSheet6(certificationUnit);
						
						}else {
							
							sheet.setSheet6(certificationUnit);
						
						}
						
						
						//指导老师
						if(st.getCell(7, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(在输入其指导老师的名字中间出现了空格)";
							}
							sheet.setSheet7(allMember);
					
						}else {
							sheet.setSheet7(allMember);
						
						}
						
						
						if(st.getCell(8, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
							sheet.setSheet8(remarks);
						
						}else {
							
							sheet.setSheet8(remarks);
						
						}
						
						//奖励金额
						if(st.getCell(9, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(9, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(9, j).getContents())){

								verifyAmounts = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(9,j).getContents()));
								sheet.setSheet9(verifyAmounts+"");
							
							}else {
								sheet.setSheet9("（请输入相应的数值）");
								b1 = false;
						    }
						}
						
						
						if(b1){
							
							String achievementsId = GenerateUtils.getID();
							TeachAchievementsCQ TeachAchievementsCQ =new TeachAchievementsCQ();
							TeachAchievementsCQ.setAchievementsId(achievementsId);
							TeachAchievementsCQ.setCertificationUnit(certificationUnit);
							TeachAchievementsCQ.setClassAchievements(classAchievements);
							TeachAchievementsCQ.setGradeAchievements(gradeAchievements);
							TeachAchievementsCQ.setProjectName(projectName);
							TeachAchievementsCQ.setProjectType(projectType);
							TeachAchievementsCQ.setRemarks(remarks);
							TeachAchievementsCQ.setReportedAmounts(reportedAmounts.toString());
							TeachAchievementsCQ.setStatus(status);
							TeachAchievementsCQ.setSubmitUser(user);
							TeachAchievementsCQ.setTimeAchievements(timeAchievements.toString());
							TeachAchievementsCQ.setVerifyAmounts(verifyAmounts);
							
							
							teachAchievementsNewlist.add(TeachAchievementsCQ);
							
							
							
							 ArrayList<TeachAchievementsDeclarant> teachAchievementsDeclarantlists = new ArrayList<TeachAchievementsDeclarant>();

							 	TeachAchievementsDeclarant teachAchievementsDeclarant= new TeachAchievementsDeclarant();
							 	
							 	CQUPTUser cQUPTUser = submitInfoMemberDao.findCQUPTUserByUserName(chargeMan);
							 	teachAchievementsDeclarant.setTeachAchievementsCQ(TeachAchievementsCQ);
							 	teachAchievementsDeclarant.setDeclarantName(chargeMan);
							 	teachAchievementsDeclarant.setOrders(1);
							 	if(cQUPTUser!=null){
							 		teachAchievementsDeclarant.setDeclarantId(cQUPTUser.getUserId());
							 	}
							 	
							 	teachAchievementsDeclarantlists.add(teachAchievementsDeclarant);
								
								for(int m = 0; m < memberName.size(); m++){
									teachAchievementsDeclarant.setTeachAchievementsCQ(TeachAchievementsCQ);
									teachAchievementsDeclarant.setDeclarantName(memberName.get(m));
									teachAchievementsDeclarant.setOrders(m+2);
									cQUPTUser = submitInfoMemberDao.findCQUPTUserByUserName(memberName.get(m));
									if(cQUPTUser!=null){
								 		teachAchievementsDeclarant.setDeclarantId(cQUPTUser.getUserId());
								 	}
									teachAchievementsDeclarantlists.add(teachAchievementsDeclarant);
								}
								 
				
								TeachAchievementsDeclarantlist.add(teachAchievementsDeclarantlists);
						    
						}else{
							b1 = true;
							teachAchievementsNewSheet.add(sheet);
						}	
					}
					
					 
					if(teachAchievementsNewSheet.size()!=0){
						 
					   	 writableSheet = writableworkbook.createSheet("教学奖励类重庆市大学生创新创业训练计划项目",5);
					      
					   	 
					   	  Label label = new Label(0,0,"项目编号");	
						  
					      writableSheet.addCell(label);
						  
					      label = new Label(1,0,"项目名称");	
						  
					      writableSheet.addCell(label);
					      
						  label = new Label(2,0,"立项时间");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"结题时间");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"类型");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"负责人（学生）");	
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"团队成员");
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"指导老师");
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"备注");
						  writableSheet.addCell(label);
						  
						  label = new Label(9,0,"奖励金额");
						  writableSheet.addCell(label);
						  
						  
						 
						 for(int m=0;m<teachAchievementsNewSheet.size();m++){
							
							 Sheet sheets = teachAchievementsNewSheet.get(m);
							 
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
							  label = new Label(9,m+1,sheets.getSheet9());	
							  writableSheet.addCell(label);
							  
							
						}
				
				  }
					
				}else{
					return "ERR";
				}
			}
				
				if(courseContributelists!=null){
					
					
					for(int i=0;i<courseContributelists.size();i++){
						
						CourseContributeNew courseContribute = courseContributelists.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<CourseContributeMemberNew> courseContributeMembers = CourseContributeMemberslist.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(courseContribute);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(21, courseContributeMembers);
					    if(!(result2 || result1)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(majorContributelists!=null){
					
					
					for(int i=0;i<majorContributelists.size();i++){
						
						MajorContributeNew majorContribute = majorContributelists.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<MajorContributeMemberNew> majorContributeMembers = majorContributeMemberslist.get(i);
						
						boolean result1 = submitInfoAndProofsService.submitInfo(majorContribute);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(20, majorContributeMembers);
					    if(!(result2 || result1)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(TeachersAwardsslist!=null){
					
					
					for(int i=0;i<TeachersAwardsslist.size();i++){
						
						TeachAchievementsNew teachAchievements = teachAchievementslist.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<TeachersAwardsNew> teachersAwards = TeachersAwardsslist.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(teachAchievements);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(22, teachersAwards);
					    	
							if(!(result1&&result2)){
						    	
						    	return "ERR";
						    }
					    }
				}
					
				

				if(teachingMaterialSetlists!=null){
					
					
					for(int i=0;i<teachingMaterialSetlists.size();i++){
						@SuppressWarnings("unchecked")
						ArrayList<TeachingMaterialEditorNew> teachingMaterialEditors = teachingMaterialEditorlists.get(i);
						TeachingMaterialSetNew teachingMaterialSet = teachingMaterialSetlists.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(teachingMaterialSet);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(24, teachingMaterialEditors);

					    if(!(result1&&result2)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(studentAwardslists!=null){
					
					
					for(int i=0;i<studentAwardslists.size();i++){
						@SuppressWarnings("unchecked")
						ArrayList<StudentInstructorNew> studentInstructors = StudentInstructorslists.get(i);
						StudentAwardsNew studentAwards = studentAwardslists.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(studentAwards);
						boolean result3 = submitInfoAndProofsService.submitResearchMemberInfo(23, studentInstructors);
					    if(!(result1&&result3)){
					    	
					    	return "ERR";
					    }
					}
					
				}	
				
				if(TeachAchievementsDeclarantlist!=null){
					
					for(int i=0;i<TeachAchievementsDeclarantlist.size();i++){
						
						TeachAchievementsCQ teachAchievementsCQ = teachAchievementsNewlist.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<TeachAchievementsDeclarant> teachAchievementsDeclarant = TeachAchievementsDeclarantlist.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(teachAchievementsCQ);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(19, teachAchievementsDeclarant);
					    	
							if(!(result1&&result2)){
						    	
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
