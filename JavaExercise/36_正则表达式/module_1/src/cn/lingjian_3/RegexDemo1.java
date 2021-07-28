package cn.lingjian_3;

import java.util.regex.*;
/**
 * @author lingjian
 * @date 2019-09-11 - 10:56
 */
/*
* Pattern和Matcher类的使用（判断功能）
*
* */
public class RegexDemo1 {
    public static void main(String[] args) {
        //模式和匹配器的典型调用顺序（判断功能）
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();

        //一步到位
        boolean b1=Pattern.compile("a*b").matcher("aaaaab").matches();
        //直接用String来进行判断功能(就判断功能 该方法方便）
        String s="aaaaab";
        String regex="a*b";
        boolean b2=s.matches(regex);

        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);


    }
}
