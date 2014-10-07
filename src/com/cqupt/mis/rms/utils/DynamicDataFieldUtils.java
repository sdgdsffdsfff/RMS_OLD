package com.cqupt.mis.rms.utils;

/**
 * 动态数据字段的工具类
 * @author Bern
 *
 */
public class DynamicDataFieldUtils {
	
	public static String getClassNameByClassNum(int num) {
		String className = null;
		switch (num) {
		case 1:		//专业建设/教改项目信息
			className = "MajorContributeField";
			break;
		case 2:
			className = null;
			break;
		case 3:
			className = null;
			break;
		case 4:		//教材立项信息
			className = "TeachingMaterialField";
			break;
		case 5:		//学生获奖信息的字段类
			className = "StudentAwardsField";
			break;
		default:
			break;
		}
		return className;
	}
	
	public static String getInfoNameByClassNum(int num) {
		String infoName = null;
		switch (num) {
		case 1:		//专业建设/教改项目信息
			infoName = "专业建设/教改项目信息";
			break;
		case 2:
			infoName = null;
			break;
		case 3:
			infoName = null;
			break;
		case 4:		//教材立项信息
			infoName = "教材立项信息";
			break;
		case 5:		//学生获奖信息的字段类
			infoName = "学生获奖信息";
			break;
		default:
			break;
		}
		return infoName;
	}
}
