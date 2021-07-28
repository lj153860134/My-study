public class Animal {
    public void eat(){
        System.out.println("eat");
    }
    public void sleep(){
        System.out.println("sleep");
    }
}

class Dog extends Animal {
    public void eat(){
        System.out.println("Dog eat");
    }
    public void sleep(){
        System.out.println("Dog sleep");
    }
}

class Cat extends Animal {
   /* public void eat(){
        System.out.println("Cat eat");
    }
    public void sleep(){
        System.out.println("Cat sleep");
    } */
   //直接用动物接受，不然每次添加一种动物 都要修改工具类
    public static void useAnimal(Animal a){
        a.eat();
        a.sleep();
    }
}
//针对动物操作的工具类
class AnimalTool{
    private AnimalTool(){} //将构造函数定义为私有，不允许外界创建该类的对象
                           //定义了两个静态的方法 可直接通过类名调用该方法
    public static void useCat(Cat c){
        c.eat();
        c.sleep();
    }
    public static void useDog(Dog d){
        d.eat();
        d.sleep();
    }
}
class DuoTaiDemo2{
    public static void main(String[] args){
        Cat c1=new Cat();
        Cat c2=new Cat();
        Cat c3=new Cat();
        AnimalTool.useCat(c1);
        AnimalTool.useCat(c2);
        AnimalTool.useCat(c3);


    }

}
