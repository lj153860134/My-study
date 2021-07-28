/* 从键盘输入两个整数 输出其和 输出其中较大的数 比较是否相等
*/
import java.util.Scanner;
public class scannerDemo{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个整数");
        int x=sc.nextInt();
        System.out.println("请输入第二个整数");
        int y=sc.nextInt();
        System.out.println("你输入两个整数的和为 "+(x+y));
        int max=(x>y)?x:y;
        System.out.println("其中较大的数为 "+max);
        boolean flag=(x==y);
        if(flag)
        System.out.println("这两个数相等");
        else
            System.out.println("这两个数不相等");
    }
}






