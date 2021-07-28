package com.lingjian.jianzhi;

/**
 * @description: 一个整型数组nums里除两个数字之外
 *               其他数字都出现了两次
 *               请写程序找出这两个只出现一次的数字
 *               要求时间复杂度是O(n)
 *               空间复杂度是O(1)
 * @author: Ling Jian
 * @date: 2020-07-08 16:01
 **/
public class Test_56_1 {
    public static void main(String[] args) {

    }


    public static int[] singleNumbers(int[] nums) {
        int sum=0;
        //得到异或结果，即为不相同两个数的异或结果sum
        for(int num:nums)
            sum^=num;
        //得到sum的二进制的1的最低位
        int flag=(-sum)&sum;
        int result[]=new int[2];
        //分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for(int num:nums){
            if((flag&num)==0)
                result[0]^=num;
            else{
                result[1]^=num;
            }
        }
        return result;

    }
}
