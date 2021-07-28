package com.lingjian.ticket.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.lingjian.ticket.service.TicketService;

import org.springframework.stereotype.Component;

/**
 * @description: 票的业务层实现类
 * @author: Ling Jian
 * @date: 2020-03-27 14:54
 **/
@EnableDubbo
@Component
@Service//将服务发布出去
public class TickerServiceImpl implements TicketService {

    @Override
    public String GetTicket() {
        return "凌健❤️徐小萌";
    }
}
