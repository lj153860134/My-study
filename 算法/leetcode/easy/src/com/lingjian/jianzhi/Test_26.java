package com.lingjian.jianzhi;

/**
 * @description: 输入两棵二叉树A和B
 *               判断B是不是A的子结构
 *               (约定空树不是任意一个树的子结构)
 *               B是A的子结构，即 A中有出现和B相同的结构和节点值
 * @author: Ling Jian
 * @date: 2020-06-23 16:54
 **/
public class Test_26 {

    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A,TreeNode B){
        if(A==null||B==null){
            return false;
        }
        return process(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    public boolean process(TreeNode A,TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null||A.val!=B.val){
            return false;
        }
        return process(A.left,B.left)&&process(A.right,B.right);
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
