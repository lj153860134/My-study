package com.lingjian_1_digui;

/**
 * @description: 求数组中每个数左边比当前数小的数累加起来的和
 * @author: Ling Jian
 * @date: 2019-12-10 16:48
 **/
public class SmallSumDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 5};
//        System.out.println(myMethod(arr));
        System.out.println(mergeMethod(arr));
    }

    /**
     * @description: 我的方法（无递归）
     * @param: [arr]
     * @return: int
     * @author: Ling Jian
     * @date: 2019/12/11 10:50 上午
     */
    public static int myMethod(int[] arr) {
        int sum = 0;      //最终求得小和的结果  返回值
        int count;    //计算自己比右边小的次数
        for (int i = 0; i < arr.length - 1; i++) {
            count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    count++;
                }
            }
            sum += count * arr[i];

        }

        return sum;
    }

    /**
     * @description: 用归并的思想（分治法 递归）来求解
     * @param: [arr]
     * @return: void
     * @author: Ling Jian
     * @date: 2019/12/10 5:11 下午
     */
    public static int mergeMethod(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return setProcess(arr, 0, arr.length - 1);
    }

    public static int setProcess(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1); //这里后面一定要加括号

        return setProcess(arr, left, mid) +
                setProcess(arr, mid + 1, right) +
                merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int p = 0;
        int res = 0;  //返回值
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                res += arr[p1] * (right - p2 + 1);
                help[p++] = arr[p1++];
            } else {
                help[p++] = arr[p2++];
//            res+=arr[p1]<arr[p2]?arr[p1]*(right-p2+1):0;
//            help[p++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[p++] = arr[p1++];
        }

        while (p2 <= right) {
            help[p++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

        return res;
    }


}
