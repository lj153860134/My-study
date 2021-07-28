package cn.lingjian.test;

import cn.lingjian.dao.UserDao;
import cn.lingjian.dao.impl.UserDaoImpl;
import cn.lingjian.game.GuessNumberGame;
import cn.lingjian.pojo.User;

import java.util.Scanner;

/**
 * 用户测试类
 *
 * @author lingjian
 * @date 2019/9/18 - 3:03 下午
 */
public class UserTest {
    public static void main(String[] args) {
        //为了能够回来
        while (true) {
            //欢迎界面 给出选择项
            System.out.println("-----------------Welcome---------------");
            System.out.println("1 Login");
            System.out.println("2 Register");
            System.out.println("3 Exit");
            System.out.println("Please enter your choice");
            //键盘录入选择 根据选择做不同的操作
            Scanner sc = new Scanner(System.in);
            String choiceString = sc.nextLine();

            //switch语句多个地方要使用 定义在外面
            UserDao ud = new UserDaoImpl();
            switch (choiceString) {
                case "1":
                    //登录界面，请输入用户名和密码
                    System.out.println("-----------------Login---------------");
                    System.out.println("Please enter your username");
                    String username = sc.nextLine();
                    System.out.println("Please enter your password");
                    String password = sc.nextLine();

                    //调用登录功能
//                UserDao ud=new UserDaoImpl();
                    boolean flag = ud.isLogin(username, password);
                    if (flag) {
                        System.out.println("Login Successful");
                        System.out.println("Start Game?(Y/N)");
                        while (true) {
                            String resultString = sc.nextLine();
                            if (resultString.equalsIgnoreCase("Y")) {
                                GuessNumberGame.game();  //玩猜数字小游戏
                                System.out.println("Start Again?(Y/N)");
                            } else {
                                System.out.println("Thank you");
                                break;
                            }
                        }
                        System.exit(0);
//                        break;//这里写break 结束的是switch
                    } else
                        System.out.println("Login Failed");
                    break;
                case "2":
                    //欢迎界面，请输入用户名和密码
                    System.out.println("-----------------Register---------------");
                    System.out.println("Please enter username");
                    String newUsername = sc.nextLine();
                    System.out.println("Please enter password");
                    String newPassword = sc.nextLine();

                    //把用户名和密码封装到一个对象中
                    User newUser = new User();
                    newUser.setUsername(newUsername);
                    newUser.setPassword(newPassword);

                    //调用注册功能
//                UserDao ud=new UserDaoImpl();
                    ud.register(newUser);
                    System.out.println("Registration Successful");
                    break;
                case "3":
                default:
                    System.out.println("Thank you");
                    System.exit(0);
                    break;
            }
        }

    }
}
