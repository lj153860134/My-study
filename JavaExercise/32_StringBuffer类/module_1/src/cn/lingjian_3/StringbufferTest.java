package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019-08-30 - 10:26
 */
/*
* 练习1 ：String和StringBuffer的相互转换
* 分析：  A:String转换成StringBuffer
*        方式1：可以通过StringBuffer的构造方法
*        方式2：还可以通过append转换
*       B:StringBuffer转String
*        方式1：可以通过StringBuffer的截取功能
*        方式2：通过构造方法
*        方式3：通过toString
*
* */
public class StringbufferTest {
    public static void main(String[] args) {
        String s1="lingjian";
        System.out.println(s1);
       StringBuffer sb1= stringToSb(s1);
       //方式1：可以通过StringBuffer的构造方法
       StringBuffer sb2=new StringBuffer();
       sb2.append(s1);
       //方式2：还可以通过append转换
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println("------");//String转换成StringBuffer
        StringBuffer sb3=new StringBuffer();
        sb3.append("hehe");
        System.out.println(sb3);
        String s2=sbToString(sb3);
        String s3=sb3.toString();
        System.out.println(s2);


    }
    public static StringBuffer stringToSb(String str){
        StringBuffer sb=new StringBuffer(str);
        return sb;

    }

    public static String sbToString(StringBuffer sb){
        return sb.substring(0,sb.length());
    }
}
