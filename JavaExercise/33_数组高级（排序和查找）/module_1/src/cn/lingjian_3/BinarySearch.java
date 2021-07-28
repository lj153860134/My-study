package cn.lingjian_3;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-09-02 - 17:04
 */
/*
* 查找：
*       基本查找：数组元素无序（从头找到尾）
*       二分查找（折半查找）：数组元素有序
*
*
* */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a integer");
        int number=sc.nextInt();
        int [] arr={11,22,33,44,55,66};
        int index=SearchOfIndex(arr,number);
        System.out.println(index);

    }

    public static int SearchOfIndex(int[] arr,int number){
        int min=0;
        int max=arr.length-1;
        int mid=(min+max)/2;
        while(arr[mid]!=number){
            if(arr[mid]<number){
                min=mid+1;
            }else{
                max=mid-1;
            }
            mid=(min+max)/2;
            if(min>max){
                return -1;
            }
        }
        return mid;
    }
}
