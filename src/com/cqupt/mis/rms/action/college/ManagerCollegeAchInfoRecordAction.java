package com.cqupt.mis.rms.action.college;

import java.util.List;

import com.cqupt.mis.rms.model.EducationalReformRecord;
import com.cqupt.mis.rms.model.ExcellentTrainerRecord;
import com.cqupt.mis.rms.model.LearningEvaluationRecord;
import com.cqupt.mis.rms.model.MajorContributeRecord;
import com.cqupt.mis.rms.model.OtherTeachingAwardsRecord;
import com.cqupt.mis.rms.model.QualityProjectRecord;
import com.cqupt.mis.rms.model.StudentAwardsRecord;
import com.cqupt.mis.rms.model.TeachersAwardsRecord;
import com.cqupt.mis.rms.model.TeachingMaterialRecord;
import com.cqupt.mis.rms.service.CollegeManagerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title:实现得到符合条件教学成果类信息的action</p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company:重邮信管工作室 </p>
 * @author Bern
 * @version 2.0
 * */
public class ManagerCollegeAchInfoRecordAction extends ActionSupport {
	//注入服务层接口
	private CollegeManagerService collegeManagerService;
	
	private final static String RECORDS = "records";

	//得到符合条件的教学成果信息类专业建设的相关信息
    @SuppressWarnings("unchecked")
	public String majorContributeRecord(){
		List<MajorContributeRecord> majorContributeRecordsLists;
    	majorContributeRecordsLists = (List<MajorContributeRecord>) collegeManagerService.getInfo("MajorContributeRecord");
    	ActionContext.getContext().put(RECORDS, majorContributeRecordsLists);
    	return SUCCESS;
	}
    
  //得到符合条件的教学成果信息类教材立项的相关信息
    @SuppressWarnings("unchecked")
	public String teachingMaterialRecord(){
		List<TeachingMaterialRecord> teachingMaterialRecordsLists;
    	teachingMaterialRecordsLists = (List<TeachingMaterialRecord>) collegeManagerService.getInfo("TeachingMaterialRecord");
    	ActionContext.getContext().put(RECORDS, teachingMaterialRecordsLists);
    	return SUCCESS;
	}
    
  //得到符合条件的教学成果信息类学生获奖的相关信息
    @SuppressWarnings("unchecked")
	public String studentAwardsRecord(){
		List<StudentAwardsRecord> studentAwardsRecordsLists;
    	studentAwardsRecordsLists = (List<StudentAwardsRecord>) collegeManagerService.getInfo("StudentAwardsRecord");
    	ActionContext.getContext().put(RECORDS, studentAwardsRecordsLists);
    	return SUCCESS;
	}
    
    //liu add 得到符合条件的教学成果奖的相关信息
    @SuppressWarnings("unchecked")
    public String teacherAwardsRecord(){
		List<TeachersAwardsRecord> teachersAwardsRecordsLists;
    	teachersAwardsRecordsLists = (List<TeachersAwardsRecord>) collegeManagerService.getInfo("TeachersAwardsRecord");
    	ActionContext.getContext().put(RECORDS, teachersAwardsRecordsLists);
    	return SUCCESS;
	}
    
    //liu add 得到符合条件的优秀培训师的相关信息
    @SuppressWarnings("unchecked")
    public String excellentTrainerRecord(){
		List<ExcellentTrainerRecord> excellentTrainerRecordsLists;
    	excellentTrainerRecordsLists = (List<ExcellentTrainerRecord>) collegeManagerService.getInfo("ExcellentTrainerRecord");
    	ActionContext.getContext().put(RECORDS, excellentTrainerRecordsLists);
    	return SUCCESS;
	}
    
    //liu add 得到符合条件的质量工程的相关信息
    @SuppressWarnings("unchecked")
    public String qualityProjectRecord(){
		List<QualityProjectRecord> qualityProjectRecordsLists;
    	qualityProjectRecordsLists = (List<QualityProjectRecord>) collegeManagerService.getInfo("QualityProjectRecord");
    	ActionContext.getContext().put(RECORDS, qualityProjectRecordsLists);
    	return SUCCESS;
	}
    
    //liu add 得到符合条件的学评教的相关信息
    @SuppressWarnings("unchecked")
    public String learningEvaluationRecord(){
		List<LearningEvaluationRecord> learningEvaluationRecordsLists;
    	learningEvaluationRecordsLists = (List<LearningEvaluationRecord>) collegeManagerService.getInfo("LearningEvaluationRecord");
    	ActionContext.getContext().put(RECORDS, learningEvaluationRecordsLists);
    	return SUCCESS;
	}
    
    //liu add 得到符合条件的教改项目的相关信息
    @SuppressWarnings("unchecked")
    public String educationalReformRecord(){
		List<EducationalReformRecord> educationalReformRecordsLists;
    	educationalReformRecordsLists = (List<EducationalReformRecord>) collegeManagerService.getInfo("EducationalReformRecord");
    	ActionContext.getContext().put(RECORDS, educationalReformRecordsLists);
    	return SUCCESS;
	}
    
    //liu add 得到符合条件的其他教学奖励的相关信息
    @SuppressWarnings("unchecked")
    public String otherTeachingAwardsRecord(){
		List<OtherTeachingAwardsRecord> otherTeachingAwardsRecordsLists;
    	otherTeachingAwardsRecordsLists = (List<OtherTeachingAwardsRecord>) collegeManagerService.getInfo("OtherTeachingAwardsRecord");
    	ActionContext.getContext().put(RECORDS, otherTeachingAwardsRecordsLists);
    	return SUCCESS;
	}
    
	public CollegeManagerService getCollegeManagerService() {
		return collegeManagerService;
	}

	public void setCollegeManagerService(CollegeManagerService collegeManagerService) {
		this.collegeManagerService = collegeManagerService;
	}
    
}
