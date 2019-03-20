package lesson_7_Graphs;

import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph(13);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(3, 5);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(3, 2);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(5, 0);


        BreadthFirstSaerch searchPath = new BreadthFirstSaerch(myGraph, 0);
        System.out.println(searchPath.hasPathTo(5));
        System.out.println(searchPath.pathTo(3));
        System.out.println(searchPath.pathTo(5));
        System.out.println(searchPath.distTo(1));
        System.out.println(searchPath.distTo(2));
        System.out.println(searchPath.distTo(3));
        System.out.println(searchPath.distTo(4));
        System.out.println(searchPath.distTo(5));


    }
}
