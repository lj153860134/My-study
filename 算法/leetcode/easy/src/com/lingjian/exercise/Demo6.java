package com.lingjian.exercise;

/**
 * @description: Manacher算法
 * @author: Ling Jian
 * @date: 2020-08-24 16:57
 **/
public class Demo6 {
    public static void main(String[] args) {
        String s = "11";
        int res = maxLcpLength(s);
        System.out.println(res);

    }

    public static int maxLcpLength(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        char[] chs = manacherString(str);
        int[] pArr=new int[chs.length];
        int C=-1;
        int R=-1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <chs.length ; i++) {
            pArr[i]=R>i?Math.min((2*C-i),R-i):1;
            while(i-pArr[i]>=0&&i+pArr[i]<chs.length){
                if(chs[i-pArr[i]]==chs[i+pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(C+pArr[i]>R){
                R = C + pArr[i];
                C=i;
            }
            max = Math.max(pArr[i], max);
        }
        return max / 2;
    }

    public static char[] manacherString(String str){
        char[] chs = str.toCharArray();
        int index=0;
        char[] res=new char[chs.length*2+1];
        for (int i = 0; i <res.length ; i++) {
            res[i]=(i&1)==0?'#':chs[index++];
        }
        return res;
    }
}
