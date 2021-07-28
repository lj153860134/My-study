package com.lingjian_1;


/**
 * @description: StringTable垃圾回收
 * @author: Ling Jian
 * @date: 2019-12-26 14:42
 **/
public class Demo2 {
    public static void main(String[] args) {
        int i = 0;
        try {
            for (int j = 0; j < 260000; j++) {
                String.valueOf(j).intern();
                i++;
            }
            Thread.sleep(30000);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
