package lesson_4_Linked_list;

import java.util.NoSuchElementException;

public class MyLinkedList<Item> {

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
     * TODO добавить оптимизацию поиск с начала или с конца 00:57
     */
    public  Item get(int index){
        if(index < 0 || index > size - 1) throw  new IndexOutOfBoundsException();
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index){
            current = current.next;
            currentIndex++;
        }
        return current.item;
    }

    /**
     * Метод установит элемент на указанный индекс
     * TODO добавить оптимизацию поиск с начала или с конца 00:58
     * @param index
     * @param item
     */
    public void set(int index, Item item){
        if(index < 0 || index > size - 1) throw  new IndexOutOfBoundsException();
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index){
            current = current.next;
            currentIndex++;
        }
        current.item = item;
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

    public Item remove(int index){
        
    }

}
