package com.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTransactionMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transaction-config.xml");
        AccountTransaction accountTransaction =   applicationContext.getBean(AccountTransaction.class);
        accountTransaction.transfer("Kishan","Kamini",5000);
        System.out.println("Done");
    }
}
