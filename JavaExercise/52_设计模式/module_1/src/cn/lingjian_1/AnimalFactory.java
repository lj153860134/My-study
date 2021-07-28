package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019/10/23 - 9:35 上午
 */
public class AnimalFactory {
    //私有构造方法
    private AnimalFactory() {
    }

//    public static Dog creatDog(){
//        return new Dog();
//    }
//
//    public static Cat creatCat(){
//        return new Cat();
//    }

    public static Animal creatAnimal(String type){
        if(type.equals("Dog"))
            return new Dog();
        else if(type.equals("Cat"))
            return new Cat();
        return null;
    }

}
