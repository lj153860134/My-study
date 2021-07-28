package com.lingjian.window;

import java.util.*;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-05-26 11:21
 **/
public class test {
    public static void main(String[] args) {
        Integer [][] matrix=new Integer[][]{{0,1,2},{0,1,3},{0,1,4},
                {0,2,3},{0,2,7},{0,7,3},{0,3,5},{0,4,6}};
        Graph graph=GraphGenerator.createGraph(matrix);
        System.out.println("宽度优先算法 BFS：");
        bfs(graph.nodes.get(1));
        System.out.println("深度优先算法 DFS：");
        dfs(graph.nodes.get(1));


    }

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }
}

 class Node {
     public int value;
     public int in;
     public int out;
     public ArrayList<Node> nexts;
     public ArrayList<Edge> edges;

     public Node(int value) {
         this.value = value;
         in = 0;
         out = 0;
         nexts = new ArrayList<>();
         edges = new ArrayList<>();
     }
 }

 class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}

 class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}


class GraphGenerator {

    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

}
