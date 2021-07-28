package cn.lingjian_7;

import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019/9/18 - 10:02 上午
 */
/*
* 需求：获取10个1到20的随机数，要求不能重复
*
* */
public class ArrayListDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<Integer>();
//        int count=0;
        while(list.size()<10){
           Integer number=(int)(Math.random()*20)+1;
           if(!list.contains(number)){
               list.add(number);
//               count++;
           }
        }
        for (Integer integer : list) {
            System.out.println(integer);

        }
    }
}
