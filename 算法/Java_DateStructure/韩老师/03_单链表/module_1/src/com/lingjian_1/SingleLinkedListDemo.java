package com.lingjian_1;

/**
 * @author lingjian
 * @date 2019/11/28 - 2:23 下午
 */
/*
* 单链表的创建和遍历(没有考虑编号 在尾部添加）
* */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建一个单链表
        SingleLinkedList list=new SingleLinkedList();
        //  创建一些结点
        HeroNode hn1=new HeroNode(1,"凌健","小小贱");
        HeroNode hn2=new HeroNode(2,"徐小萌","小小萌");
        HeroNode hn3=new HeroNode(3,"凌立宏","A哥");
        //添加结点
        list.addNode(hn1);
        list.addNode(hn2);
        list.addNode(hn3);

        //遍历链表
        list.showList();


    }
}

class SingleLinkedList{
    //初始化一个头结点 头结点不能动 不存放具体的数据
    HeroNode head=new HeroNode(0," "," ");

    //添加结点到单向链表
    //不按照编号顺序 直接添加到最后结点
    //1.找到当前链表的最后结点
    //2.将最后这个结点的next 指向新的结点
    public void  addNode(HeroNode heroNode){
        //因为head结点不能动 需要一个辅助变量temp
        HeroNode temp=head;
        //遍历链表
        while(temp.next!=null){
            //没有找到最后结点 一定要将temp后移
            temp=temp.next;
        }
        temp.next=heroNode;
    }

    //遍历显示链表
    public void showList(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        //head不能动 需要辅助变量temp
        HeroNode temp=head.next;  //已经判断链表不为空 至少存在一个数据
        while(temp!=null){
            System.out.println(temp);
            temp=temp.next;  //将temp后移
        }
    }
}

//定义HeroNode 每一个HeroNode对象就是一个结点
class HeroNode{
    public int num;    //结点的序号
    public String name;
    public String nickName;
    public HeroNode next;  //指向下一个结点

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
