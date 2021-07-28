package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-09-11 - 14:15
 */
public class MathDemo1 {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println(Math.E);
        System.out.println(Math.abs(-10));
        System.out.println(Math.ceil(2.123));
        System.out.println(Math.ceil(-1.234));
        System.out.println(Math.max(2,3));
        System.out.println(Math.pow(2, 5));
        //输出0-100的随机数
        for (int i = 1; i <=100 ; i++) {
            if(i%10!=0)
            System.out.print(((int)(Math.random()*100)+1+"\t"));
            else
                System.out.println();
        }
        System.out.println(Math.round(2.56));
        System.out.println(Math.round(-1.98234f));
        System.out.println(Math.sqrt(2.56));

    }
}
