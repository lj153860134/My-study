package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019/9/25 - 9:21 上午
 */
public class ExceptionDemo2 {
    public static void main(String[] args) {
        int a=10;
        int b=0;
        try {
            System.out.println(a / b);
        }catch(ArithmeticException ae) {
            System.out.println("除数不能为0");
        }
        System.out.println("over");
    }
}
