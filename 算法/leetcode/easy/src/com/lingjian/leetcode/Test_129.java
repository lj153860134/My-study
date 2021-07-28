package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。  例如，从根到叶子节点路径 1->2->3 代表数字 123。  计算从根到叶子节点生成的所有数字之和。
 * @author: Ling Jian
 * @date: 2020-09-03 17:19
 **/
public class Test_129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }

    static List<String> res = new ArrayList<>();
    public static int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        int ans=0;
        for (String re : res) {
            ans += Integer.parseInt(re);
        }
        return ans;
    }

    public static void dfs(TreeNode root,StringBuilder sb){
        if(root.right==null&&root.left==null){
            sb.append(root.val);
            res.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(root.val);
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }


    static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
