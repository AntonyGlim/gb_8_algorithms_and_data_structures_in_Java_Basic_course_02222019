package lesson_2_Arrays_and_sorting;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<Item> {

    private Object[] list = new Object[1]; //нельзя создать обобщенный,т.к. присутсвует стирание типов
    private int size = 0; //изначально 0

    /**
     * Вернет размер листа
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * Вернет элемент
     * @param index
     * @return
     */
    public Item get(int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    /**
     * Устанавливаем элемент
     * @param index
     * @param item
     */
    public void set(int index, Item item){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        list[index] = item;
    }

    /**
     * Вставка элемента в список
     * @param item
     */
    public void add(Item item){
        if (size == list.length){
            resize(2 * list.length);
        }
        list[size] = item;
        size++;
    }

    /**
     * Найдет вхождение первого слева элемента
     * @param item
     * @return
     */
    public int indexOf(Item item){
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Содержиться элемент?
     * @param item
     * @return
     */
    public boolean contains(Item item){
        return indexOf(item) != -1;
    }

    /**
     * Изменение размера массива
     * @param capacity
     */
    public void resize(int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }

    /**
     * Удаление элемента
     * @param item
     * @return
     */
    public boolean remove (Item item){
        int index;
        for (index = 0; index < size && !list[index].equals(item); index++) {
        }

        if(index == size){
            return false;
        }

        //сдвинем все элементы влево на 1 элемент
        for (int j = index; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        list[size - 1] = null;
        size--;

        //меняем размеры массива если необходимо
        if (size == list.length / 4 && size > 0){
            resize(list.length / 2);
        }

        return true; //удаление завершено удачно
    }

    /**
     * Для удобства вавода на экран
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(list[i] + ", ");
        }
        return stringBuilder.toString();
    }

//
//    public Iterator<Item> iterator() {
//        return new MyListIterator();
//    }
//
//    private class MyListIterator implements Iterator<Item>{
//        int cursor = 0; //следующий элемент
//
//        public boolean hasNext() {
//            return cursor != size;
//        }
//
//        public Item next() {
//            if (!hasNext()){
//                throw new IndexOutOfBoundsException();
//            }
//            Item item = (Item) list[cursor];
//            cursor++;
//            return item;
//        }
//
//        public void remove() {
//
//        }
//
//        /**
//         * меняет элементы местами
//         */
//        private void exchange(int a, int b){
//            Object temp = list[a];
//            list[a] = list[b];
//            list[b] = temp;
//        }
//
//        private boolean less(Item item1, Item item2, Comparator<Item> cmp){
//            return cmp.compare(item1, item2) < 0; //
//        }
//
//        /**
//         * сортировка выбором
//         * @param cmp
//         */
//        public void selectionSort(Comparator<Item> cmp){
//            for (int i = 0; i < size - 1; i++) {
//                int min = i;
//                for (int j = 0; j < size; j++) {
//                    if (less())
//                }
//            }
//        }
//    }
}