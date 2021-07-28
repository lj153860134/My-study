package com.lingjian.interview.tengxun;

import java.util.*;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-06 20:39
 **/
public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            String s = sc.nextLine();
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Node> max=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int m = o2.count - o1.count;
                if(m!=0){
                    return m;
                }else{
                    return o1.s.compareTo(o2.s);
                }
            }
        });

        PriorityQueue<Node> min=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int m = o1.count - o2.count;
                if(m!=0){
                    return m;
                }else{
                    return o1.s.compareTo(o2.s);
                }
            }
        });

        for (String s : map.keySet()) {
            Node temp = new Node(s, map.get(s));
            max.add(temp);
            min.add(temp);
        }
        for (int i = 0; i <k ; i++) {
            Node res = max.poll();
            System.out.println(res.s + " " + res.count);
        }
        for (int i = 0; i <k ; i++) {
            Node res = min.poll();
            System.out.println(res.s + " " + res.count);
        }
    }

    static class Node{
        public String s;
        public int count;

        public Node(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }
}
