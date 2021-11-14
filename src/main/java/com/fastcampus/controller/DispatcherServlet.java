package com.fastcampus.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "*.do")
public class DispatcherServlet extends HttpServlet {
    private HandlerMapping handlerMapping;

    public DispatcherServlet() {
        System.out.println("===> DispatcherServlet 생성");
    }

    public void init(ServletConfig config) throws ServletException {
        handlerMapping = new HandlerMapping();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 사용자가 요청한 path 정보를 추출한다.
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println("요청 PATH : " + path);

        // 2. 요청 path에 해당하는 Controller 객체를 검색한다.
        HandlerMapping handlerMapping = new HandlerMapping();
        Controller ctrl = handlerMapping.getController(path);

        String viewPage = ctrl.handleRequest(request, response);

        response.sendRedirect(viewPage);

    }
}




















