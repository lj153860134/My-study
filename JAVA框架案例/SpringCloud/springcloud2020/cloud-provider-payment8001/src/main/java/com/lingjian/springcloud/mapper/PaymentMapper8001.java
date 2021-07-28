package com.lingjian.springcloud.mapper;

import com.lingjian.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description: payment的持久层8001
 * @author: Ling Jian
 * @date: 2020-03-30 14:16
 **/
@Mapper
public interface PaymentMapper8001 {
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
