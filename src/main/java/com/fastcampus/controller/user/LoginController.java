package com.fastcampus.controller.user;

import com.fastcampus.biz.user.UserDAO;
import com.fastcampus.biz.user.UserVO;
import com.fastcampus.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그인 기능 처리");

        // 1. 사용자 입력정보 추출
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // 2. DB 연동 처리
        UserVO vo = new UserVO();
        vo.setId(id);
        vo.setPassword(password);

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUser(vo);

        // 3. 응답 화면 구성
        if (user != null) {
            // 로그인 성공 시 세션(내장객체)에 사용자 정보를 저장한다.
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "getBoardList.do";
        } else {
            return "login.html";
        }
    }
}
