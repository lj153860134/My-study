package com.lingjian.springcloud.service.impl;

import com.lingjian.springcloud.dao.IOrderDao;
import com.lingjian.springcloud.domain.Order;
import com.lingjian.springcloud.service.IAccountService;
import com.lingjian.springcloud.service.IOrderService;
import com.lingjian.springcloud.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-04-08 21:06
 **/
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Resource
    private IOrderDao orderDao;

    @Resource
    private IStorageService storageService;

    @Resource
    private IAccountService accountService;

    @Override
    public void create(Order order) {
        //新建订单
        log.info("-------> 开始新建订单");
        orderDao.create(order);

        //扣减库存
        log.info("-------> 订单微服务开始调用库存 做扣减count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------> 订单微服务开始调用库存 做扣减end");

        //扣减账户余额
        log.info("-------> 订单微服务开始调用账户 做扣减money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-------> 订单微服务开始调用账户 做扣钱end");

        //修改订单状态 从0（创建中）到1（已完结
        log.info("-------> 开始修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("-------> 结束修改订单状态");

        log.info("下订单结束 O(∩_∩)O哈哈~");

    }
}
