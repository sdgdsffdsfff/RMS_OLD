package com.cqupt.mis.rms.model;

import java.io.Serializable;
import java.util.Set;

/*
 * 可动态添加数据库字段的类
 * 记录类
 * @author Bern
 * 2014.9.20
 */

public class StudentAwardsRecord implements Serializable {
	private String id;		//记录id
	private String name;		//记录的名字
	private String returnReason;		//未通过审核的原因
	private int status;		//记录的状态
	private Set<StudentAwardsData> fields;		//记录的动态字段
	
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
	public Set<StudentAwardsData> getFields() {
		return fields;
	}
	public void setFields(Set<StudentAwardsData> fields) {
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
	
}
