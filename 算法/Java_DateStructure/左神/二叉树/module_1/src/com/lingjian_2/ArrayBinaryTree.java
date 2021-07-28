package com.lingjian_2;

/**
 * @description: 顺序存储二叉树（前中序）存储 完全二叉树
 *               将数组想象成一个数 通过下标的的变化
 *               为后面的堆排序做基础 堆一定是完全二叉树
 *               堆在底层是优先级队列
 * @author: Ling Jian
 * @date: 2020-03-07 14:45
 **/
public class ArrayBinaryTree {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7};
        preArrayBinaryTree(arr,0);
        System.out.println("======");
        inArrayBinaryTree(arr,0);
        System.out.println("======");
        posArrayBinaryTree(arr,0);
    }


    //定义结点
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //数组前序存储二叉树
    public static void preArrayBinaryTree(int[] arr,int index){
        if(arr==null||arr.length<2){
            return;
        }
        if(index>=arr.length){
            return;
        }
        System.out.println(arr[index]);
        preArrayBinaryTree(arr,2*index+1);
        preArrayBinaryTree(arr,2*index+2);

    }

    //数组中序存储二叉树
    public static void inArrayBinaryTree(int[] arr,int index){
        if(arr==null||arr.length<2){
            return;
        }
        if(index>=arr.length){
            return;
        }
        inArrayBinaryTree(arr,2*index+1);
        System.out.println(arr[index]);
        inArrayBinaryTree(arr,2*index+2);

    }

    //数组后序存储二叉树
    public static void posArrayBinaryTree(int[] arr,int index){
        if(arr==null||arr.length<2){
            return;
        }
        if(index>=arr.length){
            return;
        }
        posArrayBinaryTree(arr,2*index+1);
        posArrayBinaryTree(arr,2*index+2);
        System.out.println(arr[index]);

    }
}

