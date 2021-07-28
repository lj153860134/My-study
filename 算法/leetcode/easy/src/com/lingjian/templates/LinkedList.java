package com.lingjian.templates;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-06-12 15:52
 **/
public class LinkedList {
    public static void main(String[] args) {

    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("The list is null");
            return;
        }
        System.out.print(head.val);
        ListNode cur = head.next;
        while (cur != null) {
            System.out.print("->" + cur.val);
            cur = cur.next;
        }
        System.out.println();
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
