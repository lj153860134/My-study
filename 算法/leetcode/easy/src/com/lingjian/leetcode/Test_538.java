package com.lingjian.leetcode;

/**
 * @description: 给定一个二叉搜索树（Binary Search Tree）
 * 把它转换成为累加树（Greater Tree)
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和
 *
 * @author: Ling Jian
 * @date: 2020-09-21 10:10
 **/
public class Test_538 {
    public static void main(String[] args) {

    }

   static int num=0;
    public static TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null ;
        }
        convertBST(root.right);
        root.val+=num;
        num=root.val;
        convertBST(root.left);
        return root;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
