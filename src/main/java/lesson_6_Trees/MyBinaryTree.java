package lesson_6_Trees;

import java.util.NoSuchElementException;

//MyTreeMap
//Key extends Comparable<Key> - т.к. ключи необходимо сравнивать
public class MyBinaryTree<Key extends Comparable<Key>, Value> {

    /**
     * Скрытый класс
     * Класс для элемента состоящего из ключа и значения
     */
    private class Node{
        Key key;
        Value value;
        Node leftTree; //ссылка на левое дерево
        Node rightTree; //ссылка на правое дерево
        int size; //количество узлов в дереве, корнем которого является данный узел

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    private Node root = null; //корень

    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Интерфейсный метод
     * @return
     */
    public int size(){
        return size(root);
    }

    /**
     * Метод для всей грязной работы
     * @param node
     * @return
     */
    private int size(Node node){
        if(node == null) return 0;
        else return node.size;
    }

    /**
     * Интерфейсный метод
     * @return
     */
    public Value get (Key key){
        return get(root, key);
    }

    /**
     * Скрытый метод
     * @return
     */
    private Value get(Node node, Key key){

        if (key == null) throw new IllegalArgumentException("Не может быть такого значения!");
        if (node == null) return null; //не нашли ключ
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node.value; //нашли ключ
        if (cmp < 0) return get(node.leftTree, key); //ищем в левом
        else /* (cmp > 0) */ return get(node.rightTree, key); //ищем в правом
    }

    /**
     * Присвоем значение по ключу
     * I
     */
    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    /**
     * Рекурсивно спускаемся и после поднимаемся по дереву
     * @param node - необходим, для вставки связи у вставляемого элемента
     * @param key
     * @param value
     * @return
     */
    public Node put(Node node, Key key, Value value){
        if (key == null) throw new IllegalArgumentException("Не может быть такого значения!");
        if (node == null) return new Node(key, value, 1);//дошди до низа и можем вставить узел. Вернем ссылку на узел
        int cmp = key.compareTo(node.key);
        if (cmp == 0) node.value = value;
        if (cmp < 0) node.leftTree = put(node.leftTree, key, value);
        else /* (cmp > 0) */ node.rightTree = put(node.rightTree, key, value); //вставили новый или обновили значение

        node.size = size(node.leftTree) + size(node.rightTree) + 1;//обновим size у каждого узла
        return node;
    }

    /**
     * Есть-ли такой ключ
     * @param key
     * @return
     */
    public boolean contains(Key key){
        return get(key) != null;
    }

    /**
     * Удаление узла
     */
    public void remove(Key key){
        root = remove(root, key);
    }

    /**
     * Удаление узла (основной рекурсивный метод)
     */
    private Node remove(Node node, Key key){
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.leftTree = remove(node.leftTree, key);
        else if (cmp > 0) node.rightTree = remove(node.rightTree, key);
        else {
            if (node.leftTree == null) return node.rightTree;
            if (node.rightTree == null) return node.leftTree;

            //у узла оба потомка. Реализуем удаление Хибборда
            Node tmp = node; //сохраняем узел
            node = max(node.leftTree);//на его место ьфкс. из левого под
            node.leftTree = removeMax(tmp.leftTree);
            node.rightTree = tmp.rightTree;
            tmp = null;
        }
        node.size = size(node.leftTree) + size(node.rightTree) + 1;//обновим size у каждого узла
        return node;
    }

    /**
     * найдем наибольший и наименьший элементы
     */
    private Node min(Node node){
        if (node.leftTree == null) return node;
        else return  min(node.leftTree);
    }

    private Node max(Node node){
        if (node.rightTree == null) return node;
        else return  min(node.rightTree);
    }

    /**
     * Получить значения
     * @return
     */
    public Value minValue(){
        return min(root).value;
    }

    public Value maxValue(){
        return max(root).value;
    }

    /**
     * Удаление минимального и максимального элемента
     */
    private Node removeMin(Node node){
        if (node.leftTree == null) return node.rightTree;
        else node.leftTree =removeMin(node.leftTree);
        node.size = size(node.leftTree) + size(node.rightTree) + 1;//обновим size у каждого узла
        return node;
    }

    private Node removeMax(Node node){
        if (node.rightTree == null) return node.leftTree;
        else node.rightTree =removeMax(node.rightTree);
        node.size = size(node.leftTree) + size(node.rightTree) + 1;//обновим size у каждого узла
        return node;
    }

    private Node removeMin(){
        if (isEmpty()) throw new NoSuchElementException("Деево пустое");
        return removeMin(root);
    }

    private Node removeMax(){
        if (isEmpty()) throw new NoSuchElementException("Деево пустое");
        return removeMax(root);
    }

}
