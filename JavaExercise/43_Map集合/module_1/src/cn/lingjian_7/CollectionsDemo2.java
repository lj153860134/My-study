package cn.lingjian_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lingjian
 * @date 2019/9/24 - 2:38 下午
 */
public class CollectionsDemo2 {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<Student>();
        Student s1=new Student("凌健",25);
        Student s2=new Student("徐小萌",24);
        Student s3=new Student("王杰",26);
        Student s4=new Student("王龙",23);
        Student s5=new Student("凌立宏",30);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        for (Student s : list) {
            System.out.println(s.getName()+"----"+s.getAge());
        }
        System.out.println("---------------------------");

//        Collections.sort(list);  //自然排序
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num=s1.getAge()-s2.getAge();
                int num2=num==0?s1.getName().compareTo(s2.getName()):num;
                return num2;
            }
        });           //比较器排序
        for (Student s : list) {
            System.out.println(s.getName()+"----"+s.getAge());
        }
    }
}
