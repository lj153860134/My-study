package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019/10/30 - 3:46 下午
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //得到Class文件对象
        //方式1
        Person p=new Person();
        Class c=p.getClass();

        Person p2=new Person();
        Class c2=p2.getClass();

        System.out.println(p==p2);
        System.out.println(c==c2);

        //方式2
        Class c3=Person.class;
        System.out.println(c==c3);

        //方式3 要带全路径
        Class c4=Class.forName("cn.lingjian_1.Person");
        System.out.println(c==c4);
    }
}
