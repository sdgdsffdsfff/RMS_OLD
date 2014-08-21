package com.cqupt.mis.rms.model;

import java.util.Date;

public class Titles {
	private int titlesId;
	private CQUPTUser user;
	private String titlesName;
	private Date timeTitlesBegin;
	private Date timeTitlesEnd;
	private String remarks;


	public int getTitlesId() {
		return titlesId;
	}

	public void setTitlesId(int titlesId) {
		this.titlesId = titlesId;
	}

	public CQUPTUser getUser() {
		return user;
	}

	public void setUser(CQUPTUser user) {
		this.user = user;
	}

	public String getTitlesName() {
		return titlesName;
	}

	public void setTitlesName(String titlesName) {
		this.titlesName = titlesName;
	}

	public Date getTimeTitlesBegin() {
		return timeTitlesBegin;
	}

	public void setTimeTitlesBegin(Date timeTitlesBegin) {
		this.timeTitlesBegin = timeTitlesBegin;
	}

	public Date getTimeTitlesEnd() {
		return timeTitlesEnd;
	}

	public void setTimeTitlesEnd(Date timeTitlesEnd) {
		this.timeTitlesEnd = timeTitlesEnd;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
