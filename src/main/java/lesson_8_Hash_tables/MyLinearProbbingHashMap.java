package lesson_8_Hash_tables;

public class MyLinearProbbingHashMap<Key, Value> {
    private int M = 97;
    private int size = 0;
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];

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
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        for (int i = hash(key); keys[i] != null ; i = (i + 1) % M) {
            if (((Key)keys[i]).equals(key)){
                return (Value) values[i];
            }
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
        if (size == M - 1){
            throw new IndexOutOfBoundsException("Таблица переполнена!");
        }
        int i;
        for (i = hash(key); keys[i] != null ; i = (i + 1) % M) {
            if (((Key)keys[i]).equals(key)){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

}
