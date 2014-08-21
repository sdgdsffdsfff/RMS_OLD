package com.cqupt.mis.rms.model;

/**
 * <p>
 * Title:技术转让负责人信息
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
public class ScienceTransferLeader {
	//该表的ID
	private int id;
	//技术转让
	private ScienceTechTransfer scienceTechTransfer;
	//负责人ID
	private String leaderId;
	//负责人姓名
	private String leaderName;
	//负责人在获奖中的排名
	private int orders;
	//备注
	private String remarks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
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
	public ScienceTechTransfer getScienceTechTransfer() {
		return scienceTechTransfer;
	}
	public void setScienceTechTransfer(ScienceTechTransfer scienceTechTransfer) {
		this.scienceTechTransfer = scienceTechTransfer;
	}
}
