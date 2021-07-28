package com.lingjian.leetcode;

import com.lingjian.templates.Tree;

/**
 * @description: 将一个按照升序排列的有序数组
 *               转换为一棵高度平衡二叉搜索树。
 * @author: Ling Jian
 * @date: 2020-07-03 15:01
 **/
public class Test_108 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0,5, 9};
        TreeNode root = sortedArrayToBST(nums);
        TreeNode root1 = sortedArrayToBST1(nums);
        InOrderTree(root);
        System.out.println("+++++++++");
        InOrderTree(root1);


    }


    //有序数组利用二分法 平衡二叉搜索树
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);
        }

       return process(nums,0,nums.length-1);
    }

    public static TreeNode process(int[] nums,int left,int right){
        if(left>right){
            return null;
        }

        int mid=left+((right-left)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums, left, mid-1);
        root.right = process(nums, mid+1, right);
        return root;

    }

    //无序数组直接递归插入 仅仅是二叉搜索树

    public static TreeNode sortedArrayToBST1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root=new TreeNode(nums[0]);
        for (int i = 1; i <nums.length ; i++) {
            addNode(root,new TreeNode(nums[i]));
        }
        return root;


    }

    public static void  addNode(TreeNode root,TreeNode node){
        if(node.val>root.val){
            if(root.right!=null){
                addNode(root.right,node);
            }
            else{
                root.right=node;
            }
        }

        if(node.val<root.val){
            if(root.left!=null){
                addNode(root.left, node);
            }else{
                root.left = node;
            }
        }
    }

    public static  void InOrderTree(TreeNode head){
        if (head == null) {
            return;
        }
        InOrderTree(head.left);
        System.out.println(head.val);
        InOrderTree(head.right);
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
