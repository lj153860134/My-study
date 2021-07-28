package cn.lingjian_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lingjian
 * @date 2019/9/25 - 9:35 上午
 */
public class ExceptionDemo3 {
    public static void main(String[] args) {
        String s="2019-9-25";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH");

        try {
            Date d = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
