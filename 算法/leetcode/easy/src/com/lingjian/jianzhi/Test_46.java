package com.lingjian.jianzhi;

/**
 * @description: 给定一个数字
 *              我们按照如下规则把它翻译为字符串：0 翻译成 “a”
 *              1 翻译成 “b”，……，11 翻译成 “l”，……，
 *              25 翻译成 “z”。
 *              一个数字可能有多个翻译
 *              请编程实现一个函数
 *              用来计算一个数字有多少种不同的翻译方法
 * @author: Ling Jian
 * @date: 2020-07-09 16:19
 **/
public class Test_46 {
    public static void main(String[] args) {
        int num=12258;
        int res=translateNum(num);
        System.out.println(res);

    }
    //dp[i]表示以String第i位结尾的翻译方法
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            int count=(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0');
            if(count<=25){
                dp[i]=dp[i-2]+dp[i-1];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[s.length()];
    }


}
