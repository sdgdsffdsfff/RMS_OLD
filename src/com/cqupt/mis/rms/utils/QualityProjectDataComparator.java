package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.QualityProjectData;

/**
 * 质量工程信息Data类的比较器
 * @author Bern
 *
 */
public class QualityProjectDataComparator implements Comparator<QualityProjectData> {

	@Override
	public int compare(QualityProjectData o1, QualityProjectData o2) {
		if(o1.getField().getOrder() > o2.getField().getOrder()) {
			return 1;
		} else if(o1.getField().getOrder() == o2.getField().getOrder()) {
			return 0;
		} else {
			return -1;
		}
	}

}
