package lesson_2_Arrays_and_sorting;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<Item> implements Iterable<Item>{

    // --- work-with-list-block ---
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
        if (size == list.length){ resize(2 * list.length); }
        list[size] = item;
        size++;
    }

    /**
     * Найдет вхождение первого слева элемента
     * Реализует линейный поиск O(n)
     * @param item
     * @return
     */
    public int indexOf(Item item){
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)){ return i; }
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
     * Для удобства вывода на экран
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


    // --- work-with-iterator-block ---
    public Iterator<Item> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<Item>{
        int cursor = 0; //указатель на следующий элемент

        /**
         * Есть еще элементы?
         * @return
         */
        public boolean hasNext() {
            return cursor != size;
        }

        /**
         * Получим следующий элемент
         * @return
         */
        public Item next() {
            if (!hasNext()){
                throw new IndexOutOfBoundsException();
            }
            Item item = (Item) list[cursor];
            cursor++;
            return item;
        }
    }


    // --- work-with-sorting-block ---
    /**
     * Меняет 2 элемента массива местами по индексам
     */
    private void exchangeElementsByIndex(int index1, int index2){
        Object temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    /**
     * Определяет меньше-ли один О-кт другого
     * @param item1
     * @param item2
     * @param comparator
     * @return true if item1 < item2
     */
    private boolean less(Item item1, Item item2, Comparator<Item> comparator){
        return comparator.compare(item1, item2) < 0;
    }

    /**
     * Сортировка выбором O(n*n)
     * @param comparator
     */
    public void selectionSort(Comparator<Item> comparator){
        for (int i = 0; i < size - 1; i++) { //т.к. аоследний на своем месте
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less( (Item) list[j], (Item) list[min], comparator)){
                    min = j;
                }
            }
            exchangeElementsByIndex(i, min);
        }
    }

    /**
     * Сортировка вставками O(n*n)
     * Для Частично упорядоченного массива O(n)
     * Часто применяется на практике
     * @param comparator
     */
    public void insortionSort(Comparator<Item> comparator){
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item) list[j], (Item) list[j - 1], comparator)){
                    exchangeElementsByIndex(j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Бинарный поиск O(log n)
     * @param item
     * @param comparator
     * @return
     */
    public boolean binarySearch(Item item, Comparator<Item> comparator){
        int low = 0;
        int high = size - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (comparator.compare(item, (Item) list[mid]) < 0){
                high = mid - 1;
            }
            if (comparator.compare(item, (Item) list[mid]) > 0){
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Скрытый метод с реализацией рекурсии
     * Мы должны управлять границами.
     * А пользователю не нужна информация о границах
     * Поэтому метода 2. Один для пользователя, второй служебный
     * TODO - почему ошибка
     */
    private boolean binarySearchRec(Item item, int low, int high, Comparator<Item> comp){
        if (low > high) return false;
        int mid = low + (high - low) / 2;
        if (comp.compare(item, (Item) list[mid]) == 0) return true;
        if (comp.compare(item, (Item) list[mid]) < 0) return binarySearchRec(item, low, mid - 1, comp);
        if (comp.compare(item, (Item) list[mid]) > 0) return binarySearchRec(item, mid + 1, high, comp);
        return false;
    }

    public boolean binarySearchRec(Item item, Comparator<Item> comp){
        return binarySearchRec(item, 0, size - 1, comp);
    }
}