package lesson_4_Linked_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item> {

    public Iterator<Item> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<Item>{

        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Вспомогательный класс
     * Реализует узел связанного списка
     */
    private class Node{
        Node previous; //ссылка на предыдущий
        Item item; //сам элемент
        Node next; //ссылка на следующий

        public Node( Node previous, Item item, Node next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    private Node first = null; //ссылка на 1 узел
    private Node last = null; //ссылка на последний узел
    private int size = 0;

    public int size(){
        return size;
    }

    /**
     * Список пуст?
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Извлечение элемента из начала списка
     * @return
     */
    public Item getFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
    }

    /**
     * Добавление элемента в начало списка
     * @param item
     */
    public void addFirst(Item item){
        Node oldFirst = first;
        first = new Node(null, item, oldFirst);
        if (isEmpty()) last = first; //определяем последний элемент
        else oldFirst.previous = first;
        size++;
    }

    /**
     * Удаление элемента из начала списка
     */
    public Item removeFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        Node second = first.next;
        Item item = first.item;
        first.item = null;
        first.next = null;
        first = second;
        size--;
        if (isEmpty()) last = null; //определяем последний элемент
        else second.previous = null;
        return item;
    }

    /**
     * Извлечение элемента из конца списка
     * @return
     */
    public Item getLast(){
        if (isEmpty()) throw new NoSuchElementException();
        return last.item;
    }

    /**
     * Добавление элемента в конeц списка
     * @param item
     */
    public void addLast(Item item){
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    /**
     * Удаление элемента из конца списка
     */
    public Item removeLast(){
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        Node previous = last.previous;
        last.previous = null;
        last.item = null;
        last = previous;
        size--;
        if (isEmpty()) first = null;
        else last.next = null;
        return item;
    }

    /**
     * Возврат элемента с определенным индексом
     * Для этого необходимо пройти по всем элементам до требуемого
     */
    public  Item get(int index){
        return findItemByIndex(index).item;
    }

    /**
     * Метод установит элемент на указанный индекс
     * @param index
     * @param item
     */
    public void set(int index, Item item){
        findItemByIndex(index).item = item;
    }

    /**
     * Метод найдет в массиве элемент по указанному индексу
     * @param index
     * @return
     */
    private Node findItemByIndex(int index){
        if(index < 0 || index > size - 1) throw  new IndexOutOfBoundsException();
        int currentIndex = 0;
        Node current = first;
        if (index < size / 2){
            while (currentIndex < index){
                current = current.next;
                currentIndex++;
            }
        } else {
            currentIndex = size - 1;
            current = last;
            while (currentIndex > index){
                current = current.previous;
                currentIndex--;
            }
        }
        return current;
    }

    /**
     * Номер элемента в списке
     */
    public  int indexOf(Item item){
        Node current = first;
        int currentIndex = 0;
        while (current != null && !current.item.equals(item)){ //список закончился
            current = current.next;
            currentIndex++;
        }
        return current != null ? currentIndex : -1;
    }


    public boolean contains (Item item){
        return indexOf(item) > -1;
    }

    /**
     * Удаление о-та с определенным индексом
     * @return
     */
    public Item remove(Item item){
        Node current = first;
        while (current != null && !current.item.equals(item)){ //список закончился
            current = current.next;
        }
        if (current == null) return null;
        if (current == first) return removeFirst();
        if (current == last) return removeLast();

        Node next = current.next;
        Node previous = current.previous;
        previous.next = next;
        next.previous = previous;
        size--;
        current.next = null;
        current.previous = null;
        return current.item;
    }

    /**
     * Добавление элемента по индексу
     */
    public void add (int index, Item item){ //addBefore
        if(index < 0 || index > size) throw  new IndexOutOfBoundsException(); //именно size а не size - 1
        if (index == 0){
            addFirst(item);
            return;
        }
        if (index == size){
            addLast(item);
            return;
        }

        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index){
            current = current.next;
            currentIndex++;
        }
        Node newNode = new Node(current.previous, item, current);
        Node previous = current.previous;
        previous.next = newNode;
        current.previous = newNode;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = first;
        while (current != null){
            stringBuilder.append(current.item.toString()).append(", ");
            current = current.next;
        }
        return stringBuilder.toString();
    }

}
