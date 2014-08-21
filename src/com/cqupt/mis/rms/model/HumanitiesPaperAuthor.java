package com.cqupt.mis.rms.model;

public class HumanitiesPaperAuthor {
	private int id;
	private HumanitiesPaper humanitiesPaper;
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

	public HumanitiesPaper getHumanitiesPaper() {
		return humanitiesPaper;
	}

	public void setHumanitiesPaper(HumanitiesPaper humanitiesPaper) {
		this.humanitiesPaper = humanitiesPaper;
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
