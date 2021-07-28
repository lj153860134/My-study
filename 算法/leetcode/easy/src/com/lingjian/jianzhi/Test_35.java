package com.lingjian.jianzhi;

import java.util.HashMap;

/**
 * @description: 复杂单链表的复制 结点出了next指针 还有一个random指针
 * @author: Ling Jian
 * @date: 2020-06-02 14:45
 **/
public class Test_35 {
    public static void main(String[] args) {
//        Node res = copyRandomList(head);

    }





    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
