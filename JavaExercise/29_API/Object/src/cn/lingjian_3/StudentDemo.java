package cn.lingjian_3;

import java.sql.SQLOutput;

/**
 * @author lingjian
 * @date 2019-07-24 - 09:57
 */
public class StudentDemo {
    public static void main(String[] args) {
        Student s1=new Student("凌健",25);
        Student s2=new Student("凌健",25);
        Student s3=new Student("徐小萌",24);
        System.out.println(s1 == s2);
        System.out.println("------");
        Student s4=s1;
        System.out.println(s1.equals(s1));
        System.out.println(s1.equals(s2));//obj=s2 多态
        System.out.println(s1.equals(s3));//obj=s3 多态
        System.out.println(s1.equals(s4));//obj=s4 多态

        System.out.println("------");
        Demo d=new Demo();
        System.out.println(s1.equals(d));

    }
}
class Demo{

        }