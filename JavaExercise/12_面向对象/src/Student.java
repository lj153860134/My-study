//这是学生基本类
class Student {
    //定义变量
    String name;     //姓名
    int age;         //年龄
    String address;  //地址

    //定义方法
    //学习的方法
    public void study(){
        System.out.println("I love studying");
    }

    //吃饭的方法
    public void eat(){
        System.out.println("I love food");
    }

    //睡觉的方法
    public void sleep(){
        System.out.println("I love sleeping");
    }
}

//这是测试类
class StudentDemo{
    public static void main(String[] args){
        Student lingjian=new Student();
        //输出成员变量
        System.out.println(lingjian.name);
        System.out.println(lingjian.age);
        System.out.println(lingjian.address);
        System.out.println(lingjian.name+" "+lingjian.age+" "+lingjian.address);
        lingjian.name="凌健";
        lingjian.age=25;
        lingjian.address="盐城";
        //赋值后的输出
        System.out.println(lingjian.name+" "+lingjian.age+" "+lingjian.address);
        lingjian.study();
        lingjian.eat();
        lingjian.sleep();

    }
}
