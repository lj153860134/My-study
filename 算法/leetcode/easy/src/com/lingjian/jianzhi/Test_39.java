package com.lingjian.jianzhi;

import java.util.HashMap;

/**
 * @description: 数组中有一个数字出现的次数超过数组长度的一半
 *               请找出这个数字
 * @author: Ling Jian
 * @date: 2020-06-28 18:28
 **/
public class Test_39 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,2,1,1,1,2,2};
        int res = majorityElement(nums);
        System.out.println(res);
    }

    public static int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int mid = nums.length / 2;
        for (int i = 0; i <nums.length ; i++) {
            int count=map.getOrDefault(nums[i],0);
            count++;
            if(count>mid){
                return nums[i];
            }else{
                map.put(nums[i],count);
            }
        }
        return 0;


    }


    //投票法
    public static int majorityElement1(int[] nums) {

        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
