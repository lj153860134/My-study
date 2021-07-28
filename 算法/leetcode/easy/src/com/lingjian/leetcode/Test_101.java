package com.lingjian.leetcode;

import com.lingjian.templates.Tree;

import java.util.HashSet;

/**
 * @description: 给定二叉树 检查它是否是镜像对称的
 * @author: Ling Jian
 * @date: 2020-06-19 17:17
 **/
public class Test_101 {
    public static void main(String[] args) {




    }
   

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);


    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
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
