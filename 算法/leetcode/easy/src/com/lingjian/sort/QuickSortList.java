package com.lingjian.sort;


/**
 * @description: 单链表的快速排序
 * @author: Ling Jian
 * @date: 2020-09-14 08:46
 **/
public class QuickSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        quickSort(head, head.next.next.next.next);
        printList(head);

    }


    public static void quickSort(ListNode begin, ListNode end) {
        //判断为空，判断是不是只有一个节点
        if (begin == null || end == null || begin == end)
            return;
        //从第一个节点和第一个节点的后面一个几点
        ListNode first = begin;
        ListNode second = begin.next;

        int nMidValue = begin.value;
        //结束条件，second到最后了
        while (second != end.next && second != null) {
            if (second.value < nMidValue) {
                first = first.next;
                //判断一下，避免后面的数比第一个数小，不用换的局面
                if (first != second) {
                    swap(first,second);
                }
            }
            second = second.next;
        }
        //判断，有些情况是不用换的，提升性能
        if (begin != first) {
            swap(begin, first);
        }
        //前部分递归
        quickSort(begin, first);
        //后部分递归
        quickSort(first.next, end);
    }



    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

    }

    public static void swap(ListNode a, ListNode b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
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
