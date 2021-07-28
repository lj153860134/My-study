package com.lingjian.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-06-23 14:34
 **/
public class Test {
    public static void main(String[] args) throws Exception{

        UserController userController = new UserController();
        UserService userService = new UserService();
        System.out.println(userService);


        //运用反射将userService主人userController
        Class<? extends UserController> clazz = userController.getClass();
        Field field = clazz.getDeclaredField("userService");
        String name = field.getName();
        String newName = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        String MethodName = "set" + newName;
        Method method = clazz.getMethod(MethodName,UserService.class);
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());

    }

}
