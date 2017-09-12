package com.yjp.config;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(-5)
public class WebLogAspect {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("execution(public * com.yjp.controller.*.*(..))")
	public void webLog(){}
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint){
		logger.info("WebLogAspect.doBefore()");
		ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=attributes.getRequest();
		//记录下请求内容
		logger.info("URL:"+request.getRequestURI().toString());
		logger.info("HTTP_METHOD:"+request.getMethod());
		logger.info("IP:"+request.getRemoteAddr());
		logger.info("CLASS_METHOD:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		logger.info("ARGS:"+Arrays.toString(joinPoint.getArgs()));
		
		 Enumeration<String> enu=request.getParameterNames(); 
		 while(enu.hasMoreElements()){
			 String paraName=enu.nextElement();
			 System.out.println(paraName+":"+request.getParameter(paraName));
		 }
	}
	@AfterReturning("webLog()")
	public void doAfterReturning(JoinPoint ioinPoint){
		logger.info("WebLogAspect.doAfterReturning()");
		System.out.println("我在你后面实现");
	}
	
}
