package cn.lingjian_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lingjian
 * @date 2019/9/25 - 2:20 下午
 */
public class FinallyDemo1 {
    public static void main(String[] args) {
        String s="2019-9-25";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        String str=null;
//        System.out.println(str);  引用数据类型初始化null
        Date d= null;
        try {
            d = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            System.out.println("这里的代码是可以执行的");
        }
        System.out.println(d);
    }
}
