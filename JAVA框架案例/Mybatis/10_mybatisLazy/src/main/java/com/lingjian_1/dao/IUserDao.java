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
     * 查询所有用户 同时获取用户下所有账户的信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User findById(Integer id);


}



