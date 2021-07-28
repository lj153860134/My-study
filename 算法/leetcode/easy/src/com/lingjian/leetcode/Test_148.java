package com.lingjian.leetcode;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description: 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * @author: Ling Jian
 * @date: 2020-06-12 15:43
 **/
public class Test_148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        printList(head);
        ListNode res = sortList(head);
        printList(res);

    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode cur = head;
        while (cur != null) {
            queue.offer(cur);
            cur = cur.next;
        }

        cur = queue.peek();
        ListNode res = cur;
        while(!queue.isEmpty()){
            cur.next = queue.peek();
            cur = queue.poll();
        }
        cur.next = null;
        return res;
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
