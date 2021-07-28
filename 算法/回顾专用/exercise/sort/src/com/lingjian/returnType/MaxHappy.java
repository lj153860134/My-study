package com.lingjian.returnType;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 宴会最大活跃值
 * @author: Ling Jian
 * @date: 2020-05-27 15:11
 **/
public class MaxHappy {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.nexts.add(new Node(12));
        head.nexts.add(new Node(2));
        head.nexts.add(new Node(3));
        ReturnType res = process(head);
        System.out.println(Math.max(res.lai_huo, res.bu_lai_huo));


    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        int lai_huo = head.happy;
        int bu_lai_huo=0;
        for (int i = 0; i <head.nexts.size() ; i++) {
            Node next = head.nexts.get(i);
            ReturnType info = process(next);
            lai_huo += info.bu_lai_huo;
            bu_lai_huo += Math.max(info.lai_huo, info.bu_lai_huo);
        }
        return new ReturnType(lai_huo, bu_lai_huo);
    }
    public static class ReturnType{
        public int lai_huo;
        public int bu_lai_huo;

        public ReturnType(int lai_huo, int bu_lai_huo) {
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }

    public static class Node{
        public int happy;
        public List<Node> nexts;

        public Node(int happy) {
            this.happy = happy;
            nexts = new ArrayList<>();
        }
    }
}
