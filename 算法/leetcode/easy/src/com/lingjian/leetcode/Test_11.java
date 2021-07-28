package com.lingjian.leetcode;

/**
 * @description: 给你n个非负整数 a1，a2，...，an
 *               每个数代表坐标中的一个点 (i, ai)
 *               在坐标内画n条垂直线垂直线i的两个端点分别为 (i, ai) 和 (i, 0)
 *               找出其中的两条线
 *               使得它们与x轴共同构成的容器可以容纳最多的水。
 * @author: Ling Jian
 * @date: 2020-08-09 16:21
 **/
public class Test_11 {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int res=0;
        if(height==null||height.length<=1){
            return res;
        }
        int L=0;
        int R=height.length-1;
        while(L<R){
            int num=Math.min(height[L],height[R]);
            res=Math.max(res,num*(R-L));
            if(height[L]<=height[R]){
                L++;
            }else{
                R--;
            }
        }
        return res;

    }
}
