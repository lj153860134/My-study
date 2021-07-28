package com.lingjian.dao.impl;

import com.lingjian.dao.UserDao;
import com.lingjian.pojo.User;

import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019/9/20 - 2:23 下午
 */
public class UserDaoImpl implements UserDao {
    private static ArrayList<User> list=new ArrayList<User>();
    @Override
    public boolean isLogin(String username, String password) {
        boolean flag=false;
        for (User user : list) {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                flag=true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void register(User user) {
        list.add(user);

    }
}
