package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-08-20 - 14:44
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String s1=new String("hello");
        String s2="hello";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}
