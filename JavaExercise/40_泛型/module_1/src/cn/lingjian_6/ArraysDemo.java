package cn.lingjian_6;

import java.util.Arrays;
import java.util.List;

/**
 * @author lingjian
 * @date 2019-09-18 - 09:21
 */
/*
* 把数组转换成集合
*
* */
public class ArraysDemo {
    public static void main(String[] args) {
        String[] strArray={"hello","world","java"};
        List<String> list= Arrays.asList(strArray);
        System.out.println(list);
        for (String s : list) {
            System.out.println(s);

        }
    }
}
