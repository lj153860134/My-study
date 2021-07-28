package com.lingjian.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 给定一个二叉树，找出其最大深度
 * @author: Ling Jian
 * @date: 2020-06-18 15:51
 **/
public class Test_104 {
    public static void main(String[] args) {

    }

    //DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = maxDepth(root.left);
        int R = maxDepth(root.right);
        return L >= R ? L + 1 : R + 1;
    }

    //BFS
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res=0;
        while(!queue.isEmpty()){
            for (int i = queue.size(); i>0 ; i--) {
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);

                }
            }
            res++;

        }
        return res;
    }


        static class TreeNode {
            public int value;
            public TreeNode left;
            public TreeNode right;

            public TreeNode(int data) {
                this.value = data;
            }
        }
    }
