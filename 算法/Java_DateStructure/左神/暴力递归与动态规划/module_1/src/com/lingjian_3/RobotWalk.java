package com.lingjian_3;

/**
 * @description: 阿里原题 机器人走路
 *
 * @author: Ling Jian
 * @date: 2020-03-16 10:51
 **/
public class RobotWalk {
    public static void main(String[] args) {
       int res=process1(4,2,4,30);
        System.out.println(res);

        res=process2(4,2,4,30);
        System.out.println(res);
    }

    /**
     *  N:一共有N个dian
     *  (可往左 可以往右 在1只能往右 在N只能往左）
     *  K:最终要求到达的位置
     *  M:当前所在的位置
     *  P:还剩下的步数
     * @param n
     * @param k
     * @param m
     * @param p
     * @return
     */
    //暴力递归
    public static int process1(int n,int k,int m,int p){
        if(n<0||m<1||m>n||k<1||k>n||p<0){
            return 0;
        }
        if(p==0){
            return m==k?1:0;
        }
        return process1(n,k,m+1,p-1)+process1(n,k,m-1,p-1);
    }


    //动态规划
    public static int process2(int n,int k,int m,int p){
        if(n<0||k<0||k>n||p<0){
            return 0;
        }
        int[][]dp=new int[p+1][n+1];
        dp[0][k]=1;
        for (int i = 1; i <=p ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(j==1){
                    dp[i][j]=dp[i-1][j+1];
                }else if(j==n){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                   dp[i][j]=dp[i-1][j+1]+dp[i-1][j-1];
                }
            }
        }
        return dp[p][m];
    }

}
