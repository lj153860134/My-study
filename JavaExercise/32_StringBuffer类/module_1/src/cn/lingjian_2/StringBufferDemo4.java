package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-08-30 - 10:03
 *
 */
/*
*  StringBuffer的反转功能
*
* */
public class StringBufferDemo4 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        sb.append("123456789");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}
