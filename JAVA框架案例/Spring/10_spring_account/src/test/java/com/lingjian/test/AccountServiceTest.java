package com.lingjian.test;

import com.lingjian.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @description: 使用Junit单元测试 测试我们的配置
 * @author: Ling Jian
 * @date: 2020-02-11 17:39
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService as;
    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100d);
    }
}
