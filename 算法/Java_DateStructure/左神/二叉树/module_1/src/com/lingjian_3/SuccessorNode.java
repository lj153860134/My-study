package com.lingjian_3;


import com.lingjian_1.PreInPosTraversal;

/**
 * @description: 二叉树找后继结点
 * 后继结点：中序遍历中 后一个结点是前一个结点的后继结点
 * @author: Ling Jian
 * @date: 2019-12-19 21:08
 **/
public class SuccessorNode {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.parent = null;

        head.left = new Node(3);
        head.left.parent = head;

        head.right = new Node(8);
        head.right.parent = head;

        head.left.left = new Node(2);
        head.left.left.parent = head.left;

        head.left.right = new Node(4);
        head.left.right.parent = head.left;

        head.left.left.left = new Node(1);
        head.left.left.left.parent = head.left.left;

        head.right.left = new Node(7);
        head.right.left.parent = head.right;

        head.right.left.left = new Node(6);
        head.right.left.left.parent = head.right.left;

        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        head.right.right.left = new Node(9);
        head.right.right.left.parent = head.right.right;

        head.right.right.right = new Node(11);
        head.right.right.right.parent = head.right.right;

        Node node = head.left.left.left;
        while (node != null) {
            System.out.println(node.value);
            node = getSuccessorNode(node);
        }


    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }

//        if (node == null) {
//            return node;
//        }
//        if (node.right != null) {
//            return getLeftMost(node.right);
//        } else {
//            Node parent = node.parent;
//            while (parent != null && parent.left != node) {
//                node = parent;
//                parent = node.parent;
//            }
//            return parent;
//        }
        if (node.right == null) {
            Node temp = node;
            Node tempParent = node.parent;
            //注意while里面两个判断也有先后顺序才行 如果后面在前面会报错
            //所以要先保证tempParent不为空 才能判断下一个条件
            while (tempParent != null&& temp != tempParent.left) {
                temp = tempParent;
                tempParent = tempParent.parent;
            }
            return tempParent;

        } else {
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
    }


    //定义结点
    public static class Node {
        public int value;
        public Node parent;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}


