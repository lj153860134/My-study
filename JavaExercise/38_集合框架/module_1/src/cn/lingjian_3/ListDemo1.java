package cn.lingjian_3;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lingjian
 * @date 2019-09-16 - 10:34
 */
public class ListDemo1 {
    public static void main(String[] args) {
        List list=new ArrayList();
        String s1="凌健";
        String s2="徐小萌";
        String s3="王龙";
        String s4="王杰";
        String s5="凌立宏";
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        Iterator it=list.iterator();
        while(it.hasNext()){
            System.out.println((String)(it.next()));
        }
    }
}
