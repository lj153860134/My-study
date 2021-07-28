/*
*   匿名内部类：内部类的简化方法
*   前提：存在一个类或者接口
*        这里的类可以是具体类也可以是抽象类
*   格式：new 类名或者接口名
*   本质：是一个对象，该类的子类、该抽象类的具体类、该接口类的实现类 还没有名字
*
*
*
* */
class Inter{
    public void show(){
        System.out.println("show fu");
    }

}

class Outer{
    public void method(){
        Inter i=new Inter(){ //多态
            public void show(){
                System.out.println("show zi");
            }
        };
        i.show();
    }
}

public class InnerClass {
    public static void main(String[] args){
        Outer o=new Outer();
        o.method();


    }
}
