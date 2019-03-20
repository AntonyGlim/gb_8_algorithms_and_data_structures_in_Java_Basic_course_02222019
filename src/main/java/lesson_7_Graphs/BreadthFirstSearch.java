package lesson_7_Graphs;

import java.util.LinkedList;

/**
 * Алгритм (BFS) обхода графа в ширину
 */
public class BreadthFirstSearch {
        private int[] edgeTo;
        private int[] distTo;
        private boolean[] marked;
        private int source;
        private static final int INF = Integer.MAX_VALUE;

    public BreadthFirstSearch(MyGraph graph, int source) {
        if (source < 0){
            throw  new IllegalArgumentException();
        }
        if (source >= graph.vertexCount()){
            throw  new IndexOutOfBoundsException();
        }
        marked = new boolean[graph.vertexCount()];
        edgeTo = new int[graph.vertexCount()];
        distTo = new int[graph.vertexCount()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INF; //от текущей до всех остальных - нет пути
        }
        this.source = source;
        bfs(graph, source); //вызываем алгоритм на обработку
    }

    /**
     * Обход графа в ширину
     * @param graph
     * @param source
     */
    private void bfs(MyGraph graph, int source){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.addLast(source); //добавляем в очередь для проверки
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()){
            int v = queue.removeFirst();
            for (int w : graph.adjastmentLists(v)) { //идем по списку смежных вершин
                if (!marked[w]){ //если еще не посетили
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    queue.addLast(w);
                }
            }

        }
    }

    /**
     * Существует путь до вершины?
     * @param dist
     * @return
     */
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

    /**
     * Кратчайшее расстояние
     * @param dist
     * @return
     */
    public int distTo(int dist){
        if (dist < 0){
            throw  new IllegalArgumentException();
        }
        if (dist >= marked.length){
            throw  new IndexOutOfBoundsException();
        }
        return distTo[dist];
    }
}
