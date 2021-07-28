package com.lingjian.ui;


import com.lingjian.dao.IAccountDao;
import com.lingjian.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 模拟一个表现层 用于调用业务层
 * @author: Ling Jian
 * @date: 2020-02-10 11:18
 **/
public class Client {
    /**
     * 获取spring的IOC核心容器 并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
//        获取核心容器对象
//        方法一 加载类路径下（实际开发中 多采用这种方法）
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
         //根据id获取Bean对象
        IAccountService as=(IAccountService) ac.getBean("accountService");
            as.saveAccount();
            ac.close();
//        System.out.println(as);
//
//        IAccountDao dao=ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(dao);




    }
}
