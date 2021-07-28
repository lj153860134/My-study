package cn.lingjian_6;

import java.util.HashMap;
import java.util.Set;

/**
 * @author lingjian
 * @date 2019/9/24 - 10:35 上午
 */

/*
* HashMap嵌套HashMap
*  1班  凌健   25
*       徐小萌 24
*  2班  王杰   26
*       凌立宏 25
*
* */
public class HashMapDemo1 {
    public static void main(String[] args) {
        HashMap<String,HashMap<String,Integer>> hm=new HashMap<String,HashMap<String,Integer>>();
        HashMap<String,Integer> hmClass1=new HashMap<String,Integer>();
        HashMap<String,Integer> hmClass2=new HashMap<String,Integer>();

        hmClass1.put("凌健",25);
        hmClass1.put("徐小萌",24);

        hmClass2.put("王杰",26);
        hmClass2.put("凌立宏",25);

        hm.put("1班",hmClass1);
        hm.put("2班",hmClass2);

        Set<String> hmSet=hm.keySet();
        for (String s : hmSet) {
            System.out.println(s);
            Set<String> hmClassSet=hm.get(s).keySet();
            for (String s1 : hmClassSet) {
                System.out.println("\t"+s1+"------"+hm.get(s).get(s1));
            }

        }


    }
}
