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
	private final String ALLFIELDS = "allFields";	//返回到jsp字段的名字
	private final String RECORDS = "records";	//返回到jsp记录的名字
	
	/**
	 * 查找有关当前用户（session）的学生获奖信息
	 */
	public String viewStudentAwardsRecords() {
		Set<StudentAwardsData> sortedFields2 = new HashSet<StudentAwardsData>();
		//获取相应的所有字段
		List<StudentAwardsField> fields = searchDao.SearchObjectsByFactor("StudentAwardsField", "isDelete", 0);		
		//获取相应的学生获奖信息数据
		String userId = (String)ActionContext.getContext().getSession().get("userId");
		List<StudentAwardsRecord> studentAwardsRecords = (List<StudentAwardsRecord>) researchInfoService.viewResearchInfo(userId, "StudentAwardsRecord");
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(StudentAwardsField field1 : fields) {
			StudentAwardsData studentAwardsData = new StudentAwardsData();
			studentAwardsData.setField(field1);
			studentAwardsData.setValue("");
			sortedFields2.add(studentAwardsData);
			for(StudentAwardsRecord record : studentAwardsRecords) {
				Set<StudentAwardsData> datas = record.getFields();
				Set<StudentAwardsData> tempDatas = new HashSet<StudentAwardsData>();
				//剔除已经假删除的字段
				for(StudentAwardsData d : datas) {
					if(d.getField().getIsDelete() == 1) {
						tempDatas.add(d);
					}
				}
				datas.removeAll(tempDatas);
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(studentAwardsData);
			} 
		}
		ActionContext.getContext().put(ALLFIELDS, sortedFields2);
		ActionContext.getContext().put(RECORDS, studentAwardsRecords);
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
