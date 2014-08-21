package com.cqupt.mis.rms.manager;

import java.util.Date;
import java.util.List;

public interface SearchDao {
	//精确查询唯一结果
	public <T,T1> T SearchUniqueObjectsByFactor(String className,String factorName,T1 factorValue);	
	public <T,T1,T2> T SearchUniqueObjectsByFactor(String className,String factorName1,T1 factorValue1,String factorName2,T2 factorValue2);		
	public <T,T1,T2,T3> T SearchUniqueObjectsByFactor(String className,String factorName1,T1 factorValue1,String factorName2,T2 factorValue2,String factorName3,T3 factorValue3);
	public <T,T1,T2,T3,T4> T SearchUniqueObjectsByFactor(String className,String factorName1,T1 factorValue1,String factorName2,T2 factorValue2,String factorName3,T3 factorValue3,String factorName4,T4 factorValue4);
	
	//精确查询结果集
	public <T,T1> List<T> SearchObjectsByFactor(String className,String factorName,T1 factorValue);
	public <T,T1,T2> List<T> SearchObjectsByFactor(String className,String factorName1,T1 factorValue1,String factorName2,T2 factorValue2);
	public <T,T1,T2,T3> List<T> SearchObjectsByFactor(String className,String factorName1,T1 factorValue1,String factorName2,T2 factorValue2,String factorName3,T3 factorValue3);
	public <T,T1,T2,T3,T4> List<T> SearchObjectsByFactor(String className,String factorName1,T1 factorValue1,String factorName2,T2 factorValue2,String factorName3,T3 factorValue3,String factorName4,T4 factorValue4);
	
	//模糊查询结果集
	public <T> List<T> SearchObjectsLikeFactor(String className,String factorName,String factorValue);
	public <T> List<T> SearchObjectsLikeFactor(String className,String factorName1,String factorValue1,String factorName2,String factorValue2);
	public <T> List<T> SearchObjectsLikeFactor(String className,String factorName1,String factorValue1,String factorName2,String factorValue2,String factorName3,String factorValue3);
	public <T> List<T> SearchObjectsLikeFactor(String className,String factorName1,String factorValue1,String factorName2,String factorValue2,String factorName3,String factorValue3,String factorName4,String factorValue4);
		
	//范围查询
	public <T,T1> List<T> SearchObjectsLikeFactor(String className,String factorName,T1 beginFactorValue,T1 endFactorValue);
	
	
	
	public <T> List<T> SearchObjectsLikeDateFactor(String className,String factorName,Date beginFactorValue,Date endFactorValue);
}
