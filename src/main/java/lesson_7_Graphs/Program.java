package lesson_7_Graphs;

/**
 * 1. Реализовать программу, в которой задается граф из 10 вершин.
 * Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 *
 *             4
 *             |
 * 0 - 1 - 2 - 3
 *             |
 *             5
 *             |
 *         7 - 6 - 8 - 9
 */
public class Program {
    public static void main(String[] args) {

        MyGraph myGraph = new MyGraph(10);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(3, 5);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(5, 6);
        myGraph.addEdge(6, 7);
        myGraph.addEdge(6, 8);
        myGraph.addEdge(8, 9);

        BreadthFirstSearch searchPath = new BreadthFirstSearch(myGraph, 0);
        System.out.println(searchPath.hasPathTo(5));
        System.out.println(searchPath.pathTo(3));
        System.out.println(searchPath.pathTo(5));
        System.out.println(searchPath.pathTo(9));
        System.out.println(searchPath.distTo(0));
        System.out.println(searchPath.distTo(1));
        System.out.println(searchPath.distTo(2));
        System.out.println(searchPath.distTo(3));
        System.out.println(searchPath.distTo(4));
        System.out.println(searchPath.distTo(5));
        System.out.println(searchPath.distTo(6));
        System.out.println(searchPath.distTo(7));
        System.out.println(searchPath.distTo(8));
        System.out.println(searchPath.distTo(9));

    }
}
