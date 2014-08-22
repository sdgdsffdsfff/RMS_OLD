/**
 * 
 */
package com.cqupt.mis.rms.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

import com.cqupt.mis.rms.manager.PurviewDao;
import com.cqupt.mis.rms.manager.RoleInfoDao;
import com.cqupt.mis.rms.manager.RolePurviewDao;
import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.model.Rolepurview;


/**
 * 该类主要用于获取相应的访问相应资源所需要的权限
 * 
 * @author Bern
 *
 */
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
	private PurviewDao purviewDao;
	private RoleInfoDao roleInfoDao;
	private RolePurviewDao rolePurviewDao;
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	public MyFilterInvocationSecurityMetadataSource() {
		loadOnStartup();
	}


	public void loadOnStartup() {
		String[] locations = {"classpath:config/applicationContext-commons.xml","classpath:config/applicationContext-beans.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(locations);
		purviewDao = (PurviewDao) ac.getBean("purviewDao");
		roleInfoDao = (RoleInfoDao) ac.getBean("roleInfoDao");
		rolePurviewDao = (RolePurviewDao) ac.getBean("rolePurviewDao");
		List<CQUPTRole> allRole = roleInfoDao.findRoleInfoList(0, 5);		//获取全部角色？？

		/*
		 * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
		 */
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		
		for (CQUPTRole role : allRole) {
			ConfigAttribute ca = new SecurityConfig(String.valueOf(role.getRoleId()));
			List<Rolepurview> rolePurviewList = rolePurviewDao.findRolePurviewListByroleId(role.getRoleId());		//获取相应角色的相应合法资源信息	
			
			for (Rolepurview rolePurview : rolePurviewList) {
				String url = rolePurview.getPurviewinfo().getPurviewUrl();		
				
				/*
				 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。
				 */
				if(url == null) {	//一级菜单url为空！url检验匹配时会报空指针错误		本类117行
					url = "NoURL";
					if (resourceMap.containsKey(url)) {
						continue;
					}
				}
				if (resourceMap.containsKey(url)) {
					Collection<ConfigAttribute> value = resourceMap.get(url);
					value.add(ca);
					resourceMap.put(url, value);
				} else {
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
					atts.add(ca);
					resourceMap.put(url, atts);
				}
			}
		}
		
	}
	
	
	/*
	 * 根据URL，找到相关的权限配置。
	 * @return Collection<ConfigAttribute> 返回相应url的授权信息(roleId)
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		
		UrlMatcher urlMatcher = new AntUrlPathMatcher();
		String url = ((FilterInvocation) object).getRequestUrl();		// object 是一个URL，被用户请求的url。
		
		/*
		 * 去掉url的参数
		 */
		int firstQuestionMarkIndex = url.indexOf("?");
		if (firstQuestionMarkIndex != -1) {
			url = url.substring(1, firstQuestionMarkIndex);
		} else {
			url = url.substring(1);	
		}

		Iterator<String> ite = resourceMap.keySet().iterator();

		while (ite.hasNext()) {
			String resURL = ite.next();		
			if (urlMatcher.pathMatchesUrl(url, resURL)) {
				return resourceMap.get(resURL);
			}
		}

		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		//TODO ????
		Collection<ConfigAttribute> returnCollection = new ArrayList<ConfigAttribute>();
		returnCollection.add(new SecurityConfig("1"));
		returnCollection.add(new SecurityConfig("2"));
		returnCollection.add(new SecurityConfig("3"));
		returnCollection.add(new SecurityConfig("4"));
		return returnCollection;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	public PurviewDao getPurviewDao() {
		return purviewDao;
	}

	public void setPurviewDao(PurviewDao purviewDao) {
		this.purviewDao = purviewDao;
	}

	public RoleInfoDao getRoleInfoDao() {
		return roleInfoDao;
	}

	public void setRoleInfoDao(RoleInfoDao roleInfoDao) {
		this.roleInfoDao = roleInfoDao;
	}

	public RolePurviewDao getRolePurviewDao() {
		return rolePurviewDao;
	}

	public void setRolePurviewDao(RolePurviewDao rolePurviewDao) {
		this.rolePurviewDao = rolePurviewDao;
	}
}
