package com.lingjian.interview.huawei;

import java.util.*;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-03 10:53
 **/
public class Main_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int road = sc.nextInt();
        int count = sc.nextInt();
        int[][] nums = new int[city+1][city + 1];
        for (int i = 0; i <nums.length ; i++) {
            Arrays.fill(nums[i], Integer.MAX_VALUE);
        }
//        for (int i = 0; i <nums.length ; i++) {
//            nums[i][i] = 0;
//        }
        for (int i = 0; i < road; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int temp = sc.nextInt();
            nums[m][n] = temp;
            nums[n][m] = temp;
        }
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        for (int i = 0; i <count ; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
//            System.out.println("++++");
            int res = solution(nums, m, n);
            System.out.print(res+" ");
        }

    }

    public static int solution(int[] []nums,int i,int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        int res=0;
        List<Integer> list = new ArrayList<>();
        List<Integer> road = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = size; k >0 ; k--) {
                int temp = queue.poll();
                road.add(temp);
                for (int l = 0; l <nums[temp].length ; l++) {
                    if (nums[i][l] != Integer.MAX_VALUE&&!road.contains(l)) {
                        queue.add(l);
                        res += nums[i][l];
                        if(l==j){
                            list.add(res);
                        }
                    }
                    }
                }
            }
        Collections.sort(list);
        return list.size() >= 1 ? list.get(0) : -1;
    }

}
