package cn.lingjian_5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lingjian
 * @date 2019/10/31 - 4:11 下午
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target; //目标对象

    public MyInvocationHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("权限校验");
        Object result=method.invoke(target,args);
        System.out.println("日志记录");
        return result; //返回的是代理对象
    }
}
