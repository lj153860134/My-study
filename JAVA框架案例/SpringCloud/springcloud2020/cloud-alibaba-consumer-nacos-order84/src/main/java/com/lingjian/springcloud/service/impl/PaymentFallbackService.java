package com.lingjian.springcloud.service.impl;

import com.lingjian.springcloud.entities.CommonResult;
import com.lingjian.springcloud.entities.Payment;
import com.lingjian.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-04-08 16:50
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回,----PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
