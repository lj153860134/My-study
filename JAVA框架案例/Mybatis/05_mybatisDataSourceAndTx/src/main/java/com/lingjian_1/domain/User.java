package com.lingjian_1.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 用户实体类
 * @author: Ling Jian
 * @date: 2020-01-06 16:01
 **/
public class User implements Serializable {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User() {
    }

    public User(String username, Date birthday, String sex, String address) {
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override

    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
