package com.example.datastructureexercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    int vertex;
    LinkedList<Integer> list[];
    adjList[] array;

    class Node {
        int dest;
        Node next;

        public Node(int d) {
            dest = d;
            next = null;
        }
    }

    class adjList {
        Node head;
    }

    public Graph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        array = new adjList[vertex];

        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<>();

            array[i] = new adjList();
            array[i].head = null;
        }
    }

    public void addEdge(int source, int destination){
        list[source].addFirst(destination);

        Node n = new Node(destination);
        n.next = array[source].head;
        array[source].head = n;
    }


    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            LinkedList<Integer> nodeList = list[i];
            if(nodeList.isEmpty()==false) {
                System.out.print(i + ":");
                for (int j = 0; j < nodeList.size(); j++) {
                    System.out.print(" " + nodeList.get(j));
                }
            }
            System.out.println();
        }
    }

    public void DFS(){
        System.out.print("DFS: ");
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<Integer>();

        for(int startIndex=0; startIndex<vertex; startIndex++){
            if(visited[startIndex]==false) {
                stack.push(startIndex);
                visited[startIndex] = true;
                while (stack.isEmpty() == false) {
                    int nodeIndex = stack.pop();
                    System.out.print(nodeIndex + " ");
                    LinkedList<Integer> nodeList = list[nodeIndex];
                    for (int i = 0; i < nodeList.size(); i++) {
                        int dest = nodeList.get(i);
                        if (visited[dest] == false) {
                            stack.push(dest);
                            visited[dest] = true;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public void BFS(int startVertex){
        System.out.print("BFS:");
        boolean[] visited = new boolean[vertex];
        Queue<Integer> s = new LinkedList<Integer>();

        s.add(startVertex);
        while (s.isEmpty() == false) {
            int n = s.poll();
            System.out.print(" " + n);
            visited[n] = true;
            Node head = array[n].head;
            while (head != null) {
                if (visited[head.dest] == false) {
                    s.add(head.dest);
                    visited[head.dest] = true;
                }
                head = head.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(4, 5);
        g.printGraph();
        g.DFS();
        g.BFS(0);
    }
}