package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-09-05 - 10:55
 */
/*
*  正则表达式的分割功能
* String 类的public String[] split(String regex)
*
* */
public class RegexDemo4 {
    public static void main(String[] args) {
        String s="18-24";
        String regex="-";
        String[] stringArray=s.split(regex);
        for (int i = 0; i <stringArray.length ; i++) {
            System.out.println(stringArray[i]);
        }
        int startAge=Integer.parseInt(stringArray[0]);
        int endAge=Integer.parseInt(stringArray[1]);
        System.out.println(startAge+" "+endAge);

    }
}
