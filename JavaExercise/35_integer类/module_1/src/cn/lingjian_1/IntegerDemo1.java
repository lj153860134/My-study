package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-09-02 - 19:49
 */
/*
 *  需求1：将100用二进制 八进制 十六进制计算出来
 *  需求2：判断一个数据是否是int范围内的
 *
 *
 * */
public class IntegerDemo1 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(100));//二进制
        System.out.println("--------");
        System.out.println(Integer.toOctalString(100));//八进制
        System.out.println("--------");
        System.out.println(Integer.toHexString(100));//十六进制

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}
