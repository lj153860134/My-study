package com.lingjian.exercise;



/**
 * @description: 给定一个数组全是正数
 *               目标aim 求累加和等于aim的最长子数组长度
 * @author: Ling Jian
 * @date: 2020-08-03 23:49
 **/
public class Demo3 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,1,1,1,3};
        int aim=6;
        int res = maxLength(nums, aim);
        System.out.println(res);

    }
    public static int maxLength(int[] nums,int aim){
        if(nums==null||nums.length==0||aim<=0){
            return 0;
        }
        int L=0;
        int R=0;
        int sum=0;
        int res=0;
        while(R<nums.length){
            if(sum<aim){
                sum += nums[R++];
            }else if(sum>aim){
                sum-=nums[L++];
            }else {
                res = Math.max(R - L + 1, res);
                sum+=nums[R++];
            }
        }
        return res;
    }
}
