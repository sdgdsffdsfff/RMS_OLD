package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.LearningEvaluationData;

/**
 * 学评教信息Data类的比较器
 * @author Bern
 *
 */
public class LearningEvaluationDataComparator implements Comparator<LearningEvaluationData> {

	@Override
	public int compare(LearningEvaluationData o1, LearningEvaluationData o2) {
		if(o1.getField().getOrder() > o2.getField().getOrder()) {
			return 1;
		} else if(o1.getField().getOrder() == o2.getField().getOrder()) {
			return 0;
		} else {
			return -1;
		}
	}

}
