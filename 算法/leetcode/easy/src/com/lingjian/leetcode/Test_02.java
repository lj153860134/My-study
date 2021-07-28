package com.lingjian.leetcode;

import java.util.List;

/**
 * @description: 三位数链表逆序相加
 * @author: Ling Jian
 * @date: 2020-03-21 22:11
 **/
public class Test_02 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

//        ListNode node = solution2(l1, l2);
        printList(l1);
        printList(l2);
        printList(addTwoNumbers(l1, l2));



    }

    private static ListNode solution1(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int ge = (cur1.val + cur2.val) % 10;
        int shi = (cur1.val + cur2.val) / 10;
        ListNode headNode = new ListNode(ge);
        ListNode curNode = headNode;
        while (cur1.next != null && cur2.next != null) {
            ge = (cur1.next.val + cur2.next.val + shi) % 10;
            curNode.next = new ListNode(ge);
            shi = (cur1.next.val + cur2.next.val + shi) / 10;
            curNode = curNode.next;
            cur1 = cur1.next;
            cur2 = cur2.next;

        }
        if (cur1.next == null && cur2.next == null && (cur1.val + cur2.val + shi) >= 10) {
            curNode.next = new ListNode(1);
        } else if (cur1.next == null) {
                while (cur2.next != null) {
                    curNode.next = new ListNode(cur2.next.val);
                    cur2 = cur2.next;
                }

        }else{
                while (cur1.next != null) {
                    curNode.next = new ListNode(cur1.next.val);
                    cur1 = cur1.next;
                }
            }
        return headNode;
    }


    //官方思路 高位置0
    private static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head=new ListNode(0);
        ListNode cur=head;
        int shi=0;
        while(cur1!=null||cur2!=null){
            int x=cur1!=null?cur1.val:0;
            int y=cur2!=null?cur2.val:0;
            int sum=x+y+shi;
            cur.next = new ListNode(sum % 10);
            cur=cur.next;
            shi=sum/10;
            cur1=cur1!=null?cur1.next:cur1;
            cur2=cur2!=null?cur2.next:cur2;

        }
        if(shi>0){
            cur.next=new ListNode(shi);
        }
        return head.next;
    }


    //练习
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode dummy=new ListNode(0);
        ListNode p = dummy;
        int num=0;
        while(head1!=null||head2!=null){
            int a = head1 != null ? head1.val : 0;
            int b = head2 != null ? head2.val : 0;
            int sum = a + b + num;
            p.next = new ListNode(sum % 10);
            num = sum / 10;
            head1 = head1 != null ? head1.next : head1;
            head2 = head2 != null ? head2.next : head2;
            p = p.next;
        }
        if(num==1){
            p.next = new ListNode(1);
        }
        return dummy.next;
    }

    //打印
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


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
