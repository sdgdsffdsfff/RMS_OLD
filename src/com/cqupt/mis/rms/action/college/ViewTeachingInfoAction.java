package com.cqupt.mis.rms.action.college;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.model.EducationalReformData;
import com.cqupt.mis.rms.model.EducationalReformField;
import com.cqupt.mis.rms.model.EducationalReformRecord;
import com.cqupt.mis.rms.model.ExcellentTrainerData;
import com.cqupt.mis.rms.model.ExcellentTrainerField;
import com.cqupt.mis.rms.model.ExcellentTrainerRecord;
import com.cqupt.mis.rms.model.LearningEvaluationData;
import com.cqupt.mis.rms.model.LearningEvaluationField;
import com.cqupt.mis.rms.model.LearningEvaluationRecord;
import com.cqupt.mis.rms.model.MajorContributeData;
import com.cqupt.mis.rms.model.MajorContributeField;
import com.cqupt.mis.rms.model.MajorContributeRecord;
import com.cqupt.mis.rms.model.OtherTeachingAwardsData;
import com.cqupt.mis.rms.model.OtherTeachingAwardsField;
import com.cqupt.mis.rms.model.OtherTeachingAwardsRecord;
import com.cqupt.mis.rms.model.QualityProjectData;
import com.cqupt.mis.rms.model.QualityProjectField;
import com.cqupt.mis.rms.model.QualityProjectRecord;
import com.cqupt.mis.rms.model.StudentAwardsData;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.cqupt.mis.rms.model.StudentAwardsRecord;
import com.cqupt.mis.rms.model.TeachersAwardsData;
import com.cqupt.mis.rms.model.TeachersAwardsField;
import com.cqupt.mis.rms.model.TeachersAwardsRecord;
import com.cqupt.mis.rms.model.TeachingMaterialData;
import com.cqupt.mis.rms.model.TeachingMaterialField;
import com.cqupt.mis.rms.model.TeachingMaterialRecord;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.EducationalReformDataComparator;
import com.cqupt.mis.rms.utils.ExcellentTrainerDataComparator;
import com.cqupt.mis.rms.utils.LearningEvaluationDataComparator;
import com.cqupt.mis.rms.utils.MajorContributeDataComparator;
import com.cqupt.mis.rms.utils.OtherTeachingAwardsDataComparator;
import com.cqupt.mis.rms.utils.QualityProjectDataComparator;
import com.cqupt.mis.rms.utils.StudentAwardsDataComparator;
import com.cqupt.mis.rms.utils.TeachAchievementsDataComparator;
import com.cqupt.mis.rms.utils.TeachingMaterialDataComparator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.emory.mathcs.backport.java.util.TreeSet;

/**
 * 处理教学类信息的查询(排序规则：根据Data类重写的hashcode方法实现的散列)
 * @author Bern
 * 2014.09.28
 */
public class ViewTeachingInfoAction extends ActionSupport {
	private ResearchInfoService researchInfoService;
	private DynamicDataFieldDao dynamicDataFieldDao;
	
	private final String ALLFIELDS = "allFields";	//返回到jsp字段的名字
	private final String RECORDS = "records";	//返回到jsp记录的名字
	
