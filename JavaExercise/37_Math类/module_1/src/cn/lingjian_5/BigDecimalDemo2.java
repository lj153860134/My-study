package cn.lingjian_5;

import cn.lingjian_4.BigIntegerDemo2;

import java.math.BigDecimal;

/**
 * @author lingjian
 * @date 2019-09-11 - 16:56
 */
public class BigDecimalDemo2 {
    public static void main(String[] args) {
        BigDecimal bd1=new BigDecimal("1.301");
        BigDecimal bd2=new BigDecimal("100");
        System.out.println(bd1.divide(bd2,8,BigDecimal.ROUND_HALF_UP));
    }
}
