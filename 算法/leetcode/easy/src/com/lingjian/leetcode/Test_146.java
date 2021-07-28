package com.lingjian.leetcode;

import java.util.*;

/**
 * @description: LRU缓存机制
 * @author: Ling Jian
 * @date: 2020-07-23 23:27
 **/
public class      Test_146 {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2 );
        lru.put(3, 3 );

        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
    }

    //利用HashMap与LinkedList
    //LinkedList越靠前优先级越高
    class LRUCache {
        private int cap;
        private HashMap<Integer, Node> map;
        private LinkedList<Node> list;

        public LRUCache(int capacity) {
            this.cap = capacity;
            this.map = new HashMap<>();
            this.list = new LinkedList<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int value = map.get(key).value;
            put(key, value);
            return value;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                list.remove(map.get(key));

            } else {
                if (cap == list.size()) {
                    Node last = list.pollLast();
                    map.remove(last.key);
                }

            }
            list.addFirst(node);
            map.put(key, node);


        }

        class Node {
            private int key;
            private int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    //利用LinkedHashMap
    //越靠前 优先级越低
    static class LRU {
        private int cap;
        private Map<Integer, Integer> map;

        public LRU(int cap
        ) {
            this.cap = cap;
            this.map = new LinkedHashMap<>();

        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            } else {
                int res = map.get(key);
                put(key, res);
                return res;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
            } else if (map.size()==cap){
                Iterator it = map.entrySet().iterator();
                it.next();
                it.remove();


            }
            map.put(key, value);
        }
    }


}
