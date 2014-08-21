package com.cqupt.mis.rms.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeeting;
import com.cqupt.mis.rms.model.HumanitiesAcademicMeetingPerson;
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesBookAuthor;
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesExchangePaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesPaper;
import com.cqupt.mis.rms.model.HumanitiesPaperAuthor;
import com.cqupt.mis.rms.model.HumanitiesProject;
import com.cqupt.mis.rms.model.HumanitiesProjectDetail;
import com.cqupt.mis.rms.model.HumanitiesProjectMember;
import com.cqupt.mis.rms.model.HumanitiesResearchReward;
import com.cqupt.mis.rms.model.HumanitiesResearchRewardPerson;
import com.cqupt.mis.rms.model.Sheet;
import com.cqupt.mis.rms.service.ExcelToDBService;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.DoString;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;
/**
*<p>Title:实现管理用户信息Service</p>
*<p>Description:从excel导入人文类信息到数据库</p>
*@author HuangHaiyan
*@version 1.0
**/
public class ExcelToDBHumServiceImpl implements ExcelToDBService{

    private SubmitInfoAndProofsService submitInfoAndProofsService;
	
	public SubmitInfoAndProofsService getSubmitInfoAndProofsService() {
		return submitInfoAndProofsService;
	}
	public void setSubmitInfoAndProofsService(
			SubmitInfoAndProofsService submitInfoAndProofsService) {
		this.submitInfoAndProofsService = submitInfoAndProofsService;
	}
	/**
	 * 从EXCEL表格里面导入人文类科研信息进入数据库
	 * @param excelfile EXCEL文件
	 * @return  String SUCCESS 表示全部导入成功 ;ERR 表示导入失败;excelName 表示导入了一部分正确的数据
	 */
	@Override
	public String readInfoExceltoDB(File excelfile,String userId,String url) {
		// TODO Auto-generated method stub
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
		
		ArrayList<HumanitiesPaper> humanitiesPaperlist = new ArrayList<HumanitiesPaper>();
		@SuppressWarnings("rawtypes")
		ArrayList<ArrayList> humanitiesPaperMembers=new ArrayList<ArrayList>();
		ArrayList<Sheet> humanitiesPaperSheetlist = new ArrayList<Sheet>();
		 
		ArrayList<HumanitiesBook> humanitiesBooklist=new ArrayList<HumanitiesBook>();
		@SuppressWarnings("rawtypes")
		ArrayList<ArrayList> humanitiesBookMembers=new ArrayList<ArrayList>();
		ArrayList<Sheet> humanitiesBookSheetlist = new ArrayList<Sheet>();
		
		ArrayList<HumanitiesProject> humanitiesProjectlist=new ArrayList<HumanitiesProject>();
		ArrayList<HumanitiesProjectDetail> humanitiesProjectDetaillist=new ArrayList<HumanitiesProjectDetail>();
		@SuppressWarnings("rawtypes")
		ArrayList<ArrayList> humanitiesProjectMembers=new ArrayList<ArrayList>();
		ArrayList<Sheet> humanitiesProjectSheetlist=new ArrayList<Sheet>();
		
		ArrayList<HumanitiesExchangePaper> humanitiesExchangePaperlist=new ArrayList<HumanitiesExchangePaper>();
		ArrayList<Sheet> humanitiesExchangePaperSheetlist=new ArrayList<Sheet>();
		@SuppressWarnings("rawtypes")
		ArrayList<ArrayList> humanitiesExchangePaperMembers=new ArrayList<ArrayList>();
		
		ArrayList<HumanitiesResearchReward> humanitiesResearchRewardlist=new ArrayList<HumanitiesResearchReward>();
		ArrayList<Sheet> humanitiesResearchRewardSheetlist=new ArrayList<Sheet>();
		@SuppressWarnings("rawtypes")
		ArrayList<ArrayList> HumanitiesResearchRewardMembers=new ArrayList<ArrayList>();
		
		ArrayList<HumanitiesAcademicMeeting> humanitiesAcademicMeetinglist=new ArrayList<HumanitiesAcademicMeeting>();
		ArrayList<Sheet> humanitiesAcademicMeetingSheetlist=new ArrayList<Sheet>();
		@SuppressWarnings("rawtypes")
		ArrayList<ArrayList> HumanitiesAcademicMeetingMembers=new ArrayList<ArrayList>();
		
		 boolean b1 = true;
		 
			if (excelfile != null || !"".equals(excelfile)) {
				try {
					
					jxl.Workbook wb = Workbook.getWorkbook(excelfile);// 获取工作薄
					
					for(int i=0;i<wb.getNumberOfSheets();i++){
						
						 jxl.Sheet st = wb.getSheet(i);// 得到工作薄
						 
						 String name =st.getName();
						 
						 if("人文类论文".equals(name)){
							b1 = true;
					    	
							
							for (int j = 3; j < st.getRows()&&st.getCell(3,j).getContents()!=null&&st.getCell(3,j).getContents()!=""; j++) {
								Sheet sheet = new Sheet();	 
								String paperName="";
								String publishedTime="";
								String postPublication="";
								String publishedGrades="";
								String searchStation="";
								String belongProject="";
								String subjectsClassify="";
								String achievementQuote="";

								int status=0;
								String firstAuthor="";
								String allMember="";
								ArrayList<String> memberName=new ArrayList<String>();
								
								if(st.getCell(0, j).getContents()!=""){
									
									firstAuthor = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
									sheet.setSheet0(firstAuthor);
							 	
								}else {
									
									firstAuthor="第一作者不能为空";
									sheet.setSheet0(firstAuthor);
									b1 =false;
								
								}

								if(st.getCell(1, j).getContents()!=""){
									boolean b=true;

									allMember = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
									allMember = firstAuthor +";"+ allMember;
									memberName = TypeConvert.getNames(allMember);
									if(memberName != null){
										for(int m = 0; m < memberName.size(); m++){
												
											if(memberName.get(m)==null||memberName.get(m).length()<=1){
														
													   b = false;
											}
										}
									}
									if(b == false){
										allMember = allMember + "(没有其他负责人名字或则在某个人的名字中间出项了空格)";
									}
									sheet.setSheet1(allMember);
								}else {
									sheet.setSheet1(allMember);
								}

								
								if(st.getCell(2, j).getContents()!=""){
									
									paperName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
									sheet.setSheet2(paperName);
								 	
								}else {
									paperName="请输入成果名称";
									sheet.setSheet2(paperName);
									b1 =false;
								
								}
								
								if(st.getCell(3, j).getContents()!=""){
									
									publishedTime = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
									sheet.setSheet3(paperName);
								 	
								}else {
									
									sheet.setSheet3(publishedTime);
								}
								
								if(st.getCell(4, j).getContents()!=""){
									
									postPublication = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
									sheet.setSheet4(postPublication);
								 	
								}else {
									
									sheet.setSheet4(postPublication);
								}
								
								if(st.getCell(5, j).getContents()!=""){
									
									publishedGrades = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
									sheet.setSheet5(publishedGrades);
								 	
								}else {
									
									sheet.setSheet5(publishedGrades);
								}
								
								if(st.getCell(6, j).getContents()!=""){
									
									searchStation = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
									sheet.setSheet6(searchStation);
								 	
								}else {
									
									sheet.setSheet6(searchStation);
								}
								
								if(st.getCell(7, j).getContents()!=""){
									
									belongProject = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
									sheet.setSheet7(belongProject);
								 	
								}else {
									
									sheet.setSheet7(belongProject);
								}
								
								if(st.getCell(8, j).getContents()!=""){
									
									subjectsClassify = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
									sheet.setSheet8(subjectsClassify);
								 	
								}else {
									
									sheet.setSheet8(subjectsClassify);
								}
								
								if(st.getCell(9, j).getContents()!=""){
									
									achievementQuote = DoString.nulltoEmptyString(st.getCell(9,j).getContents());
									sheet.setSheet9(achievementQuote);
								 	
								}else {
									
									sheet.setSheet9(achievementQuote);
								}
								
								if(b1){
									String paperId=GenerateUtils.getID();
									user.setUserId(userId);
									HumanitiesPaper humanitiesPaper=new HumanitiesPaper();
									humanitiesPaper.setAchievementQuote(achievementQuote);
									humanitiesPaper.setSubjectsClassify(subjectsClassify);
									humanitiesPaper.setBelongProject(belongProject);
									humanitiesPaper.setSearchStation(searchStation);
									humanitiesPaper.setPublishedGrades(publishedGrades);
									humanitiesPaper.setPostPublication(postPublication);
									humanitiesPaper.setPublishedTime(publishedTime);
									humanitiesPaper.setPaperName(paperName);
									humanitiesPaper.setPaperId(paperId);
									humanitiesPaper.setStatus(status);
									humanitiesPaper.setSubmitUser(user);
									humanitiesPaperlist.add(humanitiesPaper);
									
									ArrayList<HumanitiesPaperAuthor> humanitiesPaperAuthors=new ArrayList<HumanitiesPaperAuthor>();
									
									if(memberName.size()!=0){
										for(int m = 0; m < memberName.size(); m++){
											HumanitiesPaperAuthor humanitiesPaperAuthor = new HumanitiesPaperAuthor();
											humanitiesPaperAuthor.setHumanitiesPaper(humanitiesPaper);
											humanitiesPaperAuthor.setAuthorName(memberName.get(m));
											
											humanitiesPaperAuthors.add(humanitiesPaperAuthor);
										}
									 }else{
										HumanitiesPaperAuthor humanitiesPaperAuthor = new HumanitiesPaperAuthor();
										humanitiesPaperAuthor.setHumanitiesPaper(humanitiesPaper);
										humanitiesPaperAuthor.setAuthorName(firstAuthor);
										humanitiesPaperAuthors.add(humanitiesPaperAuthor);
									}
									humanitiesPaperMembers.add(humanitiesPaperAuthors);
								}else{
									b1 = true;
									humanitiesPaperSheetlist.add(sheet);
								}	
								
						}
							if(humanitiesPaperSheetlist.size()!=0){
								 
								 writableSheet = writableworkbook.createSheet("人文类论文",0);
								  
								Label label = new Label(0,0,"人文社科论文统计表");	
								WritableCellFormat cellFormat=new WritableCellFormat();
								cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
								label.setCellFormat(cellFormat);
								writableSheet.addCell(label);
								writableSheet.mergeCells(0,0,10,1);
									 
								 label = new Label(0,2,"第一作者");	
								 writableSheet.addCell(label);
								  
								  label = new Label(1,2,"其它作者");
								  writableSheet.addCell(label);
								  
								  label = new Label(2,2,"成果名称");
								  writableSheet.addCell(label);
								  
								  label = new Label(3,2,"出版日期/期号");	
								  writableSheet.addCell(label);
								  
								  label = new Label(4,2,"发表刊物");	
								  writableSheet.addCell(label);
								  
								  label = new Label(5,2,"刊物级别(cssci、核心、公开发表)");
								  writableSheet.addCell(label);
								  
								  label = new Label(6,2,"检索情况");	
								  writableSheet.addCell(label);
								  
								  label = new Label(7,2,"成果所属项目");	
								  writableSheet.addCell(label);
								  
								  label = new Label(8,2,"学科门类");	
								  writableSheet.addCell(label);
								  
								  label = new Label(9,2,"成果引用采纳情况");	
								  writableSheet.addCell(label);
								  
								
								 for(int m=0;m<humanitiesPaperSheetlist.size();m++){
									
									 Sheet sheets = humanitiesPaperSheetlist.get(m);
									 
									 label = new Label(0,m+3,m+1+"");	
									  writableSheet.addCell(label);
									  label = new Label(1,m+3,sheets.getSheet1());	
									  writableSheet.addCell(label);
									  label = new Label(2,m+3,sheets.getSheet2());	
									  writableSheet.addCell(label);
									  label = new Label(3,m+3,sheets.getSheet3());	
									  writableSheet.addCell(label);
									  label = new Label(4,m+3,sheets.getSheet4());	
									  writableSheet.addCell(label);
									  label = new Label(5,m+3,sheets.getSheet5());	
									  writableSheet.addCell(label);
									  label = new Label(6,m+3,sheets.getSheet6());	
									  writableSheet.addCell(label);
									  label = new Label(7,m+3,sheets.getSheet7());	
									  writableSheet.addCell(label);
									  label = new Label(8,m+3,sheets.getSheet8());	
									  writableSheet.addCell(label);
									  label = new Label(9,m+6,sheets.getSheet9());	
									  writableSheet.addCell(label);
									  label = new Label(10,m+3,sheets.getSheet10());	
									  writableSheet.addCell(label);
								}

						}
							
						 }else if("人文类著作".equals(name)){
							b1 = true;
						    
							
							for (int j = 3; j < st.getRows()&&st.getCell(2,j).getContents()!=null&&st.getCell(2,j).getContents()!=""; j++) {
								
								Sheet sheet = new Sheet();	
							    
								String bookName="";
								String grades="";
								String publisher="";
								Date publishedTime=null;
								String ISBN="";
								float wordcount=0;
								String belongProject="";
								String subjectsClassify="";
								String achievementQuote="";

								int status=0;
								String firstAuthor="";
								String allMember="";
								ArrayList<String> memberName=new ArrayList<String>();
								
								if(st.getCell(0, j).getContents()!=""){
									
									firstAuthor = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
									sheet.setSheet0(firstAuthor);
							 	
								}else {
									
									firstAuthor="第一作者不能为空";
									sheet.setSheet0(firstAuthor);
									b1 =false;
								
								}

								if(st.getCell(1, j).getContents()!=""){
									boolean b=true;

									allMember = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
									allMember = firstAuthor +";"+ allMember;
									memberName = TypeConvert.getNames(allMember);
									if(memberName != null){
										for(int m = 0; m < memberName.size(); m++){
												
											if(memberName.get(m)==null||memberName.get(m).length()<=1){
														
													   b = false;
											}
										}
									}
									if(b == false){
										allMember = allMember + "(没有其他负责人名字或则在某个人的名字中间出项了空格)";
									}
									sheet.setSheet1(allMember);
								}else {
									sheet.setSheet1(allMember);
								}
								
								if(st.getCell(2, j).getContents()!=""){
									
									bookName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
									sheet.setSheet2(bookName);
							 	
								}else {
									
									bookName="成果名称不能为空";
									sheet.setSheet2(bookName);
									b1 =false;
								
								}
								
								if(st.getCell(3, j).getContents()!=""){
									
									grades = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
									sheet.setSheet3(grades);
							 	
								}else {
									
									sheet.setSheet3(grades);
								}
								
								if(st.getCell(4, j).getContents()!=""){
									
									publisher = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
									sheet.setSheet4(publisher);
							 	
								}else {
									
									sheet.setSheet4(publisher);
								}
								
								if(st.getCell(5, j).getContents()!=""){
									
									if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(5,j).getContents()))!=null)
									{
										publishedTime = TypeConvert.StringtoDate(st.getCell(5,j).getContents());
									    sheet.setSheet5(publishedTime.toString());
							
								    }else {
										sheet.setSheet5(st.getCell(5, j).getContents()+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）");
										b1=false;
								  }
							 	
								}
								
								if(st.getCell(6, j).getContents()!=""){
									
									ISBN = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
									sheet.setSheet6(ISBN);
								
								}else {
									sheet.setSheet6(ISBN);
								}
								
								if(st.getCell(7, j).getContents()!=""){
									
									if(TypeConvert.StringIsInt(st.getCell(7, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(7, j).getContents())){

										wordcount = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(7,j).getContents()));
										sheet.setSheet7(wordcount+"");
									
									}else {
										sheet.setSheet7("（请输入相应的数值）");
										b1 = false;
								    }
								}
								
								if(st.getCell(8, j).getContents()!=""){
									
									belongProject = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
									sheet.setSheet8(belongProject);
								
								}else {
									sheet.setSheet8(belongProject);
								}
								
								if(st.getCell(9, j).getContents()!=""){
									
									subjectsClassify = DoString.nulltoEmptyString(st.getCell(9,j).getContents());
									sheet.setSheet9(subjectsClassify);
								
								}else {
									sheet.setSheet9(subjectsClassify);
								}
								
								if(st.getCell(10, j).getContents()!=""){
									
									achievementQuote = DoString.nulltoEmptyString(st.getCell(10,j).getContents());
									sheet.setSheet10(achievementQuote);
								
								}else {
									sheet.setSheet10(achievementQuote);
								}
								
								if(b1){
									user.setUserId(userId);
									String bookId=GenerateUtils.getID();
									HumanitiesBook humanitiesBook=new HumanitiesBook();
									humanitiesBook.setAchievementQuote(achievementQuote);
									humanitiesBook.setSubmitUser(user);
									humanitiesBook.setBelongProject(belongProject);
									humanitiesBook.setBookId(bookId);
									humanitiesBook.setBookName(bookName);
									humanitiesBook.setGrades(grades);
									humanitiesBook.setISBN(ISBN);
									humanitiesBook.setPublishedTime(publishedTime);
									humanitiesBook.setPublisher(publisher);
									humanitiesBook.setStatus(status);
									humanitiesBook.setSubjectsClassify(subjectsClassify);
									humanitiesBook.setWordcount(wordcount);
									
									humanitiesBooklist.add(humanitiesBook);
									
									ArrayList<HumanitiesBookAuthor> humanitiesBookAuthors=new ArrayList<HumanitiesBookAuthor>();
									
									if(memberName.size()!=0){
										for(int m = 0; m < memberName.size(); m++){
											HumanitiesBookAuthor humanitiesBookAuthor = new HumanitiesBookAuthor();
											humanitiesBookAuthor.setHumanitiesBook(humanitiesBook);
											humanitiesBookAuthor.setAuthorName(memberName.get(m));
											
											humanitiesBookAuthors.add(humanitiesBookAuthor);
										}
									 }else{
										HumanitiesBookAuthor humanitiesBookAuthor = new HumanitiesBookAuthor();
										humanitiesBookAuthor.setHumanitiesBook(humanitiesBook);
										humanitiesBookAuthor.setAuthorName(firstAuthor);
										humanitiesBookAuthors.add(humanitiesBookAuthor);
									}
									
									humanitiesBookMembers.add(humanitiesBookAuthors);
									
								}else{
									b1=true;
									humanitiesBookSheetlist.add(sheet);
								}
								
							}
							if(humanitiesBookSheetlist.size()!=0){
								 
							   	 writableSheet = writableworkbook.createSheet("人文类著作",1);
								 
							   	Label label = new Label(0,0,"(本校第一作者填写;如参与外校排名前3填写)人文社科著作统计表");	
							    WritableCellFormat cellFormat=new WritableCellFormat();
							     cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
							     label.setCellFormat(cellFormat);
								 writableSheet.addCell(label);
								 writableSheet.mergeCells(0,0,11,1);
								 
								 label = new Label(0,2,"第一作者");	
								 writableSheet.addCell(label);
								  
								 label = new Label(1,2,"其它作者");
								 writableSheet.addCell(label);
								  
								 label = new Label(2,2,"成果名称");
								 writableSheet.addCell(label);
								  
								 label = new Label(3,2,"等级(专著、编著、译著)");	
								 writableSheet.addCell(label);
								  
								 label = new Label(4,2,"出版单位");	
								 writableSheet.addCell(label);
								  
								 label = new Label(5,2,"出版日期");
								 writableSheet.addCell(label);
								  
								 label = new Label(6,2,"ISBN");	
								 writableSheet.addCell(label);
								  
								 label = new Label(7,2,"字数(千字)");	
								 writableSheet.addCell(label);
								  
								 label = new Label(8,2,"成果所属项目");	
								 writableSheet.addCell(label);
								  
								 label = new Label(9,2,"学科门类");	
								 writableSheet.addCell(label);
								  
								 label = new Label(10,2,"成果引用采纳情况");	
								 writableSheet.addCell(label);
								  
								  
								for(int m=0;m<humanitiesBookSheetlist.size();m++){
									
									Sheet sheets = humanitiesBookSheetlist.get(m);
									 
									label = new Label(0,m+3,sheets.getSheet0());	
									writableSheet.addCell(label);
									label = new Label(1,m+3,sheets.getSheet1());	
									writableSheet.addCell(label);
									label = new Label(3,m+3,sheets.getSheet3());	
									writableSheet.addCell(label);
									label = new Label(3,m+3,sheets.getSheet3());	
									writableSheet.addCell(label);
									label = new Label(4,m+3,sheets.getSheet4());	
									writableSheet.addCell(label);
									label = new Label(5,m+3,sheets.getSheet5());	
									writableSheet.addCell(label);
									label = new Label(6,m+3,sheets.getSheet6());	
									writableSheet.addCell(label);
									label = new Label(7,m+3,sheets.getSheet7());	
									writableSheet.addCell(label);
									label = new Label(8,m+3,sheets.getSheet8());	
									writableSheet.addCell(label);
									label = new Label(9,m+3,sheets.getSheet9());	
									writableSheet.addCell(label);
									label = new Label(10,m+3,sheets.getSheet10());	
									writableSheet.addCell(label);
									label = new Label(11,m+3,sheets.getSheet11());	
									writableSheet.addCell(label);
									
								}
						
							}
							
						 }else if("人文类科研项目".equals(name)){
							 b1 = true;
							 
							 
						    for (int j = 3; j < st.getRows()&&st.getCell(1,j).getContents()!=null&&st.getCell(1,j).getContents()!=""; j++) {
						    	
						    	Sheet sheet = new Sheet(); 
								String projectName="";
								String projectNumber="";
								String projectOrigin="";
								Date timeApproved=null;
								String projectStatus="";
								float money=0;
								String timePerPerson="";
								int status=0;
								String firstAuthor="";
								String allMember="";
								ArrayList<String> memberName=new ArrayList<String>();
								 
						    	if(st.getCell(0, j).getContents()!=""){
									
									firstAuthor = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
									sheet.setSheet0(firstAuthor);
							 	
								}else {
									
									firstAuthor="第一作者不能为空";
									sheet.setSheet0(firstAuthor);
									b1 =false;
								
								}
						    	
						    	if(st.getCell(1, j).getContents()!=""){
									
						    		projectName = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
									sheet.setSheet1(projectName);
							 	
								}else {
									
									projectName="项目名称不能为空";
									sheet.setSheet1(projectName);
									b1 =false;
								
								}

								if(st.getCell(2, j).getContents()!=""){
									boolean b=true;

									allMember = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
									allMember = firstAuthor +";"+ allMember;
									memberName = TypeConvert.getNames(allMember);
									if(memberName != null){
										for(int m = 0; m < memberName.size(); m++){
												
											if(memberName.get(m)==null||memberName.get(m).length()<=1){
														
													   b = false;
											}
										}
									}
									if(b == false){
										allMember = allMember + "(没有其他负责人名字或则在某个人的名字中间出项了空格)";
									}
									sheet.setSheet2(allMember);
								}else {
									sheet.setSheet2(allMember);
								}
								
								if(st.getCell(3, j).getContents()!=""){
									
									projectNumber = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
									sheet.setSheet3(projectNumber);
							 	
								}else {
									sheet.setSheet3(projectNumber);
								}
								
								if(st.getCell(4, j).getContents()!=""){
									
									projectOrigin = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
									sheet.setSheet4(projectOrigin);
							 	
								}else {
									sheet.setSheet4(projectOrigin);
								}
								
								if(st.getCell(5, j).getContents()!=""){
									
									if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(5,j).getContents()))!=null)
									{
										timeApproved = TypeConvert.StringtoDate(st.getCell(5,j).getContents());
									    sheet.setSheet5(timeApproved+"");
							
								    }else {
										sheet.setSheet5(st.getCell(5, j).getContents()+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）");
										b1=false;
								  }
							 	
								}else {
									sheet.setSheet5(timeApproved+"");
								}
								
								if(st.getCell(6, j).getContents()!=""){
									
									projectStatus = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
									sheet.setSheet6(projectStatus);
							 	
								}else {
									sheet.setSheet6(projectStatus);
								}
								
								if(st.getCell(7, j).getContents()!=""){
									
									if(TypeConvert.StringIsInt(st.getCell(7, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(7, j).getContents())){

										money = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(7,j).getContents()));
										sheet.setSheet7(money+"");
									
									}
								}else {
									sheet.setSheet7(money+"");
								}
								
