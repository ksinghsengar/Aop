package com.spring.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * Created by krishan on 7/10/2017.
 */
public class AccountService
{
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

    @Transactional(isolation = Isolation.READ_UNCOMMITTED,rollbackFor = RuntimeException.class)
    public void create(String name, Integer balance) {
        String SQL = "insert into UserAccount (name, balance) values (?, ?)";
        jdbcTemplate.update( SQL, new Object[]{name,balance});
        System.out.println("Created Record Name = " + name + " Balance = " + balance);

    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED,readOnly = true)
    public void getAccount(String name) {
        String SQL = "select * from useraccount where name = ?";
        System.out.println(jdbcTemplate.queryForMap(SQL, new Object[]{name}));
    }


    public void delete(String name){
        String SQL = "delete from useraccount where name = ?";
        jdbcTemplate.update(SQL, name);
        System.out.println("Deleted Record with Name = " + name );
        return;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED,rollbackFor = RuntimeException.class)
    public void update(String name, Integer balance){
        String SQL = "update useraccount set balance = ? where name = ?";
        jdbcTemplate.update(SQL, balance,name);
        System.out.println("Updated Record with Name = " + name );
        return;
    }

}
