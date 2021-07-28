package com.lingjian.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @description: 给定一个单链表
 *               随机选择链表的一个节点
 *               并返回相应的节点值。
 *               保证每个节点被选的概率一样
 *
 *               蓄水池抽样
 * 进阶: 如果链表十分大且长度未知，
 * 如何解决这个问题？你能否使用常数级空间复杂度实现？
 * @author: Ling Jian
 * @date: 2020-06-18 14:32
 **/
public class Test_382 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        Solution1 s1 = new Solution1(head);
//        for (int i = 0; i <10 ; i++) {
//            System.out.println(s1.getRandom());
//        }

        SolutionK sk = new SolutionK(head);
        for (int i = 0; i <10 ; i++) {
            System.out.println(Arrays.toString(sk.getRandom(3)));
        }
    }

    //n个中  等概率选择1个

    static class Solution1 {
        private ListNode head;

        public Solution1(ListNode head) {
            this.head = head;

        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int res=head.val;
            int i=2;
            ListNode temp=head.next; //这里一定是head.next
                                     //因为res=head.val了
            Random random = new Random();
            while(temp!=null){
                if(random.nextInt(i)==0){
                    res = temp.val;
                }
                i++;
                temp = temp.next;
            }
            return res;
        }
    }

    //n个 中等概率选择k个 （n>=k）
    static class SolutionK{
        private ListNode head;

        public SolutionK(ListNode head) {
            this.head = head;
        }

        public int[] getRandom(int k){
            if(k<1){
                return null;
            }
            int[] res = new int[k];
            ListNode temp=head;
            for (int i = 0; i <k ; i++) {
                res[i]=temp.val;
                temp = temp.next;
            }
            int i=k+1;
            Random random = new Random();
            while(temp!=null){
                if(random.nextInt(i)<k){
                    res[random.nextInt(k)] = i;
                }
                temp = temp.next;
                i++;
            }
            return res;
        }
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
