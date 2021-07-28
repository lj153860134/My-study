/*
* 匿名内部类面试题 按照要求，补齐代码
* 在控制塔中输出“HelloWorld”
* */
interface Inter1{
    void show();
    //这里隐藏了public abstract 方法重写的时候不要忘了public
}

class Outer1{
    //补齐代码
    public static Inter1 method(){
        int num=10;
        return new Inter1(){
            public void show(){
                System.out.println("HelloWorld");
            }
        };
    }

}
public class InneClass {
    public static void main(String[] args){
        Outer1.method().show();
        //Outer1.method()可以看出method（）是Outer1的一个静态方法
        //Outer1.method().show() 可以看出method（）返回值是一个对象
        //接口Inter1中有一个show（）方法，所以method（）返回值类型是一个接口
    }
}

