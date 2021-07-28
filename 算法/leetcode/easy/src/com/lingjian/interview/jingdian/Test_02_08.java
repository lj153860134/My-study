package com.lingjian.interview.jingdian;

import java.util.HashSet;

/**
 * @description: 给定一个有环链表，实现一个算法返回环路的开头节点
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 * @author: Ling Jian
 * @date: 2020-06-05 19:53
 **/
public class Test_02_08 {
    public static void main(String[] args) {


    }

    //方法一 用额外空间 HashSet
    public static ListNode detectCycle1(ListNode head) {
        if(head==null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                break;
            }
            set.add(cur);
            cur = cur.next;
        }
        return cur;


    }

    public static ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
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
