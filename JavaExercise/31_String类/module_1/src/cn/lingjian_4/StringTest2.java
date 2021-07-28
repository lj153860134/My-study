package cn.lingjian_4;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-08-21 - 09:15
 */
    /*
     *  模拟登入，给三次机会，并提示还有几次
     *  如果登入成功，就可以玩猜数字小游戏了
     *  分析：
     *     A：定义用户名和密码，已经存在的
     *     B:键盘录入用户名和密码
     *     C:比较用户名和密码
     *     D:给三次机会 用for循环改进
     *
     *
     * */
    public class StringTest2{
        public static void main(String[] args) {
            String username="lingjian";  //这里最好用username和password代替 不要用s1和s2
            String password="210910";
            String s3,s4;
            Scanner sc=new Scanner(System.in);
            for (int i = 0; i <3 ; i++) {
                System.out.println("Please enter your username：");
                s3=sc.nextLine();
                System.out.println("Please enter your password：");
                s4=sc.nextLine();
                if(username.equals(s3)&&password.equals(s4)){
                    System.out.println("Sign in suceesfully Let us play game");
                    //猜数字游戏
                    GuessNumberGame.start();
                    break; //登入成功过后 就要break退出了
                }
                else{
                    System.out.println("You still have "+(2-i)+" chances");
                    if(i==2){
                        System.out.println("Failure");
                    }
                }

            }
        }
    }

