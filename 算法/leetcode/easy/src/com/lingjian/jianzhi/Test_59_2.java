package com.lingjian.jianzhi;

import java.util.LinkedList;

/**
 * @description: 请定义一个队列并实现函数 max_value
 *               得到队列里的最大值
 *               要求函数max_value、push_back 和 pop_front
 *               的均摊时间复杂度都是O(1)
 * @author: Ling Jian
 * @date: 2020-07-07 17:22
 **/
public class Test_59_2 {

    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        queue.push_back(4);
        queue.push_back(4);
        queue.push_back(3);
        queue.push_back(5);
        System.out.println(queue.max_value());

        System.out.println(queue.pop_front());

        System.out.println(queue.max_value());

        System.out.println(queue.pop_front());

        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());

        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());


    }

    static class MaxQueue {
        private LinkedList<Integer> max;
        private LinkedList<Integer> data;
        public MaxQueue() {
            this.max = new LinkedList<>();
            this.data = new LinkedList<>();
        }

        public int max_value() {
            if(data.isEmpty()){
                return -1;
            }
            return max.peek();
        }

        public void push_back(int value) {
            data.add(value);
            while(!max.isEmpty()&&max.peekLast()<value){
                max.pollLast();
            }
            max.add(value);
        }

        public int pop_front() {
            if(data.isEmpty()){
                return -1;
            }
            int temp = data.poll();
            if (temp == max.peek()) {
                max.poll();
            }
            return temp;
        }
    }
}
