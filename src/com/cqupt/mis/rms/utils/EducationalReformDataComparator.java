package com.cqupt.mis.rms.utils;

import java.util.Comparator;

import com.cqupt.mis.rms.model.EducationalReformData;

/**
 * 教改项目结题信息Data类的比较器
 * @author Bern
 *
 */
public class EducationalReformDataComparator implements Comparator<EducationalReformData> {

	@Override
	public int compare(EducationalReformData o1, EducationalReformData o2) {
		if(o1.getField().getOrder() > o2.getField().getOrder()) {
			return 1;
		} else if(o1.getField().getOrder() == o2.getField().getOrder()) {
			return 0;
		} else {
			return -1;
		}
	}

}
