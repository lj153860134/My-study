package cn.lingjian_1;

import cn.lingjian_2.Student;import java.util.HashSet;

/**
 * @author lingjian
 * @date 2019/9/20 - 7:47 下午
 */
public class HashSetDemo2 {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<Student> hs=new HashSet<Student>();

        //创建学生对象
        Student s1=new Student("凌健",25);
        Student s2=new Student("徐小萌",24);
        Student s3=new Student("凌健",25);
        Student s4=new Student("王杰",26);

        //添加元素
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);

        for (Student s : hs) {
            System.out.println(s);

        }
    }
}
