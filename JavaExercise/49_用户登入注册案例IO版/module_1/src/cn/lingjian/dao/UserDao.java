package cn.lingjian.dao;

import cn.lingjian.pojo.User;

/**
 * 这是针对用户进行操作的接口
 * @author lingjian
 * @date 2019/9/18 - 2:44 下午
 */
public interface UserDao  {
    /**
     * 这是用户的登录功能
     * @param username  用户名
     * @param password  密码
     * @return          返回登录是否成功
     */
    public abstract boolean isLogin(String username, String password);

    /**
     * 这是用户注册功能
     * @param user  要注册的用户信息
     */
    public abstract void register(User user);
}
