public final class Fu {
    public void show(){
        System.out.println("This is father");
    }
}
class Zi extends Fu{
    public void show(){
        System.out.println("This is son");
    }
}
class TestDemo{
    public static void main(String[] args){
        Zi z=new Zi();
        z.show();
    }
}