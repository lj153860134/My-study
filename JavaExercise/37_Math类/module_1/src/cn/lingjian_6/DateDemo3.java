package cn.lingjian_6;

import java.text.*;
import java.util.Date;

/**
 * @author lingjian
 * @date 2019-09-12 - 10:20
 */
/*
* 将Date类转换成习惯的格式
*  Date到String
* String到Date
*
* */
public class DateDemo3 {
    public static void main(String[] args)throws ParseException {
        //String 到Date
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat();//默认模式
        String s=sdf.format(d);
        System.out.println(s);

        SimpleDateFormat sdf2 =new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//给定模式
        String s1=sdf2.format(d);
        System.out.println(s1);

        //Date到String
        String str="2019-12-19 15:47:43";
        SimpleDateFormat sdf3 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//给定模式
        Date d1=sdf3.parse(str);
        System.out.println(d1);




    }
}
