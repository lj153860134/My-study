package com.lingjian.dao;

import com.lingjian.pojo.User;

/**
 * @author lingjian
 * @date 2019/9/20 - 2:20 下午
 */
public abstract interface UserDao {
    public abstract boolean isLogin(String username,String password);

    public abstract void register(User user);

}
