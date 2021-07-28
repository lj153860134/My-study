package com.lingjian_2;

/**
 * @author lingjian
 * @date 2019/11/29 - 10:02 上午
 */

/*
 *
 * 需求:查找单链表的倒数第k个结点【新浪面试题】
 * */
public class SingleLinkedListTest2 {
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
        findLastNode(list,1);
        findLastNode(list,2);
        findLastNode(list,3);
        findLastNode(list,4);
        findLastNode(list,5);
    }

    //查找单链表中倒数第k个结点
    public static void findLastNode(SingleLinkedList list, int k){
        int len=list.getLength(); //获取单链表有效结点的个数
        if(k>len){
            System.out.println("超出链表的长度 无法获取结点");
            return;
        }
        int count=len-k;
        HeroNode temp=list.getHead().next;
        for (int i = 0; i <count ; i++) {
            temp=temp.next;
        }
        System.out.println(temp);
    }



}
