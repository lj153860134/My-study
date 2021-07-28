package com.lingjian.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @author: Ling Jian
 * @date: 2020-07-08 16:45
 **/
public class Test_54 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int res = kthLargest1(root,3);
        System.out.println(res);
    }
    static List<Integer> list=new ArrayList<>();
    public static int kthLargest(TreeNode root, int k) {
        inOrderTree(root);
        return list.get(k-1);
    }
    public static void inOrderTree(TreeNode root){
        if(root==null){
            return;
        }
        inOrderTree(root.right);
        list.add(root.val);
        inOrderTree(root.left);
    }


    static int res, count;
    public static int kthLargest1(TreeNode root, int k) {
        count=k;
        dfs(root);
        return res;
    }
    static void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(count == 0) return;
        if(--count == 0) res = root.val;
        dfs(root.left);
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
