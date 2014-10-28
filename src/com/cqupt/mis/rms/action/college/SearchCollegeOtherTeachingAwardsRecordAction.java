package com.cqupt.mis.rms.action.college;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.OtherTeachingAwardsData;
import com.cqupt.mis.rms.model.OtherTeachingAwardsField;
import com.cqupt.mis.rms.model.OtherTeachingAwardsRecord;
import com.cqupt.mis.rms.model.OtherTeachingRecordAward;
import com.cqupt.mis.rms.service.OtherTeachingAwardsRecordInfoService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;

public class SearchCollegeOtherTeachingAwardsRecordAction {
	private SearchDao searchDao;
	private SearchCQUPTUserService searchCQUPTUserService;
	private OtherTeachingAwardsRecordInfoService otherTeachingAwardsRecordInfoService;
	private List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> otherTeachingAwardsRecordInfos;
	
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
	 * 查询管辖范围内的所有学生获奖记录
	 */
	public void findAllOtherTeachingAwardsRecordInfo(){
		/*
		 * 取出当前登录角色的id
		 */
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.otherTeachingAwardsRecordInfos = otherTeachingAwardsRecordInfoService.findAllOtherTeachingAwardsRecordInfo(cquptUsers);
	}
	
	public String execute() {
		
		this.findAllOtherTeachingAwardsRecordInfo();
		this.otherTeachingAwardsRecordInfos = otherTeachingAwardsRecordInfoService.searchOtherTeachingAwardsRecordInfoByStringFactor(otherTeachingAwardsRecordInfos, "status", "2");
		
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				otherTeachingAwardsRecordInfos = otherTeachingAwardsRecordInfoService.searchOtherTeachingAwardsRecordInfoByStringFactor(otherTeachingAwardsRecordInfos, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				otherTeachingAwardsRecordInfos = otherTeachingAwardsRecordInfoService.searchOtherTeachingAwardsRecordInfoByStringFactor(otherTeachingAwardsRecordInfos, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				otherTeachingAwardsRecordInfos = otherTeachingAwardsRecordInfoService.searchOtherTeachingAwardsRecordInfoByStringFactor(otherTeachingAwardsRecordInfos, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				otherTeachingAwardsRecordInfos = otherTeachingAwardsRecordInfoService.searchOtherTeachingAwardsRecordInfoByStringFactor(otherTeachingAwardsRecordInfos, stringName4, stringValue4);
			}
		}
		
		/*
		 * 将动态字段的输出序列化
		 */
		Set<OtherTeachingAwardsData> sortedFields2 = new HashSet<OtherTeachingAwardsData>();
		//获取相应的所有字段
		List<OtherTeachingAwardsField> fields = searchDao.SearchObjectsByFactor("OtherTeachingAwardsField", "isDelete", 0);	
		//将每条记录中值为空的字段插入，并初始化一个排好序的字段Set
		for(OtherTeachingAwardsField field1 : fields) {
			OtherTeachingAwardsData otherTeachingAwardsData = new OtherTeachingAwardsData();
			otherTeachingAwardsData.setField(field1);
			otherTeachingAwardsData.setValue("");
			sortedFields2.add(otherTeachingAwardsData);
			for(ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward> info : otherTeachingAwardsRecordInfos) {
				Set<OtherTeachingAwardsData> datas = info.getModel().getFields();
				Set<OtherTeachingAwardsData> tempDatas = new HashSet<OtherTeachingAwardsData>();
				//剔除已经假删除的字段
				for(OtherTeachingAwardsData d : datas) {
					if(d.getField().getIsDelete() == 1) {
						tempDatas.add(d);
					}
				}
				datas.removeAll(tempDatas);
				//添加字段，若该字段已存在，则不会添加；若该字段不存在，则添加且置值为“”
				datas.add(otherTeachingAwardsData);
			}
		}
		
		//将序列化话的值放入值栈
		ActionContext.getContext().put("fields", sortedFields2);
		ActionContext.getContext().put("otherTeachingAwardsInfos", otherTeachingAwardsRecordInfos);
		type="search";
		
		return "SUCCESS";

	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	public SearchCQUPTUserService getSearchCQUPTUserService() {
		return searchCQUPTUserService;
	}

	public void setSearchCQUPTUserService(
			SearchCQUPTUserService searchCQUPTUserService) {
		this.searchCQUPTUserService = searchCQUPTUserService;
	}

	public OtherTeachingAwardsRecordInfoService getOtherTeachingAwardsRecordInfoService() {
		return otherTeachingAwardsRecordInfoService;
	}

	public void setOtherTeachingAwardsRecordInfoService(
			OtherTeachingAwardsRecordInfoService otherTeachingAwardsRecordInfoService) {
		this.otherTeachingAwardsRecordInfoService = otherTeachingAwardsRecordInfoService;
	}

	public List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> getOtherTeachingAwardsRecordInfos() {
		return otherTeachingAwardsRecordInfos;
	}

	public void setOtherTeachingAwardsRecordInfos(
			List<ModelInfo<OtherTeachingAwardsRecord, OtherTeachingRecordAward>> otherTeachingAwardsRecordInfos) {
		this.otherTeachingAwardsRecordInfos = otherTeachingAwardsRecordInfos;
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
