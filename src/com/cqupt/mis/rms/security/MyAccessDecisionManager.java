/**
 * 
 */
package com.cqupt.mis.rms.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 该类用于进行权限判断，判断某用户是否有权限访问某一资源
 * 
 * @author Bern
 *
 */
public class MyAccessDecisionManager implements AccessDecisionManager{

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		
		if( configAttributes == null ) {
			return ;
		}
		
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		
		while(ite.hasNext()) {
			
			ConfigAttribute ca = ite.next();
			String needRole = ((SecurityConfig)ca).getAttribute();
			
			//ga 为用户所被赋予的权限。 needRole 为访问相应的资源应该具有的权限。
			for(GrantedAuthority ga: authentication.getAuthorities()) {		
				if(needRole.trim().equals(ga.getAuthority().trim())) {
					return ;
				}
			}
		}
		
		throw new AccessDeniedException("");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
