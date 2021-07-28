package cn.lingjian_4;

import java.util.HashSet;
import java.util.Random;

/**
 * @author lingjian
 * @date 2019/9/21 - 11:08 上午
 */
/*
* 产生10个1-20之间的随机数要求随机数不能重复案例
*
* */
public class HashSetDemo1 {
    public static void main(String[] args) {
        Random r=new Random();
        HashSet<Integer> hs = new HashSet<Integer>();
        while (hs.size() <10) {
            Integer num = Integer.valueOf(r.nextInt(20)+1);
            hs.add(num);
        }
        for (Integer h : hs) {
            System.out.println(h);

        }
    }
}
