package cn.lingjian_5;

import java.util.HashMap;
import java.util.Set;

/**
 * @author lingjian
 * @date 2019/9/24 - 9:19 上午
 */

/*
*   "aababcabcdabcde" 获取字符串中每一个字母出现的次数
*   要求结果为a(5)b(4)c(3)d(2)e(1)
*
* */
public class MapTestDemo1 {
    public static void main(String[] args) {
        HashMap<Character,Integer> hm =new HashMap<Character,Integer>();
        String s="afgababcabcdabcde";
        char[] charArray=s.toCharArray();
        for (int i = 0; i <charArray.length ; i++) {
            if (hm.containsKey(charArray[i])) {
                hm.put(charArray[i], hm.get(charArray[i]) + 1);

            } else {
                hm.put(charArray[i], 1);

            }
        }
        StringBuilder sb=new StringBuilder();
            Set<Character> set=hm.keySet();
            for (Character ch : set) {
               sb.append(ch).append("(").append(hm.get(ch)).append(")");
            }
        System.out.println(sb);

            }

        }


