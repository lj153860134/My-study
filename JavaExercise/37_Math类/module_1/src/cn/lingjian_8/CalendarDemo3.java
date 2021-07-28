package cn.lingjian_8;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-09-12 - 22:01
 */
/*
* 需求：得到任意一年2月份的天数
*
* */
public class CalendarDemo3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the year");
        int year=sc.nextInt();
        Calendar c=Calendar.getInstance();
        c.set(year,2,1);
        c.add(Calendar.DATE,-1);
        int year1=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DATE);
        System.out.println(year1+"-"+(month+1)+"-"+day);

        System.out.println(c.get(Calendar.DATE));
    }
}
