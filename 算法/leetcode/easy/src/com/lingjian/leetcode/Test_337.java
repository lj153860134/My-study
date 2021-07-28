package com.lingjian.leetcode;

/**
 * @description: 在上次打劫完一条街道之后和一圈房屋后
 * 小偷又发现了一个新的可行窃的地区
 * 这个地区只有一个入口
 * 我们称之为“根”
 * 除了“根”之外
 * 每栋房子有且只有一个“父“房子与之相连
 * 一番侦察之后
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”
 * 如果两个直接相连的房子在同一天晚上被打劫
 * 房屋将自动报警
 * 计算在不触动警报的情况下
 * 小偷一晚能够盗取的最高金额。
 * <p>
 * 这一题与宴会参加的活跃度是一样的
 * @author: Ling Jian
 * @date: 2020-07-31 20:12
 **/
public class Test_337 {
    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        returnType res = process(root);
        return Math.max(res.rob, res.no_rob);
    }

    public static returnType process(TreeNode root) {
        if(root==null){
            return new returnType(0, 0);
        }
        returnType left = process(root.left);
        returnType right = process(root.right);
        int rob = root.val + left.no_rob+ right.no_rob;
        int no_rob = Math.max(left.rob, left.no_rob) + Math.max(right.rob, right.no_rob);
        return new returnType(rob, no_rob);
    }


    static class returnType {
        private int rob;
        private int no_rob;

        public returnType(int rob, int no_rob) {
            this.rob = rob;
            this.no_rob = no_rob;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
