package com.lingjian;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 深度优先遍历 和 广度优先遍历
 * @author: Ling Jian
 * @date: 2020-03-11 10:30
 **/
public class BFSAndDFS {
    public static void main(String[] args) {
        //创建图的邻接矩阵
        int[][] graph=new int[8][8];
        //添加结点
        graph[0][1]=graph[1][0]=1;
        graph[0][2]=graph[2][0]=1;
        graph[1][2]=graph[2][1]=1;
        graph[1][3]=graph[3][1]=1;
        graph[1][4]=graph[4][1]=1;
        graph[2][5]=graph[5][2]=1;
        graph[2][6]=graph[6][2]=1;
        graph[3][7]=graph[7][3]=1;
        graph[4][7]=graph[7][4]=1;
        graph[5][6]=graph[6][5]=1;

        printArray(graph);
        printBFS(graph,0);
        System.out.println();
        printDFS(graph,0);

    }

    //打印二维数组
    public static void printArray(int[][] arr) {
        if (arr == null) {
            return;
        }
        for(int[] array :arr){
            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 深度优先算法（利用栈）
     * @param graph 图的邻接矩阵
     * @param index 遍历开始的索引
     */
    public static void printBFS(int[][] graph,int index){
        //创建一个bool数组 表示结点是否被访问过 true代表访问过
        boolean[] isVisited = new boolean[graph.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(index);
        isVisited[index]=true;
        while(!stack.isEmpty()){
            int vertex=stack.pop();
            int[] nodes = graph[vertex];
            //这里反向入栈
            for (int i = nodes.length-1; i >=0; i--) {
                if(!isVisited[i]&&nodes[i]==1){
                    stack.push(i);
                    isVisited[i]=true;
                }
            }
            System.out.print(vertex+1+"=>");
        }
    }

    /**
     * 广度优先算法（利用队列）
     * @param graph
     * @param index
     */
    public static void printDFS(int[][] graph,int index){
        //创建一个bool数组 表示结点是否被访问过 true代表访问过
        boolean[] isVisited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        isVisited[index]=true;
        while(!queue.isEmpty()){
            int vertex=queue.poll();
            int[] nodes = graph[vertex];
            //这里入队列
            for (int i = 0; i <nodes.length ; i++) {
                if(!isVisited[i]&&nodes[i]>0){
                    queue.add(i);
                    isVisited[i]=true;
                }
            }

            System.out.print(vertex+1+"=>");
        }
    }

}
