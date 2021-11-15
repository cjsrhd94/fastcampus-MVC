package com.fastcampus.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fastcampus.biz.common.JDBCUtil;

// DAO(Data Access Object)
//@Repository
public class UserDAOJdbc implements UserDAO {
	// JDBC 관련 변수 선언
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// BOARD 관련 SQL 명령어들
	private final String USER_INSERT = "insert into users values (?, ?, ?, sysdate, ?)";
	private final String USER_UPDATE = "update users set role = ? where id = ?";
	private final String USER_DELETE = "delete users where id = ?";
	private final String USER_GET    = "select * from users where id = ? and password = ?";
	private final String USER_LIST   = "select * from users order by seq desc";
	
	// USERS 관련 CRUD(Create(INSERT), Read(SELECT), Update, Delete) 메소드 구현
	// 회원 등록
	@Override
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 insertUser() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(3, vo.getRole());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 수정
	@Override
	public void updateUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 updateUser() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getRole());
			stmt.setString(2, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 삭제
	@Override
	public void deleteUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 deleteUser() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 상세 조회
	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 getUser() 기능 처리");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRegDate(rs.getDate("REGDATE"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		} 
		return user;
	}
	
	// 회원 목록 조회
	@Override
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> JDBC 기반으로 getUserList() 기능 처리");
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRegDate(rs.getDate("REGDATE"));
				user.setRole(rs.getString("ROLE"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		} 
		return userList;
	}
}
