package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-07-24 - 09:57
 */
public class StudentDemo {
    public static void main(String[] args) {
        Student s=new Student();
        System.out.println(s.hashCode());
        System.out.println(s.getClass().getName());
        System.out.println("------");
        //下面两条语句等价
        System.out.println(s.toString());//在子类中一定要重写toString方法
                                         // 直接自动生成即可
        System.out.println(s);           //直接输出对象名称
        System.out.println(s.getClass().getName()+"@"
                +Integer.toHexString(s.hashCode()));
    }
}
