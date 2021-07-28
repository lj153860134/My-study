package cn.lingjian_1;

import java.util.concurrent.ForkJoinPool;

/**
 * @author lingjian
 * @date 2019-08-30 - 16:26
 */
/*
 * 冒泡排序基本概念是：
 * 依次比较相邻的两个数，将小数放在前面，大数放在后面。
 * 即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。
 * 然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，
 * 直至比较最后两个数，将小数放前，大数放后。至此第一趟结束，
 * 将最大的数放到了最后。在第二趟：仍从第一对数开始比较
 * （因为可能由于第2个数和第3个数的交换，使得第1个数不再小于第2个数），
 *  将小数放前，大数放后，一直比较到倒数第二个数（倒数第一的位置上已经是最大的），
 *  第二趟结束，在倒数第二的位置上得到一个新的最大数
 * （其实在整个数列中是第二大的数）。如此下去，重复以上过程，直至最终完成排序。
 */
public class ArraySortDemo1 {
    public static void main(String[] args) {
        int[] arr={24,69,80,57,13,14};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

   public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i <arr.length ; i++) {
            if(i==arr.length-1){
                System.out.println(arr[i]+"]");
            }else{
                System.out.print(arr[i]+",");
            }
        }
    }
}
