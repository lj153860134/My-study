package cn.lingjian_2;

import java.util.HashMap;

/**
 * @author lingjian
 * @date 2019/9/22 - 3:58 下午
 */
public class HashMapDemo1 {
    public static void main(String[] args) {
        HashMap<String,String> hm=new HashMap<String,String>();
        hm.put("凌健","徐小萌");
        hm.put("王杰","凌立宏");
        hm.put("王龙","陈旭");
        hm.put("余垚博","雎学文");

        for (String s : hm.keySet()) {
            System.out.println(s+"------"+hm.get(s));
        }


    }
}
