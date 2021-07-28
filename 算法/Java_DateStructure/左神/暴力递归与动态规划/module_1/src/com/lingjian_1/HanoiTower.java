package com.lingjian_1;

/**
 * @description: 汉诺塔问题
 * @author: Ling Jian
 * @date: 2019-12-23 20:00
 **/
public class HanoiTower {
    public static void main(String[] args) {
//        hanoid(3,'a','b','c');
        process(3, "左", "右", "中");
    }

    /**
     * @description: 将n个圆盘从a经由b移动到c
     * @param: [n, a, b, c]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/9 9:52 上午
     */
    public static void hanoid(int n, char a, char b, char c) {
        if (n == 0) {
            return;
        }
        //将n-1个圆盘从a经由c移动到b
        hanoid(n - 1, a, c, b);
        //将a底下最大的圆盘移到c
        move(a, c);
        //将n-1个圆盘从b经由a移动到c
        hanoid(n - 1, b, a, c);


    }

    private static void move(char a, char b) {
        System.out.printf("%c->%c\n", a, b);
    }

    //左神实现
    public static void process(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("Move " + n + " from " + from + " to " + to);
            return;
        } else {
            process(n - 1, from, help, to);
            System.out.println("Move " + n + " from " + from + " to " + to);
            process(n - 1, help, to, from);
        }
    }
}
