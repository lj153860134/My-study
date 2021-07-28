package com.lingjian.test;

import com.lingjian.domain.Account;
import com.lingjian.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @description: 使用Junit单元测试 测试我们的配置
 * @author: Ling Jian
 * @date: 2020-02-11 17:39
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll() {

        //执行方法
        List<Account> accounts=as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);

        }
    }

    @Test
    public void testFindAccountById() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        IAccountService as=(IAccountService)ac.getBean("accountService");
        //执行方法
        Account account=as.findAccountById(3);
        System.out.println(account);
    }

    @Test
    public void testSaveAccount() {
        Account account=new Account();
        account.setName("凌健");
        account.setMoney(10000d);
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        IAccountService as=(IAccountService)ac.getBean("accountService");
        //执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdateAccount() {
    }

    @Test
    public void testDeleteAccount() {
    }
}
