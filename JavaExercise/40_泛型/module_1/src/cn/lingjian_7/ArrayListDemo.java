package cn.lingjian_7;

import java.util.ArrayList;
/**
 * @author lingjian
 * @date 2019/9/18 - 9:40 上午
 */
/*
*   集合的嵌套遍历
*   需求：多个班级 每个班级多个学生 多个ArrayList<Student>
*        有多个ArrayList<Student> 也要用集合存储
*
* */
public class ArrayListDemo {
    public static void main(String[] args) {
        //创建大集合
        ArrayList<ArrayList<Student>> bigArrayList=new ArrayList <ArrayList<Student>>();
        ArrayList<Student> list1=new ArrayList<Student>();
        ArrayList<Student> list2=new ArrayList<Student>();
        ArrayList<Student> list3=new ArrayList<Student>();

        Student s1=new Student("凌健1",25);
        Student s2=new Student("凌健2",26);
        Student s3=new Student("凌健3",27);
        Student s4=new Student("凌健4",28);
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);
        list1.add(s4);
        bigArrayList.add(list1);

        Student s5=new Student("徐小萌1",24);
        Student s6=new Student("徐小萌2",25);
        Student s7=new Student("徐小萌3",26);
        Student s8=new Student("徐小萌4",27);
        list2.add(s5);
        list2.add(s6);
        list2.add(s7);
        list2.add(s8);
        bigArrayList.add(list2);

        Student s9=new Student("王杰1",26);
        Student s10=new Student("王杰2",27);
        Student s11=new Student("王杰3",28);
        Student s12=new Student("王杰4",297);
        list3.add(s9);
        list3.add(s10);
        list3.add(s11);
        list3.add(s12);
        bigArrayList.add(list3);

        for (ArrayList<Student> students : bigArrayList) {
            for (Student student : students) {
                System.out.println(student.getName()+"----"+student.getAge());

            }
        }



    }
}
