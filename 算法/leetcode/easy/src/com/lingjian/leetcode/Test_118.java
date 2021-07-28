package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个非负整数 numRows
 *               生成杨辉三角的前 numRows 行
 * @author: Ling Jian
 * @date: 2020-08-24 23:45
 **/
public class Test_118 {
    public static void main(String[] args) {
        int num=1;
        List<List<Integer>> res = generate(num);

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for (int i=0;i<numRows;i++){
            ArrayList<Integer> sub=new ArrayList<Integer>();
            for (int j=0;j<=i;j++){
                //第一个位置和最后一个位置的元素为1
                if (j==0 || j==i){
                    sub.add(1);
                }else {
                    //上一行的元素进行相加
                    sub.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(sub);

        }
        return result;

    }
}
