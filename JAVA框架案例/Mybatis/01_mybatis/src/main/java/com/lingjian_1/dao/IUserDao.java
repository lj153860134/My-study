package com.lingjian_1.dao;

import com.lingjian_1.domain.User;

import java.util.List;

/**
 * @description: 用户持久层接口
 * @author: Ling Jian
 * @date: 2020-01-06 16:01
 **/
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();
}


