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
//        System.out.println("===> TimeCheckFilter 생성");
//    }
    
	public void init(FilterConfig fConfig) throws ServletException {}                              

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 브라우저의 요청 path 정보를 추출한다.
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		long startTime = System.currentTimeMillis();
		
		// 이 시점에 브라우저가 요청한 서블릿이 실행된다. 
		chain.doFilter(request, response);    
		
		long endTime = System.currentTimeMillis();
		System.out.println(path + " 요청 처리에 소요된 시간 : " + (endTime - startTime) + "(ms)초");
	}

	public void destroy() {	}

}
