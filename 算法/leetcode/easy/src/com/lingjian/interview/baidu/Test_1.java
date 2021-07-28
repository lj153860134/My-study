package com.lingjian.interview.baidu;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-08-13 20:22
 **/
public class Test_1 {
    public static void main(String[] args) {
        int[] input = new int[]{6, 2, 7, 3, 2};
        int[] res = solution(input);
        System.out.println(Arrays.toString(res));

        int[] nums=new int[]{-10,-8,-6,-2,-20};
        int res1 = solution2(nums);
        int res2 = solution2(nums);
        System.out.println(res1);
        System.out.println(res2);

    }



    public static int[] solution(int[] input){
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[input.length];
        for(int i=0;i<input.length;i++){
            while(!stack.isEmpty()&&input[stack.peek()]<input[i]){
                int num=stack.pop();
                res[num]=i-num;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            res[stack.pop()]=-1;
        }

        return res;
    }


    public static int solution2(int[] nums){
        int max=Integer.MIN_VALUE;
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i-1],nums[i-1]);
            max=Math.max(dp[i],max);
        }
        return max;
    }

    public static int solution3(int[] nums){
        int sum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(sum<0){
                sum=nums[i];
            }else{
                sum+=nums[i];
            }

        }
        return sum;
    }

}
