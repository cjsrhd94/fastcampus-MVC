package com.fastcampus.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoardPointcut {
	@Pointcut("execution(* com.fastcampus.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.fastcampus.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@Pointcut("execution(* com.fastcampus.biz.board.*Impl.*(..))")
	public void boardPointcut() {}
	
	@Pointcut("execution(* com.fastcampus.biz.user.*Impl.*(..))")
	public void userPointcut() {}
}
