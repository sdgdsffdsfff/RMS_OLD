package com.cqupt.mis.rms.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 可动态添加数据库字段的类
 * 教改结题的记录类
 * @author Bern
 * 2014.10.21
 */
public class EducationalReformRecord implements Serializable {
	private String id;		//记录id
	private String name;		//记录的名字
	private String returnReason;		//未通过审核的原因
	private int status;		//记录的状态
	private String statusDes;
	private Set<EducationalReformData> fields;		//记录的动态字段
	private String fieldsJson;		//动态字段类的json格式
	
	private CQUPTUser submitUser;		//记录的提交者
	private CQUPTUser approvedUser;		//记录的审核者
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<EducationalReformData> getFields() {
		return fields;
	}

	public void setFields(Set<EducationalReformData> fields) {
		this.fields = fields;
	}

	public CQUPTUser getSubmitUser() {
		return submitUser;
	}

	public void setSubmitUser(CQUPTUser submitUser) {
		this.submitUser = submitUser;
	}

	public CQUPTUser getApprovedUser() {
		return approvedUser;
	}

	public void setApprovedUser(CQUPTUser approvedUser) {
		this.approvedUser = approvedUser;
	}

	/**
	 * 返回相应状态码的状态描述
	 * @return statusDes
	 */
	public String getStatusDes() {
		switch (status) {
		case 0:
			statusDes = "已保存";
			break;
		case 1:
			statusDes = "未审批";
			break;
		case 2:
			statusDes = "审批通过";
			break;
		case 3:
			statusDes = "审批未通过";
			break;
		default:
			statusDes = "";
			break;
		}
		return statusDes;
	}
	
	/**
	 * 返回字段集合的json格式(只有值)
	 * @return 
	 */
	public String getFieldsJson() {
		fieldsJson = "";
		
		if(fields != null) {
			StringBuilder temp = new StringBuilder();
			temp.append("{ [");
			for(EducationalReformData d : fields) {
				temp.append("{ \"value\":\" "+d.getValue()+"\" }, ");
			}
			fieldsJson = temp.substring(0, temp.length()-2);
			fieldsJson = fieldsJson +" ] }";
		}
		//System.out.println("fieldJson:"+fieldsJson);
		return fieldsJson;
	}
}
