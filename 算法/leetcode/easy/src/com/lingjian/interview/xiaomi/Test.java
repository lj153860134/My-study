package com.lingjian.interview.xiaomi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-08 18:36
 **/
public class Test {
    public static void main(String[] args) {
        String pwd = "111aaAa!";

        Pattern p = Pattern.compile("/^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*,\\.])[0-9a-zA-Z!@#$%^&*,\\.]{8,12}$/");

        Matcher m = p.matcher(pwd);
        System.out.println(m.matches());
    }
}
