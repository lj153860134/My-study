package com.lingjian.interview.zhongxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:  中兴第二题
 * @author: Ling Jian
 * @date: 2020-08-31 10:53
 **/
public class Test_02 {


        public static void main(String[] args)
        {
            Scanner sc= new Scanner(System.in);
            int t = sc.nextInt();
            for(int i=0;i<t;i++) {
                int n = sc.nextInt();
                int[] a =new int[n];
                for(int j=0;j<n;j++) {
                    a[j] = sc.nextInt();
                }
                System.out.println(getCount(a,n));
            }

        }

        private static int getCount(int[] a, int n){
            if (n <= 2)
                return 0;
            int count = -1;
            for (int i = -1; i <= 1; ++i){
                for (int j = -1; j <= 1; ++j){
                    int temp = 0;
                    if (i != 0)
                        temp++;
                    if (j != 0)
                        temp++;
                    int a1 = a[0] + i;
                    int a2 = a[1] + j;
                    int d = a2 - a1;
                    int pre = a2;
                    boolean flag = true;
                    for (int k = 2; k < n; ++k){
                        if (a[k] - pre == d){
                            pre = a[k];
                        } else if (a[k] - pre == d - 1){
                            temp++;
                            pre = a[k] + 1;
                        } else if (a[k] - pre == d + 1){
                            temp++;
                            pre = a[k] - 1;
                        } else{
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        if (count == -1)
                            count = temp;
                        else
                            count = Math.min(count, temp);
                    }
                }
            }
            return count;
        }

    }