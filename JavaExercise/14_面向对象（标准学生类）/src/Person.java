import jdk.jshell.PersistentSnippet;

/* 定义一个人类*/
class Person {
    String name;
    int age;
    static String country;
    static String hometown="仓头";
    //无参构造永远都要写
    public Person(){}
    //两个参数的构造函数
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    //三个参数的构造函数
    public Person(String name,int age,String country){
        this.name=name;
        this.age=age;
        this.country=country;
    }
    public void show(){
        System.out.println(name+"----"+age+"----"+country);
    }

}
class PersonDemo{
    public static void main(String[] args){
        System.out.println(args); //数组地址（[Ljava.lang.String;@2752f6e2）
        System.out.println(args.length); //数组长度为0
        Person p1=new Person("凌健",25,"中国");
        p1.show();
        Person p2=new Person("徐小萌",24);
        p2.show();
        Person p3=new Person("陈旭",26);
        p3.show();
        p3.country="盐城";
        p1.show();
        p2.show();
        p3.show();
        //静态成员变量（类变量） 可以通过类名调用（推荐使用类名调用）
        System.out.println(Person.country+"----"+Person.hometown);

    }
}
