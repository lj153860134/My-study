package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-08-30 - 10:21
 */
/*
*
* StringBuffer的截取功能（返回值是String类型）
* */
public class StringBufferDemo5 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        sb.append("helloworldjava");
        System.out.println(sb);
        String s=sb.substring(5);
        System.out.println(sb);
        System.out.println(s);
    }
}
