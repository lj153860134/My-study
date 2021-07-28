package com.lingjian.springcloud.controller;

import com.lingjian.springcloud.entities.CommonResult;
import com.lingjian.springcloud.entities.Payment;
import com.lingjian.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 表现层 80
 * @author: Ling Jian
 * @date: 2020-04-02 15:20
 **/
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openFeign-ribbon 客户端一般默认等待1s
        return paymentFeignService.paymentFeignTimeout();
    }
}
