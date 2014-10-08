package com.cqupt.mis.rms.model;

import java.util.HashSet;
import java.util.Set;

public class TeachersAwardsRecord {
	
	private String id;
	private String name;
	private CQUPTUser submitUser;
	private CQUPTUser approvedUser;
	private int status;
	private String returnReason;
	private String statusDes;
	private Set<TeachersAwardsData> fields ;
	
		
	
	public void setStatusDes(String statusDes) {
		this.statusDes = statusDes;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public Set<TeachersAwardsData> getFields() {
		return fields;
	}


	public void setFields(Set<TeachersAwardsData> fields) {
		this.fields = fields;
	}
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
}
