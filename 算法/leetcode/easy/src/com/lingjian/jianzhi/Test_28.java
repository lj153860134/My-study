package com.lingjian.jianzhi;

/**
 * @description: 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的
 * @author: Ling Jian
 * @date: 2020-06-23 17:43
 **/
public class Test_28 {

    public static void main(String[] args) {

    }


    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return process(root, root);
    }
    public static boolean process(TreeNode t1,TreeNode t2 ){
        if(t1==null&&t2!=null){
            return false;
        }
        if(t1!=null&&t2==null){
            return false;
        }
        if(t1==null&&t2==null){
            return true;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return process(t1.left,t2.right)&&process(t1.right,t2.left);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }
}
