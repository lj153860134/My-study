package com.lingjian.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 * FreqStack 有两个函数：
 *
 * push(int x)，将整数 x 推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。

 * @author: Ling Jian
 * @date: 2020-09-16 10:17
 **/
public class Test_895 {


    class FreqStack {
        public int max;  //最大次数
        public Map<Integer,Integer> map; //key 为数据 value为数据出现的次数
        public Map<Integer,Stack<Integer>> group; //key为次数 Stack表示该次数下的数据栈

        public FreqStack() {
            this.max=0;
            this.map=new HashMap<>();
            this.group=new HashMap<>();
        }

        public void push(int x) {
            int f=map.getOrDefault(x,0)+1;
            map.put(x,f);
            max=Math.max(f,max);
            if(group.get(f)==null){
                group.put(f,new Stack<>());
            }
            group.get(f).push(x);

        }

        public int pop() {
            int x=group.get(max).pop();
            map.put(x,map.get(x)-1);
            if(group.get(max).size()==0){
                max--;
            }
            return x;
        }
    }
}
