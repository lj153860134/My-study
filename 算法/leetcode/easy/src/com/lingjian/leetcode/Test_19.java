package com.lingjian.leetcode;

/**
 * @description: 给定一个链表
 * 删除链表的倒数第 n 个节点
 * 并且返回链表的头结点
 * @author: Ling Jian
 * @date: 2020-08-09 18:03
 **/
public class Test_19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
         head.next = new ListNode(2);
         head.next.next = new ListNode(3);
         head.next.next.next = new ListNode(4);
         head.next.next.next.next = new ListNode(5);
        printList(head);
        printList(removeNthFromEnd1(head, 5));
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode f=head;
            ListNode s=head;
            while(n>0){
                f=f.next;
                n--;
            }
            while(f!=null&&f.next!=null){
                f=f.next;
                s=s.next;
            }
            if(f==null){
                return head.next;
            }else {
                s.next = s.next.next;
                return head;
            }
        }

    public static ListNode removeNthFromEnd1(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode f=dummy;
        ListNode s=dummy;
        while(n>0){
            f=f.next;
            n--;
        }
        while(f.next!=null){
            f=f.next;
            s=s.next;
        }
        s.next = s.next.next;
        return dummy.next;
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
        }
    }
}
