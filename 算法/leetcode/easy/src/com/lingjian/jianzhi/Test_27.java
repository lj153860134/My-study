package com.lingjian.jianzhi;

/**
 * @description: 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 * @author: Ling Jian
 * @date: 2020-06-23 17:23
 **/
public class Test_27 {
    public static void main(String[] args) {

    }

    public static TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left=root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }
}
