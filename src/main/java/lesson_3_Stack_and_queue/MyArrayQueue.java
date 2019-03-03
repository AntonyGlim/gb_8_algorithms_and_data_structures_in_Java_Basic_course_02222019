package lesson_3_Stack_and_queue;

import java.util.NoSuchElementException;

public class MyArrayQueue <Item> {
    private Object[] queue = new Object[1];
    private int size = 0;

    private int startElementIndex = 0;
    private int endElementIndex = 0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Меняет размеры массива
     * Зацикливает элементы в массиве. (элементы двигаются по кольцу)
     * Дойдя до конца, элементы начнут писаться в начало, если там пусто
     * В новый массив элементы "разворачиваются"
     * @param capacity
     */
    private void resize (int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(startElementIndex + i) % queue.length];
        }
        queue = temp;
        startElementIndex = 0;
        endElementIndex = size;
    }

    /**
     * Метод добавления элементов
     * @param item
     */
    public void enqueue(Item item){
        if (size == queue.length){
            resize(2 * queue.length);
        }
        queue[endElementIndex++] = item;
        endElementIndex %= queue.length;
        size++;
    }

    /**
     * Метод извлечения элементов из очереди
     * @return
     */
    public Item dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = (Item) queue[startElementIndex];
        size--;
        startElementIndex++;
        startElementIndex %= queue.length;
        if (size == queue.length / 4 && size > 0){
            resize( queue.length / 2);
        }
        return item;
    }

    /**
     * Метод просмотра элементов
     * @return
     */
    public Item peak(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return (Item) queue[startElementIndex];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(((Item) queue[(startElementIndex + i) % queue.length]).toString());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}
