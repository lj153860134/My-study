package com.lingjian.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-27 10:26
 **/
@Service
public class ScheduledService {

//    @Scheduled(cron = "0 * * * * MON-FRI")
    public void hello(){
        System.out.println("hello...");
    }
}
