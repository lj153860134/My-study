package com.lingjian_2;
/*
* 这是具体的猫类
*
* @author 凌健
* @version 1.0
*
* */
public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("cat eat");
    }

    @Override
    public void sleep() {
        System.out.println("cat sleep");
    }
}
