package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-07-24 - 09:50
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s1=new Student();
        Student s2=new Student();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        Student s=new Student();
        Class c=s.getClass();
        System.out.println(c.getName());
        //连式编程 返回值是一个对象 可以继续调方法®
        String str=s.getClass().getName();
        System.out.println(str);

    }
}
