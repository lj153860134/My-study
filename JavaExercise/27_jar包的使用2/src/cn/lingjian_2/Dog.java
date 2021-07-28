package cn.lingjian_2;

import cn.lingjian_1.Jump;

/**
 * @author lingjian
 * @date 2019-07-23 - 10:04
 */

public class Dog extends Animal implements Jump  {
    @Override
    public void eat() {
        System.out.println("Dog eat");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleep");
    }

    public void jump(){
        System.out.println("Dog jump");
    }
}
