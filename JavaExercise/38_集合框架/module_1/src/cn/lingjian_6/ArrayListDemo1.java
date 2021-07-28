package cn.lingjian_6;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lingjian
 * @date 2019-09-17 - 09:27
 */
/*
* ArrayList存储字符串并遍历
*
* */
public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList array=new ArrayList();//创建集合对象
        array.add("hello");             //创建元素对象，并添加元素
        array.add("world");
        array.add("java");
        //遍历方式1（用迭代器遍历）
        Iterator it=array.iterator();
       while(it.hasNext()){
           String s=(String)it.next();
           System.out.println(s);
       }
        System.out.println("--------");
       //遍历方式2（for循环 直接用集合遍历）
        for (int i = 0; i <array.size() ; i++) {
            String s=(String) array.get(i);
            System.out.println(s);
        }
    }
}
