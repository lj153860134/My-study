/*
    需求：我准备写一个Java程序，把“HelloWorld”这句话输出在控制台上
    分析：A:要写一个Java程序，必须定义一个雷
         B:把数据能够输出，说明我们的程序是可以独立运行的，必须定义main方法
         C:把数据输出在控制台，必须使用输出语句
    实现：A:java语言提供了一个关键字：class用来定义类，后面是类名
         B:main方法的格式是固定的：
                 public static void main(String[] args){
                 }
         C:输出语言的格式是固定的：
              System.out.println("Helloworld");
              "Helloworld"里面的内容是可以改变的
 */
public class Helloworld {
    public static void main(String[] args){
        System.out.println("HelloWorld");
    }
}
