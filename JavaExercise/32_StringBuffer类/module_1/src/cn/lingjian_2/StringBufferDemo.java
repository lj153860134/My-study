package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-08-22 - 16:33
 */
/*
*
* StringBuffer的添加功能
*
* */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        /*StringBuffer sb2=sb.append("hello");
        System.out.println(sb);
        System.out.println(sb2);
        System.out.println(sb == sb2);//sb2就是sb其本身 并没有开辟新的空间*/

        sb.append("hello");
        System.out.println(sb);
        System.out.println("------");
        StringBuffer sb2=new StringBuffer();
        //可以一步步添加
        //也可以连式编程添加
        sb2.append("hello").append(true).append(12).append(034);//八进制
        System.out.println(sb2);
        sb2.insert(5,"world");
        System.out.println(sb2);

    }
}
