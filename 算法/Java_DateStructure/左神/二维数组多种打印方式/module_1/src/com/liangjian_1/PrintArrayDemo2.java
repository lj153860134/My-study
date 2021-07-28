package com.liangjian_1;

import java.lang.invoke.LambdaConversionException;

/**
 * @description: 顺时针90度打印正方形二维数组
 * @author: Ling Jian
 * @date: 2019-12-19 11:28
 **/
public class PrintArrayDemo2 {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        int row = arr.length;
        int column = arr[0].length;
        int j = 1;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++, j++) {
                arr[i][k] = j;
            }
        }
        print(arr);
        System.out.println("==========");
        int Lr=0;
        int Lc=0;
        int Rr=row-1;
        int Rc=column-1;
        while(Lr<=Rr&&Lc<=Rc) {
            printArray(arr,Lr++,Lc++,Rr--,Rc--);
        }
        print(arr);
    }

    private static void printArray(int[][] arr, int Lr,int Lc, int Rr, int Rc) {
        for (int i = 0; i <Rr-Lr ; i++) {
            int temp=arr[Lr][Lc+i];
            arr[Lr][Lc+i]=arr[Rr-i][Lc];
            arr[Rr-i][Lc]=arr[Rr][Rc-i];
            arr[Rr][Rc-i]=arr[Lr+i][Rc];
            arr[Lr+i][Rc]=temp;
        }
    }


    /**
         * 打印二维数组
         * @param array
         */
        public static void print(int[][] array){
            for (int[] ints : array) {
                System.out.print("[");
                for (int data : ints) {
                    System.out.printf("%3d",data);
                }
                System.out.println(" ]");
            }

        }
}
