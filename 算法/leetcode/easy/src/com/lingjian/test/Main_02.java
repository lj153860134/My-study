package com.lingjian.test;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-17 20:23
 **/
public class Main_02 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        while(n>0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode temp=slow.next;
        slow.next=slow.next.next;
        temp.next=null;

        return head;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }


}


