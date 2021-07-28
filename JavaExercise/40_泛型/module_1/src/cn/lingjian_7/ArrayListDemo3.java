package cn.lingjian_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/9/18 - 10:22 上午
 */
/*
*   需求：键盘录入多个数据 以0结束 在控制台上输出其中的最大值
*
* */
public class ArrayListDemo3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the integer");
        int x=sc.nextInt();
        int max=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(x!=0){
           list.add(x);
           System.out.println("Please enter the integer");
           x=sc.nextInt();
        }

        //  增强for循环找最大值
//        for (Integer integer : list) {
//            if(integer.intValue()>max)
//                max=integer.intValue();
//        }

        // 先将集合转换成数组
        Integer[] i=new Integer[list.size()];
//        Integer[] ii=list.toArray(i); i与ii是同一个数组 地址相同
        list.toArray(i);
        Arrays.sort(i);
        System.out.println("数组: "+arrayToString(i)+"最大值: "+i[i.length-1]);
    }

    public static StringBuilder arrayToString(Integer[] i){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int j = 0; j < i.length; j++) {
            if(j==i.length-1)
                sb.append(i[j]);
            else
                sb.append(i[j]+",");
        }
        sb.append("]");
        return sb;
    }
}
