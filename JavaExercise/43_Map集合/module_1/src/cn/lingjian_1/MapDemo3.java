package cn.lingjian_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lingjian
 * @date 2019/9/22 - 3:28 下午
 */
/*
* 对Map集合的遍历方式2
* */
public class MapDemo3 {
    public static void main(String[] args) {
        Map<String,String> m=new HashMap<String,String>();
        m.put("凌健","徐小萌");
        m.put("王杰","凌立宏");
        m.put("王龙","陈旭");
        m.put("余垚博","雎学文");

        Set<Map.Entry<String,String>> set= m.entrySet();
        for (Map.Entry<String, String> s : set) {
            System.out.println(s.getKey()+"------"+s.getValue());

        }
    }
}
