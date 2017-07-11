package com.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by krishan on 7/10/2017.
 */
public class TransactionMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction-config.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.create("Kishan",70000);
        accountService.create("Kamini",70000);
//        accountService.getAccount("Kishan");
//        accountService.update("Kishan",80000);
//        accountService.delete("Kishan");
        System.out.println("Done");
    }
}
