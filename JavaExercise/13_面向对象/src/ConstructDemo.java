/*构造函数*/
class ConstructDemo {
    private String name;
    //无参数构造方法
    public ConstructDemo(){
        System.out.println("This is no parameters construction method");
    }
    //带参数的构造方法
    public ConstructDemo(String name){
        System.out.println("This is String parameters construction method");
        this.name=name;
    }
    public void show(){
        System.out.println(name);
    }

}
class ConstructTest {
    public static void main(String[] args) {
        ConstructDemo c1 = new ConstructDemo();
        ConstructDemo c2 = new ConstructDemo();
        ConstructDemo c3 = new ConstructDemo("凌健");
        c1.show();
        c2.show();
        c3.show();
    }
}

