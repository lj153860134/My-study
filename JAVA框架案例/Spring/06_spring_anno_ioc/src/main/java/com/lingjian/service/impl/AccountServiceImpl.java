package com.lingjian.service.impl;

import com.lingjian.dao.IAccountDao;
import com.lingjian.dao.impl.AccountDaoImpl;
import com.lingjian.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/**
 * @description: 账户业务层实现类
 * 曾经XML的配置
 * <bean id="accountService" class="com.lingjian.service.impl.AccountServiceImpl"></bean>
 * @author: Ling Jian
 * @date: 2020-02-10 11:04
 **/
@Component("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "accountDao1")
    private IAccountDao accountDao = null;

    public AccountServiceImpl() {

        System.out.println("业务层对象创建");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁了");
    }

    public void saveAccount() {

        accountDao.saveAccount();

    }
}
