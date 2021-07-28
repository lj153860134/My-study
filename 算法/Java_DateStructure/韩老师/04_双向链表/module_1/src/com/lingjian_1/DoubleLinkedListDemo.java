package com.lingjian_1;

import java.util.LinkedList;

/**
 * @author lingjian
 * @date 2019/11/29 - 6:31 下午
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        //创建一个单链表
        DoubleLinkedList list = new DoubleLinkedList();

        //  创建一些结点
        HeroNode hn1 = new HeroNode(1, "凌健", "小小贱");
        HeroNode hn2 = new HeroNode(2, "徐小萌", "小小萌");
        HeroNode hn3 = new HeroNode(3, "凌立宏", "A哥");
        HeroNode hn4 = new HeroNode(4, "王杰", "死胖子");

        //添加结点
        list.addNode2(hn3);
        list.addNode2(hn1);
        list.addNode2(hn4);
        list.addNode2(hn2);

        //打印结点
        list.showList();
        System.out.println("----------");

        //修改结点
        HeroNode newNode = new HeroNode(1, "lj", "lj");
        list.updateNode(newNode);
        list.showList();
        System.out.println("----------");

        //删除结点
        list.deleteNode(1);
        list.deleteNode(4);
        list.showList();
    }


}

//定义双向链表类
class DoubleLinkedList {
    private HeroNode head = new HeroNode(0, " ", " ");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }


    /**
     * 不按num顺序 直接添加结点到双向链表尾部
     *
     * @param heroNode
     */
    public void addNode(HeroNode heroNode) {
        //因为head结点不能动 需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表
        while (temp.next != null) {
            //没有找到最后结点 一定要将temp后移
            temp = temp.next;
        }
        //当退出while的循环的时候 temp就指向链表的最后
        //添加新的结点 形成新的双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 按num顺序 添加结点到双向链表中
     *
     * @param heroNode
     */
    public void addNode2(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = true; //判断是否添加成功 默认true
        while (true) {
            if (temp.next == null)
                break;
            else if (temp.next.num > heroNode.num)
                break;
            else if (temp.next.num == heroNode.num) {
                flag = false;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            heroNode.pre = temp;
            heroNode.next = temp.next;
            if (temp.next != null)
                temp.next.pre = heroNode;
            temp.next = heroNode;
        }
    }

    /**
     * 删除双向链表的结点(可以自我删除）
     *
     * @param num
     */
    public void deleteNode(int num) {
        if (isEmpty()) {
            System.out.println("链表为空 无法删除结点");
            return;
        }
        HeroNode temp = head.next; //双向链表这里是用的head.next赋值给temp
        // 与单链表不同
        boolean flag = false; //是否删除成功
        while (temp != null) {
            if (temp.num == num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {   //判断删除的是否为最后一个结点
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("查找不到该数据 无法删除");
        }


    }

    /**
     * 修改结点数据（根据num来修改)
     * 双向链表修改结点的内容与单向链表一样
     *
     * @param heroNode
     */
    public void updateNode(HeroNode heroNode) {
        if (isEmpty()) {
            System.out.println("链表为空 无法修改");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = true; //用来表示是否修改成功 默认true
        while (true) {
            if (temp == null) {
                flag = false;
                break;
            } else if (temp.num == heroNode.num) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("找不到该数据 无法修改");
        }
    }

    /**
     * 遍历显示双向链表的所有结点
     *
     * @param
     */
    public void showList() {
        //判断链表是否为空
        if (isEmpty()) {
            System.out.println("链表为空 无法遍历");
            return;
        }

        //head不能动 需要辅助变量temp
        HeroNode temp = head.next;  //已经判断链表不为空 至少存在一个数据
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;  //将temp后移
        }
    }


    //判断链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }
}


//定义HeroNode 每一个HeroNode对象就是一个结点
class HeroNode {
    public int num;    //结点的序号
    public String name;
    public String nickName;
    public HeroNode next;  //指向后一个结点
    public HeroNode pre;   //指向前一个结点


    //结点构造器


    public HeroNode(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    //重写toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
