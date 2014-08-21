package com.cqupt.mis.rms.model;

import java.io.Serializable;

/**
 * <p>
 * Title:角色模块信息
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author LM
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class Rolepurview implements Serializable {
	// 角色实体
	private CQUPTRole roleinfo;
	// 模块实体
	private Purviewinfo purviewinfo;

	public CQUPTRole getRoleinfo() {
		return roleinfo;
	}

	public void setRoleinfo(CQUPTRole roleinfo) {
		this.roleinfo = roleinfo;
	}

	public Purviewinfo getPurviewinfo() {
		return purviewinfo;
	}

	public void setPurviewinfo(Purviewinfo purviewinfo) {
		this.purviewinfo = purviewinfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((roleinfo == null) ? 0 : roleinfo.hashCode());
		result = prime * result
				+ ((purviewinfo == null) ? 0 : purviewinfo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rolepurview other = (Rolepurview) obj;
		if (roleinfo == null) {
			if (other.roleinfo != null)
				return false;
		} else if (!roleinfo.equals(other.roleinfo))
			return false;
		if (purviewinfo == null) {
			if (other.purviewinfo != null)
				return false;
		} else if (!purviewinfo.equals(other.purviewinfo))
			return false;
		return true;
	}
}
