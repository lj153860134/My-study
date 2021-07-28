package com.lingjian.window;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 二维数组最大矩阵为1的面积
 * @author: Ling Jian
 * @date: 2020-05-23 08:34
 **/
public class GetMaxArea {
    public static void main(String[] args) {
        int[][] map = new int[][]{{3,4,4,4,4,4,4,2,2,2,2,2}};
        int res = getArea(map);
        System.out.println(res);
    }

    private static int getArea(int[][] map) {
        if (map == null) {
            return 0;
        }
        int maxArea=0;
        for (int i = 0; i <map.length ; i++) {
            int[] help = new int[map[0].length];
            for (int j = 0; j <help.length ; j++) {
                if(i==0){
                    help[j] = map[0][j];
                }else{
                    help[j] = map[i][j] == 0 ? 0 : map[i - 1][j] + 1;
                }

            }
            System.out.println(Arrays.toString(help));
            maxArea=Math.max(getArrArea(help),maxArea);
            System.out.println(maxArea);
        }
        return maxArea;
    }

    private static int getArrArea(int[] arr) {
        int curArea=0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <arr.length ; i++) {
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                int R=stack.pop();
                int L = stack.isEmpty() ? -1 : stack.peek();
                curArea =Math.max ((i - L - 1) * arr[R],curArea);
                System.out.println(curArea);
            }
            stack.push(i);
        }
            while(!stack.isEmpty()){
                int R = stack.pop();
                int L = stack.isEmpty() ? -1 : stack.peek();
                curArea =Math.max ((arr.length - L - 1) * arr[R],curArea);
            }
        return curArea;
    }
}
