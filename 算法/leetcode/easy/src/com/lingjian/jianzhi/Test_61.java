package com.lingjian.jianzhi;

import java.util.HashSet;

/**
 * @description: 从扑克牌中随机抽5张牌
 *               判断是不是一个顺子
 *               即这5张牌是不是连续的
 *               2～10为数字本身
 *               A为1，J为11，Q为12，K为13，而大、小王为 0
 *               可以看成任意数字。A不能视为14
 * @author: Ling Jian
 * @date: 2020-07-07 16:24
 **/
public class Test_61 {
    public static void main(String[] args) {

    }

    public boolean isStraight(int[] nums) {
        int max=0;
        int min=14;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(num==0) continue;
            max=Math.max(max,num);
            min=Math.min(min,num);
            if(set.contains(num))
                return false;
            else
                set.add(num);

        }
        return max-min<5;

    }
}
