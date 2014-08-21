/**
 * 
 */
package com.cqupt.mis.rms.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * 测试抽象类
 * @author lim
 *
 */
@SuppressWarnings("deprecation")
public abstract class AbstractTest extends AbstractDependencyInjectionSpringContextTests{
	protected ApplicationContext context;
	protected BeanFactory factory;
	//加载XML文件
	protected void config(){
		context = new FileSystemXmlApplicationContext(new String[] { "classpath:config/applicationContext-*.xml"});    
	    factory = (BeanFactory) context;
	}
	
	protected Object configYourManager(String beanName){
		config();
		return factory.getBean(beanName);
	}
	//初始化
	public abstract void init();
}
