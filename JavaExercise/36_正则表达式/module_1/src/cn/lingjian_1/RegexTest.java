package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-09-05 - 11:14
 */
/*
* 分割功能练习
*
* */
public class RegexTest {
    public static void main(String[] args) {
        String s1="aa,bb,cc";
        String[] stringArray1=s1.split(",");
        for (int i = 0; i <stringArray1.length ; i++) {
            System.out.println(stringArray1[i]);
        }

        System.out.println("--------");
        String s2="aa.bb.cc";
        String[] stringArray2=s2.split("\\.");
        for (int i = 0; i <stringArray2.length ; i++) {
            System.out.println(stringArray2[i]);
        }

        System.out.println("--------");
        String s3="aa   bb         cc";
        String[] stringArray3=s3.split(" +");
        for (int i = 0; i <stringArray3.length ; i++) {
            System.out.println(stringArray3[i]);
        }

        System.out.println("--------");
        String s4="E:\\lingjian\\itcast\\lj";
        String[] stringArray4=s4.split("\\\\");//这里面是没有空格的
        for (int i = 0; i <stringArray4.length ; i++) {
            System.out.println(stringArray4[i]);
        }
    }
}
