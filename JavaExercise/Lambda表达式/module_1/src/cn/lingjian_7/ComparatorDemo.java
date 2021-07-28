package cn.lingjian_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author lingjian
 * @date 2019/11/5 - 3:07 下午
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<String> array=new ArrayList<>();
        array.add("凌健");
        array.add("徐小萌");
        array.add("王龙");
        array.add("凌健王杰");
        System.out.println(array);

        //进行自然排序
        Collections.sort(array);
        System.out.println(array);

        //进行比较器排序
        Collections.sort(array,getComparator());
        System.out.println(array);

    }

    private static Comparator<String> getComparator(){
//        Comparator<String> c=new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length()-s2.length();
//            }
//        };
//        return c;

//        return new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length()-s2.length();
//            }
//        };
        //Lambda表达式
        return ((s1,s2)->s1.length()-s2.length());
    }
}
