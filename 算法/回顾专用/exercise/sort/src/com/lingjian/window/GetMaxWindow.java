package com.lingjian.window;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description: 滑动窗口最大值 （单调双向队列）
 * @author: Ling Jian
 * @date: 2020-05-20 16:53
 **/
public class GetMaxWindow {
    public static void main(String[] args) {
        int[] arr=new int[]{4,3,5,4,3,3,6,7};
        int windowLength=3;
        int[] res = getMax(arr, windowLength);
        System.out.println(Arrays.toString(res));
    }

    private static int[] getMax(int[] arr, int w) {
        if (arr == null || w < 1 || w > arr.length) {
            return null;
        }
        int index=0;
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <arr.length ; i++) {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                list.pollLast();
            }
            list.offerLast(i);

            if (list.peekFirst() == i - w) {
                list.pollFirst();
            }
            if (i >=w-1) {
                res[index++] = arr[list.peekFirst()];
            }

        }
        return res;

    }
}
