package com.fastcampus.controller.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletEngineListener implements ServletContextListener {

//    public ServletEngineListener() {
//        System.out.println("===> ServletEngineListener 생성");
//    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("---> contextInitialized() 호출");
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("---> contextDestroyed() 호출");
    }	
}














