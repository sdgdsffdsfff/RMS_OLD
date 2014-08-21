package com.cqupt.mis.rms.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.ScienceBook;
import com.cqupt.mis.rms.model.ScienceBookAuthor;
import com.cqupt.mis.rms.model.ScienceDetailTechProject;
import com.cqupt.mis.rms.model.ScienceGovAwardPerson;
import com.cqupt.mis.rms.model.ScienceGovernmentAward;
import com.cqupt.mis.rms.model.ScienceInventors;
import com.cqupt.mis.rms.model.ScienceIpRights;
import com.cqupt.mis.rms.model.ScienceOrganization;
import com.cqupt.mis.rms.model.SciencePaper;
import com.cqupt.mis.rms.model.SciencePaperAuthor;
import com.cqupt.mis.rms.model.ScienceTechAttendPerson;
import com.cqupt.mis.rms.model.ScienceTechExchange;
import com.cqupt.mis.rms.model.ScienceTechProject;
import com.cqupt.mis.rms.model.ScienceTechProjectMember;
import com.cqupt.mis.rms.model.ScienceTechTransfer;
import com.cqupt.mis.rms.model.ScienceTransferLeader;
import com.cqupt.mis.rms.model.Sheet;
import com.cqupt.mis.rms.service.ExcelToDBService;
import com.cqupt.mis.rms.service.SubmitInfoAndProofsService;
import com.cqupt.mis.rms.utils.DoString;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.cqupt.mis.rms.utils.TypeConvert;
/**
*<p>Title:实现管理用户信息Service</p>
*<p>Description:从excel导入理工类信息到数据库</p>
*@author HuangHaiyan
*@version 1.0
**/
public class ExcelToDBTecServiceImpl implements ExcelToDBService{
	
	private SubmitInfoAndProofsService submitInfoAndProofsService;
	
