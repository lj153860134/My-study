package com.lingjian_4;


import javax.sql.rowset.RowSetMetaDataImpl;

/**
 * @description: 判断二叉树是否为平衡二叉树
 * @author: Ling Jian
 * @date: 2019-12-21 20:45
 **/
public class IsBalancedTree {
    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.left = new Node(3);
        head1.left.left = new Node(2);

        Node head2 = new Node(5);
        head2.left = new Node(3);
        head2.right = new Node(8);
        head2.left.left = new Node(2);
        head2.left.right = new Node(4);
        head2.left.left.left = new Node(1);
        head2.right.left = new Node(7);
        head2.right.left.left = new Node(6);
        head2.right.right = new Node(10);
        head2.right.right.left = new Node(9);
        head2.right.right.right = new Node(11);

        System.out.println(isBalanced(head1));
        System.out.println(isBalanced(head2));

    }

    //是否为平衡二叉树
    public static boolean isBalanced(Node node){
        return process(node).isB;
    }

    //套路递归解题
    public static returnData process(Node node) {
        if (node == null) {
            return new returnData(true, 0);
        }
        returnData rdLeft = process(node.left);
        if (!rdLeft.isB)
            return new returnData(false, 0);
        returnData rdRight = process(node.right);
        if (!rdRight.isB)
            return new returnData(false, 0);
        if (Math.abs(rdLeft.height - rdRight.height) > 1)
            return new returnData(false, 0);
        return new returnData(true, Math.max(rdLeft.height, rdRight.height) + 1);
    }

    //定返回值的类（返回是否为平衡数和高度）
    public static class returnData {
        public boolean isB;
        public int height;

        public returnData(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
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
