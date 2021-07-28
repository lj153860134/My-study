/*键盘输入一个整数 求1到该整数数据之和
* 求1到该数据所有偶数的和 并输出偶数的个数
* 求1到该数据所有奇数的和 并输出奇数的个数
* */
import java.util.Scanner;
public class loopDemo2 {
    public static void main(String[] args){
        int sum=0;
        int sumOfOdd=0;
        int sumOfEven=0;
        int numOfOdd=0;
        int numOfEven=0;
        //创建键盘录入对象
        Scanner sc =new Scanner(System.in);
        System.out.println("Please enter a integer");
        int i=sc.nextInt();
        //杜绝错误数据（数据比1还小）的输入
        //还有一种数据错误 输入的数据不是整数 但还未学会判断输入一定为整数
        //不应使用if语句 if语句只会判断一次错误数据
        //应使用while语句 循环判断数据是否正确
        while (i<1){
            System.out.println("The integer is wrong");
            System.out.println("Please enter a right integer");
            i=sc.nextInt();
        }
        //利用循环语句进行求和
        for(int x=1;x<=i;x++){
            if(x%2==0){  //进行偶数奇数的判断
                numOfEven++;
                sumOfEven+=x;
            }else{
                numOfOdd++;
                sumOfOdd+=x;
            }
            sum+=x;
        }
        System.out.println("The integer you entered is "+i);
        System.out.println("The number of odd is "+numOfOdd);
        System.out.println("The number of even is "+numOfEven);
        System.out.println("The sum of all odd integers: "+sumOfOdd);
        System.out.println("The sum of all even integers: "+sumOfEven);
        System.out.println("The sum of all integers: "+sum);
    }
}
