package com.lingjian.tree.lingjian_1;

/**
 * @description: morri遍历 额外空间复杂度O(1)
 * @author: Ling Jian
 * @date: 2020-03-14 08:58
 **/
public class MorrisTraversal {
    public static void main(String[] args) {

        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        //递归前序遍历
        preTreeRecur(head);
        System.out.println();
        //morris前序遍历
        morrisPreTree(head);
        System.out.println();

        //递归中序遍历
        inTreeRecur(head);
        System.out.println();
        //morris中序遍历
        morrisInTree(head);
        System.out.println();
    }


    //morris前序遍历
    public static void morrisPreTree(Node head){
        if(head==null){
            return;
        }
        Node cur=head;
        Node mostRight=null;
        while(cur!=null){
           if(cur.left==null){
               System.out.print(cur.value+" ");
               cur=cur.right;
           }else{
               mostRight=cur.left;
               while(mostRight.right!=null&&mostRight.right!=cur){
                   mostRight=mostRight.right;
               }
               if(mostRight.right==null){
                   System.out.print(cur.value+" ");
                   mostRight.right=cur;
                   cur=cur.left;
               }else{
                   mostRight.right=null;
                   cur=cur.right;
               }
           }
        }
    }

    //morris中序遍历
    public static void morrisInTree(Node head){
        if(head==null){
            return;
        }
        Node cur=head;
        Node mostRight=null;
        while(cur!=null){
            if(cur.left==null){
                System.out.print(cur.value+" ");
                cur=cur.right;
            }else{
                mostRight=cur.left;
                while(mostRight.right!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }
                if(mostRight.right==null){
//                    System.out.print(cur.value+" ");
                    mostRight.right=cur;
                    cur=cur.left;
                }else{
                    System.out.print(cur.value+" ");
                    mostRight.right=null;
                    cur=cur.right;
                }
            }
        }
        System.out.println();

    }



    //递归前序遍历
    public static void preTreeRecur(Node head){
        if(head==null){
            return;
        }
        System.out.print(head.value+" ");
        preTreeRecur(head.left);
        preTreeRecur(head.right);
    }


    //递归中序遍历
    public static void inTreeRecur(Node head){
        if(head==null){
            return;
        }
        inTreeRecur(head.left);
        System.out.print(head.value+" ");
        inTreeRecur(head.right);
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
}
