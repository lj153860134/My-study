package com.lingjian_1.mybatis.sqlsession.defaults;

import com.lingjian_1.mybatis.cfg.Configuration;
import com.lingjian_1.mybatis.sqlsession.SqlSession;
import com.lingjian_1.mybatis.sqlsession.SqlSessionFactory;

/**
 * @description: SqlSessionFactory接口的实现类
 * @author: Ling Jian
 * @date: 2020-01-13 20:30
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }
    /**
     * 用于创建新的操作数据库对象
     * @return
     */

    public SqlSession openSession() {
        return new DefaultSqlSesssion(cfg);
    }
}
