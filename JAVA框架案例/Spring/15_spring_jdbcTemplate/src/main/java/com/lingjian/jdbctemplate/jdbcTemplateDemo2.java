package com.lingjian.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @description: JdbcTemplate的最基本的用法
 * @author: Ling Jian
 * @date: 2020-02-16 16:10
 **/
public class jdbcTemplateDemo2 {
    public static void main(String[] args) {

        //获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //执行操作
        jt.execute("insert into account(name,money) values ('eee',1000)");
        /*//准备数据源 spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("lj210910");

        //创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();

        //给jt设置数据源
        jt.setDataSource(ds);
        //执行操作
        jt.execute("insert into account(name,money) values ('ddd',1000)");
        */

    }
}
