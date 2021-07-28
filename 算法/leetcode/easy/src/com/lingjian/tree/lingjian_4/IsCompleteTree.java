package com.lingjian.tree.lingjian_4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 判断二叉树是否为完全二叉树
 * @author: Ling Jian
 * @date: 2019-12-21 21:48
 **/
public class IsCompleteTree {




    public static boolean isCBT(Node head){
        if(head==null){
            return true;
        }

        Queue<Node> queue=new LinkedList<Node>();
        boolean leaf=false; //开启判断该层即后面的结点全是叶结点的状态
        Node l=null;
        Node r=null;
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            l=head.left;
            r=head.right;
            if((leaf&&(l!=null||r!=null))||
                    (l==null&&r!=null)){
                return false;
            }
            if(l!=null){
                queue.add(l);
            }
            if(r!=null){
                queue.add(r);
            }else{
                leaf=true;
            }
        }
        return true;

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
