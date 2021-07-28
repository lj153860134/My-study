package com.lingjian_3;

import java.util.Arrays;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2019-12-11 14:49
 **/
/*
* 需求：给定一个数组arr 和一个数num
*      把小于等于num的数放在数组左边
*      把大于num的数放在数组的右边
* */
public class NetherlandsFlagDemo1 {
    public static void main(String[] args) {

    int[] arr=new int[]{2,3,4,2,3,4,2,1,5,7,1,7};
    int num=3;
//        method1(arr,num);
//        System.out.println(Arrays.toString(arr));
        method2(arr,num);
        System.out.println(Arrays.toString(arr));

    }

    /*
     * 需求：给定一个数组arr 和一个数num
     *      把小于等于num的数放在数组左边
     *      把大于num的数放在数组的右边
     * */

    public static void method1(int[] arr,int num){
        int p=-1;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]<=num){
                swap(arr,++p,i);
            }
        }
    }

    /*
     * 需求：给定一个数组arr 和一个数num
     *      把小于num的数放在数组左边
     *      等于num的数放在数组中间
     *      把大于num的数放在数组的右边
     */

    public static void method2(int[] arr,int num){
        int less=-1;
        int more=arr.length;
        int cur=0;
        while(cur<more){
            if(arr[cur]<num){
                swap(arr,++less,cur++);
            }else if(arr[cur]>num){
                swap(arr,--more,cur);
            }else{
                cur++;
            }
        }

    }


    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
