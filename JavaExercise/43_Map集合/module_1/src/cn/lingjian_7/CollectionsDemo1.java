package cn.lingjian_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lingjian
 * @date 2019/9/24 - 2:23 下午
 */
public class CollectionsDemo1 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(30);
        list.add(20);
        list.add(50);
        list.add(10);
        list.add(40);

        System.out.println(list);
        System.out.println("--------");
        Collections.sort(list); //排序
        System.out.println(list);


    }
}
