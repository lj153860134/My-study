package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-08-30 - 09:50
 */
/*
*  StringBuffer的替换功能 和String不一样
*  String替换前后是两个字符串
*  StringBuffer替换前后是同一个字符串
*
* */
public class StringDemo3 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        sb.append("lingjian").append("like").append("xvxiaomeng");
        System.out.println(sb);
        sb.replace(8,12,"love11");
        System.out.println(sb);
    }
}
