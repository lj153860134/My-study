package com.lingjian.springcloud.service.impl;

import com.lingjian.springcloud.entities.Payment;
import com.lingjian.springcloud.mapper.PaymentMapper8002;
import com.lingjian.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @description: 支付业务层的实现类8002
 * @author: Ling Jian
 * @date: 2020-03-30 14:51
 **/
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private PaymentMapper8002 paymentMapper;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }
}
