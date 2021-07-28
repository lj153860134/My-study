package com.lingjian.pailie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一个无重复元素的数组candidates和一个目标数target 
 *               找出 candidates 中所有可以使数字和为target的组合
 *               candidates 中的数字可以无限制重复被选取
 * @author: Ling Jian
 * @date: 2020-08-26 09:54
 **/
public class Test_39 {
    public static void main(String[] args) {
        int[] candidates = new int[]{1,2,3,5,10};
        int target = 10;
        List<List<Integer>> ans = combinationSum(candidates, target);
        System.out.println(Arrays.toString(ans.toArray()));
        System.out.println(ans.size());
        int count = coinChanges(candidates, target);
        System.out.println(count);

    }
    static List<List<Integer>> res = new ArrayList<>();



    public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null){
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        dfs(candidates, 0, list,target);
        return res;
    }

    public static void dfs(int[] candidates, int start, LinkedList<Integer> list,int target){
        if(target<0){
            return;
        }
        if(target==0) {
            res.add(new ArrayList<>(list));
        }
        for (int i =start; i <candidates.length ; i++) {

            list.add(candidates[i]);
            dfs(candidates, i , list, target - candidates[i]);
            list.pollLast();
        }
    }

    //类似换钱 可计算换钱个数
    public static int coinChanges(int[] nums,int target){
        if(target<0||nums.length==0||nums==null){
            return 0;
        }
        int[][] dp = new int[nums.length + 1][target + 1];
        //base case
        dp[0][0] = 1;
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 0; j <dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - nums[i - 1] >= 0 ? dp[i][j - nums[i - 1]] : 0;
            }
        }
        return dp[nums.length][target];
    }

}
