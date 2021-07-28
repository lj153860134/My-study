package com.lingjian.jianzhi;

/**
 * @description: 定义一个函数，输入一个链表的头节点，
 *               反转该链表并输出反转后链表的头节点。
 * @author: Ling Jian
 * @date: 2020-06-22 17:57
 **/
public class Test_24 {
    public static void main(String[] args) {

    }

    //递归版本
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;


    }

    //非递归版本
    public static ListNode reverseList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=null;
        ListNode next=null;
        ListNode cur=head;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
