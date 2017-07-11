package com.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by krishan on 7/11/2017.
 */
public class DecTransferMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction-config.xml");
        DecTransferService decTransferService =  applicationContext.getBean(DecTransferService.class);
        decTransferService.transfer("Kamini","Kishan",20000);
        System.out.println("Done");
    }
}
