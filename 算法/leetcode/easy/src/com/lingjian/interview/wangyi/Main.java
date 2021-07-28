package com.lingjian.interview.wangyi;

import com.sun.xml.internal.xsom.impl.ForeignAttributesImpl;

import java.util.*;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-05 16:51
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> zheng = new ArrayList<>();
        List<Integer> fu = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num > 0) {
                zheng.add(num);
            } else {
                fu.add(num);
            }
        }
        List<Integer> res = new ArrayList<>();
        Collections.sort(zheng, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(fu);
        int size1 = zheng.size();
        int size2 = fu.size();
        int size = Math.min(size1, size2);
        boolean flag = size == size1 ? false : true;
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < size; i++) {
            if(flag){
            res.add(zheng.get(p1++));
            res.add(fu.get(p2++));
            }else{
                res.add(fu.get(p2++));
                res.add(zheng.get(p1++));
            }
        }

        if (size1 > size2) {
            int temp = size1 - 1;
            while (temp >= size) {
                res.add(zheng.get(temp--));
            }
        } else if (size1 < size2) {
            int temp = size2 - 1;
            while(temp>=size) {
                res.add(fu.get(temp--));
            }
        }
        for (Integer re : res) {
            System.out.print(re+" ");
        }


    }
}

