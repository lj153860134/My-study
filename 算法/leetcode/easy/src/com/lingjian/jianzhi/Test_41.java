package com.lingjian.jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 如何得到一个数据流中的中位数
 *               如果从数据流中读出奇数个数值
 *               那么中位数就是所有数值排序之后位于中间的数值
 *               如果从数据流中读出偶数个数值
 *               那么中位数就是所有数值排序之后中间两个数的平均值。
 * @author: Ling Jian
 * @date: 2020-07-03 15:38
 **/
public class Test_41 {

    public static void main(String[] args) {
        MedianFinder1 mf = new MedianFinder1();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(4);
        System.out.println(mf.findMedian());
        mf.addNum(5);
        System.out.println(mf.findMedian());
    }

    static class MedianFinder {
        private PriorityQueue<Integer> min;
        private PriorityQueue<Integer> max;
        int count;

        public MedianFinder() {
            this.min=new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });


            this.max = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });



        }

        public void addNum(int num) {
            if(count==0||num<max.peek()){
                max.add(num);
            }else{
                min.add(num);
            }
            count++;
            balance();


        }

        public double findMedian() {
            //偶数
            if((count&1)==0){
                return (min.peek() + max.peek()) / 2.0;
            }else{
                return min.size() > max.size() ? (double) min.peek() : (double) max.peek();
            }

        }

        public void balance(){
            while(Math.abs(max.size()-min.size())>1){
                if(max.size()>min.size()){
                    min.add(max.poll());
                }else{
                    max.add(min.poll());
                }
            }
        }
    }

    //简练版本
    static class MedianFinder1 {

        private PriorityQueue<Integer> min;
        private PriorityQueue<Integer> max;


        public MedianFinder1() {
            this.min = new PriorityQueue<>();
            this.max=new PriorityQueue<>((x,y)->(y-x));

        }

        //一直保证max.size()>=min.size()
        public void addNum(int num) {
            //向max中添加元素
            if(min.size()==max.size()){
                min.add(num);
                max.add(min.poll());

            }else{
                //向min中添加元素
                max.add(num);
                min.add(max.poll());


            }

        }

        public double findMedian() {
            return max.size() != min.size() ? max.peek() : (max.peek() + min.peek()) / 2.0;
        }
    }
}
