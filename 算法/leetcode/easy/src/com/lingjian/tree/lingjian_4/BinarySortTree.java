package com.lingjian.tree.lingjian_4;

/**
 * @description: 创建二叉排序树（二叉搜索树 二叉查找树）
 * @author: Ling Jian
 * @date: 2020-03-10 10:05
 **/
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};
        Node head=createBST(arr);
        PreOrderTree(head);

    }


    //创建二叉搜索树
    public static Node createBST(int[] arr) {
        if (arr == null) {
            return null;
        }
        Node head = new Node(arr[0]);
        //创建头结点
        for (int i = 1; i < arr.length; i++) {
            addNode(head,new Node(arr[i]));
        }
        return head;
    }

    //递归添加结点
    public static void addNode(Node head, Node node) {
        if (node.value >= head.value) {
            if (head.right != null) {
                addNode(head.right, node);
            }else{
                head.right=node;
            }
        }
        if (node.value < head.value ) {
            if(head.left!=null){
               addNode(head.left,node);
            }else{
                head.left=node;
            }
        }
    }


    //递归前序遍历

    public static  void PreOrderTree(Node head){
        if (head == null) {
            return;
        }
        PreOrderTree(head.left);
        System.out.println(head.value);
        PreOrderTree(head.right);
    }
    //定义结点
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
