package com.cqupt.mis.rms.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String getProp(String key){
		Properties p = new Properties();
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("beans.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
}
