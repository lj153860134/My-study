package cn.lingjian_7;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-09-12 - 21:05
 */
/*
*  需求：计算我来这个世界多少天
*
* */
public class MyDays {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your birthday");
        String birthday=sc.nextLine();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date d=sdf.parse(birthday);
        long time1=d.getTime();
        long time2=new Date().getTime();
        long days=(time2-time1)/1000/60/60/24;
        System.out.println(days);
    }
}
