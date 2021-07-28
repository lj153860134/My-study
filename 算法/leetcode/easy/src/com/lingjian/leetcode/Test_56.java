package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给出一个区间的集合，请合并所有重叠的区间。
 * @author: Ling Jian
 * @date: 2020-08-25 10:32
 **/
public class Test_56 {
    public static void main(String[] args) {
        int[][] intervals=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
//        List<int[]> res = merge(intervals);
//        for (int[] re : res) {
//            System.out.println(re[0] + "===" + re[1]);
//        }

    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i <intervals.length ;i++ ) {

            int[] nums = new int[2];
            nums[0]=intervals[i][0];
            nums[1] = intervals[i][1];
            for (int j = i+1; j <intervals.length ;j++) {
                if(nums[1]>=intervals[j][0]){
                    nums[1]=intervals[j][1];
                    i=j;
                }else {
                    i = j-1;
                    break;
                }

            }
            list.add(nums);
        }
        int[][] res=new int[list.size()][2];
        int index=0;
        for (int[] re : list) {
            res[index][0] = re[0];

            res[index++][1] = re[1];

        }
        return res;

    }
    //简单方法
    public static int[][] merge1(int[][] intervals) {
        int len=intervals.length;
        if (len<2) return intervals;

        int cnt=0;
        for (int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(intervals[i][0]<=intervals[j][1]&&intervals[i][1]>=intervals[j][0]){
                    intervals[j][0]=Math.min(intervals[i][0],intervals[j][0]);
                    intervals[j][1]=Math.max(intervals[i][1],intervals[j][1]);
                    intervals[i]=null;
                    cnt++;
                    break;
                }
            }
        }
        int[][]res=new int [len-cnt][2];
        int ri=0;
        for(int[]pair:intervals){
            if(pair!=null){
                res[ri++]=pair;
            }
        }
        return res;

    }
}
