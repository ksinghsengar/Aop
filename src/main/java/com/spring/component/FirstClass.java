package com.spring.component;

import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class FirstClass {

    public void display(){
        System.out.println("Display method in FirstClass Called");
    }
/*@Deprecated
    public void display2(){
        System.out.println("Display2 method in FirstClass Called");
    }*/

    void exceptionThrowing() throws IOException {
        System.out.println("Inside Excetion Throwing Method");
        throw  new IOException();
    }
}
