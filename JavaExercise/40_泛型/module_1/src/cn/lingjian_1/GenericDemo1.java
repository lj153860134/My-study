package cn.lingjian_1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lingjian
 * @date 2019-09-17 - 14:57
 */
/*
 * ArrayList存储字符串并遍历
 *
 * */
public class GenericDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");
//        list.add(10);//自动装包成integer的引用类型
        //等价于list.add(Integer.valueOf(10))


        //遍历
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
//            String s=(String)it.next();
//            System.out.println(s);
            System.out.println(it.next());//运用泛型 也不需要强转类型了
        }
        System.out.println("--------");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

