import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object[] list = new Object[1];
    private int size;

    public int size(){
        return size;
    }

    public Item get(int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public void set(int index, Item item){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        list[index] = item;
    }

    public void add(Item item){
        if (size == list.length){
            resize(2 * list.length);
        }
        list[size] = item;
        size++;
    }

    public int indexOf(Item item){
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)){
                //TODO!!!
            }
        }
    }

    public boolean contains(Item item){
        return indexOf(item) != -1;
    }

    public void resize(int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }



    public boolean contains(Item item){
        return indexOf(item) != ;
    }

    public boolean remove (Item item){
        for (int i = 0; i < size && !list[i].equals(item); i++) {

        }

        if(i == size){
            return false;
        }

        //1 2 3 4 5
        //1 2 4 5 null
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        list[size - 1] = null;
        size--;

        if (size == list.length / 4 && size > 0){
            resize(list.length / 2);
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(list[i]);
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    public Iterator<Item> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<Item>{
        int cursor = 0; //следующий элемент

        public boolean hasNext() {
            return cursor != size;
        }

        public Item next() {
            if (!hasNext()){
                throw new IndexOutOfBoundsException();
            }
            Item item = (Item) list[cursor];
            cursor++;
            return item;
        }

        public void remove() {

        }

        /**
         * меняет элементы местами
         */
        private void exchange(int a, int b){
            Object temp = list[a];
            list[a] = list[b];
            list[b] = temp;
        }

        private boolean less(Item item1, Item item2, Comparator<Item> cmp){
            return cmp.compare(item1, item2) < 0; //
        }

        /**
         * сортировка выбором
         * @param cmp
         */
        public void selectionSort(Comparator<Item> cmp){
            for (int i = 0; i < size - 1; i++) {
                int min = i;
                for (int j = 0; j < size; j++) {
                    if (less())
                }
            }
        }
    }
}