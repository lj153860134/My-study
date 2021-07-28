package cn.lingjian_6;

import java.util.Date;

/**
 * @author lingjian
 * @date 2019-09-12 - 09:59
 */
public class DateDemo1 {
    public static void main(String[] args) {
        Date d=new Date();
        System.out.println(d);

        long time=System.currentTimeMillis();
        Date d2=new Date(time);
        System.out.println(d2);

        long time1=1000*60*60;
        Date d3=new Date(time1);
        System.out.println(d3);
    }
}
