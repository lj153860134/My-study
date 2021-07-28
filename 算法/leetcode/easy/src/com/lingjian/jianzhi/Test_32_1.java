package com.lingjian.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 从上到下打印出二叉树的每个节点
 *               同一层的节点按照从左到右的顺序打印
 * @author: Ling Jian
 * @date: 2020-06-27 17:00
 **/
public class Test_32_1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right=new TreeNode(7);
        int[] res = levelOrder(root);
        System.out.println(Arrays.toString(res));

    }
    //BFS（广度优先遍历）利用队列
    public static int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }

        }
        int[] res = new int[list.size()];
        int index=0;
        for (Integer integer : list) {
            res[index++] = integer;
        }
        return res;
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
