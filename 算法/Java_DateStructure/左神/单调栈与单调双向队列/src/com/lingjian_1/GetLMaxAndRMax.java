package com.lingjian_1;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 利用单调栈求一个数组两端靠近自身的最大值
 * @author: Ling Jian
 * @date: 2020-03-13 14:13
 **/
public class GetLMaxAndRMax {
    public static void main(String[] args) {
        int[] arr=new int[]{1,3,4,6,5,8,9,2,7};
        getMax(arr);
    }

    public static void getMax(int[] arr){
        if(arr==null){
            System.out.println("数组为空 无法获取两端最大值");
            return;
        }

        Integer[] RightMax = new Integer[arr.length];
        Integer[] LeftMax = new Integer[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <arr.length ; i++) {
            while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
                int num=stack.pop();
                RightMax[num]=arr[i];
                LeftMax[num] = stack.isEmpty() ? null : arr[stack.peek()];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int num=stack.pop();
            RightMax[num]=null;
            LeftMax[num] = stack.isEmpty() ? null : arr[stack.peek()];
        }

        System.out.println(Arrays.toString(RightMax));
        System.out.println(Arrays.toString(LeftMax));

    }
}
