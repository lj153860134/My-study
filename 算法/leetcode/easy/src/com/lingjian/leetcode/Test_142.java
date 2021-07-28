package com.lingjian.leetcode;

/**
 * @description: 给定一个链表
 *               返回链表开始入环的第一个节点
 *               如果链表无环，则返回 null
 * @author: Ling Jian
 * @date: 2020-08-04 21:37
 **/
public class Test_142 {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        //注意判断条件
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
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
