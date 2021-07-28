package com.liangjian_1;



/**
 * @description: 环形打印二维数组
 * @author: Ling Jian
 * @date: 2019-12-19 10:29
 **/
public class PrintArrayDemo1 {
    public static void main(String[] args) {
        int[][] arr=new int[4][4];
        int row=arr.length;
        int column=arr[0].length;
        int j=1;
        for (int i = 0; i <row ; i++) {
            for (int k = 0; k <column ; k++,j++) {
                arr[i][k]=j;
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

    public static void printArray(int[][] arr,int Lr,int Lc,int Rr,int Rc) {
        if (Lr == Rr) {
            for (int i = Lc; i <= Rc; i++) {
                System.out.print(arr[Lr][i] + " ");
            }
        } else if (Lc == Rc) {
            for (int i = Lr; i <= Rr; i++) {
                System.out.print(arr[i][Lc] + " ");
            }
        } else {

                for (int i = Lc; i < Rc; i++) {
                    System.out.print(arr[Lr][i] + " ");
                }
                for (int i = Lr; i < Rr; i++) {
                    System.out.print(arr[i][Rc] + " ");
                }
                for (int i = Rc; i > Lc; i--) {
                    System.out.print(arr[Rr][i] + " ");
                }
                for (int i = Rr; i > Lr; i--) {
                    System.out.print(arr[i][Lc] + " ");
                }



        }
    }

        public static void printEdge(int[][] m, int tR, int tC,int dR, int dC) {
            if (tR == dR) {
                for (int i = tC; i <= dC; i++) {
                    System.out.print(m[tR][i] + " ");
                }
            } else if (tC == dC) {
                for (int i = tR; i <= dR; i++) {
                    System.out.print(m[i][tC] + " ");
                }
            } else {
                int curC = tC;
                int curR = tR;
                while (curC != dC) {
                    System.out.print(m[tR][curC] + " ");
                    curC++;
                }
                while (curR != dR) {
                    System.out.print(m[curR][dC] + " ");
                    curR++;
                }
                while (curC != tC) {
                    System.out.print(m[dR][curC] + " ");
                    curC--;
                }
                while (curR != tR) {
                    System.out.print(m[curR][tC] + " ");
                    curR--;
                }
            }
    }


}
