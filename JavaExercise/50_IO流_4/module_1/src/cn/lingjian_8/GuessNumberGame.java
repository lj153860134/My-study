package cn.lingjian_8;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lingjian
 * @date 2019/9/20 - 3:02 下午
 */
public class GuessNumberGame {

    //类最好自己写构造函数
    private GuessNumberGame(){

    } //构造函数私有 不允许外部创建对象

    public static void game() throws IOException {
        //把文件中次数加载到集合中
        Reader r=new FileReader("count.txt");
        Properties prop=new Properties();
        prop.load(r);
        r.close();
        //判断次数是否超过5
        int count=0;
        Set<String> set=prop.stringPropertyNames();
        for (String key : set) {
            if(key.equals("count")){
                count=Integer.parseInt(prop.getProperty(key));
                prop.setProperty("count",String.valueOf(count+1));
                break;
            }

        }

        Writer w=new FileWriter("count.txt");
        prop.store(w,null);


        if(count<=1) {
            int number = (int) (Math.random() * 10) + 1;
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter your guess number(1-10)");
                int guessNumber = sc.nextInt();
                if (number == guessNumber) {
                    System.out.println("Guess Successfully");
                    break;
                }
            }
        }else{
            System.out.println("游戏试玩结束，请付钱");
            System.exit(0);
        }
    }

}
