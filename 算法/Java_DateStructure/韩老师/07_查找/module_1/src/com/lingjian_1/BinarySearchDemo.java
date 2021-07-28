package com.lingjian_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 递归二分查找
 * @author: Ling Jian
 * @date: 2020-01-08 09:40
 **/
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9};
//        int result = binarySearch1(arr, 5, 0, arr.length - 1);
//        System.out.println(result);
        List<Integer> list = binarySearch3(arr, 2, 0, arr.length - 1);
        System.out.println(list);

    }

    /**
     * 递归二分查找
     *
     * @param arr
     * @param value
     * @param left
     * @param right
     * @return
     */

    public static int binarySearch1(int[] arr, int value, int left, int right) {
        //考虑周全 所有的结束以及边界条件
        if (arr == null || arr.length < 1 || left > right || value > arr[right] || value < arr[0]) {
            return -1;
        }
        int mid = (left + right) >> 1;

        if (arr[mid] > value) {
            return binarySearch1(arr, value, left, mid - 1);
        } else if (arr[mid] < value) {
            return binarySearch1(arr, value, mid + 1, right);
        } else {
            return mid;
        }

    }

    //完善递归二分查找
    //若有相同的数据 全部找出
    public static List<Integer> binarySearch2(int[] arr, int value, int left, int right) {
        if (arr == null || arr.length < 1 || left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) >> 1;

        if (arr[mid] > value) {
            return binarySearch2(arr, value, left, mid - 1);
        } else if (arr[mid] < value) {
            return binarySearch2(arr, value, mid + 1, right);
        } else {
            List<Integer> list = new ArrayList<>();
            int temp = mid;
            while (--mid >= 0 && arr[mid] == value) {
                list.add(mid);
            }
            list.add(temp);
            while (++temp <= arr.length - 1 && arr[temp] == value) {
                list.add(temp);
            }
            return list;
        }

    }

    /**
     * 非递归完善二分查找
     *
     * @param arr
     * @param value
     * @param left
     * @param right
     * @return
     */
    public static List<Integer> binarySearch3(int[] arr, int value, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (value > arr[mid])
                left = mid + 1;
            else if (value < arr[mid])
                right = mid - 1;
            else {
                int temp = mid;
                List<Integer> list = new ArrayList<>();
                while (--mid >= 0 && arr[mid] == value) {
                    list.add(mid);
                }
                list.add(temp);
                while (++temp <= arr.length - 1 && arr[temp] == value) {
                    list.add(temp);
                }
                return list;
            }

        }

        return new ArrayList<Integer>();
    }


}
