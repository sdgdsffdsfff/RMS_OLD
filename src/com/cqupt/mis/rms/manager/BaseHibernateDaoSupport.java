package com.cqupt.mis.rms.manager;

/**
 * <p>Title:所有持久化类的根类，主要提供分页功能</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author LM
 * @version 1.0
 * */
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class BaseHibernateDaoSupport extends HibernateDaoSupport {
	private int totalNumber;

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	/**
	 * 使用HQL语句进行分页查询 hql：需要查询的HQL语句 offset：第一条记录的索引 pageSize：每页需要显示的记录数
	 * */
	@SuppressWarnings("rawtypes")
	public List findByPage(final String hql, final int offset,
			final int pageSize) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallback借口时必须实现的如下方法
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				// 执行Hibernate分页查询
				Query query = session.createQuery(hql);
				List list = query.list();
				if(!list.isEmpty()){
					int count  = list.size();
					setTotalNumber(count);
				}else{
					setTotalNumber(0);
				}
				List result = query.setFirstResult(offset).setMaxResults(pageSize).list();			
				return result;
			}
		});
		return list;
	}

	/**
	 * 使用HQL语句进行分页查询 hql：需要查询的HQL语句 offset：第一条记录的索引 value:
	 * 如果HQL语句有一个参数需要传入，则value就是传入的参数值 pageSize：每页需要显示的记录数
	 * */
	@SuppressWarnings("rawtypes")
	public List findByPage(final String hql, final Object value,
			final int offset, final int pageSize) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallback借口时必须实现的如下方法
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				// 执行Hibernate分页查询

				Query query = session.createQuery(hql).setParameter(0, value);
				List list = query.list();
				if(!list.isEmpty()){
					int count  = list.size();
					setTotalNumber(count);
				}else{
					setTotalNumber(0);
				}
				List result = query.setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * 使用HQL语句进行分页查询 hql：需要查询的HQL语句 offset：第一条记录的索引 values:
	 * 如果HQL语句有多个参数需要传入，则values就是传入的参数值 pageSize：每页需要显示的记录数
	 * */
	@SuppressWarnings("rawtypes")
	public List findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallback借口时必须实现的如下方法
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// 执行Hibernate分页查询
				Query query = session.createQuery(hql);
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
				List list = query.list();
				if(!list.isEmpty()){
					int count  = list.size();
					setTotalNumber(count);
				}else{
					setTotalNumber(0);
				}			
				List result = query.setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

}
