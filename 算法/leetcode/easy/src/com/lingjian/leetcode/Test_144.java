package com.lingjian.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 给定一个二叉树，返回它的前序遍历
 * @author: Ling Jian
 * @date: 2020-08-05 21:01
 **/
public class Test_144 {
    public static void main(String[] args) {

    }


    //非递归
    List<Integer> list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return list;
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            list.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return list;
    }
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
