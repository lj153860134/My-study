package com.lingjian.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 有 N 个房间
 * 开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1
 * 并且房间里可能有一些钥匙能使你进入下一个房间
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]
 * 每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示
 * 其中 N = rooms.length
 * 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间
 * 最初，除 0 号房间外的其余所有房间都被锁住
 * 你可以自由地在房间之间来回走动
 * 如果能进入每个房间返回 true，否则返回 false
 * @author: Ling Jian
 * @date: 2020-08-31 09:00
 **/
public class Test_841 {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
//        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
//        list2.add(0);
//        list2.add(1);

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);

        List<Integer> list4 = new ArrayList<>();
//        list4.add(0);


        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        boolean res = canVisitAllRooms(list);
        System.out.println(res);

    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size()==1){
            return true;
        }
        boolean[] visited = new boolean[rooms.size()];
        visited[0]=true;
        dfs(0,rooms,visited);
        for (int i = 0; i <visited.length ; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }

    public static void dfs(int start,List<List<Integer>> rooms,boolean[] visited){
        if(start!=0&&visited[start]){
            return ;
        }
        List<Integer> temp=rooms.get(start);
        visited[start] = true;
        for (int i = 0; i <temp.size() ; i++) {
            dfs(temp.get(i), rooms, visited);
        }
    }
}
