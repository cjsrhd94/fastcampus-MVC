package com.fastcampus.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� �����Ѵ�.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml"); 
		
		// 2. �׽�Ʈ ��ü�� Lookup�Ѵ�. 
		UserService userService = (UserService) container.getBean("userService");

		// 3. ��ü�� �׽�Ʈ�Ѵ�. 
		UserVO vo = new UserVO();
		vo.setId("aaa");
		vo.setPassword("aaa");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ���մϴ�.");
		} else {
			System.out.println("�α��� ����");
		}
		
		// 4. �����̳ʸ� �����Ѵ�. 
		container.close();
	}
}
























