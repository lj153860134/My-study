package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-08-22 - 17:03
 */

/*
*
* StringBUffer的删除功能
*
* */
public class StringBufferDemo2 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        sb.append("hello").append("world").append("java");
//        sb.delete(5,10);
        System.out.println(sb);
        //删除所有的数据
        sb.delete(0,sb.length());
        System.out.println(sb);

    }
}
