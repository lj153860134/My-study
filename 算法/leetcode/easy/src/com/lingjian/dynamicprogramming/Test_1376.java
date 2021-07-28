package com.lingjian.dynamicprogramming;

import javax.swing.tree.TreeNode;
import java.util.List;

/**
 * @description: 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表
 * 如果在二叉树中，存在一条一直向下的路径，
 * 且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，返回 True 否则返回 False  。
 * @author: Ling Jian
 * @date: 2020-06-11 17:09
 **/
public class Test_1376 {
    public static void main(String[] args) {
        //链表
        ListNode head = new ListNode(1);
        head.next=new ListNode(10);
//        head.next.next = new ListNode(8);

        //树
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left=new TreeNode(10);
        root.right.left.left=new TreeNode(9);
        root.right.right=new TreeNode(1);


        boolean res = isSubPath(head,root);
        System.out.println(res);
    }

    //二叉树 套路解题
    public static boolean process(ListNode head,TreeNode root,ListNode realHead) {
        if (root == null) {
            return false;
        }
        if (head.next== null) {
            if (head.val == root.val) {
                return true;
            } else {
                return false;
            }
        }
        if (head.val != root.val) {
            if (head == realHead) {
                return process(head, root.left, head) || process(head, root.right, head);
            } else {
                return false;
            }
        } else {
            boolean LFlag = process(head.next, root.left, realHead);
            boolean RFlag = process(head.next, root.right, realHead);
            if (LFlag || RFlag) {
                return true;
            } else {
                return false;
            }
        }
    }
    public static boolean isSubPath(ListNode head, TreeNode root) {
        if(head.next==null){
            return findNode(head,root);
        }
            return process(head, root, head);
    }
    public static boolean findNode(ListNode head, TreeNode root){
        if(root==null){
            return false;
        }
        if(head.val==root.val) {
            return true;
        }
        return findNode(head, root.right) || findNode(head, root.left);
    }




    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
