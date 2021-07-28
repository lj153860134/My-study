package cn.lingjian_2;

import cn.lingjian_7.Student;

import java.util.HashMap;

/**
 * @author lingjian
 * @date 2019/9/22 - 4:41 下午
 */
public class HashMapDemo4 {
    public static void main(String[] args) {
        HashMap<Student,String> hm=new HashMap<Student, String>();
        Student s1=new Student("凌健",25);
        Student s2=new Student("徐小萌",24);
        Student s3=new Student("王杰",26);
        Student s4=new Student("陈旭",27);
        Student s5=new Student("陈旭",27);

        hm.put(s1,"1111");
        hm.put(s2,"2222");
        hm.put(s3,"3333");
        hm.put(s4,"4444");
        hm.put(s5,"5555");


        for (Student s : hm.keySet()) {
            String str=hm.get(s);
            System.out.println(str+s.getName()+s.getAge());

        }


    }
}
