package br.com.wmw.springframework.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TransactionAspect {

	@Pointcut("execution(* br.com.wmw..service..*Service.*(..))")
	public void isService() {
	}

//	@Pointcut("!@target(org.springframework.transaction.annotation.Transactional)")
//	public void isNotTransactional() {
//	}
//
//	@Pointcut("!@annotation(org.springframework.transaction.annotation.Transactional)")
//	public void isNotTransactionalMethod() {
//	}
//
//	@Pointcut("!@annotation(br.com.wmw.springframework.service.NoTransactional)")
//	public void isNotNoTransactionalMethod() {
//	}

}
