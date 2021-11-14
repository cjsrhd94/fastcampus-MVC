package com.fastcampus.controller.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = "*.do", 
           initParams = {@WebInitParam(name = "encoding", value = "EUC-KR"), 
        		         @WebInitParam(name = "message", value = "Hello!!!")})
public class CharacterEncodingFilter implements Filter {
	private String boardEncoding;

//    public CharacterEncodingFilter() {
//    	System.out.println("===> CharacterEncodingFilter 생성");
//    }

	public void init(FilterConfig fConfig) throws ServletException {
		boardEncoding = fConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 모든 서블릿이 실행되기 전에 인코딩을 일괄적으로 처리한다. 
		request.setCharacterEncoding(boardEncoding);
		
		chain.doFilter(request, response);		
	}

	public void destroy() {}
}
