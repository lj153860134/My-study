package com.lingjian.jianzhi;

import java.util.HashMap;

/**
 * @description: 输入某二叉树的前序遍历和中序遍历的结果
 * 请重建该二叉树
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * @author: Ling Jian
 * @date: 2020-07-10 17:31
 **/
public class Test_07 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode res = buildTree(preorder, inorder);


    }

    static int[] pre;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        pre=preorder;
        //HashMap存储中序遍历
        for (int i = 0; i <inorder.length ; i++) {
            map.put(inorder[i], i);
        }
        return process(0,0,inorder.length-1);

    }

    /**
     *
     * @param pre_root  当前根节点在先序遍历的索引
     * @param in_left   子树中序遍历左边界
     * @param in_right  子树中序遍历右边界
     * @return
     */
    public static TreeNode process(int pre_root, int in_left, int in_right) {
        if(in_left>in_right){
            return null;
        }
        //找到当前根节点在中序遍历的索引
        int index = map.get(pre[pre_root]);
        TreeNode root=new TreeNode(pre[pre_root]);
        root.left = process(pre_root+1, in_left, index- 1);
        root.right=process(pre_root+1+(index-1-in_left+1),index+1,in_right);
        return root;
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
