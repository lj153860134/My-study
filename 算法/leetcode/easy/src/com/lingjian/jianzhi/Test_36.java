package com.lingjian.jianzhi;

/**
 * @description: 输入一棵二叉搜索树
 *              将该二叉搜索树转换成一个排序的循环双向链表
 *              要求不能创建任何新的节点，只能调整树中节点指针的指向
 * @author: Ling Jian
 * @date: 2020-06-28 17:36
 **/
public class Test_36 {
    public static void main(String[] args) {

    }

    static Node pre=null;
    static Node head=null;

    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        process(root);
        pre.right=head;
        head.left=pre;
        return head;

    }

    public static void process(Node cur){
        if(cur==null){
            return;
        }
        process(cur.left);
        if(pre!=null){
            pre.right=cur;
        }else{
            head=cur;
        }
        cur.left=pre;
        pre=cur;
        process(cur.right);

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
