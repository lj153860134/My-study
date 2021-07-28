package com.lingjian.jianzhi;

import java.util.HashMap;

/**
 * @description: 在一个数组nums中除一个数字只出现一次之外
 *               其他数字都出现了三次
 *               请找出那个只出现一次的数字
 * @author: Ling Jian
 * @date: 2020-07-08 16:18
 **/
public class Test_56_2 {
    public static void main(String[] args) {

    int[] nums = new int[]{3, 4, 3, 3};
        int res = singleNumber(nums);
        System.out.println(res);


    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            int count=map.getOrDefault(num,0);
            map.put(num,count+1);
        }
        for (Integer i : map.keySet()) {
            if(map.get(i)==1){
                return i;
            }
        }
        return 0;
    }

}
