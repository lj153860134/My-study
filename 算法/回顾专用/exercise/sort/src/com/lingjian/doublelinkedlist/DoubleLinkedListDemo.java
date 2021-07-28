package com.lingjian.doublelinkedlist;

/**
 * @description: 双向链表
 * @author: Ling Jian
 * @date: 2020-05-07 15:55
 **/
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        Node node1 = new Node(1, "凌健");
        Node node2 = new Node(2, "徐小萌");
        Node node3 = new Node(3, "王龙");
        Node node4 = new Node(4, "陈旭");
        Node node5 = new Node(4, "陈旭1");

        list.addBySort(node1);
        list.addBySort(node4);
        list.addBySort(node2);
        list.addBySort(node3);
//        list.addBySort(node5);
        list.deleteNode(4);

        list.show();


    }


}

class DoubleLinkedList {

    public Node head;    //头结点
//    public Node tail;    //尾结点

    public DoubleLinkedList() {
        this.head = new Node();
//        this.tail = new Node();
    }


    //直接添加结点到双向链表尾部
    public void addNode(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //按照顺序添加结点 若num已经添加 直接覆盖
    public void addBySort(Node node) {
        Node temp = head;
        while (temp.next!= null && temp.next.num < node.num){
            temp = temp.next;
        }
        if(temp.next!=null){
            if(temp.next.num==node.num){
                temp.next.name=node.name;
            }else{
                node.pre=temp;
                node.next=temp.next;
                temp.next.pre=node;
                temp.next=node;
            }
        }else{
            node.pre=temp;
            node.next=temp.next;
            temp.next=node;
        }

    }

    //根据num删除对应的结点
    public void deleteNode(int num) {
        if(isEmpty()){
            System.out.println("双向链表为空 无法删除");
            return;
        }
        Node temp = head;
        while (temp.next!= null && temp.num != num) {
            temp = temp.next;
        }
        if(temp.next==null){
            if(temp.num!=num){
                System.out.println("双向链表无该数据 无法删除");
            }else{
                temp.pre.next=temp.next;
            }
        }else{
            temp.pre.next=temp.next;
            temp.next.pre=temp.pre;
        }
    }



    //遍历双向链表
    public void show(){
       if(isEmpty()){
           System.out.println("双向链表为空");
           return;
       }
       Node temp=head.next;
       while(temp!=null){
           System.out.println(temp);
           temp = temp.next;
       }

    }


    //判断链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }
}

//结点类
class Node {
    public int num;
    public String name;
    public Node pre;
    public Node next;

    //无参构造器
    public Node() {
    }

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}

