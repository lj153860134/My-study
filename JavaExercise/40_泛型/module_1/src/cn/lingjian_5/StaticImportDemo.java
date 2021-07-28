package cn.lingjian_5;

/**
 * @author lingjian
 * @date 2019-09-17 - 20:30
 */
/*
* 见笔记 意义不大 一般不用
* */
public class StaticImportDemo {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        int result= sum(a, b);
    }

    public static int sum(int a, int b) {
        return a+b;
    }
}
