package com.lingjian.factory;

import com.lingjian.service.IAccountService;
import com.lingjian.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 用于创建Service的代理对象工厂
 * @author: Ling Jian
 * @date: 2020-02-12 20:53
 **/
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager txManager;

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public IAccountService getAccountService() {
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue=null;
                        try {
                            //开启事务
                            txManager.beginTransaction();
                            //执行操作
                            returnValue=method.invoke(accountService,args);
                            //提交事务
                            txManager.commit();
                            return returnValue;
                        } catch (Exception e) {
                            //回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //释放连接
                            txManager.release();
                        }
                    }
                });
    }
}
