package com.cqupt.mis.rms.model;

import java.util.Date;

public class Positions {
	private int positionId;
	private CQUPTUser user;
	private String positionName;
	private Date timePositionBegin;
	private Date timePositionEnd;
	private String remarks;
	
	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public CQUPTUser getUser() {
		return user;
	}

	public void setUser(CQUPTUser user) {
		this.user = user;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Date getTimePositionBegin() {
		return timePositionBegin;
	}

	public void setTimePositionBegin(Date timePositionBegin) {
		this.timePositionBegin = timePositionBegin;
	}

	public Date getTimePositionEnd() {
		return timePositionEnd;
	}

	public void setTimePositionEnd(Date timePositionEnd) {
		this.timePositionEnd = timePositionEnd;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
