package com.spring.transaction;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class TransferService {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private PlatformTransactionManager platformTransactionManager;

    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void transfer(String name1, String name2, Integer balance) {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus;
        transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

        try {
            String SQL = "update useraccount set balance = balance-? where name = ?";
            jdbcTemplate.update(SQL, new Object[]{balance,name1});
            String SQL2 = "update useraccount set balance = balance+? where name = ?";
            jdbcTemplate.update(SQL2,new Object[]{balance,name2});
            platformTransactionManager.commit(transactionStatus);
            System.out.println("Successfully transfered " + balance + " from " + name1 + " to " + name2);
        }
        catch (DataAccessException exception){
            platformTransactionManager.rollback(transactionStatus);
        }

    }
}