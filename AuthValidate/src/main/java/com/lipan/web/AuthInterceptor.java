package com.lipan.web;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
			AuthPassport authPassport = ((HandlerMethod)handler).getMethodAnnotation(AuthPassport.class);
			
			if(authPassport == null || authPassport.validate()== false){
				return true;
			}else{
				if(false){
					return true;
				}else{
					response.sendRedirect("login");
					return false;
				}
			}
		}else{
			return true;
		}
	}
}
