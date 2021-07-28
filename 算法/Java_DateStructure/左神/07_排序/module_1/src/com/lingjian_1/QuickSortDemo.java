package com.lingjian_1;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: Ling Jian
 * @date: 2019-12-08 22:53
 **/
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr=new int[]{4,3,2,4,1,2,3,5,7,8};
        System.out.print("快速排序前:");
        System.out.println(Arrays.toString(arr));
        quickSort2(arr);
        System.out.print("快速排序后:");
        System.out.println(Arrays.toString(arr));
    }

    //韩老师快排
    public static void quickSort1(int[] arr,int left,int right){
        if(arr==null||arr.length<2){
            return;
        }
        int l=left;
        int r=right;
        int pivot=arr[(l+r)/2];
        int temp=0;
        while(l<r){
            while(arr[l]<pivot){
                l++;
            }
            while(arr[r]>pivot){
                r--;
            }

            if(l==r){ //这里需不需要l>=r(思考一下）
                break;
            }
            temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;

            if(arr[l]==pivot){
                r--;
            }

            if(arr[r]==pivot){
                l++;
            }

        }
//        System.out.println(Arrays.toString(arr));
        if(l==r){
            l++;
            r--;
        }

        if(left<r){
            quickSort1(arr,left,r);
        }

        if(right>l){
            quickSort1(arr,l,right);
        }
    }

    /**
    * @description: 我的快排
    * @param: [arr]
    * @return: void
    * @author: Ling Jian
    * @date: 2019/12/11 3:58 下午
    */
    public static void  quickSort2(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        quick(arr,0,arr.length-1);
    }

    public  static void quick(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        int less=left-1;
        int more=right+1;
        int cur=left;
        int num=arr[left+(int)((right-left+1)*Math.random())];
        while(cur<more){
            if(arr[cur]<num){
                swap(arr,++less,cur++);
            }else if(arr[cur]>num){
                swap(arr,--more,cur);
            }else{
                cur++;
            }
        }
        quick(arr,left,less);
        quick(arr,more,right);
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
