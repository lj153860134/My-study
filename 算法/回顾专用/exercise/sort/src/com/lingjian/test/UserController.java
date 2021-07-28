package com.lingjian.test;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-06-23 14:34
 **/
public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
