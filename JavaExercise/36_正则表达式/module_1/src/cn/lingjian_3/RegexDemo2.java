package cn.lingjian_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lingjian
 * @date 2019-09-11 - 11:14
 */
/*
* Pattern类和Matcher类的获取功能
* 需求：获取字符串中用三个字符组成的单词
* */
public class RegexDemo2 {
    public static void main(String[] args) {
        String s="da jia hao,jin tian tian qi bu hao";
        String regex="\\b\\w{3}\\b"; //运用单词边界\\b
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(s);
//        boolean flag=m.find();
//        System.out.println(flag);
//        String ss=m.group();
        //用循环做
        while(m.find()){
            System.out.println(m.group());
        }

    }
}
