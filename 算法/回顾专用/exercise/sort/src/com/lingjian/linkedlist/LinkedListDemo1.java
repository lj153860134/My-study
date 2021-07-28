package com.lingjian.linkedlist;

import java.util.Spliterator;
import java.util.Stack;

/**
 * @description: 单链表
 * @author: Ling Jian
 * @date: 2020-05-06 16:26
 **/
public class LinkedListDemo1 {
    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1, "凌健");
        Node node2 = new Node(2, "徐小萌");
        Node node3 = new Node(3, "王龙");
        Node node4 = new Node(4, "陈旭");
        Node node5 = new Node(5, "陈旭1");

        list.addBySort(node1);
        list.addBySort(node2);
        list.addBySort(node3);
        list.addBySort(node4);
//        list.show();
//        System.out.println();
//        reversalLinkedList(list);
//        printReversalLinkedList(list);
//        System.out.println();
//        list.show();
        //递归反转单链表
        printList(node1);
        Node head = reversalLinkedListByRecur(node1);
        System.out.println("递归反转之后=========");
        printList(head);

//        list.updateNode(node5);
//        list.show();
//        System.out.println();

    }


    //非递归反转单链表（改变单链表的结构）
    public static void reversalLinkedList(SingleLinkedList list){
        if(list.isEmpty()){
            System.out.println("该链表为空 无法反转");
            return;
        }

        Node cur=list.head.next;
        Node pre=null;
        Node next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        list.head.next=pre;

    }

    //递归反转单链表（改变单链表的结构）
    public static Node reversalLinkedListByRecur(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reversalLinkedListByRecur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }


    //利用栈来反转单链表（改变单链表的结构）
    public static void reversalLinkedList2(SingleLinkedList list) {
        if (list.isEmpty()) {
            System.out.println("该链表为空 无法反转");
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node temp=list.head.next;
        while(temp!=null){
            stack.push(temp);
            temp = temp.next;
        }

        list.head.next= stack.pop();
        temp=list.head.next;
        while(!stack.isEmpty()){
            temp.next=stack.peek();
            temp=stack.pop();
        }
        temp.next=null;
    }


    //利用栈来反转遍历单链表（不改变单链表的结构 ）
    public static void printReversalLinkedList(SingleLinkedList list) {
        if (list.isEmpty()) {
            System.out.println("该链表为空 无法遍历");
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node temp=list.head.next;
        while(temp!=null){
            stack.push(temp);
            temp = temp.next;
        }

        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    //根据头结点打印链表
    public static void printList(Node head) {
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp= temp.next;
        }
    }


}



//单链表类
class SingleLinkedList{
    //头结点
    public Node head;

    public SingleLinkedList() {
        head=new Node();
    }

    //不按照顺序添加结点
    public void add(Node node){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=node;
    }

    //按照num顺序添加结点 若已经添加num 直接覆盖
    public void addBySort(Node node) {
        Node temp=head;
        while(temp.next!=null&&temp.next.num<node.num){
            temp=temp.next;
        }

        if (temp.next != null && temp.next.num != node.num) { //这里被idea直接重构了
            node.next = temp.next;
        }
        temp.next=node;

    }

    //根据num删除结点
    public void deleteNode(int num) {
        if (isEmpty()) {
            System.out.println("链表为空 无法删除");
            return;
        }
        Node temp=head;
        while (temp.next != null && temp.next.num != num) {
            temp = temp.next;

        }


        if (temp.next == null) {
            System.out.println("链表不存在该数据 无法删除");
        }else{
            temp.next = temp.next.next;
        }


    }


    //根据num修改结点
    public void updateNode(Node node) {
        if (isEmpty()) {
            System.out.println("链表为空 无法修改");
            return;
        }
        Node temp=head.next;
        while (temp != null && temp.num != node.num) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("链表不存在该数据 无法修改");
        }else{
            temp.name = node.name;
        }
    }


    //根据num查找打印结点
    public void getNode(int num) {
        if (isEmpty()) {
            System.out.println("链表为空 无法查找数据");
            return;
        }
        Node temp=head.next;
        while (temp != null && temp.num != num) {
            temp = temp.next;
        }
        if(temp==null){
            System.out.println("该链表不存在该数据");
        }else{
            System.out.println(temp);
        }
    }

    //返回链表长度
    public int size(){
        Node temp=head.next;
        int result=0;
        while(temp!=null){
            result++;
            temp = temp.next;
        }
        return result;
    }


    public boolean isEmpty(){
        return head.next==null;
    }

    //遍历单链表
    public void show(){
        if(isEmpty()){
            System.out.println("The linkedList is empty");
            return;
        }
        Node temp=head.next;
        while(temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
    }
}

//结点类
class Node{
    public int num;
    public String name;
    public Node next;

    //无参构造器
    public Node(){}

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
