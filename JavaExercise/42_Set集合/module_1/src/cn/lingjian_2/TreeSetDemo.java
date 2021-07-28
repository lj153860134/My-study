package cn.lingjian_2;

import java.util.TreeSet;

/**
 * @author lingjian
 * @date 2019/9/20 - 9:48 下午
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts=new TreeSet<Integer>();
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);

        for (Integer t : ts) {
            System.out.println(t);

        }
    }
}
