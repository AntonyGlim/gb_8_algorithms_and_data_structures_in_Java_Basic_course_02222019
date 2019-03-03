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

    private void resize (int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(startElementIndex + i) % queue.length];
        }
        queue = temp;
        startElementIndex = 0;
        endElementIndex = size;
    }

    public void enqueue(Item item){
        if (size == queue.length){
            resize(2 * queue.length);
        }
        queue[endElementIndex++] = item;
        endElementIndex %= queue.length;
        size++;
    }

    public Item dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = (Item) queue[startElementIndex];
        size--;
        startElementIndex++;
        startElementIndex %= queue.length;
        if (size <= queue.length / 4 && size > 0){ //TODO
            resize( queue.length / 2);
        }
        return item;
    }

    public Item peak(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return (Item) queue[startElementIndex];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        //TODO
        return stringBuilder.toString();
    }
}
