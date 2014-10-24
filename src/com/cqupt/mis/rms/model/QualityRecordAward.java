package com.cqupt.mis.rms.model;

public class QualityRecordAward {

	private int id;		//逻辑主键
	private QualityProjectRecord qualityProjectRecord;		//质量工程记录
	private String memberId;		//负责人id
	private String memberName;		//负责人名字
	private int orders;			//序号
	private String remarks;			//备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public QualityProjectRecord getQualityProjectRecord() {
		return qualityProjectRecord;
	}
	public void setQualityProjectRecord(QualityProjectRecord qualityProjectRecord) {
		this.qualityProjectRecord = qualityProjectRecord;
	}
	
}
