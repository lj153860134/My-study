/*
 *   猜数字小游戏（数据在1--100之间）
 *   分析：
 *      A：产生一个随机数（被猜的）
 *      B:键盘输入数据（你猜的）
 *      C:两个数据进行比较（大  小  猜中）
 *      D:给出多次猜的机会，猜中就结束
 *       不知道循环的次数，用while循环 猜中就break
 *
 * */
import java.util.Scanner;
public class GuessNumber {
    public static void main(String[] args){
        int count=0;   //猜测的次数
        int guessNumber=0; //猜测的数初始值设为0
        //产生一个随机数
        int number=(int)(Math.random()*100)+1;
        System.out.println("The number is "+number);
        while(guessNumber!=number) {
            //创建键盘录入对象
            Scanner sc=new Scanner(System.in);
            System.out.println("Please enter the number you guessed（1-100）");
            guessNumber=sc.nextInt();
            //检测错误数据（小于1或者大于100）
            while(guessNumber<1||guessNumber>100){
                System.out.println("The number is wrong");
                System.out.println("Please enter the right number you guessed（1-100）");
                guessNumber=sc.nextInt();
            }
            count++;
            if(guessNumber==number){
                break;
            }
        }
        System.out.println("You guess "+count+" times");
    }

}
