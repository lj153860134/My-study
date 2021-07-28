package cn.lingjian_8;

import java.util.Calendar;

/**
 * @author lingjian
 * @date 2019-09-12 - 21:49
 */
public class CalendarDemo2 {
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance();
//        c.add(Calendar.YEAR,5);
//        c.add(Calendar.DATE,-10);
//        int year=c.get(Calendar.YEAR);
//        int month=c.get(Calendar.MONTH);
//        int day=c.get(Calendar.DATE);
//        System.out.println(year+"-"+(month+1)+"-"+day);

        System.out.println("-------");
        c.set(2011,12,19);
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DATE);
        System.out.println(year);
        System.out.println(year+"-"+(month+1)+"-"+day);

    }
}
