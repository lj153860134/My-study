/*
* 猫狗案例
* */
abstract class Animal {  //有或没有public 都行
    private String name;
    private int age;
    //构造方法（无参 有参）
    public  Animal(){}
    public  Animal(String name,int age){
        this.name=name;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void eat();    //猫和狗的共性方法 定义为抽象类
                                   // 有抽象方法的类必定为抽象类

}

class Cat extends Animal{
    public  Cat(){}
    public  Cat(String name,int age){
        super(name,age);
    }
    public void eat(){
        System.out.println("cat eat fish");
    }

}

class Dog extends Animal{
    public  Dog(){}
    public  Dog(String name,int age){
        super(name,age);
    }
    public void eat(){
        System.out.println("dog eat meat");
    }

}
class AbstractDemo{
    public static void main(String[] args){
        //  Animal a=new Animal(); 报错 Animal是抽象的; 无法实例化
    }
}