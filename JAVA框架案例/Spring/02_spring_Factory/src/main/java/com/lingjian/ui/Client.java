package com.lingjian.ui;


import com.lingjian.dao.impl.AccountDaoImpl;
import com.lingjian.factory.BeanFactory;
import com.lingjian.service.IAccountService;
import com.lingjian.service.impl.AccountServiceImpl;

/**
 * @description: 模拟一个表现层 用于调用业务层
 * @author: Ling Jian
 * @date: 2020-02-10 11:18
 **/
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}
