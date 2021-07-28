package com.lingjian.jianzhi;

/**
 * @description: 输入两个递增排序的链表
 *               合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @author: Ling Jian
 * @date: 2020-06-23 16:36
 **/
public class Test_25 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);

        printList(l1);
        printList(l2);
        printList(mergeTwoLists1(l1,l2));



    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode dummy =new ListNode(-1);
        ListNode p= dummy;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                p.next=new ListNode(temp1.val);
                temp1=temp1.next;
            }else{
                p.next=new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            p = p.next;

        }
        p.next = temp1 != null ? temp1 : temp2;

        return dummy.next;

    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                p.next=l1;
                l1 = l1.next;

            }else{
                p.next=l2;
                l2 = l2.next;

            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    //递归版本
    public static ListNode merge(ListNode head1,ListNode head2){
        if(head1==null||head2==null){
            return head1 != null ? head1 : head2;
        }
        if(head1.val<head2.val){
            head1.next = merge(head1.next, head2);
            return head1;
        }else{
            head2.next = merge(head1, head2.next);
            return head2;
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


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
