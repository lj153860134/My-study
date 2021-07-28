package com.lingjian.jianzhi;

/**
 * @description: 输入一棵二叉树的根节点
 * 求该树的深度
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径
 * 最长路径的长度为树的深度
 * @author: Ling Jian
 * @date: 2020-07-03 19:04
 **/
public class Test_55_1 {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
