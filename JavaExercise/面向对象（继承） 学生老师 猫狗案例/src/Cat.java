public class Cat extends Animal{
    Cat(){};
    Cat(String name,int age,String colour){
        super(name,age,colour);
    }
    public void playGame(){
        System.out.println("The cat play LOL");
    }
}
