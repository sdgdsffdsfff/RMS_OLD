package com.cqupt.mis.rms.utils;

/**
 * 动态数据字段的工具类
 * @author Bern
 *
 */
public class DynamicDataFieldUtils {
	
	/**
	 * 根据数字获取动态字段类的名字
	 * @param num
	 * @return java类名
	 */
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
	
	/**
	 * 根据数字获取动态字段类信息名字
	 * @param num
	 * @return 前台展示中文名
	 */
	public static String getInfoNameByClassNum(int num) {
		String infoName = null;
		switch (num) {
		case 1:		//专业建设/教改项目信息
			infoName = "发表教改论文";
			break;
		case 2:		//优秀培训师的字段类
			infoName = "教学技术奖";
			break;
		case 3:     //教学成果奖信息字段类
			infoName = "教学成果奖";
			break;
		case 4:		//教材立项信息
			infoName = "教材出版";
			break;
		case 5:		//学生获奖信息的字段类
			infoName = "指导学生参赛获奖";
			break;
		case 6:		//质量工程获奖信息的字段类
			infoName = "本科教学工程";
			break;
		case 7:		//学评教信息的字段类
			infoName = "重庆市大学生创新创业训练计划项目";
			break;
		case 8:		//教改项目结题信息的字段类
			infoName = "教改项目";
			break;
		case 9:		//其他教学奖励信息的字段类
			infoName = "其他获奖信息";
			break;
		default:
			break;
		}
		return infoName;
	}
	
	/**
	 * 根据数字获取动态字段记录类的名字
	 * @param num
	 * @return java类名
	 */
	public static String getRecordNameByClassNum(int num) {
		String recordName = null;
		switch (num) {
		case 1:		//专业建设/教改项目信息的记录类
			recordName = "MajorContributeRecord";
			break;
		case 2:		//优秀培训师的记录类
			recordName = "ExcellentTrainerRecord";
			break;
		case 3:     //教学成果奖信息记录类
			recordName = "TeachersAwardsRecord";
			break;
		case 4:		//教材立项信息
			recordName = "TeachingMaterialRecord";
			break;
		case 5:		//学生获奖信息的记录类
			recordName = "StudentAwardsRecord";
			break;
		case 6:		//质量工程的记录类
			recordName = "QualityProjectRecord";
			break;
		case 7:		//学评教的记录类
			recordName = "LearningEvaluationRecord";
			break;
		case 8:		//教改项目结题的记录类
			recordName = "EducationalReformRecord";
			break;
		case 9:		//其他教学奖励的记录类
			recordName = "OtherTeachingAwardsRecord";
			break;
		default:
			break;
		}
		return recordName;
	}
	
	/**
	 * 根据数字获取动态字段数据类的名字
	 * @param num
	 * @return java类名
	 */
	public static String getDataNameByClassNum(int num) {
		String dataName = null;
		switch (num) {
		case 1:		//专业建设/教改项目信息的字段类
			dataName = "MajorContributeData";
			break;
		case 2:		//优秀培训师的字段类
			dataName = "ExcellentTrainerData";
			break;
		case 3:     //教学成果奖信息字段类
			dataName = "TeachersAwardsData";
			break;
		case 4:		//教材立项信息
			dataName = "TeachingMaterialData";
			break;
		case 5:		//学生获奖信息的字段类
			dataName = "StudentAwardsData";
			break;
		case 6:		//质量工程的字段类
			dataName = "QualityProjectData";
			break;
		case 7:		//学评教的字段类
			dataName = "LearningEvaluationData";
			break;
		case 8:		//教改项目结题的字段类
			dataName = "EducationalReformData";
			break;
		case 9:		//其他教学奖励的字段类
			dataName = "OtherTeachingAwardsData";
			break;
		default:
			break;
		}
		return dataName;
	}
	
	/**
	 * 根据数字获取动态字段类的比较器的名字
	 * @param num
	 * @return java类名
	 */
	public static String getDataComparatorNameByClassNum(int num) {
		String comparatorName = null;
		switch (num) {
		case 1:		//专业建设/教改项目信息的字段类
			comparatorName = "MajorContributeDataComparator";
			break;
		case 2:		//优秀培训师的字段类
			comparatorName = "ExcellentTrainerDataComparator";
			break;
		case 3:     //教学成果奖信息字段类
			comparatorName = "TeachersAwardsDataComparator";
			break;
		case 4:		//教材立项信息
			comparatorName = "TeachingMaterialDataComparator";
			break;
		case 5:		//学生获奖信息的字段类
			comparatorName = "StudentAwardsDataComparator";
			break;
		case 6:		//质量工程的字段类
			comparatorName = "QualityProjectDataComparator";
			break;
		case 7:		//学评教的字段类
			comparatorName = "LearningEvaluationDataComparator";
			break;
		case 8:		//教改项目结题的字段类
			comparatorName = "EducationalReformDataComparator";
			break;
		case 9:		//其他教学奖励的字段类
			comparatorName = "OtherTeachingAwardsDataComparator";
			break;
		default:
			break;
		}
		return comparatorName;
	}
	
}
