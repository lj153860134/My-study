package com.lingjian.leetcode;

import com.sun.jmx.snmp.SnmpAckPdu;

import java.util.*;

/**
 * @description: 给定一个二叉搜索树，编写一个函数 kthSmallest
 * 来查找其中第 k 个最小的元素
 * @author: Ling Jian
 * @date: 2020-06-16 16:54
 **/
public class Test_230 {
    public static void main(String[] args) {

    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        insertHeap(root, list);
        return list.get(k - 1);

    }

    private static void insertHeap(TreeNode root,List<Integer> list) {
        if(root==null){
            return;
        }
        insertHeap(root.left,list);
        list.add(root.val);
        insertHeap(root.right,list);
    }

    //中序遍历  提前剪枝
    static int res;
    static int count;
    public static int kthSmallest1(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    public static void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        if(count==0) return;
        if(--count==0) res = root.val;
        dfs(root.right);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
