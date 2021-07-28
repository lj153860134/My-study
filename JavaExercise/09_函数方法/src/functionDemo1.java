/*键盘输入输入三个数据 运用函数方法求出三个中的最大值*/
import java.util.Scanner;
public class functionDemo1 {
    public static void main(String[] args){
        //创建键盘录入数据
        //杜绝错误数据 以后保证数据一定为整数
        //其实也可比较小数
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the first integer");
            int x = sc.nextInt();
            System.out.println("Please enter the second integer");
            int y = sc.nextInt();
            System.out.println("Please enter the third integer");
            int z = sc.nextInt();
            int max=getMax(x,y,z);
            int max1=getMax(x,y,z);
            System.out.println("The max of three integers is :"+max);
            System.out.println("The max of three integers is :"+max1);
        }
    }
    //第一种方法利用if else 求出三个值中的最大值
    private static int getMax(int a,int b,int c){
        if(a>b){
            if(a>c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b<c){
                return c;
            }else{
                return b;
            }
        }

    }
    //第二种方法 分成两步比较大小 且用三元运算符 该方法较好
    private static int getMax1(int a,int b,int c ){
        int temp=(a>b)?a:b;
        int max=(temp>c)?temp:c;
        return max;
    }
}
