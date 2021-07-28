package com.lingjian.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 输入一个正整数target
 *               输出所有和为target的连续正整数序列(至少含有两个数)
 *               序列内的数字由小到大排列
 *               不同序列按照首个数字从小到大排列
 * @author: Ling Jian
 * @date: 2020-07-06 16:51
 **/
public class Test_57_2 {
    public static void main(String[] args) {
        int target=55;
        List<List<Integer>> list = findContinuousSequence(target);
        List<List<Integer>> list1 = findContinuousSequence1(target);

            System.out.println(Arrays.toString(list.toArray()));
            System.out.println(Arrays.toString(list1.toArray()));


    }

        public static List<List<Integer>> findContinuousSequence(int target) {
        List<List<Integer>> res = new ArrayList<>();
        int half=(target>>1)+1;
        int sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
        for (int i = 1; i <=half ; i++) {
            sum+=i;
            if(map.containsKey(sum-target)){
                List<Integer> list = new ArrayList<>();
                for (int j = map.get(sum-target)+1; j <=i ; j++) {
                    list.add(j);
                }
                res.add(list);
            }
            map.put(sum, i);
        }
        return res;


    }

    //双指正
    public static List<List<Integer>> findContinuousSequence1(int target) {
        List<List<Integer>> res = new ArrayList<>();
        int half = (target >> 1) + 1;
        int left = 1;
        int right = 1;
        int sum = 0;
        while (right <= half+1) {
            if (sum > target) {
                sum -= left++;
            } else if (sum < target) {
                sum += right++;
            } else {
                List<Integer> list = new ArrayList<>();
                for (int i = left; i <right; i++) {
                    list.add(i);
                }
                res.add(list);
                sum -= left++;

            }

        }
        return res;


    }
}
