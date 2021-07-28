package cn.lingjian_3;

import java.util.Arrays;

/**
 * @author lingjian
 * @date 2019-09-11 - 16:16
 */
public class SystemDemo4 {
    public static void main(String[] args) {
        int[] arr1={11,22,33,44,55};
        int[] arr2={6,7,8,9,0};
        System.arraycopy(arr1,1,arr2,2,3);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
