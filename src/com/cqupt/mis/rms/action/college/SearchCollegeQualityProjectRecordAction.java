package com.cqupt.mis.rms.action.college;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.DynamicDataFieldDao;
import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.QualityProjectData;
import com.cqupt.mis.rms.model.QualityProjectField;
import com.cqupt.mis.rms.model.QualityProjectRecord;
import com.cqupt.mis.rms.model.QualityRecordAward;
import com.cqupt.mis.rms.service.QualityProjectRecordInfoService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.cqupt.mis.rms.utils.QualityProjectDataComparator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.emory.mathcs.backport.java.util.TreeSet;

public class SearchCollegeQualityProjectRecordAction extends ActionSupport {
	private DynamicDataFieldDao dynamicDataFieldDao;
	private SearchCQUPTUserService searchCQUPTUserService;
	private QualityProjectRecordInfoService qualityProjectRecordInfoService;
	private List<ModelInfo<QualityProjectRecord, QualityRecordAward>> qualityProjectRecordInfos;
	
	private String roleId;
	
	private String stringName1;
	private String stringValue1;
	
	private String stringName2;
	private String stringValue2;
	
	private String stringName3;
	private String stringValue3;
	
	private String stringName4;
	private String stringValue4;
	private String type;
	
	/**
	 * 查询管辖范围内的所有质量工程记录
	 */
	public void findAllQualityProjectRecordInfo(){
		/*
		 * 取出当前登录角色的id
		 */
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.qualityProjectRecordInfos = qualityProjectRecordInfoService.findAllQualityProjectRecordInfo(cquptUsers);
	}
	
	public String execute() {
		
		this.findAllQualityProjectRecordInfo();
		this.qualityProjectRecordInfos = qualityProjectRecordInfoService.searchQualityProjectRecordInfoByStringFactor(qualityProjectRecordInfos, "status", "2");
		
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				qualityProjectRecordInfos = qualityProjectRecordInfoService.searchQualityProjectRecordInfoByStringFactor(qualityProjectRecordInfos, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				qualityProjectRecordInfos = qualityProjectRecordInfoService.searchQualityProjectRecordInfoByStringFactor(qualityProjectRecordInfos, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				qualityProjectRecordInfos = qualityProjectRecordInfoService.searchQualityProjectRecordInfoByStringFactor(qualityProjectRecordInfos, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				qualityProjectRecordInfos = qualityProjectRecordInfoService.searchQualityProjectRecordInfoByStringFactor(qualityProjectRecordInfos, stringName4, stringValue4);
			}
		}
		
		/*
		 * 将动态字段的输出序列化
		 */
		List<QualityProjectData> sortedFields = new ArrayList<QualityProjectData>();
		//获取相应的所有字段
		List<QualityProjectField> fields = dynamicDataFieldDao.findAllFields("QualityProjectField");	
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(QualityProjectField field1 : fields) {
			QualityProjectData qualityProjectData = new QualityProjectData();
			qualityProjectData.setField(field1);
			qualityProjectData.setValue("");
			sortedFields.add(qualityProjectData);
			for(ModelInfo<QualityProjectRecord, QualityRecordAward> info : qualityProjectRecordInfos) {
				Set<QualityProjectData> datas = info.getModel().getFields();
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(qualityProjectData);
			} 
		}
		
		//剔除已经假删除的字段,并将每个record的fields值按Order排序
		for(ModelInfo<QualityProjectRecord, QualityRecordAward> info : qualityProjectRecordInfos) {
			Set<QualityProjectData> datas = info.getModel().getFields();
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
			info.getModel().setFields(sortedDatas);
		}		
		
		StringBuilder temp = new StringBuilder();
		temp.append("{ \"field\": [");
		for(QualityProjectData data : sortedFields) {
			temp.append(" { \"des\":\""+data.getField().getDescription()+"\" },");
		}
		String json = temp.substring(0, temp.length()-1);
		json += "] }";
		
		//将序列化话的值放入值栈
		ActionContext.getContext().put("fieldJson",json);
		ActionContext.getContext().put("fields", sortedFields);
		ActionContext.getContext().put("qualityProjectInfos", qualityProjectRecordInfos);
		type="search";
		
		return "SUCCESS";

	}

	public DynamicDataFieldDao getDynamicDataFieldDao() {
		return dynamicDataFieldDao;
	}

	public void setDynamicDataFieldDao(DynamicDataFieldDao dynamicDataFieldDao) {
		this.dynamicDataFieldDao = dynamicDataFieldDao;
	}

	public SearchCQUPTUserService getSearchCQUPTUserService() {
		return searchCQUPTUserService;
	}

	public void setSearchCQUPTUserService(
			SearchCQUPTUserService searchCQUPTUserService) {
		this.searchCQUPTUserService = searchCQUPTUserService;
	}

	public QualityProjectRecordInfoService getQualityProjectRecordInfoService() {
		return qualityProjectRecordInfoService;
	}

	public void setQualityProjectRecordInfoService(
			QualityProjectRecordInfoService qualityProjectRecordInfoService) {
		this.qualityProjectRecordInfoService = qualityProjectRecordInfoService;
	}

	public List<ModelInfo<QualityProjectRecord, QualityRecordAward>> getQualityProjectRecordInfos() {
		return qualityProjectRecordInfos;
	}

	public void setQualityProjectRecordInfos(
			List<ModelInfo<QualityProjectRecord, QualityRecordAward>> qualityProjectRecordInfos) {
		this.qualityProjectRecordInfos = qualityProjectRecordInfos;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getStringName1() {
		return stringName1;
	}

	public void setStringName1(String stringName1) {
		this.stringName1 = stringName1;
	}

	public String getStringValue1() {
		return stringValue1;
	}

	public void setStringValue1(String stringValue1) {
		this.stringValue1 = stringValue1;
	}

	public String getStringName2() {
		return stringName2;
	}

	public void setStringName2(String stringName2) {
		this.stringName2 = stringName2;
	}

	public String getStringValue2() {
		return stringValue2;
	}

	public void setStringValue2(String stringValue2) {
		this.stringValue2 = stringValue2;
	}

	public String getStringName3() {
		return stringName3;
	}

	public void setStringName3(String stringName3) {
		this.stringName3 = stringName3;
	}

	public String getStringValue3() {
		return stringValue3;
	}

	public void setStringValue3(String stringValue3) {
		this.stringValue3 = stringValue3;
	}

	public String getStringName4() {
		return stringName4;
	}

	public void setStringName4(String stringName4) {
		this.stringName4 = stringName4;
	}

	public String getStringValue4() {
		return stringValue4;
	}

	public void setStringValue4(String stringValue4) {
		this.stringValue4 = stringValue4;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
