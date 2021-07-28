package com.lingjian.jianzhi;

/**
 * @description: 统计一个数字在排序数组中出现的次数
 * @author: Ling Jian
 * @date: 2020-07-08 16:59
 **/
public class Test_53_1 {
    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,10};
        int target=6;
        int res = search(nums, target);
        System.out.println(res);


    }

    public static int search(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int res=process( nums,target,0,nums.length-1);
        return res;
    }

    public static int process(int[] nums,int target,int left,int right){
        if(left>right){
            return 0;
        }
        int mid=left+((right-left)>>1);
        if(nums[mid]==target){
            int temp=mid;
            int count=-1;
            while(mid<nums.length&&nums[mid++]==target) count++;
            while(temp>=0&&nums[temp--]==target) count++;
            return count;
        }else if(nums[mid]>target){
            return process(nums,target,left,mid-1);
        }else{
            return process(nums,target,mid+1,right);
        }
    }


}
