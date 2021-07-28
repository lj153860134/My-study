package cn.lingjina_5;

import java.sql.SQLOutput;

/**
 * @author lingjian
 * @date 2019-08-21 - 10:10
 */
/*
*  String类的获取功能
*
* */
public class StringDemo {
    public static void main(String[] args) {
        String s="helloworld";
        System.out.println(s.length());  //获取字符创长度
        System.out.println("------");

        System.out.println(s.charAt(4)); //获取指定索引位置的字符
        System.out.println("------");

        System.out.println(s.indexOf('o'));
        System.out.println(s.indexOf('k')); //-1
        //返回指定字符在此字符串第一次出现的索引
        System.out.println("------");

        System.out.println(s.indexOf("world"));
        //返回指定字符串在此字符串第一次出现的索引
        System.out.println("------");

        System.out.println(s.indexOf('o', 5));
        //返回指定字符在此字符串指定位置第一次出现的索引
        System.out.println("------");

        System.out.println(s.indexOf("or", 4));
        //返回指定字符串在此字符串指定位置第一次出现的索引
        System.out.println("------");

        System.out.println(s.substring(5));
        //从指定位置开始截取字符串，默认到末尾
        //包含start
        System.out.println("------");

        System.out.println(s.substring(0, 5));
        //从指定位置开始到指定位置截取字符串
        //包含start 不包含end
        System.out.println(s.substring(0,s.length()));
        //直接可以打印出整个字符 length正好多1
        System.out.println("------");


    }

}
