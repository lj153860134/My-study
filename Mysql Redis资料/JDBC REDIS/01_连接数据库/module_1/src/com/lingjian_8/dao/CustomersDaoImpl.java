package com.lingjian_8.dao;

import com.lingjian_2.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2019-12-13 21:44
 **/
public class CustomersDaoImpl extends BaseDao<Customers> implements CustomersDao {
    @Override
    public void insert(Connection conn, Customers customer) {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        update(conn, sql, customer.getName(), customer.getEmail(), customer.getBirth());

    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql="delete from customers where id =?";
        update(conn,sql,id);

    }

    @Override
    public void update(Connection conn, Customers customer) {
        String sql = "update customers set name=?,email=?,birth=? where id =?";
        update(conn,sql,customer.getName(), customer.getEmail(), customer.getBirth(),customer.getId());
    }

    @Override
    public Customers getCustomerById(Connection conn, int id) {
        String sql="select id,name,email,birth from customers where id=?";
        return getInstance(conn,sql,id);
    }

    @Override
    public List<Customers> getAll(Connection conn) {
        String sql="select id,name,email,birth from customers";
        return getForList(conn,sql);
    }

    @Override
    public long getCount(Connection conn) {
        String sql="select count(*) from customers";
        return getValue(conn,sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql="select Max(birth) from customers";
        return getValue(conn,sql);
    }
}