	/**
	 * 查找有关当前用户（session）的学生获奖信息
	 */
	public String viewStudentAwardsRecords() {
		List<StudentAwardsData> sortedFields = new ArrayList<StudentAwardsData>();
		//获取相应的所有字段
		List<StudentAwardsField> fields = dynamicDataFieldDao.findAllFields("StudentAwardsField");	
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<StudentAwardsRecord> studentAwardsRecords = (List<StudentAwardsRecord>) researchInfoService.viewResearchInfo(userId, "StudentAwardsRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(StudentAwardsField field1 : fields) {
			StudentAwardsData studentAwardsData = new StudentAwardsData();
			studentAwardsData.setField(field1);
			studentAwardsData.setValue("");
			sortedFields.add(studentAwardsData);
			for(StudentAwardsRecord record : studentAwardsRecords) {
				Set<StudentAwardsData> datas = record.getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(studentAwardsData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(StudentAwardsRecord record : studentAwardsRecords) {
			Set<StudentAwardsData> datas = record.getFields();
			Set<StudentAwardsData> tempDatas = new HashSet<StudentAwardsData>();
			//找出假删除的字段
			for(StudentAwardsData d : datas) {
				if(d.getField().getIsDelete() == 1) {
					tempDatas.add(d);
				}
			}
			//剔除假删除的字段
			datas.removeAll(tempDatas);
			//按order排序
			Set<StudentAwardsData> sortedDatas = new TreeSet(new StudentAwardsDataComparator());
			sortedDatas.addAll(datas);
			record.setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(StudentAwardsData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put(ALLFIELDS,sortedFields);
		ActionContext.getContext().put(RECORDS, studentAwardsRecords);
		
		
		return SUCCESS;
	}
	
	/**
	 * 查找有关当前用户（session）的教学成果奖信息
	 */
	public String viewTeacherAwardsRecords() {
		List<TeachersAwardsData> sortedFields = new ArrayList<TeachersAwardsData>();
		//获取相应的所有字段
		List<TeachersAwardsField> fields = dynamicDataFieldDao.findAllFields("TeachersAwardsField");	
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<TeachersAwardsRecord> teachersAwardsRecords = (List<TeachersAwardsRecord>) researchInfoService.viewResearchInfo(userId, "TeachersAwardsRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(TeachersAwardsField field1 : fields) {
			TeachersAwardsData teachersAwardsData = new TeachersAwardsData();
			teachersAwardsData.setField(field1);
			teachersAwardsData.setValue("");
			sortedFields.add(teachersAwardsData);
			for(TeachersAwardsRecord record : teachersAwardsRecords) {
				Set<TeachersAwardsData> datas = record.getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(teachersAwardsData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(TeachersAwardsRecord record : teachersAwardsRecords) {
			Set<TeachersAwardsData> datas = record.getFields();
			Set<TeachersAwardsData> tempDatas = new HashSet<TeachersAwardsData>();
			//找出假删除的字段
			for(TeachersAwardsData d : datas) {
				if(d.getField().getIsDelete() == 1) {
					tempDatas.add(d);
				}
			}
			//剔除假删除的字段
			datas.removeAll(tempDatas);
			//按order排序
			Set<TeachersAwardsData> sortedDatas = new TreeSet(new TeachAchievementsDataComparator());
			sortedDatas.addAll(datas);
			record.setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(TeachersAwardsData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put(ALLFIELDS,sortedFields);
		ActionContext.getContext().put(RECORDS, teachersAwardsRecords);
		
		return SUCCESS;
	}
	
	
	/**
	 * 查找有关当前用户（session）的专业建设信息
	 */
	public String viewMajorContributeRecords() {
		List<MajorContributeData> sortedFields = new ArrayList<MajorContributeData>();
		//获取相应的所有字段
		List<MajorContributeField> fields = dynamicDataFieldDao.findAllFields("MajorContributeField");	
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<MajorContributeRecord> majorContributeRecords = (List<MajorContributeRecord>) researchInfoService.viewResearchInfo(userId, "MajorContributeRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(MajorContributeField field1 : fields) {
			MajorContributeData majorContributeData = new MajorContributeData();
			majorContributeData.setField(field1);
			majorContributeData.setValue("");
			sortedFields.add(majorContributeData);
			for(MajorContributeRecord record : majorContributeRecords) {
				Set<MajorContributeData> datas = record.getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(majorContributeData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(MajorContributeRecord record : majorContributeRecords) {
			Set<MajorContributeData> datas = record.getFields();
			Set<MajorContributeData> tempDatas = new HashSet<MajorContributeData>();
			//找出假删除的字段
			for(MajorContributeData d : datas) {
				if(d.getField().getIsDelete() == 1) {
					tempDatas.add(d);
				}
			}
			//剔除假删除的字段
			datas.removeAll(tempDatas);
			//按order排序
			Set<MajorContributeData> sortedDatas = new TreeSet(new MajorContributeDataComparator());
			sortedDatas.addAll(datas);
			record.setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(MajorContributeData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put(ALLFIELDS,sortedFields);
		ActionContext.getContext().put(RECORDS, majorContributeRecords);
		
		return SUCCESS;
	}
	
	/**
	 * 查找有关当前用户（session）的教材立项信息
	 */
	public String viewTeachingMaterialRecords() {
		List<TeachingMaterialData> sortedFields = new ArrayList<TeachingMaterialData>();
		//获取相应的所有字段
		List<TeachingMaterialField> fields = dynamicDataFieldDao.findAllFields("TeachingMaterialField");	
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<TeachingMaterialRecord> teachingMaterialRecords = (List<TeachingMaterialRecord>) researchInfoService.viewResearchInfo(userId, "TeachingMaterialRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(TeachingMaterialField field1 : fields) {
			TeachingMaterialData teachingMaterialData = new TeachingMaterialData();
			teachingMaterialData.setField(field1);
			teachingMaterialData.setValue("");
			sortedFields.add(teachingMaterialData);
			for(TeachingMaterialRecord record : teachingMaterialRecords) {
				Set<TeachingMaterialData> datas = record.getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(teachingMaterialData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(TeachingMaterialRecord record : teachingMaterialRecords) {
			Set<TeachingMaterialData> datas = record.getFields();
			Set<TeachingMaterialData> tempDatas = new HashSet<TeachingMaterialData>();
			//找出假删除的字段
			for(TeachingMaterialData d : datas) {
				if(d.getField().getIsDelete() == 1) {
					tempDatas.add(d);
				}
			}
			//剔除假删除的字段
			datas.removeAll(tempDatas);
			//按order排序
			Set<TeachingMaterialData> sortedDatas = new TreeSet(new TeachingMaterialDataComparator());
			sortedDatas.addAll(datas);
			record.setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(TeachingMaterialData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put(ALLFIELDS,sortedFields);
		ActionContext.getContext().put(RECORDS, teachingMaterialRecords);
		
		return SUCCESS;
	}
	
	/**
	 * 查找有关当前用户（session）的优秀培训师信息
	 */
	public String viewExcellentTrainerRecords() {
		List<ExcellentTrainerData> sortedFields = new ArrayList<ExcellentTrainerData>();
		//获取相应的所有字段
		List<ExcellentTrainerField> fields = dynamicDataFieldDao.findAllFields("ExcellentTrainerField");	
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<ExcellentTrainerRecord> excellentTrainerRecords = (List<ExcellentTrainerRecord>) researchInfoService.viewResearchInfo(userId, "ExcellentTrainerRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(ExcellentTrainerField field1 : fields) {
			ExcellentTrainerData excellentTrainerData = new ExcellentTrainerData();
			excellentTrainerData.setField(field1);
			excellentTrainerData.setValue("");
			sortedFields.add(excellentTrainerData);
			for(ExcellentTrainerRecord record : excellentTrainerRecords) {
				Set<ExcellentTrainerData> datas = record.getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(excellentTrainerData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(ExcellentTrainerRecord record : excellentTrainerRecords) {
			Set<ExcellentTrainerData> datas = record.getFields();
			Set<ExcellentTrainerData> tempDatas = new HashSet<ExcellentTrainerData>();
			//找出假删除的字段
			for(ExcellentTrainerData d : datas) {
				if(d.getField().getIsDelete() == 1) {
					tempDatas.add(d);
				}
			}
			//剔除假删除的字段
			datas.removeAll(tempDatas);
			//按order排序
			Set<ExcellentTrainerData> sortedDatas = new TreeSet(new ExcellentTrainerDataComparator());
			sortedDatas.addAll(datas);
			record.setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(ExcellentTrainerData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put(ALLFIELDS,sortedFields);
		ActionContext.getContext().put(RECORDS, excellentTrainerRecords);
		
		return SUCCESS;
	}
	
	/**
	 * 查找有关当前用户（session）的质量工程信息
	 */
	public String viewQualityProjectRecords() {
		List<QualityProjectData> sortedFields = new ArrayList<QualityProjectData>();
		//获取相应的所有字段
		List<QualityProjectField> fields = dynamicDataFieldDao.findAllFields("QualityProjectField");	
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<QualityProjectRecord> qualityProjectRecords = (List<QualityProjectRecord>) researchInfoService.viewResearchInfo(userId, "QualityProjectRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(QualityProjectField field1 : fields) {
			QualityProjectData qualityProjectData = new QualityProjectData();
			qualityProjectData.setField(field1);
			qualityProjectData.setValue("");
			sortedFields.add(qualityProjectData);
			for(QualityProjectRecord record : qualityProjectRecords) {
				Set<QualityProjectData> datas = record.getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(qualityProjectData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(QualityProjectRecord record : qualityProjectRecords) {
			Set<QualityProjectData> datas = record.getFields();
			Set<QualityProjectData> tempDatas = new HashSet<QualityProjectData>();
			//找出假删除的字段
			for(QualityProjectData d : datas) {
				if(d.getField().getIsDelete() == 1) {
					tempDatas.add(d);
				}
			}
			//剔除假删除的字段
			datas.removeAll(tempDatas);
			//按order排序
			Set<QualityProjectData> sortedDatas = new TreeSet(new QualityProjectDataComparator());
			sortedDatas.addAll(datas);
			record.setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(QualityProjectData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put(ALLFIELDS,sortedFields);
		ActionContext.getContext().put(RECORDS, qualityProjectRecords);
		
		return SUCCESS;
	}
	
	/**
	 * 查找有关当前用户（session）的学评教信息
	 */
	public String viewLearningEvaluationRecords() {
		List<LearningEvaluationData> sortedFields = new ArrayList<LearningEvaluationData>();
		//获取相应的所有字段
		List<LearningEvaluationField> fields = dynamicDataFieldDao.findAllFields("LearningEvaluationField");	
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<LearningEvaluationRecord> learningEvaluationRecords = (List<LearningEvaluationRecord>) researchInfoService.viewResearchInfo(userId, "LearningEvaluationRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(LearningEvaluationField field1 : fields) {
			LearningEvaluationData learningEvaluationData = new LearningEvaluationData();
			learningEvaluationData.setField(field1);
			learningEvaluationData.setValue("");
			sortedFields.add(learningEvaluationData);
			for(LearningEvaluationRecord record : learningEvaluationRecords) {
				Set<LearningEvaluationData> datas = record.getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(learningEvaluationData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(LearningEvaluationRecord record : learningEvaluationRecords) {
			Set<LearningEvaluationData> datas = record.getFields();
			Set<LearningEvaluationData> tempDatas = new HashSet<LearningEvaluationData>();
			//找出假删除的字段
			for(LearningEvaluationData d : datas) {
				if(d.getField().getIsDelete() == 1) {
					tempDatas.add(d);
				}
			}
			//剔除假删除的字段
			datas.removeAll(tempDatas);
			//按order排序
			Set<LearningEvaluationData> sortedDatas = new TreeSet(new LearningEvaluationDataComparator());
			sortedDatas.addAll(datas);
			record.setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(LearningEvaluationData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put(ALLFIELDS,sortedFields);
		ActionContext.getContext().put(RECORDS, learningEvaluationRecords);
		
		return SUCCESS;
	}
	
	/**
	 * 查找有关当前用户（session）的教改项目结题信息
	 */
	public String viewEducationalReformRecords() {
		List<EducationalReformData> sortedFields = new ArrayList<EducationalReformData>();
		//获取相应的所有字段
		List<EducationalReformField> fields = dynamicDataFieldDao.findAllFields("EducationalReformField");	
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<EducationalReformRecord> educationalReformRecords = (List<EducationalReformRecord>) researchInfoService.viewResearchInfo(userId, "EducationalReformRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(EducationalReformField field1 : fields) {
			EducationalReformData educationalReformData = new EducationalReformData();
			educationalReformData.setField(field1);
			educationalReformData.setValue("");
			sortedFields.add(educationalReformData);
			for(EducationalReformRecord record : educationalReformRecords) {
				Set<EducationalReformData> datas = record.getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(educationalReformData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(EducationalReformRecord record : educationalReformRecords) {
			Set<EducationalReformData> datas = record.getFields();
			Set<EducationalReformData> tempDatas = new HashSet<EducationalReformData>();
			//找出假删除的字段
			for(EducationalReformData d : datas) {
				if(d.getField().getIsDelete() == 1) {
					tempDatas.add(d);
				}
			}
			//剔除假删除的字段
			datas.removeAll(tempDatas);
			//按order排序
			Set<EducationalReformData> sortedDatas = new TreeSet(new EducationalReformDataComparator());
			sortedDatas.addAll(datas);
			record.setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(EducationalReformData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put(ALLFIELDS,sortedFields);
		ActionContext.getContext().put(RECORDS, educationalReformRecords);
		
		return SUCCESS;
	}
	
	/**
	 * 查找有关当前用户（session）的其他获奖信息
	 */
	public String viewOtherTeachingAwardsRecords() {
		List<OtherTeachingAwardsData> sortedFields = new ArrayList<OtherTeachingAwardsData>();
		//获取相应的所有字段
		List<OtherTeachingAwardsField> fields = dynamicDataFieldDao.findAllFields("OtherTeachingAwardsField");	
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<OtherTeachingAwardsRecord> otherTeachingAwardsRecords = (List<OtherTeachingAwardsRecord>) researchInfoService.viewResearchInfo(userId, "OtherTeachingAwardsRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(OtherTeachingAwardsField field1 : fields) {
			OtherTeachingAwardsData otherTeachingAwardsData = new OtherTeachingAwardsData();
			otherTeachingAwardsData.setField(field1);
			otherTeachingAwardsData.setValue("");
			sortedFields.add(otherTeachingAwardsData);
			for(OtherTeachingAwardsRecord record : otherTeachingAwardsRecords) {
				Set<OtherTeachingAwardsData> datas = record.getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(otherTeachingAwardsData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(OtherTeachingAwardsRecord record : otherTeachingAwardsRecords) {
			Set<OtherTeachingAwardsData> datas = record.getFields();
			Set<OtherTeachingAwardsData> tempDatas = new HashSet<OtherTeachingAwardsData>();
			//找出假删除的字段
			for(OtherTeachingAwardsData d : datas) {
				if(d.getField().getIsDelete() == 1) {
					tempDatas.add(d);
				}
			}
			//剔除假删除的字段
			datas.removeAll(tempDatas);
			//按order排序
			Set<OtherTeachingAwardsData> sortedDatas = new TreeSet(new OtherTeachingAwardsDataComparator());
			sortedDatas.addAll(datas);
			record.setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(OtherTeachingAwardsData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put(ALLFIELDS,sortedFields);
		ActionContext.getContext().put(RECORDS, otherTeachingAwardsRecords);
		
		return SUCCESS;
	}
	
	
	public ResearchInfoService getResearchInfoService() {
		return researchInfoService;
	}
	public void setResearchInfoService(ResearchInfoService researchInfoService) {
		this.researchInfoService = researchInfoService;
	}
	public DynamicDataFieldDao getDynamicDataFieldDao() {
		return dynamicDataFieldDao;
	}

	public void setDynamicDataFieldDao(DynamicDataFieldDao dynamicDataFieldDao) {
		this.dynamicDataFieldDao = dynamicDataFieldDao;
	}
	
}
