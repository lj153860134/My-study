package cn.lingjian_7;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lingjian
 * @date 2019-09-12 - 20:17
 */

/*
*
* 这是日期和字符串相互转换的工具类
**/
public class DateUtil {
    private DateUtil(){}//私有构造函数 外部无法创建对象

    /**
     * 作用是把日期转换成一个字符串
     * @param date  被转换的日期对象
     * @param format 要求的格式
     * @return     格式化的字符串
     */
    public static String dateToString(Date date,String format) {
//        SimpleDateFormat sdf=new SimpleDateFormat(format);
//        return sdf.format(date);
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 作用是把一个字符串解析成一个日期对象
     * @param s  被解析的字符串
     * @param format 传递过来的要被转换的格式
     * @return  解析后的日期对象
     * @throws Exception
     */
        public  static Date stringToDate(String s,String format)
        throws Exception{
        return new SimpleDateFormat(format).parse(s);

    }


}
