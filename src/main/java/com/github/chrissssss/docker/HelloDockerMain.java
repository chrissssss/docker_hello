package com.github.chrissssss.docker;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

public class HelloDockerMain {
    public static void main(String[] args) throws SQLException, InterruptedException {
        System.out.println("Hello World! This is java. I'm speaking from docker here! Really!");

        for (int retries = 20; retries > 0; retries--) {
            try {
                SimpleDriverDataSource ds = new SimpleDriverDataSource();
                ds.setDriver(new com.mysql.jdbc.Driver());
                ds.setUrl("jdbc:mysql://container2:3306/testdb");
                ds.setUsername("user7");
                ds.setPassword("secret");

                String sql = "SELECT Count(*) FROM tutorials_tbl";

                JdbcTemplate jtm = new JdbcTemplate(ds);
                int numOfCars = jtm.queryForObject(sql, Integer.class);

                System.out.format("There are %d cars in the table", numOfCars);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Sleeping 5 sec");
            Thread.sleep(5000);

        }
    }
}
