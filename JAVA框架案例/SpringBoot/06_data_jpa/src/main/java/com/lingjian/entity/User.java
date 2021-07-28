package com.lingjian.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @description: 用户的实体类
 * @author: Ling Jian
 * @date: 2020-03-23 09:57
 **/

//使用JPA注解配置映射关系
@Entity//通知JPA这是一个实体类（和数据表映射的类）
@Table(name = "tbl_user") //指定和哪个数据表对应 默认表名 user
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User {
    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name="last_name",length = 50)  //和数据表对应的列
    private String lastName;

    @Column //省略默认列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
