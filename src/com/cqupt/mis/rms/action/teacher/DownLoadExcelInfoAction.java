package com.cqupt.mis.rms.action.teacher;


import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.service.DownLoadExcelInfoService;
import com.cqupt.mis.rms.utils.ExcelTemplate;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DownLoadExcelInfoAction extends ActionSupport{
	
	private DownLoadExcelInfoService downLoadExcelInfoService;
	private  String fileShowName;
	
	public String getFileShowName() {
		return fileShowName;
	}

	public void setFileShowName(String fileShowName) {
		this.fileShowName = fileShowName;
	}

	public DownLoadExcelInfoService getDownLoadExcelInfoService() {
		return downLoadExcelInfoService;
	}

	public void setDownLoadExcelInfoService(
			DownLoadExcelInfoService downLoadExcelInfoService) {
		this.downLoadExcelInfoService = downLoadExcelInfoService;
	}
	
    public InputStream getInputStream() throws Exception{
		
	    
		return ServletActionContext.getServletContext().getResourceAsStream("download.xls");
	}
	    
    public String downloadCourseContributeExcel(){
		HttpServletResponse response = ServletActionContext.getResponse();  
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelCourseContributeInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelMajorContributeInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelStudentAwardsInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelTeachingMaterialSetInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelTeachAchievementsInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesAcademicMeetingInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesBookInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesExchangePaperInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesPaperInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesProjectInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelHumanitiesResearchRewardInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceBookInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceGovernmentAwardInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceIpRightsInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceOrganizationInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelSciencePaperInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceTechTransferInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceTechProjectInfo();
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
		 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelScienceTechExchangeInfo();
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

/**************************************************/
	//本科教学工程 
	public String downloadCourseContributeNewExcel(){
			HttpServletResponse response = ServletActionContext.getResponse();  
			 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelCourseContributeNewInfo();
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
			 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelMajorContributeNewInfo();
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
		//指导学生参赛获奖
		public String downloadStudentAwardsNewExcel(){
			HttpServletResponse response = ServletActionContext.getResponse();  
			 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelStudentAwardsNewInfo();
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
			 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelTeachingMaterialSetNewInfo();
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
		
		//发表教改论文  
		public String downloadTeachAchievementsNewExcel(){
			HttpServletResponse response = ServletActionContext.getResponse();  
			 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelTeachAchievementsNewInfo();
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
		
		//重庆市大学生创新创业训练计划
		public String downloadTeachAchievementsCQExcel(){
			HttpServletResponse response = ServletActionContext.getResponse();  
			 ExcelTemplate template = (ExcelTemplate) downLoadExcelInfoService.getExcelTeachAchievementsCQInfo();
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
}
