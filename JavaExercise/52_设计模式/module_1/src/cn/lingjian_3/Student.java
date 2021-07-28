package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019/10/23 - 10:15 上午
 */
public class Student {
    //私有构造
    private Student() {
    }

    //创建一个对象
    //静态方法只能访问私有成员变量
    //为了不让外界直接访问修改这个值，加private
    private static  Student s=new Student();

    //提供公共的访问方式
    public static Student getStudent(){
        return s;
    }

}
