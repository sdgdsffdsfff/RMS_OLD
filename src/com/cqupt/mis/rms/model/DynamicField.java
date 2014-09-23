package com.cqupt.mis.rms.model;

import java.util.Date;

/*
 * 所有动态字段类都要实现的接口
 * @author Bern
 * 2014.9.23
 */
public interface DynamicField {
	
	//获取id
	public int getId();
	
	//设置id
	public void setId(int id);
	
	//获取数据库名字
	public String getName();
	
	//设置数据库名字
	public void setName(String name);
	
	//获取前台展示名
	public String getDescription();
	
	//设置前台展示名
	public void setDescription(String description);
	
	//设置是否删除标识
	public int getIsDelete();
	
	//获取是否删除的标识
	public void setIsDelete(int isDelete);
	
	//获取提交时间
	public Date getSubmittime();
	
	//设置提交时间
	public void setSubmittime(Date submittime);

}
