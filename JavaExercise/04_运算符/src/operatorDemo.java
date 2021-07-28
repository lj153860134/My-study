/*  讲解运算符
*/
public class operatorDemo {
    public static void main(String[] args){
        int x=3;//这样读比较好 把3赋值给int类型变量x
        int y=4;
        System.out.println(x+y);
        System.out.println(x-y);
        System.out.println(x*y);
        System.out.println(x*1.0/y);//整数相除 只能得到整数
        System.out.println("x:"+x);
        System.out.println("y:"+y);
        //short s=1;
       // s=s+1;
        short c=1;
        c+=1;         //扩展运算符隐含着类型的强制转换
        /* 位运算运算  首先要把数据转换成二进制
            若两边是boolean类型就是逻辑运算符
            若两边是数据就是位运算符*/
        System.out.println("------------");
        System.out.println(3&4);
        System.out.println(3|4);
        System.out.println(3^4);
        System.out.println(~3);
        System.out.println("------------");
        /*面试题：
        请自己实现两个整数的交换
        没有明确指定数据类型，默认int类型
        */
        int a=10;
        int b=20;
        System.out.println("a:"+a+", b:"+b);
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("a:"+a+", b:"+b);
        System.out.println("------------");
        System.out.println(-24>>>2);
        System.out.println(-24>>>2);//复数右移与无符号右移的差别
        System.out.println("------------");
        /*三木运算符
        格式   （表达式boolean类型）？表达式1：表达式2；*/
       int p,q,max;
       p=100;
       q=200;
       max=(p>q)?p:q;
        System.out.println(max);


    }
}
