package cn.lingjian_2;

import cn.lingjian_1.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author lingjian
 * @date 2019-09-15 - 15:48
 */
public class CollectionDemo5 {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        Student s1=new Student("凌健",25);
        Student s2=new Student("徐小萌",24);
        Student s3=new Student("王杰",26);
        Student s4=new Student("凌立宏",25);
        Student s5=new Student("陈旭",26);
        c.add(s1);
        c.add(s2);
        c.add(s3);
        c.add(s4);
        c.add(s5);


//        while(it.hasNext()){
//            Student s=(Student) it.next();
//            System.out.println(s.getName()+"----"+s.getAge());
//        }
        //用for循环改进
        for (Iterator it=c.iterator(); it.hasNext(); ) {
            Student s=(Student) it.next();
            System.out.println(s.getName()+"----"+s.getAge());
        }
    }
}
