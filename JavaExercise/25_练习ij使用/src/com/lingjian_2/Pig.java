package com.lingjian_2;

import com.lingjian.Jump;
/*
* 这是具体的猪类
*
* @author 凌健
* @version 1.0
*
* */

public class Pig extends Animal implements Jump {
    @Override
    public void jump() {
        System.out.println("pig jump");
    }

    @Override
    public void eat() {
        System.out.println("pig eat");
    }

    @Override
    public void sleep() {
        System.out.println("pig sleep");
    }
}
