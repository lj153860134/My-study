package com.lingjian_1.dao;

import com.lingjian_1.domain.QueryVo;
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

    /**
     *  根据传入参数条件 查询用户
     * @param user 查询的条件 用户名 等等 或都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryVo中提供的id集合 查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}



