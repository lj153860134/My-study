package com.lingjian.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lingjian.springcloud.entities.CommonResult;
import com.lingjian.springcloud.entities.Payment;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-04-08 15:07
 **/
public class CustomerBlockHandler {

    public static CommonResult handelException1(BlockException exception) {
        return new CommonResult(444, "按客户自定义1, global handlerException");

    }

    public static CommonResult handelException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义2, global handlerException");

    }
}
