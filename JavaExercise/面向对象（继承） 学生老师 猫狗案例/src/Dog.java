public class Dog extends Animal {
    Dog() {}
    Dog(String name,int age,String colour){
        super(name,age,colour);
    }
    public void lookDoor(){
        System.out.println("The dog look the door");
    }
}
