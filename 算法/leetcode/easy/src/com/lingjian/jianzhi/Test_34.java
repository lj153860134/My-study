package com.lingjian.jianzhi;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 输入一棵二叉树和一个整数
 *               打印出二叉树中节点值的和为输入整数的所有路径
 *               从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
 * @author: Ling Jian
 * @date: 2020-06-28 16:55
 **/
public class Test_34 {
    public static void main(String[] args) {

    }

    static List<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> list = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        process(root, sum);
        return res;

    }

    private static void process(TreeNode root, int sum) {
        if(root==null){
            return;
        }
        list.add(root.val);
        sum-=root.val;
        if(sum==0&&root.left==null&&root.right==null){
            res.add(new LinkedList<>(list));
        }
        process(root.left, sum);
        process(root.right, sum);
        list.pollLast();


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
