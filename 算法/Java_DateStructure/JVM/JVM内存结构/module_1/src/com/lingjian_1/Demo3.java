package com.lingjian_1;

import java.io.IOException;

/**
 * @description: 字节码测试多态
 * @author: Ling Jian
 * @date: 2019-12-30 10:07
 **/
public class Demo3 {
    public static void main(String[] args) throws IOException {
        test(new dog());
        test(new cat());
        System.in.read();
    }

    public static void test(Animal a){
        a.eat();
        System.out.println(a.toString());
    }
}

abstract class Animal{
    public abstract void eat();

    @Override
    public String toString() {
        return "I am "+this.getClass().getSimpleName();
    }
}

class dog extends Animal{
    @Override
    public void eat() {
        System.out.println("eat bones");
    }
}

class cat extends Animal{
    @Override
    public void eat() {
        System.out.println("eat fish");
    }
}