								if(st.getCell(8, j).getContents()!=""){
									
									timePerPerson = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
									sheet.setSheet8(timePerPerson);
							 	
								}else {
									sheet.setSheet8(timePerPerson);
								}
								
								if(b1){
									user.setUserId(userId);
									String projectId= GenerateUtils.getID();
									HumanitiesProject humanitiesProject=new HumanitiesProject();
									humanitiesProject.setSubmitUser(user);
									humanitiesProject.setProjectId(projectId);
									humanitiesProject.setProjectName(projectName);
									humanitiesProject.setProjectNumber(projectNumber);
									humanitiesProject.setProjectOrigin(projectOrigin);
									humanitiesProject.setStatus(status);
									humanitiesProjectlist.add(humanitiesProject);
									
									HumanitiesProjectDetail humanitiesProjectDetail=new HumanitiesProjectDetail();
									humanitiesProjectDetail.setHumanitiesProject(humanitiesProject);
									humanitiesProjectDetail.setMoney(money);
									humanitiesProjectDetail.setProjectStatus(projectStatus);
									humanitiesProjectDetail.setTimePerPerson(timePerPerson);
									humanitiesProjectDetaillist.add(humanitiesProjectDetail);
									
									ArrayList<HumanitiesProjectMember> humanitiesProjectMemberlist=new ArrayList<HumanitiesProjectMember>();
									if(memberName.size()!=0){
										for(int m = 0; m < memberName.size(); m++){
											HumanitiesProjectMember  humanitiesProjectMember = new HumanitiesProjectMember();
											humanitiesProjectMember.setHumanitiesProject(humanitiesProject);
											humanitiesProjectMember.setMemberName(memberName.get(m));
											
											humanitiesProjectMemberlist.add(humanitiesProjectMember);
										}
									 }else{
										HumanitiesProjectMember  humanitiesProjectMember = new HumanitiesProjectMember();
										humanitiesProjectMember.setHumanitiesProject(humanitiesProject);
										humanitiesProjectMember.setMemberName(firstAuthor);
										humanitiesProjectMemberlist.add(humanitiesProjectMember);
										   
									}
										humanitiesProjectMembers.add(humanitiesProjectMemberlist);
								}else{
									b1=true;
									humanitiesProjectSheetlist.add(sheet);
								}
								
							}
						    
						    if(humanitiesProjectSheetlist.size()!=0){
								 
							   	 writableSheet = writableworkbook.createSheet("人文类科研项目",2);
							   	 
							   	Label label = new Label(0,0,"(2008年在研和结题)人文社科科研项目统计表");	
							    WritableCellFormat cellFormat=new WritableCellFormat();
							     cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
							     label.setCellFormat(cellFormat);
								 writableSheet.addCell(label);
								 writableSheet.mergeCells(0,0,9,1);
								 
							      label = new Label(0,2,"项目负责人");	
								  writableSheet.addCell(label);
								  
								  label = new Label(1,2,"项目名称");	
								  writableSheet.addCell(label);
								  
								  label = new Label(2,2,"参与人员");	
								  writableSheet.addCell(label);
								  
								  label = new Label(3,2,"项目编号");	
								  writableSheet.addCell(label);
								  
								  label = new Label(4,2,"项目来源");	
								  writableSheet.addCell(label);
								  
								  label = new Label(5,2,"批准时间");	
								  writableSheet.addCell(label);
								  
								  label = new Label(6,2,"目前状态(在研/完成)");
								  writableSheet.addCell(label);
								  
								  label = new Label(7,2,"当年投入经费（万元）"	);
								  writableSheet.addCell(label);
								  
								  label = new Label(8,2,"每人当年投入研究时间（月/研究人员姓名）");	
								  writableSheet.addCell(label);
								  
								
								 for(int m=0;m<humanitiesProjectSheetlist.size();m++){
									
									 Sheet sheets = humanitiesProjectSheetlist.get(m);
									 
									  label = new Label(0,m+3,sheets.getSheet0());	
									  writableSheet.addCell(label);
									  label = new Label(1,m+3,sheets.getSheet1());	
									  writableSheet.addCell(label);
									  label = new Label(2,m+3,sheets.getSheet2());	
									  writableSheet.addCell(label);
									  label = new Label(3,m+3,sheets.getSheet3());	
									  writableSheet.addCell(label);
									  label = new Label(4,m+3,sheets.getSheet4());	
									  writableSheet.addCell(label);
									  label = new Label(5,m+3,sheets.getSheet5());	
									  writableSheet.addCell(label);
									  label = new Label(6,m+3,sheets.getSheet6());	
									  writableSheet.addCell(label);
									  label = new Label(7,m+3,sheets.getSheet7());	
									  writableSheet.addCell(label);
									  label = new Label(8,m+3,sheets.getSheet8());	
									  writableSheet.addCell(label);
								}
						
							}
						    
						 }else if("人文类交流论文".equals(name)){
							b1 = true;
						    
							
							ArrayList<String> memberName=new ArrayList<String>();
						    for (int j = 3; j < st.getRows()&&st.getCell(0,j).getContents()!=null&&st.getCell(0,j).getContents()!=""; j++) {
						    	Sheet sheet = new Sheet();
						    	
						    	String exchangePaperName="";
								String searchStation="";
								String subjectsClassify="";
								Date publishedTime=null;
								String hostConferenceName="";

								int status=0;
								String firstAuthor="";
								String allMember="";
								
						    	if(st.getCell(0, j).getContents()!=""){
									
						    		exchangePaperName = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
									sheet.setSheet0(exchangePaperName);
							 	
								}else {
									exchangePaperName="请输入论文名称";
									sheet.setSheet0(exchangePaperName);
									b1 =false;
								
								}
						    	
						    	
						    	if(st.getCell(1, j).getContents()!=""){
									firstAuthor = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
									sheet.setSheet1(firstAuthor);
								}else {
									firstAuthor="第一作者不能为空";
									sheet.setSheet1(firstAuthor);
									b1 =false;
								}

						    	if(st.getCell(2, j).getContents()!=""){
									boolean b=true;
									allMember = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
								    memberName = TypeConvert.getNames(allMember);
									if(memberName != null){
										for(int m = 0; m < memberName.size(); m++){
											
											if(memberName.get(m)==null||memberName.get(m).length()<=1){
													
												    b = false;
											}
										}
									}
									if(b == false){
										allMember = allMember + "(没有输入负责人名字或则在某个人的名字中间出项了空格)";
									}
									sheet.setSheet2(allMember);
							
								}else {
									sheet.setSheet2(allMember);
								}
						    	
						    	
						    	if(st.getCell(3, j).getContents()!=""){
									
						    		searchStation = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
									sheet.setSheet3(searchStation);
							 	
								}else {
									sheet.setSheet3(searchStation);
								}
						    	
						    	
						    	if(st.getCell(4, j).getContents()!=""){
									
						    		subjectsClassify = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
									sheet.setSheet4(subjectsClassify);
							 	
								}else {
									sheet.setSheet4(subjectsClassify);
								}
								
						    	
						    	if(st.getCell(5, j).getContents()!=""){
									
						    		if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(5,j).getContents()))!=null)
									{
						    			publishedTime = TypeConvert.StringtoDate(st.getCell(5,j).getContents());
									    sheet.setSheet5(publishedTime+"");
							
								    }else {
										sheet.setSheet5(st.getCell(5, j).getContents()+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）");
										b1=false;
								  }
							 	
								}else {
									sheet.setSheet5(publishedTime+"");
								}
						    	
						    	
						    	if(st.getCell(6, j).getContents()!=""){
									
						    		hostConferenceName = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
									sheet.setSheet6(hostConferenceName);
							 	
								}else {
									sheet.setSheet6(hostConferenceName);
								}
						    	
						    	if(b1){
									user.setUserId(userId);
									String exchangePaperId = GenerateUtils.getID();
									
									HumanitiesExchangePaper humanitiesExchangePaper=new HumanitiesExchangePaper();
									humanitiesExchangePaper.setStatus(status);
									humanitiesExchangePaper.setSubmitUser(user);
									humanitiesExchangePaper.setExchangePaperId(exchangePaperId);
									humanitiesExchangePaper.setExchangePaperName(exchangePaperName);
									humanitiesExchangePaper.setHostConferenceName(hostConferenceName);
									humanitiesExchangePaper.setPublishedTime(publishedTime);
									humanitiesExchangePaper.setSearchStation(searchStation);
									humanitiesExchangePaper.setSubjectsClassify(subjectsClassify);
									humanitiesExchangePaperlist.add(humanitiesExchangePaper);
									
									ArrayList<HumanitiesExchangePaperAuthor> humanitiesExchangePaperAuthors=new ArrayList<HumanitiesExchangePaperAuthor>();
									if(memberName.size()!=0){
										for(int m = 0; m < memberName.size(); m++){
											HumanitiesExchangePaperAuthor humanitiesExchangePaperAuthor = new HumanitiesExchangePaperAuthor();
											humanitiesExchangePaperAuthor.setHumanitiesExchangePaper(humanitiesExchangePaper);
											humanitiesExchangePaperAuthor.setAuthorName(memberName.get(m));
											
											humanitiesExchangePaperAuthors.add(humanitiesExchangePaperAuthor);
										}
									 }else{
										HumanitiesExchangePaperAuthor humanitiesExchangePaperAuthor = new HumanitiesExchangePaperAuthor();
										humanitiesExchangePaperAuthor.setHumanitiesExchangePaper(humanitiesExchangePaper);
										humanitiesExchangePaperAuthor.setAuthorName(firstAuthor);
										humanitiesExchangePaperAuthors.add(humanitiesExchangePaperAuthor);
										   
									}
									
									humanitiesExchangePaperMembers.add(humanitiesExchangePaperAuthors);
									
							    }else{
									b1=true;
									humanitiesExchangePaperSheetlist.add(sheet);
								}
						    	
							}
						    
						    if(humanitiesExchangePaperSheetlist.size()!=0){
								 
							   	 writableSheet = writableworkbook.createSheet("人文类交流论文",3);
							   	 
							   	Label label = new Label(0,0,"会议交流论文");	
							    WritableCellFormat cellFormat=new WritableCellFormat();
							     cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
							     label.setCellFormat(cellFormat);
								 writableSheet.addCell(label);
								 writableSheet.mergeCells(0,0,7,1);
								 
							      label = new Label(0,2,"论文名称");	
								  writableSheet.addCell(label);
								  
								  label = new Label(1,2,"第一作者");	
								  writableSheet.addCell(label);
								  
								  label = new Label(2,2,"其它作者");	
								  writableSheet.addCell(label);
								  
								  label = new Label(3,2,"检索情况");	
								  writableSheet.addCell(label);
								  
								  label = new Label(4,2,"学科门类");	
								  writableSheet.addCell(label);
								  
								  label = new Label(5,2,"发表时间");
								  writableSheet.addCell(label);
								  
								  label = new Label(6,2,"主办会议名称"	);
								  writableSheet.addCell(label);
								  
								
								 for(int m=0;m<humanitiesExchangePaperSheetlist.size();m++){
									
									 Sheet sheets = humanitiesExchangePaperSheetlist.get(m);
									 
									  label = new Label(0,m+3,sheets.getSheet0());	
									  writableSheet.addCell(label);
									  label = new Label(1,m+3,sheets.getSheet1());	
									  writableSheet.addCell(label);
									  label = new Label(2,m+3,sheets.getSheet2());	
									  writableSheet.addCell(label);
									  label = new Label(3,m+3,sheets.getSheet3());	
									  writableSheet.addCell(label);
									  label = new Label(4,m+3,sheets.getSheet4());	
									  writableSheet.addCell(label);
									  label = new Label(5,m+3,sheets.getSheet5());	
									  writableSheet.addCell(label);
									  label = new Label(6,m+3,sheets.getSheet6());	
									  writableSheet.addCell(label);
								}
						
							}
						    
						 }else if("人文类科研获奖".equals(name)){
							b1 = true;
						    
							
						    for (int j = 3; j < st.getRows()&&st.getCell(0,j).getContents()!=null&&st.getCell(0,j).getContents()!=""; j++) {
						    	Sheet sheet = new Sheet();
						    	String researchRewardName="";
								String rewardClassify="";
								String rewardGrades="";
								String issueUnit="";
								Date approveTime=null;
								String approveNumber="";
								
								int status=0;
								String firstAuthor="";
								String allMember="";
								ArrayList<String> memberName=new ArrayList<String>();
						    	 
						    	if(st.getCell(0, j).getContents()!=""){
						    		researchRewardName = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
									sheet.setSheet0(researchRewardName);
								}else {
									researchRewardName="请输入获奖成果名称";
									sheet.setSheet0(researchRewardName);
									b1 =false;
								}
						    	
						    	if(st.getCell(1, j).getContents()!=""){
									firstAuthor = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
									sheet.setSheet1(firstAuthor);
								}else {
									firstAuthor="第一获奖人不能为空";
									sheet.setSheet1(firstAuthor);
									b1 =false;
								}

						    	if(st.getCell(2, j).getContents()!=""){
									boolean b=true;
									allMember = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
								    memberName = TypeConvert.getNames(allMember);
									if(memberName != null){
										for(int m = 0; m < memberName.size(); m++){
											
											if(memberName.get(m)==null||memberName.get(m).length()<=1){
													
												    b = false;
											}
										}
									}
									if(b == false){
										allMember = allMember + "(没有输入其他人名字或则在某个人的名字中间出项了空格)";
									}
									sheet.setSheet2(allMember);
							
								}else {
									sheet.setSheet2(allMember);
								}
						    	
						    	if(st.getCell(3, j).getContents()!=""){
						    		rewardClassify = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
									sheet.setSheet3(rewardClassify);
								}else {
									sheet.setSheet3(rewardClassify);
								}
						    	
						    	if(st.getCell(4, j).getContents()!=""){
						    		rewardGrades = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
									sheet.setSheet4(rewardGrades);
								}else {
									sheet.setSheet4(rewardGrades);
								}
						    	
						    	if(st.getCell(5, j).getContents()!=""){
						    		issueUnit = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
									sheet.setSheet5(issueUnit);
								}else {
									sheet.setSheet5(issueUnit);
								}
						    	
						    	
						    	if(st.getCell(6, j).getContents()!=""){
									
						    		if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(6,j).getContents()))!=null)
									{
						    			approveTime = TypeConvert.StringtoDate(st.getCell(6,j).getContents());
									    sheet.setSheet6(approveTime+"");
							
								    }else {
										sheet.setSheet6(st.getCell(6, j).getContents()+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）");
										b1=false;
								  }
							 	
								}
						    	
						    	if(st.getCell(7, j).getContents()!=""){
						    		approveNumber = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
									sheet.setSheet7(approveNumber);
								}else {
									sheet.setSheet7(approveNumber);
								}
						    	
						    	if(b1){
									user.setUserId(userId);
									String researchRewardId = GenerateUtils.getID();
									HumanitiesResearchReward humanitiesResearchReward=new HumanitiesResearchReward();
									humanitiesResearchReward.setSubmitUser(user);
									humanitiesResearchReward.setStatus(status);
									humanitiesResearchReward.setApproveNumber(approveNumber);
									humanitiesResearchReward.setApproveTime(approveTime);
									humanitiesResearchReward.setIssueUnit(issueUnit);
									humanitiesResearchReward.setResearchRewardId(researchRewardId);
									humanitiesResearchReward.setResearchRewardName(researchRewardName);
									humanitiesResearchReward.setRewardClassify(rewardClassify);
									humanitiesResearchReward.setRewardGrades(rewardGrades);
									
									humanitiesResearchRewardlist.add(humanitiesResearchReward);
									
									ArrayList<HumanitiesResearchRewardPerson> humanitiesResearchRewardPersons=new ArrayList<HumanitiesResearchRewardPerson>();
									if(memberName.size()!=0){
										for(int m = 0; m < memberName.size(); m++){
											HumanitiesResearchRewardPerson humanitiesResearchRewardPerson = new HumanitiesResearchRewardPerson();
											humanitiesResearchRewardPerson.setHumanitiesResearchReward(humanitiesResearchReward);
											humanitiesResearchRewardPerson.setRewardPersonName(memberName.get(m));
											
											humanitiesResearchRewardPersons.add(humanitiesResearchRewardPerson);
										}
									 }else{
										HumanitiesResearchRewardPerson humanitiesResearchRewardPerson = new HumanitiesResearchRewardPerson();
										humanitiesResearchRewardPerson.setHumanitiesResearchReward(humanitiesResearchReward);
										humanitiesResearchRewardPerson.setRewardPersonName(firstAuthor);
										humanitiesResearchRewardPersons.add(humanitiesResearchRewardPerson);
										   
									}
									
									HumanitiesResearchRewardMembers.add(humanitiesResearchRewardPersons);
						    	}else{
						    		b1=true;
						    		humanitiesResearchRewardSheetlist.add(sheet);
						    	}
						    	
							}	
						    
						    
						    if(humanitiesResearchRewardSheetlist.size()!=0){
								 
							   	 writableSheet = writableworkbook.createSheet("人文类科研获奖",4);
							   	 
							   	WritableCellFormat cellFormat=new WritableCellFormat();
							   	
							    Label label = new Label(0,0,"成果获奖统计");	
							    
							     cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
							     label.setCellFormat(cellFormat);
								 writableSheet.addCell(label);
								 writableSheet.mergeCells(0,0,7,1);
							    
								 label = new Label(0,2,"获奖成果名称");	
								  writableSheet.addCell(label);
								  
								  label = new Label(1,2,"第一获奖人");	
								  writableSheet.addCell(label);
								  
								  label = new Label(2,2,"其它获奖人（按排名顺序）");	
								  writableSheet.addCell(label);
								  
								  label = new Label(3,2,"获奖类别");	
								  writableSheet.addCell(label);
								  
								  label = new Label(4,2,"获奖等级");	
								  writableSheet.addCell(label);
								  
								  label = new Label(5,2,"颁发单位");
								  writableSheet.addCell(label);
								  
								  label = new Label(6,2,"获奖批准时间"	);
								  writableSheet.addCell(label);
								  
								  label = new Label(7,2,"获奖批准号"	);
								  writableSheet.addCell(label);
								  
								
								 for(int m=0;m<humanitiesResearchRewardSheetlist.size();m++){
									
									 Sheet sheets = humanitiesResearchRewardSheetlist.get(m);
									 
									  label = new Label(0,m+3,sheets.getSheet0());	
									  writableSheet.addCell(label);
									  label = new Label(1,m+3,sheets.getSheet1());	
									  writableSheet.addCell(label);
									  label = new Label(2,m+3,sheets.getSheet2());	
									  writableSheet.addCell(label);
									  label = new Label(3,m+3,sheets.getSheet3());	
									  writableSheet.addCell(label);
									  label = new Label(4,m+3,sheets.getSheet4());	
									  writableSheet.addCell(label);
									  label = new Label(5,m+3,sheets.getSheet5());	
									  writableSheet.addCell(label);
									  label = new Label(6,m+3,sheets.getSheet6());	
									  writableSheet.addCell(label);
									  label = new Label(7,m+3,sheets.getSheet7());	
									  writableSheet.addCell(label);
								}
						
							}
						    
						 }else if("人文类学术会议".equals(name)){
							b1 = true;
						    
						    for (int j = 1; j < st.getRows()&&st.getCell(0,j).getContents()!=null&&st.getCell(0,j).getContents()!=""; j++) {
						    	Sheet sheet = new Sheet();
						    	String academicMeetingName="";
								String hostUnit="";
								String meetingClassify="";
								Date holdingTime=null;
								String meetingLocation="";
								String participantsNumber="";


								int status=0;
								String allMember="";
								ArrayList<String> memberName=new ArrayList<String>();
								
						    	 
						    	if(st.getCell(0, j).getContents()!=""){
						    		academicMeetingName = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
									sheet.setSheet0(academicMeetingName);
								}else {
									academicMeetingName="请输入会议名称";
									sheet.setSheet0(academicMeetingName);
									b1 =false;
								}
						    	
						    	if(st.getCell(1, j).getContents()!=""){
						    		hostUnit = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
									sheet.setSheet1(hostUnit);
								}else {
									sheet.setSheet1(hostUnit);
								}
						    	
						    	if(st.getCell(2, j).getContents()!=""){
						    		meetingClassify = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
									sheet.setSheet2(meetingClassify);
								}else {
									sheet.setSheet2(meetingClassify);
								}
						    	
						    	if(st.getCell(3, j).getContents()!=""){
									
						    		if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(3,j).getContents()))!=null)
									{
						    			holdingTime = TypeConvert.StringtoDate(st.getCell(3,j).getContents());
									    sheet.setSheet3(holdingTime+"");
							
								    }else {
										sheet.setSheet3(st.getCell(3, j).getContents()+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）");
										b1=false;
								  }
							 	
								}
						    	
						    	if(st.getCell(4, j).getContents()!=""){
						    		meetingLocation = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
									sheet.setSheet4(meetingLocation);
								}else {
									sheet.setSheet4(meetingLocation);
								}
						    	
						    	if(st.getCell(5, j).getContents()!=""){
						    		participantsNumber = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
									sheet.setSheet5(participantsNumber);
								}else {
									sheet.setSheet5(participantsNumber);
								}
						    	
						    	if(st.getCell(6, j).getContents()!=""){
									boolean b=true;
									allMember = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
									memberName = TypeConvert.getNames(allMember);
									if(memberName != null){
										for(int m = 0; m < memberName.size(); m++){
												
											if(memberName.get(m)==null||memberName.get(m).length()<=1){
														
													   b1 = false;
											}
										}
									}
									if(b == false){
										allMember = allMember + "(没有输入其他人名字或则在某个人的名字中间出项了空格)";
									}
									sheet.setSheet6(allMember);
							
								}else {
									sheet.setSheet6(allMember);
								}
						    	
						    	if(b1){
									user.setUserId(userId);
									String academicMeetingId = GenerateUtils.getID();
									HumanitiesAcademicMeeting humanitiesAcademicMeeting=new HumanitiesAcademicMeeting();
									humanitiesAcademicMeeting.setAcademicMeetingName(academicMeetingName);
									humanitiesAcademicMeeting.setSubmitUser(user);
									humanitiesAcademicMeeting.setHoldingTime(holdingTime);
									humanitiesAcademicMeeting.setHostUnit(hostUnit);
									humanitiesAcademicMeeting.setMeetingLocation(meetingLocation);
									humanitiesAcademicMeeting.setMeetingClassify(meetingClassify);
									humanitiesAcademicMeeting.setStatus(status);
									humanitiesAcademicMeeting.setAcademicMeetingId(academicMeetingId);
									humanitiesAcademicMeeting.setParticipantsNumber(participantsNumber);
									
									humanitiesAcademicMeetinglist.add(humanitiesAcademicMeeting);
									
									ArrayList<HumanitiesAcademicMeetingPerson> humanitiesResearchRewardPersons=new ArrayList<HumanitiesAcademicMeetingPerson>();
									if(memberName.size()!=0){
										for(int m = 0; m < memberName.size(); m++){
											HumanitiesAcademicMeetingPerson humanitiesAcademicMeetingPerson = new HumanitiesAcademicMeetingPerson();
											humanitiesAcademicMeetingPerson.setHumanitiesAcademicMeeting(humanitiesAcademicMeeting);
											humanitiesAcademicMeetingPerson.setMeetingPersonName(memberName.get(m));
											
											humanitiesResearchRewardPersons.add(humanitiesAcademicMeetingPerson);
										}
									 }
									
									HumanitiesAcademicMeetingMembers.add(humanitiesResearchRewardPersons);
									
						    	}else{
						    		b1=true;
						    		humanitiesAcademicMeetingSheetlist.add(sheet);
						    	}
							}
						    
						    if(humanitiesAcademicMeetingSheetlist.size()!=0){
								 
							   	 writableSheet = writableworkbook.createSheet("人文类学术会议",5);
							   	 
							      Label label = new Label(0,0,"会议名称");	
								  writableSheet.addCell(label);
								  
								  label = new Label(1,0,"主办单位");	
								  writableSheet.addCell(label);
								  
								  label = new Label(2,0,"会议类型");	
								  writableSheet.addCell(label);
								  
								  label = new Label(3,0,"举办时间");	
								  writableSheet.addCell(label);
								  
								  label = new Label(4,0,"会议地点");	
								  writableSheet.addCell(label);
								  
								  label = new Label(5,0,"参加人数");
								  writableSheet.addCell(label);
								  
								  label = new Label(6,0,"参会人员名单"	);
								  writableSheet.addCell(label);
								  
								
								 for(int m=0;m<humanitiesAcademicMeetingSheetlist.size();m++){
									
									 Sheet sheets = humanitiesAcademicMeetingSheetlist.get(m);
									 
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
						    
						 }else{
							 
							 return "ERR";
						 }
					}
					//for end ...
					
					if(humanitiesPaperlist!=null){
						
						
						for(int i=0;i<humanitiesPaperlist.size();i++){
							@SuppressWarnings("unchecked")
							ArrayList<HumanitiesPaperAuthor> humanitiesPaperAuthors = humanitiesPaperMembers.get(i);
							HumanitiesPaper humanitiesPaper = humanitiesPaperlist.get(i);
							boolean result1 = submitInfoAndProofsService.submitInfo(humanitiesPaper);
							boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(7, humanitiesPaperAuthors);
						    if(!(result1&&result2)){
						    	
						    	return "ERR";
						    }
						}
						
					}
					
					if(humanitiesAcademicMeetinglist!=null){
						
						
						for(int i=0;i<humanitiesAcademicMeetinglist.size();i++){
							@SuppressWarnings("unchecked")
							ArrayList<HumanitiesAcademicMeetingPerson> humanitiesAcademicMeetingPersons = HumanitiesAcademicMeetingMembers.get(i);
							HumanitiesAcademicMeeting humanitiesAcademicMeeting = humanitiesAcademicMeetinglist.get(i);
							boolean result1 = submitInfoAndProofsService.submitInfo(humanitiesAcademicMeeting);
							boolean result3 = submitInfoAndProofsService.submitResearchMemberInfo(12, humanitiesAcademicMeetingPersons);
						    if(!(result1&&result3)){
						    	
						    	return "ERR";
						    }
						}
						
					}	
					
					if(humanitiesResearchRewardlist!=null){
						
						
						for(int i=0;i<humanitiesResearchRewardlist.size();i++){
							@SuppressWarnings("unchecked")
							ArrayList<HumanitiesResearchRewardPerson> humanitiesResearchRewardPersons = HumanitiesResearchRewardMembers.get(i);
							HumanitiesResearchReward humanitiesResearchReward = humanitiesResearchRewardlist.get(i);
							boolean result1 = submitInfoAndProofsService.submitInfo(humanitiesResearchReward);
							boolean result3 = submitInfoAndProofsService.submitResearchMemberInfo(11, humanitiesResearchRewardPersons);
						    if(!(result1&&result3)){
						    	
						    	return "ERR";
						    }
						}
						
					}	
					
						
					
					if(humanitiesBooklist!=null){
						
						for(int i=0;i<humanitiesBooklist.size();i++){
							@SuppressWarnings("unchecked")
							ArrayList<HumanitiesBookAuthor> humanitiesBookAuthors = humanitiesBookMembers.get(i);
							HumanitiesBook humanitiesBook = humanitiesBooklist.get(i);
							boolean result1 = submitInfoAndProofsService.submitInfo(humanitiesBook);
							boolean result3 = submitInfoAndProofsService.submitResearchMemberInfo(8, humanitiesBookAuthors);
						    if(!(result1&&result3)){
						    	
						    	return "ERR";
						    }
						}
						
					}	
					
					if(humanitiesProjectlist!=null){
						

						for(int i=0;i<humanitiesProjectlist.size();i++){
							@SuppressWarnings("unchecked")
							ArrayList<HumanitiesProjectMember> humanitiesProjectMember = humanitiesProjectMembers.get(i);
							HumanitiesProject humanitiesProject = humanitiesProjectlist.get(i);
							HumanitiesProjectDetail humanitiesProjectDetail = humanitiesProjectDetaillist.get(i);
							boolean result1 = submitInfoAndProofsService.submitInfo(humanitiesProject);
							boolean result2 = submitInfoAndProofsService.submitInfo(humanitiesProjectDetail);
							boolean result3 = submitInfoAndProofsService.submitResearchMemberInfo(9, humanitiesProjectMember);
						    if(!(result1&&result3&&result2)){
						    	
						    	return "ERR";
						    }
						}
						
					}	
					
					if(humanitiesExchangePaperlist!=null){
						

						for(int i=0;i<humanitiesExchangePaperlist.size();i++){
							@SuppressWarnings("unchecked")
							ArrayList<HumanitiesExchangePaperAuthor> humanitiesExchangePaperAuthors = humanitiesExchangePaperMembers.get(i);
							HumanitiesExchangePaper humanitiesExchangePaper = humanitiesExchangePaperlist.get(i);
							boolean result1 = submitInfoAndProofsService.submitInfo(humanitiesExchangePaper);
							boolean result3 = submitInfoAndProofsService.submitResearchMemberInfo(10, humanitiesExchangePaperAuthors);
						    if(!(result1&&result3)){
						    	
						    	return "ERR";
						    }
						}
						
					}	
					
					wb.close();// 关闭工作薄
					
					boolean b=writableworkbook==null&&humanitiesPaperlist==null
					&&humanitiesAcademicMeetinglist==null
					&&humanitiesResearchRewardlist==null&&humanitiesBooklist==null
					&&humanitiesProjectlist==null;
					if(b){
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
						
						return excelName;
					}
					
				}catch (Exception e) {
					e.printStackTrace();
					return "ERR";
				}
			}
			return "ALLSUC";
	}

}
