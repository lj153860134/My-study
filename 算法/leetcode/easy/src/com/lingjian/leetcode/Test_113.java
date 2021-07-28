package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一个二叉树和一个目标和
 * 找到所有从根节点到叶子节点路径总和等于给定目标和的路径
 * @author: Ling Jian
 * @date: 2020-07-07 14:49
 **/
public class Test_113 {

    public static void main(String[] args) {

    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return res;
        }
        process(root, sum);
        return res;

    }

    public static void process(TreeNode root, int sum){
        if(root==null){
            return;
        }

        list.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum-root.val==0){
                res.add(new ArrayList<>(list));
            }
        }

        process(root.left,sum-root.val);
        process(root.right,sum-root.val);
        list.pollLast();
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
