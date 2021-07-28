package com.lingjian_6;


import java.util.*;

/**
 * @description: 哈夫曼数
 * @author: Ling Jian
 * @date: 2020-03-09 10:03
 **/
public class HuffmanTree {

    public static void main(String[] args) {

        int[] arr= new int[]{13, 7, 8, 3, 29, 6, 1};
        Node head=creatHuffmanTree(arr);
        //遍历数组 每个元素变为Node 将Node放入ArrayList中
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Node(arr[i]));
        }
        Node head1=recurCreateHuffmanTree(list);
        PreOrderTree(head);
        System.out.println("========");
        PreOrderTree(head1);

    }

    //非递归创建赫夫曼树
        public static Node creatHuffmanTree(int[] arr){
        if(arr==null){
            return null;
        }
        //遍历数组 每个元素变为Node 将Node放入ArrayList中
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Node(arr[i]));
        }
        while(list.size()>1) {
            //排序 有两种方法
            //Node实现Comparable接口 实现compareTo方法
            //在这里用内部实现类 实现Comparator接口 实现compare方法
            Collections.sort(list);
            System.out.println(list);
            //取出最小的前两个权值节点
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);

            //生成新的结点
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;

            //移除这两个节点
            list.remove(leftNode);
            list.remove(rightNode);

            //将新结点放入集合中
            list.add(parent);


        }
            return list.get(0);
    }

    //递归调用赫夫曼树
    public static Node recurCreateHuffmanTree(List<Node> list){
        if(list.size()<=1){
            return list.get(0);
        }
            Collections.sort(list);
            //取出最小的前两个权值节点
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);

            //生成新的结点
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;

            //移除这两个节点
            list.remove(leftNode);
            list.remove(rightNode);

            //将新结点放入集合中
            list.add(parent);
            return recurCreateHuffmanTree(list);

    }

    //递归前序遍历
    public static void PreOrderTree(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.value);
        PreOrderTree(head.left);
        PreOrderTree(head.right);
    }

    //定义结点
    public static class Node implements Comparable<Node>{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}



