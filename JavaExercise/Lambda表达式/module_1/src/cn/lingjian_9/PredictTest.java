package cn.lingjian_9;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author lingjian
 * @date 2019/11/5 - 4:53 下午
 */
public class PredictTest {
    public static void main(String[] args){
        String[] strArray={"凌健,25","徐小萌,24","王杰,30"};
        ArrayList<String> array=myFilter(strArray,s -> s.split(",")[0].length()>=2,
                s->Integer.parseInt(s.split(",")[1])<=25);
        System.out.println(array);

    }

    private static ArrayList<String> myFilter(String[] strArray, Predicate<String> pre1,Predicate<String> pre2){
        ArrayList<String> array=new ArrayList<String>();
        //遍历数组
        for (String s : strArray) {
           if (pre1.and(pre2).test(s)){
               array.add(s);
           }
        }
        return array;
    }
}
