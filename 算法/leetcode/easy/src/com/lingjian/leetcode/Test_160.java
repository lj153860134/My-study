package com.lingjian.leetcode;

/**
 * @description: 编写一个程序
 * 找到两个单链表相交的起始节点。
 * @author: Ling Jian
 * @date: 2020-08-04 21:40
 **/
public class Test_160 {
    public static void main(String[] args) {


    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int p = getLength(headA);
        int q = getLength(headB);
        int gap = Math.abs(p - q);
        if(p>=q){
           while(gap-->0){
               headA = headA.next;
           }
        }else{
            while(gap-->0){
                headB = headB.next;
            }
        }
        while(headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static int getLength(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }

    //将两个链表拼接起来 避免算长度差
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode temp1= headA;
        ListNode temp2= headB;
        while(temp1!=temp2){
            temp1=temp1==null?headB:temp1.next;
            temp2=temp2==null?headA:temp2.next;

        }
        return temp1;
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
