package com.lingjian.interview.wangyi;

import java.util.*;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-05 14:54
 **/
public class Main_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        int n=5;
//        int m=3;
        int left=0;
        int right=0;
        int[] money = new int[n];
        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            money[i] = sc.nextInt();
//            money[i] = i + 1;
            map.put(i,new LinkedList<>());
        }
//        System.out.println(Arrays.toString(money));
        for (int i = 0; i <m ; i++) {
            int count = sc.nextInt();
//            int count=5;
            int res=0;
            sc.nextLine();
//            String[] s=new String[]{"left take 1","right take 2","left return 3","right keep","right take 4"};
            for (int j = 0; j <count ; j++) {
                String str = sc.nextLine();
//                System.out.println(str);
                String[] strs=str.split(" ");
                int num=0;
                if(strs.length==3) {
                     num = Integer.parseInt(strs[2]);
                }
                if(strs[0].equals("left")){
                    if(strs[1].equals("take")){
                        if(map.get(num-1).size()==0){
                            left = money[num-1];
                        }else{
                            left= map.get(num-1).pollLast();
                        }
                    }else if(strs[1].equals("return")){
                        map.get(num-1).addLast(money[num-1]);
                        left=0;
                    }else{
                        res += left;
                        left=0;
                    }
                }else{
                    if(strs[1].equals("take")){
                        if(map.get(num-1).size()==0){
                            right = money[num-1];
                        }else{
                            right= map.get(num-1).pollLast();
                        }
                    }else if(strs[1].equals("return")){
                        map.get(num-1).addLast(money[num-1]);
                        right=0;
                    }else{
                        res += right;
                        right=0;
                    }
                }

            }
//            for (int j = 0; j <n ; j++) {
//                System.out.println(Arrays.toString(map.get(j).toArray()));
//            }
            res = res + left + right;
            System.out.println(res);

        }
    }
}
