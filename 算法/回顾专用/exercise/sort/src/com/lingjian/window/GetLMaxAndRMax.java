package com.lingjian.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @description: 利用单调栈求一个数组两端靠近自身的最大值
 * @author: Ling Jian
 * @date: 2020-05-23 08:13
 **/
public class GetLMaxAndRMax {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,3,4};
        getMax(arr);
    }

    private static void getMax(int[] arr) {
        if (arr == null) {
            return;
        }
        Integer[] LMax = new Integer[arr.length];
        Integer[] RMax = new Integer[arr.length];
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] < arr[i]) {
                list=stack.pop();
                for (Integer num : list) {
                LMax[num] = stack.isEmpty() ? null : arr[stack.peek().get(0)];
                RMax[num] = arr[i];

                }
            }
            if(!stack.isEmpty()&&arr[stack.peek().get(0)]==arr[i]){
                stack.peek().add(i);
            }else{
                List<Integer> list1 = new ArrayList<>();
                list1.add(i);
                stack.push(list1);
            }

        }
        while(!stack.isEmpty()){
            list=stack.pop();
            for (Integer num : list) {

            LMax[num]=stack.isEmpty() ? null : arr[stack.peek().get(0)];
            RMax[num] = null;
            }
        }
        System.out.println(Arrays.toString(LMax));
        System.out.println(Arrays.toString(RMax));

    }
}
