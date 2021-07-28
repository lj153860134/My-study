package com.lingjian.interview.jingdian;

import java.util.*;

/**
 * @description: 你正在使用一堆木板建造跳水板
 *               有两种类型的木板
 *               其中长度较短的木板长度为shorter
 *               长度较长的木板长度为longer
 *               你必须正好使用k块木板
 *               编写一个方法，生成跳水板所有可能的长度
 * @author: Ling Jian
 * @date: 2020-07-08 15:19
 **/
public class Test_16_11 {
    public static void main(String[] args) {
        int shorter=1;
        int longer=2;
        int k=3;
        int[] res = divingBoard(shorter, longer, k);
        System.out.println(Arrays.toString(res));

    }

    //暴力递归
    public static int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{0};
        }
        if(k==1){
            return new int[]{shorter, longer};
        }
        if(shorter==longer){
            int[] res = new int[k];
            for (int i = 1; i <=k ; i++) {
                res[i - 1] = i * k;
            }
            return res;
        }
       int[] res = process(shorter, longer, k);
        return res;

    }

    public static int[] process(int shorter,int longer,int k){
        if(k==1){
            return new int[]{shorter, longer};
        }
        int[] res = process(shorter, longer, k - 1);
        HashSet<Integer> set = new HashSet<>();
        for (int i : res) {
            set.add(i + shorter);
            set.add(i + longer);
        }
        int[] num = new int[set.size()];
        int index=0;
        for (Integer integer : set) {
            num[index++] = integer;
        }
        return num;
    }



}
