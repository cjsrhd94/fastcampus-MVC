package com.fastcampus.controller.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletEngineListener implements ServletContextListener {

//    public ServletEngineListener() {
//        System.out.println("===> ServletEngineListener ����");
//    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("---> contextInitialized() ȣ��");
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("---> contextDestroyed() ȣ��");
    }	
}














