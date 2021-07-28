package com.lingjian.returnType;

import java.util.List;

/**
 * @description: 判断二叉树是否为平衡二叉树
 * @author: Ling Jian
 * @date: 2020-05-27 15:00
 **/
public class IsBalancedTree {
    public static void main(String[] args) {
        Node head = new Node(5);
//        head.left=new Node(3);
//        head.right = new Node(2);
        boolean res=process(head).isB;
        System.out.println(res);

    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType LInfo = process(head.left);
        ReturnType RInfo = process(head.right);
        if(!LInfo.isB||!RInfo.isB){
            return new ReturnType(false, 0);
        }
        int h1 = LInfo.h;
        int h2 = RInfo.h;
        if (Math.abs(h1 - h2) < 2) {
            return new ReturnType(true, Math.max(h1, h2) + 1);
        }else{
            return new ReturnType(false, 0);
        }
    }


    public static class ReturnType{
        public boolean isB;
        public int h;

        public ReturnType(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
