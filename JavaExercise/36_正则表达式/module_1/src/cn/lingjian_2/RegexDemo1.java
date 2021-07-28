package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-09-11 - 10:30
 */
/*
* 正则表达式的替换功能
*
* */
public class RegexDemo1 {
    public static void main(String[] args) {
        String s="hello123world456";
        String regex="\\d+";
        String result=s.replaceAll(regex,"*");//可以直接写"\\d+"
        System.out.println(result);
    }
}
