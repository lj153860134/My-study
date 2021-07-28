package cn.lingjian_7;

/**
 * @author lingjian
 * @date 2019-08-21 - 15:45
 */

/*
 *String类的其他功能
 *
 * */

public class StringDemo {

    public static void main(String[] args) {
        String s = "helloworld";
        String s1 = s.replace('l', 't');
        System.out.println(s1);
        //替换字符串的特定字符
        System.out.println("------");

        String s2 = s.replace("world", "lingjian");
        System.out.println(s2);
        //替换字符串中的特定字符串
        System.out.println("------");

        String s3=" Hello  World   ";
        String s4=s3.trim();
        System.out.println(s3+"---");
        System.out.println(s4+"---");
        //去除字符串两端的空格
        System.out.println("------");

        String s5="hello";
        String s6="hello";
        String s7="abc";
        String s8="xyz";
        String s9="hel";
        System.out.println(s5.compareTo(s6));
        System.out.println(s5.compareTo(s7));
        System.out.println(s5.compareTo(s8));
        System.out.println(s5.compareTo(s9));
        //按字典顺序比较两个字符串

        //compare的源码
        /*public static int compareTo(byte[] value, byte[] other, int len1, int len2) {
            int lim = Math.min(len1, len2);
            for (int k = 0; k < lim; k++) {
                if (value[k] != other[k]) {
                    return getChar(value, k) - getChar(other, k);
                }
            }
            return len1 - len2;
        }*/



    }
}

