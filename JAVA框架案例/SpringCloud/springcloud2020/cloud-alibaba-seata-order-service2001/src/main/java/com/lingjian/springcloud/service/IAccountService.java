package com.lingjian.springcloud.service;

import com.lingjian.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-04-08 21:08
 **/
@FeignClient("seata-account-service")
public interface IAccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
