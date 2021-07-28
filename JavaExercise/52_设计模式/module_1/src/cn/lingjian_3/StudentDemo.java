package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019/10/23 - 10:15 上午
 */
/*
* 单例模式：保证类在内存中只有一个对象
* 饿汉式:类一加载就创建对象
* */
public class StudentDemo {
    public static void main(String[] args) {
//        Student s1=new Student();
//        Student s2=new Student();
//        System.out.println(s1==s2);

//        Student.s=null;
        Student s1=Student.getStudent();
        Student s2=Student.getStudent();
        System.out.println(s1==s2);

    }
}
