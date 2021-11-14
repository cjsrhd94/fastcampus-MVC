package com.fastcampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect // Aspect = Pointcut(핵심 관심) + Advice(횡단 관심)
public class AroundAdvice { 

	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		// JoinPoint를 상속한 ProceedingJoinPoint를 이용하면 클라이언트가 호출한 비즈니스 메소드 정보를 알 수 있다.
		String method = jp.getSignature().getName();

		Object returnObj = null;

		StopWatch watch = new StopWatch();
		watch.start();
		// 실제 클라이언트가 호출한 비즈니스 메소드가 실행되는 시점
		returnObj = jp.proceed(); 
		watch.stop();
		System.out.println(method + "() 메소드 수행에 소요된 시간 : " + watch.getTotalTimeSeconds() + "(초)");
		
		return returnObj;
	}
}
