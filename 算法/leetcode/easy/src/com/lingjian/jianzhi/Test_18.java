package com.lingjian.jianzhi;

/**
 * @description: 给定单向链表的头指针和一个要删除的节点的值
 * 定义一个函数删除该节点
 * 返回删除后的链表的头节点
 * @author: Ling Jian
 * @date: 2020-06-22 17:38
 **/
public class Test_18 {

    public static void main(String[] args) {

    }

    public static ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            head=head.next;
            return head;
        }
        ListNode temp=head;
        while(temp.next!=null){
            if(temp.next.val==val){
                temp.next=temp.next.next;
                return head;
            }
            temp=temp.next;
        }
        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
