package com.lingjian.tree;

import java.util.Stack;

/**
 * @description: 树的遍历（前序 中序 后序 Morris） 递归 非递归
 * @author: Ling Jian
 * @date: 2020-05-09 17:09
 **/
public class Traversal {


    //前序遍历（递归）
    public void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //前序遍历（非递归）
    public void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head=stack.pop();
            System.out.println(head.value);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    //中序遍历（递归）
    public void InOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        InOrderRecur(head.left);
        System.out.println(head.value);
        InOrderRecur(head.right);
    }


    //中序遍历（非递归）
    public void InOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty()||head!=null) {
            if (head != null) {
                stack.push(head);
                head=head.left;
            }else{
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }

        }
    }


    //后序遍历（递归）
    public void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value);
    }

    //后序遍历（非递归）
    public void posOrderUnRecur(Node head) {
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
            System.out.println(stack2.pop().value);
        }
    }


}

//定义结点
 class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}
