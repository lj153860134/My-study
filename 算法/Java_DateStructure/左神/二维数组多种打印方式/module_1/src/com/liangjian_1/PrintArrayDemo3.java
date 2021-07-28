package com.liangjian_1;

/**
 * @description: "之"字打印二维数组
 * @author: Ling Jian
 * @date: 2019-12-19 11:29
 **/
public class PrintArrayDemo3 {
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
        int Ar = 0;
        int Ac = 0;
        int Br = 0;
        int Bc = 0;
        boolean flag=false;
        while (Ar <= row - 1 && Ac <= column - 1) {
            printArray(arr, Ar,Ac,Br,Bc,flag);
            Ac=Ar==row-1?Ac+1:Ac;
            Ar=Ar==row-1?Ar:Ar+1;
            Br=Bc==column-1?Br+1:Br;
            Bc=Bc==column-1?Bc:Bc+1;
            flag=!flag;
        }

    }


    public static void printArray(int[][] arr, int Ar, int Ac, int Br, int Bc,boolean flag) {
        if(flag){
            for (int i = Br,j=Bc; i <=Ar&&j>=Ac ; i++,j--) {
                System.out.print(arr[i][j]+" ");
            }
        }else{
            for (int i = Ar,j=Ac; i>=Br&&j<=Bc ; i--,j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
    }


    /**
     * 打印二维数组
     *
     * @param array
     */
    public static void print(int[][] array) {
        for (int[] ints : array) {
            System.out.print("[");
            for (int data : ints) {
                System.out.printf("%3d", data);
            }
            System.out.println(" ]");
        }

    }
}
