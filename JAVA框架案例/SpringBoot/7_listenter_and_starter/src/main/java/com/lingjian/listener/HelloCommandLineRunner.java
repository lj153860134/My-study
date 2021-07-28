package com.lingjian.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-23 14:19
 **/
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner...run"+ Arrays.toString(args));
    }
}
