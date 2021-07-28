import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-27 19:32
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] res=function1(n);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] function1(int n) {
        Scanner sc = new Scanner(System.in);
        int[] res=new int[n];
        for (int i = 0; i <n ; i++) {
            int count=sc.nextInt();
            int[] helper=new int[count];
            for (int j = 0; j <helper.length ; j++) {
                helper[j] = sc.nextInt();
            }
            int temp=function2(count,helper);
            res[i]=temp;
            }

        return res;
    }

    private static int function2(int count, int[] helper) {
        if(count==0){
            return -1;
        }
        int min = 1;
        Arrays.sort(helper);
        if (helper[count - 1] == 0 || helper[count - 1] == 1) {
            min = -1;
        } else {
            for (int i = 0; i <helper.length ; i++) {
                if(helper[i]!=0){
                    min++;
                }
            }
        }
        return min;
    }


}
