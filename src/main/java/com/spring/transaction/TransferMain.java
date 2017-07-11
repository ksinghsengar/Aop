package com.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by krishan on 7/10/2017.
 */
public class TransferMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction-config.xml");
        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transfer("Kamini","Kishan",10000);
        System.out.println("Done");
    }
}
