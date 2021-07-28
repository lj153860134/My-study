package com.lingjian.leetcode;

/**
 * @description: 给定一个二叉树和一个目标和
 * 判断该树中是否存在根节点到叶子节点的路径
 * 这条路径上所有节点值相加等于目标和
 * @author: Ling Jian
 * @date: 2020-07-07 14:09
 **/
public class Test_112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        boolean res = hasPathSum(root, 1);
        System.out.println(res);

    }

    public static boolean hasPathSum(TreeNode root, int sum) {

        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return root.val-sum==0;
        }
        sum-=root.val;
        return hasPathSum(root.left,sum)||
                hasPathSum(root.right,sum);
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
