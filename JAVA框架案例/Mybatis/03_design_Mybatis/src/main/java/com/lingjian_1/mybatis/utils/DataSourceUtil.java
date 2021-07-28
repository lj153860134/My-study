package com.lingjian_1.mybatis.utils;

import com.lingjian_1.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @description: 用于创建数据源的工具类
 * @author: Ling Jian
 * @date: 2020-01-13 21:14
 **/
public class DataSourceUtil {
    /**
     * 用于获取一个数据源
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
