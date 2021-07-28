package com.lingjian_1;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-01-07 19:31
 **/
public class Demo2 {
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new WoMan();
        Demo d=new Demo();
        d.say(man);
        d.say(woman);
        System.out.println(man.a);
        System.out.println(woman.a);
    }
}
