package com.lingjian.springcloud.dao;

import com.lingjian.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-04-08 20:44
 **/
@Mapper
public interface IOrderDao {

    //新建订单
    void create(Order order);

    //修改订单状态 从0（创建中）到1（已完结）
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
