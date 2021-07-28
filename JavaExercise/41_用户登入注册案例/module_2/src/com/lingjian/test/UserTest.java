package com.lingjian.test;

import com.lingjian.dao.UserDao;
import com.lingjian.dao.impl.UserDaoImpl;
import com.lingjian.pojo.User;
import jdk.nashorn.api.tree.NewTree;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/9/20 - 2:32 下午
 */
public class UserTest {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("------------Welcome------------");
            System.out.println("1:Register");
            System.out.println("2:Login");
            System.out.println("3:Exit");
            System.out.println("Please enter your choice");
            String choice = sc.nextLine();
            UserDao ud = new UserDaoImpl();
            switch (choice) {
                case "1":
                    System.out.println("------------Register------------");
                    System.out.println("Please enter your username");
                    String newUsername = sc.nextLine();
                    System.out.println("Please enter your password");
                    String newPassword = sc.nextLine();
                    User newUser = new User();
                    newUser.setUsername(newUsername);
                    newUser.setPassword(newPassword);
                    ud.register(newUser);
                    System.out.println("Registration Success");
                    break;

                case "2":
                    System.out.println("------------Login------------");
                    System.out.println("Please enter your username");
                    String username = sc.nextLine();
                    System.out.println("Please enter your password");
                    String password = sc.nextLine();
                    if (ud.isLogin(username, password)) {
                        System.out.println("Login Successful");
                        System.exit(0);
                    } else {
                        System.out.println("Login Failure");
                    }
                    break;
                case "3":
                default:
                    System.out.println("Thank you");
                    System.exit(0);
            }
        }
    }
}
