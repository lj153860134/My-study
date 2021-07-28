package com.lingjian;

import java.util.Arrays;

/**
 * @description: KMP算法
 * @author: Ling Jian
 * @date: 2020-03-11 21:00
 **/
public class KMP {
    public static void main(String[] args) {
        String str1="abcabcte";
        String str2 = "t";
        int[] next1 = getNextArray(str1);
        int[] next2 = getNextArray2(str1);
        System.out.println(Arrays.toString(next1));
        System.out.println(Arrays.toString(next2));
//        System.out.println(getIndexof(str1,str2));

    }

   /**
   * @description: 返回str1中包含str2的索引 若找不到 返回-1
   * @param: [str1, str2]
   * @return: int
   * @author: Ling Jian
   * @date: 2020/3/11 10:46 下午
   */
    public static int getIndexof(String str1, String str2) {
        if(str1==null||str2==null||str2.length()<1||str1.length()<str2.length()){
            return -1;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[] next = getNextArray(str2);
        int p=0;
        int q=0;
        while (p < str1.length() && 1 < str2.length()) {
            if(chs1[p]==chs2[q]){
                p++;
                q++;
            }else if(next[q]==-1){
                p++;
            }else{
                q=next[q];
            }
        }
        return q==str2.length()?p-q:-1;
    }

    //获取next数组（我的思路）
    public static int[] getNextArray(String string) {
        if(string.length()==1){
            return new int[]{-1};
        }
        if(string.length()==2){
            return new int[]{-1, 0};
        }
        char[] chs = string.toCharArray();
        int[] next = new int[chs.length];
        next[0]=-1;
        next[1]=0;
        for (int i = 2; i <chs.length ; i++) {
            int temp=next[i-1];
            while(temp>=0){
                if(chs[temp]==chs[i-1]){
                    next[i]=temp+1;
                    break;
                }
                temp=next[temp];
            }
            if(temp==-1){
                next[i]=0;
            }

        }
        return next;

    }

    //获取next数组（左神思路）
    public static int[] getNextArray2(String string) {
        if(string.length()==1){
            return new int[]{-1};
        }
        char[] chs = string.toCharArray();
        int[] next = new int[chs.length];
        next[0]=-1;
        next[1]=0;
        int i=2;
        int temp=0;
        while(i<chs.length){
            if(chs[temp]==chs[i-1]){
                next[i++]=++temp;
            }else if(temp>0){
                temp=next[temp];
            }else{
                next[i++]=0;
            }
        }


        return next;
    }
}
