package com.lingjian.springcloud.controller;

import com.lingjian.springcloud.domain.CommonResult;
import com.lingjian.springcloud.domain.Order;
import com.lingjian.springcloud.service.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-04-08 21:31
 **/
@RestController
public class OrderController {
    @Resource
    private IOrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
