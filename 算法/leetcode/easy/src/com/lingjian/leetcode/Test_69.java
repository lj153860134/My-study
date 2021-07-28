package com.lingjian.leetcode;

/**
 * @description: 实现 int sqrt(int x) 函数
 *               计算并返回 x 的平方根，其中 x 是非负整数
 *               由于返回类型是整数
 *               结果只保留整数的部分
 *               小数部分将被舍去。
 * @author: Ling Jian
 * @date: 2020-06-18 16:27
 **/
public class Test_69 {
    public static void main(String[] args) {
        int x=8;
        int res = mySqrt(x);
//        int res1 = mySqrt1(x);
        System.out.println(res);

    }

    //x可能会溢出
    public static int mySqrt(int x) {
        for (int i = 1; i <=x ; i++) {
            if(x>=i*i&&x<(i+1)*(i+1)){
               return i;
            }
        }
        return 0;
    }

    //循环
    public static int mySqrt1(int x){
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }


    //递归
    public static int mySqrt2(int x){
        if(x==0){
            return 0;
        }
        long left=1;
        long right=x/2;
        return process(x,left,right);
    }

    public static int process(int x,long left,long right){
        while(left>=right){
            return (int) right;
        }
        long mid=(left+right)>>1;
        long square=mid*mid;
        if(square==x){
            return (int)mid;
        }else if(square>x){
            return process(x,left,mid);
        }else{
            return process(x,mid+1,right);
        }
    }


}
