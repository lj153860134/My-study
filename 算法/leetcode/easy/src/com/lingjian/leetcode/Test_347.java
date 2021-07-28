package com.lingjian.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @description: 给定一个非空的整数数组
 *               返回其中出现频率前 k 高的元素。
 * @author: Ling Jian
 * @date: 2020-08-24 15:10
 **/
public class Test_347 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int index=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> min=new PriorityQueue<>((x,y)->(map.get(x)-map.get(y)));
        for (int num:map.keySet()) {
            if(min.size()<k){
                min.add(num);
            }else if(map.get(num)>map.get(min.peek())){
                min.poll();
                min.add(num);
            }
        }
        while(!min.isEmpty()){
            res[index++] = min.poll();
        }
        return res;
    }
}
