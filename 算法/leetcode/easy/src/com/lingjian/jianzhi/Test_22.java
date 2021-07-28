package com.lingjian.jianzhi;

/**
 * @description: 输入一个链表，输出该链表中倒数第k个节点
 * 为了符合大多数人的习惯
 * 本题从1开始计数
 * 即链表的尾节点是倒数第1个节点。
 * @author: Ling Jian
 * @date: 2020-06-22 17:41
 **/
public class Test_22 {
    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int n=count-k;
        temp=head;
        while(n-->0){
            temp=temp.next;
        }
        return temp;

    }

    //双指针
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode s = dummy;
        ListNode f = dummy;
        dummy.next=head;
        while(k>0){
            f = f.next;
            k--;
        }
        while(f!=null){
            f = f.next;
            s = s.next;
        }
        return s;


    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
