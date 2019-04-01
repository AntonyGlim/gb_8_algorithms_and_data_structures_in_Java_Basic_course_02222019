package lesson_7_Graphs;

import java.util.LinkedList;

/**
 * Алгритм (DFS) обхода графа в глубину
 * (граф существует независимо от алгоритма)
 */
public class DepthFirstSearch {
    private boolean[] marked;//массив для хранения посещаемости
    private int[] edgeTo;//массив с предками
    private int source;//исходная вершина

    public DepthFirstSearch(MyGraph graph, int source) {
        if (source < 0){
            throw  new IllegalArgumentException();
        }
        if (source >= graph.vertexCount()){
            throw  new IndexOutOfBoundsException();
        }
        this.source = source;
        edgeTo = new int[graph.vertexCount()];
        marked = new boolean[graph.vertexCount()];
        dfs(graph, source);
    }

    private void dfs(MyGraph graph, int vertex){
        marked[vertex] = true; //посетили вершину
        for (int w : graph.adjastmentLists(vertex)) {
            if (!marked[w]){ //если не посещали
                edgeTo[w] = vertex;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int dist){
        if (dist < 0){
            throw  new IllegalArgumentException();
        }
        if (dist >= marked.length){
            throw  new IndexOutOfBoundsException();
        }
        return marked[dist];
    }

    /**
     * Вернет путь
     */
    public LinkedList pathTo(int dist){
        if (!hasPathTo(dist)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();

        int v = dist;
        while (v != source){
            stack.push(v);
            v = edgeTo[v];
        }
        return stack;
    }

}
