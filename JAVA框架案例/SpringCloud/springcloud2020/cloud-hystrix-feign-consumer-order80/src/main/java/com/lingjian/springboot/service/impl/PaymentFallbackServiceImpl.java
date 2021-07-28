package com.lingjian.springboot.service.impl;

import com.lingjian.springboot.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @description: 同一的fallback实现类
 * @author: Ling Jian
 * @date: 2020-04-03 09:15
 **/
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackServiceImpl fall back ┭┮﹏┭┮";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallbackServiceImpl fall back ┭┮﹏┭┮";
    }
}
