package com.lingjian.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: 模拟一个消费者
 * @author: Ling Jian
 * @date: 2020-02-12 17:59
 **/
public class Client {
    public static void main(String[] args) {
        final Producer producer=new Producer();

       Producer cglibProducer=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
       cglibProducer.saleProduct(10000f);
    }
}
