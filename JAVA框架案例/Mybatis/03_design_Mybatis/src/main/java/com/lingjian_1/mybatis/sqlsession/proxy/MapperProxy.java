package com.lingjian_1.mybatis.sqlsession.proxy;

import com.lingjian_1.mybatis.cfg.Mapper;
import com.lingjian_1.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-01-13 20:53
 **/
public class MapperProxy implements InvocationHandler {
    //map的key是全限定接口名+方法名
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers,Connection conn) {
        this.mappers = mappers;
        this.conn=conn;
    }

    /**
     * 用于对方法进行增强的
     * 我们增强其实就是调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName=method.getName();
        //获取方法所在的类的名称
        String className=method.getDeclaringClass().getName();
        //组合key
        String key=className+"."+methodName;
        //获取mappers中的Mapper对象
        Mapper mapper=mappers.get(key);
        //判断是否有mapper
        if(mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //调用工具类
        return new Executor().selectList(mapper,conn);
    }
}
