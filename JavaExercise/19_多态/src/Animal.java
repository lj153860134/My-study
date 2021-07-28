public class Animal {
    public void eat(){
        System.out.println("eat");
    }
}

class Dog extends Animal{
    public void eat(){
        System.out.println("Dog eat");
    }
    public void lookDoor(){
        System.out.println("Dog look the door");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("Cat eat");
    }
    public void playGame(){
        System.out.println("Cat play the game");
    }
}

class DuoTaiTest{
    public static void main(String[] args){
        Animal a=new Dog();   //向上转型
        a.eat();
        //a.lookDoor();  报错
        System.out.println("------");

        Dog d=(Dog) a;        //向下转型
        d.eat();
        d.lookDoor();
        System.out.println("------");

        a=new Cat();
        a.eat();
        //a.playGame();    报错
        System.out.println("------");

        Cat c=(Cat) a;
        c.eat();
        c.playGame();
        System.out.println("------");

        //Dog dd=(Dog) a;    //编译不报错 运行会报错
    }
}