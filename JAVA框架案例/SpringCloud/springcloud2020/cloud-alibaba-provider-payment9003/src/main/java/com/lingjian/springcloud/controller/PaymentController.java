package com.lingjian.springcloud.controller;

import com.lingjian.springcloud.entities.CommonResult;
import com.lingjian.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Stack;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-04-08 15:31
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static
    {
        hashMap.put(1L,new Payment(1L,"111111"));
        hashMap.put(2L,new Payment(2L,"222222"));
        hashMap.put(3L,new Payment(3L,"333333"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<Payment>(200, "from mysql serverPort: " + serverPort, payment);
        return result;
    }
}
