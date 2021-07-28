package com.lingjian.leetcode;

import java.util.PriorityQueue;

/**
 * @description: 给定一个表示分数的非负整数数组
 *               玩家 1 从数组任意一端拿取一个分数
 *               随后玩家 2 继续从剩余数组任意一端拿取分数
 *               然后玩家 1 拿，…… 。
 *               每次一个玩家只能拿取一个分数
 *               分数被拿取之后不再可取
 *               直到没有剩余分数可取时游戏结束
 *               最终获得分数总和最多的玩家获胜
 *               给定一个表示分数的数组，预测玩家1是否会成为赢家
 *               你可以假设每个玩家的玩法都会使他的分数最大化
 * @author: Ling Jian
 * @date: 2020-09-01 11:13
 **/
public class Test_486 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 23,7};
        boolean res = PredictTheWinner(nums);
        System.out.println(res);
    }

    //动态规划   dp[i][j]当前玩家在数组[i:j]中先手，赢过对方的分数。
    public static boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        //base case
        for (int i = 0; i <nums.length ; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = nums.length-2; i >=0 ; i--) {
            for (int j = i+1; j <nums.length ; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;


    }
    /**
     *【博弈】【动态规划】
     * 区间[i, j]中先手可获得的最大值：掌握主动权———拿[端点]+[剩下的后手]。拿左端点还是右端点自己决定(取最大值)
     * 区间[i, j]中后手可获得的最大值：身不由己———不到端点，且只能拿到[剩下的先手]。因为只能用对手剩下的，所以只能取[剩下先手]的最小值
     *
     * 注意：
     * 1.【博弈】的题目中，先手和后手在动态规划的过程中不断巧妙转化，注意体会
     * 2.【博弈】的题目中，先手主动，后手被动———后手倾向于【被动记录】而非【主动选择】，这是博弈题目的默认要求
     * 3.【动态规划】时：注意填表顺序；数组可以压缩，但没必要
     */
    //dp另一种思路
    public static boolean PredictTheWinner1(int[] nums) {
        int len = nums.length;
        int[][] dp1 = new int[len][len];    // 先手
        int[][] dp2 = new int[len][len];    // 后手

        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    dp1[i][j] = nums[i];    // 初始化
                    continue;
                }
                dp1[i][j] = Math.max(nums[i] + dp2[i + 1][j], nums[j] + dp2[i][j - 1]);     //【主动选择】
                dp2[i][j] = Math.min(dp1[i + 1][j], dp1[i][j - 1]);                         //【被动记录】
            }
        }

        return dp1[0][len - 1] >= dp2[0][len - 1];
    }

}
