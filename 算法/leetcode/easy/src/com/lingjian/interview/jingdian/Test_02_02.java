package com.lingjian.interview.jingdian;

/**
 * @description: 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * @author: Ling Jian
 * @date: 2020-06-05 20:30
 **/
public class Test_02_02 {
    public static void main(String[] args) {


    }

    public static int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int aim = size - k + 1;
        cur = head;
        while (--aim > 0) {
            cur = cur.next;
        }
        return cur.val;
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
