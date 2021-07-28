package com.lingjian.jianzhi;

/**
 * @description: 请实现一个函数用来匹配包含'. '和'*'的正则表达式
 *               模式中的字符'.'表示任意一个字符
 *               而'*'表示它前面的字符可以出现任意次（含0次
 *               在本题中，匹配是指字符串的所有字符匹配整个模式
 * @author: Ling Jian
 * @date: 2020-07-10 16:01
 **/
public class Test_19 {
    boolean flag;
    boolean[][] cache;
    public boolean isMatch(String s, String p) {
        cache = new boolean[s.length()][p.length()];
        backtracking(0, 0, s, p);
        return flag;
    }
    private void backtracking(int sId, int pId, String s, String p) {
        if (flag) {
            return;
        }

        if (sId >= s.length()) {
            while (pId + 1 < p.length() && p.charAt(pId + 1) == '*') {
                pId += 2;
            }
            if (pId >= p.length()) {
                flag = true;
            }
            return;
        }

        if (pId >= p.length()) {
            return;
        }

        if (cache[sId][pId]) {
            return;
        }

        cache[sId][pId] = true;

        char pc = p.charAt(pId);
        char sc = s.charAt(sId);

        if (pId + 1 < p.length() && p.charAt(pId + 1) == '*') {
            if (pc == '.' || pc == sc) {
                backtracking(sId + 1, pId, s, p);
            }
            backtracking(sId, pId + 2, s, p);
        } else if (pc == sc || pc == '.') {
            backtracking(sId + 1, pId + 1, s, p);
        }
    }

    //练习
    public boolean isMatch1(String A, String B) {
        int m = A.length();
        int n = B.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <m+1 ; i++) {
            for (int j = 0; j <n+1 ; j++) {
                dp[i][j]=i==0;
                if(B.charAt(j-1)!='*'){
                    if(i>0&&(A.charAt(i-1)==B.charAt(j-1)||B.charAt(j-1)=='.')){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }else{
                    //不看B的后两位
                    if(j>=2){
                        dp[i][j] = dp[i][j - 2];
                    }
                    //看B的后两位
                    if(i>=1&&j>=2&&(A.charAt(i-1)==B.charAt(j-2)||B.charAt(j-2)=='.')){
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }

        }

        return dp[m][n];
    }
}
