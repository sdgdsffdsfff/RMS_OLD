package com.cqupt.mis.rms.model;

/**
 * 教材立项对应的编辑者类
 * @author Bern
 *
 */
public class TeachingRecordEditor {
	private int id;		//该表的ID
	private TeachingMaterialRecord teachingMaterialRecord;		//教材立项
	private String editorId;		//主编ID
	private String editorName;		//主编姓名
	private int orders;		//主编在获奖中的排名
	private String remarks;		//备注(排名明细)
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TeachingMaterialRecord getTeachingMaterialRecord() {
		return teachingMaterialRecord;
	}
	public void setTeachingMaterialRecord(
			TeachingMaterialRecord teachingMaterialRecord) {
		this.teachingMaterialRecord = teachingMaterialRecord;
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
	
}
