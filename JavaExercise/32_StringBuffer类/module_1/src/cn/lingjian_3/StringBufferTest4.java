package cn.lingjian_3;

import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019-08-30 - 14:26
 */
/*
*   判断一个字符串是否是对称字符串
*
* */
public class StringBufferTest4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a String");
        String s=sc.nextLine();

        if(judgeSymmetricString(s)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        System.out.println("--------");
        if(isSame(s)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }
    public static boolean judgeSymmetricString(String str){
        char[] chs=str.toCharArray();
        boolean flag=true;
        for (int i = 0; i <=chs.length/2 ; i++) {
            if (chs[i]!=chs[chs.length-1-i]){
                flag=false;
                break;
            }
        }
        return flag;
    }

    public static boolean isSame(String str){
        return new StringBuffer(str).reverse().toString().equals(str);
    }


}
