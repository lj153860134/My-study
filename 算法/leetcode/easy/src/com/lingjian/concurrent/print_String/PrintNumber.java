package com.lingjian.concurrent.print_String;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-08-24 14:37
 **/
public class PrintNumber {

        public static void main(String[] args) {
            CommonData data = new CommonData();
            new Thread(()->{
                for (int i = 0; i < 100; i++) {
                    try {
                        data.produce();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"生产者").start();



            new Thread(()->{
                for (int i = 0; i < 100; i++) {
                    try {
                        data.consumer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"消费者").start();
        }

    /**
     * 线程操作的资源
     */
    static class CommonData{

        private int number = 0;

        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        /**
         * 打印1
         * @throws Exception
         */
        public void produce() throws Exception{
            lock.lock();
            try {
                // 1. number等于0，才开始生产，不等于0，则生产者处于等待状态

                // 这里必须用while判断，否则可能产生虚假唤醒
                while(number != 0){
                    condition.await();
                }
                // 2. 等于0，则开始干活
                number++;
                System.out.println("生产者生产.... " + number);

                // 3. 生产者生产完了之后，需要通知唤醒消费者
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        /**
         * 打印0
         * @throws Exception
         */
        public void consumer() throws Exception{
            lock.lock();
            try {
                // 1. number ==0 ,生产者等待
                while(number == 0){
                    condition.await();
                }

                // 2. 如果number != 0，则消费者消费
                number--;
                System.out.println("消费者消费.... " + number);

                // 3. 消费者消费之后，通知唤醒生产者
                condition.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }



}
