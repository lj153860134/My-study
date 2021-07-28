package cn.lingjian_2;

import cn.lingjian_7.Student;

import java.util.HashMap;

/**
 * @author lingjian
 * @date 2019/9/22 - 4:34 下午
 */
public class HashMapDemo3 {
    public static void main(String[] args) {
        HashMap<String, Student> hm=new HashMap<String,Student>();
        Student s1=new Student("凌健",25);
        Student s2=new Student("徐小萌",24);
        Student s3=new Student("王杰",26);
        Student s4=new Student("陈旭",27);

        hm.put("1111",s1);
        hm.put("2222",s2);
        hm.put("3333",s3);
        hm.put("4444",s4);

        for (String s : hm.keySet()) {
            System.out.println(s+"----"+hm.get(s).getName()+"----"+hm.get(s).getAge());

        }
    }
}
