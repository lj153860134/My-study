package com.lingjian_2;

/**
 * @author lingjian
 * @date 2019/11/29 - 9:54 上午
 */

/*
 * 需求：求单链表中有效结点的个数(不能把头结点算进去）
 *
 * */
public class SingleLinkedListTest1 {
    public static void main(String[] args) {


        //创建一个单链表
        SingleLinkedList list = new SingleLinkedList();
        //  创建一些结点
        HeroNode hn1 = new HeroNode(1, "凌健", "小小贱");
        HeroNode hn2 = new HeroNode(2, "徐小萌", "小小萌");
        HeroNode hn3 = new HeroNode(3, "凌立宏", "A哥");
        HeroNode hn4 = new HeroNode(4, "王杰", "死胖子");

        System.out.println(list.getLength());
        //添加结点
        list.addNode2(hn4);
        list.addNode2(hn2);
        list.addNode2(hn1);
        list.addNode2(hn3);
        System.out.println(list.getLength());

    }


}
