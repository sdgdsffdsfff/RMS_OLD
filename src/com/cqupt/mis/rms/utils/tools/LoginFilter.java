package com.cqupt.mis.rms.utils.tools;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest objRequest = (HttpServletRequest)request;
		HttpServletResponse objResponse = (HttpServletResponse)response;
		HttpSession session = objRequest.getSession();
		if(session.getAttribute("userId")!=null){
			chain.doFilter(request, response);
		} else {
			System.out.println("filter2");
			objRequest.getRequestDispatcher("/login.jsp").forward(objRequest, objResponse);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
