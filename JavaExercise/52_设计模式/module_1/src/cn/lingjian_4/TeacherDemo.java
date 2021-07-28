package cn.lingjian_4;

/**
 * @author lingjian
 * @date 2019/10/23 - 10:35 上午
 */
/*
* 单例模式懒汉式：用的时候，才创建对象
* */
public class TeacherDemo {
    public static void main(String[] args) {
        Teacher t1=Teacher.getTeacher();
        Teacher t2=Teacher.getTeacher();
        System.out.println(t1==t2);
        System.out.println(t1);
        System.out.println(t2);
    }
}
