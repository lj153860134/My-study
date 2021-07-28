package cn.lingjian_6;

/**
 * @author lingjian
 * @date 2019-08-21 - 14:20
 */

/*i
*
* String类的转换功能
* */
public class StringDemo {
    public static void main(String[] args) {
        String s="HelloWorld";
        byte[] bytes=s.getBytes();
        for (int i = 0; i <bytes.length ; i++) {
            System.out.print(bytes[i]+" ");
        }
        //把字符串转换为字节数组
        System.out.println();
        System.out.println("------");

        char[] chs=s.toCharArray();
        for (int i = 0; i <chs.length ; i++) {
            System.out.print(chs[i]+" ");
        }
        //把字符串转换为字符数组
        System.out.println();
        System.out.println("------");

        String s1=String.valueOf(chs); //静态方法 直接用String类名调用
        System.out.println(s1);
        //把字符数组转换为字符串
        System.out.println("------");

        String s2=String.valueOf(12334321);
        System.out.println(s2);
        //把int类型的数据转换成字符串
        System.out.println("-------");

        System.out.println(s.toLowerCase());
        //把字符串转换为小写
        System.out.println("------");

        System.out.println(s.toUpperCase());
        //把字符串转换为大写
        System.out.println("------");

        System.out.println(s.concat("lingjian"));
        //把字符串拼接在一起
        System.out.println("------");
    }

}
