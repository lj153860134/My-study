public class DateTypeDemo {
    public static void main(String[] args){
        //定义数据的格式：
        // 数据类型 变量名 =初始化值；

        //定义一个字节变量
        byte a=10;
        System.out.println(10);
        System.out.println(a);

        //定义一个短整型变量
        short s=100;
        System.out.println(s);

        //定义一个整型
        int i=1000;
        System.out.println(i);

        //超过了int的范围
        long j=10000000000000L;
        System.out.println(j);

        //定义浮点类型数据变量
        float f=12.345F;
        System.out.println(f);

        //数据溢出，且用强制转移，计算机中所有的运算都是用补码来运算的
        byte b=(byte) 130;
        System.out.println(b);

        //直接输出一个字符
        System.out.println('a');
        //输出一个字符和一个整数做加法
        System.out.println('a'+1);

        System.out.println("hello"+'a'+1);
        System.out.println('a'+1+"hello");
    }
}
