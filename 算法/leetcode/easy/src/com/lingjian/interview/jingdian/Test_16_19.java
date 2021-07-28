package com.lingjian.interview.jingdian;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: 你有一个用于表示一片土地的整数矩阵land
 *               该矩阵中每个点的值代表对应地点的海拔高度
 *               若值为0则表示水域
 *               由垂直、水平或对角连接的水域为池塘
 *               池塘的大小是指相连接的水域的个数
 *               编写一个方法来计算矩阵中所有池塘的大小
 *               返回值需要从小到大排序。
 * @author: Ling Jian
 * @date: 2020-09-02 15:26
 **/
public class Test_16_19 {
    public static void main(String[] args) {
        int[] [] land=new int[][]
                {{0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}};
        int[] res = pondSizes(land);
        System.out.println(Arrays.toString(res));

    }

    static int cnt;
    public static int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(land[i][j]==0){
                    cnt=0;
                    dfs(land,i,j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        int[] res = new int[list.size()];
        for (int i = 0; i <res.length ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void dfs(int[][] land,int i,int j){
        if(i<0||i>=land.length||j<0||j>=land[0].length||land[i][j]!=0){
            return;
        }
        land[i][j] = -1;
        cnt++;
        for (int k = -1; k <=1 ; k++) {
            for (int l = -1; l <=1 ; l++) {
                if(k==0&&l==0) continue;
                dfs(land, i + k, j + l);
            }
        }
    }

}
