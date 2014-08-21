package com.cqupt.mis.rms.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLGet {
	private static ApplicationContext tx;
	static{
		tx = new ClassPathXmlApplicationContext(new String[]{"classpath:config/applicationContext-*.xml"});
	}
	private XMLGet(){}
	public static ApplicationContext getXMLFile(){
		return tx;		
	}
}
