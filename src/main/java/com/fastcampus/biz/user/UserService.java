package com.fastcampus.biz.user;

import java.util.List;

public interface UserService {

	// USERS ���� CRUD(Create(INSERT), Read(SELECT), Update, Delete) �޼ҵ� ����
	// ȸ�� ���
	void insertUser(UserVO vo);

	// ȸ�� ����
	void updateUser(UserVO vo);

	// ȸ�� ����
	void deleteUser(UserVO vo);

	// ȸ�� �� ��ȸ
	UserVO getUser(UserVO vo);

	// ȸ�� ��� ��ȸ
	List<UserVO> getUserList(UserVO vo);

}