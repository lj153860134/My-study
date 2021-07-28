package com.lingjian.jianzhi;

/**
 * @description: 输入一棵二叉树的根节点
 *               判断该树是不是平衡二叉树
 *               如果某二叉树中任意节点的左右子树的深度相差不超过1
 *               那么它就是一棵平衡二叉树
 * @author: Ling Jian
 * @date: 2020-07-03 19:09
 **/
public class Test_55_2 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return process(root).isB;
    }

    public static ReturnType process(TreeNode root){
        if(root==null){
            return new ReturnType(true, 0);
        }
        ReturnType LInfo = process(root.left);
        if(!LInfo.isB){
            return new ReturnType(true, 0);
        }
        ReturnType RInfo = process(root.right);
        if(!RInfo.isB){
            return new ReturnType(true, 0);
        }
        if(Math.abs(LInfo.dep-RInfo.dep)>1){
            return new ReturnType(true, 0);
        }else{
            int dep=Math.max(LInfo.dep,RInfo.dep);
            return new ReturnType(true, dep + 1);
        }
    }

    static class ReturnType{
        public boolean isB;
        public int dep;

        public ReturnType(boolean isB, int dep) {
            this.isB = isB;
            this.dep = dep;
        }
    }


    //简练版
    public static boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }

    private static int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
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

