/**
 * 
 */
package com.cqupt.mis.rms.service.model;

import java.util.List;

import com.cqupt.mis.rms.model.Purviewinfo;

/**
 * <p>
 * Title:封装一级和二级菜单
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
public class MenuInfo {
	// 一级菜单
	private Purviewinfo first;
	// 二级菜单
	private List<Purviewinfo> second;

	public Purviewinfo getFirst() {
		return first;
	}

	public void setFirst(Purviewinfo first) {
		this.first = first;
	}

	public List<Purviewinfo> getSecond() {
		return second;
	}

	public void setSecond(List<Purviewinfo> second) {
		this.second = second;
	}

}
