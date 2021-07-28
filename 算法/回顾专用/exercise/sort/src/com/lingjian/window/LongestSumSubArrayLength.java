package com.lingjian.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个数组，值可以为正、负和0，请返回累加和为给定值k的最长子数组长度
 * @author: Ling Jian
 * @date: 2020-05-23 08:01
 **/
public class LongestSumSubArrayLength {
    public static void main(String[] args) {


        int[] arr = new int[]{7, 1, 2, 1, 3, -1, -6, 7, 3, 4};
        int aim=7;
        int res = getLength(arr, aim);
        System.out.println(res);
    }

    private static int getLength(int[] arr, int k) {
        if (arr == null) {
            throw new RuntimeException("数组为null try again");
        }
        int len=0;
        int sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);    //very important
        for (int i = 0; i <arr.length ; i++) {
            sum += arr[i];
            int gap=sum-k;
            if(!map.containsKey(gap)){
                map.put(sum, i);
            }else{
                len = Math.max(i - map.get(gap), len);
            }

        }
        return len;
    }
}
