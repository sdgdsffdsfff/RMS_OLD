package com.cqupt.mis.rms.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static Configuration cfg = null;
	private static SessionFactory factory = null;
	static{
		if(cfg == null)
			cfg = new Configuration().configure();
		if(factory == null){
			factory = cfg.buildSessionFactory();
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	
	public static Session getSession(){
		return factory.openSession();
	}
	
	public static void closeSession(Session session){
		if(session != null) session.close();
	}
}
