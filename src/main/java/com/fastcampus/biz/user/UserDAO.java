package com.fastcampus.biz.user;

import java.util.List;

public interface UserDAO {
    // USERS 관련 CRUD(Create(INSERT), Read(SELECT), Update, Delete) 메소드 구현
    // 회원 등록
    void insertUser(UserVO vo);

    // 회원 수정
    void updateUser(UserVO vo);

    // 회원 삭제
    void deleteUser(UserVO vo);

    // 회원 상세 조회
    UserVO getUser(UserVO vo);

    // 회원 목록 조회
    List<UserVO> getUserList(UserVO vo);
}
