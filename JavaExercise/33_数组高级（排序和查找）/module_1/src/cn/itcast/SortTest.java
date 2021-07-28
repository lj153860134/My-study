package cn.itcast;

import java.util.Arrays;

/**
 * @author lingjian
 * @date 2019-09-02 - 15:44
 */
public class SortTest {

        /*
         * 交换数组中的两个元素
         */
        public static void swap(int[] data, int i, int j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }
