package com.spring.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by krishan on 7/10/2017.
 */
public class SecondClassMain {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop-spring-config.xml");
        SecondClass secondClass = applicationContext.getBean(SecondClass.class);
        secondClass.display();
        System.out.println("Exit Main");
    }
}
