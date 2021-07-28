package com.lingjian.sort;

import com.sun.javafx.tk.DummyToolkit;

/**
 * @description:  基于单链表的归并排序
 * @author: Ling Jian
 * @date: 2020-09-14 09:11
 **/
public class MergeSortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        printList(head);
       printList( mergeSort(head));


    }

    public static ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode first = mergeSort(head);
        ListNode second = mergeSort(temp);
        return merge(first, second);
    }


    public static ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode first,ListNode second){
        if(first==second){
            return first;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(first!=null&&second!=null){
            if(first.value<=second.value){
                p.next = first;
                first = first.next;
            }else{
                p.next = second;
                second = second.next;
            }
            p = p.next;
        }
        p.next = first != null ? first : second;

        return dummy.next;
    }

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

    }


    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("The list is null");
            return;
        }
        System.out.print(head.value);
        ListNode cur = head.next;
        while (cur != null) {
            System.out.print("->" + cur.value);
            cur = cur.next;
        }
        System.out.println();
    }
}
