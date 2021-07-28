package com.lingjian.springcloud.service;

import com.lingjian.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @description: payment的业务层接口
 * @author: Ling Jian
 * @date: 2020-03-30 14:48
 **/
public interface IPaymentService {
    /**
     * 查询
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);

    /**
     * 插入
     * @param payment
     * @return
     */
    int create(Payment payment);
}
