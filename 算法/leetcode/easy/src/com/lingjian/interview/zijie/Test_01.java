package com.lingjian.interview.zijie;

/**
 * @description: 一个链表 奇数位升序 偶数位降序 让链表变成升序
 * @author: Ling Jian
 * @date: 2020-07-20 15:23
 **/
public class Test_01 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
//        head.next.next.next.next.next.next = new ListNode(7);
        printList(head);
//        ListNode res = solution(head);
//        printList(res);
        solution(head);


    }

    //简易方法
    public static void solution(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        ListNode newHead = null;
        ListNode next = null;
        while (temp != null && temp.next != null) {
            next = temp.next.next;
            temp.next.next = newHead;
            newHead = temp.next;
            temp.next = next;
            temp = next;
        }
        printList(head);
        printList(newHead);
        printList(merge(head, newHead));

    }

    public static ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode temp=dummy;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                temp.next=head1;
                head1=head1.next;
            }else{
                temp.next=head2;
                head2 = head2.next;
            }
            temp = temp.next;
            temp.next = head1 != null ? head1 : head2;
        }
        return dummy.next;
    }
    //繁琐
    public static void solution1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        ListNode next1 = null;
        ListNode next2 = null;
        ListNode newHead = null;
        while (temp2 != null && temp2.next != null) {
            next1 = temp1.next.next;
            next2 = temp2.next.next;
            temp2.next = newHead;
            newHead = temp2;
            temp1.next = next1;
            temp1 = next1;
            temp2 = next2;
        }
        if(temp1.next!=null){
            temp1.next=null;
            temp2.next = newHead;
            newHead = temp2;
        }
        printList(head);
        printList(newHead);
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
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
}
