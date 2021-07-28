package com.lingjian_3;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-01-02 09:44
 **/
public class loadDemo {

        public static void main(String[] args) throws Exception {
            Class c = Class.forName("com.lingjian_2.H");
            System.out.println(c.getClassLoader());
        }
    }

