package cn.lingjian_1;
import java.util.Arrays;

/**
 * @author lingjian
 * @date 2019-09-02 - 18:34
 */
/*
*  Array类中的常用方法：
*     1、public static String toString(int[] arr)
*     2、public static void sort(int[] arr)
*     3、public static int binarySearch(int[] arr)
*
* */
public class ArrayDemo1 {
    public static void main(String[] args) {
        int[] arr={1,3,4,7,5,9,2,8,0,6};
        String[] str={"h","e","l","l","o"};
        String s1=Arrays.toString(arr);
        String s2=Arrays.toString(str);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("------");

        Arrays.sort(arr);
        Arrays.sort(str);
        String s3=Arrays.toString(arr);;
        String s4=Arrays.toString(str);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println("------");

        int index=Arrays.binarySearch(arr,8);
        int number= Arrays.binarySearch(str,"e");
        System.out.println(index);
        System.out.println(number);

    }
}
