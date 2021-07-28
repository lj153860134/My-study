package com.lingjian_2;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-01-02 09:09
 **/
public class LoadDemo1 {
    public static void main(String[] args) throws Exception{
        Class c=Class.forName("com.lingjian_2.F");
        System.out.println(c.getClassLoader());
    }
}

class F{
    static {
        System.out.println("bootstrap F init");
    }
}