package com.lingjian_2;

/**
 * @description: 递归汉诺塔
 * @author: Ling Jian
 * @date: 2019-12-09 09:51
 **/
public class HanoidDemo {
    public static void main(String[] args) {
        hanoid(3,'a','b','c');
        process(3,"a","c","b");
    }
    /**
    * @description: 将n个圆盘从a经由b移动到c
    * @param: [n, a, b, c]
    * @return: void
    * @author: Ling Jian
    * @date: 2019/12/9 9:52 上午
    */
    public static void hanoid(int n,char a,char b,char c){
        if(n==0){
            return;
        }
        //将n-1个圆盘从a经由c移动到b
        hanoid(n-1,a,c,b);
        //将a底下最大的圆盘移到c
        move(a,c);
        //将n-1个圆盘从b经由a移动到c
        hanoid(n-1,b,a,c);


    }

    private static void move(char a,char b) {
        System.out.printf("%c->%c\n",a,b);
    }

    //左神实现
    public static void process(int n,String from,String to,String help){
        if(n==1){
            System.out.println("Move "+n+" from "+from+" to "+to);
            return;
        }
            process(n-1,from,help,to);
            System.out.println("Move "+n+" from "+from+" to "+to);
            process(n-1,help,to,from);

    }
}
