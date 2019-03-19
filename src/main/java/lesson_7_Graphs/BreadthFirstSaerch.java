package lesson_7_Graphs;

import java.util.LinkedList;

/**
 * поиск в глубину
 */
public class BreadthFirstSaerch {
        private int[] edgeTo;
        private int[] distTo;
        private boolean[] marked;
        private int source;
        private static final int INF = Integer.MAX_VALUE;

    public BreadthFirstSaerch(MyGraph graph, int source) {
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
            distTo[i] = INF;
        }
        this.source = source;
    }

    private void bfs(MyGraph graph, int source){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.addLast(source);
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()){
            int v = queue.removeFirst();
            for (int w : graph.adjastmentLists(v)) {
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[w] + 1;
                    queue.addLast(w);
                }
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
