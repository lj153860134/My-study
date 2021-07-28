package com.lingjian.interview.wangyi;

import java.util.*;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-09-12 15:55
 **/
public class Main_06 {
    static int res=0;
    public static void main(String[] args) {
        boolean[] choose = new boolean[10001];
        Scanner sc = new Scanner(System.in);
        //男生的id
        String s1 = sc.nextLine();
        String[] str1=s1.split(" ");
        List<Integer> man = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (String s : str1) {
            man.add(Integer.parseInt(s));
        }
        //女生的id
        String s2 = sc.nextLine();
//        String[] str2=s2.split(" ");
        int num = sc.nextInt();
        for (int i = 0; i <num; i++) {
            int manNum = sc.nextInt();
            if(!map.containsKey(manNum)) {
                map.put(manNum, new ArrayList<>());
            }
            int womenNum = sc.nextInt();
            map.get(manNum).add(womenNum);
        }
        dfs(map,0,man,choose);
        System.out.println(res);
    }

    public static void dfs( HashMap<Integer, List<Integer>> map,int index,List<Integer> man,boolean[] choose){
        if(index==man.size()){
            int temp=0;
            for (int i = 0; i <choose.length ; i++) {
                if(choose[i]){
                    temp++;
                }
            }
            res = Math.max(temp, res);
            return;
        }

        for (int i = 0; i <map.get(man.get(index)).size() ; i++) {
            if(!choose[map.get(man.get(index)).get(i)]) {
                choose[map.get(man.get(index)).get(i)] = true;
                dfs(map, index + 1, man, choose);
                choose[map.get(man.get(index)).get(i)] = false;
            }else{
                dfs(map, index + 1, man, choose);
            }
        }
    }
}
