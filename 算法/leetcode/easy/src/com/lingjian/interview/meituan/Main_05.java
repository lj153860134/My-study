package com.lingjian.interview.meituan;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-06 11:16
 **/
public class Main_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i <count ; i++) {
            nums[i] = sc.nextInt();
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <nums.length ; i++) {
            if(!list.contains(nums[i])){
                list.addFirst(nums[i]);
            }else{
                int index = list.indexOf(nums[i]);
                list.remove(index);
                list.addFirst(nums[i]);
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);

        }
    }
}
