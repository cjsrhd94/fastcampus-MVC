package com.fastcampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.fastcampus.biz.user.UserVO;

@Service
@Aspect
public class BeforeAdvice { 
	
	// Around�� ��ϵǴ� �޼ҵ常 ProceedingJoinPoint�� �ް� �������� 
	// ProceedingJoinPoint�� �θ��� JoinPoint�� �޾ƾ� �Ѵ�.
	@Before("BoardPointcut.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		
		// JoinPoint�� getArgs() �޼ҵ带 �̿��ϸ� ����Ͻ� �޼ҵ� ȣ�� �� ���޵� ���� �� �� �ִ�. 
		Object[] args = jp.getArgs();
		
		System.out.println("[ ���� ó�� ] " + method + 
			"() �޼ҵ� ARGS ���� : " + args[0].toString());
	}
	
	@AfterReturning(pointcut = "BoardPointcut.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[ ���� ó�� ] " + method + "() �޼ҵ��� ���� �� : " + returnObj.toString());
		
		// ����Ͻ� �޼ҵ尡 ������ ��ü�� UserVO Ÿ���� ��ü���� Ȯ��
		if(returnObj instanceof UserVO) {
			// UserVO Ÿ���� ��ü�� ���ϵƴٸ� UserVO Ÿ������ ����ȯ
			UserVO user = (UserVO) returnObj;
			// ADMIN ������ ���� ����ڰ� �˻� �ƴ��� Ȯ��
			if(user.getRole().equals("ADMIN")) {
				// ������ ���� �������� �����Ѵ�.
				System.out.println(user.getName() + "�����ڴ� ������ ���� �������� �̵��մϴ�....");
			}
		}
	}
}
