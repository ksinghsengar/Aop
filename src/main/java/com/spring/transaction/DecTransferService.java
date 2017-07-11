package com.spring.transaction;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class DecTransferService {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

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

    @Transactional
    public void transfer(String name1, String name2, Integer balance) {
        try {
            String SQL = "update useraccount set balance = balance-? where name = ?";
            jdbcTemplate.update(SQL, new Object[]{balance,name1});
            String SQL2 = "update useraccount set balance = balance+? where name = ?";
            jdbcTemplate.update(SQL2,new Object[]{balance,name2});
            System.out.println("Successfully transfered " + balance + " from " + name1 + " to " + name2);

        }
        catch (DataAccessException exception){
            System.out.println("Exception occured");
        }

    }



}
