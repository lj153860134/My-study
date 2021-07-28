package com.lingjian.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-05-09 09:33
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 1; i <= 4; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t出去了");
                countDownLatch.countDown();
               },NameEnum.forEach_NameEnum(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 人全都出去了");

    }
}

enum NameEnum {
    ONE(1,"凌健"),TWO(2,"徐小萌"),THREE(3,"王龙"), FOUR(4, "陈旭");

    private Integer num;
    private String name;

    NameEnum(Integer num, String name) {
        this.num = num;
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public static NameEnum forEach_NameEnum(int index) {
        NameEnum[] values = NameEnum.values();
        for (NameEnum value : values) {
            if (index == value.getNum()) {
                return value;
            }

        }
        return null;
    }
}
