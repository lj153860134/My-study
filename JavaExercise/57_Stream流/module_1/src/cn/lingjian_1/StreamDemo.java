package cn.lingjian_1;

import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019/11/6 - 9:57 上午
 */
/*
* 创建一个集合 存储多个字符串元素
* 把集合中所有以“张”开头的元素存储到一个新的集合
* 把“张”开头的集合中的长度为3的元素存储到一个新的集合
* 遍历上一步得到的集合
*
* */
public class StreamDemo {
    public static void main(String[] args) {
        //创建集合
        ArrayList<String> list1=new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();
        ArrayList<String> list3=new ArrayList<>();

        //添加元素
        list1.add("凌健");
        list1.add("凌立宏");
        list1.add("凌兆永");
        list1.add("凌兆俊");
        list1.add("张静");

        //把集合中所有以“张”开头的元素存储到一个新的集合
        for (String s : list1) {
            if(s.startsWith("凌"))
                list2.add(s);
        }

        //把“张”开头的集合中的长度为3的元素存储到一个新的集合
        for (String s : list2) {
            if(s.length()==3)
                list3.add(s);
        }

        //遍历获得的集合
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        //Stream流来改进
//        list1.stream().filter(s -> s.startsWith("凌")).filter(s -> s.length()==3).forEach(s -> System.out.println(s));
        list1.stream().filter(s -> s.startsWith("凌")).filter(s -> s.length()==3).forEach(System.out::println);


    }
}
