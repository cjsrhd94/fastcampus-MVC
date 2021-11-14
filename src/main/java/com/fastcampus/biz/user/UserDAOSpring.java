package com.fastcampus.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// DAO(Data Access Object)
@Repository
public class UserDAOSpring {
	
	@Autowired
	private JdbcTemplate spring;
	
	// BOARD 관련 SQL 명령어들
	private final String USER_INSERT = "insert into users values (?, ?, ?, sysdate, ?)";
	private final String USER_UPDATE = "update users set role = ? where id = ?";
	private final String USER_DELETE = "delete users where id = ?";
	private final String USER_GET    = "select * from users where id = ? and password = ?";
	private final String USER_LIST   = "select * from users order by seq desc";
	
	// USERS 관련 CRUD(Create(INSERT), Read(SELECT), Update, Delete) 메소드 구현
	// 회원 등록
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 insertUser() 기능 처리");
		spring.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}
	
	// 회원 수정
	public void updateUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 updateUser() 기능 처리");
		spring.update(USER_UPDATE, vo.getRole(), vo.getId());
	}
	
	// 회원 삭제
	public void deleteUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 deleteUser() 기능 처리");
		spring.update(USER_DELETE, vo.getId());
	}
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 getUser() 기능 처리");
		Object[] params = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, params, new UserRowMapper());
	}
	
	// 회원 목록 조회
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> SPRING 기반으로 getUserList() 기능 처리");
		return spring.query(USER_LIST, new UserRowMapper());
	}
}
