package cn.lingjian_4;

import java.math.BigInteger;

/**
 * @author lingjian
 * @date 2019-09-11 - 16:43
 */
public class BigIntegerDemo2 {
    public static void main(String[] args) {
        BigInteger b1=new BigInteger("100");
        BigInteger b2=new BigInteger("50");
        System.out.println(b1.add(b2));
        System.out.println(b1.subtract(b2));
        System.out.println(b1.divide(b2));
        System.out.println(b1.multiply(b2));
        System.out.println(b1.divideAndRemainder(b2)[0]);
        System.out.println(b1.divideAndRemainder(b2)[1]);


    }
}
