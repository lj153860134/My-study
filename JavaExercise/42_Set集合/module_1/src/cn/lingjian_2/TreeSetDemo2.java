package cn.lingjian_2;

import java.util.TreeSet;

/**
 * @author lingjian
 * @date 2019/9/21 - 9:27 上午
 */
public class TreeSetDemo2 {
    public static void main(String[] args) {
        TreeSet<Student> ts=new TreeSet<Student>();
        Student s1=new Student("lingjian",25);
        Student s2=new Student("xvxiaomeng",24);
        Student s3=new Student("lingjian",25);
        Student s4=new Student("wangjie",26);
        Student s5=new Student("linglihong",23);
        Student s6=new Student("linglihong",25);


        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);




        for (Student s : ts) {
            System.out.println(s);

        }
    }
}
