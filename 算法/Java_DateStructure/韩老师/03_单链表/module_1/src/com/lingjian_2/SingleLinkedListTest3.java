package com.lingjian_2;

import java.util.Stack;

/**
 * @author lingjian
 * @date 2019/11/29 - 10:54 上午
 */
/*
*
* 反向遍历单链表
*
* 反转单链表【腾讯面试题】(头结点现在到最后了）
* */
public class SingleLinkedListTest3 {
    public static void main(String[] args) {
        //创建一个单链表
        SingleLinkedList list = new SingleLinkedList();
        //  创建一些结点
        HeroNode hn1 = new HeroNode(1, "凌健", "小小贱");
        HeroNode hn2 = new HeroNode(2, "徐小萌", "小小萌");
        HeroNode hn3 = new HeroNode(3, "凌立宏", "A哥");
        HeroNode hn4 = new HeroNode(4, "王杰", "死胖子");

        //添加结点
        list.addNode2(hn4);
        list.addNode2(hn2);
        list.addNode2(hn1);
        list.addNode2(hn3);

        list.showList();
        System.out.println("---------");

        //反向遍历链表(方式1)
        reversePrintList(list);
        System.out.println("----------");

        //利用栈反向遍历链表(方式2)
        stackPrintList(list.getHead());
        System.out.println("----------");

        //反转单链表
        reverseList(list);
        list.showList();

    }

    /**
     * 反向遍历单链表
     * @param list
     */
    public static void reversePrintList(SingleLinkedList list){
        if(list.isEmpty()){
            System.out.println("链表为空 无法反向遍历");
            return;
        }
        int len=list.getLength(); //获取单链表的结点个数
        //方式1 用for循环嵌套
        for (; len>=1 ; len--) {
            HeroNode temp=list.getHead();
            for (int j = 1; j <=len ; j++) {
               temp=temp.next;

            }
            System.out.println(temp);

        }

        //方式2 用一个for循环 和list.getNode(int num)
//        for (; len >=1 ; len--) {
//            list.getNode(len);
//        }

    }

    /**
     * 利用栈来反向遍历单链表（很简单）
     * @param head
     */

    public static void stackPrintList(HeroNode head){
        if(head.next==null){
            System.out.println("链表为空 无法反向遍历");
            return;
        }
        HeroNode temp=head.next;
        //创建一个结点的栈
        Stack<HeroNode> stack=new Stack<>();
        //将所有的结点入栈  push（）
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        //将所有的结点出栈 pop()
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 反转单链表
     * @param list
     */

    public static void reverseList(SingleLinkedList list){
        if(list.isEmpty()){
            System.out.println("链表为空 无法反转");
        }
        //先定义一个新的头结点
        HeroNode reverseHead =new HeroNode(0," "," ");
        HeroNode temp=list.getHead().next;
        while(temp!=null){
            list.getHead().next=temp.next;
            temp.next=reverseHead.next;
            reverseHead.next=temp;
            temp=list.getHead().next;

        }
        list.getHead().next=reverseHead.next;


    }


}
