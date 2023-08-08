package com.hotel.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Tien
 *
 * class AuthenticationInterceptor
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

	@Autowired
	private HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		
		 if (session.getAttribute("userName") != null) {
			 
			 return true; 
		 }
		 
		 response.sendRedirect("Login");
		  
		 return false;
		 
	}
}
