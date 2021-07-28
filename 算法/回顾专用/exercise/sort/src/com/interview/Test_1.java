package com.interview;

/**
 * @description: 给定一个数 给定某两个节点a b 在O(1)空间复杂度下找两个节点的最近公共节点
 * @author: Ling Jian
 * @date: 2020-06-02 14:02
 **/
public class Test_1 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node2.parent = node3;
        node4.parent = node3;

        node1.parent = node2;
        node5.parent = node2;


        node6.parent = node4;
        node7.parent = node4;

        Node res = findCommonNode(node1, node3);
        System.out.println(res.value);

    }

    public static Node findCommonNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        Node cur1 = node1;
        int p1 = 0;
        Node cur2 = node2;
        int p2 = 0;
        while(cur1!=null){
            p1++;
            cur1 = cur1.parent;
        }

        while(cur2!=null){
            p2++;
            cur2 = cur2.parent;
        }
        int num = Math.abs(p1 - p2);
        System.out.println(num);

        cur1 = node1;
        cur2 = node2;
        if (p1 > p2) {
            while (num-- > 0) {
                cur1 = cur1.parent;
            }
        }else{
            while (num-- > 0) {
                cur2 = cur2.parent;
            }
        }

        while (cur1.value != cur2.value) {
            cur1 = cur1.parent;
            cur2 = cur2.parent;
        }

        return cur1;

    }


    static class Node {
        public int value;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }
}
