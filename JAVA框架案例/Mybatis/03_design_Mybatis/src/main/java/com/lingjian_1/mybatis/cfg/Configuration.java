package com.lingjian_1.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 自定义mybatis的配饰类
 * @author: Ling Jian
 * @date: 2020-01-13 17:08
 **/
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String,Mapper> mappers=new HashMap<>();


    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);  //此处需要使用追加的方式
    }
//    public void setMappers(Map<String, Mapper> mappers) {
//        this.mappers=mappers;
//    }
    // 第二种在mappers只有一种sql是可以的 但是当有多种sql
    // 语句时  就会覆盖前面的mappers
}
