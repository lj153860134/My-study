package com.lingjian.jianzhi;

/**
 * @description: 地上有一个m行n列的方格
 *                  从坐标 [0,0] 到坐标 [m-1,n-1]
 *                  一个机器人从坐标 [0, 0] 的格子开始移动
 *                  它每次可以向左、右、上、下移动一格（不能移动到方格外)
 *                  也不能进入行坐标和列坐标的数位之和大于k的格子
 *                  例如，当k为18时，机器人能够进入方格 [35, 37]
 *                  因为3+5+3+7=18。但它不能进入方格 [35, 38]
 *                  因为3+5+3+8=19。请问该机器人能够到达多少个格子
 * @author: Ling Jian
 * @date: 2020-06-22 15:08
 **/
public class Test_13 {
    public static void main(String[] args) {
        int m=10;
        int n=10;
        int k=5;

        int res = movingCount(m, n, k);
        int res1 = movingCount1(m, n, k);
        System.out.println(res);
        System.out.println(res1);
    }

    public static int movingCount(int m, int n, int k) {
        if(k==0||(m==1&&n==1)){
            return 1;
        }
        int[][] dp  = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        return process(dp, 0, 0, k,visited);
    }

    public static int process(int[][] dp, int i, int j, int k,boolean[][] visited) {
        if(i<0||j<0||i>= dp.length||j>= dp[0].length||visited[i][j]){
            return 0;
        }
        if(dp[i][j]!=0) return dp[i][j];
        visited[i][j] = true;
        if((getSum(i)+getSum(j))>k){
            dp[i][j]= process(dp,i-1,j,k, visited)+
            process(dp, i, j - 1, k, visited);
            return dp[i][j];
        }else{

           dp[i][j]= process(dp,i+1,j,k, visited)+
           process(dp,i-1,j,k, visited)+
           process(dp,i,j+1,k, visited)+
           process(dp,i,j-1,k, visited);
            return ++dp[i][j];
        }



    }

    public static int movingCount1(int m, int n, int k) {
        if(k==0||(m==1&&n==1)){
            return 1;
        }
        int[][] arr = new int[m][n];
        return process1(arr, 0, 0, k);
    }

    public  static int process1(int[][] arr, int i, int j, int k) {
        if(i<0||j<0||i>=arr.length||j>=arr[0].length||arr[i][j]==1){
            return 0;
        }
        arr[i][j]=1;
        if((getSum(i)+getSum(j))>k){

            return process1(arr,i-1,j,k)+
                    process1(arr, i, j - 1, k);
        }else{

            return process1(arr,i+1,j,k)+
                    process1(arr,i-1,j,k)+
                    process1(arr,i,j+1,k)+
                    process1(arr,i,j-1,k)+1;
        }



    }

    public static int getSum(int n){
        int res=0;
        while(n!=0){
            res+=n%10;
            n/=10;
        }
        return res;
    }
}