	public SubmitInfoAndProofsService getSubmitInfoAndProofsService() {
		return submitInfoAndProofsService;
	}
	public void setSubmitInfoAndProofsService(
			SubmitInfoAndProofsService submitInfoAndProofsService) {
		this.submitInfoAndProofsService = submitInfoAndProofsService;
	}
	/**
	 * 从EXCEL表格里面导入理工类科研信息进入数据库
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
		 ArrayList<Sheet> scienceOrganizationSheet = new ArrayList<Sheet>();
		 ArrayList<ScienceOrganization> ScienceOrganizationlists = new ArrayList<ScienceOrganization>();
		 
		 ArrayList<Sheet> scienceTechProjectSheet = new ArrayList<Sheet>();
		 ArrayList<ScienceTechProject> ScienceTechProjectlists = new ArrayList<ScienceTechProject>();
		 ArrayList<ScienceDetailTechProject> ScienceDetailTechProjectlists = new ArrayList<ScienceDetailTechProject>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> ScienceTechProjectMemberlists = new ArrayList<ArrayList>();
		 
		 ArrayList<Sheet> scienceBookSheet = new ArrayList<Sheet>();
		 List<ScienceBook> scienceBooklist = new ArrayList<ScienceBook>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> scienceBookAuthorlist = new ArrayList<ArrayList>();
		 
		 List<SciencePaper> sciencePaperlist = new ArrayList<SciencePaper>();
		 @SuppressWarnings("rawtypes")
	   	 ArrayList<ArrayList> sciencePaperAuthorlist = new ArrayList<ArrayList>();
		 ArrayList<Sheet> sciencePaperSheet = new ArrayList<Sheet>();
		 
		 ArrayList<ScienceGovernmentAward> scienceGovernmentAwardlist = new ArrayList<ScienceGovernmentAward>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> ScienceGovAwardPersonslist = new ArrayList<ArrayList>();
		 ArrayList<Sheet> ScienceGovAwardPersonsSheet = new ArrayList<Sheet>();
		 
		 ArrayList<ScienceIpRights> scienceIpRightslist = new ArrayList<ScienceIpRights>();
		 ArrayList<Sheet> ScienceIpRightsSheet = new ArrayList<Sheet>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> scienceInventorslist = new ArrayList<ArrayList>();

		 ArrayList<ScienceTechTransfer> scienceTechTransferlist = new ArrayList<ScienceTechTransfer>();
		 ArrayList<Sheet> scienceTechTransferSheet = new ArrayList<Sheet>();
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> scienceTransferLeaderslist = new ArrayList<ArrayList>();
		 
		 @SuppressWarnings("rawtypes")
		 ArrayList<ArrayList> scienceTechAttendPersonslist = new ArrayList<ArrayList>();
		 ArrayList<ScienceTechExchange> scienceTechExchangelist = new ArrayList<ScienceTechExchange>();
		 ArrayList<Sheet> scienceTechExchangeSheet = new ArrayList<Sheet>();
		 
		 boolean b1 = true;
		 
		if (excelfile != null || !"".equals(excelfile)) {
			try {
				
				jxl.Workbook wb = Workbook.getWorkbook(excelfile);// 获取工作薄
				
				for(int i=0;i<wb.getNumberOfSheets();i++){
					
					 jxl.Sheet st = wb.getSheet(i);// 得到工作薄
					 
					 String name =st.getName();
					 
					
					 
				  if("理工类科研机构表".equals(name)){
						 
					 
					 
					 
					 for (int j = 4; j < st.getRows()&&st.getCell(1,j).getContents()!=null&&st.getCell(1,j).getContents()!="";j++) { 
						// 行数从第4行开始，去掉标题行，st.getRows()返回总行数
						 Sheet sheet = new Sheet();	 
						 String organizationId = "";
						 String organizationName = "";
						 String organizationType = "";
						 String organizationCategory = "";
						 String sortSubject = "";
						 String modusComposition = "";
						 int totalEmployees = 0;
						 String totalEmployeesWrong;
						 int doctorEmployees = 0;
						 String doctorEmployeesWrong;
						 int masterEmployees = 0;
						 String masterEmployeesWrong;
						 int totalIts = 0;
						 String totalItsWrong;
						 int advancedIts = 0;
						 String advancedItsWrong;
						 int middleIts = 0;
						 String middleItsWrong;
						 int juniorIts = 0;
						 String juniorItsWrong;
						 int otherIts = 0;
						 String otherItsWrong;
						 int numGraduates = 0;
						 String numGraduatesWrong;
						 float internalExpenditures = 0;
						 String internalExpendituresWrong;
						 float rdExpenditures = 0;
						 String rdExpendituresWrong;
						 int numIssueAssume = 0;
						 String numIssueAssumeWrong;
						 float assetsFixed = 0;
						 String assetsFixedWrong;
						 float assetsEquipment = 0;
						 String assetsEquipmentWrong;
						 float assetsImport = 0;
						 String assetsImportWrong;
						 String industryService = "";
	                     String submitUserId;

						 int status = 0;
						 
						if(st.getCell(1, j).getContents()!=""){
						
							organizationName = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(organizationName);
					 	}else {
							
							organizationName="请输入机构名称";
							sheet.setSheet1(organizationName);
							b1 =false;
						
						}
						
						if(st.getCell(2, j).getContents()!=""){
						
							organizationType = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(organizationType);
						}else {
							
							sheet.setSheet2(organizationType);
						
						}
						
						if(st.getCell(3, j).getContents()!=""){
							
						    organizationCategory = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
						    sheet.setSheet3(organizationCategory);
						}else {
							
							sheet.setSheet3(organizationCategory);
						
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							sortSubject = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(sortSubject);
						}else {
							
							sheet.setSheet4(sortSubject);
						
						}
						
						if(st.getCell(5, j).getContents()!=""){
						
							modusComposition = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(modusComposition);
						}else {
							
							sheet.setSheet5(modusComposition);
						
						}
						
						if(st.getCell(6, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(6, j).getContents())){
								
								totalEmployees = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(6,j).getContents()));
								sheet.setSheet6(totalEmployees+"");
							}else{
								
								totalEmployeesWrong = totalEmployees+"（请输入相应的整形数值）"+"";
								sheet.setSheet6(totalEmployeesWrong);
								b1 = false;
							}
						}
						
						if(st.getCell(7, j).getContents()!=""){
						
							if(TypeConvert.StringIsInt(st.getCell(7, j).getContents())){
						
								doctorEmployees = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(7,j).getContents()));
								sheet.setSheet7(doctorEmployees+"");
							}else {
								
								doctorEmployeesWrong = doctorEmployees+"（请输入相应的整形数值）"+"";
								sheet.setSheet7(doctorEmployeesWrong);
								b1 = false;
							}
						}
						
						if(st.getCell(8, j).getContents()!=""){
					
							if(TypeConvert.StringIsInt(st.getCell(8, j).getContents())){
								
								masterEmployees = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(8,j).getContents()));
								sheet.setSheet8(masterEmployees+"");
							}else {
								
								masterEmployeesWrong = masterEmployees+"（请输入相应的整形数值）"+"";
								sheet.setSheet8(masterEmployeesWrong);
								b1 = false;
							}
						
						}
						
						if(st.getCell(9, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(9, j).getContents())){
								
								totalIts = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(9,j).getContents()));
								sheet.setSheet9(totalIts+"");
							}else {
								
								totalItsWrong = totalIts+"（请输入相应的整形数值）"+"";
								sheet.setSheet9(totalItsWrong);
								b1 = false;
							}
							
						}
						
						if(st.getCell(10, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(10, j).getContents())){
						   
								advancedIts = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(10,j).getContents()));
								sheet.setSheet10(advancedIts+"");
							}else {

								advancedItsWrong = advancedIts+"（请输入相应的整形数值）"+"";
								sheet.setSheet10(advancedItsWrong);
								b1 = false;
							}
					    }
						
						if(st.getCell(11, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(11, j).getContents())){

						        middleIts = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(11,j).getContents()));
						        sheet.setSheet11(middleIts+"");
							}else {

								middleItsWrong = middleIts+"（请输入相应的整形数值）"+"";
								sheet.setSheet11(middleItsWrong);
								b1 = false;
						    }
							
						}
						
						if(st.getCell(12, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(12, j).getContents())){

								juniorIts = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(12,j).getContents()));
								sheet.setSheet12(juniorIts+"");
							}else {
							
								juniorItsWrong = juniorIts+"（请输入相应的整形数值）"+"";
								sheet.setSheet12(juniorItsWrong);
								b1 = false;
							}
							
						}
						
						if(st.getCell(13, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(13, j).getContents())){

								otherIts = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(13,j).getContents()));
								sheet.setSheet13(otherIts+"");
							}else {
								
								otherItsWrong = otherIts+"（请输入相应的整形数值）"+"";
								sheet.setSheet13(otherItsWrong);
								b1 = false;
							}
							
						}
						
						if(st.getCell(14, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(14, j).getContents())){
						
								numGraduates = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(14,j).getContents()));
								sheet.setSheet14(numGraduates+"");
							}else {
					    		
					    		numGraduatesWrong = numGraduates+"（请输入相应的整形数值）"+"";
					    		sheet.setSheet14(numGraduatesWrong);
								b1 = false;
					    	}
						}
							
						if(st.getCell(15, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(15, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(15, j).getContents())){

								internalExpenditures = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(15,j).getContents()));
								sheet.setSheet15(internalExpenditures+"");
							}else {

								internalExpendituresWrong = internalExpenditures+"（请输入相应的数值）"+"";
								sheet.setSheet15(internalExpendituresWrong);
								b1 = false;
							}
						}
						
						if(st.getCell(16, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(16, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(16, j).getContents())){
	
								rdExpenditures = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(16,j).getContents()));
								sheet.setSheet16(rdExpenditures+"");
							}else {
							
								rdExpendituresWrong = rdExpenditures+"（请输入相应的数值）"+"";
								sheet.setSheet16(rdExpendituresWrong);
								b1 = false;
							}
					
					   }	
						
						if(st.getCell(17, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(17, j).getContents())){

						    	numIssueAssume = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(17,j).getContents()));
						    	sheet.setSheet17(numIssueAssume+"");
							}else {
								
								numIssueAssumeWrong = numIssueAssume+"（请输入相应的整形数值）"+"";
								sheet.setSheet17(numIssueAssumeWrong);
								b1 = false;
							}
							
						}
						
						if(st.getCell(18, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(18, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(18, j).getContents())){

								assetsFixed = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(18,j).getContents()));
								sheet.setSheet18(assetsFixed+"");
							}else {
								
								assetsFixedWrong = assetsFixed+"（请输入相应的整形数值）"+"";
								sheet.setSheet18(assetsFixedWrong);
								b1 = false;
							}

						}
						
						if(st.getCell(19, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(19, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(19, j).getContents())){

								assetsEquipment = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(19,j).getContents()));
								sheet.setSheet19(assetsEquipment+"");
							}else {
								
								assetsEquipmentWrong = assetsEquipment+"（请输入相应的整形数值）"+"";
								sheet.setSheet19(assetsEquipmentWrong);
								b1 = false;
						    }
							
						}
						
						if(st.getCell(20, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(20, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(20, j).getContents())){

								assetsImport = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(20,j).getContents()));
								sheet.setSheet20(assetsImport+"");
							}else {
								
								assetsImportWrong = assetsImport+"（请输入相应的整形数值）"+"";
								sheet.setSheet20(assetsImportWrong);
								b1 = false;
							}

						}
						
						if(st.getCell(21, j).getContents()!=""){
							
							industryService = DoString.nulltoEmptyString(st.getCell(21,j).getContents());
							sheet.setSheet21(industryService);
						}else {
							
							sheet.setSheet21(industryService);
						}
						
						if(b1){
							
							
							user.setUserId(userId);
							String id = GenerateUtils.getID();
							ScienceOrganization scienceOrganization =new ScienceOrganization();
							scienceOrganization.setOrganizationId(id);
							scienceOrganization.setAdvancedIts(advancedIts);
							scienceOrganization.setAssetsEquipment(assetsEquipment);
							scienceOrganization.setAssetsFixed(assetsFixed);
							scienceOrganization.setAssetsImport(assetsImport);
							scienceOrganization.setDoctorEmployees(doctorEmployees);
							scienceOrganization.setIndustryService(industryService);
							scienceOrganization.setInternalExpenditures(internalExpenditures);
							scienceOrganization.setJuniorIts(juniorIts);
							scienceOrganization.setMasterEmployees(masterEmployees);
							scienceOrganization.setMiddleIts(middleIts);
							scienceOrganization.setModusComposition(modusComposition);
							scienceOrganization.setNumGraduates(numGraduates);
							scienceOrganization.setNumIssueAssume(numIssueAssume);
							scienceOrganization.setOrganizationCategory(organizationCategory);
							scienceOrganization.setOrganizationName(organizationName);
							scienceOrganization.setOrganizationType(organizationType);
							scienceOrganization.setOtherIts(otherIts);
							scienceOrganization.setRdExpenditures(rdExpenditures);
							scienceOrganization.setSortSubject(sortSubject);
							scienceOrganization.setTotalEmployees(totalEmployees);
							scienceOrganization.setTotalIts(totalIts);
							scienceOrganization.setSubmitUser(user);
							scienceOrganization.setStatus(status);
							ScienceOrganizationlists.add(scienceOrganization);
							
						}else{
							b1 = true;
							scienceOrganizationSheet.add(sheet);
						}
					  
					 }	
					 
					 
					 if(scienceOrganizationSheet.size()!=0){
						 
						writableSheet = writableworkbook.createSheet("理工类科研机构表",0);
						Label label = new Label(0,0, "科技活动机构情况表");
						WritableCellFormat cellFormat=new WritableCellFormat();
					     cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
					     label.setCellFormat(cellFormat);
						 writableSheet.addCell(label);
						 writableSheet.mergeCells(0,0,21,0);
						 
						 
						 
						  cellFormat = new WritableCellFormat();
						  label = new Label(0,1,"序号");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(0,1,0,3);
						  
						  cellFormat=new WritableCellFormat();
						  label = new Label(1,1,"机构名称");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(1,1,1,3);
						  
						  cellFormat=new WritableCellFormat();
						  label = new Label(2,1,"机构类型");
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(2,1,2,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(3,1,"类别机构"	);
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(3,1,3,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(4,1,"学科分类");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(4,1,4,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(5,1,"组成形式");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(5,1,6,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(6,1,"从业人员合计");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(6,1,6,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(7,1,"其中博士毕业");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(7,1,7,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(8,1,"其中硕士毕业");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(8,1,8,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(9,1,"科技活动人员（人年）合计");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(9,1,9,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(10,1,"其中高级职称");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(10,1,10,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(11,1,"其中中级职称");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(11,1,11,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(12,1,"其中初级职称");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						 label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(12,1,12,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(13,1,"其中其他");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(13,1,13,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(14,1,"培养研究生（人）");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(14,1,14,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(15,1,"当年经费内部支出（千元");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(15,1,15,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(16,1,"R&D支出（千元）");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(16,1,16,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(17,1,"承担课题（项）");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(17,1,17,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(18,1,"固定资产原值（千元）");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(18,1,18,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(19,1,"其中仪器设备（千元）");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(19,1,19,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(20,1,"其中：进口（千元）");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(20,1,20,3);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(21,1,"服务的国民经济行业");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(21,1,21,3);
						
						 for(int m=0;m<scienceOrganizationSheet.size();m++){
							
							 Sheet sheets = scienceOrganizationSheet.get(m);
							 
							  label = new Label(0,m+4,m+1+"");	
							  writableSheet.addCell(label);
							  label = new Label(1,m+4,sheets.getSheet1());	
							  writableSheet.addCell(label);
							  label = new Label(2,m+4,sheets.getSheet2());	
							  writableSheet.addCell(label);
							  label = new Label(3,m+4,sheets.getSheet3());	
							  writableSheet.addCell(label);
							  label = new Label(4,m+4,sheets.getSheet4());	
							  writableSheet.addCell(label);
							  label = new Label(5,m+4,sheets.getSheet5());	
							  writableSheet.addCell(label);
							  label = new Label(6,m+4,sheets.getSheet6());	
							  writableSheet.addCell(label);
							  label = new Label(7,m+4,sheets.getSheet7());	
							  writableSheet.addCell(label);
							  label = new Label(8,m+4,sheets.getSheet8());	
							  writableSheet.addCell(label);
							  label = new Label(9,m+4,sheets.getSheet9());	
							  writableSheet.addCell(label);
							  label = new Label(10,m+4,sheets.getSheet10());	
							  writableSheet.addCell(label);
							  label = new Label(11,m+4,sheets.getSheet11());	
							  writableSheet.addCell(label);
							  label = new Label(12,m+4,sheets.getSheet12());	
							  writableSheet.addCell(label);
							  label = new Label(13,m+4,sheets.getSheet13());	
							  writableSheet.addCell(label);
							  label = new Label(14,m+4,sheets.getSheet14());	
							  writableSheet.addCell(label);
							  label = new Label(15,m+4,sheets.getSheet15());	
							  writableSheet.addCell(label);
							  label = new Label(16,m+4,sheets.getSheet16());	
							  writableSheet.addCell(label);
							  label = new Label(17,m+4,sheets.getSheet17());	
							  writableSheet.addCell(label);
							  label = new Label(18,m+4,sheets.getSheet18());	
							  writableSheet.addCell(label);
							  label = new Label(19,m+4,sheets.getSheet19());	
							  writableSheet.addCell(label);
							  label = new Label(20,m+4,sheets.getSheet20());	
							  writableSheet.addCell(label);
							  label = new Label(21,m+4,sheets.getSheet21());	
							  writableSheet.addCell(label);
						}
				
						 
				}	
				
			    }else if("理工类科研项目".equals(name)){
			    	 b1 = true;
			    	 
		    		  
					for (int j = 6; j < st.getRows()&&st.getCell(1,j).getContents()!=null&&st.getCell(1,j).getContents()!=""; j++) { 
						
						Sheet sheet = new Sheet();	
				    	 
				    	 String allMember = "";
				    	 String member[];
				    	 
				    	 //科研项目基本信息
				    	 String projectName = "";
				    	 String timeProjectApproved = "";
				    	 float totalFundContract = 0.0f;
				    	 String totalFundContractWrong = "";
				    	 String sortSubject = "";
				    	 String sortActivity = "";
				    	 String originProject = "";
				    	 String formOrganization = "";
				    	 String formCooperation = "";
				    	 String organReliedProject = "";
				    	 String industryService = "";
				    	 String unitProject = "";

				    	 CQUPTUser submitUser;

				    	 int status = 0;
			    		 ScienceTechProject project;
			    		 String memberId;
			    		 int orders;
			    		 String task;
			    		 String remarks;
			    		 ArrayList<String> memberName = new ArrayList<String>();
			    		 //科研项目详细信息
			    	      float inputThisYear = 0.0f;
			    	      String inputThisYearWrong;
			    		  float expenditureThisYear = 0.0f;
			    		  String expenditureThisYearWrong;
			    		  int totalStaff = 0;
			    		  String totalStaffWrong;
			    		  int advancedStaff = 0;
			    		  String advancedStaffWrong;
			    		  int middleStaff = 0;
			    		  String middleStaffWrong;
			    		  int juniorStaff = 0;
			    		  String juniorStaffWrong;
			    		  int otherStaff = 0;
			    		  String otherStaffWrong;
			    		  int graduateJoin = 0;
			    		  String graduateJoinWrong;
			    		  String projectStatus = "";
						
						if(st.getCell(1, j).getContents()!=""){
							
							projectName = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
							sheet.setSheet1(projectName);
					 	
						}else {
							
					 		projectName="请输入机构名称";
							sheet.setSheet1(projectName);
							b1 =false;
						
						}
						
						
						if(st.getCell(2, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
							if(memberName != null){
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							}
							if(!b1){
								allMember = allMember + "(在某个人的名字中间出项了空格,请不要在名字里留空格)";
							}
							sheet.setSheet2(allMember);
					
						}else {
							allMember = allMember + "(请输入负责人姓名)";
							b1 = false;
							sheet.setSheet2(allMember);
						
						}
						
						if(st.getCell(3, j).getContents()!=""){
						
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(3,j).getContents()))!=null)
							{
								timeProjectApproved = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							    sheet.setSheet3(timeProjectApproved);
					
						    }else {
						    	timeProjectApproved = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
								timeProjectApproved = timeProjectApproved+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet3(timeProjectApproved);
						        b1 = false;
						  }
						}else{
							sheet.setSheet3(timeProjectApproved);
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(4, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(4, j).getContents())){

								totalFundContract = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(4,j).getContents()));
								sheet.setSheet4(totalFundContract+"");
							
							}else {
								
								totalFundContractWrong = totalFundContract+"（请输入相应的数值）"+"";
								sheet.setSheet4(totalFundContract+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(5, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(5, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(5, j).getContents())){

								inputThisYear = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(5,j).getContents()));
								sheet.setSheet5(inputThisYear+"");
							
							}else {
								
								inputThisYearWrong = inputThisYear+"（请输入相应的数值）";
								sheet.setSheet5(inputThisYear+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(6, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(6, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(6, j).getContents())){

								expenditureThisYear = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(6,j).getContents()));
								sheet.setSheet6(expenditureThisYear+"");
							
							}else {
								
								expenditureThisYearWrong = expenditureThisYear+"（请输入相应的数值）"+"";
								sheet.setSheet6(expenditureThisYear+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(7, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(7, j).getContents())){

								totalStaff = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(7,j).getContents()));
						    	sheet.setSheet7(totalStaff+"");
							}else {
								
								totalStaffWrong = totalStaff+"（请输入相应的整形数值）"+"";
								sheet.setSheet7(totalStaffWrong+"");
								b1 = false;
							}
							
						}

						if(st.getCell(8, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(8, j).getContents())){

								advancedStaff = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(8,j).getContents()));
						    	sheet.setSheet8(advancedStaff+"");
							}else {
								
								advancedStaffWrong = advancedStaff+"（请输入相应的整形数值）"+"";
								sheet.setSheet8(advancedStaffWrong);
								b1 = false;
							}
							
						}
						
						if(st.getCell(9, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(9, j).getContents())){

								middleStaff = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(9,j).getContents()));
						    	sheet.setSheet9(middleStaff+"");
							}else {
								
								middleStaffWrong = middleStaff+"（请输入相应的整形数值）"+"";
								sheet.setSheet9(middleStaffWrong);
								b1 = false;
							}
							
						}
						
						if(st.getCell(10, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(10, j).getContents())){

								juniorStaff = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(10,j).getContents()));
						    	sheet.setSheet10(juniorStaff+"");
							}else {
								
								juniorStaffWrong = juniorStaff+"（请输入相应的整形数值）"+"";
								sheet.setSheet10(juniorStaffWrong);
								b1 = false;
							}
							
						}
						
						if(st.getCell(11, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(11, j).getContents())){

								otherStaff = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(11,j).getContents()));
						    	sheet.setSheet11(otherStaff+"");
							}else {
								
								otherStaffWrong = otherStaff+"（请输入相应的整形数值）"+"";
								sheet.setSheet11(otherStaffWrong);
								b1 = false;
							}
							
						}
						
						if(st.getCell(12, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(12, j).getContents())){

								graduateJoin = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(12,j).getContents()));
						    	sheet.setSheet12(graduateJoin+"");
							}else {
								
								graduateJoinWrong = graduateJoin+"（请输入相应的整形数值）"+"";
								sheet.setSheet12(graduateJoinWrong);
								b1 = false;
							}
							
						}
						
						if(st.getCell(13, j).getContents()!=""){
							
							sortSubject = DoString.nulltoEmptyString(st.getCell(13,j).getContents());
							sheet.setSheet13(sortSubject);
						
						}else {
							
							sheet.setSheet13(sortSubject);
						
						}
						
						
						if(st.getCell(14, j).getContents()!=""){
							
							projectStatus = DoString.nulltoEmptyString(st.getCell(14,j).getContents());
							sheet.setSheet14(projectStatus);
						
						}else {
							
							sheet.setSheet14(projectStatus);
						
						}
						
						if(st.getCell(15, j).getContents()!=""){
						
							sortActivity = DoString.nulltoEmptyString(st.getCell(15,j).getContents());
							sheet.setSheet15(sortActivity);
						
						}else {
							
							sheet.setSheet15(sortActivity);
						
						}
						
						if(st.getCell(16, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(16, j).getContents())){
								
								originProject = DoString.nulltoEmptyString(st.getCell(16,j).getContents());
								sheet.setSheet16(originProject);
							
							}else{
								
								sheet.setSheet16(originProject);
							}
						}
						
						if(st.getCell(17, j).getContents()!=""){
						
						
								formOrganization =DoString.nulltoEmptyString(st.getCell(17,j).getContents());
								sheet.setSheet17(formOrganization+"");
						
						}else{
							
							sheet.setSheet17(formOrganization);
						}
						
						if(st.getCell(18, j).getContents()!=""){
					
								formCooperation = DoString.nulltoEmptyString(st.getCell(18,j).getContents());
								sheet.setSheet18(formCooperation);
						
						}else {
							
							sheet.setSheet18(formCooperation);
						}
						
						if(st.getCell(19, j).getContents()!=""){
								
								organReliedProject = DoString.nulltoEmptyString(st.getCell(19,j).getContents());
								
								sheet.setSheet19(organReliedProject);
						}else {
								
								sheet.setSheet19(organReliedProject);
						}
						
						if(st.getCell(20, j).getContents()!=""){
							
						        industryService = DoString.nulltoEmptyString(st.getCell(20,j).getContents());
								sheet.setSheet20(industryService+"");
						
						}else {

								sheet.setSheet20(industryService);
					    }
						
						if(st.getCell(21, j).getContents()!=""){
							

								unitProject = DoString.nulltoEmptyString(st.getCell(21,j).getContents());
						        sheet.setSheet21(unitProject);
						
						}else {

								sheet.setSheet21(unitProject);
							
						}
						
						if(b1){
							
							
							user.setUserId(userId);
							String id = GenerateUtils.getID();
							ScienceTechProject scienceTechProject =new ScienceTechProject();
							scienceTechProject.setFormCooperation(formCooperation);
							scienceTechProject.setFormOrganization(formOrganization);
							scienceTechProject.setIndustryService(industryService);
							scienceTechProject.setOrganReliedProject(organReliedProject);
							scienceTechProject.setOriginProject(originProject);
							scienceTechProject.setProjectId(id);
							scienceTechProject.setProjectName(projectName);
							scienceTechProject.setSortActivity(sortActivity);
							scienceTechProject.setSortSubject(sortSubject);
							scienceTechProject.setStatus(status);
							scienceTechProject.setSubmitUser(user);
							if(TypeConvert.StringtoDate(timeProjectApproved)!=null)
							scienceTechProject.setTimeProjectApproved(TypeConvert.StringtoDate(timeProjectApproved));
							scienceTechProject.setTotalFundContract(totalFundContract);
							scienceTechProject.setUnitProject(unitProject);
							
							String Detailid = GenerateUtils.getID();
							ScienceDetailTechProject scienceDetailTechProject = new ScienceDetailTechProject();
							scienceDetailTechProject.setAdvancedStaff(advancedStaff);
							scienceDetailTechProject.setDeatilProjectId(Detailid);
							scienceDetailTechProject.setExpenditureThisYear(expenditureThisYear);
							scienceDetailTechProject.setGraduateJoin(graduateJoin);
							scienceDetailTechProject.setInputThisYear(inputThisYear);
							scienceDetailTechProject.setJuniorStaff(juniorStaff);
							scienceDetailTechProject.setMiddleStaff(middleStaff);
							scienceDetailTechProject.setOtherStaff(otherStaff);
							scienceDetailTechProject.setProjectStatus(projectStatus);
							scienceDetailTechProject.setScienceTechProject(scienceTechProject);
							scienceDetailTechProject.setTotalStaff(totalStaff);
							scienceDetailTechProject.setUpdateTime(new Date());//更新时间设置为当前信息提交时间
							
							
							 ArrayList<ScienceTechProjectMember> scienceTechProjectMembers = new ArrayList<ScienceTechProjectMember>();

								for(int m = 0; m < memberName.size(); m++){
									ScienceTechProjectMember scienceTechProjectMember = new ScienceTechProjectMember();
									scienceTechProjectMember.setProject(scienceTechProject);
									scienceTechProjectMember.setMemberName(memberName.get(m));
									
									scienceTechProjectMembers.add(scienceTechProjectMember);
								}
								ScienceTechProjectlists.add(scienceTechProject);
								ScienceDetailTechProjectlists.add(scienceDetailTechProject);
								ScienceTechProjectMemberlists.add(scienceTechProjectMembers);
								
						}else{
							b1 = true;
							scienceTechProjectSheet.add(sheet);
						}
					  
					 }	
					 
					 
					 if(scienceTechProjectSheet.size()!=0){
						 
						 writableSheet = writableworkbook.createSheet("理工类科研项目",1);
						 Label label = new Label(0,0, "科技项目情况表");
						 WritableCellFormat cellFormat=new WritableCellFormat();
					     cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
					     label.setCellFormat(cellFormat);
						 writableSheet.addCell(label);
						 writableSheet.mergeCells(0,0,21,0);
					    
					
						 
						 cellFormat = new WritableCellFormat();
						  label = new Label(0,1,"序号");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(0,1,0,4);
						  
						  cellFormat=new WritableCellFormat();
						  label = new Label(1,1,"项目名称");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(1,1,1,4);
						  
						  cellFormat=new WritableCellFormat();
						  label = new Label(2,1,"负责人");
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(2,1,2,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(3,1,"项目批准（合同签定）时间"	);
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(3,1,3,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(4,1,"合同总经费(千元)");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(4,1,4,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(5,1,"当年拨入经费（千元）");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(5,1,5,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(6,1,"当年支出经费（千元）");
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(6,1,6,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(7,1,"当年投入人员（人年）合计");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(7,1,7,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(8,1,"其中高级职务");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(8,1,8,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(9,1,"其中中级职务");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(9,1,9,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(10,1,"其中初级职称");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(10,1,10,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(11,1,"其中其他");
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(11,1,11,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(12,1,"参与研究生数（人）");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(12,1,12,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(13,1,"学科分类");
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(13,1,13,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(14,1,"项目状态");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(14,1,14,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(15,1,"活动分类");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(15,1,15,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(16,1,"项目来源");		
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(16,1,16,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(17,1,"组织形式");		
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(17,1,17,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(18,1,"合作形式");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(18,1,18,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(19,1,"项目依托科研机构");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(19,1,19,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(20,1,"服务的国民经济行业");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(20,1,20,4);
						  
						  cellFormat = new WritableCellFormat();
						  label = new Label(21,1,"项目所在部门");	
						  cellFormat.setAlignment(jxl.format.Alignment.JUSTIFY);
						  label.setCellFormat(cellFormat);
						  writableSheet.addCell(label);
						  writableSheet.mergeCells(21,1,21,4);
						 
						 for(int m=0;m<scienceTechProjectSheet.size();m++){
							
							 Sheet sheets = scienceTechProjectSheet.get(m);
							 
							  label = new Label(0,m+6,m+1+"");	
							  writableSheet.addCell(label);
							  label = new Label(1,m+6,sheets.getSheet1());	
							  writableSheet.addCell(label);
							  label = new Label(2,m+6,sheets.getSheet2());	
							  writableSheet.addCell(label);
							  label = new Label(3,m+6,sheets.getSheet3());	
							  writableSheet.addCell(label);
							  label = new Label(4,m+6,sheets.getSheet4());	
							  writableSheet.addCell(label);
							  label = new Label(5,m+6,sheets.getSheet5());	
							  writableSheet.addCell(label);
							  label = new Label(6,m+6,sheets.getSheet6());	
							  writableSheet.addCell(label);
							  label = new Label(7,m+6,sheets.getSheet7());	
							  writableSheet.addCell(label);
							  label = new Label(8,m+6,sheets.getSheet8());	
							  writableSheet.addCell(label);
							  label = new Label(9,m+6,sheets.getSheet9());	
							  writableSheet.addCell(label);
							  label = new Label(10,m+6,sheets.getSheet10());	
							  writableSheet.addCell(label);
							  label = new Label(11,m+6,sheets.getSheet11());	
							  writableSheet.addCell(label);
							  label = new Label(12,m+6,sheets.getSheet12());	
							  writableSheet.addCell(label);
							  label = new Label(13,m+6,sheets.getSheet13());	
							  writableSheet.addCell(label);
							  label = new Label(14,m+6,sheets.getSheet14());	
							  writableSheet.addCell(label);
							  label = new Label(15,m+6,sheets.getSheet15());	
							  writableSheet.addCell(label);
							  label = new Label(16,m+6,sheets.getSheet16());	
							  writableSheet.addCell(label);
							  label = new Label(17,m+6,sheets.getSheet17());	
							  writableSheet.addCell(label);
							  label = new Label(18,m+6,sheets.getSheet18());	
							  writableSheet.addCell(label);
							  label = new Label(19,m+6,sheets.getSheet19());	
							  writableSheet.addCell(label);
							  label = new Label(20,m+6,sheets.getSheet20());	
							  writableSheet.addCell(label);
							  label = new Label(21,m+6,sheets.getSheet21());	
							  writableSheet.addCell(label);
						}
				
						 
						
						
					}
					
				}else if("理工类著作".equals(name)){
					
					for (int j = 1; j < st.getRows()&&st.getCell(2,j).getContents()!=null&&st.getCell(2,j).getContents()!=""; j++) { 
						 b1 = true;
						Sheet sheet = new Sheet();	
						ArrayList<String> memberName = new ArrayList<String>();
						 String allMember = "";
						 
						 String unitAuthor = "";
						 String publicationName = "";
						 String publicationType = "";
						 String firstAuthor = "";
						 String publisher = "";
						 String ISBN = "";
						 String awardingGrades = "";
						 String publishedTime = "";
						 float totalPrize = 0.0f;
						 String totalPrizeWrong = "";
						 float deductionsDistPosts = 0.0f;
						 String deductionsDistPostsWrong = "";
						 float actualAward = 0.0f;
						 String actualAwardWrong = "";
						 String remarks = "";

						 int status = 0;
						 String returnReason;
						
						 int id;
						 String authorId;
						 int orders;

						if(st.getCell(0, j).getContents()!=""){
							
							unitAuthor = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(unitAuthor);
					 	
						}else {
							
						    sheet.setSheet0(unitAuthor);
						
						}
						
						if(st.getCell(2, j).getContents()!=""){
							
							publicationName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(publicationName);
						
						}else {
							publicationName="请输入出版物名称";
							sheet.setSheet2(publicationName);
							b1 =false;
						}
						
						if(st.getCell(3, j).getContents()!=""){
							
							publicationType = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(publicationType);
						
						}else {
							
							sheet.setSheet3(publicationType);
						
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							firstAuthor = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(firstAuthor);
						
						}else {
							b1 = false;
							firstAuthor = "请输入第一作者名字";
							sheet.setSheet4(firstAuthor);
						
						}

						if(st.getCell(5, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							allMember = firstAuthor +";"+ allMember;
						    memberName = TypeConvert.getNames(allMember);
							
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(在某个人的名字中间出项了空格)";
							}
							sheet.setSheet5(allMember);
					
						}else {
							
							sheet.setSheet5(allMember);
						
						}
						
						if(st.getCell(6, j).getContents()!=""){
							
							publisher = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							sheet.setSheet6(publisher);
						
						}else {
							
							sheet.setSheet6(publisher);
						
						}
						
						if(st.getCell(8, j).getContents()!=""){
							
							ISBN = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
							sheet.setSheet7(ISBN);
						
						}else {
							
							sheet.setSheet7(ISBN);
						
						}
						
						if(st.getCell(9, j).getContents()!=""){
							
							awardingGrades = DoString.nulltoEmptyString(st.getCell(9,j).getContents());
							sheet.setSheet8(awardingGrades);
						
						}else {
							
							sheet.setSheet8(awardingGrades);
						
						}
						
						
						if(st.getCell(10, j).getContents()!=""){
						
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(10,j).getContents()))!=null)
							{
								publishedTime = DoString.nulltoEmptyString(st.getCell(10,j).getContents());
							    sheet.setSheet9(publishedTime);
					
						    }else {
						    	b1 = false;
						    	publishedTime = DoString.nulltoEmptyString(st.getCell(10,j).getContents());
						    	publishedTime = publishedTime+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet9(publishedTime);
						
						  }
						}else{
							sheet.setSheet9(publishedTime);
						}
						
						if(st.getCell(11, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(11, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(11, j).getContents())){

								totalPrize = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(11,j).getContents()));
								sheet.setSheet10(totalPrize+"");
							
							}else {
								
								totalPrizeWrong = totalPrize+"（请输入相应的数值）"+"";
								sheet.setSheet10(totalPrizeWrong+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(12, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(12, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(12, j).getContents())){

								deductionsDistPosts = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(12,j).getContents()));
								sheet.setSheet11(deductionsDistPosts+"");
							
							}else {
								
								deductionsDistPostsWrong = deductionsDistPosts+"（请输入相应的数值）";
								sheet.setSheet11(deductionsDistPosts+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(13, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(13, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(13, j).getContents())){

								actualAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(13,j).getContents()));
								sheet.setSheet12(actualAward+"");
							
							}else {
								
								actualAwardWrong = actualAward+"（请输入相应的数值）"+"";
								sheet.setSheet12(actualAwardWrong+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(14, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(14,j).getContents());
							sheet.setSheet13(remarks);
						
						}else {
							
							sheet.setSheet13(remarks);
						
						}
						
						if(b1){
							
							
							user.setUserId(userId);
							String bookId = GenerateUtils.getID();
							ScienceBook scienceBook =new ScienceBook();
							scienceBook.setActualAward(actualAward);
							scienceBook.setAwardingGrades(awardingGrades);
							scienceBook.setBookId(bookId);
							scienceBook.setDeductionsDistPosts(deductionsDistPosts);
							scienceBook.setISBN(ISBN);
							scienceBook.setPublicationName(publicationName);
							scienceBook.setPublicationType(publicationType);
							scienceBook.setPublishedTime(publishedTime);
							scienceBook.setPublisher(publisher);
							scienceBook.setRemarks(remarks);
							scienceBook.setStatus(status);
							scienceBook.setSubmitUser(user);
							scienceBook.setTotalPrize(totalPrize);
							scienceBook.setUnitAuthor(unitAuthor);
							
							
							
							 ArrayList<ScienceBookAuthor> scienceBookAuthors = new ArrayList<ScienceBookAuthor>();

							 if(memberName.size()!=0){
								for(int m = 0; m < memberName.size(); m++){
									ScienceBookAuthor scienceBookAuthor = new ScienceBookAuthor();
									scienceBookAuthor.setScienceBook(scienceBook);
									scienceBookAuthor.setMemberName(memberName.get(m));
									
									scienceBookAuthors.add(scienceBookAuthor);
								}
							 }else{
								 
								   ScienceBookAuthor scienceBookAuthor = new ScienceBookAuthor();
									scienceBookAuthor.setScienceBook(scienceBook);
									scienceBookAuthor.setMemberName(firstAuthor);
									scienceBookAuthors.add(scienceBookAuthor);
							}
								scienceBooklist.add(scienceBook);
								scienceBookAuthorlist.add(scienceBookAuthors);
						    
						}else{
							b1 = true;
							scienceBookSheet.add(sheet);
						}	
					}
					
					 
					 if(scienceBookSheet.size()!=0){
						 
					   	 writableSheet = writableworkbook.createSheet("理工类著作",2);
					      Label label = new Label(0,0,"所在单位");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"ID");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"出版物名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"类别");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"第一作者");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"其它作者");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"出版单位"	);
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"书号");	
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"ISBN");	
						  writableSheet.addCell(label);
						  
						  label = new Label(9,0,"奖励等级");
						  writableSheet.addCell(label);
						  
						  label = new Label(10,0,"出版年月");	
						  writableSheet.addCell(label);
						  
						  label = new Label(11,0,"总奖金额(万元)");	
						  writableSheet.addCell(label);
						  
						  label = new Label(12,0,"扣减特聘岗位");	
						  writableSheet.addCell(label);
						  
						  label = new Label(13,0,"实际获得奖励金额（万元）");	
						  writableSheet.addCell(label);
						  
						  label = new Label(14,0,"备注");
						  writableSheet.addCell(label);
						  
						
						 for(int m=0;m<scienceBookSheet.size();m++){
							
							 Sheet sheets = scienceBookSheet.get(m);
							 
							  label = new Label(0,m+1,sheets.getSheet1());	
							  writableSheet.addCell(label);
							  label = new Label(1,m+1,m+1+"");	
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
							  label = new Label(8,m+1,sheets.getSheet7());	
							  writableSheet.addCell(label);
							  label = new Label(9,m+1,sheets.getSheet8());	
							  writableSheet.addCell(label);
							  label = new Label(10,m+1,sheets.getSheet9());	
							  writableSheet.addCell(label);
							  label = new Label(11,m+1,sheets.getSheet10());	
							  writableSheet.addCell(label);
							  label = new Label(12,m+1,sheets.getSheet11());	
							  writableSheet.addCell(label);
							  label = new Label(13,m+1,sheets.getSheet12());	
							  writableSheet.addCell(label);
							  label = new Label(14,m+1,sheets.getSheet13());	
							  writableSheet.addCell(label);
							
						}
				
				  }
					
				}else if("理工类论文".equals(name)){
					 
					 
					for (int j = 1; j < st.getRows()&&st.getCell(2,j).getContents()!=null&&st.getCell(2,j).getContents()!=""; j++) { 
						 Sheet sheet = new Sheet();	
						 b1 = true;
							
						 ArrayList<String> memberName = new ArrayList<String>();
						 
						 String department = "";
						 String paperName = "";
						 String firstAuthor = "";
						 String allMember = "";
						 String subjectsIn = "";
						 String postPublication = "";
						 String includeSituation = "";
						 String publishedTime = "";
						 String titleNumber = "";
						 String awardingGrades = "";
						 float totalPrize = 0.0f;
						 String totalPrizeWrong;
						 float deductionsDistPosts = 0.0f;
						 String deductionsDistPostsWrong;
						 float actualAward = 0.0f;
						 String actualAwardWrong;
						 String papersUnits = "";

						 CQUPTUser submitUser;
						 CQUPTUser approvedUser;

						 int status = 0;
						 String remarks = "";
						 if(st.getCell(0, j).getContents()!=""){
							
							department = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(department);
					 	
						}else {
							
						    sheet.setSheet0(department);
						
						}
						
						if(st.getCell(2, j).getContents()!=""){
							
							paperName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(paperName);
						
						}else {
							paperName="请输入论文名称";
							sheet.setSheet2(paperName);
							b1 =false;
						}
						
						
						if(st.getCell(3, j).getContents()!=""){
							
							firstAuthor = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(firstAuthor);
						
						}else {
							b1 = false;
							firstAuthor = "请输入第一作者名字";
							sheet.setSheet3(firstAuthor);
						
						}

						if(st.getCell(4, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							allMember = firstAuthor +";"+ allMember;
						    memberName = TypeConvert.getNames(allMember);
							if(memberName != null){
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							}
							if(b1 == false){
								allMember = allMember + "(没有其他负责人名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet4(allMember);
					
						}else {
							
							sheet.setSheet4(allMember);
						
						}
						
						if(st.getCell(5, j).getContents()!=""){
							
							subjectsIn = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(subjectsIn);
						
						}else {
							
							sheet.setSheet5(subjectsIn);
						
						}
						
						if(st.getCell(6, j).getContents()!=""){
							
							postPublication = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							sheet.setSheet6(postPublication);
						
						}else {
							
							sheet.setSheet6(postPublication);
						
						}
						
						if(st.getCell(7, j).getContents()!=""){
							
							includeSituation = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
							sheet.setSheet7(includeSituation);
						
						}else {
							
							sheet.setSheet7(includeSituation);
						
						}
						
						if(st.getCell(8, j).getContents()!=""){
							
							includeSituation = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
							sheet.setSheet8(publishedTime);
						
						}else {
							
							sheet.setSheet8(publishedTime);
						
						}
					
						if(st.getCell(9, j).getContents()!=""){
							
							titleNumber = DoString.nulltoEmptyString(st.getCell(9,j).getContents());
							sheet.setSheet9(titleNumber);
						
						}else {
							
							sheet.setSheet9(titleNumber);
						
						}
						
						if(st.getCell(10, j).getContents()!=""){
							
							awardingGrades = DoString.nulltoEmptyString(st.getCell(10,j).getContents());
							sheet.setSheet10(awardingGrades);
						
						}else {
							
							sheet.setSheet10(awardingGrades);
						
						}
						
						
						if(st.getCell(11, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(11, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(11, j).getContents())){

								totalPrize = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(11,j).getContents()));
								sheet.setSheet11(totalPrize+"");
							
							}else {
								
								totalPrizeWrong = totalPrize+"（请输入相应的数值）"+"";
								sheet.setSheet11(totalPrizeWrong+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(12, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(12, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(12, j).getContents())){

								deductionsDistPosts = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(12,j).getContents()));
								sheet.setSheet12(deductionsDistPosts+"");
							
							}else {
								
								deductionsDistPostsWrong = deductionsDistPosts+"（请输入相应的数值）";
								sheet.setSheet12(deductionsDistPosts+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(13, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(13, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(13, j).getContents())){

								actualAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(13,j).getContents()));
								sheet.setSheet13(actualAward+"");
							
							}else {
								
								actualAwardWrong = actualAward+"（请输入相应的数值）"+"";
								sheet.setSheet13(actualAwardWrong+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(14, j).getContents()!=""){
							
							papersUnits = DoString.nulltoEmptyString(st.getCell(14,j).getContents());
							sheet.setSheet14(papersUnits);
						
						}else {
							
							sheet.setSheet14(papersUnits);
						
						}
						
						if(st.getCell(15, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(15,j).getContents());
							sheet.setSheet15(remarks);
						
						}else {
							
							sheet.setSheet15(remarks);
						
						}
						
						if(b1){
							
							
							user.setUserId(userId);
							String paperId = GenerateUtils.getID();
							SciencePaper sciencePaper =new SciencePaper();
							sciencePaper.setActualAward(actualAward);
							sciencePaper.setAwardingGrades(awardingGrades);
							sciencePaper.setDeductionsDistPosts(deductionsDistPosts);
							sciencePaper.setDepartment(department);
							sciencePaper.setIncludeSituation(includeSituation);
							sciencePaper.setPaperId(paperId);
							sciencePaper.setPaperName(paperName);
							sciencePaper.setPapersUnits(papersUnits);
							sciencePaper.setPostPublication(postPublication);
							sciencePaper.setPublishedTime(publishedTime);
							sciencePaper.setRemarks(remarks);
							sciencePaper.setStatus(status);
							sciencePaper.setSubjectsIn(subjectsIn);
							sciencePaper.setSubmitUser(user);
							sciencePaper.setTitleNumber(titleNumber);
							sciencePaper.setTotalPrize(totalPrize);
							
							sciencePaperlist.add(sciencePaper);
							
							 ArrayList<SciencePaperAuthor> sciencePaperAuthors = new ArrayList<SciencePaperAuthor>();

							 if(memberName.size()!=0){
								for(int m = 0; m < memberName.size(); m++){
									SciencePaperAuthor sciencePaperAuthor = new SciencePaperAuthor();
									sciencePaperAuthor.setSciencePaper(sciencePaper);
									sciencePaperAuthor.setMemberName(memberName.get(m));
									
									sciencePaperAuthors.add(sciencePaperAuthor);
								}
							 }else{
								
								 SciencePaperAuthor sciencePaperAuthor = new SciencePaperAuthor();
									sciencePaperAuthor.setSciencePaper(sciencePaper);
									sciencePaperAuthor.setMemberName(firstAuthor);
									sciencePaperAuthors.add(sciencePaperAuthor);
								   
							}
								sciencePaperAuthorlist.add(sciencePaperAuthors);
						    
						}else{
							b1 = true;
							sciencePaperSheet.add(sheet);
						}	
					}
					
					 
					 if(sciencePaperSheet.size()!=0){
						 
					   	 writableSheet = writableworkbook.createSheet("理工类论文",3);
					      Label label = new Label(0,0,"所在部门");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"ID");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"论文名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"第一作者");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"其它作者");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"所在学科");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"发表刊物(填写全称)"	);
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"收录情况");	
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"出版年月");	
						  writableSheet.addCell(label);
						  
						  label = new Label(9,0,"卷期号及页码");
						  writableSheet.addCell(label);
						  
						  label = new Label(10,0,"奖励等级");	
						  writableSheet.addCell(label);
						  
						  label = new Label(11,0,"奖励金额（元）");	
						  writableSheet.addCell(label);
						  
						  label = new Label(12,0,"特聘岗位/教授/其他扣减");	
						  writableSheet.addCell(label);
						  
						  label = new Label(13,0,"扣除后的奖励金额");	
						  writableSheet.addCell(label);
						  
						  label = new Label(14,0,"论文署名单位");
						  writableSheet.addCell(label);
						  
						  label = new Label(15,0,"其他说明");
						  writableSheet.addCell(label);
						  
						 for(int m=0;m<sciencePaperSheet.size();m++){
							
							 Sheet sheets = sciencePaperSheet.get(m);
							 
							  label = new Label(0,m+1,sheets.getSheet0());	
							  writableSheet.addCell(label);
							  label = new Label(1,m+1,m+1+"");	
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
							  label = new Label(11,m+1,sheets.getSheet11());	
							  writableSheet.addCell(label);
							  label = new Label(12,m+1,sheets.getSheet12());	
							  writableSheet.addCell(label);
							  label = new Label(13,m+1,sheets.getSheet13());	
							  writableSheet.addCell(label);
							  label = new Label(14,m+1,sheets.getSheet14());	
							  writableSheet.addCell(label);
							  label = new Label(15,m+1,sheets.getSheet15());	
							  writableSheet.addCell(label);
						}
				
					}
					
				}else if("理工类政府科技奖励".equals(name)){
					
					for (int j = 1; j < st.getRows()&&st.getCell(2,j).getContents()!=null&&st.getCell(2,j).getContents()!=""; j++){ 
						Sheet sheet = new Sheet();	
						b1 = true;
						 
						 ArrayList<String> memberName = new ArrayList<String>();
						     String allMember = "";
							 String collegesIn = "";
							 String projectName = "";
							 String awardingGrades = "";
							 String completeUnit = "";
							 float unitAward = 0.0f;
							 String unitAwardWrong;
							 float personAward = 0.0f;
							 String personAwardWrong;
							 float totalAward = 0.0f;
							 String totalAwardWrong;
							 String remarks = "";
							 int status = 0;
							 
						if(st.getCell(0, j).getContents()!=""){
							
							collegesIn = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(collegesIn);
					 	
						}else {
							
						    sheet.setSheet0(collegesIn);
						
						}
						
						if(st.getCell(2, j).getContents()!=""){
							
							projectName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(projectName);
						
						}else {
							projectName="请输入政府奖励的科技项目名称";
							sheet.setSheet2(projectName);
							b1 =false;
						}

						if(st.getCell(3, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有主要完成人名字或者在某个人的名字中间出项了空格)";
							}
							sheet.setSheet3(allMember);
					
						}else {
							b1 = false;
							allMember = allMember + "(请输入主要完成人姓名)";
							sheet.setSheet3(allMember);
						
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							awardingGrades = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(awardingGrades);
						
						}else {
							
							sheet.setSheet4(awardingGrades);
						
						}
						
						if(st.getCell(5, j).getContents()!=""){
							
							completeUnit = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(completeUnit);
						
						}else {
							
							sheet.setSheet5(completeUnit);
						
						}
						
						if(st.getCell(6, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(6, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(6, j).getContents())){

								unitAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(6,j).getContents()));
								sheet.setSheet6(unitAward+"");
							
							}else {
								
								unitAwardWrong = unitAward+"（请输入相应的数值）"+"";
								sheet.setSheet6(unitAwardWrong+"");
								b1 = false;
						    }
						}	
						
						if(st.getCell(7, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(7, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(7, j).getContents())){

								personAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(7,j).getContents()));
								sheet.setSheet7(personAward+"");
							
							}else {
								
								personAwardWrong = personAward+"（请输入相应的数值）"+"";
								sheet.setSheet7(personAwardWrong+"");
								b1 = false;
						    }
						}	

						if(st.getCell(8, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(8, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(8, j).getContents())){

								totalAward = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(8,j).getContents()));
								sheet.setSheet8(totalAward+"");
							
							}else {
								
								totalAwardWrong = totalAward+"（请输入相应的数值）"+"";
								sheet.setSheet8(totalAwardWrong+"");
								b1 = false;
						    }
						}	

						if(b1){
							
							
							user.setUserId(userId);
							String awardId = GenerateUtils.getID();
							SciencePaper sciencePaper =new SciencePaper();
							ScienceGovernmentAward scienceGovernmentAward = new ScienceGovernmentAward();
							scienceGovernmentAward.setAwardId(awardId);
							scienceGovernmentAward.setAwardingGrades(awardingGrades);
							scienceGovernmentAward.setCollegesIn(collegesIn);
							scienceGovernmentAward.setCompleteUnit(completeUnit);
							scienceGovernmentAward.setPersonAward(personAward);
							scienceGovernmentAward.setProjectName(projectName);
							scienceGovernmentAward.setRemarks(remarks);
							scienceGovernmentAward.setStatus(status);
							scienceGovernmentAward.setSubmitUser(user);
							scienceGovernmentAward.setTotalAward(totalAward);
							scienceGovernmentAward.setUnitAward(unitAward);
							
							scienceGovernmentAwardlist.add(scienceGovernmentAward);
							
							 ArrayList<ScienceGovAwardPerson> ScienceGovAwardPersons = new ArrayList<ScienceGovAwardPerson>();

								for(int m = 0; m < memberName.size(); m++){
									ScienceGovAwardPerson scienceGovAwardPerson = new ScienceGovAwardPerson();
									scienceGovAwardPerson.setScienceGovernmentAward(scienceGovernmentAward);
									scienceGovAwardPerson.setMemberName(memberName.get(m));
									
									ScienceGovAwardPersons.add(scienceGovAwardPerson);
								}
							
								ScienceGovAwardPersonslist.add(ScienceGovAwardPersons);
						    
						}else{
							b1 = true;
							ScienceGovAwardPersonsSheet.add(sheet);
						}	
					}
					
					 
					 if(ScienceGovAwardPersonsSheet.size()!=0){
						 
					   	 writableSheet = writableworkbook.createSheet("理工类政府科技奖励",4);
					      Label label = new Label(0,0,"所在学院");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"序号");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"项目名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"主要完成人 ");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"获奖等级");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"主要完成单位");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"配套单位奖励金额（万元）"	);
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"配套个人奖励金额（万元）");	
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"备注");	
						  writableSheet.addCell(label);
						  
						  
						 for(int m=0;m<ScienceGovAwardPersonsSheet.size();m++){
							
							 Sheet sheets = ScienceGovAwardPersonsSheet.get(m);
							 
							  label = new Label(0,m+1,sheets.getSheet0());	
							  writableSheet.addCell(label);
							  label = new Label(1,m+1,m+1+"");	
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
					
				}else if("理工类知识产权情况表".equals(name)){
					
					
					for (int j = 1; j < st.getRows()&&st.getCell(2,j).getContents()!=null&&st.getCell(2,j).getContents()!=""; j++) { 
						 Sheet sheet = new Sheet();	
						 b1 = true;
							
						 ArrayList<String> memberName = new ArrayList<String>();
					     String allMember = "";
						 String collegesIn = "";
						 String patentName = "";
						 String patentType = "";
						 String applicationNumber = "";
						 String patentStatus = "";
						 String filingDate = "";
						 String announcementDate = "";
						 float incentivePayments = 0.0f;
						 String incentivePaymentsWrong = "";
						 String remarks = "";

						 int status = 0;
							 
						if(st.getCell(0, j).getContents()!=""){
							
							collegesIn = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
							sheet.setSheet0(collegesIn);
					 	
						}else {
							
						    sheet.setSheet0(collegesIn);
						
						}
						
						if(st.getCell(2, j).getContents()!=""){
							
							patentName = DoString.nulltoEmptyString(st.getCell(2,j).getContents());
							sheet.setSheet2(patentName);
						
						}else {
							patentName="请输入专利名称";
							sheet.setSheet2(patentName);
							b1 =false;
						}

					
						
						if(st.getCell(3, j).getContents()!=""){
							
							patentType = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
							sheet.setSheet3(patentType);
						
						}else {
							
							sheet.setSheet3(patentType);
						
						}
						
						if(st.getCell(4, j).getContents()!=""){
							
							applicationNumber = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
							sheet.setSheet4(applicationNumber);
						
						}else {
							
							sheet.setSheet4(applicationNumber);
						
						}
						
						
						if(st.getCell(5, j).getContents()!=""){
							
							patentStatus = DoString.nulltoEmptyString(st.getCell(5,j).getContents());
							sheet.setSheet5(patentStatus);
						
						}else {
							
							sheet.setSheet5(patentStatus);
						
						}
					
						
						if(st.getCell(6, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(6,j).getContents()))!=null)
							{
								filingDate = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
							    sheet.setSheet6(filingDate);
					
						    }else {
						    	filingDate = DoString.nulltoEmptyString(st.getCell(6,j).getContents());
						    	filingDate = filingDate+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet6(filingDate);
						        b1 = false;
						    }
						}else {
							sheet.setSheet6(filingDate);
						}
						
						if(st.getCell(7, j).getContents()!=""){
							
							if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(7,j).getContents()))!=null)
							{
								announcementDate = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
							    sheet.setSheet7(announcementDate);
					
						    }else {
						    	announcementDate = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
						    	announcementDate = announcementDate+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
								sheet.setSheet7(announcementDate);
						        b1 = false;
						  }
						}else {
							sheet.setSheet7(filingDate);
						}
						
						if(st.getCell(8, j).getContents()!=""){
							
							allMember = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
						    memberName = TypeConvert.getNames(allMember);
								for(int m = 0; m < memberName.size(); m++){
									
									if(memberName.get(m)==null||memberName.get(m).length()<=1){
											
										    b1 = false;
									}
								}
							if(!b1){
								allMember = allMember + "(没有输入负责人名字或则在某个人的名字中间出项了空格)";
							}
							sheet.setSheet8(allMember);
					
						}else {
							allMember = allMember + "(请输入发明人姓名)";
							sheet.setSheet8(allMember);
							b1 = false;
						}
						
						if(st.getCell(9, j).getContents()!=""){
							
							if(TypeConvert.StringIsInt(st.getCell(9, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(9, j).getContents())){

								incentivePayments = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(9,j).getContents()));
								sheet.setSheet9(incentivePayments+"");
							
							}else {
								
								incentivePaymentsWrong = incentivePayments+"（请输入相应的数值）"+"";
								sheet.setSheet9(incentivePaymentsWrong+"");
								b1 = false;
						    }
						}	

						if(st.getCell(10, j).getContents()!=""){
							
							remarks = DoString.nulltoEmptyString(st.getCell(10,j).getContents());
							sheet.setSheet10(remarks);
						
						}else {
							
							sheet.setSheet10(remarks);
						
						}
						if(b1){
							
							
							user.setUserId(userId);
							String rightsId = GenerateUtils.getID();
							ScienceIpRights scienceIpRights =new ScienceIpRights();
							if(TypeConvert.StringtoDate(announcementDate)!=null)
							scienceIpRights.setAnnouncementDate(TypeConvert.StringtoDate(announcementDate));
							scienceIpRights.setApplicationNumber(applicationNumber);
							scienceIpRights.setCollegesIn(collegesIn);
							if(TypeConvert.StringtoDate(filingDate)!=null)
							scienceIpRights.setFilingDate(TypeConvert.StringtoDate(filingDate));
							scienceIpRights.setIncentivePayments(incentivePayments);
							scienceIpRights.setPatentName(patentName);
							scienceIpRights.setPatentStatus(patentStatus);
							scienceIpRights.setPatentType(patentType);
							scienceIpRights.setRemarks(remarks);
							scienceIpRights.setRightsId(rightsId);
							scienceIpRights.setStatus(status);
							scienceIpRights.setSubmitUser(user);
							scienceIpRightslist.add(scienceIpRights);
							
							 ArrayList<ScienceInventors> scienceInventors = new ArrayList<ScienceInventors>();

								for(int m = 0; m < memberName.size(); m++){
									ScienceInventors scienceInventor = new ScienceInventors();
									scienceInventor.setScienceIpRights(scienceIpRights);
									scienceInventor.setMemberName(memberName.get(m));
									
									scienceInventors.add(scienceInventor);
								}
							
								scienceInventorslist.add(scienceInventors);
						    
						}else{
							b1 = true;
							ScienceIpRightsSheet.add(sheet);
						}	
					}
					if(ScienceIpRightsSheet.size()!=0){
						 
					   	 writableSheet = writableworkbook.createSheet("理工类知识产权情况表",5);
					      Label label = new Label(0,0,"所在学院");	
						  writableSheet.addCell(label);
						  
						  label = new Label(1,0,"ID");	
						  writableSheet.addCell(label);
						  
						  label = new Label(2,0,"专利名称");	
						  writableSheet.addCell(label);
						  
						  label = new Label(3,0,"类型 ");	
						  writableSheet.addCell(label);
						  
						  label = new Label(4,0,"申请号/授权号");	
						  writableSheet.addCell(label);
						  
						  label = new Label(5,0,"专利状态");
						  writableSheet.addCell(label);
						  
						  label = new Label(6,0,"申请日"	);
						  writableSheet.addCell(label);
						  
						  label = new Label(7,0,"授权公告日");	
						  writableSheet.addCell(label);
						  
						  label = new Label(8,0,"发明人/设计人（全部）");	
						  writableSheet.addCell(label);
						  
						  label = new Label(9,0,"奖励金额（单位：万元）");	
						  writableSheet.addCell(label);
						  
						  label = new Label(10,0,"备注");	
						  writableSheet.addCell(label);
						  
						  
						 for(int m=0;m<ScienceIpRightsSheet.size();m++){
							
							 Sheet sheets = ScienceIpRightsSheet.get(m);
							 
							  label = new Label(0,m+1,sheets.getSheet0());	
							  writableSheet.addCell(label);
							  label = new Label(1,m+1,m+1+"");	
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
					 
					 
				  }else if("理工类技术转让情况表".equals(name)){
					    
					  	
						 
						 for (int j = 1; j < st.getRows()&&st.getCell(1,j).getContents()!=null&&st.getCell(1,j).getContents()!=""; j++) { 
							 Sheet sheet = new Sheet();	
							 b1 = true;
								
							 ArrayList<String> memberName = new ArrayList<String>();
							 String allMember = "";
							 String collegeIn = "";
							 String techName = "";
							 String transfereeUnit = "";
							 String unitProperties = "";
							 float contractAmount = 0.0f;
							 String contractAmountWrong;
							 float realIncome = 0.0f;
							 String realIncomeWrong;
							 String transformationWay = "";
							 String startTime = "";
							 String endTime = "";
							 String remarks = "";
							 int status = 0;
							 if(st.getCell(0, j).getContents()!=""){
									
								    collegeIn = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
								 	sheet.setSheet0(collegeIn);
							 	
								}else {
									
								    sheet.setSheet0(collegeIn);
								
								}
								
								if(st.getCell(1, j).getContents()!=""){
									
									techName = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
									sheet.setSheet1(techName);
								
								}else {
									techName="请输入转让的技术名称";
									sheet.setSheet1(techName);
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
										allMember = allMember + "(输入负责人名字时某个人的名字中间出项了空格)";
									}
									sheet.setSheet2(allMember);
							
								}else {
									allMember = allMember + "(请输入发明人姓名)";
									sheet.setSheet2(allMember);
									b1 = false;
								}
								
								if(st.getCell(3, j).getContents()!=""){
									
									transfereeUnit = DoString.nulltoEmptyString(st.getCell(3,j).getContents());
									sheet.setSheet3(transfereeUnit);
								
								}else {
									
									sheet.setSheet3(transfereeUnit);
								
								}
								
								if(st.getCell(4, j).getContents()!=""){
									
									unitProperties = DoString.nulltoEmptyString(st.getCell(4,j).getContents());
									sheet.setSheet4(unitProperties);
								
								}else {
									
									sheet.setSheet4(unitProperties);
								
								}
								
								if(st.getCell(5, j).getContents()!=""){
									
									if(TypeConvert.StringIsInt(st.getCell(5, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(5, j).getContents())){

										contractAmount = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(5,j).getContents()));
										sheet.setSheet5(contractAmount+"");
									
									}else {
										
										contractAmountWrong = contractAmount+"（请输入相应的数值）"+"";
										sheet.setSheet5(contractAmountWrong+"");
										b1 = false;
								    }
								}
								
								if(st.getCell(6, j).getContents()!=""){
									
									if(TypeConvert.StringIsInt(st.getCell(6, j).getContents())||TypeConvert.StringisFloatPointNumber(st.getCell(6, j).getContents())){

										realIncome = Float.parseFloat(DoString.nulltoEmptyString(st.getCell(6,j).getContents()));
										sheet.setSheet6(realIncome+"");
									
									}else {
										
										realIncomeWrong = realIncome+"（请输入相应的数值）"+"";
										sheet.setSheet6(realIncomeWrong+"");
										b1 = false;
								    }
								}
								
								if(st.getCell(7, j).getContents()!=""){
									
									unitProperties = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
									sheet.setSheet7(unitProperties);
								
								}else {
									
									sheet.setSheet7(unitProperties);
								
								}
								
								if(st.getCell(8, j).getContents()!=""){
									
									if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(8,j).getContents()))!=null)
									{
										startTime = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
									    sheet.setSheet8(startTime);
							
								    }else {
								    	startTime = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
								    	startTime = startTime+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
										sheet.setSheet8(startTime);
								        b1 = false;
								  }
								}else {
									sheet.setSheet8(startTime);
								}
								
								if(st.getCell(9, j).getContents()!=""){
									
									if(TypeConvert.StringtoDate(DoString.nulltoEmptyString(st.getCell(9,j).getContents()))!=null)
									{
										endTime = DoString.nulltoEmptyString(st.getCell(9,j).getContents());
									    sheet.setSheet9(endTime);
							
								    }else {
								    	endTime = DoString.nulltoEmptyString(st.getCell(9,j).getContents());
								    	endTime = endTime+"（请输入相应的日期类型格式,如：2012.12.10或2012.12或2012）"+"";
										sheet.setSheet9(endTime);
								        b1 = false;
								  }
								}else {
									sheet.setSheet9(endTime);
								}
								
								if(st.getCell(10, j).getContents()!=""){
									
									remarks = DoString.nulltoEmptyString(st.getCell(10,j).getContents());
									sheet.setSheet10(remarks);
								
								}else {
									
									sheet.setSheet10(remarks);
								
								}
								if(b1){
									
									user.setUserId(userId);
									String transferId = GenerateUtils.getID();
									ScienceTechTransfer scienceTechTransfer =new ScienceTechTransfer();
									scienceTechTransfer.setCollegeIn(collegeIn);
									scienceTechTransfer.setContractAmount(contractAmount);
									if(TypeConvert.StringtoDate(endTime)!=null)
									scienceTechTransfer.setEndTime(TypeConvert.StringtoDate(endTime));
									scienceTechTransfer.setRealIncome(realIncome);
									scienceTechTransfer.setRemarks(remarks);
									if(TypeConvert.StringtoDate(startTime)!=null)
									scienceTechTransfer.setStartTime(TypeConvert.StringtoDate(startTime));
									scienceTechTransfer.setStatus(status);
									scienceTechTransfer.setSubmitUser(user);
									scienceTechTransfer.setTechName(techName);
									scienceTechTransfer.setTransfereeUnit(transfereeUnit);
									scienceTechTransfer.setTransferId(transferId);
									scienceTechTransfer.setTransformationWay(transformationWay);
									scienceTechTransfer.setUnitProperties(unitProperties);
									
									
									scienceTechTransferlist.add(scienceTechTransfer);
									
									ArrayList<ScienceTransferLeader> scienceTransferLeaders = new ArrayList<ScienceTransferLeader>();

									for(int m = 0; m < memberName.size(); m++){
										ScienceTransferLeader scienceTransferLeader = new ScienceTransferLeader();
										scienceTransferLeader.setScienceTechTransfer(scienceTechTransfer);
										scienceTransferLeader.setLeaderName(memberName.get(m));
										
										scienceTransferLeaders.add(scienceTransferLeader);
									}
								
									scienceTransferLeaderslist.add(scienceTransferLeaders);
									
									
								}else{
									
									scienceTechTransferSheet.add(sheet);
								}
								
								
								
						 }
					
							 
							 if(scienceTechTransferSheet.size()!=0){
								 
							   	 writableSheet = writableworkbook.createSheet("理工类技术转让情况表",6);
							      Label label = new Label(0,0,"所在学院");	
								  writableSheet.addCell(label);
								  
								  label = new Label(1,0,"项目/专利/技术名称");	
								  writableSheet.addCell(label);
								  
								  label = new Label(2,0,"项目负责人");	
								  writableSheet.addCell(label);
								  
								  label = new Label(3,0,"受让单位 ");	
								  writableSheet.addCell(label);
								  
								  label = new Label(4,0,"受让单位性质");	
								  writableSheet.addCell(label);
								  
								  label = new Label(5,0,"合同金额（万元）");
								  writableSheet.addCell(label);
								  
								  label = new Label(6,0,"当年实际收入（万元）"	);
								  writableSheet.addCell(label);
								  
								  label = new Label(7,0,"成果转化方式");	
								  writableSheet.addCell(label);
								 
								  label = new Label(8,0,"转让技术研究的起始时间");	
								  writableSheet.addCell(label);
								  
								  label = new Label(9,0,"转让技术研究的终止时间");	
								  writableSheet.addCell(label);
								  
								  label = new Label(10,0,"备注");	
								  writableSheet.addCell(label);
								  
								  
								 for(int m=0;m<scienceTechTransferSheet.size();m++){
									
									 Sheet sheets = scienceTechTransferSheet.get(m);
									 
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
						 
					  
				  }else if("理工类科技交流情况表".equals(name)){
					  

						
						
							 
						for (int j = 2; j < st.getRows()&&st.getCell(1,j).getContents()!=null&&st.getCell(1,j).getContents()!=""; j++) { 
							 Sheet sheet = new Sheet();
							 b1 = true;
								
							 ArrayList<String> memberName = new ArrayList<String>();
							     String allMember = "";
								 String collegesIn = "";
								 String exchangeType = "";
								 int sendNumber = 0;
								 String sendNumberWrong;
								 int receiveNumber = 0;
								 String receiveNumberWrong;
								 int attendNumber = 0;
								 String attendNumberWrong;
								 int papersNumber = 0;
								 String papersNumberWrong;
								 int specialInvitedNumber = 0;
								 String specialInvitedNumberWrong;
								 String exchangeHost = "";
								 int status = 0;
							if(st.getCell(0, j).getContents()!=""){
								
								collegesIn = DoString.nulltoEmptyString(st.getCell(0,j).getContents());
								sheet.setSheet0(collegesIn);
						 	
							}else {
								
							    sheet.setSheet0(collegesIn);
							
							}
							
							if(st.getCell(1, j).getContents()!=""){
								
								exchangeType = DoString.nulltoEmptyString(st.getCell(1,j).getContents());
								sheet.setSheet1(exchangeType);
							
							}else {
								exchangeType="请输入参与形式";
								sheet.setSheet1(exchangeType);
								b1 =false;
							}

						
							
							if(st.getCell(2, j).getContents()!=""){
								
								if(TypeConvert.StringIsInt(st.getCell(2, j).getContents())){
									
									sendNumber = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(2,j).getContents()));
									sheet.setSheet2(sendNumber+"");
								}else {
									
									sendNumberWrong = sendNumber+"（请输入相应的整形数值）"+"";
									sheet.setSheet2(sendNumberWrong);
									b1 = false;
								}
								
							}
							
							if(st.getCell(3, j).getContents()!=""){
								
								if(TypeConvert.StringIsInt(st.getCell(3, j).getContents())){
									
									receiveNumber = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(3,j).getContents()));
									sheet.setSheet3(receiveNumber+"");
								}else {
									
									receiveNumberWrong = receiveNumber+"（请输入相应的整形数值）"+"";
									sheet.setSheet3(receiveNumberWrong);
									b1 = false;
								}
								
							}
							
							if(st.getCell(4, j).getContents()!=""){
								
								if(TypeConvert.StringIsInt(st.getCell(4, j).getContents())){
									
									attendNumber = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(4,j).getContents()));
									sheet.setSheet4(attendNumber+"");
								}else {
									
									attendNumberWrong = attendNumber+"（请输入相应的整形数值）"+"";
									sheet.setSheet4(attendNumberWrong);
									b1 = false;
								}
								
							}
							
							
							if(st.getCell(5, j).getContents()!=""){
								
								if(TypeConvert.StringIsInt(st.getCell(5, j).getContents())){
									
									papersNumber = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(5,j).getContents()));
									sheet.setSheet5(papersNumber+"");
								}else {
									
									papersNumberWrong = papersNumber+"（请输入相应的整形数值）"+"";
									sheet.setSheet5(papersNumberWrong);
									b1 = false;
								}
								
							}
							
							
							if(st.getCell(6, j).getContents()!=""){
								
								if(TypeConvert.StringIsInt(st.getCell(6, j).getContents())){
									
									specialInvitedNumber = Integer.parseInt(DoString.nulltoEmptyString(st.getCell(6,j).getContents()));
									sheet.setSheet6(specialInvitedNumber+"");
								}else {
									
									specialInvitedNumberWrong = specialInvitedNumber+"（请输入相应的整形数值）"+"";
									sheet.setSheet6(specialInvitedNumberWrong);
									b1 = false;
								}
								
							}
							
							if(st.getCell(7, j).getContents()!=""){
								
								exchangeHost = DoString.nulltoEmptyString(st.getCell(7,j).getContents());
								sheet.setSheet7(exchangeHost);
						 	
							}else {
								
							    sheet.setSheet7(exchangeHost);
							
							}
							
							
							if(st.getCell(8, j).getContents()!=""){
								
								allMember = DoString.nulltoEmptyString(st.getCell(8,j).getContents());
							    memberName = TypeConvert.getNames(allMember);
									for(int m = 0; m < memberName.size(); m++){
										
										if(memberName.get(m)==null||memberName.get(m).length()<=1){
												
											    b1 = false;
										}
									}
								if(!b1){
									allMember = allMember + "(没有输入负责人名字或则在某个人的名字中间出项了空格)";
								}
								sheet.setSheet8(allMember);
						
							}else {
								allMember = allMember + "(请输入发明人姓名)";
								sheet.setSheet8(allMember);
								b1 = false;
							}
								
							if(b1){
								
								
								user.setUserId(userId);
								String techExchangeId = GenerateUtils.getID();
								ScienceTechExchange scienceTechExchange =new ScienceTechExchange();
								scienceTechExchange.setAttendNumber(attendNumber);
								scienceTechExchange.setCollegesIn(collegesIn);
								scienceTechExchange.setExchangeHost(exchangeHost);
								scienceTechExchange.setExchangeType(exchangeType);
								scienceTechExchange.setPapersNumber(papersNumber);
								scienceTechExchange.setReceiveNumber(receiveNumber);
								scienceTechExchange.setSendNumber(sendNumber);
								scienceTechExchange.setSpecialInvitedNumber(specialInvitedNumber);
								scienceTechExchange.setStatus(status);
								scienceTechExchange.setSubmitUser(user);
								scienceTechExchange.setTechExchangeId(techExchangeId);
								
								scienceTechExchangelist.add(scienceTechExchange);
								
								
								ArrayList<ScienceTechAttendPerson> scienceTechAttendPersons = new ArrayList<ScienceTechAttendPerson>();

								for(int m = 0; m < memberName.size(); m++){
									ScienceTechAttendPerson scienceTechAttendPerson = new ScienceTechAttendPerson();
									scienceTechAttendPerson.setScienceTechExchange(scienceTechExchange);
									scienceTechAttendPerson.setMemberName(memberName.get(m));
									
									scienceTechAttendPersons.add(scienceTechAttendPerson);
								}
							
								scienceTechAttendPersonslist.add(scienceTechAttendPersons);
							    
							}else{
								b1 = true;
								scienceTechExchangeSheet.add(sheet);
							}	
						}
			    	  
						if(scienceTechExchangeSheet.size()!=0){
							 
						   	 writableSheet = writableworkbook.createSheet("理工类科技交流情况表",7);
						      Label label = new Label(0,0,"所在部门");	
							  writableSheet.addCell(label);
							  
							  label = new Label(1,0,"形式");	
							  writableSheet.addCell(label);
							  
							  label = new Label(2,0,"派遣人数");	
							  writableSheet.addCell(label);
							  
							  label = new Label(3,0,"接受人数 ");	
							  writableSheet.addCell(label);
							  
							  label = new Label(4,0,"出席人数");	
							  writableSheet.addCell(label);
							  
							  label = new Label(5,0,"交流论文篇数");
							  writableSheet.addCell(label);
							  
							  label = new Label(6,0,"特邀报告篇数"	);
							  writableSheet.addCell(label);
							  
							  label = new Label(7,0,"主   办");	
							  writableSheet.addCell(label);
							 
							  
							  
							 for(int m=0;m<scienceTechExchangeSheet.size();m++){
								
								 Sheet sheets = scienceTechExchangeSheet.get(m);
								 
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
				
				if(ScienceOrganizationlists!=null){
					
					
					for(int i=0;i<ScienceOrganizationlists.size();i++){
						
						ScienceOrganization scienceOrganization = ScienceOrganizationlists.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(scienceOrganization);
					    if(!result1){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(ScienceTechProjectlists!=null){
					
					
					for(int i=0;i<ScienceTechProjectlists.size();i++){
						ScienceTechProject scienceTechProject = ScienceTechProjectlists.get(i);
						ScienceDetailTechProject scienceDetailTechProject  = ScienceDetailTechProjectlists.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<ScienceTechProjectMember> scienceTechProjectMembers = ScienceTechProjectMemberlists.get(i);
					    boolean result1 = submitInfoAndProofsService.submitInfo(scienceTechProject);//插入数据库的操作
					    boolean result2 = submitInfoAndProofsService.submitInfo(scienceDetailTechProject);
					    boolean result3 = submitInfoAndProofsService.submitResearchMemberInfo(2, scienceTechProjectMembers);
					    if(!(result1 || result3)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(scienceBooklist!=null){
					
					
					for(int i=0;i<scienceBooklist.size();i++){
						
						ScienceBook scienceBook = scienceBooklist.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<ScienceBookAuthor> scienceBookAuthors = scienceBookAuthorlist.get(i);
				    	boolean result3 = submitInfoAndProofsService.submitInfo(scienceBook);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(3, scienceBookAuthors);
					    if(!(result2 || result3)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(sciencePaperlist!=null){
					
					
					for(int i=0;i<sciencePaperlist.size();i++){
						
						SciencePaper sciencePaper = sciencePaperlist.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<SciencePaperAuthor> sciencePaperAuthors = sciencePaperAuthorlist.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(sciencePaper);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(1, sciencePaperAuthors);
					    if(!(result2 || result1)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(scienceGovernmentAwardlist!=null){
					
					
					for(int i=0;i<scienceGovernmentAwardlist.size();i++){
						
						ScienceGovernmentAward scienceGovernmentAward = scienceGovernmentAwardlist.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<ScienceGovAwardPerson> scienceGovAwardPersons = ScienceGovAwardPersonslist.get(i);
						
						boolean result3 = submitInfoAndProofsService.submitInfo(scienceGovernmentAward);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(4, scienceGovAwardPersons);
					    if(!(result2 || result3)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(scienceIpRightslist!=null){
					
					
					for(int i=0;i<scienceIpRightslist.size();i++){
						
						ScienceIpRights scienceIpRights = scienceIpRightslist.get(i);
						@SuppressWarnings("unchecked")
						ArrayList<ScienceInventors> scienceInventors = scienceInventorslist.get(i);
						
						boolean result1 = submitInfoAndProofsService.submitInfo(scienceIpRights);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(5, scienceInventors);
					    if(!(result2 || result1)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				

				if(scienceTechTransferlist!=null){
					
					
					for(int i=0;i<scienceTechTransferlist.size();i++){
						@SuppressWarnings("unchecked")
						ArrayList<ScienceTransferLeader> scienceTransferLeaders = scienceTransferLeaderslist.get(i);
						ScienceTechTransfer scienceTechTransfer = scienceTechTransferlist.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(scienceTechTransfer);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(18, scienceTransferLeaders);

					    if(!(result1&&result2)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				
				if(scienceTechExchangelist!=null){
					
					
					for(int i=0;i<scienceTechExchangelist.size();i++){
						@SuppressWarnings("unchecked")
						ArrayList<ScienceTechAttendPerson> scienceTechAttendPersons = scienceTechAttendPersonslist.get(i);
						ScienceTechExchange scienceTechExchange = scienceTechExchangelist.get(i);
						boolean result1 = submitInfoAndProofsService.submitInfo(scienceTechExchange);
						boolean result2 = submitInfoAndProofsService.submitResearchMemberInfo(6, scienceTechAttendPersons);
					    if(!(result1&&result2)){
					    	
					    	return "ERR";
					    }
					}
					
				}
				//插入数据库的操作
				wb.close();// 关闭工作薄
				
				if(writableworkbook==null&&scienceTechExchangelist==null
						&&scienceTechTransferlist==null&&scienceIpRightslist==null
						&&scienceGovernmentAwardlist==null&&sciencePaperlist==null
						&&scienceBooklist==null&&ScienceTechProjectlists==null&&
						ScienceOrganizationlists==null){
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
				
			} catch (Exception e) {
				e.printStackTrace();
				return "ERR";
			}
		}
		return "ALLSUC";
	}

}
