package cn.lingjian_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author lingjian
 * @date 2019-09-16 - 10:24
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        String s1="凌健";
        String s2="徐小萌";
        String s3="王龙";
        String s4="王杰";
        String s5="凌立宏";
        c.add(s1);
        c.add(s2);
        c.add(s3);
        c.add(s4);
        c.add(s5);

        Iterator it=c.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
