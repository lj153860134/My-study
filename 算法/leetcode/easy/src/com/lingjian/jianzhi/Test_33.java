package com.lingjian.jianzhi;

/**
 * @description: 输入一个整数数组
 *               判断该数组是不是某二叉搜索树的后序遍历结果
 *               如果是则返回 true，否则返回 false
 *               假设输入的数组的任意两个数字都互不相同
 * @author: Ling Jian
 * @date: 2020-06-28 16:46
 **/
public class Test_33 {
    public static void main(String[] args) {

    }
    //有点像二分法
    public boolean verifyPostorder(int[] postorder) {

        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i > j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


}
