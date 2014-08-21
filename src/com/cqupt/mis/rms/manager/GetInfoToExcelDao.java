package com.cqupt.mis.rms.manager;
/**
 * <p>Title:管理用户登录信息的接口</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
import java.util.List;

public interface GetInfoToExcelDao {

	/**
	 * 通过表的model名字得到相应的信息
	 * @param modelName 需要的信息对应的modelName名称
	 * @return Object 返回相应的信息model
	 * */
	public List<Object> getInfo(String modelName);
    
	/**
	 * 通过某个得到相应的信息
	 * @param id  需要的信息的id
	 * @param modelName 需要的信息对应的modelName名称
	 * @param idName 需要的信息对应的modelName里关于这个id的命名
	 * @return Object 返回相应的信息model
	 * */
	public List<Object> getInfoByFactor(String modelName,String factorName,String factorValue);
	
	public List<Object> getInfoByFactors(String modelName,String factorName,String factorValues);

	
	public Object getUserInfoByFactor(String modelName,String factorName,String factorValue);

}
