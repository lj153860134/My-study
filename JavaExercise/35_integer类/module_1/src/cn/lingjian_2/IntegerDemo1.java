package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-09-03 - 09:28
 */
/*
* int类型与String类型的相互转换
*
* */
public class IntegerDemo1 {
    public static void main(String[] args) {
        //String 转int
        int number=100;
        String s=""+number;
        System.out.println(s);

        String s2=String.valueOf(number);
        System.out.println(s2);

        Integer i=new Integer(number);
        String s3=i.toString();
        System.out.println(s3);

        String s4=Integer.toString(number);
        System.out.println(s4);

        //String转int
        String str="1000";
        Integer ii=new Integer(str);
        int x=ii.intValue();
        System.out.println(x);

        int y=Integer.parseInt(str);
        System.out.println(y);


    }
}
