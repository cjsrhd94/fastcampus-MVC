package com.fastcampus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        System.out.println("로그아웃 기능 처리");
        session.invalidate();
        return "login.html";
    }
}
