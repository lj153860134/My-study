package com.lingjian.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 给定一个二叉树，找出其最小深度
 *               最小深度是从根节点到最近叶子节点的最短路径上的节点数量
 *               说明: 叶子节点是指没有子节点的节点。
 * @author: Ling Jian
 * @date: 2020-08-21 15:49
 **/
public class Test_111 {
    public static void main(String[] args) {

    }


    //二叉树套路解题
    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }

    //用BFS解题
    public static int minDepth1(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        // root 本身就是一层，depth 初始化为 1
        queue.add(root);
        int depth=1;
        while(!queue.isEmpty()){
            int num=queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode temp = queue.poll();
                if(temp.left==null&&temp.right==null){
                    return depth;
                }
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);

            }
            depth++;

        }
        return depth;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
