package lesson_7_Graphs;

import java.util.LinkedList;

public class MyGraph {
    private int vertexCount;
    private int edgeCount;
    private LinkedList<Integer>[] adjastmentLists; //список смежности для каждой вершины

    public MyGraph(int vertexCount) {
        if (vertexCount < 0){
            throw  new IllegalArgumentException("Не допустимое количество вершин");
        }
        this.vertexCount = vertexCount;
        adjastmentLists = new LinkedList[vertexCount]; //массив связных списков
        for (int i = 0; i < vertexCount; i++) {
            adjastmentLists[i] = new LinkedList<Integer>(); //хранит вершины смежные с данной
        }
    }

    public int vertexCount(){
        return vertexCount;
    }

    public int edgeCount(){
        return edgeCount;
    }

    /**
     * Добавляет ребро между 2 вершинами
     */
    public void addEdge(int v1, int v2){
        if (v1 < 0 || v2 < 0){
            throw  new IllegalArgumentException("Номер не может быть отрицательным");
        }

        if (v1 >= vertexCount || v2 >= vertexCount){
            throw  new IndexOutOfBoundsException("Нет вершины с таким номером");
        }

        //добавление ребра
        adjastmentLists[v1].add(v2);
        adjastmentLists[v2].add(v1);
    }

    /**
     * Запросить список смежности вершины
     */
    public LinkedList<Integer> adjastmentLists(int vertex){
        return adjastmentLists[vertex];
    }
}
