/*   在控制台输入一个三位数输出100到该数之间的所有“水仙花数”
*    水仙花数是指一个三位数，其各位数字的立方和等于该数本身
*    并且输出一共有多少个水仙花数
*
* */
import java.util.Scanner;
public class loopDemo3 {
    public static void main(String[] args){
        int sum;
        // 创建键盘录入对象
        int count=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a three-digit number ");
        int num=sc.nextInt();
        //判断错误数据（数据不是三位数）
        while(num<100||num>1000){
            System.out.println("The number is wrong");
            System.out.println("Please enter a right three-digit number");
            num=sc.nextInt();
        }
        for(int x=100;x<=num;x++) {
            //取出该三位数中的各位上的数字
            int sumGe = 1;
            int sumShi = 1;
            int sumBai = 1;
            int ge = x % 10;
            int shi = x / 10 % 10;
            int bai = x / 10 / 10 % 10;
            //利用for循环判断是否为水仙花数
            for (int i = 0; i < 3; i++) {
                sumGe *= ge;
                sumShi *= shi;
                sumBai *= bai;
            }
                sum = sumGe + sumShi + sumBai;
            //利用if判断为水仙花数 输出该数 并且计数加一
                if (sum == x) {
                    count++;
                    System.out.println("The number is a daffodil number :" + x);
                }
            }
        System.out.println("There are "+count+" daffodil numbers");
        }


    }
