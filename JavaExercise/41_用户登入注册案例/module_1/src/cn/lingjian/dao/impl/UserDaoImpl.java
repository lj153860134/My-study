package cn.lingjian.dao.impl;

import cn.lingjian.dao.UserDao;
import cn.lingjian.pojo.User;

import java.util.ArrayList;

/**
 * 这是用户操作的具体实现类（集合版）
 * @author lingjian
 * @date 2019/9/18 - 2:53 下午
 */
public class UserDaoImpl implements UserDao {
    //为了让多个方法能够使用同一个集合 集合应该定义为成员变量
    //为了不让外人看到，用private
    //为了让多个对象共享同一个成员变量
    private static ArrayList<User> list=new ArrayList<User>();

    @Override
    public boolean isLogin(String username, String password) {
        //遍历集合，获取每一个用户，并判断该用户的用户名和密码和传递过来的匹配
        boolean flag=false;
        for (User user : list) {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)) {
                flag = true;
                break;
            }

        }

        return flag;
    }

    @Override
    public void register(User user) {
        //把用户信息存储到集合中
        list.add(user);

    }
}
