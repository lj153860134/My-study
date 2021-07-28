package com.lingjian_1;

import java.util.Stack;

/**
 * @description: 前中后序遍历二叉树 递归和非递归
 * @author: Ling Jian
 * @date: 2019-12-19 15:52
 **/
public class PreInPosTraversal {
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
        System.out.print("递归前序遍历: ");
        preOrderRecur(head);
        System.out.println("");

        System.out.print("非递归前序遍历: ");
        preOrderUnRecur(head);
        System.out.println("");

        System.out.print("前序遍历序列化");
        System.out.println(serialByPre(head));

        System.out.print("递归中序遍历: ");
        inOrderRecur(head);
        System.out.println("");

        System.out.print("非递归中序遍历: ");
        inOrderUnRecur(head);
        System.out.println("");

        System.out.print("中序遍历序列化");
        System.out.println(serialByIn(head));

        System.out.print("递归后序遍历: ");
        posOrderRecur(head);
        System.out.println("");

        System.out.print("非递归后序遍历: ");
        posOrderUnRecur(head);
        System.out.println("");

        System.out.print("后序遍历序列化");
        System.out.println(serialByPos(head));

        System.out.print("前序查找结果: ");
        System.out.println(findByPre(head, 5));

        System.out.print("中序查找结果: ");
        System.out.println(findByIn(head, 8));

        System.out.print("后序查找结果: ");
        System.out.println(findByPos(head, 11));

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

    //递归前序遍历
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //非递归前序遍历
    public static void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    //前序遍历序列化
    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    //前序遍历查找
    public static Node findByPre(Node head, int value) {
        Node temp = null;
        if (head.value == value) {
            return head;
        }
        if (head.left != null) {
            temp = findByPre(head.left, value);
        }

        if (temp != null) {
            return temp;
        }
        if (head.right != null) {
            temp = findByPre(head.right, value);
        }
        return temp;

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

    //非递归中序遍历
    public static void inOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }

    //中遍历序列化
    public static String serialByIn(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = serialByIn(head.left);
        res += head.value + "_";
        res += serialByIn(head.right);
        return res;
    }

    //中序遍历查找
    public static Node findByIn(Node head, int value) {
        Node temp = null;

        if (head.left != null) {
            temp = findByIn(head.left, value);
        }

        if (temp != null) {
            return temp;
        }

        if (head.value == value) {
            return head;
        }
        if (head.right != null) {
            temp = findByIn(head.right, value);
        }
        return temp;
    }


    //递归后序遍历
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    //非递归后序遍历
    public static void posOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    //后遍历序列化
    public static String serialByPos(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = serialByPos(head.left);
        res += serialByPos(head.right);
        res += head.value + "_";
        return res;
    }

    //后序遍历查找
    public static Node findByPos(Node head, int value) {
        Node temp = null;

        if (head.left != null) {
            temp = findByPos(head.left, value);
        }

        if (temp != null) {
            return temp;
        }

        if (head.right != null) {
            temp = findByPos(head.right, value);
        }
        if (head.value == value) {
            return head;
        }
        return temp;
    }
}


