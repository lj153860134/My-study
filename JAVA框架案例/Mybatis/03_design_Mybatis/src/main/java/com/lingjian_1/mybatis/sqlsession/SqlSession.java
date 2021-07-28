package com.lingjian_1.mybatis.sqlsession;


/**
 * @description: 自定义Mybatis中和数据库交互的核心类
 *               里面可以创建dao接口的代理对象
 * @author: Ling Jian
 * @date: 2020-01-13 16:35
 **/
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
    * @description: 释放资源
    * @param: []
    * @return: void
    * @author: Ling Jian
    * @date: 2020/1/13 4:49 下午
    */
    void close();
}
