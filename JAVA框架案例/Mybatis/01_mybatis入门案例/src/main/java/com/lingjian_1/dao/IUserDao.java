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

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(int userId);

    /**
     * 根据id查询单个用户
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 根据name模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总的用户数
     * @return
     */
    int findCount();


}



