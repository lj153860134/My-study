package cn.lingjian.game;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/9/20 - 3:02 下午
 * @version 1.1
 */
public class GuessNumberGame {

    //类最好自己写构造函数
    private GuessNumberGame(){

    } //构造函数私有 不允许外部创建对象

    public static void game(){
        int number=(int)(Math.random()*10)+1;
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Please enter your guess number(1-10)");
            int guessNumber=sc.nextInt();
            if(number==guessNumber){
                System.out.println("Guess Successfully");
                break;
            }
        }
    }

}
