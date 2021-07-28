package com.lingjian_1;

/**
 * @description: 线索化二叉树
 * @author: Ling Jian
 * @date: 2020-03-08 10:39
 **/
public class ThreadedBinaryTree {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.parent = null;

        head.left = new Node(2);
        head.left.parent = head;

        head.right = new Node(3);
        head.right.parent = head;

        head.left.left = new Node(4);
        head.left.left.parent = head.left;

        head.left.right = new Node(5);
        head.left.right.parent = head.left;


        head.right.left = new Node(6);
        head.right.left.parent = head.right;
        System.out.println("中序遍历为");
        inOrderRecur(head);

    }


    //定义结点
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    //中序线索二叉树
    public static void threadedNodes(Node head){
        //辅助结点 指向node的前一个结点
        if(head==null){
            return;
        }
        //线索化左子树
        threadedNodes(head.left);

        //线索化右子树
        threadedNodes(head.right);



    }

    //递归中序遍历
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }
}
