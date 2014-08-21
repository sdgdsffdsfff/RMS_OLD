package com.cqupt.mis.rms.model;

public class HumanitiesExchangePaperAuthor {
	private int id;
	private HumanitiesExchangePaper humanitiesExchangePaper;
	private String authorId;
	private String authorName;
	private int orders;
	private String task;
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HumanitiesExchangePaper getHumanitiesExchangePaper() {
		return humanitiesExchangePaper;
	}

	public void setHumanitiesExchangePaper(
			HumanitiesExchangePaper humanitiesExchangePaper) {
		this.humanitiesExchangePaper = humanitiesExchangePaper;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
