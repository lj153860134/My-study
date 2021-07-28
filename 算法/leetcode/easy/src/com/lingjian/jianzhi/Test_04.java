package com.lingjian.jianzhi;

/**
 * @description: 在一个 n * m 的二维数组中
 * 每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序
 * 请完成一个函数，输入这样的一个二维数组和一个整数
 * 判断数组中是否含有该整数。
 * @author: Ling Jian
 * @date: 2020-06-20 16:56
 **/
public class Test_04 {
    public static void main(String[] args) {


        int[][] matrix = new int[][]{
                {1, 4, 7,11,15},
                {2, 5, 8,12,19},
                {3, 6, 9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
//        int target = 26;

        System.out.println(findNumberIn2DArray(matrix,17));
    }


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row=0;
        int col = matrix[0].length - 1;
        while(row<matrix.length&& col >=0){
            if (matrix[row][col] == target) {
                return true;
            }else if(matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

}
