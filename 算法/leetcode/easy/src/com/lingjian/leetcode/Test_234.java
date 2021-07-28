package com.lingjian.leetcode;

/**
 * @description: 请判断一个链表是否为回文链表。
 * @author: Ling Jian
 * @date: 2020-07-31 09:39
 **/
public class Test_234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }


        ListNode s = head;
        ListNode f = head;
        ListNode mid = null;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        if (f == null) {
            mid = s;
        } else {
            mid = s.next;
        }
        mid = reverse(mid);
        s = head;
        while (s.val != mid.val) {
            return false;
        }
        return true;
    }

    //将这个链表放入栈中 然后与链表依次遍历即可

    //递归逆序
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //迭代递归
    public static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre=null;
        ListNode next=null;
        ListNode cur=head;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=cur.next;
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
