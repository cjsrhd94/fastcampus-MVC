package com.fastcampus.controller.user;

import com.fastcampus.biz.user.UserService;
import com.fastcampus.biz.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public String login(UserVO vo, HttpSession session) {
        System.out.println("로그인 기능 처리");
        UserVO user = userService.getUser(vo);
        if (user != null) {
            session.setAttribute("user", user);
            return "getBoardList.do";
        } else {
            return "login.html";
        }
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        System.out.println("로그아웃 기능 처리");
        session.invalidate();
        return "login.html";
    }
}
