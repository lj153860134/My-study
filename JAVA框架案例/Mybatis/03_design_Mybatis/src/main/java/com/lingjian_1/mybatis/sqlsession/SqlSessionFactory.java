package com.lingjian_1.mybatis.sqlsession;

/**
 * @description: 用于创建一个SqlSessionFactory对象
 * @author: Ling Jian
 * @date: 2020-01-13 16:35
 **/
public interface SqlSessionFactory {
    public abstract SqlSession openSession();
}
