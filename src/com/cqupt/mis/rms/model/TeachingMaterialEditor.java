package com.cqupt.mis.rms.model;

/**
 * <p>
 * Title:教材主编信息
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author LvHai
 * @version 1.0
 * */
public class TeachingMaterialEditor {
	//该表的ID
	private int id;
	//教材立项
	private TeachingMaterialSet teachingMaterialSet;
	//主编ID
	private String editorId;
	//主编姓名
	private String editorName;
	//主编在获奖中的排名
	private int orders;
	//备注(排名明细)
	private String remarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEditorId() {
		return editorId;
	}
	public void setEditorId(String editorId) {
		this.editorId = editorId;
	}
	public String getEditorName() {
		return editorName;
	}
	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public TeachingMaterialSet getTeachingMaterialSet() {
		return teachingMaterialSet;
	}
	public void setTeachingMaterialSet(TeachingMaterialSet teachingMaterialSet) {
		this.teachingMaterialSet = teachingMaterialSet;
	}
}
