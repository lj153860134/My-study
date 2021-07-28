package com.lingjian.jianzhi;

/**
 * @description: 给定一个二叉搜索树
 *               找到该树中两个指定节点的最近公共祖先。
 * @author: Ling Jian
 * @date: 2020-06-30 15:30
 **/
public class Test_68_1 {
    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
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
