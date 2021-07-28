package cn.lingjina_5;

/**
 * @author lingjian
 * @date 2019-08-21 - 10:45
 */
/*
 *  需求：遍历获取字符串的每一个字符
 *  分析：
 *      A:如何能够拿到每一个字符呢
 *        用for循环
 * */
public class StringTest {
    public static void main(String[] args) {
        String s = "helloworld";
        for (int i = 0; i < s.length(); i++) {

            System.out.print(s.charAt(i) + " ");
        }
    }
}
