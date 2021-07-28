package com.lingjian_1;

/**
 * @description: 细胞分裂
 * @author: Ling Jian
 * @date: 2019-12-23 21:09
 **/
public class CellDemo {
    public static void main(String[] args) {
        System.out.println(cellCount(6));
    }

    public static int cellCount(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }if(n==3){
            return 3;
        }
        return cellCount(n-1)+cellCount(n-3);
    }
}
