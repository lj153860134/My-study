package com.lingjian.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 输入一个链表的头节点
 *               从尾到头反过来返回每个节点的值（用数组返回）
 * @author: Ling Jian
 * @date: 2020-06-20 18:10
 **/
public class Test_06 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        int[] res = reversePrint(head);
        System.out.println(Arrays.toString(res));

    }

    public static int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i <res.length ; i++) {
            res[i] = list.get(res.length - i - 1);
        }
        return res;

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
