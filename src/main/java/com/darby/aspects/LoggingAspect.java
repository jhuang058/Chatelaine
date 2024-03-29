package com.darby.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	
	private static Logger log = LogManager.getLogger(LoggingAspect.class);

	@Before("within(com.darby.services.*)")
	public void logModelMethods(JoinPoint jp) {
		log.info(jp.getTarget()+" invoked "+jp.getSignature());
	}
	
	@AfterReturning(pointcut="execution(String fight(..))", returning = "returnedObject")
	public void logFight(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked "+jp.getSignature()+" returning "+returnedObject);
	}
	
	@AfterThrowing(pointcut="execution(String fight(..))", throwing= "ex")
	public void logFightException(JoinPoint jp, Exception ex) {
		log.warn(jp.getTarget()+" invoked "+jp.getSignature()+" throwing "+ex.getClass());
	}

}
