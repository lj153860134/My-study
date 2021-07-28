package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-08-22 - 15:25
 */
/*
*
*  线程安全
*
* */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        System.out.println("------");

        StringBuffer sb2=new StringBuffer(50);
        System.out.println(sb2);
        System.out.println(sb2.length());
        System.out.println(sb2.capacity());
        System.out.println("------");

        StringBuffer sb3=new StringBuffer("hello");
        System.out.println(sb3);
        System.out.println(sb3.length());
        System.out.println(sb3.capacity());
        System.out.println("------");
    }
}
