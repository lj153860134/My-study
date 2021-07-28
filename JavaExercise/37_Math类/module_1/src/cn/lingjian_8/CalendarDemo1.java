package cn.lingjian_8;

import java.time.Year;
import java.util.Calendar;

/**
 * @author lingjian
 * @date 2019-09-12 - 21:22
 */
public class CalendarDemo1 {
    public static void main(String[] args) {
        Calendar rightnow=Calendar.getInstance();//多态
        int year=rightnow.get(Calendar.YEAR);
        int month=rightnow.get(Calendar.MONTH);
        int day=rightnow.get(Calendar.DATE);
        System.out.println(year+"-"+(month+1)+"-"+day);

    }
}
