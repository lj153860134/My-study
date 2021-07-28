package com.lingjian.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lingjian.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @description: 用户的业务层
 * @author: Ling Jian
 * @date: 2020-03-27 15:02
 **/
@Service
public class UserService {
    @Reference
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.GetTicket();
        System.out.println("买到票了"+ticket);
    }
}
