package com.cqupt.mis.rms.service.impl;

import java.util.List;

import com.cqupt.mis.rms.model.CourseContribute;
import com.cqupt.mis.rms.model.CourseContributeMember;
import com.cqupt.mis.rms.model.CourseContributeNew;
import com.cqupt.mis.rms.model.CourseContributeMemberNew;
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
import com.cqupt.mis.rms.model.MajorContribute;
import com.cqupt.mis.rms.model.MajorContributeMember;
import com.cqupt.mis.rms.model.MajorContributeNew;
import com.cqupt.mis.rms.model.MajorContributeMemberNew;
import com.cqupt.mis.rms.model.Proofs;
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
import com.cqupt.mis.rms.model.StudentAwards;
import com.cqupt.mis.rms.model.StudentAwardsNew;
import com.cqupt.mis.rms.model.StudentInstructor;
import com.cqupt.mis.rms.model.StudentInstructorNew;
import com.cqupt.mis.rms.model.TeachAchievements;
import com.cqupt.mis.rms.model.TeachAchievementsCQ;
import com.cqupt.mis.rms.model.TeachAchievementsDeclarant;
import com.cqupt.mis.rms.model.TeachAchievementsNew;
import com.cqupt.mis.rms.model.TeachersAwards;
import com.cqupt.mis.rms.model.TeachersAwardsNew;
import com.cqupt.mis.rms.model.TeachingMaterialEditor;
import com.cqupt.mis.rms.model.TeachingMaterialEditorNew;
import com.cqupt.mis.rms.model.TeachingMaterialSet;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.cqupt.mis.rms.service.DownLoadExcelInfobyFactorService;
import com.cqupt.mis.rms.service.GetDownloadInfoService;
import com.cqupt.mis.rms.utils.ExcelTemplate;

public class DownLoadExcelInfobyFactorServiceImpl implements DownLoadExcelInfobyFactorService{

	
	private GetDownloadInfoService getDownloadInfoService;
	
	public void setGetDownloadInfoService(
			GetDownloadInfoService getDownloadInfoService) {
		this.getDownloadInfoService = getDownloadInfoService;
	}
	
