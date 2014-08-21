package com.cqupt.mis.rms.service.model;

import java.util.List;

public class ProjectInfo<T1, T2, T3> {
	private T1 project;
	private List<T2> detail;
	private List<T3> member;

	public T1 getProject() {
		return project;
	}

	public void setProject(T1 project) {
		this.project = project;
	}

	public List<T2> getDetail() {
		return detail;
	}

	public void setDetail(List<T2> detail) {
		this.detail = detail;
	}

	public List<T3> getMember() {
		return member;
	}

	public void setMember(List<T3> member) {
		this.member = member;
	}

}
