package cn.lingjian_4;

import java.util.Set;
import java.util.TreeMap;

/**
 * @author lingjian
 * @date 2019/9/24 - 8:49 上午
 */
public class TreeMapDemo1 {
    public static void main(String[] args) {
        TreeMap<String,String> tm=new TreeMap<String, String>();
        tm.put("hello","凌健");
        tm.put("world","徐小萌");
        tm.put("java","王杰");
        tm.put("hello","凌健");
        tm.put("javaee","陈旭");

        Set<String> set=tm.keySet();
        for (String s : set) {
            String value=tm.get(s);
            System.out.println(s+"------"+value);

        }

        }
    }

