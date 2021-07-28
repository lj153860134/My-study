package cn.lingjian_7;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lingjian
 * @date 2019-09-12 - 20:38
 */
public class DateUtilDemo {
    public static void main(String[] args)throws Exception {
        Date d=new Date();//默认格式 yyyy/M/dd 上/下午H:mm
        String s=DateUtil.dateToString(d,new SimpleDateFormat().format(new Date()));
        String s1=DateUtil.dateToString(d,"yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
        System.out.println(s1);

        String str="2018-12-19";
        Date dd=DateUtil.stringToDate(str,"yyyy-MM-dd");
        System.out.println(dd);

    }
}
