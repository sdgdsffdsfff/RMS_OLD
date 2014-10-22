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
		case 1:		//专业建设/教改项目信息的字段类
			className = "MajorContributeField";
			break;
		case 2:		//优秀培训师的字段类
			className = "ExcellentTrainerField";
			break;
		case 3:     //教学成果奖信息字段类
			className = "TeachersAwardsField";
			break;
		case 4:		//教材立项信息
			className = "TeachingMaterialField";
			break;
		case 5:		//学生获奖信息的字段类
			className = "StudentAwardsField";
			break;
		case 6:		//质量工程的字段类
			className = "QualityProjectField";
			break;
		case 7:		//学评教的字段类
			className = "LearningEvaluationField";
			break;
		case 8:		//教改项目结题的字段类
			className = "EducationalReformField";
			break;
		case 9:		//其他教学奖励的字段类
			className = "OtherTeachingAwardsField";
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
		case 2:		//优秀培训师的字段类
			infoName = "优秀培训师信息";
			break;
		case 3:     //教学成果奖信息字段类
			infoName = "教学成果奖信息";
			break;
		case 4:		//教材立项信息
			infoName = "教材立项信息";
			break;
		case 5:		//学生获奖信息的字段类
			infoName = "学生获奖信息";
			break;
		case 6:		//学生获奖信息的字段类
			infoName = "质量工程获奖信息";
			break;
		case 7:		//学生获奖信息的字段类
			infoName = "学评教信息";
			break;
		case 8:		//学生获奖信息的字段类
			infoName = "教改项目结题信息";
			break;
		case 9:		//学生获奖信息的字段类
			infoName = "其他教学奖励信息";
			break;
		default:
			break;
		}
		return infoName;
	}
}
