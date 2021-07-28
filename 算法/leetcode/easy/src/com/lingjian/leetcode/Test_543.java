package com.lingjian.leetcode;

/**
 * @description: 给定一棵二叉树
 * 你需要计算它的直径长度
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值
 * 这条路径可能穿过也可能不穿过根结点
 * @author: Ling Jian
 * @date: 2020-08-04 23:08
 **/
public class Test_543 {
    public static void main(String[] args) {

    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return max;
        }
        process(root);
        return max - 1;
    }

    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = process(root.left);
        int R = process(root.right);
        max = Math.max(max, L + R + 1);
        return Math.max(L, R) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
