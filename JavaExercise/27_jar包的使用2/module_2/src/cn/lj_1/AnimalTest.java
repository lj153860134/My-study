package cn.lj_1;

import cn.lingjian_2.Animal;
import cn.lingjian_2.Cat;
import cn.lingjian_2.Dog;

/**
 * @author lingjian
 * @date 2019-07-23 - 10:17
 */
public class AnimalTest {
    public static void main(String[] args) {
        Dog d=new Dog();
        d.jump();
        d.eat();
        d.sleep();
        System.out.println("------");
        Animal a=new Cat();
        a.eat();
        a.sleep();
        System.out.println("------");
        Cat c=(Cat) a;
        c.eat();
        c.jump();
        c.sleep();
    }
}
