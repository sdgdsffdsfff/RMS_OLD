package com.cqupt.mis.rms.model;

public class RelationUserRole {
	private int id;
	private RelationUserRolePk relationUserRolePk;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RelationUserRolePk getRelationUserRolePk() {
		return relationUserRolePk;
	}

	public void setRelationUserRolePk(RelationUserRolePk relationUserRolePk) {
		this.relationUserRolePk = relationUserRolePk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
