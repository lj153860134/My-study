package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一个包含m x n个元素的矩阵（m 行, n 列)
 *               请按照顺时针螺旋顺序，返回矩阵中的所有元素
 * @author: Ling Jian
 * @date: 2020-08-25 15:35
 **/
public class Test_54 {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(Arrays.toString(list.toArray()));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left=0;
        int top=0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        while(true) {
            for (int i = left; i <=right; i++) {
                res.add(matrix[top][i]);
            }
            if(++top>bottom) break;
            for( int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            if(--right<left) break;
            for (int i = right; i >=left ; i--) {
                res.add(matrix[bottom][i]);
            }
            if(--bottom<top) break;
            for (int i = bottom; i >=top ; i--) {
                res.add(matrix[i][left]);
            }
            if(++left>right) break;
        }
        return res;
    }
}
