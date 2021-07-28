package com.lingjian.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 请实现一个函数按照之字形顺序打印二叉树
 * 即第一行按照从左到右的顺序打印
 * 第二层按照从右到左的顺序打印
 * 第三行再按照从左到右的顺序打印
 * 其他行以此类推
 * @author: Ling Jian
 * @date: 2020-06-27 17:33
 **/
public class Test_32_3 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode temp=queue.poll();
                if(flag){
                    list.add(temp.val);
                }else{
                    list.addFirst(temp.val);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);

                }
            }
            flag=!flag;
            res.add(list);
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
