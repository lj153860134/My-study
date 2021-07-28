package cn.lingjian_4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lingjian
 * @date 2019-09-17 - 19:58
 */
public class ForDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        for (int i : arr) {
            System.out.println(i);
        }

        String[] strArray={"凌健","徐小萌","王杰","王龙"};
        for (String s : strArray) {
            System.out.println(s);
        }

        ArrayList<String> list=new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");
        for (String s : list) {
            System.out.println(s);
        }

        List<String> list1=null;
        for (String s : list1) {
            System.out.println(s);
        }
    }
}
