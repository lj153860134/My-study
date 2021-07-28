package com.lingjian.pailie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定一个可包含重复数字的序列
 *               返回所有不重复的全排列
 * @author: Ling Jian
 * @date: 2020-08-26 14:50
 **/
public class Test_47 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,2};
        List<List<Integer>> list1 = permute1(nums);
        System.out.println(Arrays.toString(list1.toArray()));
        List<List<Integer>> list2 = permute2(nums);
        System.out.println(Arrays.toString(list2.toArray()));
    }




    //用一个额外的辅助空间
    static List<List<Integer>> res1 = new ArrayList<>();
    public static List<List<Integer>> permute1(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        process1(nums, list, visited);
        return res1;
    }

    public static void process1(int[] nums,LinkedList<Integer> list,boolean[] visited){
        if(nums.length==list.size()){
            res1.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i <nums.length ; i++) {
            if(visited[i]) continue;
            if(i>0&&nums[i]==nums[i-1]&&visited[i-1]) continue;

            visited[i] = true;
            list.add(nums[i]);
            process1(nums, list,visited);
            list.removeLast();
            visited[i] = false;
        }
    }



    //模板套路（中间的i可以不用了） 同上题解法
    static List<List<Integer>> res2 = new ArrayList<>();
    public static List<List<Integer>> permute2(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums, 0,list);
        return res2;
    }

    public static void dfs(int[] nums,int start,LinkedList<Integer> list){
        if(list.size()==nums.length){
//            System.out.println(Arrays.toString(list.toArray()));
            res2.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i <nums.length ; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.pollLast();
        }
    }


}
