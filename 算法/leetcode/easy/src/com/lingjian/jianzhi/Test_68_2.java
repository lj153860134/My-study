package com.lingjian.jianzhi;

/**
 * @description: 给定一个二叉树
 *               找到该树中两个指定节点的最近公共祖先
 * @author: Ling Jian
 * @date: 2020-06-30 16:51
 **/
public class Test_68_2 {

    public static void main(String[] args) {

    }

    public  static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null&&right==null) return null;
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
