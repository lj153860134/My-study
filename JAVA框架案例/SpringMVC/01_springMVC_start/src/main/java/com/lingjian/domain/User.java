package com.lingjian.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 用户的实体类
 * @author: Ling Jian
 * @date: 2020-02-22 11:57
 **/
public class User implements Serializable {
    private String name;
    private Integer age;

    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
