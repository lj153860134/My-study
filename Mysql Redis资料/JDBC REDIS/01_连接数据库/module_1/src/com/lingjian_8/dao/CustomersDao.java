package com.lingjian_8.dao;

import com.lingjian_2.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 此接口用于规范针对于Customers表的常用操作
 */
public interface CustomersDao {
    /**
     * @description: 将customers对象添加导数据库中
     * @param: [conn, customer]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/13 9:34 下午
     */
    public abstract void insert(Connection conn, Customers customer);

    /**
     * @description: 根据指定id删除表中的一条记录
     * @param: [conn, id]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/13 9:35 下午
     */
    public abstract void deleteById(Connection conn, int id);

    /**
     * @description: 根据customer修改表中一条记录
     * @param: [conn, id, customer]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/13 9:36 下午
     */
    public abstract void update(Connection conn, Customers customer);

    /**
     * @description: 根据指定的id查询对应的customer对象
     * @param: [conn, id]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/13 9:39 下午
     */
    public abstract Customers getCustomerById(Connection conn, int id);

    /**
     * @description: 查询表中的所有数据构成的集合
     * @param: [conn]
     * @return: java.util.List<com.lingjian_2.Customers>
     * @author: Ling Jian
     * @date: 2019/12/13 9:40 下午
     */
    public abstract List<Customers> getAll(Connection conn);

    /**
    * @description: 返回数据表中数据的条目数
    * @param: [conn]
    * @return: long
    * @author: Ling Jian
    * @date: 2019/12/13 9:42 下午
    */
    public abstract long getCount(Connection conn);

    /**
    * @description: 返回数据表中的最大生日
    * @param: [conn]
    * @return: java.sql.Date
    * @author: Ling Jian
    * @date: 2019/12/13 9:43 下午
    */
    public abstract Date getMaxBirth(Connection conn);
}
