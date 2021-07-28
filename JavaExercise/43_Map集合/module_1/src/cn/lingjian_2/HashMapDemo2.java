package cn.lingjian_2;

import java.util.HashMap;

/**
 * @author lingjian
 * @date 2019/9/22 - 4:14 下午
 */
public class HashMapDemo2 {
    public static void main(String[] args) {
        HashMap<Integer,String> hm=new HashMap<Integer, String>();
        hm.put(1,"凌健");
        hm.put(2,"徐小萌");
        hm.put(3,"王杰");
        hm.put(4,"王龙");
        hm.put(5,"凌立宏");

        for (Integer i : hm.keySet()) {
            System.out.println(i+"------"+hm.get(i));
        }
    }
}
