package com.cqupt.mis.rms.action.college;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.StudentAwardsData;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.cqupt.mis.rms.model.StudentAwardsRecord;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.MyDynamicFieldComparator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理教学类信息的查询(排序规则：根据Data类重写的hashcode方法实现的散列)
 * @author Bern
 * 2014.09.28
 */
public class ViewTeachingInfoAction extends ActionSupport {
	private ResearchInfoService researchInfoService;
	private SearchDao searchDao;
	
	/**
	 * 查找学生获奖信息
	 */
	public String viewStudentAwardsRecords() {
//		TreeSet<StudentAwardsData> sortedFields = new TreeSet<StudentAwardsData>(new MyDynamicFieldComparator());
		Set<StudentAwardsData> sortedFields2 = new HashSet<StudentAwardsData>();
		//获取相应的所有字段
		List<StudentAwardsField> fields = searchDao.SearchObjectsByFactor("StudentAwardsField", "isDelete", 0);		
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<StudentAwardsRecord> stuAwardsRecords = (List<StudentAwardsRecord>) researchInfoService.viewResearchInfo(userId, "StudentAwardsRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(StudentAwardsField field1 : fields) {
			StudentAwardsData studentAwardsData = new StudentAwardsData();
			studentAwardsData.setField(field1);
			studentAwardsData.setValue("");
//			sortedFields.add(studentAwardsData);
			sortedFields2.add(studentAwardsData);
			for(StudentAwardsRecord record : stuAwardsRecords) {
				record.getFields().add(studentAwardsData);
			} 
		}
		//将每条记录的字段排好序
//		for(StudentAwardsRecord record : stuAwardsRecords) {
//			TreeSet<StudentAwardsData> sortedFieldsTmp = new TreeSet<StudentAwardsData>(new MyDynamicFieldComparator());
//			sortedFieldsTmp.addAll(record.getFields());
//			record.setFields(sortedFieldsTmp);
//		}
//		ActionContext.getContext().put("allData", sortedFields);
//		ActionContext.getContext().put("records", stuAwardsRecords);
		
		ActionContext.getContext().put("allData", sortedFields2);
		ActionContext.getContext().put("records", stuAwardsRecords);
		return SUCCESS;
	}
	
	public ResearchInfoService getResearchInfoService() {
		return researchInfoService;
	}
	public void setResearchInfoService(ResearchInfoService researchInfoService) {
		this.researchInfoService = researchInfoService;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	
}
