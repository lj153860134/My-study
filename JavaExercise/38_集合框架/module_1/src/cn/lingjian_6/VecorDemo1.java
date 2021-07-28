package cn.lingjian_6;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author lingjian
 * @date 2019-09-17 - 09:41
 */
public class VecorDemo1 {
    public static void main(String[] args) {
        Vector v=new Vector();
        //Vector的特有添加功能
        v.addElement("hello");
        v.addElement("world");
        v.addElement("java");

        //方式1（for循环遍历Vector）
        for (int i = 0; i <v.size() ; i++) {
            String s=(String) v.elementAt(i);
            System.out.println(s);
        }
        System.out.println("--------");
        //方式2（通过Vector特有的获取功能遍历 类似于迭代器）

        Enumeration en=v.elements();
        while(en.hasMoreElements()){
            String s1=(String)en.nextElement();
            System.out.println(s1);
        }
    }
}
