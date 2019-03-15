package lesson_3_Stack_and_queue;

import java.util.NoSuchElementException;

public class MyArrayStack <Item> {

    private  Object[] stack = new Object[1];
    private int size = 0;

    /**
     * Размеры стэка
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * Стэк пуст?
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Изменение размеров стека
     * @param capasity
     */
    public void resize(int capasity){
        Object[] temp = new Object[capasity];
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    /**
     * Помещение элементов в стек
     * @param item
     */
    public  void push (Item item){
        if (size == stack.length){
            resize(2 * stack.length);
        }
        stack[size++] = item;
    }

    /**
     * Посмотреть что на верху стека
     * @return
     */
    public Item peek(){
        if (isEmpty()){
            throw new  NoSuchElementException();
        }
        //InstanceOf not needed
        return (Item) stack[size - 1];
    }

    /**
     * Извлечение элемента
     * @return
     */
    public Item pop(){
        if (isEmpty()){
            throw new  NoSuchElementException();
        }
        Item item = (Item) stack[size - 1];
        size--;
        if (size == stack.length / 4 && size > 0){
            resize (stack.length / 2);
        }
        return item;
    }

    /**
     * Вывод (для красоты)
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((Item) stack[i].toString());
            stringBuilder.append(", ");
        }

        return stringBuilder.toString();
    }
}
