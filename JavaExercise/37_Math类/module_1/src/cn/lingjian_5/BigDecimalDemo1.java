package cn.lingjian_5;

/**
 * @author lingjian
 * @date 2019-09-11 - 16:49
 */
public class BigDecimalDemo1 {
    public static void main(String[] args) {
        System.out.println(0.09+0.01);
        System.out.println(1-0.32);
        System.out.println(1.015*100);
        System.out.println(1.301/100);
        //结果和我们想的有一点点不一样，因为float类型的存储和整数不一样导致的
        //大部分的视乎，都是带有效数字
    }
}
