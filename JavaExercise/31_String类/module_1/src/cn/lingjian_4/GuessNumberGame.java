package cn.lingjian_4;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-08-21 - 09:23
 */
public class GuessNumberGame {

    private GuessNumberGame() {
    }     //把构造方法私有化 外部就不能创建对象 只能通过类名调用（必须是静态）

    public static void start() {
        int number = (int) (Math.random() * 10) + 1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please guess a integer(1-10):");
            int guessNumber = sc.nextInt();
            if (guessNumber == number) {
                System.out.println("Congratulations, you guess it.");
                break;
            } else if (guessNumber < number) {
                System.out.println("Guess bigger");

            } else {
                System.out.println("Guess smaller");
            }
        }

    }

}
