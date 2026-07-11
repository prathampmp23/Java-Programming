package com.cts.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExternalLogic {
	Logger logger = LoggerFactory.getLogger(ExternalLogic.class);

	@Pointcut("execution (void com.cts.springaop.BussinessLogic.*())")
	public void serviceMethod() {
	}

//	@After("serviceMethod()")
	@Before("serviceMethod()")
	public void log(JoinPoint joinPoint) {
		logger.info("Log is called on Method --> " + joinPoint.getSignature().getName() + " with arguments : "
				+ joinPoint.getArgs());
	}

//	@Around("serviceMethod()" )
	// @After("serviceMethod()" )
	@Before("execution (void com.cts.springaop.BussinessLogic.*())")
	public void sendMail(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("email confirmation about product is send");
		joinPoint.proceed();
		System.out.println("email confirmation about product is send - After order placed");
	}

	// @AfterReturning(pointcut = "execution(String
	// com.cts.springaop.BussinessLogic.*())", returning="address")
	// public void afterReturningAddress(JoinPoint joinPoint, String address) {
	// public void afterThrowingException(JoinPoint joinPoint, String address) {
	@AfterThrowing(pointcut = "execution(String com.cts.springaop.BussinessLogic.*())", throwing = "ex")
	public void afterThrowingException(JoinPoint joinPoint, Exception ex) {
		/// System.out.println("executing after returning the value from business class");
		// System.out.println("The returned value is : "+address);
		System.out.println("The returned exception msg :" + ex.getMessage());
	}
}
