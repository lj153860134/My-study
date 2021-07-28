package com.lingjian.jianzhi;

import java.util.Arrays;

/**
 * @description: 输入一个矩阵
 *               按照从外向里以顺时针的顺序依次打印出每一个数字
 * @author: Ling Jian
 * @date: 2020-06-23 17:57
 **/
public class Test_29 {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        int[] res = spiralOrder(matrix);
        System.out.println(Arrays.toString(res));


    }

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if(++l > r) break;
        }
        return res;

        }

}
