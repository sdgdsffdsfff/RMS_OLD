package com.bern.dynamic.field.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.StudentAwardsData;
import com.cqupt.mis.rms.model.StudentAwardsField;
import com.cqupt.mis.rms.model.StudentAwardsRecord;

public class StudentAwardsTest {
	ApplicationContext ac;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("config/applicationContext-*.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void saveTest() {
		StudentAwardsField field1;
		StudentAwardsField field2;
		SessionFactory sf;
		Session session;
		Set<StudentAwardsData> fields = new HashSet<StudentAwardsData>();
		
		//读取出已有的字段
		sf = (SessionFactory) ac.getBean("sessionFactory");
		session = sf.openSession();
		session.beginTransaction();
		field1 = (StudentAwardsField) session.get(com.cqupt.mis.rms.model.StudentAwardsField.class, 1);
		field2 = (StudentAwardsField) session.get(com.cqupt.mis.rms.model.StudentAwardsField.class, 2);
		session.getTransaction().commit();
		session.close();
		
		System.out.println(field1);
		System.out.println(field2);
		
		/*
		 * 构造数据，构造一个StudentAwardsRecord对象
		 */
		StudentAwardsRecord record = new StudentAwardsRecord();
		record.setId("20140920");
		record.setName("test");
		record.setStatus(0);
		
		StudentAwardsData data1 = new StudentAwardsData();
		data1.setAwards(record);
		data1.setField(field1);
		data1.setValue("20140101");
		StudentAwardsData data2= new StudentAwardsData();
		data2.setAwards(record);
		data2.setField(field2);
		data2.setValue("bern");
		fields.add(data1);
		fields.add(data2);
		record.setFields(fields);
		
		CQUPTUser user = new CQUPTUser();
		user.setUserId("admin");
		record.setSubmitUser(user);
		
		System.out.println(record);
		
		//进行存储测试
		session = sf.openSession();
		session.beginTransaction();
		session.save(record);
		session.getTransaction().commit();
		sf.close();
	}
	
	@Test
	public void deleteTest() {
		SessionFactory sf;
		Session session;
		
		sf = (SessionFactory) ac.getBean("sessionFactory");
		session = sf.openSession();
		session.beginTransaction();
		StudentAwardsRecord record = (StudentAwardsRecord) session.get(com.cqupt.mis.rms.model.StudentAwardsRecord.class, "20140920");
		session.delete(record);
		session.getTransaction().commit();
	}
	
	@Test
	public void findTest() {
		SessionFactory sf;
		Session session;
	
		sf = (SessionFactory) ac.getBean("sessionFactory");
		session = sf.openSession();
		session.beginTransaction();
		StudentAwardsRecord record = (StudentAwardsRecord) session.get(com.cqupt.mis.rms.model.StudentAwardsRecord.class, "20140920");
		
		Set<StudentAwardsData> datas = record.getFields();
		Iterator it = datas.iterator();
		while(it.hasNext()) {
			StudentAwardsData data = (StudentAwardsData) it.next();
			System.out.println("动态字段名："+data.getField().getDescription()+" ## 动态字段值："+data.getValue());
		}
		session.getTransaction().commit();
	
	}

}
