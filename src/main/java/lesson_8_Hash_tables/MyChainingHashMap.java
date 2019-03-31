package lesson_8_Hash_tables;

public class MyChainingHashMap<Key, Value> {
    private final int M = 97;
    private int size = 0;
    private Object[] st = new Object[M];

    private class Node{
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Ф-ыя найдет нужный нам хэш
     */
    public int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M; //убираем минус и отсекаем последнюю единицу
    }

    public Value get(Key key){
        if (key == null){
            throw new IllegalArgumentException("");
        }
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null){
            if (key.equals((x.key))){
                return x.value;
            }
            x = x.next;
        }
        return null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public void put(Key key, Value value){
        if (key == null){
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null){ //возникла коллизия
            if (key.equals((x.key))){ //если ключ уже присутствует в массиве
                x.value = value;
                return;
            }
            x = x.next;
        }
        st[i] = new Node(key, value, (Node) st[i]); //1:25
        size++;
    }

    //TODO Метод remove
    //TODO Метод resize
}
