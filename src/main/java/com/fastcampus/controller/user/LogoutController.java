package com.fastcampus.controller.user;

import com.fastcampus.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그아웃 기능 처리");

        HttpSession session = request.getSession();

        session.invalidate();

        return "login.html";
    }
}
