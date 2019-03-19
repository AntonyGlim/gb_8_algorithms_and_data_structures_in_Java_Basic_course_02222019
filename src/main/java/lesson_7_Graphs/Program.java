package lesson_7_Graphs;

import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph(13);
        myGraph.addEdge(0, 6);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(5, 3);
        myGraph.addEdge(5, 4);
        myGraph.addEdge(5, 0);
        myGraph.addEdge(4, 6);
        myGraph.addEdge(4, 3);

        myGraph.addEdge(7, 8);

        myGraph.addEdge(9, 10);
        myGraph.addEdge(9, 12);
        myGraph.addEdge(9, 11);
        myGraph.addEdge(11, 12);

        DepthFirstSearch searchPath = new DepthFirstSearch(myGraph, 0);
        System.out.println(searchPath.hasPathTo(5));
        System.out.println(searchPath.hasPathTo(7));
        System.out.println(searchPath.hasPathTo(9));

        System.out.println(searchPath.hasPathTo(9));

    }
}
