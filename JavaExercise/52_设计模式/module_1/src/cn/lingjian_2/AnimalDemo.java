package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019/10/23 - 9:59 上午
 */
/*
* 工厂方法模式
* */
public class AnimalDemo {
    public static void main(String[] args) {
        //我要狗
        Factory f=new DogFactory();
        Animal a=f.creatAnimal();
        a.eat();

        //我要猫
        f=new CatFactory();
        a=f.creatAnimal();
        a.eat();
    }
}
