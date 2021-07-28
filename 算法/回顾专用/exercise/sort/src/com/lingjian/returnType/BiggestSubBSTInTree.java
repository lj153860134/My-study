package com.lingjian.returnType;

import java.util.List;

/**
 * @description: 给定头结点 返回最大搜索二叉子树的大小
 * @author: Ling Jian
 * @date: 2020-05-27 14:07
 **/
public class BiggestSubBSTInTree {
    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(1);
        head.left.left = new Node(0);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.left.left = new Node(4);
        head.right.left.left.left = new Node(2);
        head.right.left.left.right = new Node(5);
        head.right.left.right = new Node(14);
        head.right.left.right.left = new Node(11);
        head.right.left.right.right = new Node(15);
        head.right.right = new Node(13);
        head.right.right.left = new Node(20);
        head.right.right.right = new Node(16);

        int res = process(head).size;
        System.out.println(res);

    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ReturnType RInfo = process(head.right);
        ReturnType LInfo = process(head.left);
        int maxSize = 0;
        int includeItself = 0;
        if (RInfo.head == head.right && LInfo.head == head.left
                && RInfo.min > head.value && LInfo.max < head.value) {
            includeItself = RInfo.size + 1 + LInfo.size;
        }
        int p1 = LInfo.size;
        int p2 = RInfo.size;
        maxSize = Math.max(Math.max(p1, p2), includeItself);
        Node maxHead = p1 > p2 ? LInfo.head : RInfo.head;
        if (maxSize == includeItself) {
            maxHead = head;
        }
        return new ReturnType(maxSize, maxHead,
                Math.max(Math.max(RInfo.max, LInfo.max), head.value),
                Math.min(Math.min(RInfo.min, LInfo.min), head.value));
    }


    public static class ReturnType {
        private int size;
        private Node head;
        private int max;
        private int min;

        public ReturnType(int size, Node head, int max, int min) {
            this.size = size;
            this.head = head;
            this.max = max;
            this.min = min;
        }


    }


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}

