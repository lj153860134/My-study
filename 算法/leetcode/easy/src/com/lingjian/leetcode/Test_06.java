package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字符串Z字形变换
 * @author: Ling Jian
 * @date: 2020-05-26 16:36
 **/
public class Test_06 {
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        String str = convert(s, numRows);
        System.out.println(str);
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}
