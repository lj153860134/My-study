package com.lingjian.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-27 10:08
 **/
@Service
public class AsyncService {

    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中。。。");
    }

}
