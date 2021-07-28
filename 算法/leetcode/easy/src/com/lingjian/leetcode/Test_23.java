package com.lingjian.leetcode;

/**
 * @description: 合并 k 个有序链表，返回合并后的排序链表
 * @author: Ling Jian
 * @date: 2020-08-05 20:35
 **/
public class Test_23 {
    public static void main(String[] args) {

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        return process(lists, 0, lists.length - 1);
    }

    public static ListNode process(ListNode[] lists, int left, int right) {
        if(left==right){
            return lists[left];
        }
        int mid=left+((right-left)>>1);
        ListNode head1 = process(lists, left, mid);
        ListNode head2 = process(lists, mid + 1,right);
        return merge(head1, head2);
    }

    public static ListNode merge( ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(head1!=null&&head2!=null){
            if(head1.val<=head2.val){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next=head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        temp.next = head1 != null ? head1 : head2;
        return dummy.next;

    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
