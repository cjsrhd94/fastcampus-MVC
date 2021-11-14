package com.fastcampus.controller.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "*.do")
public class TimeCheckFilter implements Filter {

//    public TimeCheckFilter() { 
//        System.out.println("===> TimeCheckFilter ����");
//    }
    
	public void init(FilterConfig fConfig) throws ServletException {}                              

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// �������� ��û path ������ �����Ѵ�.
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		long startTime = System.currentTimeMillis();
		
		// �� ������ �������� ��û�� ������ ����ȴ�. 
		chain.doFilter(request, response);    
		
		long endTime = System.currentTimeMillis();
		System.out.println(path + " ��û ó���� �ҿ�� �ð� : " + (endTime - startTime) + "(ms)��");
	}

	public void destroy() {	}

}
