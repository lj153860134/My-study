package com.lingjian.service.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @description: 用于记录日志的工具类 里面提供了公共的代码
 * @author: Ling Jian
 * @date: 2020-02-14 15:09
 **/
public class Logger {
    /**
     * 前置通知
     */
    public  void beforePrintLog(){
        System.out.println("前置通知日志");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知日志");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知日志");
    }

    /**
     * 最终通知
     */
    public  void afterPrintLog(){
        System.out.println("最终通知日志");
    }

    /**
     * 环绕通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] objects=pjp.getArgs();//得到方法执行所需的参数
            rtValue=pjp.proceed();//明确低啊用业务层方法（切入点方法）
            return rtValue;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        } finally {
        }
    }
}
