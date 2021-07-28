package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019-09-11 - 15:08
 */
public class SystemDemo1 {
    public static void main(String[] args) {
        Person p=new Person("凌健",24);
        System.out.println(p);//打印对象名称 就是直接调用toString（）方法
        p=null;//让p不再指定堆内存
        System.gc();
    }
}
