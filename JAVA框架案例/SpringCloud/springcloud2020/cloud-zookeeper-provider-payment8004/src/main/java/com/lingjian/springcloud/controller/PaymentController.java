package com.lingjian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description: 支付的表现层8004
 * @author: Ling Jian
 * @date: 2020-03-31 15:10
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private  String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk(){
        return "springcloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
