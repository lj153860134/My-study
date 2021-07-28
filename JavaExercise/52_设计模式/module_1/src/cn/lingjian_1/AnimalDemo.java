package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019/10/23 - 9:34 上午
 */
/*
* 简单工厂模式
* */
public class AnimalDemo {
    public static void main(String[] args) {
        Dog d=new Dog();
        Cat c=new Cat();

        //用工厂造对象
//       Dog d1=AnimalFactory.creatDog();
//       Cat c1=AnimalFactory.creatCat();
//       d1.eat();
//       c1.eat();
        //改进工厂

        Animal a1=AnimalFactory.creatAnimal("Dog");
        Animal a2=AnimalFactory.creatAnimal("Cat");
        a1.eat();
        a2.eat();

    }
}
