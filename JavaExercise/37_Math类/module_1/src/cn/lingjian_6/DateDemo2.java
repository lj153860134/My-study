package cn.lingjian_6;

import java.util.Date;

/**
 * @author lingjian
 * @date 2019-09-12 - 10:11
 */
public class DateDemo2 {
    public static void main(String[] args) {
        Date d=new Date();
        long time=System.currentTimeMillis();
        long time1=d.getTime();
        System.out.println(time);
        System.out.println(time1);
    }
}
