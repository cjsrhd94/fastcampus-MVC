package com.fastcampus.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
		
	// JoinPoint�� �ٸ� �Ű������� ���� ���Ǵ� ���, �ݵ�� ù ��° �Ű������� ����Ǿ�� �Ѵ�. 	
	@AfterThrowing(pointcut = "BoardPointcut.allPointcut()", throwing = "exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName();
		System.out.println("[ ���� ó�� ] " + method + "() �޼ҵ� ������ ���� �߻� : " + exceptionObj.getMessage());

		// �߻��� ������ Ÿ�Կ� ���� ����ó�� ������ �б��Ų��.
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("0�� ���� ����� ���� �����ϴ�.");
		} else if(exceptionObj instanceof ArithmeticException) {
			System.out.println("0���� ���ڸ� ���� ���� �����ϴ�.");
		} else if(exceptionObj instanceof SQLException) {
			System.out.println("SQL ������ ������ �ֽ��ϴ�.");
		} else {
			System.out.println("�ý��ۿ� ������ �ֽ��ϴ�.");
		}
	}
}
