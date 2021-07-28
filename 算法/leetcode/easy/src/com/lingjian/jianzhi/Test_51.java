package com.lingjian.jianzhi;

/**
 * @description: 在数组中的两个数字（分治）
 *               如果前面一个数字大于后面的数字
 *               则这两个数字组成一个逆序对
 *               输入一个数组，求出这个数组中的逆序对的总数
 * @author: Ling Jian
 * @date: 2020-07-10 16:03
 **/
public class Test_51 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,1,2,1};
        int res = reversePairs(nums);
        System.out.println(res);
    }


    public static int reversePairs(int[] nums) {
        if(nums==null||nums.length<=1){
            return 0;
        }

        return process(nums,0,nums.length-1);


    }


    public static int process(int[] nums,int left,int right){
        if(left==right){
            return 0;
        }
        int mid=left+((right-left)>>1);
        return process(nums,left,mid)+process(nums,mid+1,right)
                +merge(nums,left,mid,right);
    }

    public static int merge(int[] nums,int left,int mid,int right){
        int[] help=new int[right-left+1];
        int index=0;
        int p1=left;
        int p2=mid+1;
        int res=0;
        while(p1<=mid&&p2<=right){
            res+=nums[p1]>nums[p2]?(mid-p1+1):0;
            help[index++]=nums[p1]<=nums[p2]?nums[p1++]:nums[p2++];
        }
        while(p1<=mid){
            help[index++]=nums[p1++];
        }
        while(p2<=right){
            help[index++]=nums[p2++];
        }
        for (int i = 0; i <help.length ; i++) {
            nums[i+left]=help[i];
        }
        return res;

    }


    //小和问题 用分治
    /**
     * @description: 用归并的思想（分治法 递归）来求解
     * @param: [arr]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/10 5:11 下午
     */
    public static int mergeMethod(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return setProcess(arr, 0, arr.length - 1);
    }

    public static int setProcess(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1); //这里后面一定要加括号

        return setProcess(arr, left, mid) +
                setProcess(arr, mid + 1, right) +
                merge1(arr, left, mid, right);
    }

    public static int merge1(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int p = 0;
        int res = 0;  //返回值
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                res += arr[p1] * (right - p2 + 1);
                help[p++] = arr[p1++];
            } else {
                help[p++] = arr[p2++];
//            res+=arr[p1]<arr[p2]?arr[p1]*(right-p2+1):0;
//            help[p++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[p++] = arr[p1++];
        }

        while (p2 <= right) {
            help[p++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

        return res;
    }
}
