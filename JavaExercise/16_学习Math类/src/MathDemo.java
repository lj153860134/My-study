/*
* Math：
* 由于math类子java.lang包下，不需要导包
* 特点：
* 没有构造方法，因为它的成员全部都是静态的
*
* 掌握一个方法：
*          获取随机数
*         static double	random()
          返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。
*
* */
public class MathDemo {
    public static void main(String[] args){
        //获取一个随机数
        double d=Math.random();
        System.out.println(d);
        //获取一个1--100之间的随机整数
        for(int i=0;i<100;i++) {
            int a = (int) (Math.random() * 100) + 1;//前面必须要加一个括号 不然会一直出现1
            System.out.println(a);
        }
    }

}
