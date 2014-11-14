package com.cqupt.mis.rms.action.teacher;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.service.DownLoadExcelInfobyFactorService;
import com.cqupt.mis.rms.utils.DynamicDataFieldUtils;
import com.cqupt.mis.rms.utils.ExcelTemplate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DownLoadExcelInfobyFactorAction extends ActionSupport{
	
	private DownLoadExcelInfobyFactorService downLoadExcelInfobyFactorService;
	private String factorName;
	private String factorValue;
	private String fileShowName;
	

	
	public String getFileShowName() {
		return fileShowName;
	}

	public void setFileShowName(String fileShowName) {
		this.fileShowName = fileShowName;
	}
	public void setDownLoadExcelInfobyFactorService(
			DownLoadExcelInfobyFactorService downLoadExcelInfobyFactorService) {
		this.downLoadExcelInfobyFactorService = downLoadExcelInfobyFactorService;
	}
	
	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public String getfactorValue() {
		return factorValue;
	}

	public void setfactorValue(String factorValue) {
		this.factorValue = factorValue;
	}
	
    public InputStream getInputStream() throws Exception{
		
	    
		return ServletActionContext.getServletContext().getResourceAsStream("download.xls");
	}
    
    public String downloadCourseContributeExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelCourseContributeInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=CourseContribute_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadMajorContributeExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelMajorContributeInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=MajorContribute_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadStudentAwardsExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelStudentAwardsInfo(factorName,factorValue,userId);
		response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=StudentAwards_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadTeachingMaterialSetExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelTeachingMaterialSetInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=TeachingMaterialSet_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadTeachAchievementsExcel(){
		HttpServletResponse response = ServletActionContext.getResponse(); 
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelTeachAchievementsInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=TeachAchievements_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	
	
	
	public String downloadHumanitiesAcademicMeetingExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelHumanitiesAcademicMeetingInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=HumanitiesAcademicMeeting_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadHumanitiesBookExcel(){
		HttpServletResponse response = ServletActionContext.getResponse(); 
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelHumanitiesBookInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=HumanitiesBook_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadHumanitiesExchangePaperExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelHumanitiesExchangePaperInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ExchangePaper_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadHumanitiesPaperExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelHumanitiesPaperInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=HumanitiesPaper_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadHumanitiesProjectExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelHumanitiesProjectInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=HumanitiesProject_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}

	
	public String downloadHumanitiesResearchRewardExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelHumanitiesResearchRewardInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=HumanitiesResearchReward_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadScienceBookExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelScienceBookInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ScienceBook_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadScienceGovernmentAwardExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelScienceGovernmentAwardInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ScienceGovernmentAward_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadScienceIpRightsExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelScienceIpRightsInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ScienceIpRights_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadScienceOrganizationExcel(){
		HttpServletResponse response = ServletActionContext.getResponse(); 
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelScienceOrganizationInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ScienceOrganization_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadSciencePaperExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelSciencePaperInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=SciencePaper_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadScienceTechTransferExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelScienceTechTransferInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ScienceTechTransfer_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadScienceTechProjectExcel(){
		HttpServletResponse response = ServletActionContext.getResponse(); 
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelScienceTechProjectInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ScienceTechProject_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	public String downloadScienceTechExchangeExcel(){
		HttpServletResponse response = ServletActionContext.getResponse(); 
		String userId = (String)ActionContext.getContext().getSession().get("userId");

		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelScienceTechExchangeInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ScienceTechExchange_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}


	/****************2013-8-14  HuangHaiYan add*************************/
	
	//发表教改论文
	public String downloadTeachAchievementsNewExcel(){
		HttpServletResponse response = ServletActionContext.getResponse(); 

		String userId = (String)ActionContext.getContext().getSession().get("userId");

		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelTeachAchievementsNewInfo(factorName,factorValue,userId);
		response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ReformPapers_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}

	//本科教学工程
	public String downloadCourseContributeNewExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelCourseContributeNewInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=TeachingProject_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	//教改项目
	public String downloadMajorContributeNewExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelMajorContributeNewInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=ReformProject_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
   //指导学生获获奖
	public String downloadStudentAwardsNewExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelStudentAwardsNewInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=GuidingStudents_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	//教材出版
	public String downloadTeachingMaterialSetNewExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelTeachingMaterialSetNewInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=TextbookPublishing_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	//重庆市大学生创新创业训练计划项目
	public String downloadTeachAchievementsCQExcel(){
		HttpServletResponse response = ServletActionContext.getResponse(); 
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelTeachAchievementsCQInfo(factorName,factorValue,userId);
		 response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename=TrainingProgram_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	/**
	 * 导出动态字段记录类的excel
	 * @return
	 */
	public String downloadDynamicDataRecordExcel(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();  
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		int classNum = Integer.valueOf(request.getParameter("classNum"));
		String recordName = DynamicDataFieldUtils.getRecordNameByClassNum(classNum);
		ExcelTemplate template = null;
		try {
			template = (ExcelTemplate) downLoadExcelInfobyFactorService.getExcelDyanmicDataRecordInfo(factorName, factorValue, userId, classNum);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		if(template == null) {
			return ERROR;
		}
		response.reset();  
        response.setContentType("application/x-download;charset=GBK");  
        response.setHeader("Content-Disposition", "attachment;filename="+recordName+"_"+System.currentTimeMillis()+".xls");  
        try {  
            template.getWorkbook().write(response.getOutputStream());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		return SUCCESS;
		
	}
	
	
	
}
