package com.lingjian_5;


/**
 * @description: 求完全二叉树的结点个数
 * @author: Ling Jian
 * @date: 2019-12-21 22:52
 **/
public class CompleteTreeNodeNumber {
    public static void main(String[] args) {
        Node head = new Node(5);

        head.left = new Node(3);
        head.right = new Node(8);
//        head.left.left = new Node(2);
//        head.left.right = new Node(4);
//        head.left.left.left = new Node(1);
//        head.right.left = new Node(7);
//        head.right.left.left = new Node(6);
//        head.right.right = new Node(10);
//        head.right.right.left = new Node(9);
//        head.right.right.right = new Node(11);

        int level=getLevel(head);
        System.out.println(level);
//        System.out.println(mostLeftLevel(head,1));
//        System.out.println(nodeNum(head));
        System.out.println(getNodeNumber(head,level));

    }

    public static int getNodeNumber(Node head,int level){
        if(level==1){
            return 1;
        }
        int rightLevel=getLevel(head.right);
        if(level==rightLevel+1){
            return (1<<(level-1))+getNodeNumber(head.right,rightLevel);
        }else{
            return (1<<rightLevel)+getNodeNumber(head.left,level-1);
        }
    }

    public static int getLevel(Node node){
        int res=0;
//        if(node==null){
//            return res;
//        }
        while(node!=null){
            res++;
            node=node.left;
        }
        return res;


    }

    //左神

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public static int bs(Node node, int l, int h) {
        if (l == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, l + 1) == h) {
            return (1 << (h - l)) + bs(node.right, l + 1, h);
        } else {
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }

    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
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
