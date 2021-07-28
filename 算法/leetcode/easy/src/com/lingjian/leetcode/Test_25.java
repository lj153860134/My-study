package com.lingjian.leetcode;

import com.sun.tools.internal.ws.processor.model.HeaderFault;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表
 * k是一个正整数，它的值小于或等于链表的长度
 * 如果节点总数不是 k 的整数倍，
 * 那么请将最后剩余的节点保持原有顺序
 * @author: Ling Jian
 * @date: 2020-06-05 20:44
 **/
public class Test_25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next .next= new ListNode(6);
//        head.next.next.next.next .next.next= new ListNode(7);
        int k = 3;
        printList(head);
//        printList(reverse(head));
        ListNode res = reverseKGroup5(head, k);
        printList(res);
    }

    //我的迭代1（计算长度）
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode cur = head;
        int size = 0;
        ListNode next = null;
        ListNode tail = null;
        ListNode res = null;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        int num1 = size / k;
        for (int i = 1; i <= num1; i++) {
            cur = head;
            for (int j = 0; j <k-1 ; j++) {
                cur=cur.next;
            }
            if (i != 1) {
                tail.next = cur;
            }
            next = cur.next;
            cur.next = null;
            reverse(head);
            tail = head;
            if (i == 1) {
                res = cur;
            }
            head = next;

        }
        tail.next = head;
        return res;
    }

    //我的迭代2（不用计算长度）
    public static ListNode reverseKGroup1(ListNode head, int k) {
        if(k==1){
            return head;
        }
        int count=1;
        ListNode temp=head;
        ListNode res=null;
        ListNode next=null;
        ListNode pre=null;
        boolean flag=true;
        while(temp!=null&&temp.next!=null){
            count++;
            temp=temp.next;
            if(count==k){
                next = temp.next;
                temp.next=null;
                reverse(head);
                if(flag==true){
                    res=temp;
                    pre=head;
                    flag=false;

                }else {
                    pre.next=temp;
                    pre=head;

                }
                head.next=next;
                head=next;
                temp=head;
                count=1;

            }

        }
        return res;
    }

    //我的迭代（比较好理解的迭代 不用计算长度）
    public static ListNode reverseKGroup5(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode temp = head;
        ListNode tail = null;
        while(true){
            int count = 0;
            while(temp!=null&&count<k){
                if(count==k-1){
                    tail = temp;
                }
                count++;
                temp = temp.next;
            }
            if(count!=k){
                p.next = head;
                break;
            }
            tail.next = null;
            reverse(head);
            p.next = tail;
            head.next = temp;
            p=head;
            head = temp;
        }
        return dummy.next;


//        return dummy.next;
    }


    //练习专用
    public static ListNode reverseKGroup7(ListNode head,int k){
        if(k==1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode temp=head;
        ListNode tail=null;
        while(true){
            int count=0;
            while(temp!=null&&count!=k){
                if(count==k-1){
                    tail=temp;
                }
                temp = temp.next;
            }
            if(count!=k){
                p.next=head;
                break;
            }
            tail.next = null;
            reverse(head);
            p.next = tail;
            head.next = temp;
            p = head;
            head = temp;
        }
        return dummy.next;
    }



    //利用栈
    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode temp = head;
        while(true){
           int count=0;
           while(temp!=null&&count!=k){
               stack.push(temp);
               temp = temp.next;
               count++;
           }

            if(count!=k){
                p.next=head;
                break;
            }
           while(!stack.isEmpty()){
               p.next = stack.pop();
               p = p.next;
           }

           p.next=temp;
            head = temp;
        }
        return dummy.next;
    }

    //利用递归
    public static ListNode reverseKGroup3(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        return process(head, k);
    }

    public static ListNode process(ListNode head, int k) {
        int count=0;
        ListNode cur = head;
        while(cur!=null&&count!=k){
            cur = cur.next;
            count++;
        }
        if(count==k){
            cur = process(cur, k);
            while(count!=0){
                count--;
                ListNode next = head.next;
                head.next=cur;
                cur = head;
                head = next;
            }
            head = cur;
        }
        return head;
    }





    private static void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
//        return pre;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
