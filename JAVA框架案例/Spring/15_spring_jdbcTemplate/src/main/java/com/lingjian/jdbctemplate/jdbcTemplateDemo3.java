package com.lingjian.jdbctemplate;

import com.lingjian.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @description: JdbcTemplate的CRUD操作
 * @author: Ling Jian
 * @date: 2020-02-16 16:10
 **/
public class jdbcTemplateDemo3 {
    public static void main(String[] args) {

        //获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //执行操作
        //保存
//        jt.update("insert into account(name,money) values (?,?)","fff",1000);
        //更新
//        jt.update("update account set money=? where id=?",2000,8);
        //删除
//        jt.update("delete from account where id=?",8);s
        //查询所有
//        List<Account> list=jt.query("select * from account where money=?",new AccountRowMapper(),1000f);
//        List<Account> list=jt.query("select * from account where money=?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
//
//        for (Account account : list) {
//            System.out.println(account);
//        }

        //查询一个
//        List<Account> list1=jt.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),4);
//
//        for (Account account : list1) {
//            System.out.println(account);
//        }

        //查询一行一列
        int result=jt.queryForObject("select count(*) from account where money=?",Integer.class,1000f);
        System.out.println(result);
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据分装打Account中 然后由spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account=new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
