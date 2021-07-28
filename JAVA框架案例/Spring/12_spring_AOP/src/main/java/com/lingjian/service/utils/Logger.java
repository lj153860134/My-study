package com.lingjian.service.utils;

/**
 * @description: 用于记录日志的工具类 里面提供了公共的代码
 * @author: Ling Jian
 * @date: 2020-02-14 15:09
 **/
public class Logger {
    /**
     * 用于打印日志 计划让在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public static void printLog(){
        System.out.println("打印日志");
    }
}
