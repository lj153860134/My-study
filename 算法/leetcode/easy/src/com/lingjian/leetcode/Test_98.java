package com.lingjian.leetcode;

/**
 * @description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树
 * @author: Ling Jian
 * @date: 2020-06-20 15:20
 **/
public class Test_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        boolean res = isValidBST2(root);
        System.out.println(res);


    }


    //二叉树套路解题1
    public static boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return process(root).isBST;

    }

    public static ReturnType process(TreeNode root){
        if(root==null){
            return new ReturnType(true, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        ReturnType LInfo = process(root.left);
        ReturnType RInfo = process(root.right);
        if(!LInfo.isBST||!RInfo.isBST||LInfo.max>=root.val||RInfo.min<=root.val){
            return new ReturnType(false, 0, 0 );
        }
        long min=Math.min(LInfo.min,root.val);
        long max = Math.max(RInfo.max, root.val);
        return new ReturnType(true, max, min);

    }

    public static class ReturnType{
        public boolean isBST;
        public long max;
        public long min;

        public ReturnType(boolean isBST, long max, long min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }


    //优化版二叉树套路解题
    public static boolean isValidBST1(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }


    //中序遍历 升序即可
   static long pre = Long.MIN_VALUE;
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre=root.val;
        return isValidBST2(root.right);
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