	@Override
	public ExcelTemplate getExcelCourseContributeNewInfo(String factorName,String factorValues ,String userId) {
        
		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<CourseContributeNew> lists1 = (List<CourseContributeNew>) getDownloadInfoService.getExcelDownloadInfoByFactors("CourseContributeNew",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("本科教学工程ID");
		template.createCell("项目级别");
		template.createCell("项目类别");
		template.createCell("项目名称");
		template.createCell("立项时间");
		template.createCell("负责人");
		template.createCell("其他负责人");
		template.createCell("申报人排名");
		template.createCell("项目来源");
		template.createCell("结题时间");
		template.createCell("奖励金额");
		template.createCell("备注");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		for(int i=0;i<lists1.size();i++){
			CourseContributeNew courseContribute = lists1.get(i);
			String courseId = courseContribute.getCourseId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
             //本科教学工程ID
			 template.createCell(courseContribute.getCourseId());
			 
			 //立项级别
			 String classContribute = courseContribute.getClassContribute();
			 if(classContribute==""){
				 
				 classContribute="无"; 
			 }
			 template.createCell(classContribute);
			 
			 //立项类别
			 String typeContribute = courseContribute.getTypeContribute();
             if(typeContribute==""){
				 
            	 typeContribute="无"; 
			 }
			 template.createCell(typeContribute);
			 
			 
			 
			 //本科教学工程名称
			 String courseName = courseContribute.getCourseName();
             if(courseName==""){
				 
            	 courseName="无"; 
			 }
			 template.createCell(courseName);
			 
			//立项时间
			 String checkTime ="";
		
			 if(courseContribute.getCheckTime()!=null)
				 checkTime = courseContribute.getCheckTime().toString();
			 if(checkTime=="")
			 {
			 
				 checkTime="无"; 
			 }
			 template.createCell(checkTime);
			 
			 @SuppressWarnings("unchecked")
				List<CourseContributeMemberNew> lists2 = (List<CourseContributeMemberNew>) getDownloadInfoService.getExcelDownloadInfoByFactor("CourseContributeMemberNew", "courseContributeNew.courseId", courseId);
				 //其他负责人
			 	 String other = "";
			 	 //主要负责人
				 String MemberName = "";
				
				 for(int j=0;j<lists2.size();j++){
					 CourseContributeMemberNew courseContributeMember= lists2.get(j);
					
					
					 if(courseContributeMember.getOrders()==1){
						//主要负责人
						 MemberName = courseContributeMember.getMemberName();
						 
					 }else{
						 //其他负责人
						 other = other + courseContributeMember.getMemberName()+"、";
					 
					 }
				 }
				 
				 if(MemberName==""){
					 template.createCell("无");
				 }else{
					 template.createCell(MemberName);
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
					 template.createCell(other);
				 }
				
				 
				 //申报人排名
				 String applicantRanking = courseContribute.getApplicantRanking();
	             if(applicantRanking==""){
					 
	            	 applicantRanking="无"; 
				 }
				 template.createCell(applicantRanking);
				 
				 //项目来源
				 String timeContribute = courseContribute.getTimeContribute();
	             if(timeContribute==""){
					 
	            	 timeContribute="无"; 
				 }
				 template.createCell(timeContribute);
				 
				//结题时间
				 String endTime ="";
				 if(courseContribute.getEndTime()!=null)
				  endTime = courseContribute.getEndTime().toString();
	             if(endTime==""){
					 
	            	 endTime="无"; 
				 }
				 template.createCell(endTime);
				 
				 
				
				 
			 //学院奖励
			 String collegeAward = "";
			 if(courseContribute.getCollegeAward()!=null)
			  collegeAward = courseContribute.getCollegeAward().toString();
             if(collegeAward==""){
				 
            	 collegeAward="无"; 
			 }
			 template.createCell(collegeAward);	 
			
			
			
			 
			 //备注
			 String remarks = courseContribute.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
			
			 
			
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(courseContribute.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = courseContribute.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser ="";
             if(courseContribute.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = courseContribute.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = courseContribute.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = courseContribute.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			 
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", courseId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
			
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelMajorContributeNewInfo(String factorName,String factorValues,String userId) {
		
		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<MajorContributeNew> lists1 = (List<MajorContributeNew>) getDownloadInfoService.getExcelDownloadInfoByFactors("MajorContributeNew",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("专业建设ID");
		template.createCell("项目级别");
		template.createCell("项目类别");
		template.createCell("项目名称");
		template.createCell("负责人");
		template.createCell("其他参与人");
		template.createCell("申报时间");
		template.createCell("立项时间");
		template.createCell("结项时间");
		template.createCell("项目来源");
		template.createCell("申报金额");
		template.createCell("备注");
		template.createCell("奖励金额");
		
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			MajorContributeNew majorContribute = lists1.get(i);
			String majorId = majorContribute.getMajorId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 
			 //专业建设ID
			 template.createCell(majorContribute.getMajorId());
			 
			 //立项级别
			 String classContribute = majorContribute.getClassContribute();
			 if(classContribute==""){
				 
				 classContribute="无"; 
			 }
			 template.createCell(classContribute);
			 
			 //立项类别
			 String typeContribute = majorContribute.getTypeContribute();
             if(typeContribute==""){
				 
            	 typeContribute="无"; 
			 }
			 template.createCell(typeContribute);
			 
			 //专业名称
			 String majorName = majorContribute.getMajorName();
             if(majorName==""){
				 
            	 majorName="无"; 
			 }
             @SuppressWarnings("unchecked")
	 			List<MajorContributeMemberNew> lists2 = (List<MajorContributeMemberNew>) getDownloadInfoService.getExcelDownloadInfoByFactor("MajorContributeMemberNew", "majorContributeNew.majorId", majorId);
	 			//其他负责人 
			    String other = "";
			    //主要负责人
			    String MemberName = "";
	 			 
	 			
	 			 for(int j=0;j<lists2.size();j++){
	 				 MajorContributeMemberNew majorContributeMember= lists2.get(j);
	 				
	 				
	 				 if(majorContributeMember.getOrders()==1){
	 					 //主要负责人
	 					MemberName = majorContributeMember.getMemberName();
	 					 
	 				 }else{
	 					 //其他负责人
	 					 other = other + majorContributeMember.getMemberName()+"、";
	 				 
	 				 }
	 			 }
	 			
				 
				if(MemberName==""){
					template.createCell("无");
				}else{
					template.createCell(MemberName);
				}
	 			 
	 			 if(other==""){
	 				 
	 				other = "无"; 
	 				template.createCell(other);
	 			 }else{
		 			other = other.substring(0,other.length()-1);
		 			template.createCell(other);
	 			 }
	 			
 			//年度检查时间
			 String checkTime ="";
			 if(majorContribute.getCheckTime()!=null)
			  checkTime = majorContribute.getCheckTime().toString();
             if(checkTime==""){
				 
            	 checkTime="无"; 
			 }
             template.createCell(checkTime);
			 //立项时间
			 String timeContribute = majorContribute.getTimeContribute();
             if(timeContribute==""){
				 
            	 timeContribute="无"; 
			 }
			 template.createCell(timeContribute);
			 
			 
			 template.createCell(majorName);
			 
			 
	 			
			 
			 
             //结题时间
             String endTime = "";
			 if(majorContribute.getEndTime()!=null)
			  endTime = majorContribute.getEndTime().toString();
             if(endTime==""){
				 
            	 endTime="无"; 
			 }
			 template.createCell(endTime);
			 
			 //项目来源
			 String projectSource = majorContribute.getProjectSource();
             if(projectSource==""){
				 
            	 projectSource="无"; 
			 }
			 template.createCell(projectSource);
			 
			 //申报金额
			 String reportedAmounts = majorContribute.getReportedAmounts().toString();
			 if(reportedAmounts=="")
			 {
				 reportedAmounts = 0+"";
			 }
			 template.createCell(reportedAmounts);
			 
			 //备注
			 String remarks = majorContribute.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
			 
			 //学院奖励
			 String collegeAward ="";
			 if(majorContribute.getRewardCollege()!=null)
			  collegeAward = majorContribute.getRewardCollege().toString();
             if(collegeAward==""){
				 
            	 collegeAward="无"; 
			 }
			 template.createCell(collegeAward);
			 
			
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(majorContribute.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = majorContribute.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(majorContribute.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = majorContribute.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = majorContribute.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = majorContribute.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", majorId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelStudentAwardsNewInfo(String factorName,String factorValues,String userId) {
		
		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<StudentAwardsNew> lists1 = (List<StudentAwardsNew>) getDownloadInfoService.getExcelDownloadInfoByFactors("StudentAwardsNew",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("获奖ID");
		template.createCell("赛事名称");
		template.createCell("颁奖单位");
		template.createCell("获奖级别");
		template.createCell("获奖时间");
		template.createCell("学生团队成员");
		template.createCell("排名第一的学生姓名");
		template.createCell("指导教师");
		template.createCell("备注");
		template.createCell("奖励金额");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			StudentAwardsNew studentAwards = lists1.get(i);
			String awardsId = studentAwards.getAwardsId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 
			 //获奖ID
			 template.createCell(studentAwards.getAwardsId());
			 
			//赛事名称
			 String rewardName = studentAwards.getRewardName();
             if(rewardName==""){
				 
            	 rewardName="无"; 
			 }
			 template.createCell(rewardName);
			 
			//颁奖单位
			 String rewardUnit = studentAwards.getRewardUnit();
             if(rewardUnit==""){
				 
            	 rewardUnit="无"; 
			 }
			 template.createCell(rewardUnit);
			 
			//获奖级别
			 String rewardLevel = studentAwards.getRewardLevel();
             if(rewardLevel==""){
				 
            	 rewardLevel="无"; 
			 }
			 template.createCell(rewardLevel);
			 
			//获奖时间
			 String rewardTime = studentAwards.getRewardTime();
			 if(rewardTime==""){
				 
				 rewardTime="无"; 
			 }
			 template.createCell(rewardTime);
			 
			//学生团队成员
			 String rewardStudents = studentAwards.getRewardStudents();
             if(rewardStudents==""){
				 
            	 rewardStudents="无"; 
			 }
			 template.createCell(rewardStudents);
			 
			//排名第一的学生姓名
			 String firstStudents = studentAwards.getFirstStudents();
             if(firstStudents==""){
				 
            	 firstStudents="无"; 
			 }
			 template.createCell(firstStudents );
			 
			 
			 
			 
			 //指导老师
			 @SuppressWarnings("unchecked")
				List<StudentInstructorNew> lists2 = (List<StudentInstructorNew>) getDownloadInfoService.getExcelDownloadInfoByFactor("StudentInstructorNew", "studentAwardsNew.awardsId", awardsId);
				 String other = "";
				 for(int j=0;j<lists2.size();j++){
					 StudentInstructorNew studentInstructor= lists2.get(j);
					
					 other = other + studentInstructor.getMemberName()+"、";
					 
					
				 }
				 
				 
				 
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
					 template.createCell(other);
				 }
				
				 
			//备注
			 String remarks = studentAwards.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
				 
			//奖励金额
			 String collegeAward = studentAwards.getCollegeAward().toString();
             if(collegeAward==""){
				 
            	 collegeAward="无"; 
			 }
			 template.createCell(collegeAward);
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(studentAwards.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = studentAwards.getSubmitUser().getUserName(); 
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = studentAwards.getApprovedUser().getUserName();
             if(studentAwards.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = studentAwards.getApprovedUser().getUserName(); 
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = studentAwards.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = studentAwards.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId",awardsId );
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelTeachingMaterialSetNewInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<TeachingMaterialSetNew> lists1 = (List<TeachingMaterialSetNew>) getDownloadInfoService.getExcelDownloadInfoByFactors("TeachingMaterialSetNew",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("教材立项ID");
		template.createCell("教材等级");
		template.createCell("教材名称");
		template.createCell("作者");
		template.createCell("作者排名");
		template.createCell("类别");
		template.createCell("出版单位");
		template.createCell("出版日期");
		template.createCell("字数（千字）");
		template.createCell("备注");
		template.createCell("奖励金额");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		for(int i=0;i<lists1.size();i++){
			TeachingMaterialSetNew teachingMaterialSet = lists1.get(i);
			String teachingMaterialId = teachingMaterialSet.getTeachingMaterialId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 
			 //教材立项ID
			 template.createCell(teachingMaterialId);
			 
			 //获奖等级
			 String setClass = teachingMaterialSet.getSetClass();
			 if(setClass==""){
				 
				 setClass="无"; 
			 }
			 template.createCell(setClass);
			 //教材名称
			 String teachingMaterialName = teachingMaterialSet.getTeachingMaterialName();
             if(teachingMaterialName==""){
				 
            	 teachingMaterialName="无"; 
			 }
			 template.createCell(teachingMaterialName);
			 
			//主编/作者姓名（2012-10-31 吕海修改）
				@SuppressWarnings("unchecked")
				List<TeachingMaterialEditorNew> lists2 = (List<TeachingMaterialEditorNew>) getDownloadInfoService.getExcelDownloadInfoByFactor("TeachingMaterialEditorNew", "teachingMaterialSetNew.teachingMaterialId", teachingMaterialId);
				String other = "";
				String rank ="";
				 
				for(int j=0;j<lists2.size();j++){
					
					TeachingMaterialEditorNew teachingMaterialEditor = lists2.get(j);
					other = other + teachingMaterialEditor.getEditorName()+"、";
					rank = rank + teachingMaterialEditor.getRemarks();
					}
				
				if(other==""){
					other = "无";
					template.createCell(other);
				}else{
					other = other.substring(0,other.length()-1);
					template.createCell(other);//作者
				}
				if(rank==""){
					rank = "无";
					template.createCell(rank);
				}else{
					rank = rank.substring(0,rank.length()-1);
					template.createCell(rank);//作者排名
				}
			 
			
			//类别
			 String numberProject = teachingMaterialSet.getNumberProject();
             if(numberProject==""){
				 
            	 numberProject="无"; 
			 }
			 template.createCell(numberProject);
			 
			 //出版单位
			 String resultsPostedStatus = teachingMaterialSet.getResultsPostedStatus();
             if(resultsPostedStatus==""){
				 
            	 resultsPostedStatus="无"; 
			 }
			 template.createCell(resultsPostedStatus);
			 
			 //出版日期
			 String setTime = teachingMaterialSet.getSetTime();
             if(setTime==""){
				 
            	 setTime="无"; 
			 }
			 template.createCell(setTime);
			 
			//字数（千字）
			 String wordsNumbers = teachingMaterialSet.getWordsNumbers()+"";
             if(wordsNumbers==""){
				 
            	 wordsNumbers="无"; 
			 }
			 template.createCell(wordsNumbers);
			 
			//备注
			 String remarks = teachingMaterialSet.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
			 
			//奖励金额
			 String collegeAward = teachingMaterialSet.getCollegeAward().toString();
             if(collegeAward==""){
				 
            	 collegeAward="无"; 
			 }
			 template.createCell(collegeAward);
			 
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(teachingMaterialSet.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = teachingMaterialSet.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(teachingMaterialSet.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = teachingMaterialSet.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = teachingMaterialSet.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = teachingMaterialSet.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", teachingMaterialId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelTeachAchievementsNewInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<TeachAchievementsNew> lists1 = (List<TeachAchievementsNew>) getDownloadInfoService.getExcelDownloadInfoByFactors("TeachAchievementsNew",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("发表教改论文ID");
		template.createCell("期刊类别");
		template.createCell("期刊名称");
		template.createCell("论文名称");
		template.createCell("作者");
		template.createCell("是否为第一负责人");
		template.createCell("作者排名");
		template.createCell("出版单位");
		template.createCell("出版日期");
		template.createCell("字数");
		template.createCell("备注");
		template.createCell("奖励金额");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			TeachAchievementsNew teachAchievements = lists1.get(i);
			String achievementsId = teachAchievements.getAchievementsId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 //发表教改论文ID
			 template.createCell(teachAchievements.getAchievementsId());
			 
			 //期刊类别
			 String classAchievements = teachAchievements.getClassAchievements();
			 if(classAchievements==""){
				 
				 classAchievements="无"; 
			 }
			 template.createCell(classAchievements);
			 
			 //期刊名称
			 String levelAchievements = teachAchievements.getLevelAchievements();
             if(levelAchievements==""){
				 
            	 levelAchievements="无"; 
			 }
			 template.createCell(levelAchievements);
			 
			 //论文名称
			 String projectName = teachAchievements.getProjectName();
             if(projectName==""){
				 
            	 projectName="无"; 
			 }
			 template.createCell(projectName);
			 
			 
			 
			 
			 @SuppressWarnings("unchecked")
				List<TeachersAwardsNew> lists2 = (List<TeachersAwardsNew>) getDownloadInfoService.getExcelDownloadInfoByFactor("TeachersAwardsNew", "teachAchievementsNew.achievementsId", achievementsId);
				//其他参与人
			 	String other = "";
			 	//作者
				String MemberName = "";
				 for(int j=0;j<lists2.size();j++){
					 TeachersAwardsNew teachersAwards= lists2.get(j);
					
					
					 if(teachersAwards.getOrders()==1){
						 
						//作者
						 MemberName = teachersAwards.getMemberName();
					 }else{
						 //其他参与人
						 other = other + teachersAwards.getMemberName()+"、";
					 
					 }
				 }
				 
				 if(MemberName==""){
					 template.createCell("无");
				 }else{
					 template.createCell(MemberName);
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
						other = other.substring(0,other.length()-1);
						template.createCell(other);
				 }
				
			
				 //是否为第一负责人
				 String firstChargeMan = teachAchievements.getFirstChargeMan();
	             if(firstChargeMan == ""){
					 
	            	 firstChargeMan = "无"; 
				 }
				 template.createCell(firstChargeMan);
				 
				//作者排名
				 String authorRank = teachAchievements.getAuthorRank();
	             if(authorRank == ""){
					 
	            	 authorRank = "无"; 
				 }
				 template.createCell(authorRank);
				 
				//出版单位
				 String publisher = teachAchievements.getPublisher();
	             if(publisher == ""){
					 
	            	 publisher = "无"; 
				 }
				 template.createCell(publisher);
				 
				//出版时间
				 String timeAchievements = teachAchievements.getTimeAchievements().toString();
	             if(timeAchievements==""){
					 
	            	 timeAchievements="无"; 
				 }
				 template.createCell(timeAchievements);
			 
				 //字数
				 String wordsNumber = teachAchievements.getWordsNumber().toString();
	             if(wordsNumber == ""){
					 
	            	 wordsNumber = "无"; 
				 }
				 template.createCell(wordsNumber);
				 
				 //备注
				 String remarks = teachAchievements.getRemarks();
	             if(remarks == ""){
					 
	            	 remarks = "无"; 
				 }
				 template.createCell(remarks);
				 
				 
				 //学院奖励
				 String collegeAward = "";
				 if(teachAchievements.getCollegeAward()!=null)
				  collegeAward = teachAchievements.getCollegeAward().toString();
	             if(collegeAward==""){
					 
	            	 collegeAward="无"; 
				 }
				 template.createCell(collegeAward);
				 
				 //提交该信息的用户
				 String submitUser = "";
	             if(teachAchievements.getSubmitUser()==null){
					 
	            	 submitUser="无"; 
				 }else{
					 submitUser = teachAchievements.getSubmitUser().getUserName();
				 }
				 template.createCell(submitUser);
				 
				 //审批该信息的用户
				 String approvedUser = "";
	             if(teachAchievements.getApprovedUser()==null){
					 
	            	 approvedUser="无"; 
				 }else{
					 approvedUser = teachAchievements.getApprovedUser().getUserName();
				 }
				 template.createCell(approvedUser);
				 
				 //该信息的状态
				 int status = teachAchievements.getStatus();
				 String statusStr = "";
				 if(status==0){
					 statusStr = "该信息已保存但未提交";
				 }else if(status==1){
					 statusStr = "信息已提交";
				 }else if(status==2){
					 statusStr = "信息已审批通过";
				 }else if(status==3){
					 statusStr = "信息审批未通过";
				 }
				 template.createCell(statusStr);
				 
				 //返回原因
				 String returnReason = teachAchievements.getReturnReason();
	             if(returnReason==""){
					 
	            	 returnReason="无"; 
				 }
				 template.createCell(returnReason);
				   if("admin".equals(userId)){
						 //旁证材料
						 
						@SuppressWarnings("unchecked")
						List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", achievementsId);
						
						 for(int j=0;j<proofslists.size();j++){
							 Proofs proofs= proofslists.get(j);
							
							
							 if("".equals(proofs)){
								 
								 template.createCell("没有上传附件");
							 }else{
								 String proofsUrl = proofs.getUploadRealName();
								
								 proofsUrl = "file:///"+proofsUrl;
								 template.createCell(proofsUrl);
								 
	
							 }
						 }
					  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelHumanitiesAcademicMeetingInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<HumanitiesAcademicMeeting> lists1 = (List<HumanitiesAcademicMeeting>) getDownloadInfoService.getExcelDownloadInfoByFactors("HumanitiesAcademicMeeting",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("学术会议参会人ID");
		template.createCell("会议名称");
		template.createCell("主办单位");
		template.createCell("会议类型");
		template.createCell("举办时间");
		template.createCell("会议地点");
		template.createCell("参加人数");
		template.createCell("参会人姓名");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			template.createRow(i+1);
			template.createCell(i+1+"");
			HumanitiesAcademicMeeting humanitiesAcademicMeeting = lists1.get(i);
			
			//学术会议参会人ID
			String academicMeetingId = humanitiesAcademicMeeting.getAcademicMeetingId();
			 
			 template.createCell(academicMeetingId);
			 
			 //会议名称
			 String academicMeetingName = humanitiesAcademicMeeting.getAcademicMeetingName();
			 if(academicMeetingName==""){
				 
				 academicMeetingName="无"; 
			 }
			 template.createCell(academicMeetingName);
			 
			 //主办单位
			 String hostUnit = humanitiesAcademicMeeting.getHostUnit();
             if(hostUnit==""){
				 
            	 hostUnit="无"; 
			 }
			 template.createCell(hostUnit);
			 //会议类型
			 String MeetingType = humanitiesAcademicMeeting.getMeetingClassify();
			 if(MeetingType==""){
				 
				 MeetingType="无"; 
			 }
			 template.createCell(MeetingType);
			 
			 //举办时间
			 String  holdingTime = "";
			 if(humanitiesAcademicMeeting.getHoldingTime()!=null){
			   holdingTime= humanitiesAcademicMeeting.getHoldingTime().toString();
			 }
             if(holdingTime==""){
				 
            	 holdingTime="无"; 
			 }
			 template.createCell(holdingTime);
			 
			 //会议地点
			 String meetingLocation = humanitiesAcademicMeeting.getMeetingLocation();
             if(meetingLocation==""){
				 
            	 meetingLocation="无"; 
			 }
			 template.createCell(meetingLocation);
			 
			 //参加人数
			 String participantsNumber = humanitiesAcademicMeeting.getParticipantsNumber();
             if(participantsNumber==""){
				 
            	 participantsNumber="无"; 
			 }
			 template.createCell(participantsNumber);
			 
			 
			 //参会人姓名
			 @SuppressWarnings("unchecked")
				List<HumanitiesAcademicMeetingPerson> lists2 = (List<HumanitiesAcademicMeetingPerson>) 
				getDownloadInfoService.getExcelDownloadInfoByFactor("HumanitiesAcademicMeetingPerson", 
						"humanitiesAcademicMeeting.academicMeetingId", academicMeetingId);
				 String other = "";
				 
				 for(int j=0;j<lists2.size();j++){
					 HumanitiesAcademicMeetingPerson humanitiesAcademicMeetingPerson = lists2.get(j);
					
					
					
						 other = other + humanitiesAcademicMeetingPerson.getMeetingPersonName()+"、";
					 
					
				 }
				 
				
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
					other = other.substring(0,other.length()-1);
					template.createCell(other);
				 }
				
			
			 //提交该信息的用户
			 String submitUser = "";
             if(humanitiesAcademicMeeting.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = humanitiesAcademicMeeting.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(humanitiesAcademicMeeting.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = humanitiesAcademicMeeting.getApprovedUser().getUserName(); 
			 }
			 template.createCell(approvedUser);
			 
			 
			 //该信息的状态
			 int status = humanitiesAcademicMeeting.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = humanitiesAcademicMeeting.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", academicMeetingId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelHumanitiesBookInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<HumanitiesBook> lists1 = (List<HumanitiesBook>) getDownloadInfoService.getExcelDownloadInfoByFactors("HumanitiesBook",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("著作信息ID");
		template.createCell("成果名称");
		template.createCell("等级");
		template.createCell("出版单位");
		template.createCell("出版日期");
		template.createCell("ISBN");
		template.createCell("字数");
		template.createCell("成果所属项目");
		template.createCell("学科门类");
		template.createCell("成果引用采纳情况");
		template.createCell("著作作者姓名");
		template.createCell("其他著作作者姓名");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		for(int i=0;i<lists1.size();i++){
			HumanitiesBook humanitiesBook = lists1.get(i);
			String bookId = humanitiesBook.getBookId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 //著作信息ID
			 template.createCell(bookId);
			 
			 //成果名称
			 String bookName = humanitiesBook.getBookName();
			 if(bookName==""){
				 
				 bookName="无"; 
			 }
			 template.createCell(bookName);
			 
			 //等级
			 String grades = humanitiesBook.getGrades();
             if(grades==""){
				 
            	 grades="无"; 
			 }
			 template.createCell(grades);
			 
			 //出版单位
			 String publisher = humanitiesBook.getPublisher();
             if(publisher==""){
				 
            	 publisher="无"; 
			 }
			 template.createCell(publisher);
			 //出版日期
			 String publishedTime ="";
			 if(humanitiesBook.getPublishedTime()!=null)
			  publishedTime = humanitiesBook.getPublishedTime().toString();
             if(publishedTime==""){
				 
            	 publishedTime="无"; 
			 }
			 template.createCell(publishedTime);
			 
			
			//ISBN
			 String ISBN = humanitiesBook.getISBN();
             if(ISBN==""){
				 
            	 ISBN="无"; 
			 }
			 template.createCell(ISBN);
			 
			 //字数
			 String wordcount = humanitiesBook.getWordcount()+"";
             if(wordcount==""){
				 
            	 wordcount="无"; 
			 }
			 template.createCell(wordcount);
			 
			 //成果所属项目
			 String belongProject = humanitiesBook.getBelongProject();
             if(belongProject==""){
				 
            	 belongProject="无"; 
			 }
			 template.createCell(belongProject);
			 
			 //学科门类
			 String subjectsClassify = humanitiesBook.getSubjectsClassify();
             if(subjectsClassify==""){
				 
            	 subjectsClassify="无"; 
			 }
			 template.createCell(subjectsClassify);
			 
			 //成果引用采纳情况
			 String achievementQuote = humanitiesBook.getAchievementQuote();
             if(achievementQuote==""){
				 
            	 achievementQuote="无"; 
			 }
			 template.createCell(achievementQuote);
			
			 @SuppressWarnings("unchecked")
				List<HumanitiesBookAuthor> lists2 = (List<HumanitiesBookAuthor>) 
				getDownloadInfoService.getExcelDownloadInfoByFactor("HumanitiesBookAuthor", "humanitiesBook.bookId", bookId);
				 String other = "";
				 String AuthorName = "";
				
					 
				 for(int j=0;j<lists2.size();j++){
					 HumanitiesBookAuthor humanitiesBookAuthor= lists2.get(j);
					
					
					 if(humanitiesBookAuthor.getOrders()==1){
						 //著作作者姓名
						 AuthorName = humanitiesBookAuthor.getAuthorName();
						 
					 }else{
						 //其他著作作者姓名
						 other = other + humanitiesBookAuthor.getAuthorName()+"、";
					 
					 }
				 }
				 
				 
				 if(AuthorName==""){
					 
					 template.createCell("无");
				 }else{
					 template.createCell(AuthorName);
				 }
				
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
					 template.createCell(other);
				 }
				
			 
				//提交该信息的用户
			 String submitUser = "";
             if(humanitiesBook.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = humanitiesBook.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(humanitiesBook.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = humanitiesBook.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = humanitiesBook.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = humanitiesBook.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", bookId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelHumanitiesExchangePaperInfo(String factorName,String factorValues,String userId) {
		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<HumanitiesExchangePaper> lists1 = (List<HumanitiesExchangePaper>) getDownloadInfoService.getExcelDownloadInfoByFactors("HumanitiesExchangePaper",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("交流论文信息ID");
		template.createCell("交流论文姓名");
		template.createCell("检索情况");
		template.createCell("学科门类");
		template.createCell("发表时间");
		template.createCell("主办会议名称");
		template.createCell("交流论文主要作者姓名");
		template.createCell("交流论文其他作者姓名");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		
		for(int i=0;i<lists1.size();i++){
			HumanitiesExchangePaper humanitiesExchangePaper = lists1.get(i);
			String exchangePaperId = humanitiesExchangePaper.getExchangePaperId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 
			 //交流论文信息ID
			 template.createCell(exchangePaperId);
			 
			 //交流论文姓名
			 String exchangePaperName = humanitiesExchangePaper.getExchangePaperName();
			 if(exchangePaperName==""){
				 
				 exchangePaperName="无"; 
			 }
			 template.createCell(exchangePaperName);
			 
			 //检索情况
			 String searchStation = humanitiesExchangePaper.getSearchStation();
             if(searchStation==""){
				 
            	 searchStation="无"; 
			 }
			 template.createCell(searchStation);
			 
			 //学科门类
			 String subjectsClassify = humanitiesExchangePaper.getSubjectsClassify();
             if(subjectsClassify==""){
				 
            	 subjectsClassify="无"; 
			 }
			 template.createCell(subjectsClassify);
			 
			 //发表时间
			 String publishedTime ="";
			 if(humanitiesExchangePaper.getPublishedTime()!=null)
			  publishedTime = humanitiesExchangePaper.getPublishedTime().toString();
             if(publishedTime==""){
				 
            	 publishedTime="无"; 
			 }
			 template.createCell(publishedTime);
			 
			 //主办会议名称
			 String hostConferenceName = humanitiesExchangePaper.getHostConferenceName();
             if(hostConferenceName==""){
				 
            	 hostConferenceName="无"; 
			 }
			 template.createCell(hostConferenceName);
			 
			 @SuppressWarnings("unchecked")
				List<HumanitiesExchangePaperAuthor> lists2 = (List<HumanitiesExchangePaperAuthor>)
				getDownloadInfoService.getExcelDownloadInfoByFactor("HumanitiesExchangePaperAuthor", 
						"humanitiesExchangePaper.exchangePaperId", exchangePaperId);
			 //交流论文其他作者姓名
			 String other = "";
			 //交流论文主要作者姓名 
			 String AuthorName = "";
			 
				 for(int j=0;j<lists2.size();j++){
					 HumanitiesExchangePaperAuthor humanitiesExchangePaperAuthor= lists2.get(j);
					
					
					 if(humanitiesExchangePaperAuthor.getOrders()==1){
						 //交流论文主要作者姓名
						 AuthorName = humanitiesExchangePaperAuthor.getAuthorName();
					 }else{
						 //交流论文其他作者姓名
						 other = other + humanitiesExchangePaperAuthor.getAuthorName()+"、";
					 
					 }
				 }
				
				 if(AuthorName ==""){
					 template.createCell("无"); 
					 
				 }else{
					 template.createCell(AuthorName); 
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);

				 }else{
					other = other.substring(0,other.length()-1);
					template.createCell(other);

				 }
							 
			 //提交该信息的用户
			 String submitUser = "";
             if(humanitiesExchangePaper.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = humanitiesExchangePaper.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(humanitiesExchangePaper.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 humanitiesExchangePaper.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = humanitiesExchangePaper.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = humanitiesExchangePaper.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", exchangePaperId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelHumanitiesPaperInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<HumanitiesPaper> lists1 = (List<HumanitiesPaper>) getDownloadInfoService.getExcelDownloadInfoByFactors("HumanitiesPaper",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("论文信息ID");
		template.createCell("成果名称");
		template.createCell("出版日期/期号");
		template.createCell("发表刊物");
		template.createCell("刊物级别");
		template.createCell("检索情况");
		template.createCell("成果所属项目");
		template.createCell("成果引用采纳情况");
		template.createCell("论文主要作者姓名");
		template.createCell("论文其他作者姓名");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			HumanitiesPaper humanitiesPaper = lists1.get(i);
			String paperId = humanitiesPaper.getPaperId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 
			 //论文信息ID
			 template.createCell(paperId);
			 
			 //成果名称
			 String paperName = humanitiesPaper.getPaperName();
			 if(paperName==""){
				 
				 paperName="无"; 
			 }
			 template.createCell(paperName);
			 
			 //出版日期/期号
			 String publishedTime = humanitiesPaper.getPublishedTime();
             if(publishedTime==""){
				 
            	 publishedTime="无"; 
			 }
			 template.createCell(publishedTime);
			 
			 //发表刊物
			 String postPublication = humanitiesPaper.getPostPublication();
             if(postPublication==""){
				 
            	 postPublication="无"; 
			 }
			 template.createCell(postPublication);
			 
			 //刊物级别
			 String publishedGrades = humanitiesPaper.getPublishedGrades();
             if(publishedGrades==""){
				 
            	 publishedGrades="无"; 
			 }
			 template.createCell(publishedGrades);
			 
			 //检索情况
			 String searchStation = humanitiesPaper.getSearchStation();
             if(searchStation==""){
				 
            	 searchStation="无"; 
			 }
			 template.createCell(searchStation);
			 
			 //成果所属项目
			 String belongProject = humanitiesPaper.getBelongProject();
             if(belongProject==""){
				 
            	 belongProject="无"; 
			 }
			 template.createCell(belongProject);
			 
			 //成果引用采纳情况
			 String achievementQuote=humanitiesPaper.getAchievementQuote();
             if(achievementQuote==""){
				 
            	 achievementQuote="无"; 
			 }
			 template.createCell(achievementQuote);
			 
			 
			
			 
			 @SuppressWarnings("unchecked")
				List<HumanitiesPaperAuthor> lists2 = (List<HumanitiesPaperAuthor>) 
				getDownloadInfoService.getExcelDownloadInfoByFactor("HumanitiesPaperAuthor", "humanitiesPaper.paperId", paperId);
				//论文其他作者姓名	 
				 String other = "";
				 //论文主要作者姓名
				 String AuthorName = "";
				 
				 for(int j=0;j<lists2.size();j++){
					 HumanitiesPaperAuthor humanitiesPaperAuthor= lists2.get(j);
					
					
					 if(humanitiesPaperAuthor.getOrders()==1){
						 
						 //论文主要作者姓名
						 AuthorName = humanitiesPaperAuthor.getAuthorName();
					 }else{
						 //论文其他作者姓名
						 other = other + humanitiesPaperAuthor.getAuthorName()+"、";
					 
					 }
				 }
				 
				if(AuthorName ==""){
					template.createCell("无");
					
				}else{
					
					template.createCell(AuthorName);
				}
				 
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
					 template.createCell(other);
				 }
				
			 
			
			 //提交该信息的用户
			 String submitUser = "";
             if(humanitiesPaper.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = humanitiesPaper.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 //审批该信息的用户
			 String approvedUser = "";
             if(humanitiesPaper.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = humanitiesPaper.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = humanitiesPaper.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = humanitiesPaper.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", paperId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelHumanitiesProjectInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<HumanitiesProject> lists1 = (List<HumanitiesProject>) getDownloadInfoService.getExcelDownloadInfoByFactors("HumanitiesProject",factorName,factorValues);
	
		template.createRow(0);
		template.createCell("编号");
		template.createCell("项目ID");
		template.createCell("项目名称");
		template.createCell("项目编号");
		template.createCell("项目来源");
		template.createCell("批准时间");
		template.createCell("项目负责人员");
		template.createCell("其他项目人员");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		template.createCell("更新时间");
		template.createCell("项目状态");
		template.createCell("投入经费");
		template.createCell("每次投入研究时间");
		
		
	  int m=0;
		 
		  
		  
		for(int i=0;i<lists1.size();i++){
			HumanitiesProject humanitiesProject = lists1.get(i);
			String projectId = humanitiesProject.getProjectId();
			 template.createRow(i*m+1);
			 template.createCell(i*m+1+"");
			 //项目ID
			 template.createCell(projectId);
			 
			 //项目名称
			 String projectName = humanitiesProject.getProjectName();
			 if(projectName==""){
				 
				 projectName="无"; 
			 }
			 template.createCell(projectName);
			 
			 //项目编号
			 String projectNumber = humanitiesProject.getProjectNumber();
             if(projectNumber==""){
				 
            	 projectNumber="无"; 
			 }
			 template.createCell(projectNumber);
			 
			 //项目来源
			 String projectOrigin = humanitiesProject.getProjectOrigin();
             if(projectOrigin==""){
				 
            	 projectOrigin="无"; 
			 }
			 template.createCell(projectOrigin);
			 
			 //批准时间
			 String timeApproved = "";
			 if(humanitiesProject.getTimeApproved()!=null)
			  timeApproved = humanitiesProject.getTimeApproved().toString();
             if(timeApproved==""){
				 
            	 timeApproved="无"; 
			 }
			 template.createCell(timeApproved);
			 
			 
			 @SuppressWarnings("unchecked")
				List<HumanitiesProjectMember> lists2 = (List<HumanitiesProjectMember>) 
				getDownloadInfoService.getExcelDownloadInfoByFactor("HumanitiesProjectMember", "humanitiesProject.projectId", projectId);
				//其他项目人员
				 String other = "";
				// 项目负责人员
				 String MemberName = "";
				 
				 for(int j=0;j<lists2.size();j++){
					 HumanitiesProjectMember humanitiesProjectMember= lists2.get(j);
					
					 if(humanitiesProjectMember.getOrders()==1){
						 
						// 项目负责人员
						 MemberName = humanitiesProjectMember.getMemberName();
					 }else{
						//其他项目人员
						 other = other + humanitiesProjectMember.getMemberName()+"、";
					 
					 }
				 }
				 
				 if(MemberName ==""){
					 template.createCell("无"); 
				 }else{
					 template.createCell(MemberName); 
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
					 template.createCell(other);
				 }
			 //提交该信息的用户
			 String submitUser = "";
             if(humanitiesProject.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = humanitiesProject.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(humanitiesProject.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = humanitiesProject.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			// 该信息的状态
			 int status = humanitiesProject.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }else if(status==4){
				 statusStr = "该信息已保存但未提交（已更新）";
			 }else if(status==5){
				 statusStr = "信息已提交（已更新）";
			 }else if(status==6){
				 statusStr = "信息已审批通过（已更新）";
			 }else if(status==7){
				 statusStr = "信息审批未通过（已更新）";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = humanitiesProject.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			
		@SuppressWarnings("unchecked")
		List<HumanitiesProjectDetail> lists3 = (List<HumanitiesProjectDetail>) getDownloadInfoService.getExcelDownloadInfoByFactor("HumanitiesProjectDetail", "humanitiesProject.projectId", projectId);
		
		for(m=0;m<lists3.size();m++){
		HumanitiesProjectDetail humanitiesProjectDetail = lists3.get(m);
		
	
		
		//更新时间
		String updateTime="";
		if(humanitiesProjectDetail.getUpdateTime()!=null){
			 updateTime = humanitiesProjectDetail.getUpdateTime().toString();
		}
		if(updateTime==""){
			updateTime="无";
		}
		template.createCell(updateTime);

		//项目状态
		String projectStatus="";
		if(humanitiesProjectDetail.getProjectStatus()!=null){
			projectStatus = humanitiesProjectDetail.getProjectStatus();
		}
		if(projectStatus==""){
			projectStatus="无";
		}
		template.createCell(projectStatus);

		//投入经费
		String money="";
		if(humanitiesProjectDetail.getMoney()>=0){
			money = humanitiesProjectDetail.getMoney()+"";
		}
		if(money==""){
			money="无";
		}
		template.createCell(money);

		//每次投入研究时间
		String timePerPerson="";
		if(humanitiesProjectDetail.getTimePerPerson()!=null){
			timePerPerson = humanitiesProjectDetail.getTimePerPerson();
		}
		
		if(timePerPerson==""){
			timePerPerson="无";
		}
		template.createCell(timePerPerson);
		
		
    	}
		
		   if("admin".equals(userId)){
				 //旁证材料
				 
				@SuppressWarnings("unchecked")
				List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", projectId);
				
				 for(int j=0;j<proofslists.size();j++){
					 Proofs proofs= proofslists.get(j);
					
					
					 if("".equals(proofs)){
						 
						 template.createCell("没有上传附件");
					 }else{
						 String proofsUrl = proofs.getUploadRealName();
						 proofsUrl = "file:///"+proofsUrl;
						 template.createCell(proofsUrl);
						 

					 }
				 }
			  } 
		}
		return template;
	}
	@Override
	public ExcelTemplate getExcelHumanitiesResearchRewardInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<HumanitiesResearchReward> lists1 = (List<HumanitiesResearchReward>) getDownloadInfoService.getExcelDownloadInfoByFactors("HumanitiesResearchReward",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("科研获奖信息ID");
		template.createCell("获奖成果名称");
		template.createCell("获奖类别");
		template.createCell("获奖级别");
		template.createCell("颁发单位");
		template.createCell("获奖批准时间");
		template.createCell("获奖批准号");
		template.createCell("主要科研获奖人姓名");
		template.createCell("其他科研获奖人姓名");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			HumanitiesResearchReward humanitiesResearchReward = lists1.get(i);
			
			//科研获奖信息ID
			String researchRewardId = humanitiesResearchReward.getResearchRewardId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 //科研获奖信息ID
			 template.createCell(researchRewardId);
			 
			 //获奖成果名称
			 String researchRewardName = humanitiesResearchReward.getResearchRewardName();
			 if(researchRewardName==""){
				 
				 researchRewardName="无"; 
			 }
			 template.createCell(researchRewardName);
			 
			 //获奖类别
			 String rewardClassify = humanitiesResearchReward.getRewardClassify();
             if(rewardClassify==""){
				 
            	 rewardClassify="无"; 
			 }
			 template.createCell(rewardClassify);
			 
			 //获奖级别
			 String rewardGrades = humanitiesResearchReward.getRewardGrades();
             if(rewardGrades==""){
				 
            	 rewardGrades="无"; 
			 }
			 template.createCell(rewardGrades);
			 
			 //颁发单位
			 String issueUnit = humanitiesResearchReward.getIssueUnit();
             if(issueUnit==""){
				 
            	 issueUnit="无"; 
			 }
			 template.createCell(issueUnit);
			 
			 //获奖批准时间
			 String approveTime ="";
			 if(humanitiesResearchReward.getApproveTime()!=null)
			  approveTime = humanitiesResearchReward.getApproveTime().toString();
             if(approveTime==""){
				 
            	 approveTime="无"; 
			 }
			 template.createCell(approveTime);
			 
			 //获奖批准号
			 String approveNumber = humanitiesResearchReward.getApproveNumber();
             if(approveNumber==""){
				 
            	 approveNumber="无"; 
			 }
			 template.createCell(approveNumber);
			 
			 @SuppressWarnings("unchecked")
				List<HumanitiesResearchRewardPerson> lists2 = (List<HumanitiesResearchRewardPerson>) 
				getDownloadInfoService.getExcelDownloadInfoByFactor("HumanitiesResearchRewardPerson", "humanitiesResearchReward.researchRewardId", researchRewardId);
				
			 	//其他科研获奖人姓名
			 	String other = "";
				 
				 //主要科研获奖人姓名
			 	String RewardPersonName = "";
			 	
				 for(int j=0;j<lists2.size();j++){
					 HumanitiesResearchRewardPerson humanitiesResearchRewardPerson= lists2.get(j);
					
					
					 if(humanitiesResearchRewardPerson.getOrders()==1){
						 //主要科研获奖人姓名
						 RewardPersonName = humanitiesResearchRewardPerson.getRewardPersonName();
					 }else{
						 //其他科研获奖人姓名
						 other = other + humanitiesResearchRewardPerson.getRewardPersonName()+"、";
					 
					 }
				 }
				 
				 if(RewardPersonName==""){
					 template.createCell("无"); 
				 }else{
					 template.createCell(RewardPersonName);

				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
					 template.createCell(other);
				 }
				
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(humanitiesResearchReward.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = humanitiesResearchReward.getSubmitUser().getUserName(); 
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(humanitiesResearchReward.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = humanitiesResearchReward.getApprovedUser().getUserName(); 
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = humanitiesResearchReward.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = humanitiesResearchReward.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", researchRewardId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelScienceBookInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<ScienceBook> lists1 = (List<ScienceBook>) getDownloadInfoService.getExcelDownloadInfoByFactors("ScienceBook",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("著作ID");
		template.createCell("所在单位");
		template.createCell("出版物名称");
		template.createCell("类别");
		template.createCell("出版单位");
		template.createCell("ISBN书号");
		template.createCell("奖励等级");
		template.createCell("出版年月");
		template.createCell("总奖金额(万元)");
		template.createCell("扣减特聘岗位");
		template.createCell("实际获得奖励金额(万元)");
		template.createCell("备注");
		template.createCell("第一著作作者姓名");
		template.createCell("其他著作作者姓名");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			ScienceBook scienceBook = lists1.get(i);
			
			//著作ID
			String bookId = scienceBook.getBookId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 template.createCell(bookId);
			 
			 //所在单位
			 String unitAuthor = scienceBook.getUnitAuthor();
			 if(unitAuthor==""){
				 
				 unitAuthor="无"; 
			 }
			 template.createCell(unitAuthor);
			 
			 //出版物名称
			 String publicationName = scienceBook.getPublicationName();
             if(publicationName==""){
				 
            	 publicationName="无"; 
			 }
			 template.createCell(publicationName);
			 
			 //类别
			 String publicationType = scienceBook.getPublicationType();
             if(publicationType==""){
				 
            	 publicationType="无"; 
			 }
			 template.createCell(publicationType);
			 
			 //出版单位
			 String publisher = scienceBook.getPublisher();
             if(publisher==""){
				 
            	 publisher="无"; 
			 }
			 template.createCell(publisher);
			 
			 //ISBN书号
			 String ISBN = scienceBook.getISBN();
             if(ISBN==""){
				 
            	 ISBN="无"; 
			 }
			 template.createCell(ISBN);
			 
			 //奖励等级
			 String awardingGrades = scienceBook.getAwardingGrades();
             if(awardingGrades==""){
				 
            	 awardingGrades="无"; 
			 }
			 template.createCell(awardingGrades);
			 
			 //出版年月
			 String publishedTime ="";
			 if(scienceBook.getPublishedTime()!=null)
			  publishedTime = scienceBook.getPublishedTime().toString();
             if(publishedTime==""){
				 
            	 publishedTime="无"; 
			 }
			 template.createCell(publishedTime);
			 
			 //总奖金额(万元)
			 String totalPrize = scienceBook.getTotalPrize()+"";
             if(totalPrize==""){
				 
            	 totalPrize="无"; 
			 }
			 template.createCell(totalPrize);
			 
			 //扣减特聘岗位
			 String deductionsDistPosts = scienceBook.getDeductionsDistPosts()+"";
             if(deductionsDistPosts==""){
				 
            	 deductionsDistPosts="无"; 
			 }
			 template.createCell(deductionsDistPosts);
			
			 //实际获得奖励金额(万元)
			 String actualAward = scienceBook.getActualAward()+"";
             if(actualAward==""){
				 
            	 actualAward="无"; 
			 }
			 template.createCell(actualAward);
			 
			 //备注
			 String remarks = scienceBook.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
			 
			 @SuppressWarnings("unchecked")
				List<ScienceBookAuthor> lists2 = (List<ScienceBookAuthor>) getDownloadInfoService.getExcelDownloadInfoByFactor("ScienceBookAuthor", "scienceBook.bookId", bookId);
			 	//其他作者
			 	String other = "";
			 	//第一著作作者姓名
			 	String MemberName = "";
			 	for(int j=0;j<lists2.size();j++){
					 ScienceBookAuthor scienceBookAuthor= lists2.get(j);
					
					//第一著作作者姓名
					 if(scienceBookAuthor.getOrders()==1){
						 MemberName = scienceBookAuthor.getMemberName();
					 }else{
						//其他作者
						 other = other + scienceBookAuthor.getMemberName()+"、";
					 
					 }
				 }
				 
				 if(MemberName==""){
					 template.createCell("无"); 
				 }else{
					 template.createCell(MemberName); 
				 }
				 
				 if(other==""){
					 //其他著作作者姓名
					 other = "无"; 
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
					 template.createCell(other);
				 }
				
			 
				//提交该信息的用户
			 String submitUser = "";
             if(scienceBook.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = scienceBook.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(scienceBook.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = scienceBook.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = scienceBook.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = scienceBook.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", bookId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelScienceGovernmentAwardInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<ScienceGovernmentAward> lists1 = (List<ScienceGovernmentAward>) getDownloadInfoService.getExcelDownloadInfoByFactors("ScienceGovernmentAward",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("奖励ID");
		template.createCell("所在学院");
		template.createCell("项目名称");
		template.createCell("奖励等级");
		template.createCell("主要完成单位");
		template.createCell("配套单位奖励金额（万元）");
		template.createCell("配套个人奖励金额（万元）");
		template.createCell("合计奖励金额（万元）");
		template.createCell("科技奖主要完成人");
		template.createCell("科技奖其他完成人");
		template.createCell("备注");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			ScienceGovernmentAward scienceGovernmentAward = lists1.get(i);
			//奖励ID
			String awardId = scienceGovernmentAward.getAwardId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 template.createCell(awardId);
			 
			 //所在学院
			 String collegesIn = scienceGovernmentAward.getCollegesIn();
			 if(collegesIn==""){
				 
				 collegesIn="无"; 
			 }
			 template.createCell(collegesIn);
			 
			 //项目名称
			 String projectName = scienceGovernmentAward.getProjectName();
             if(projectName==""){
				 
            	 projectName="无"; 
			 }
			 template.createCell(projectName);
			 
			 //奖励等级
			 String awardingGrades = scienceGovernmentAward.getAwardingGrades();
             if(awardingGrades==""){
				 
            	 awardingGrades="无"; 
			 }
			 template.createCell(awardingGrades);
			 
			 //主要完成单位
			 String completeUnit = scienceGovernmentAward.getCompleteUnit();
             if(completeUnit==""){
				 
            	 completeUnit="无"; 
			 }
			 template.createCell(completeUnit);
			 
			 //配套单位奖励金额（万元）
			 String unitAward = scienceGovernmentAward.getUnitAward()+"";
             if(unitAward==""){
				 
            	 unitAward="无"; 
			 }
			 template.createCell(unitAward);
			 
			 //配套个人奖励金额（万元）
			 String personAward = scienceGovernmentAward.getPersonAward()+"";
             if(personAward==""){
				 
            	 personAward="无"; 
			 }
			 template.createCell(personAward);
			 
			 //合计奖励金额（万元）
			 String totalAward = scienceGovernmentAward.getTotalAward()+"";
             if(totalAward==""){
				 
            	 totalAward="无"; 
			 }
			 template.createCell(totalAward);
			 
			 @SuppressWarnings("unchecked")
				List<ScienceGovAwardPerson> lists2 = (List<ScienceGovAwardPerson>) getDownloadInfoService.getExcelDownloadInfoByFactor("ScienceGovAwardPerson", "scienceGovernmentAward.awardId", awardId);
				//其他完成人
			 	String other = "";
				//科技奖主要完成人
				String MemberName = "";
				 for(int j=0;j<lists2.size();j++){
					 ScienceGovAwardPerson scienceGovAwardPerson= lists2.get(j);
					
					//科技奖主要完成人
					 if(scienceGovAwardPerson.getOrders()==1){
						 MemberName =scienceGovAwardPerson.getMemberName();
					 }else{
						//其他完成人
						 other = other + scienceGovAwardPerson.getMemberName()+"、";
					 
					 }
				 }
				 
				 if(MemberName==""){
					 template.createCell("无"); 
				 }else{
					 template.createCell(MemberName); 
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
					 template.createCell(other);
				 }
				//科技奖其他完成人
				
			 
				 
				 //备注
				 String remarks = scienceGovernmentAward.getRemarks();
	             if(remarks==""){
					 
	            	 remarks="无"; 
				 }
				 template.createCell(remarks);
			
				 //提交该信息的用户
			 String submitUser = "";
             if(scienceGovernmentAward.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = scienceGovernmentAward.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(scienceGovernmentAward.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = scienceGovernmentAward.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = scienceGovernmentAward.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = scienceGovernmentAward.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", awardId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelScienceIpRightsInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<ScienceIpRights> lists1 = (List<ScienceIpRights>) getDownloadInfoService.getExcelDownloadInfoByFactors("ScienceIpRights",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("知识产权ID");
		template.createCell("所在学院");
		template.createCell("专利名称");
		template.createCell("类型");
		template.createCell("申请号/授权号");
		template.createCell("专利状态");
		template.createCell("申请日");
		template.createCell("授权公告日");
		template.createCell("奖励金额(万元)");
		template.createCell("知识产权主要发明人");
		template.createCell("知识产权其他发明人");
		template.createCell("备注");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			ScienceIpRights scienceIpRights = lists1.get(i);
			
			//知识产权ID
			String rightsId = scienceIpRights.getRightsId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 template.createCell(rightsId);
			 
			 //所在学院
			 String collegesIn = scienceIpRights.getCollegesIn();
			 if(collegesIn==""){
				 
				 collegesIn="无"; 
			 }
			 template.createCell(collegesIn);
			 
			 //专利名称
			 String patentName = scienceIpRights.getPatentName();
             if(patentName==""){
				 
            	 patentName="无"; 
			 }
			 template.createCell(patentName);
			 
			 //类型
			 String patentType = scienceIpRights.getPatentType();
             if(patentType==""){
				 
            	 patentType="无"; 
			 }
			 template.createCell(patentType);
			 
			 //申请号/授权号
			 String applicationNumber = scienceIpRights.getApplicationNumber();
             if(applicationNumber==""){
				 
            	 applicationNumber="无"; 
			 }
			 template.createCell(applicationNumber);
			 
			 //专利状态
			 String patentStatus = scienceIpRights.getPatentStatus();
             if(patentStatus==""){
				 
            	 patentStatus="无"; 
			 }
			 template.createCell(patentStatus);
			 
			 //申请日
			 String filingDate ="";
			 if(scienceIpRights.getFilingDate()!=null)
			  filingDate = scienceIpRights.getFilingDate().toString();
             if(filingDate==""){
				 
            	 filingDate="无"; 
			 }
			 template.createCell(filingDate);
			 
			 //授权公告日
			 String announcementDate = "";
			 if(scienceIpRights.getAnnouncementDate()!=null)
			  announcementDate = scienceIpRights.getAnnouncementDate().toString();;
             if(announcementDate==""){
				 
            	 announcementDate="无"; 
			 }
			 template.createCell(announcementDate);
			 
			 //奖励金额(万元)
			 String incentivePayments = scienceIpRights.getIncentivePayments()+"";
             if(incentivePayments==""){
				 
            	 incentivePayments="无"; 
			 }
			 template.createCell(incentivePayments);
			 
			 @SuppressWarnings("unchecked")
				List<ScienceInventors> lists2 = (List<ScienceInventors>) getDownloadInfoService.getExcelDownloadInfoByFactor("ScienceInventors", "scienceIpRights.rightsId", rightsId);
			    //知识产权其他发明人 
			 	String other = "";
				//知识产权主要发明人
				 String MemberName = "";
				 for(int j=0;j<lists2.size();j++){
					 ScienceInventors scienceInventors= lists2.get(j);
					
					
					 if(scienceInventors.getOrders()==1){
						 //知识产权主要发明人
						 MemberName = scienceInventors.getMemberName();
					 }else{
						 other = other + scienceInventors.getMemberName()+"、";
					 
					 }
				 }
				 
				 if(MemberName==""){
					 template.createCell("无"); 
				 }else{
					 template.createCell(MemberName);
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					//知识产权其他发明人
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
				//知识产权其他发明人
					 template.createCell(other);
				 }
				
			 
			
			 //备注
			 String remarks = scienceIpRights.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(scienceIpRights.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = scienceIpRights.getSubmitUser().getUserName(); 
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(scienceIpRights.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = scienceIpRights.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = scienceIpRights.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = scienceIpRights.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", rightsId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelScienceOrganizationInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<ScienceOrganization> lists1 = (List<ScienceOrganization>) getDownloadInfoService.getExcelDownloadInfoByFactors("ScienceOrganization",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("活动机构ID");
		template.createCell("机构名称");
		template.createCell("机构类型");
		template.createCell("机构类别");
		template.createCell("学科分类");
		template.createCell("组成形式");
		template.createCell("从业人员合计");
		template.createCell("从业人员中博士毕业人数");
		template.createCell("从业人数中硕士毕业人数");
		template.createCell("科技活动人员合计");
		template.createCell("科技活动人员中高级职称数量");
		template.createCell("中级职称数量");
		template.createCell("初级职称数量");
		template.createCell("其他数量");
		template.createCell("培养研究生（人）");
		template.createCell("当年经费内部支出（千元）");
		template.createCell("R&D支出（千元）");
		template.createCell("承担课题（项）");
		template.createCell("固定资产原值（千元）");
		template.createCell("其中仪器设备（千元）");
		template.createCell("其中进口（千元）");
		template.createCell("服务的国民经济行业");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			ScienceOrganization scienceOrganization = lists1.get(i);
			
			//活动机构ID
			String organizationId = scienceOrganization.getOrganizationId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 template.createCell(organizationId);
			 
			 //机构名称
			 String organizationName = scienceOrganization.getOrganizationName();
			 if(organizationName==""){
				 
				 organizationName="无"; 
			 }
			 template.createCell(organizationName);
			 
			 //机构类型
			 String organizationType = scienceOrganization.getOrganizationType();
             if(organizationType==""){
				 
            	 organizationType="无"; 
			 }
			 template.createCell(organizationType);
			 
			 
			 //机构类别
			 String organizationCategory = scienceOrganization.getOrganizationCategory();
             if(organizationCategory==""){
				 
            	 organizationCategory="无"; 
			 }
			 template.createCell(organizationCategory);
			 
			 //学科分类
			 String sortSubject = scienceOrganization.getSortSubject();
             if(sortSubject==""){
				 
            	 sortSubject="无"; 
			 }
			 template.createCell(sortSubject);
			
			 //组成形式
			 String modusComposition = scienceOrganization.getModusComposition();
             if(modusComposition==""){
				 
            	 modusComposition="无"; 
			 }
			 template.createCell(modusComposition);
			 
			 //从业人员合计
			 String totalEmployees = scienceOrganization.getTotalEmployees()+"";
             if(totalEmployees==""){
				 
            	 totalEmployees="无"; 
			 }
			 template.createCell(totalEmployees);
			 
			 //从业人员中博士毕业人数
			 String doctorEmployees = scienceOrganization.getDoctorEmployees()+"";
             if(doctorEmployees==""){
				 
            	 doctorEmployees="无"; 
			 }
			 template.createCell(doctorEmployees);
			 
			 //从业人数中硕士毕业人数
			 String masterEmployees = scienceOrganization.getMasterEmployees()+"";
             if(masterEmployees==""){
				 
            	 masterEmployees="无"; 
			 }
			 template.createCell(masterEmployees);
			 
			 //科技活动人员合计
			 String totalIts = scienceOrganization.getTotalIts()+"";
             if(totalIts==""){
				 
            	 totalIts="无"; 
			 }
			 template.createCell(totalIts);
			
			 //科技活动人员中高级职称数量
			 String advancedIts = scienceOrganization.getAdvancedIts()+"";
             if(advancedIts==""){
				 
            	 advancedIts="无"; 
			 }
			 template.createCell(advancedIts);
			 
			 //中级职称数量
			 String middleIts = scienceOrganization.getMiddleIts()+"";
             if(middleIts==""){
				 
            	 middleIts="无"; 
			 }
			 template.createCell(middleIts);
			 
			 //初级职称数量
			 String juniorIts = scienceOrganization.getJuniorIts()+"";
             if(juniorIts==""){
				 
            	 juniorIts="无"; 
			 }
			 template.createCell(juniorIts);
			 
			 //其他数量
			 String otherIts = scienceOrganization.getOtherIts()+"";
             if(otherIts==""){
				 
            	 otherIts="无"; 
			 }
			 template.createCell(otherIts);
			 
			 //培养研究生（人）
			 String numGraduates = scienceOrganization.getNumGraduates()+"";
             if(numGraduates==""){
				 
            	 numGraduates="无"; 
			 }
			 template.createCell(numGraduates);
			 
			 //当年经费内部支出（千元）
			 String internalExpenditures = scienceOrganization.getInternalExpenditures()+"";
             if(internalExpenditures==""){
				 
            	 internalExpenditures="无"; 
			 }
			 template.createCell(internalExpenditures);
			 
			 //R&D支出（千元）
			 String rdExpenditures = scienceOrganization.getRdExpenditures()+"";
             if(rdExpenditures==""){
				 
            	 rdExpenditures="无"; 
			 }
			 template.createCell(rdExpenditures);
			 
			 //承担课题（项）
			 String numIssueAssume = scienceOrganization.getNumIssueAssume()+"";
             if(numIssueAssume==""){
				 
            	 numIssueAssume="无"; 
			 }
			 template.createCell(numIssueAssume);
			 
			 //固定资产原值（千元）
			 String assetsFixed = scienceOrganization.getAssetsFixed()+"";
             if(assetsFixed==""){
				 
            	 assetsFixed="无"; 
			 }
			 template.createCell(assetsFixed);
			 
			 //其中仪器设备（千元）
			 String assetsEquipment = scienceOrganization.getAssetsEquipment()+"";
             if(assetsEquipment==""){
				 
            	 assetsEquipment="无"; 
			 }
			 template.createCell(assetsEquipment);
			 
			 //其中进口（千元）
			 String assetsImport = scienceOrganization.getAssetsImport()+"";
             if(assetsImport==""){
				 
            	 assetsImport="无"; 
			 }
			 template.createCell(assetsImport);
			 
			 //服务的国民经济行业
			 String industryService = scienceOrganization.getIndustryService()+"";
             if(industryService==""){
				 
            	 industryService="无"; 
			 }
			 template.createCell(industryService);
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(scienceOrganization.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = scienceOrganization.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(scienceOrganization.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = scienceOrganization.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = scienceOrganization.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = scienceOrganization.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", organizationId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelSciencePaperInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<SciencePaper> lists1 = (List<SciencePaper>) getDownloadInfoService.getExcelDownloadInfoByFactors("SciencePaper",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("论文ID");
		template.createCell("论文名称");
		template.createCell("所在学科");
		template.createCell("发表刊物(填写全称)");
		template.createCell("收录情况");
		template.createCell("出版年月");
		template.createCell("卷期号及页码");
		template.createCell("奖励等级");
		template.createCell("奖励金额(万元)");
		template.createCell("特聘岗位/教授/其他扣减");
		template.createCell("扣除后的奖励金额");
		template.createCell("论文署名单位");
		template.createCell("论文主要作者姓名");
		template.createCell("论文其他作者姓名");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			SciencePaper sciencePaper = lists1.get(i);
			
			//论文ID
			String paperId = sciencePaper.getPaperId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 template.createCell(paperId);
			 
			 //论文名称
			 String paperName = sciencePaper.getPaperName();
			 if(paperName==""){
				 
				 paperName="无"; 
			 }
			 template.createCell(paperName);
			 
			 //所在学科
			 String subjectsIn = sciencePaper.getSubjectsIn();
             if(subjectsIn==""){
				 
            	 subjectsIn="无"; 
			 }
			 template.createCell(subjectsIn);
			 
			 //发表刊物(填写全称)
			 String postPublication = sciencePaper.getPostPublication();
             if(postPublication==""){
				 
            	 postPublication="无"; 
			 }
			 template.createCell(postPublication);
			 
			 //收录情况
			 String includeSituation = sciencePaper.getIncludeSituation();
             if(includeSituation==""){
				 
            	 includeSituation="无"; 
			 }
			 template.createCell(includeSituation);
			 
			 //出版年月
			 String publishedTime = sciencePaper.getPublishedTime();
             if(publishedTime==""){
				 
            	 publishedTime="无"; 
			 }
			 template.createCell(publishedTime);
			 
			 //卷期号及页码
			 String titleNumber = sciencePaper.getTitleNumber();
             if(titleNumber==""){
				 
            	 titleNumber="无"; 
			 }
			 template.createCell(titleNumber);
			 
			 //奖励等级
			 String awardingGrades = sciencePaper.getAwardingGrades();
             if(awardingGrades==""){
				 
            	 awardingGrades="无"; 
			 }
			 template.createCell(awardingGrades);
			 
			 //奖励金额(万元)
			 String totalPrize = sciencePaper.getTotalPrize()+"";
             if(totalPrize==""){
				 
            	 totalPrize="无"; 
			 }
			 template.createCell(totalPrize);
			 
			 //特聘岗位/教授/其他扣减
			 String deductionsDistPosts = sciencePaper.getDeductionsDistPosts()+"";
             if(deductionsDistPosts==""){
				 
            	 deductionsDistPosts="无"; 
			 }
			 template.createCell(deductionsDistPosts);
			 
			 //扣除后的奖励金额
			 String actualAward = sciencePaper.getActualAward()+"";
             if(actualAward==""){
				 
            	 actualAward="无"; 
			 }
			 template.createCell(actualAward);
			 
			 //论文署名单位
			 String papersUnits = sciencePaper.getPapersUnits();
             if(papersUnits==""){
				 
            	 papersUnits="无"; 
			 }
			 template.createCell(papersUnits);
			 
			 @SuppressWarnings("unchecked")
				List<SciencePaperAuthor> lists2 = (List<SciencePaperAuthor>) 
				getDownloadInfoService.getExcelDownloadInfoByFactor("SciencePaperAuthor", "sciencePaper.paperId", paperId);
			 	//论文其他作者姓名
			 	 String other = "";
				 //论文主要作者姓名
				 String  MemberName = "";
				 for(int j=0;j<lists2.size();j++){
					 SciencePaperAuthor sciencePaperAuthor= lists2.get(j);
					
					
					 if(sciencePaperAuthor.getOrders()==1){
						 //论文主要作者姓名
						 MemberName = sciencePaperAuthor.getMemberName();
					 }else{
						 other = other + sciencePaperAuthor.getMemberName()+"、";
					 
					 }
				 }
				 
				 if(MemberName==""){
					 template.createCell("无"); 
				 }else{
					 template.createCell(MemberName);
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					//论文其他作者姓名
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
				//论文其他作者姓名
					 template.createCell(other);
				 }
				
			 
			
			 //提交该信息的用户
			 String submitUser = "";
             if(sciencePaper.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = sciencePaper.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			String approvedUser = "";
             if(sciencePaper.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = sciencePaper.getApprovedUser().getUserName(); 
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = sciencePaper.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = sciencePaper.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", paperId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelScienceTechTransferInfo(String factorName,String factorValues,String userId) {
		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<ScienceTechTransfer> lists1 = (List<ScienceTechTransfer>) getDownloadInfoService.getExcelDownloadInfoByFactors("ScienceTechTransfer",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("转让ID");
		template.createCell("项目/专利/技术名称");
		template.createCell("项目负责人");
		template.createCell("受让单位");
		template.createCell("受让单位性质");
		template.createCell("合同金额（万元）");
		template.createCell("当年实际收入（万元）");
		template.createCell("成果转化方式");
		template.createCell("转让技术研究的起始时间");
		template.createCell("转让技术研究的终止时间");
		template.createCell("备注");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			ScienceTechTransfer scienceTechTransfer = lists1.get(i);
			
			//转让ID
			String transferId = scienceTechTransfer.getTransferId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 template.createCell(transferId);
			 
			 //项目/专利/技术名称
			 String techName = scienceTechTransfer.getTechName();
			 if(techName==""){
				 
				 techName="无"; 
			 }
			 template.createCell(techName);
			 
			//项目负责人/成员姓名（2012-10-31 吕海修改）
				@SuppressWarnings("unchecked")
				List<ScienceTransferLeader> lists2 = (List<ScienceTransferLeader>) getDownloadInfoService.getExcelDownloadInfoByFactor("ScienceTransferLeader", "scienceTechTransfer.transferId", transferId);
				String other = "";
				for(int j=0;j<lists2.size();j++){
					ScienceTransferLeader scienceTransferLeader = lists2.get(j);
					other = other + scienceTransferLeader.getLeaderName()+"、";
				}
				
				
				if(other==""){
					other = "无";
					template.createCell(other);

				}else{
					other = other.substring(0,other.length()-1);
					template.createCell(other);

				}
			 
			 
			 //受让单位
			 String transfereeUnit = scienceTechTransfer.getTransfereeUnit();
             if(transfereeUnit==""){
				 
            	 transfereeUnit="无"; 
			 }
			 template.createCell(transfereeUnit);
			 
			 //受让单位性质
			 String unitProperties = scienceTechTransfer.getUnitProperties();
             if(unitProperties==""){
				 
            	 unitProperties="无"; 
			 }
			 template.createCell(unitProperties);
			 
			 //合同金额（万元）
			 String contractAmount = scienceTechTransfer.getContractAmount()+"";
             if(contractAmount==""){
				 
            	 contractAmount="无";
			 }
			 template.createCell(contractAmount);
			 
			 //当年实际收入（万元）
			 String realIncome = scienceTechTransfer.getRealIncome()+"";
             if(realIncome==""){
				 
            	 realIncome="无"; 
			 }
			 template.createCell(realIncome);
			 
			 //成果转化方式
			 String transformationWay = scienceTechTransfer.getTransformationWay();
             if(transformationWay==""){
				 
            	 transformationWay="无"; 
			 }
			 template.createCell(transformationWay);
			 
			 //转让技术研究的起始时间
			 String startTime = "";
			 if(scienceTechTransfer.getStartTime()!=null)
			  startTime = scienceTechTransfer.getStartTime().toString();
             if(startTime==""){
				 
            	 startTime="无"; 
			 }
			 template.createCell(startTime);
			 
			 //转让技术研究的终止时间
			 String endTime = "";
			 if(scienceTechTransfer.getEndTime()!=null)
			  endTime = scienceTechTransfer.getEndTime().toString();
             if(endTime==""){
				 
            	 endTime="无"; 
			 }
			 template.createCell(endTime);
			 
			 //备注
			 String remarks = scienceTechTransfer.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(scienceTechTransfer.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = scienceTechTransfer.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(scienceTechTransfer.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = scienceTechTransfer.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 
			 //该信息的状态
			 int status = scienceTechTransfer.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = scienceTechTransfer.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", transferId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelScienceTechProjectInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<ScienceTechProject> lists1 = (List<ScienceTechProject>) getDownloadInfoService.getExcelDownloadInfoByFactors("ScienceTechProject",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("项目ID");
		template.createCell("项目名称");
		template.createCell("项目批准时间");
		template.createCell("合同总经费");
		template.createCell("学科分类");
		template.createCell("活动分类");
		template.createCell("项目来源");
		template.createCell("组织形式");
		template.createCell("合作形式");
		template.createCell("项目依托科研机构");
		template.createCell("服务的国民经济行业");
		template.createCell("项目所在的部门");
		template.createCell("参与人");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		template.createCell("详细情况");
		template.createCell("更新当年项目状态信息时间");
		template.createCell("当年拨入经费（千元）");
		template.createCell("当年支出经费（千元）");
		template.createCell("当年投入人员（人年）合计");
		template.createCell("高级职务（人数）");
		template.createCell("中级职务（人数）");
		template.createCell("初级职务（人数）");
		template.createCell("其他（人数）");
		template.createCell("参与研究生数（人数）");
		template.createCell("项目状态");
		
		
		int m=0;
		for(int i=0;i<lists1.size();i++){
			ScienceTechProject scienceTechProject = lists1.get(i);
			
			//项目ID
			String projectId = scienceTechProject.getProjectId();
			 template.createRow(i*m+1);
			 template.createCell(i*m+1+"");
			 template.createCell(projectId);
			 
			 //项目名称
			 String projectName = scienceTechProject.getProjectName();
			 if(projectName==""){
				 
				 projectName="无"; 
			 }
			 template.createCell(projectName);
			 
			 //项目批准时间
			 String timeProjectApproved = "";
			 if(scienceTechProject.getTimeProjectApproved()!=null)
			  timeProjectApproved = scienceTechProject.getTimeProjectApproved().toString();
             if(timeProjectApproved==""){
				 
            	 timeProjectApproved="无"; 
			 }
			 template.createCell(timeProjectApproved);
			 
			 //合同总经费
			 String totalFundContract = scienceTechProject.getTotalFundContract()+"";
             if(totalFundContract==""){
				 
            	 totalFundContract="无"; 
			 }
			 template.createCell(totalFundContract);
			 
			 //学科分类
			 String sortSubject = scienceTechProject.getSortSubject();
             if(sortSubject==""){
				 
            	 sortSubject="无"; 
			 }
			 template.createCell(sortSubject);
			 
			 //活动分类
			 String sortActivity = scienceTechProject.getSortActivity();
			 if(sortActivity==""){
				 sortActivity="无";
			 }
			 template.createCell(sortActivity);
			 
			 //项目来源
			 String originProject = scienceTechProject.getOriginProject();
             if(originProject==""){
				 
            	 originProject="无"; 
			 }
			 template.createCell(originProject);
			 
			 //组织形式
			 String formOrganization = scienceTechProject.getFormOrganization();
             if(formOrganization==""){
				 
            	 formOrganization="无"; 
			 }
			 template.createCell(totalFundContract);
			 
			 //合作形式
			 String formCooperation = scienceTechProject.getFormCooperation();
             if(formCooperation==""){
				 
            	 formCooperation="无"; 
			 }
			 template.createCell(formCooperation);
			 
			 //项目依托科研机构
			 String organReliedProject = scienceTechProject.getOrganReliedProject();
             if(organReliedProject==""){
				 
            	 organReliedProject="无"; 
			 }
			 template.createCell(organReliedProject);
			 
			 //服务的国民经济行业
			 String industryService = scienceTechProject.getIndustryService();
             if(industryService==""){
				 
            	 industryService="无"; 
			 }
			 template.createCell(industryService);
			 
			 //项目所在的部门
			 String unitProject = scienceTechProject.getUnitProject();
             if(unitProject==""){
				 
            	 unitProject="无"; 
			 }
			 template.createCell(unitProject);
			 
			 //
			 @SuppressWarnings("unchecked")
				List<ScienceTechProjectMember> lists2 = (List<ScienceTechProjectMember>) 
				getDownloadInfoService.getExcelDownloadInfoByFactor("ScienceTechProjectMember", "project.projectId", projectId);
				//其他完成人	 
				 String other = "";
				 //主要完成人
				 String MemberName = "";
				 for(int j=0;j<lists2.size();j++){
					 ScienceTechProjectMember scienceTechProjectMember= lists2.get(j);
					
					
					 if(scienceTechProjectMember.getOrders()==1){
						 //主要完成人
						 MemberName =  scienceTechProjectMember.getMemberName();
					 }else{
						 //其他完成人
						 other = other + scienceTechProjectMember.getMemberName()+"、";
					 
					 }
				 }
				 
				 if(MemberName==""){
					 template.createCell("无"); 
				 }else{
					 template.createCell(MemberName);
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
					 other = other.substring(0,other.length()-1);
					 template.createCell(other);
				 }
			 //提交该信息的用户
			 String submitUser = "";
             if(scienceTechProject.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = scienceTechProject.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(scienceTechProject.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = scienceTechProject.getApprovedUser().getUserName(); 
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = scienceTechProject.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }else if(status==4){
				 statusStr = "该信息已保存但未提交（已更新）";
			 }else if(status==5){
				 statusStr = "信息已提交（已更新）";
			 }else if(status==6){
				 statusStr = "信息已审批通过（已更新）";
			 }else if(status==7){
				 statusStr = "信息审批未通过（已更新）";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = scienceTechProject.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			 
				@SuppressWarnings("unchecked")
				List<ScienceDetailTechProject> lists3 = (List<ScienceDetailTechProject>) getDownloadInfoService.getExcelDownloadInfoByFactors("ScienceDetailTechProject", "scienceTechProject.projectId", projectId);

				for(m=0;m<lists3.size();m++){
				 
				 ScienceDetailTechProject scienceDetailTechProject = lists3.get(m);
					
					
					
					//更新时间
					String updateTime="";
					if(scienceDetailTechProject.getUpdateTime()!=null){
						 updateTime = scienceDetailTechProject.getUpdateTime().toString();
					}
					if(updateTime==""){
						updateTime="无";
					}
					template.createCell(updateTime);

					//当年拨入经费（千元）
					String inputThisYear="";
					if(scienceDetailTechProject.getInputThisYear()>=0){
						inputThisYear = scienceDetailTechProject.getInputThisYear()+"";
					}
					if(inputThisYear==""){
						inputThisYear="无";
					}
					template.createCell(inputThisYear);
					
					//当年支出经费（千元）
					String expenditureThisYear="";
					if(scienceDetailTechProject.getExpenditureThisYear()>=0){
						expenditureThisYear = scienceDetailTechProject.getExpenditureThisYear()+"";
					}
					if(expenditureThisYear==""){
						expenditureThisYear="无";
					}
					template.createCell(expenditureThisYear);

					
					//当年投入人员（人年）合计
					String totalStaff="";
					if(scienceDetailTechProject.getTotalStaff()>=0){
						totalStaff = scienceDetailTechProject.getTotalStaff()+"";
					}
					if(totalStaff==""){
						totalStaff="无";
					}
					template.createCell(totalStaff);

					//高级职务
					String advancedStaff="";
					if(scienceDetailTechProject.getAdvancedStaff()>=0){
						advancedStaff = scienceDetailTechProject.getAdvancedStaff()+"";
					}
					if(advancedStaff==""){
						advancedStaff="无";
					}
					template.createCell(advancedStaff);
					
					//中级职务
					String middleStaff="";
					if(scienceDetailTechProject.getMiddleStaff()>=0){
						middleStaff = scienceDetailTechProject.getMiddleStaff()+"";
					}
					if(middleStaff==""){
						middleStaff="无";
					}
					template.createCell(middleStaff);
					
					
					//初级职务
					String juniorStaff="";
					if(scienceDetailTechProject.getJuniorStaff()>=0){
						juniorStaff = scienceDetailTechProject.getJuniorStaff()+"";
					}
					if(juniorStaff==""){
						juniorStaff="无";
					}
					template.createCell(juniorStaff);
					
					//其他
					String otherStaff="";
					if(scienceDetailTechProject.getOtherStaff()>=0){
						otherStaff = scienceDetailTechProject.getOtherStaff()+"";
					}
					if(otherStaff==""){
						otherStaff="无";
					}
					template.createCell(otherStaff);
					
					//参与研究生数
					String graduateJoin="";
					if(scienceDetailTechProject.getGraduateJoin()>=0){
						graduateJoin = scienceDetailTechProject.getGraduateJoin()+"";
					}
					if(graduateJoin==""){
						graduateJoin="无";
					}
					template.createCell(graduateJoin);
					
					//项目状态
					String projectStatus="";
					if(scienceDetailTechProject.getProjectStatus()!=null){
						projectStatus = scienceDetailTechProject.getProjectStatus();
					}
					if(projectStatus==""){
						projectStatus="无";
					}
					template.createCell(projectStatus);
			 }
				
				   if("admin".equals(userId)){
						 //旁证材料
						 
						@SuppressWarnings("unchecked")
						List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", projectId);
						
						 for(int j=0;j<proofslists.size();j++){
							 Proofs proofs= proofslists.get(j);
							
							
							 if("".equals(proofs)){
								 
								 template.createCell("没有上传附件");
							 }else{
								 String proofsUrl = proofs.getUploadRealName();
								
								 proofsUrl = "file:///"+proofsUrl;
								 template.createCell(proofsUrl);
								 

							 }
						 }
					  } 
			
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelScienceTechExchangeInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<ScienceTechExchange> lists1 = (List<ScienceTechExchange>) getDownloadInfoService.getExcelDownloadInfoByFactors("ScienceTechExchange",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("科技交流情况ID");
		template.createCell("所在学院");
		template.createCell("形式");
		template.createCell("派遣人数");
		template.createCell("接收人数");
		template.createCell("出席人数");
		template.createCell("交流论文篇数");
		template.createCell("特邀报告篇数");
		template.createCell("主办");
		template.createCell("参与人姓名");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		
		
		for(int i=0;i<lists1.size();i++){
			ScienceTechExchange scienceTechExchange = lists1.get(i);
			//科技交流情况ID
			String techExchangeId = scienceTechExchange.getTechExchangeId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 template.createCell(techExchangeId);
			 
			 //所在学院
			 String collegesIn = scienceTechExchange.getCollegesIn();
			 if(collegesIn==""){
				 
				 collegesIn="无"; 
			 }
			 template.createCell(collegesIn);
			 
			 //形式
			 String exchangeType = scienceTechExchange.getExchangeType();
             if(exchangeType.equals("1")){
				 
            	 exchangeType="国内"; 
			 }else if(exchangeType.equals("1")){
				 exchangeType=" 国境外（包括港澳）"; 
				 
			 }else{
				 exchangeType="无"; 
			 }
			 template.createCell(exchangeType);
			 
			 //派遣人数
			 String sendNumber = scienceTechExchange.getSendNumber()+"";
             if(sendNumber==""){
				 
            	 sendNumber="无"; 
			 }
			 template.createCell(sendNumber);
			 
			 //接收人数
			 String receiveNumber = scienceTechExchange.getReceiveNumber()+"";
             if(receiveNumber==""){
				 
            	 receiveNumber="无"; 
			 }
			 template.createCell(receiveNumber);
			 
			 //出席人数
			 String attendNumber = scienceTechExchange.getAttendNumber()+"";
             if(attendNumber==""){
				 
            	 attendNumber="无"; 
			 }
			 template.createCell(attendNumber);
			 
			 //交流论文篇数
			 String papersNumber = scienceTechExchange.getPapersNumber()+"";
             if(papersNumber==""){
				 
            	 papersNumber="无"; 
			 }
			 template.createCell(papersNumber);
			 
			 //特邀报告篇数
			 String specialInvitedNumber = scienceTechExchange.getSpecialInvitedNumber()+"";
             if(specialInvitedNumber==""){
				 
            	 specialInvitedNumber="无"; 
			 }
			 template.createCell(specialInvitedNumber);
			 
			 //主办
			 String exchangeHost = scienceTechExchange.getExchangeHost();
             if(exchangeHost==""){
				 
            	 exchangeHost="无"; 
			 }
			 template.createCell(exchangeHost);
			 
			 //参与人姓名
			 @SuppressWarnings("unchecked")
				List<ScienceTechAttendPerson> lists2 = (List<ScienceTechAttendPerson>) 
				getDownloadInfoService.getExcelDownloadInfoByFactor("ScienceTechAttendPerson", "scienceTechExchange.techExchangeId", techExchangeId);
				 String other = "";
				 for(int j=0;j<lists2.size();j++){
					 ScienceTechAttendPerson scienceTechAttendPerson= lists2.get(j);
					
					
					 
						 other = other + scienceTechAttendPerson.getMemberName()+"、";
					 
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);

				 }else{
					 
						other = other.substring(0,other.length()-1);
						template.createCell(other);

				 }
			 
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(scienceTechExchange.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = scienceTechExchange.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(scienceTechExchange.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = scienceTechExchange.getApprovedUser().getUserName(); 
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = scienceTechExchange.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 //返回原因
			 String returnReason = scienceTechExchange.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			   if("admin".equals(userId)){
					 //旁证材料
					 
					@SuppressWarnings("unchecked")
					List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", techExchangeId);
					
					 for(int j=0;j<proofslists.size();j++){
						 Proofs proofs= proofslists.get(j);
						
						
						 if("".equals(proofs)){
							 
							 template.createCell("没有上传附件");
						 }else{
							 String proofsUrl = proofs.getUploadRealName();
							
							 proofsUrl = "file:///"+proofsUrl;
							 template.createCell(proofsUrl);
							 

						 }
					 }
				  } 
		}
		
		return template;
	}

	@Override
	public ExcelTemplate getExcelTeachAchievementsCQInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<TeachAchievementsCQ> lists1 = (List<TeachAchievementsCQ>) getDownloadInfoService.getExcelDownloadInfoByFactors("TeachAchievementsCQ",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("项目编号");
		template.createCell("项目名称");
		template.createCell("立项时间");
		template.createCell("结题时间");
		template.createCell("类型");
		template.createCell("负责人（学生）");
		template.createCell("团队成员");
		template.createCell("备注");
		template.createCell("奖励金额");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("备注");
		template.createCell("返回原因");
		 if("admin".equals(userId)){
			 template.createCell("附件");
		 }
		
		
		for(int i=0;i<lists1.size();i++){
			 TeachAchievementsCQ teachAchievementsCQ = lists1.get(i);
			 String achievementsId = teachAchievementsCQ.getAchievementsId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 
			 //项目编号
			 template.createCell(teachAchievementsCQ.getReportedAmounts());
			 
			//项目名称
			 String projectName = teachAchievementsCQ.getProjectName();
             if(projectName==""){
				 
            	 projectName="无"; 
			 }
			 template.createCell(projectName);
			 
			//立项时间
			 String timeAchievements = teachAchievementsCQ.getTimeAchievements();
             if(timeAchievements==""){
				 
            	 timeAchievements="无"; 
			 }
			 template.createCell(timeAchievements);
			 
			 //结题时间
			 String gradeAchievements = teachAchievementsCQ.getGradeAchievements();
             if(gradeAchievements==""){
				 
            	 gradeAchievements="无"; 
			 }
			 template.createCell(gradeAchievements);
			 
			//项目类别
			 String projectType = teachAchievementsCQ.getProjectType();
             if(projectType==""){
				 
            	 projectType="无"; 
			 }
			 template.createCell(projectType);
			 
			 //负责人（学生）
			 String classAchievements = teachAchievementsCQ.getClassAchievements();
			 if(classAchievements==""){
				 
				 classAchievements="无"; 
			 }
			 template.createCell(classAchievements);
			 
			 //团队成员
			 String certificationUnit = "";
			 if(teachAchievementsCQ.getCertificationUnit()!=null)
				 certificationUnit = teachAchievementsCQ.getCertificationUnit().toString();
             if(certificationUnit==""){
				 
            	 certificationUnit="无"; 
			 }
			 template.createCell(certificationUnit);
			 
			 
			 @SuppressWarnings("unchecked")
				List<TeachAchievementsDeclarant> lists2 = (List<TeachAchievementsDeclarant>) getDownloadInfoService.getExcelDownloadInfoByFactor("TeachAchievementsDeclarant", "teachAchievementsCQ.achievementsId", achievementsId);
				//指导老师
			 	String other = "";
			 	
				 for(int j=0;j<lists2.size();j++){
					 TeachAchievementsDeclarant teachAchievementsDeclarant= lists2.get(j);
					
					
					 if(teachAchievementsDeclarant.getOrders()==1){
						 
						 other = other + teachAchievementsDeclarant.getDeclarantName()+"、";
					 
					 }
				 }
				 
		
				 
				 if(other==""){
					 
					 other = "无"; 
					 template.createCell(other);
				 }else{
						other = other.substring(0,other.length()-1);
						template.createCell(other);
				 }
			 
			//备注
			 String remarks = teachAchievementsCQ.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
			
			 
			 
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(teachAchievementsCQ.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = teachAchievementsCQ.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(teachAchievementsCQ.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = teachAchievementsCQ.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = teachAchievementsCQ.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = teachAchievementsCQ.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			
			
		   if("admin".equals(userId)){
			 //旁证材料
			 
			@SuppressWarnings("unchecked")
			List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", achievementsId);
			
			 for(int j=0;j<proofslists.size();j++){
				 Proofs proofs= proofslists.get(j);
				
				
				 if("".equals(proofs)){
					 
					 template.createCell("没有上传附件");
				 }else{
					 String proofsUrl = proofs.getUploadRealName();
					
					 proofsUrl = "file:///"+proofsUrl;
					 template.createCell(proofsUrl);
					 

				 }
			 }
		  } 
		}
		
		return template;
	}

	@Override
    public ExcelTemplate getExcelCourseContributeInfo(String factorName,String factorValues,String userId) {
        
		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<CourseContribute> lists1 = (List<CourseContribute>) getDownloadInfoService.getExcelDownloadInfoByFactors("CourseContribute",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("课程建设ID");
		template.createCell("立项级别");
		template.createCell("立项类别");
		template.createCell("立项时间");
		template.createCell("课程名称");
		template.createCell("主要负责人");
		template.createCell("其他负责人");
		template.createCell("年度检查时间");
		template.createCell("结题时间");
		template.createCell("学院奖励");
		template.createCell("备注");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		 if("admin".equals(userId)){
			 template.createCell("附件");
		 }
		
		for(int i=0;i<lists1.size();i++){
			CourseContribute courseContribute = lists1.get(i);
			String courseId = courseContribute.getCourseId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
             //课程建设ID
			 template.createCell(courseContribute.getCourseId());
			 
			 //立项级别
			 String classContribute = courseContribute.getClassContribute();
			 if(classContribute==""){
				 
				 classContribute="无"; 
			 }
			 template.createCell(classContribute);
			 
			 //立项类别
			 String typeContribute = courseContribute.getTypeContribute();
             if(typeContribute==""){
				 
            	 typeContribute="无"; 
			 }
			 template.createCell(typeContribute);
			 
			 //立项时间
			 String timeContribute = courseContribute.getTimeContribute();
             if(timeContribute==""){
				 
            	 timeContribute="无"; 
			 }
			 template.createCell(timeContribute);
			 
			 //课程名称
			 String courseName = courseContribute.getCourseName();
             if(courseName==""){
				 
            	 courseName="无"; 
			 }
			 template.createCell(courseName);
			 
			 @SuppressWarnings("unchecked")
				List<CourseContributeMember> lists2 = (List<CourseContributeMember>) getDownloadInfoService.getExcelDownloadInfoByFactor("CourseContributeMember", "courseContribute.courseId", courseId);
				 String other = "";
				 for(int j=0;j<lists2.size();j++){
					 CourseContributeMember courseContributeMember= lists2.get(j);
					
					
					 if(courseContributeMember.getOrders()==1){
						//主要负责人
						 template.createCell(courseContributeMember.getMemberName());
					 }else{
						 //其他负责人
						 other = other + courseContributeMember.getMemberName()+"、";
					 
					 }
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
				 }else{
				other = other.substring(0,other.length()-1);
				 }
				 //年度检查时间
				template.createCell(other);
				 String checkTime ="";
			 if(courseContribute.getCheckTime()!=null)
			  checkTime = courseContribute.getCheckTime().toString();
             if(checkTime==""){
				 
            	 checkTime="无"; 
			 }
			 template.createCell(checkTime);
			 
			//结题时间
			 String endTime ="";
			 if(courseContribute.getEndTime()!=null)
			  endTime = courseContribute.getEndTime().toString();
             if(endTime==""){
				 
            	 endTime="无"; 
			 }
			 template.createCell(endTime);
			 
			 //学院奖励
			 String collegeAward = "";
			 if(courseContribute.getCollegeAward()!=null)
			  collegeAward = courseContribute.getCollegeAward().toString();
             if(collegeAward==""){
				 
            	 collegeAward="无"; 
			 }
			 template.createCell(collegeAward);
			 
			 //备注
			 String remarks = courseContribute.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(courseContribute.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = courseContribute.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser ="";
             if(courseContribute.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = courseContribute.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = courseContribute.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = courseContribute.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			 if("admin".equals(userId)){
				 //旁证材料
				 
				@SuppressWarnings("unchecked")
				List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", courseId);
				
				 for(int j=0;j<proofslists.size();j++){
					 Proofs proofs= proofslists.get(j);
					
					
					 if("".equals(proofs)){
						 
						 template.createCell("没有上传附件");
					 }else{
						 String proofsUrl = proofs.getUploadRealName();
						
						 proofsUrl = "file:///"+proofsUrl;
						 template.createCell(proofsUrl);
						 

					 }
				 }
			  } 
			
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelMajorContributeInfo(String factorName,String factorValues,String userId) {
		
		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<MajorContribute> lists1 = (List<MajorContribute>) getDownloadInfoService.getExcelDownloadInfoByFactors("MajorContribute",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("专业建设ID");
		template.createCell("立项级别");
		template.createCell("立项类别");
		template.createCell("立项时间");
		template.createCell("专业名称");
		template.createCell("主要负责人");
		template.createCell("其他负责人");
		template.createCell("年度检查时间");
		template.createCell("结题时间");
		template.createCell("学院奖励");
		template.createCell("备注");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		if("admin".equals(userId)){
			 template.createCell("附件");
		 }
		
		for(int i=0;i<lists1.size();i++){
			MajorContribute majorContribute = lists1.get(i);
			String majorId = majorContribute.getMajorId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 
			 //专业建设ID
			 template.createCell(majorContribute.getMajorId());
			 
			 //立项级别
			 String classContribute = majorContribute.getClassContribute();
			 if(classContribute==""){
				 
				 classContribute="无"; 
			 }
			 template.createCell(classContribute);
			 
			 //立项类别
			 String typeContribute = majorContribute.getTypeContribute();
             if(typeContribute==""){
				 
            	 typeContribute="无"; 
			 }
			 template.createCell(typeContribute);
			 
			 //立项时间
			 String timeContribute = majorContribute.getTimeContribute();
             if(timeContribute==""){
				 
            	 timeContribute="无"; 
			 }
			 template.createCell(timeContribute);
			 
			 //专业名称
			 String majorName = majorContribute.getMajorName();
             if(majorName==""){
				 
            	 majorName="无"; 
			 }
			 template.createCell(majorName);
			 
			  @SuppressWarnings("unchecked")
	 			List<MajorContributeMember> lists2 = (List<MajorContributeMember>) getDownloadInfoService.getExcelDownloadInfoByFactor("MajorContributeMember", "majorContribute.majorId", majorId);
	 			 String other = "";
	 			 for(int j=0;j<lists2.size();j++){
	 				 MajorContributeMember majorContributeMember= lists2.get(j);
	 				
	 				
	 				 if(majorContributeMember.getOrders()==1){
	 					 //主要负责人
	 					 template.createCell(majorContributeMember.getMemberName());
	 				 }else{
	 					 //其他负责人
	 					 other = other + majorContributeMember.getMemberName()+"、";
	 				 
	 				 }
	 			 }
	 			 
	 			 if(other==""){
	 				 
	 				 other = "无"; 
	 			 }else{
	 			other = other.substring(0,other.length()-1);
	 			 }
	 			template.createCell(other);
	 			
			 //年度检查时间
			 String checkTime ="";
			 if(majorContribute.getCheckTime()!=null)
			  checkTime = majorContribute.getCheckTime().toString();
             if(checkTime==""){
				 
            	 checkTime="无"; 
			 }
             template.createCell(checkTime);
			 
             //结题时间
             String endTime = "";
			 if(majorContribute.getEndTime()!=null)
			  endTime = majorContribute.getEndTime().toString();
             if(endTime==""){
				 
            	 endTime="无"; 
			 }
			 template.createCell(endTime);
			 
			 //学院奖励
			 String collegeAward ="";
			 if(majorContribute.getRewardCollege()!=null)
			  collegeAward = majorContribute.getRewardCollege().toString();
             if(collegeAward==""){
				 
            	 collegeAward="无"; 
			 }
			 template.createCell(collegeAward);
			 
			 //备注
			 String remarks = majorContribute.getRemarks();
             if(remarks==""){
				 
            	 remarks="无"; 
			 }
			 template.createCell(remarks);
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(majorContribute.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = majorContribute.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(majorContribute.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = majorContribute.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = majorContribute.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = majorContribute.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			 if("admin".equals(userId)){
				 //旁证材料
				 
				@SuppressWarnings("unchecked")
				List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", majorId);
				
				 for(int j=0;j<proofslists.size();j++){
					 Proofs proofs= proofslists.get(j);
					
					
					 if("".equals(proofs)){
						 
						 template.createCell("没有上传附件");
					 }else{
						 String proofsUrl = proofs.getUploadRealName();
						
						 proofsUrl = "file:///"+proofsUrl;
						 template.createCell(proofsUrl);
						 

					 }
				 }
			  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelStudentAwardsInfo(String factorName,String factorValues,String userId) {
		
		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<StudentAwards> lists1 = (List<StudentAwards>) getDownloadInfoService.getExcelDownloadInfoByFactors("StudentAwards",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("获奖ID");
		template.createCell("获奖时间");
		template.createCell("获奖学生");
		template.createCell("获奖名称");
		template.createCell("获奖级别");
		template.createCell("指导老师");
		template.createCell("学院奖励");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		if("admin".equals(userId)){
			 template.createCell("附件");
		 }
		
		for(int i=0;i<lists1.size();i++){
			StudentAwards studentAwards = lists1.get(i);
			String awardsId = studentAwards.getAwardsId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 
			 //获奖ID
			 template.createCell(studentAwards.getAwardsId());
			 
			//获奖时间
			 String rewardTime = studentAwards.getRewardTime();
			 if(rewardTime==""){
				 
				 rewardTime="无"; 
			 }
			 template.createCell(rewardTime);
			 
			//获奖学生
			 String rewardStudents = studentAwards.getRewardStudents();
             if(rewardStudents==""){
				 
            	 rewardStudents="无"; 
			 }
			 template.createCell(rewardStudents);
			 
			 //获奖名称
			 String rewardName = studentAwards.getRewardName();
             if(rewardName==""){
				 
            	 rewardName="无"; 
			 }
			 template.createCell(rewardName);
			 
			 
			 //获奖级别
			 String rewardLevel = studentAwards.getRewardLevel();
             if(rewardLevel==""){
				 
            	 rewardLevel="无"; 
			 }
			 template.createCell(rewardLevel);
			 
			 //指导老师
			 @SuppressWarnings("unchecked")
				List<StudentInstructor> lists2 = (List<StudentInstructor>) getDownloadInfoService.getExcelDownloadInfoByFactor("StudentInstructor", "studentAwards.awardsId", awardsId);
				 String other = "";
				 for(int j=0;j<lists2.size();j++){
					 StudentInstructor studentInstructor= lists2.get(j);
					
					 other = other + studentInstructor.getMemberName()+"、";
					 
					
				 }
				 
				 if(other==""){
					 
					 other = "无"; 
				 }else{
				other = other.substring(0,other.length()-1);
				 }
				template.createCell(other);
			 
			//学院奖励
			 String collegeAward = studentAwards.getCollegeAward();
             if(collegeAward==""){
				 
            	 collegeAward="无"; 
			 }
			 template.createCell(collegeAward);
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(studentAwards.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = studentAwards.getSubmitUser().getUserName(); 
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = studentAwards.getApprovedUser().getUserName();
             if(studentAwards.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = studentAwards.getApprovedUser().getUserName(); 
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = studentAwards.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = studentAwards.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			 if("admin".equals(userId)){
				 //旁证材料
				 
				@SuppressWarnings("unchecked")
				List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId",awardsId);
				
				 for(int j=0;j<proofslists.size();j++){
					 Proofs proofs= proofslists.get(j);
					
					
					 if("".equals(proofs)){
						 
						 template.createCell("没有上传附件");
					 }else{
						 String proofsUrl = proofs.getUploadRealName();
						
						 proofsUrl = "file:///"+proofsUrl;
						 template.createCell(proofsUrl);
						 

					 }
				 }
			  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelTeachingMaterialSetInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<TeachingMaterialSet> lists1 = (List<TeachingMaterialSet>) getDownloadInfoService.getExcelDownloadInfoByFactors("TeachingMaterialSet",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("教材立项ID");
		template.createCell("级别");
		template.createCell("时间");
		template.createCell("项目编号");
		template.createCell("教材名称");
		template.createCell("主编/作者姓名");
		template.createCell("是否结贴");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		if("admin".equals(userId)){
			 template.createCell("附件");
		 }
		for(int i=0;i<lists1.size();i++){
			TeachingMaterialSet teachingMaterialSet = lists1.get(i);
			String teachingMaterialId = teachingMaterialSet.getTeachingMaterialId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 
			 //教材立项ID
			 template.createCell(teachingMaterialId);
			 
			 //级别
			 String setClass = teachingMaterialSet.getSetClass();
			 if(setClass==""){
				 
				 setClass="无"; 
			 }
			 template.createCell(setClass);
			 
			 //时间
			 String setTime = teachingMaterialSet.getSetTime();
             if(setTime==""){
				 
            	 setTime="无"; 
			 }
			 template.createCell(setTime);
			 
			 //项目编号
			 String numberProject = teachingMaterialSet.getNumberProject();
             if(numberProject==""){
				 
            	 numberProject="无"; 
			 }
			 template.createCell(numberProject);
			 
			 //教材名称
			 String teachingMaterialName = teachingMaterialSet.getTeachingMaterialName();
             if(teachingMaterialName==""){
				 
            	 teachingMaterialName="无"; 
			 }
			 template.createCell(teachingMaterialName);
			 
			//主编/作者姓名（2012-10-31 吕海修改）
			@SuppressWarnings("unchecked")
			List<TeachingMaterialEditor> lists2 = (List<TeachingMaterialEditor>) getDownloadInfoService.getExcelDownloadInfoByFactor("TeachingMaterialEditor", "teachingMaterialSet.teachingMaterialId", teachingMaterialId);
			String other = "";
			for(int j=0;j<lists2.size();j++){
				TeachingMaterialEditor teachingMaterialEditor = lists2.get(j);
				other = other + teachingMaterialEditor.getEditorName()+"、";
			}
			if(other==""){
				other = "无";
			}else{
				other = other.substring(0,other.length()-1);
			}
			template.createCell(other);
			 
			 //是否结贴
			 String resultsPostedStatus = teachingMaterialSet.getResultsPostedStatus();
             if(resultsPostedStatus==""){
				 
            	 resultsPostedStatus="无"; 
			 }
			 template.createCell(resultsPostedStatus);
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(teachingMaterialSet.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = teachingMaterialSet.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(teachingMaterialSet.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = teachingMaterialSet.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = teachingMaterialSet.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = teachingMaterialSet.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			 if("admin".equals(userId)){
				 //旁证材料
				 
				@SuppressWarnings("unchecked")
				List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", teachingMaterialId);
				
				 for(int j=0;j<proofslists.size();j++){
					 Proofs proofs= proofslists.get(j);
					
					
					 if("".equals(proofs)){
						 
						 template.createCell("没有上传附件");
					 }else{
						 String proofsUrl = proofs.getUploadRealName();
						
						 proofsUrl = "file:///"+proofsUrl;
						 template.createCell(proofsUrl);
						 

					 }
				 }
			  } 
		}
		
		return template;
	}
	@Override
	public ExcelTemplate getExcelTeachAchievementsInfo(String factorName,String factorValues,String userId) {

		ExcelTemplate template = ExcelTemplate.newInstance("download.xls");    
		@SuppressWarnings("unchecked")
		List<TeachAchievements> lists1 = (List<TeachAchievements>) getDownloadInfoService.getExcelDownloadInfoByFactors("TeachAchievements",factorName,factorValues);
		
		template.createRow(0);
		template.createCell("编号");
		template.createCell("教学成果ID");
		template.createCell("级别");
		template.createCell("项目名称");
		template.createCell("等级");
		template.createCell("主要负责人");
		template.createCell("其他负责人");
		template.createCell("时间");
		template.createCell("学院奖励");
		template.createCell("提交该信息的用户");
		template.createCell("审批该信息的用户");
		template.createCell("该信息的状态");
		template.createCell("返回原因");
		if("admin".equals(userId)){
			 template.createCell("附件");
		 }
		
		for(int i=0;i<lists1.size();i++){
			TeachAchievements teachAchievements = lists1.get(i);
			String achievementsId = teachAchievements.getAchievementsId();
			 template.createRow(i+1);
			 template.createCell(i+1+"");
			 //教学成果ID
			 template.createCell(teachAchievements.getAchievementsId());
			 
			 //级别
			 String classAchievements = teachAchievements.getClassAchievements();
			 if(classAchievements==""){
				 
				 classAchievements="无"; 
			 }
			 template.createCell(classAchievements);
			 
			 //项目名称
			 String projectName = teachAchievements.getProjectName();
             if(projectName==""){
				 
            	 projectName="无"; 
			 }
			 template.createCell(projectName);
			 
			 //等级
			 String levelAchievements = teachAchievements.getLevelAchievements();
             if(levelAchievements==""){
				 
            	 levelAchievements="无"; 
			 }
			 template.createCell(levelAchievements);
			 
			 
			 @SuppressWarnings("unchecked")
				List<TeachersAwards> lists2 = (List<TeachersAwards>) getDownloadInfoService.getExcelDownloadInfoByFactor("TeachersAwards", "teachAchievements.achievementsId", achievementsId);
				 String other = "";
				 for(int j=0;j<lists2.size();j++){
					 TeachersAwards teachersAwards= lists2.get(j);
					
					
					 if(teachersAwards.getOrders()==1){
						 
						//主要负责人
						 template.createCell(teachersAwards.getMemberName());
					 }else{
						 //其他负责人
						 other = other + teachersAwards.getMemberName()+"、";
					 
					 }
				 }
				 
				
				 if(other==""){
					 
					 other = "无"; 
				 }else{
				other = other.substring(0,other.length()-1);
				 }
				template.createCell(other);
			
				//时间
			 String timeAchievements = teachAchievements.getTimeAchievements();
             if(timeAchievements==""){
				 
            	 timeAchievements="无"; 
			 }
			 template.createCell(timeAchievements);
			 
			 //学院奖励
			 String collegeAward = "";
			 if(teachAchievements.getCollegeAward()!=null)
			  collegeAward = teachAchievements.getCollegeAward().toString();
             if(collegeAward==""){
				 
            	 collegeAward="无"; 
			 }
			 template.createCell(collegeAward);
			 
			 //提交该信息的用户
			 String submitUser = "";
             if(teachAchievements.getSubmitUser()==null){
				 
            	 submitUser="无"; 
			 }else{
				 submitUser = teachAchievements.getSubmitUser().getUserName();
			 }
			 template.createCell(submitUser);
			 
			 //审批该信息的用户
			 String approvedUser = "";
             if(teachAchievements.getApprovedUser()==null){
				 
            	 approvedUser="无"; 
			 }else{
				 approvedUser = teachAchievements.getApprovedUser().getUserName();
			 }
			 template.createCell(approvedUser);
			 
			 //该信息的状态
			 int status = teachAchievements.getStatus();
			 String statusStr = "";
			 if(status==0){
				 statusStr = "该信息已保存但未提交";
			 }else if(status==1){
				 statusStr = "信息已提交";
			 }else if(status==2){
				 statusStr = "信息已审批通过";
			 }else if(status==3){
				 statusStr = "信息审批未通过";
			 }
			 template.createCell(statusStr);
			 
			 //返回原因
			 String returnReason = teachAchievements.getReturnReason();
             if(returnReason==""){
				 
            	 returnReason="无"; 
			 }
			 template.createCell(returnReason);
			 if("admin".equals(userId)){
				 //旁证材料
				 
				@SuppressWarnings("unchecked")
				List<Proofs> proofslists = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "infoApprovedId", achievementsId);
				
				 for(int j=0;j<proofslists.size();j++){
					 Proofs proofs= proofslists.get(j);
					
					
					 if("".equals(proofs)){
						 
						 template.createCell("没有上传附件");
					 }else{
						 String proofsUrl = proofs.getUploadRealName();
						
						 proofsUrl = "file:///"+proofsUrl;
						 template.createCell(proofsUrl);
						 

					 }
				 }
			  } 
		}
		
		return template;
	}



	
}
