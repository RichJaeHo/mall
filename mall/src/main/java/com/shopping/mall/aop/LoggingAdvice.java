package com.shopping.mall.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Component
public class LoggingAdvice {

	@Autowired
	@Qualifier(value="txManager")
	private PlatformTransactionManager txManager;
	
	@Around("execution(* com.shopping.mall.dao..*.*(..))")
	public Object daoTx(ProceedingJoinPoint jp){
		
		String className = jp.getTarget().getClass().getSimpleName();
		String methodName = jp.getSignature().getName();
		
		//System.out.println(String.format("시작 클래스 : %s / 메서드 : %s / 시간 : %d", className, methodName, System.currentTimeMillis()));
		
		TransactionStatus txStatus = 
				txManager.getTransaction(new DefaultTransactionDefinition());
		
		Object returnValue = null;		
		try {
			returnValue = jp.proceed();
			txManager.commit(txStatus);
		} catch (Throwable e) {
			txManager.rollback(txStatus);
		}
		
		//System.out.println(String.format("종료 클래스 : %s / 메서드 : %s / 시간 : %d", className, methodName, System.currentTimeMillis()));
		
		return returnValue;		
	}
	
	
}
