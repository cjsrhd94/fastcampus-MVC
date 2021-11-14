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
        System.out.println("===> DispatcherServlet ����");
    }

    public void init(ServletConfig config) throws ServletException {
        handlerMapping = new HandlerMapping();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. ����ڰ� ��û�� path ������ �����Ѵ�.
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println("��û PATH : " + path);

        // 2. ��û path�� �ش��ϴ� Controller ��ü�� �˻��Ѵ�.
        HandlerMapping handlerMapping = new HandlerMapping();
        Controller ctrl = handlerMapping.getController(path);

        String viewPage = ctrl.handleRequest(request, response);

        response.sendRedirect(viewPage);

    }
}




















