package com.lingjian.dynamicprogramming;

/**
 * @description: 我们将给定的数组 A 分成 K 个相邻的非空子数组
 *               我们的分数由每个子数组内的平均值的总和构成
 *               计算我们所能得到的最大分数是多少
 * @author: Ling Jian
 * @date: 2020-06-02 17:02
 **/
public class Test_813 {
    public static void main(String[] args) {
        int[] arr=new int[]{9,1,2,3,9};
        int K =3;
        double res = largestSumOfAverages1(arr, K);
        System.out.println(res);
    }

    //暴力递归(超出时间限定）
    public static double largestSumOfAverages(int[] A, int K) {
        if (K == A.length) {
            double res=0;
            for (int i : A) {
                res += i;
            }
            return res;
        }
        if (K == 1) {
            double res = 0;
            for (int i : A) {
                res += i;
            }
            return res / A.length;
        }

        return process(A, K, 0, A.length );



    }

    public  static double process(int[] arr, int k, int left, int right) {
        if (k == 1) {
            double sum = 0;
            for (int i = left; i <right ; i++) {
                sum += arr[i];
            }
            return sum / (right - left );
        }
        double max = Double.MIN_VALUE;
        for (int i = left; i <right-k+1 ; i++) {
                double sum=0;
            for (int j = left; j < i+1; j++) {
                sum += arr[j];
            }
            max=Math.max(max,sum / (i + 1-left) + process(arr, k - 1, i+1, right));
        }
        return max;
    }

    //暴力递归转动态规划
    public static double largestSumOfAverages1(int[] A, int K){
        //dp[i][j]：表示arr数组中前i个数 分成j组 最大的平均值总和
        //目标值为dp[A.length][K]
        double [][] dp = new double [A.length + 1][K + 1];
        double[] sum = new double[A.length+1];
        for (int i = 1; i <A.length+1 ; i++) {
            sum[i] += A[i-1] + sum[i - 1];
        }
        for (int i = 0; i <A.length+1 ; i++) {
            dp[i][1] = sum[i]/i;
        }
        for (int i = 2; i <A.length+1 ; i++) {
            for (int j = 2; j <K+1 ; j++) {
                for (int k = 1; k < i-j+2; k++) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-k][j-1]+(sum[i]-sum[i-k])/k);
                }
            }
        }
        return dp[A.length][K];

    }

}
