package com.lingjian.leetcode;

/**
 * @description: 给定一个二叉树
 * 它的每个结点都存放着一个整数值
 * 找出路径和等于给定数值的路径总数
 * 路径不需要从根节点开始
 * 也不需要在叶子节点结束
 * 但是路径方向必须是向下的
 * （只能从父节点到子节点）。
 * @author: Ling Jian
 * @date: 2020-07-07 15:05
 **/
public class Test_437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        int res = pathSum(root, 3);
        System.out.println(res);

    }

    public static int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        return process(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int process(TreeNode root,int sum){
        if(root==null){
            return 0 ;
        }
        int temp=0;
        if(sum==root.val){
            temp++;
        }
        return temp + process(root.left, sum - root.val) +
                process(root.right, sum - root.val);
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
