package com.spring.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class FirstClassMain {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop-spring-config.xml");
        FirstClass firstClass = applicationContext.getBean(FirstClass.class);
        firstClass.display();
//        firstClass.display2();
        firstClass.exceptionThrowing();
        System.out.println("Exit Main");
    }
}
