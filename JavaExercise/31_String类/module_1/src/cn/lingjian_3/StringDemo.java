package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019-08-20 - 15:51
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1="helloworld";
        String s2="helloworld";
        String s3="HelloWorld";
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.equalsIgnoreCase(s3));
        System.out.println("---------");

        System.out.println(s1.contains("hello"));
        System.out.println(s1.contains("ho"));
        System.out.println("---------");

        System.out.println(s1.startsWith("h"));
        System.out.println(s1.startsWith("hello"));
        System.out.println("---------");

        String s4="";
        String s5=null;
        System.out.println(s4.isEmpty());
        System.out.println(s5.isEmpty());


    }
}
