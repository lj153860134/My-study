package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-08-20 - 10:48
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1=new String();
        System.out.println("s1: "+s1);
        System.out.println("s1.length: "+s1.length());
        System.out.println("--------");

        byte[] bytes={97,98,99,100,101};
        String s2=new String(bytes);
        System.out.println("s2: "+s2);
        System.out.println("s2.length: "+s2.length());
        System.out.println("--------");

        String s3=new String(bytes,1,3);
        System.out.println("s3: "+s3);
        System.out.println("s3.length: "+s3.length());
        System.out.println("--------");

        char[] chs={'a','b','c','d','e','f','凌','健'};
        String s4=new String(chs);
        System.out.println("s4: "+s4);
        System.out.println("s4.length: "+s4.length());
        System.out.println("--------");

        String s5=new String(chs,6,2);
        System.out.println("s5: "+s5);
        System.out.println("s5.length: "+s5.length());
        System.out.println("--------");


    }
}
