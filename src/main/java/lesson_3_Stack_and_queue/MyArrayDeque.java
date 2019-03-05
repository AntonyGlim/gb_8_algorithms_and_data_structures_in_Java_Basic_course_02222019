package lesson_3_Stack_and_queue;

import java.util.NoSuchElementException;

public class MyArrayDeque <Item> {

    Object[] deque = new Object[1];
    int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    /**
     * Изменить размер дэка
     * @param capacity
     */
    public void resize(int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = deque[i];
        }
        deque = temp;
    }

    /**
     * Удалить все элементы из дэка
     */
    public void clear(){
        Object[] temp = new Object[1];
        deque = temp;
        size = 0;
    }

    /**
     * Добавление элемента в начало дэка
     * @param item
     */
    public void pushFront(Item item){
        if (size == deque.length){
            resize(deque.length * 2);
        }
        for (int i = size; i > 0 ; i--) {
            deque[i] = deque[i - 1];
        }
        size++;
        deque[0] = item;
    }

    /**
     * Просмотреть элемент в начале дэка
     * @return
     */
    public Item peakFront(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return (Item) deque[0];
    }

    /**
     * Извлечение элемента из начала дэка
     * @return
     */
    public Item popFront(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = (Item) deque[0];
        size--;
        for (int i = 0; i < size; i++) {
            deque[i] = deque[i + 1];
        }
        if (size == deque.length / 4 && size > 0){
            resize (deque.length / 2);
        }
        return item;
    }

    /**
     * Добавление элемента в конец дэка
     * @param item
     */
    public void pushBack(Item item){
        if (size == deque.length){
            resize(deque.length * 2);
        }
        deque[size++] = item;
    }

    /**
     * Просмотреть элемент в конце дэка
     * @return
     */
    public Item peakBack(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return (Item) deque[size - 1];
    }

    /**
     * Извлечение элемента из конеца дэка
     * @return
     */
    public Item popBack(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = (Item) deque[size - 1];
        size--;
        if (size == deque.length / 4 && size > 0){
            resize (deque.length / 2);
        }
        return item;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((Item)deque[i].toString()).append(", ");
        }
        return stringBuilder.toString();
    }

    //push_front
    //Добавить (положить) в начало дека новый элемент
    //push_back
    //Добавить (положить) в конец дека новый элемент
    //pop_front
    //Извлечь из дека первый элемент
    //pop_back
    //Извлечь из дека последний элемент
    //front
    //Узнать значение первого элемента (не удаляя его)
    //back
    //Узнать значение последнего элемента (не удаляя его)
    //size
    //Узнать количество элементов в деке
    //clear
    //Очистить дек (удалить из него все элементы)


}
