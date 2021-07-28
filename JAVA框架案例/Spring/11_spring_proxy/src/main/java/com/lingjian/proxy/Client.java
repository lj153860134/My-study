package com.lingjian.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 模拟一个消费者
 * @author: Ling Jian
 * @date: 2020-02-12 17:59
 **/
public class Client {
    public static void main(String[] args) {
        final IProducer producer=new Producer();

        IProducer proxyProducer=(IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue=null;
                        //获取方法执行的参数
                        Float money=(Float) args[0];
                        //判断当前方法是不是销售
                        if("saleProduct".equals(method.getName())) {
                            returnValue= method.invoke(producer, money*0.8f);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduct(10000f);
    }
}
