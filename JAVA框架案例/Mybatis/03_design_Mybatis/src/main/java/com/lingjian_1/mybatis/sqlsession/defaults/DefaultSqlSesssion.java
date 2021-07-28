package com.lingjian_1.mybatis.sqlsession.defaults;

import com.lingjian_1.mybatis.cfg.Configuration;
import com.lingjian_1.mybatis.sqlsession.SqlSession;
import com.lingjian_1.mybatis.sqlsession.proxy.MapperProxy;
import com.lingjian_1.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @description: SqlSession接口的实现类
 * @author: Ling Jian
 * @date: 2020-01-13 20:38
 **/
public class DefaultSqlSesssion implements SqlSession {
    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSesssion(Configuration cfg){
        this.cfg=cfg;
        conn= DataSourceUtil.getConnection(cfg);

    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */

    //这里的接口也可以用 new Class[] {daoInterfaceClass}
    public <T> T getMapper(Class<T> daoInterfaceClass) {
//        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
//                daoInterfaceClass.getDeclaredClasses(),new MapperProxy(cfg.getMappers(), conn));
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),conn));

    }

    /**
     * 用于释放资源
     */
    public void close() {
        if(conn!=null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
