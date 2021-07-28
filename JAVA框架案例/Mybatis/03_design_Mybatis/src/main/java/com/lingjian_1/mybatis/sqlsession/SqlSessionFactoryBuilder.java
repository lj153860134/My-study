package com.lingjian_1.mybatis.sqlsession;

import com.lingjian_1.mybatis.cfg.Configuration;
import com.lingjian_1.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.lingjian_1.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @description: 用于创建一个SqlSessionFactory对象
 * @author: Ling Jian
 * @date: 2020-01-13 16:35
 **/
public class SqlSessionFactoryBuilder {


    /**
     * 根据参数字节输入流构建一个SqlSessionFactory工厂
     * @param is
     * @return
     */
   public  SqlSessionFactory build(InputStream is){
       Configuration cfg= XMLConfigBuilder.loadConfiguration(is);
       return new DefaultSqlSessionFactory(cfg);
   }

}
