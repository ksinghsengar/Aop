package com.spring.transaction;

        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.transaction.annotation.Transactional;

        import javax.sql.DataSource;

public class AccountTransaction {
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

    @Transactional(rollbackFor = Exception.class)
    public void transfer(String name1, String name2, Integer balance) {

            String SQL = "update useraccount set balance = balance-? where name = ?";
            jdbcTemplate.update(SQL, new Object[]{balance,name1});
            String SQL2 = "update useraccount set balance = balance+? where name = ?";
            jdbcTemplate.update(SQL2,new Object[]{balance,name2});
            System.out.println("Successfully transfered " + balance + " from " + name1 + " to " + name2);
            String SQL3 = "insert into account_transaction (sender,receiver,balance_tranfer) values(?,?,?)";
            jdbcTemplate.update(SQL3,new Object[]{name1,name2,balance});
            System.out.println("Successfully inserted into account_transaction");
            throw new RuntimeException();


        }

    }




