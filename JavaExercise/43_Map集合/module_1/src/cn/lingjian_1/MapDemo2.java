package cn.lingjian_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lingjian
 * @date 2019/9/22 - 12:49 下午
 */
/*
* 对Map集合的遍历方式1
* */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,String> m=new HashMap<String,String>();
        m.put("凌健","徐小萌");
        m.put("王杰","凌立宏");
        m.put("王龙","陈旭");
        m.put("余垚博","雎学文");

        for (String s : m.keySet()) {
            System.out.println(s+"------"+m.get(s));

        }
    }
}
