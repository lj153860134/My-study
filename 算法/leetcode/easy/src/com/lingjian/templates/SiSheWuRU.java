package com.lingjian.templates;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @description: 四舍五入的方法
 * @author: Ling Jian
 * @date: 2020-08-07 08:38
 **/
public class SiSheWuRU {
    public static void main(String[] args) {
        double a1 = 3.151678;
        double a2 = 3.151678;
        double a3 = 3.151678;
        double a4 = 3.151678;
        double a5 = 3.151678;
        //方法1（旧方法）
        BigDecimal b = new BigDecimal(a1);
        double f = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f);

        //方法1（新方法）
        BigDecimal bg = new BigDecimal(a1).setScale(4, RoundingMode.UP);
        System.out.println(bg);

        //方法1（若不需要四舍五入）
        BigDecimal bg1 = new BigDecimal(a1).setScale(4, RoundingMode.DOWN);
        System.out.println(bg1);


        //方法2
        String s = new DecimalFormat("#.0000").format(a2);
        System.out.println(s);

        //方法3
        System.out.printf("%.4f\n", a3);

        //方法4
        String result = String.format("%.4f", a4);
        System.out.println(result);



    }
}
