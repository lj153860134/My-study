package com.lingjian.tree.lingjian_1;


/**
 * @description: 递归删除结点
 *                  若是叶子结点 删除该结点
 *                  若是非叶子结点 删除该子树
 * @author: Ling Jian
 * @date: 2020-03-07 10:37
 **/
public class DeleteNodeTree {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        delNode(head, 4);


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

    //先判断当前头结点是否为删除结点 在进入删除结点的递归操作中
    public static void delNode(Node head, int value) {
        //先判断该头结点是否为删除结点
        if (head != null) {
            if(head.value==value){
               head=null;
            }else{
                deleteNode(head,value);
            }
        }else {
            System.out.println("空树 无法输出结点");
        }

    }

    public static void deleteNode(Node head, int value) {
        if(head.left!=null&&head.left.value==value){
            head.left=null;
            return;
        }
        if(head.right!=null&&head.right.value==value){
            head.right=null;
            return;
        }
        if(head.left!=null){
            deleteNode(head.left, value);
        }

        if(head.right!=null){
            deleteNode(head.right,value);
        }
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

    //递归前序遍历
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void test(int[] arr){
        arr[0]=3;
    }
}
