package cn.lingjian_4;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author lingjian
 * @date 2019/9/24 - 8:55 上午
 */
public class TreeMapDemo2 {
    public static void main(String[] args) {
        TreeMap<Student,String> tm=new TreeMap<Student, String>();
        TreeMap<Student,String> tm2=new TreeMap<Student,String>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num=s1.getAge()-s2.getAge();
                int num2=num==0?s1.getName().compareTo(s2.getName()):num;
                return num2;
            }
        });
        Student s1=new Student("凌健",25);
        Student s2=new Student("徐小萌",24);
        Student s3=new Student("王杰",26);
        Student s4=new Student("陈旭",27);
        Student s5=new Student("陈旭",27);

        tm.put(s1,"hello");
        tm.put(s2,"world");
        tm.put(s3,"java");
        tm.put(s4,"javaee");
        tm.put(s5,"python");

        tm2.put(s1,"hello");
        tm2.put(s2,"world");
        tm2.put(s3,"java");
        tm2.put(s4,"javaee");
        tm2.put(s5,"python");



        Set<Student> set=tm.keySet();
        for (Student s : set) {
            String value=tm.get(s);
            System.out.println(s.getName()+"----"+s.getAge()+"----"+value);

        }
        System.out.println("-----------------------");

        Set<Student> set2=tm2.keySet();
        for (Student s : set2) {
            String value=tm2.get(s);
            System.out.println(s.getName()+"----"+s.getAge()+"----"+value);

        }

    }
}
