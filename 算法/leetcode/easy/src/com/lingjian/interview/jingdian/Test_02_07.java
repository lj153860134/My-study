package com.lingjian.interview.jingdian;

/**
 * @description: 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。
 * 如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交
 * @author: Ling Jian
 * @date: 2020-06-04 23:40
 **/
public class Test_02_07 {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int p1=0;
        int p2=0;
        while (cur1 != null) {
            p1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            p2++;
            cur2 = cur2.next;
        }

        int num = Math.abs(p1 - p2);
        cur1=headA;
        cur2 = headB;
        while(num-->0){
            if (p1 > p2) {
                cur1 = cur1.next;
            }else{
                cur2 = cur2.next;
            }
        }
        while(cur1!=null){
            if(cur1==cur2){
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;

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
