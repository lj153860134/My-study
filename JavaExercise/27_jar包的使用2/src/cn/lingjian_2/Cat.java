package cn.lingjian_2;

import cn.lingjian_1.Jump;

/**
 * 这是具体的猫类
 * @author lingjian
 * @date 2019-07-23 - 10:08
 */
public class Cat extends Animal implements Jump {
    @Override
    public void eat() {
        System.out.println("Cat eat");

    }

    @Override
    public void sleep() {
        System.out.println("Cat sleep");
    }

    public void jump(){
        System.out.println("Cat jump");
    }
}
