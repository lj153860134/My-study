package com.lingjian.interview.wangyi;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-05 22:41
 **/
public class Main_02 {
    public static void main(String[] args) {
        String s = "100100010100110";
        int res = numWays(s);
        System.out.println(res);
    }
    public static int numWays(String s) {
        char[] chs=s.toCharArray();
        int count0=0;
        int count1=0;
        for (int i = 0; i <chs.length ; i++) {
            if(chs[i]=='0'){
                count0++;
            }else{
                count1++;
            }
        }
        if(count1==0){
            long m = chs.length-1;
            m *= m - 1;
            m /= 2;
            return (int)m%1000000007;
        }
        if(count1%3!=0){
            return 0;
        }
        int count = count1 / 3;
        int temp=0;
        long[] res = new long[2];
        int index=0;
        for (int i = 0; i <chs.length ; i++) {
            if(chs[i]=='1'){
                temp++;
                int cnt=i+1;
                if(temp==count){
                    while(chs[cnt]=='0'){
                        res[index]++;
                        cnt++;
                    }
                    index++;
                    temp=0;
                }

            }
            if(index==2){
                break;
            }
        }
        res[0]++;
        res[1]++;
        return (int)(res[0] * res[1]%1000000007);
    }
}
